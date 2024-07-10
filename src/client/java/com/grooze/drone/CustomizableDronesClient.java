package com.grooze.drone;

import com.grooze.drone.render.DroneModel;
import com.grooze.drone.render.DroneRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

import static com.grooze.drone.entity.EntityLoader.DRONE;
import static com.grooze.drone.render.DroneRenderer.DRONE_LAYER;

public class CustomizableDronesClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		EntityRendererRegistry.register(DRONE, DroneRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(DRONE_LAYER, DroneModel::getTexturedModelData);
	}
}