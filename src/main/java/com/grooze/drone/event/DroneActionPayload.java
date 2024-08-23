package com.grooze.drone.event;

import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.util.Identifier;

import static com.grooze.drone.CustomizableDrones.MOD_ID;


public record DroneActionPayload(int entityId, int action) implements CustomPayload {
    // Identificatore univoco per questo payload
    public static final CustomPayload.Id<DroneActionPayload> ID = new CustomPayload.Id<>(Identifier.of(MOD_ID, "entity_action"));

    // Codec per serializzare e deserializzare il payload

    //Client disconnected with reason: Internal Exception: io.netty.handler.codec.EncoderException:
    //Failed to encode packet 'serverbound/minecraft:custom_payload' (customizable-drones:entity_action)
    public static final PacketCodec<RegistryByteBuf, DroneActionPayload> CODEC = PacketCodec.tuple(
            PacketCodecs.INTEGER,  // Codec per action
            DroneActionPayload::entityId,
            PacketCodecs.INTEGER,  // Codec per action
            DroneActionPayload::action,
            DroneActionPayload::new
            );

    @Override
    public CustomPayload.Id<? extends CustomPayload> getId() {
        return ID;
    }
}
