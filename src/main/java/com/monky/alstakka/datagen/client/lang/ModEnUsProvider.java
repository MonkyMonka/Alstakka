package com.monky.alstakka.datagen.client.lang;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.entity.ModEntityTypes;
import com.monky.alstakka.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class ModEnUsProvider extends LanguageProvider {

    public ModEnUsProvider(PackOutput gen) {
        super(gen, Alstakka.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Items
        add(ModItems.ALSTAKKA_SPAWN_EGG.get(), "Alstakka Spawn Egg");
        add(ModItems.DUPE_SPAWN_EGG.get(), "Dupe Spawn Egg");
        add(ModItems.DIP_ITEM.get(), "Dupe");
        add(ModItems.TOKEN_ITEM.get(), "Respawn Token");
        // Mobs
        add(ModEntityTypes.ALSTAKKA.get(), "Alstakka");
        add(ModEntityTypes.DUPE.get(), "Dupe");
        add(ModEntityTypes.DIP.get(), "Dip");

    }

}