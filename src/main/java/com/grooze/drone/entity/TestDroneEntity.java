package com.grooze.drone.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MovementType;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static com.grooze.drone.entity.DroneEntity.TARGET_Y;
import static com.grooze.drone.util.DebugLog.print;
import com.grooze.drone.util.MyMathHelper;

public class TestDroneEntity extends Entity {


    public TestDroneEntity(EntityType<?> type, World world) {
        super(type, world);
        noClip = false;
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {

    }

    @Override
    protected void readCustomDataFromNbt(NbtCompound nbt) {

    }

    @Override
    protected void writeCustomDataToNbt(NbtCompound nbt) {

    }

    @Override
    public void tick() {
        super.tick();

        World world = this.getWorld();
        boolean isClient = world.isClient;
        String txtIsClient = isClient?"":"[Server]";
        Box bb = this.getBoundingBox();

        List<Entity> inbox = world.getOtherEntities(this,bb);



        //System.out.println(inbox);
        //print(0, inbox.toString());
        //print(1, String.valueOf(noClip));


            //print(2, "Get player passenger: "+this.getFirstPassenger());

            if (this.getFirstPassenger() instanceof PlayerEntity player){
                Vec3d playerVelocity = player.getVelocity();
                float playerYaw = player.getHeadYaw();
                //this.setYaw(playerYaw);
                double pvx = playerVelocity.x;
                double pvy = playerVelocity.y;
                double pvz = playerVelocity.z;
                double normalizedPlayerYaw = MyMathHelper.normalizeCSPlayerHeadYawDegrees(playerYaw);

                double output = 100 * pvx * Math.cos(normalizedPlayerYaw) ;//+ pvz * Math.sin(normalizedPlayerYaw);

                this.setYaw((float) (this.getYaw() + output));

                Vec3d droneVelocity = new Vec3d(0,0,0);


                //this.setVelocity(playerVelocity);




                print(4, "Get player movement: "+playerVelocity);
                print(5, txtIsClient+"Get player yaw: "+normalizedPlayerYaw);

            }
            //print(3, "Get player passenger: "+this.getFirstPassenger());



        this.move(MovementType.SELF,this.getVelocity());

    }

    @Override
    public ActionResult interact(PlayerEntity player, Hand hand) {
        System.out.println("Va");
        ActionResult actionResult = super.interact(player, hand);
        if (actionResult != ActionResult.PASS) {
            return actionResult;
        } else if (player.shouldCancelInteraction()) {
            return ActionResult.PASS;
        } else if (0F < 60.0F) {
            if (!this.getWorld().isClient) {

                return player.startRiding(this) ? ActionResult.CONSUME : ActionResult.PASS;
            } else {
                return ActionResult.SUCCESS;
            }
        } else {
            return ActionResult.PASS;
        }
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        System.out.println("Va2");
        return super.interactAt(player, hitPos, hand);
    }

    public boolean isCollidable() {
        return true;
    }

    public boolean canHit() {
        return !this.isRemoved();
    }

    protected boolean canAddPassenger(Entity passenger) {
        return this.getPassengerList().size() < this.getMaxPassengers() && !this.isSubmergedIn(FluidTags.WATER);
    }

    protected int getMaxPassengers() {
        return 1;
    }

    @Nullable
    public LivingEntity getControllingPassenger() {
        Entity firstPassenger = this.getFirstPassenger();
        LivingEntity controllingPassenger;
        if (firstPassenger instanceof LivingEntity livingEntity) {
            controllingPassenger = livingEntity;
        } else {
            controllingPassenger = super.getControllingPassenger();
        }

        return controllingPassenger;
    }


    //should be on a interface or abstract class
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
