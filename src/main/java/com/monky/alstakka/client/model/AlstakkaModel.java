package com.monky.alstakka.client.model;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.client.render.entity.AlstakkaRenderer;
import com.monky.alstakka.entity.custom.AlstakkaEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class AlstakkaModel extends GeoModel<AlstakkaEntity> {
    @Override
    public ResourceLocation getModelResource(AlstakkaEntity object) {
        return new ResourceLocation(Alstakka.MOD_ID, "geo/alstakka.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(AlstakkaEntity object) {
        return AlstakkaRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationResource(AlstakkaEntity animatable) {
        return new ResourceLocation(Alstakka.MOD_ID, "animations/alstakka.animation.json");
    }

    @Override
    public void setCustomAnimations(AlstakkaEntity animatable, long instanceId, software.bernie.geckolib.core.animation.AnimationState<AlstakkaEntity> animationState) {
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        EntityModelData data = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        if (head != null) {
            head.setRotX(data.headPitch() * ((float) Math.PI / 180F));
            head.setRotY(data.netHeadYaw() * ((float) Math.PI / 180F));
        }
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
