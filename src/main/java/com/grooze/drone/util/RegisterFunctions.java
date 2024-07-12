package com.grooze.drone.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.grooze.drone.CustomizableDrones.MOD_ID;

public class RegisterFunctions {
    public static Identifier id(String id){
        return Identifier.of(MOD_ID, id);
    }

    public static <E extends Entity> EntityType<E> registerEntity(String name, EntityType.Builder<E> entity_builder){
        return Registry.register(Registries.ENTITY_TYPE,id(name), entity_builder.build());
    }
}
