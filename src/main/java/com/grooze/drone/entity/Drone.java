package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.world.World;


public class Drone extends AbstractDrone {
    public Drone(EntityType<? extends AbstractDrone> entityType, World world) {
        super(entityType, world);
    }

}
