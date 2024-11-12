package com.grooze.drone.event;

import com.grooze.drone.entity.TestDroneEntity;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;

public class ClientNetwork {

    public static void init(){
        ClientPlayNetworking.registerGlobalReceiver(DroneSyncS2C.ID,  ClientNetwork::onSyncDrone);

    }

    private static void onSyncDrone(DroneSyncS2C droneSyncS2C, ClientPlayNetworking.Context context) {
        context.client().execute(()->{
            Entity entity = context.player().getWorld().getEntityById(droneSyncS2C.entityId());
            if (entity instanceof TestDroneEntity testDroneEntity){
                testDroneEntity.setYaw(droneSyncS2C.yaw());
                Vec3d pos = droneSyncS2C.pos();
                testDroneEntity.setPos(pos.getX(),pos.getY(),pos.getZ());
                double halfWidth = testDroneEntity.getWidth() / 2.0;
                double halfHeight = testDroneEntity.getHeight() / 2.0;


                testDroneEntity.setBoundingBox(
                        new Box(
                                pos.x - halfWidth,
                                pos.y ,
                                pos.z - halfWidth,
                                pos.x + halfWidth,
                                pos.y + 2 * halfHeight,
                                pos.z + halfWidth
                        )
                );

            }

        });

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

    public static void sendDroneKeysPacket(int entityId, boolean forward, boolean back, boolean left, boolean right, boolean up, boolean down){
        ClientPlayNetworking.send(new DroneKeysC2SPayload(entityId, forward,  back,  left,  right, up));
    }
}
