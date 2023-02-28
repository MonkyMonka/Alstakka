package com.monky.alstakka.datagen;

import com.monky.alstakka.block.ModBlocks;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BOTTLE_RACK_BLOCK.get())
                .define('B', ItemTags.WOODEN_SLABS)
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .unlockedBy("has_" + ItemTags.WOODEN_SLABS.location(), inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemTags.WOODEN_SLABS).build()))
                .save(consumer);
    }
}