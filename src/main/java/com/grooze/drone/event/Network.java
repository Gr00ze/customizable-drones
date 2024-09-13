package com.grooze.drone.event;

import com.grooze.drone.entity.DroneEntity;
import com.grooze.drone.entity.TestDroneEntity;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;


public class Network {
    public static void init(){
        PayloadTypeRegistry.playC2S().register(DroneActionPayload.ID, DroneActionPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(DroneActionPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                //System.out.printf("Dati arrivati: id %d  A %d\n", payload.entityId(), payload.action());
                Entity entity = context.player().getServerWorld().getEntityById(payload.entityId());

                // TO DO server check

                if (entity instanceof DroneEntity droneEntity){
                    droneEntity.move(payload.action());
                }

                if (entity instanceof TestDroneEntity droneEntity){
                    droneEntity.move(payload.action());
                }
            });
        });
    }
}
