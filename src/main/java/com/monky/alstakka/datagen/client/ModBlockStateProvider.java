package com.monky.alstakka.datagen.client;

import com.monky.alstakka.Alstakka;
import com.monky.alstakka.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Alstakka.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BOTTLE_RACK_BLOCK);

        axisBlock((RotatedPillarBlock) ModBlocks.OPALIZED_BONE_BLOCK.get(), new ResourceLocation(Alstakka.MOD_ID, "block/opalized_bone_block_side"),
                new ResourceLocation(Alstakka.MOD_ID, "block/opalized_bone_block_top"));

        simpleBlockItem(ModBlocks.OPALIZED_BONE_BLOCK.get(), models().withExistingParent("alstakka:opalized_bone_block", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}