package com.monky.alstakka.client.render.entity;

import com.google.common.collect.Maps;
import com.monky.alstakka.Alstakka;
import com.monky.alstakka.client.model.DipModel;
import com.monky.alstakka.entity.custom.DipEntity;
import com.monky.alstakka.entity.variant.DipVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class DipRenderer extends MobRenderer<DipEntity, DipModel> {
    public static final Map<DipVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DipVariant.class), (p_114874_) -> {
                p_114874_.put(DipVariant.ONE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_1.png"));
                p_114874_.put(DipVariant.TWO,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_2.png"));
                p_114874_.put(DipVariant.THREE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_3.png"));
                p_114874_.put(DipVariant.FOUR,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_4.png"));
                p_114874_.put(DipVariant.FIVE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_5.png"));
                p_114874_.put(DipVariant.SIX,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_6.png"));
                p_114874_.put(DipVariant.SEVEN,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_7.png"));
                p_114874_.put(DipVariant.EIGHT,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_8.png"));
            });

    public DipRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DipModel(ctx.bakeLayer(DipModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DipEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}