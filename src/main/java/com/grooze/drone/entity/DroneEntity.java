package com.grooze.drone.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class DroneEntity extends BoatEntity implements Movable{
    public boolean on = false;
    float sleepY;
    public static final TrackedData<Float> TARGET_Y = DataTracker.registerData(DroneEntity.class, TrackedDataHandlerRegistry.FLOAT);

    public DroneEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);

    }
    //Registrazione dati sincronizzati
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(TARGET_Y, 0F);
    }


    //Inizializzazione dati sincronizzati
    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        dataTracker.set(TARGET_Y, (float) this.getBlockY());
        //desiredY = (float) this.getBlockY();
        on = false;
    }

    //Salva la Y di atterraggio
    @Override
    public void onLanding() {
        //On landing mean when is inland and not when is about to land
        super.onLanding();
        this.sleepY = this.getBlockY();
        if (!hasPlayerRider()) {
            this.on = false;
        }


    }



    @Override
    public void tick() {
        //System.out.println("SIDE Client: "+ this.getWorld().isClient + " ON: "+ on);
        super.tick();
        boolean hasPlayerRider = hasPlayerRider();
        //could be a goal maybe?
        if (on){
            this.tryToReachTargetY();
            //Bloccare il movimento se  aterra
            BlockPos bs = this.getBlockPos();
            bs = bs.add(0,-1,0);
            if(this.getWorld().getBlockState(bs) != Blocks.AIR.getDefaultState()){

            }
        }else{

            if (hasPlayerRider){
                on = true;
                dataTracker.set(TARGET_Y, (float) this.getBlockY());
            }
        }



        //trying to ingore boat logic about speed
        this.updateVelocity();

    }



    //Serve per ottenere l' altezza desideratà con l' effetto di rinculo
    public void tryToReachTargetY(){
        //System.out.println(this.getWorld().isClient +" "+this.getId()+" "+desiredY);

        Float dY = dataTracker.get(TARGET_Y);
        if (dY == null){
            dataTracker.set(TARGET_Y, (float) this.getBlockY());
        }else
        if (dY != this.getBlockY()){
            Vec3d pos = getPos();
            //this.setPosition(pos.x, dY, pos.z);
            this.addVelocity(0, (dY - pos.y) * 0.05,0);
        }
    }

    //Serve per cercare di ignorare la logica di velocità della barca
    public void updateVelocity() {
        Vec3d velocity = this.getVelocity();
        this.setVelocity(velocity.multiply(1.1,1,1.1));
        //System.out.println(velocity);




    }



    //vecchio metodo di aggiornamento dell' altezza
    @Deprecated
    public void gainStartHeight(){
        if (this.hasPlayerRider() && this.getBlockY() < this.sleepY + 2){
            Vec3d pos = this.getPos();
            this.setPosition(pos.x,this.sleepY + 2,pos.z);
        }
    }

    //vecchio metodo di aggiornamento velocita Y in base alla rotazione della testa
    @Deprecated
    public void addYVelocityOnPlayerHeadRotation(){
        if (this.hasPlayerRider() && this.getControllingPassenger() instanceof PlayerEntity player){
            double playerPitch = Math.toRadians(player.getPitch());
            double acceleration = getGravity() - 0.08 * Math.sin(playerPitch);
            //max = Math.max(playerPitch, max);
            //min = Math.min(playerPitch, min);
            //System.out.println(max +" " +min);
            Vec3d velocity = this.getVelocity();
            if (Math.abs(velocity.x) > 0.1 || Math.abs(velocity.z) > 0.1){
                this.addVelocity(0, acceleration,0);
            }
            else{
                this.setVelocity(velocity.x, getGravity(),velocity.z);
            }
        }
    }


    //funzione Server side per aggiornare la variabile Target dopo un evento lato client
    public void move(int action) {
        //System.out.printf("Moving %d \n", this.getBlockY());
        //System.out.println(this.getWorld().isClient +" "+this.getId()+" "+ TARGET_Y);
        float dy = dataTracker.get(TARGET_Y);
        if (action == 1){
            dataTracker.set(TARGET_Y, ++dy);
        }else if(action == 0 && !this.isOnGround()){
            dataTracker.set(TARGET_Y, --dy);
        }
    }



}
