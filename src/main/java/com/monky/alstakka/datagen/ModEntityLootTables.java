package com.monky.alstakka.datagen;

import com.monky.alstakka.entity.ModEntityTypes;
import net.minecraft.data.loot.EntityLootSubProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraftforge.registries.RegistryObject;

import javax.swing.text.html.parser.Entity;


public class ModEntityLootTables extends EntityLootSubProvider {
    public ModEntityLootTables() {
        super( FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    public void generate() {


    }

    @Override
    protected Iterable<EntityType<?>> getKnownEntities() {
        return ModEntityTypes.ENTITY_TYPES.getEntries().stream().map(RegistryObject::get)::iterator;
    }

}
