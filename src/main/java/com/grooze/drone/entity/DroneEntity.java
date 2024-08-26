package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class DroneEntity extends AbstractDroneEntity {
    float sleepY;
    //float desiredY;

    public static final TrackedData<Float> TARGET_Y = DataTracker.registerData(DroneEntity.class, TrackedDataHandlerRegistry.FLOAT);


    public DroneEntity(EntityType<? extends AbstractDroneEntity> entityType, World world) {
        super(entityType, world);

    }

    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(TARGET_Y, 0F);
    }

    @Override
    public void onSpawnPacket(EntitySpawnS2CPacket packet) {
        super.onSpawnPacket(packet);
        dataTracker.set(TARGET_Y, (float) this.getBlockY());
        //desiredY = (float) this.getBlockY();
    }

    @Override
    public void tick() {
        super.tick();
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



    @Override
    public void onLanding() {
        super.onLanding();
        this.sleepY = this.getBlockY();

    }

    @Deprecated
    public void gainStartHeight(){
        if (this.hasPlayerRider() && this.getBlockY() < this.sleepY + 2){
            Vec3d pos = this.getPos();
            this.setPosition(pos.x,this.sleepY + 2,pos.z);
        }
    }
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

    public void move(int action) {
        //System.out.printf("Moving %d \n", this.getBlockY());
        //System.out.println(this.getWorld().isClient +" "+this.getId()+" "+ TARGET_Y);
        float dy = dataTracker.get(TARGET_Y);
        if (action == 1){
            dataTracker.set(TARGET_Y, ++dy);
        }else if(action == 0){
            dataTracker.set(TARGET_Y, --dy);
        }
    }
}
