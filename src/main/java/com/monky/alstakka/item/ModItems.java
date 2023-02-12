package com.monky.alstakka.item;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.entity.ModEntityTypes;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Alstakka.MOD_ID);

    public static final RegistryObject<Item> ALSTAKKA_SPAWN_EGG = ITEMS.register("alstakka_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.ALSTAKKA, 0xefcfa4, 0xbd9d73,
                    new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
