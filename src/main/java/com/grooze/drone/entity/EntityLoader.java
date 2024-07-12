package com.grooze.drone.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.SkeletonEntity;


import static com.grooze.drone.util.RegisterFunctions.registerEntity;

public class EntityLoader {

    public static final EntityType<DroneEntity> DRONE = registerEntity("drone",
            EntityType.Builder.create(DroneEntity::new, SpawnGroup.MISC)
                    .dimensions(3f,1f));
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
