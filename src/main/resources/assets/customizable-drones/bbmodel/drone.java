import net.minecraft.util.math.RotationAxis;

import static net.minecraft.util.math.MathConstants.PI;

// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class drone extends EntityModel<Drone> {
	private final ModelPart root;
	private final ModelPart cabin;
	private final ModelPart sterzo;
	private final ModelPart arm;
	private final ModelPart propeller;
	private final ModelPart arm2;
	private final ModelPart propeller2;
	private final ModelPart arm3;
	private final ModelPart propeller3;
	private final ModelPart arm4;
	private final ModelPart propeller4;
	public drone(ModelPart root) {
		this.root = root.getChild("root");
		this.cabin = root.getChild("cabin");
		this.sterzo = root.getChild("sterzo");
		this.arm = root.getChild("arm");
		this.propeller = root.getChild("propeller");
		this.arm2 = root.getChild("arm2");
		this.propeller2 = root.getChild("propeller2");
		this.arm3 = root.getChild("arm3");
		this.propeller3 = root.getChild("propeller3");
		this.arm4 = root.getChild("arm4");
		this.propeller4 = root.getChild("propeller4");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData root = modelPartData.addChild("root", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cabin = root.addChild("cabin", ModelPartBuilder.create().uv(0, 0).cuboid(-8.0F, -2.0F, -8.0F, 16.0F, 1.0F, 16.0F, new Dilation(0.0F))
		.uv(48, 0).cuboid(-14.0F, -2.0F, -6.0F, 6.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(28, 44).cuboid(8.0F, -2.0F, -6.0F, 6.0F, 1.0F, 12.0F, new Dilation(0.0F))
		.uv(0, 43).cuboid(-3.0F, -4.0F, -5.0F, 9.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r1 = cabin.addChild("cube_r1", ModelPartBuilder.create().uv(0, 30).cuboid(0.0F, 0.0F, -5.0F, 13.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.of(6.0F, -4.0F, 0.0F, 0.0F, 0.0F, -1.0908F));

		ModelPartData cube_r2 = cabin.addChild("cube_r2", ModelPartBuilder.create().uv(59, 66).cuboid(-9.0F, 0.0F, -3.0F, 8.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -1.0F, -7.0F, 1.5708F, 0.0F, 1.5708F));

		ModelPartData cube_r3 = cabin.addChild("cube_r3", ModelPartBuilder.create().uv(72, 0).cuboid(-9.0F, 0.0F, -3.0F, 8.0F, 1.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(10.0F, -1.0F, 6.0F, 1.5708F, 0.0F, 1.5708F));

		ModelPartData cube_r4 = cabin.addChild("cube_r4", ModelPartBuilder.create().uv(52, 44).cuboid(-9.0F, 0.0F, -6.0F, 8.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -1.0F, 6.0F, 1.5708F, 0.0F, 1.5708F));

		ModelPartData cube_r5 = cabin.addChild("cube_r5", ModelPartBuilder.create().uv(54, 55).cuboid(-9.0F, 0.0F, -6.0F, 8.0F, 1.0F, 10.0F, new Dilation(0.0F)), ModelTransform.of(-8.0F, -1.0F, -7.0F, 1.5708F, 0.0F, 1.5708F));

		ModelPartData cube_r6 = cabin.addChild("cube_r6", ModelPartBuilder.create().uv(36, 31).cuboid(-8.0F, 0.0F, -6.0F, 8.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-14.0F, -9.0F, 0.0F, 0.0F, 0.0F, 2.8798F));

		ModelPartData cube_r7 = cabin.addChild("cube_r7", ModelPartBuilder.create().uv(38, 18).cuboid(-7.0F, -1.0F, -6.0F, 7.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-15.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData cube_r8 = cabin.addChild("cube_r8", ModelPartBuilder.create().uv(0, 17).cuboid(-13.0F, -1.0F, -6.0F, 13.0F, 1.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(14.0F, -2.0F, 0.0F, 0.0F, 0.0F, 1.5708F));

		ModelPartData sterzo = cabin.addChild("sterzo", ModelPartBuilder.create().uv(0, 0).cuboid(-0.5F, -1.0F, -2.5F, 1.0F, 2.0F, 5.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-0.5F, -2.0F, -3.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 0).cuboid(-0.5F, -2.0F, 2.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(-4.5F, -9.0F, 0.5F, 0.0F, 0.0F, -0.3054F));

		ModelPartData arm = root.addChild("arm", ModelPartBuilder.create(), ModelTransform.pivot(-14.0156F, -1.5F, 14.3085F));

		ModelPartData motor_r1 = arm.addChild("motor_r1", ModelPartBuilder.create().uv(79, 22).cuboid(-19.0F, -5.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(8.0156F, 1.5F, -7.3085F, 0.0F, 0.7854F, 0.0F));

		ModelPartData arm_r1 = arm.addChild("arm_r1", ModelPartBuilder.create().uv(0, 57).cuboid(-17.0F, -1.0F, -2.0F, 18.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(10.0156F, 1.5F, -9.3085F, 0.0F, 0.7854F, 0.0F));

		ModelPartData propeller = arm.addChild("propeller", ModelPartBuilder.create().uv(44, 66).cuboid(-18.0F, -7.0F, -7.0F, 1.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(14.0156F, 1.5F, 4.6915F));

		ModelPartData arm2 = root.addChild("arm2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData motor_r2 = arm2.addChild("motor_r2", ModelPartBuilder.create().uv(23, 75).cuboid(-19.0F, -5.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, 0.0F, 6.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData arm_r2 = arm2.addChild("arm_r2", ModelPartBuilder.create().uv(64, 18).cuboid(-23.364F, -1.0F, -1.2929F, 18.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 2.3562F, 0.0F));

		ModelPartData propeller2 = arm2.addChild("propeller2", ModelPartBuilder.create().uv(0, 65).cuboid(-0.5F, -1.0F, -6.5F, 1.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(18.5F, -6.0F, 18.5F));

		ModelPartData arm3 = root.addChild("arm3", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData motor_r3 = arm3.addChild("motor_r3", ModelPartBuilder.create().uv(78, 37).cuboid(-19.0F, -5.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(30.0F, 0.0F, -30.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData arm_r3 = arm3.addChild("arm_r3", ModelPartBuilder.create().uv(0, 61).cuboid(-23.364F, -1.0F, -1.2929F, 18.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -2.3562F, 0.0F));

		ModelPartData propeller3 = arm3.addChild("propeller3", ModelPartBuilder.create().uv(64, 22).cuboid(-37.5F, -1.0F, -4.5F, 1.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(18.5F, -6.0F, -19.5F));

		ModelPartData arm4 = root.addChild("arm4", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData motor_r4 = arm4.addChild("motor_r4", ModelPartBuilder.create().uv(72, 74).cuboid(-19.0F, -5.0F, -3.0F, 5.0F, 5.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-6.0F, 0.0F, -29.0F, 0.0F, 0.7854F, 0.0F));

		ModelPartData arm_r4 = arm4.addChild("arm_r4", ModelPartBuilder.create().uv(61, 14).cuboid(-23.364F, -1.0F, -1.2929F, 18.0F, 1.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.7854F, 0.0F));

		ModelPartData propeller4 = arm4.addChild("propeller4", ModelPartBuilder.create().uv(29, 57).cuboid(-0.5F, -1.0F, -6.5F, 1.0F, 2.0F, 13.0F, new Dilation(0.0F)), ModelTransform.pivot(18.5F, -6.0F, -19.5F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(Drone entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {

		root.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}