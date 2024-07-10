package com.grooze.drone.entity;

import com.grooze.drone.util.RegisterFunctions;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.SkeletonEntity;


import static com.grooze.drone.util.RegisterFunctions.registerEntity;

public class EntityLoader {

    public static final EntityType<Drone> DRONE = registerEntity("drone", EntityType.Builder.create(Drone::new, SpawnGroup.MISC).dimensions(0.5f,0.5f));
    public static void init(){
        SkeletonEntity.createAbstractSkeletonAttributes();
        /*
        FabricDefaultAttributeRegistry.register(DRONE, Drone.createLivingAttributes()
                        .add(EntityAttributes.GENERIC_MAX_HEALTH,20)
                        .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,2)
                .build());
         */
    };
}
