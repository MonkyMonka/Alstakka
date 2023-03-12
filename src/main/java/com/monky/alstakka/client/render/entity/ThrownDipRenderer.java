package com.monky.alstakka.client.render.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.monky.alstakka.entity.custom.ThrownDipEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;

import static com.mojang.math.Axis.YP;

public class ThrownDipRenderer extends ThrownItemRenderer<ThrownDipEntity> {

    private final ItemRenderer itemRenderer;

    public ThrownDipRenderer(EntityRendererProvider.Context context) {
        super(context, 0.0F, true);
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ThrownDipEntity entity, float yaw, float partialTicks, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (entity.tickCount >= 2 || !(this.entityRenderDispatcher.camera.getEntity().distanceToSqr(entity) < 12.25D)) {
            poseStack.pushPose();
            poseStack.scale(3.0F, 3.0F, 3.0F);
            poseStack.mulPose(YP.rotationDegrees((entity.tickCount + partialTicks) * 20));
            this.itemRenderer.renderStatic(entity.getItem(), ItemTransforms.TransformType.GROUND, packedLight, OverlayTexture.NO_OVERLAY, poseStack, bufferSource, entity.getId());
            poseStack.popPose();
        }
    }
}