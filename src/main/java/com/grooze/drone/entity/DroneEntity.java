package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class DroneEntity extends AbstractDroneEntity {

    private float sleepY;
    public DroneEntity(EntityType<? extends AbstractDroneEntity> entityType, World world) {
        super(entityType, world);

    }


    @Override
    public void tick() {
        super.tick();
        if (this.hasPlayerRider() && this.getBlockY() < this.sleepY + 2){
            Vec3d pos = this.getPos();
            this.setPosition(pos.x,this.sleepY + 2,pos.z);


        }


    }


    @Override
    public void onLanding() {
        super.onLanding();
        this.sleepY = this.getBlockY();
    }
}
