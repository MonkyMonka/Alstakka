package com.monky.alstakka.datagen;

import com.monky.alstakka.block.ModBlocks;
import com.monky.alstakka.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
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
                .pattern("WWW")
                .pattern("WWW")
                .pattern("WWW")
                .unlockedBy("has_" + ItemTags.WOODEN_SLABS.location(), inventoryTrigger(ItemPredicate.Builder.item()
                        .of(ItemTags.WOODEN_SLABS).build()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TOKEN_ITEM.get())
                .define('C', Items.CHAIN.asItem())
                .pattern("C")
                .pattern("C")
                .unlockedBy("has_" + Items.CHAIN.getDescriptionId(), inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Items.CHAIN.asItem()).build()))
                .save(consumer);
    }
}