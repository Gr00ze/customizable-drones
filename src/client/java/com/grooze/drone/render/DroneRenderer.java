package com.grooze.drone.render;

import com.grooze.drone.entity.Drone;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static com.grooze.drone.util.RegisterFunctions.id;
public class DroneRenderer extends EntityRenderer<Drone> {
    private static final Identifier TEXTURE = id("textures/entity/drone/drone.png");
    public static final EntityModelLayer DRONE_LAYER = new EntityModelLayer(id("drone"),"main");
    private final DroneModel model;
    public DroneRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new DroneModel(ctx.getPart(DRONE_LAYER));
    }

    @Override
    public Identifier getTexture(Drone entity) {
        return TEXTURE;
    }

    @Override
    public void render(Drone entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityAlpha(TEXTURE)), 1, 1, 1);

    }
}
