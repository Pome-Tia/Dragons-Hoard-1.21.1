package net.pometia.dragonshoard.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.pometia.dragonshoard.block.ModBlocks;
import net.pometia.dragonshoard.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SILVER_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.SILVER_INGOT.get());
 //               .unlockedBy("has_silver_block", has(ModItems.SILVER_INGOT.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WHITE_GOLD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.WHITE_GOLD_INGOT.get());
       //         .unlockedBy("has_white_gold_block", has(ModItems.WHITE_GOLD_INGOT.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLUE_GOLD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.BLUE_GOLD_INGOT.get());
        //        .unlockedBy("has_blue_gold_block", has(ModItems.BLUE_GOLD_INGOT.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ROSE_GOLD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.ROSE_GOLD_INGOT.get());
       //         .unlockedBy("has_rose_gold_block", has(ModItems.ROSE_GOLD_INGOT.get())).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STAR_BLUE_GOLD_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ModItems.STAR_BLUE_GOLD_INGOT.get());
       //         .unlockedBy("has_star_blue_gold_block", has(ModItems.STAR_BLUE_GOLD_INGOT.get())).save(recipeOutput);

    }
}
