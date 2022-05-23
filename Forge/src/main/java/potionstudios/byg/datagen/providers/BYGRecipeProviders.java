package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.util.function.Consumer;

public class BYGRecipeProviders extends RecipeProvider {
    public BYGRecipeProviders(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            ShapedRecipeBuilder.shaped(type.door().get(), 3)
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/door"));
            ShapedRecipeBuilder.shaped(type.boat().get())
                .pattern("P P")
                .pattern("PPP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/boat"));
            ShapedRecipeBuilder.shaped(type.bookshelf().get())
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', type.planks().get())
                .define('B', Items.BOOK)
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/bookshelf"));
            ShapelessRecipeBuilder.shapeless(type.button().get())
                .requires(type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/button"));
            ShapedRecipeBuilder.shaped(type.craftingTable())
                    .pattern("PP")
                    .pattern("PP")
                    .define('P', type.planks().get())
                    .unlockedBy("has_planks", has(type.planks()))
                    .save(consumer, BYG.createLocation("wood/" + type + "/crafting_table"));
        }
    }
}
