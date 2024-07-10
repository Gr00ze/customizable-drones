package com.grooze.drone.render;

import com.grooze.drone.entity.Drone;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Position;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static com.grooze.drone.util.RegisterFunctions.id;
import static net.minecraft.util.math.MathConstants.PI;

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
        //matrices.multiply(RotationAxis.POSITIVE_X.rotation(PI));
        //matrices.multiply((RotationAxis.POSITIVE_Y.rotation(-entity.getYaw()*PI/180)));
        //matrices.translate(0f,-1.5f,0f);
        model.animateModel(entity,0,0,tickDelta);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityAlpha(TEXTURE)), light, 1, 1);

    }
}
