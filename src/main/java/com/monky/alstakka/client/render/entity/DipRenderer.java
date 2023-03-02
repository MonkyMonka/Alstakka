package com.monky.alstakka.client.render.entity;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.client.model.DipModel;
import com.monky.alstakka.entity.custom.DipEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class DipRenderer extends MobRenderer<DipEntity, DipModel> {
    private static final ResourceLocation TEXTURE = new ResourceLocation(Alstakka.MOD_ID, "textures/entity/dip_1.png");

    public DipRenderer(EntityRendererProvider.Context ctx) {
        super(ctx, new DipModel(ctx.bakeLayer(DipModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(DipEntity instance) {
        return TEXTURE;
    }
}