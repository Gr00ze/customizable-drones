package com.grooze.drone.event;

import com.grooze.drone.entity.DroneEntity;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.Entity;

import static com.grooze.drone.event.KeyBinds.droneDown;
import static com.grooze.drone.event.KeyBinds.droneUP;

public class ClientEvents {
    public static void registerEvents(){
        // Aggiungiamo un evento che viene chiamato alla fine di ogni tick del client

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ClientPlayerEntity player = client.player;

            // Verifico di essere in game e non che ci siano conflitti di tasti
            if (player == null || droneUP.wasPressed() == droneDown.wasPressed()) {
                return;
            }
            int vehicleId;
            Entity vehicle = client.player.getControllingVehicle();
            //ottengo l' id che ci serve se è un drone
            if (vehicle instanceof DroneEntity droneEntity){
                vehicleId = droneEntity.getId();
            }else{
                return;
            }

            if(droneUP.wasPressed()){
                System.out.println("UP");
                ClientNetwork.sendUpPacket(vehicleId);
            } else if (droneDown.wasPressed()) {
                System.out.println("DOWN");
                ClientNetwork.sendDownPacket(vehicleId);
            }
        });

    }
}