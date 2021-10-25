package corgiaoc.byg.common.entity.manowar;


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class ManOWarModel<T extends ManOWar> extends EntityModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "custom_model"), "main");
	private final ModelPart cap;
	private final ModelPart tentacleOuter;
	private final ModelPart tentacleInner;

	public ManOWarModel(ModelPart root) {
		this.cap = root.getChild("cap");
		this.tentacleOuter = root.getChild("tentacleOuter");
		this.tentacleInner = root.getChild("tentacleInner");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition cap = partdefinition.addOrReplaceChild("cap", CubeListBuilder.create().texOffs(0, 30).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(20, 12).addBox(-2.0F, -11.0F, -2.0F, 4.0F, 6.0F, 12.0F, new CubeDeformation(0.0F))
				.texOffs(0, 31).addBox(0.0F, -13.0F, -4.0F, 0.0F, 5.0F, 15.0F, new CubeDeformation(0.0F))
				.texOffs(34, 50).addBox(4.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F))
				.texOffs(34, 50).mirror().addBox(-5.0F, -5.0F, -2.0F, 1.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition frillFront = cap.addOrReplaceChild("frillFront", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, -3.5F));

		PartDefinition cube_r1 = frillFront.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(39, 50).addBox(-4.0F, 0.0F, -3.0F, 8.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.7854F, 0.0F, 0.0F));

		PartDefinition frillBack = cap.addOrReplaceChild("frillBack", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 3.5F));

		PartDefinition cube_r2 = frillBack.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(39, 53).addBox(-4.0F, 0.0F, 0.0F, 8.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.7854F, 0.0F, 0.0F));

		PartDefinition frillRight = cap.addOrReplaceChild("frillRight", CubeListBuilder.create(), PartPose.offset(-3.5F, 0.0F, 0.0F));

		PartDefinition cube_r3 = frillRight.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(40, 42).mirror().addBox(-3.0F, 0.0F, -4.0F, 3.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7854F));

		PartDefinition frillLeft = cap.addOrReplaceChild("frillLeft", CubeListBuilder.create(), PartPose.offset(3.5F, 0.0F, 0.0F));

		PartDefinition cube_r4 = frillLeft.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(40, 42).addBox(0.0F, 0.0F, -4.0F, 3.0F, 0.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7854F));

		PartDefinition tentacleOuter = partdefinition.addOrReplaceChild("tentacleOuter", CubeListBuilder.create().texOffs(0, 1).addBox(-3.5F, 0.0F, -3.5F, 7.0F, 16.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		PartDefinition tentacleInner = partdefinition.addOrReplaceChild("tentacleInner", CubeListBuilder.create().texOffs(32, 30).addBox(-2.0F, 0.0F, -2.0F, 4.0F, 16.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}
	@Override
	public void renderToBuffer(PoseStack matrixStack, VertexConsumer	buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){

		cap.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacleOuter.render(matrixStack, buffer, packedLight, packedOverlay);
		tentacleInner.render(matrixStack, buffer, packedLight, packedOverlay);
	}
	public void setRotationAngle(ModelPart bone, float x, float y, float z) {
		bone.xRot = x;
		bone.yRot = y;
		bone.zRot = z;
	}

}