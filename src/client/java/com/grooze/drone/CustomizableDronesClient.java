package com.grooze.drone;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.AllayEntityRenderer;
import net.minecraft.client.render.entity.EntityRenderer;

import static com.grooze.drone.entity.EntityLoader.DRONE;

public class CustomizableDronesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(DRONE, AllayEntityRenderer::new);
	}
}