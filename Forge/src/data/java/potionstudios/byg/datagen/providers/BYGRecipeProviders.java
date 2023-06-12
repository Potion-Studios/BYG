package potionstudios.byg.datagen.providers;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.common.BYGTags;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.util.function.Consumer;

public class BYGRecipeProviders extends RecipeProvider {
    public BYGRecipeProviders(DataGenerator pGenerator) {
        super(pGenerator.getPackOutput());
    }

    @Override
    protected void buildRecipes(@NotNull Consumer<FinishedRecipe> consumer) {
        final var sticksTag = BYGTags.STICKS.all(BYGTags.RegistryType.ITEMS);

        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            String prefix = "";
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, type.door().get(), 3)
                .group("wooden_door")
                .pattern("PP")
                .pattern("PP")
                .pattern("PP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_door"));
            if (type.boat() != null) {
                ShapedRecipeBuilder.shaped(RecipeCategory.TRANSPORTATION, type.boat().get())
                        .group("boat")
                        .pattern("P P")
                        .pattern("PPP")
                        .define('P', type.planks().get())
                        .unlockedBy("has_planks", has(type.planks()))
                        .save(consumer, BYG.createLocation(prefix + type + "_boat"));

                ShapelessRecipeBuilder.shapeless(RecipeCategory.TRANSPORTATION, type.chestBoat().get())
                        .requires(Blocks.CHEST)
                        .requires(type.boat().get())
                        .group("chest_boat")
                        .unlockedBy("has_boat", has(ItemTags.BOATS))
                        .save(consumer, BYG.createLocation(prefix + type + "_chest_boat"));
            }
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, type.bookshelf().get())
                .group("bookshelf")
                .pattern("PPP")
                .pattern("BBB")
                .pattern("PPP")
                .define('P', type.planks().get())
                .define('B', Items.BOOK)
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_bookshelf"));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, type.button().get())
                .group("wooden_button")
                .requires(type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_button"));
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, type.craftingTable())
                .group("crafting_table")
                .pattern("PP")
                .pattern("PP")
                .define('P', type.planks().get())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_crafting_table"));
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, type.fence(), 3)
                .group("wooden_fence")
                .pattern("W#W")
                .pattern("W#W")
                .define('#', sticksTag)
                .define('W', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_fence"));
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, type.fenceGate())
                .group("wooden_fence_gate")
                .pattern("#W#")
                .pattern("#W#")
                .unlockedBy("has_planks", has(type.planks()))
                .define('#', sticksTag)
                .define('W', type.planks())
                .save(consumer, BYG.createLocation(prefix + type + "_fence_gate"));
            ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, type.planks(), 4)
                .group("wooden_planks")
                .unlockedBy("has_logs", has(type.logTag().item()))
                .requires(type.logTag().item())
                .save(consumer, BYG.createLocation(prefix + type + "_planks"));
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, type.pressurePlate())
                .group("wooden_pressure_plate")
                .pattern("PP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_pressure_plate"));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, type.slab(), 6)
                .group("wooden_slab")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_slab"));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, type.stairs(), 4)
                .group("wooden_stairs")
                .pattern("P  ")
                .pattern("PP ")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_stairs"));
            ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, type.trapdoor(), 2)
                .group("wooden_trapdoor")
                .pattern("PPP")
                .pattern("PPP")
                .define('P', type.planks())
                .unlockedBy("has_planks", has(type.planks()))
                .save(consumer, BYG.createLocation(prefix + type + "_trapdoor"));
            ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, type.wood(), 3)
                .group("wood")
                .pattern("LL")
                .pattern("LL")
                .define('L', type.log())
                .unlockedBy("has_log", has(type.log()))
                .save(consumer, BYG.createLocation(prefix + type + "_wood"));
            if (type.sign() != null) {
                ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, type.sign(), 3)
                    .group("sign")
                    .pattern("PPP")
                    .pattern("PPP")
                    .pattern(" S ")
                    .define('P', type.planks())
                    .define('S', sticksTag)
                    .unlockedBy("has_planks", has(type.planks()))
                    .save(consumer, BYG.createLocation(prefix + type + "_sign"));
            }
        }
    }

}
