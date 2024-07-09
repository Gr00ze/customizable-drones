package com.grooze.drone.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.passive.AllayEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Arm;
import net.minecraft.world.World;

public class Drone extends AllayEntity {


    public Drone(EntityType<? extends AllayEntity> entityType, World world) {
        super(entityType, world);
    }
}
