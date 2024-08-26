package com.grooze.drone.event;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.client.MinecraftClient;

public class ClientNetwork {

    void init(){

    }
    public static void sendDownPacket(int id) {
        //da modificare
        //System.out.println("Dati mandati");
        ClientPlayNetworking.send(new DroneActionPayload(id,0));
    }
    public static void sendUpPacket(int id) {
        //da modificare
        //System.out.println("Dati mandati");
        ClientPlayNetworking.send(new DroneActionPayload(id,1));
    }
}
