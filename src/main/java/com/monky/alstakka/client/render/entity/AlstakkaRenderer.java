package com.monky.alstakka.client.render.entity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.monky.alstakka.Alstakka;
import com.monky.alstakka.client.model.AlstakkaModel;
import com.monky.alstakka.entity.custom.AlstakkaEntity;
import com.monky.alstakka.entity.variant.AlstakkaVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.cache.object.BakedGeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.Map;

public class AlstakkaRenderer extends GeoEntityRenderer<AlstakkaEntity> {
    public static final Map<AlstakkaVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(AlstakkaVariant.class), (p_114874_) -> {
                p_114874_.put(AlstakkaVariant.BLACK,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/alstakka_black.png"));
                p_114874_.put(AlstakkaVariant.BROWN,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/alstakka_brown.png"));
                p_114874_.put(AlstakkaVariant.CREAMY,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/alstakka_creamy.png"));
                p_114874_.put(AlstakkaVariant.WHITE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/alstakka_white.png"));
            });

    public AlstakkaRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new AlstakkaModel());
        this.shadowRadius = 0.7f;
    }

    @Override
    public ResourceLocation getTextureLocation(AlstakkaEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public void preRender(PoseStack poseStack, AlstakkaEntity animatable, BakedGeoModel model, MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender, float partialTick, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        if (animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.preRender(poseStack, animatable, model, bufferSource, buffer, isReRender, partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}

