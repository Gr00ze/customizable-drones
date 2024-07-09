package com.grooze.drone.entity;

import com.grooze.drone.util.RegisterFunctions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;

import static com.grooze.drone.util.RegisterFunctions.registerEntity;

public class EntityLoader {

    public static final EntityType<Drone> DRONE = registerEntity("drone", EntityType.Builder.create(Drone::new, SpawnGroup.MISC));
    public static void init(){
        FabricDefaultAttributeRegistry.register(DRONE,Drone.createAllayAttributes());
    };
}
