package com.monky.alstakka.entity;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.entity.custom.AlstakkaEntity;
import com.monky.alstakka.entity.custom.DipEntity;
import com.monky.alstakka.entity.custom.DupeEntity;
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
    public static final RegistryObject<EntityType<DupeEntity>> DUPE =
            ENTITY_TYPES.register("dupe",
                    () -> EntityType.Builder.of(DupeEntity::new, MobCategory.CREATURE)
                            .sized(1.8f, 5.5f)
                            .build(new ResourceLocation(Alstakka.MOD_ID, "dupe").toString()));
    public static final RegistryObject<EntityType<DipEntity>> DIP =
            ENTITY_TYPES.register("dip",
                    () -> EntityType.Builder.of(DipEntity::new, MobCategory.CREATURE)
                            .sized(1.8f, 5.5f)
                            .build(new ResourceLocation(Alstakka.MOD_ID, "dip").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
