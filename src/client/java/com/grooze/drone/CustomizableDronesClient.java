package com.grooze.drone;

import com.grooze.drone.event.ClientEvents;
import com.grooze.drone.event.KeyBinds;
import com.grooze.drone.render.DroneEntityModel;
import com.grooze.drone.render.DroneEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import static com.grooze.drone.entity.EntityLoader.DRONE;
import static com.grooze.drone.render.DroneEntityRenderer.DRONE_LAYER;

public class CustomizableDronesClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(DRONE, DroneEntityRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(DRONE_LAYER, DroneEntityModel::getTexturedModelData);
		KeyBinds.init();
		ClientEvents.registerEvents();



	}

}