package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.world.World;
/**
* Intermediary class
 * **/
public abstract class AbstractDroneEntity extends BoatEntity {

    AbstractDroneEntity(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

}
