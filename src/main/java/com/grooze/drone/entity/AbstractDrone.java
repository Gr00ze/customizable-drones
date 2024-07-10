package com.grooze.drone.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.entity.vehicle.VehicleEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.world.World;
/**
* Intermediary class
 * **/
public abstract class AbstractDrone extends BoatEntity {

    AbstractDrone(EntityType<? extends BoatEntity> entityType, World world) {
        super(entityType, world);
    }

}
