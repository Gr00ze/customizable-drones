package com.grooze.drone.event;

import com.grooze.drone.entity.TestDroneEntity;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.listener.PacketListener;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.network.packet.Packet;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;

import static com.grooze.drone.CustomizableDrones.MOD_ID;

public record DroneSyncS2C(int entityId, float yaw, Vec3d pos) implements CustomPayload{
    public static final Id<DroneSyncS2C> ID = new Id<>(Identifier.of(MOD_ID, "drone_sync_payload"));

    public static final PacketCodec<RegistryByteBuf, DroneSyncS2C> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER,
            DroneSyncS2C::entityId,
            PacketCodecs.FLOAT,
            DroneSyncS2C::yaw,
            MyCodecs.VEC3D,
            DroneSyncS2C::pos,
            DroneSyncS2C::new
    );

    public static DroneSyncS2C droneSyncS2C(TestDroneEntity entity){
        entity.getPos();
        return  new DroneSyncS2C(entity.getId(), entity.getYaw(), entity.getPos());
    }

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
