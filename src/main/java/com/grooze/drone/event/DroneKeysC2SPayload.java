package com.grooze.drone.event;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static com.grooze.drone.CustomizableDrones.MOD_ID;

public record DroneKeysC2SPayload(int entityId,
                                  boolean forward,
                                  boolean back,
                                  boolean left,
                                  boolean right,
                                  boolean up) implements CustomPayload {
    public static final Id<DroneKeysC2SPayload> ID = new Id<>(Identifier.of(MOD_ID, "drone_keys_payload"));

    public static final PacketCodec<RegistryByteBuf, DroneKeysC2SPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER,  // Codec per action
            DroneKeysC2SPayload::entityId,
            PacketCodecs.BOOL,  // Codec per action
            DroneKeysC2SPayload::forward,
            PacketCodecs.BOOL,  // Codec per action
            DroneKeysC2SPayload::back,
            PacketCodecs.BOOL,  // Codec per action
            DroneKeysC2SPayload::left,
            PacketCodecs.BOOL,  // Codec per action
            DroneKeysC2SPayload::right,
            PacketCodecs.BOOL,  // Codec per action
            DroneKeysC2SPayload::up,

            DroneKeysC2SPayload::new
    );

    @Override
    public Id<? extends CustomPayload> getId() {
        return ID;
    }
}
