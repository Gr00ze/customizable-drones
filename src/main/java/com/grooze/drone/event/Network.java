package com.grooze.drone.event;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;


public class Network {
    public static void init(){
        PayloadTypeRegistry.playC2S().register(DroneActionPayload.ID, DroneActionPayload.CODEC);

        ServerPlayNetworking.registerGlobalReceiver(DroneActionPayload.ID, (payload, context) -> {
            context.server().execute(() -> {
                System.out.printf("Dati arrivati: id %d  A %d\n", payload.entityId(), payload.action());

            });
        });
    }
}
