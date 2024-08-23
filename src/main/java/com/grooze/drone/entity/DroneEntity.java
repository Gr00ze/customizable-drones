package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class DroneEntity extends AbstractDroneEntity {
    float sleepY;
    public DroneEntity(EntityType<? extends AbstractDroneEntity> entityType, World world) {
        super(entityType, world);

    }


    @Override
    public void tick() {
        super.tick();






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
}
