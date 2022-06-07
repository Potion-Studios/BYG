package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.common.item.BYGItemTags;

import java.util.function.Consumer;

public class BYGRecipeProviders extends RecipeProvider {
    public BYGRecipeProviders(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            ShapedRecipeBuilder.shaped(type.door().get(), 3)
                .group("wooden_door")
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/door"));
            if (type.boat() != null) {
                ShapedRecipeBuilder.shaped(type.boat().get())
                        .group("boat")
                        .pattern("P P")
                        .pattern("PPP")
                        .define('P', type.planks().get())
                        .unlockedBy("has_planks", has(type.planks()))
                        .save(consumer, BYG.createLocation("wood/" + type + "/boat"));
            }
            ShapedRecipeBuilder.shaped(type.bookshelf().get())
                .group("bookshelf")
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', type.planks().get())
                .define('B', Items.BOOK)
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/bookshelf"));
            ShapelessRecipeBuilder.shapeless(type.button().get())
                .group("wooden_button")
                .requires(type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/button"));
            ShapedRecipeBuilder.shaped(type.craftingTable())
                .group("crafting_table")
                .pattern("PP")
                .pattern("PP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/crafting_table"));
            ShapedRecipeBuilder.shaped(type.fence(), 3)
                .group("wooden_fence")
                .pattern("W#W")
                .pattern("W#W")
                .define('#', BYGItemTags.STICKS)
                .define('W', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/fence"));
            ShapedRecipeBuilder.shaped(type.fenceGate())
                .group("wooden_fence_gate")
                .pattern("#W#")
                .pattern("#W#")
                .unlockedBy("has_planks", has(type.planks()))
                .define('#', BYGItemTags.STICKS)
                .define('W', type.planks())
                .save(consumer, BYG.createLocation("wood/" + type + "/fence_gate"));
            ShapelessRecipeBuilder.shapeless(type.planks(), 4)
                .group("wooden_planks")
                .unlockedBy("has_logs", has(type.logTag().item()))
                .requires(type.logTag().item())
                .save(consumer, BYG.createLocation("wood/" + type + "/planks"));
            ShapedRecipeBuilder.shaped(type.pressurePlate())
                .group("wooden_pressure_plate")
                .pattern("PP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/pressure_plate"));
            ShapedRecipeBuilder.shaped(type.slab(), 6)
                .group("wooden_slab")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/slab"));
            ShapedRecipeBuilder.shaped(type.slab(), 4)
                .group("wooden_stairs")
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/stairs"));
            ShapedRecipeBuilder.shaped(type.trapdoor(), 2)
                .group("wooden_trapdoor")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation("wood/" + type + "/trapdoor"));
            ShapedRecipeBuilder.shaped(type.wood(), 3)
                .group("wood")
                .pattern("LL")
                .pattern("LL")
                .define('L', type.log())
                .unlockedBy("has_log", has(type.log()))
                .save(consumer, BYG.createLocation("wood/" + type + "/wood"));
            if (type.sign() != null) {
                ShapedRecipeBuilder.shaped(type.sign(), 3)
                    .group("sign")
                    .pattern("PPP")
                    .pattern("PPP")
                    .pattern(" S ")
                    .define('P', type.planks())
                    .define('S', BYGItemTags.STICKS)
                    .unlockedBy("has_planks", has(type.planks()))
                    .save(consumer, BYG.createLocation("wood/" + type + "/sign"));
            }
        }
    }

}
