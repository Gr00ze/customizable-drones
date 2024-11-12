package com.grooze.drone;

import com.grooze.drone.event.ClientEvents;
import com.grooze.drone.event.ClientNetwork;
import com.grooze.drone.event.KeyBinds;
import com.grooze.drone.render.DebugHud;
import com.grooze.drone.render.DroneEntityModel;
import com.grooze.drone.render.DroneEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import com.grooze.drone.render.TestDroneEntityRenderer;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;

import static com.grooze.drone.entity.EntityLoader.DRONE;
import static com.grooze.drone.entity.EntityLoader.TEST_DRONE;
import static com.grooze.drone.render.DroneEntityRenderer.DRONE_LAYER;

public class CustomizableDronesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(DRONE, DroneEntityRenderer::new);
		EntityRendererRegistry.register(TEST_DRONE, TestDroneEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(DRONE_LAYER, DroneEntityModel::getTexturedModelData);
		KeyBinds.init();
		ClientEvents.registerEvents();
		ClientNetwork.init();
		DebugHud.init();



	}

}