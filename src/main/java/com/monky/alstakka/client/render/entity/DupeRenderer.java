package com.monky.alstakka.client.render.entity;

import com.google.common.collect.Maps;
import com.monky.alstakka.Alstakka;
import com.monky.alstakka.client.model.DupeModel;
import com.monky.alstakka.entity.custom.DupeEntity;
import com.monky.alstakka.entity.variant.DupeVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class DupeRenderer extends MobRenderer<DupeEntity, DupeModel> {
    public static final Map<DupeVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(DupeVariant.class), (p_114874_) -> {
                p_114874_.put(DupeVariant.ONE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_1.png"));
                p_114874_.put(DupeVariant.TWO,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_2.png"));
                p_114874_.put(DupeVariant.THREE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_3.png"));
                p_114874_.put(DupeVariant.FOUR,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_4.png"));
                p_114874_.put(DupeVariant.FIVE,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_5.png"));
                p_114874_.put(DupeVariant.SIX,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_6.png"));
                p_114874_.put(DupeVariant.SEVEN,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_7.png"));
                p_114874_.put(DupeVariant.EIGHT,
                        new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dupe_8.png"));
            });

    public DupeRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DupeModel(ctx.bakeLayer(DupeModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DupeEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }
}