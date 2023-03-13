package com.monky.alstakka.datagen.client;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.block.ModBlocks;
import com.monky.alstakka.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Alstakka.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        eggItem(ModItems.ALSTAKKA_SPAWN_EGG);
        eggItem(ModItems.DUPE_SPAWN_EGG);
        simpleItem(ModItems.TOKEN_ITEM);
        simpleItem(ModItems.DIP_ITEM);
    }

    private ItemModelBuilder eggItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("minecraft:item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Alstakka.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Alstakka.MOD_ID,"item/" + item.getId().getPath()));
    }
}