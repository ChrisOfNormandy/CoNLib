package com.github.chrisofnormandy.conlib.mobs.types;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.AgeableListModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.util.Mth;

public class CustomAnimalModel<T extends CustomAnimal> extends AgeableListModel<T> {

    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightArm;
    private final ModelPart leftArm;

    public CustomAnimalModel(ModelPart root) {
        super(true, 10.0F, 4.0F);
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.rightArm = root.getChild("right_arm");
        this.leftArm = root.getChild("left_arm");
    }

    @Override
    protected Iterable<ModelPart> headParts() {
        return java.util.Collections.singleton(this.head);
    }

    @Override
    protected Iterable<ModelPart> bodyParts() {
        return java.util.Arrays.asList(this.body, this.rightLeg, this.leftLeg, this.rightArm, this.leftArm);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
            float headPitch) {
        this.head.yRot = netHeadYaw * ((float) Math.PI / 180F);
        this.head.xRot = headPitch * ((float) Math.PI / 180F);
        this.rightLeg.xRot = Mth.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.leftLeg.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount;
        this.rightArm.xRot = Mth.cos(limbSwing * 0.6662F + (float) Math.PI) * 2.0F * limbSwingAmount * 0.5F;
        this.leftArm.xRot = Mth.cos(limbSwing * 0.6662F) * 2.0F * limbSwingAmount * 0.5F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
            float red, float green, float blue, float alpha) {
        this.head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftLeg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.rightArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
        this.leftArm.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
