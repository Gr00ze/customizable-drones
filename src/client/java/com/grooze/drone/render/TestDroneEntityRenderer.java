package com.grooze.drone.render;

import com.grooze.drone.entity.DroneEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;

import static com.grooze.drone.util.RegisterFunctions.id;

public class TestDroneEntityRenderer extends EntityRenderer<Entity> {
    private static final Identifier TEXTURE = id("textures/entity/drone/drone.png");
    public static final EntityModelLayer DRONE_LAYER = new EntityModelLayer(id("drone"),"main");
    private final DroneEntityModel model;
    public TestDroneEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new DroneEntityModel(ctx.getPart(DRONE_LAYER));
    }

    @Override
    public Identifier getTexture(Entity entity) {
        return TEXTURE;
    }

    @Override


    public void render(Entity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {

        matrices.push();
        //matrices.multiply(RotationAxis.POSITIVE_X.rotation(PI));
        //matrices.multiply((RotationAxis.POSITIVE_Y.rotation(-entity.getYaw()*PI/180)));
        //matrices.translate(0f,-1.5f,0f);

//        model.setAngles(entity,0,0,0,0,0);
//        model.animateModel(entity,0,0,tickDelta);
        model.render(matrices, vertexConsumers.getBuffer(RenderLayer.getEntityAlpha(TEXTURE)), light, 0, 0);
        matrices.pop();
        super.render(entity, yaw, tickDelta, matrices, vertexConsumers, light);
    }
}
