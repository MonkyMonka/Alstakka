package com.monky.alstakka.entity;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.entity.custom.AlstakkaEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Alstakka.MOD_ID);

    public static final RegistryObject<EntityType<AlstakkaEntity>> ALSTAKKA =
            ENTITY_TYPES.register("alstakka",
                    () -> EntityType.Builder.of(AlstakkaEntity::new, MobCategory.CREATURE)
                            .sized(1.8f, 5.5f)
                            .build(new ResourceLocation(Alstakka.MOD_ID, "alstakka").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
