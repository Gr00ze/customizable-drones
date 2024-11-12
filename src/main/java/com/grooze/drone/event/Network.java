package com.grooze.drone.event;

import com.grooze.drone.entity.DroneEntity;
import com.grooze.drone.entity.Movable;
import com.grooze.drone.entity.TestDroneEntity;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;


public class Network {
    public static void init(){
        registerPayloads();
        registerReceivers();


    }



    private static void registerPayloads() {
        PayloadTypeRegistry.playC2S().register(DroneActionPayload.ID, DroneActionPayload.CODEC);
        PayloadTypeRegistry.playC2S().register(DroneKeysC2SPayload.ID, DroneKeysC2SPayload.CODEC);
        PayloadTypeRegistry.playS2C().register(DroneSyncS2C.ID, DroneSyncS2C.CODEC);
    }


    private static void registerReceivers() {
        ServerPlayNetworking.registerGlobalReceiver(DroneActionPayload.ID, Network::onDroneActionPayloadReceived);
        ServerPlayNetworking.registerGlobalReceiver(DroneKeysC2SPayload.ID,  Network::onDroneKeysPayloadReceived);
        }


    private static void onDroneActionPayloadReceived(DroneActionPayload payload, ServerPlayNetworking.Context context){
        context.server().execute(() -> {
            //System.out.printf("Dati arrivati: id %d  A %d\n", payload.entityId(), payload.action());
            Entity entity = context.player().getServerWorld().getEntityById(payload.entityId());

            // TO DO server check

            if (entity instanceof Movable droneEntity){
                droneEntity.move(payload.action());
            }

        });
    }

    private static void onDroneKeysPayloadReceived(DroneKeysC2SPayload payload, ServerPlayNetworking.Context context){
        MinecraftServer server = context.server();
        server.execute(() -> {
            Entity entity = context.player().getServerWorld().getEntityById(payload.entityId());
            if (entity instanceof TestDroneEntity droneEntity){
                //TODO implementare della logica di sicurezza
                //System.out.println(payload.left() +" "+  payload.right());
                droneEntity.forward = payload.forward();
                droneEntity.back = payload.back();
                droneEntity.right = payload.right();
                droneEntity.left = payload.left();
                droneEntity.up = payload.up();


            }
        });
    }
}
