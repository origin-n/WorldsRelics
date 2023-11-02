package com.origin.worldsrelics.datagen;

import com.origin.worldsrelics.WorldsRelics;
import com.origin.worldsrelics.block.ModBlocks;
import com.origin.worldsrelics.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final List<ItemLike> PRIMAL_ROCK = List.of(ModItems.PRIMAL_ROCK.get());
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreBlasting(pWriter, PRIMAL_ROCK, RecipeCategory.MISC, ModItems.CRACKED_PRIMAL_ROCK.get(), 0.25f, 100, "primal_rock");
        oreSmelting(pWriter, PRIMAL_ROCK, RecipeCategory.MISC, ModItems.CRACKED_PRIMAL_ROCK.get(), 0.25f, 200, "primal_rock");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.PRIMAL_STONE.get())
                .pattern("SS")
                .pattern("SS")
                .define('S', ModItems.PRIMAL_ROCK.get())
                .unlockedBy(getHasName(ModItems.PRIMAL_ROCK.get()), has(ModItems.PRIMAL_ROCK.get()))
                .save(pWriter);

//        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.PRIMAL_STONE_BRICKS.get())
//                .requires(ModBlocks.PRIMAL_STONE.get())
//                .unlockedBy(getHasName(ModBlocks.PRIMAL_STONE.get()), has(ModBlocks.PRIMAL_STONE.get()))
//                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, WorldsRelics.MODID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
