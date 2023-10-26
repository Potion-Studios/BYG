package potionstudios.byg.common.block;

import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import javax.annotation.Nullable;

import net.minecraft.Util;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;

@SuppressWarnings("unused")
public class BYGBlockFamily {
    private final Block baseBlock;
    final Map<Variant, Block> variants = Maps.newHashMap();
    FeatureFlagSet requiredFeatures;
    boolean generateModel;
    boolean generateRecipe;
    @Nullable
    String recipeGroupPrefix;
    @Nullable
    String recipeUnlockedBy;

    public BYGBlockFamily(Block block) {
        this.requiredFeatures = FeatureFlags.VANILLA_SET;
        this.generateModel = true;
        this.generateRecipe = true;
        this.baseBlock = block;
    }

    public Block getBaseBlock() {
        return this.baseBlock;
    }

    public Map<Variant, Block> getVariants() {
        return this.variants;
    }

    public Block get(Variant variant) {
        return this.variants.get(variant);
    }

    public boolean shouldGenerateModel() {
        return this.generateModel;
    }

    public boolean shouldGenerateRecipe(FeatureFlagSet featureFlagSet) {
        return this.generateRecipe && this.requiredFeatures.isSubsetOf(featureFlagSet);
    }

    public Optional<String> getRecipeGroupPrefix() {
        return Util.isBlank(this.recipeGroupPrefix) ? Optional.empty() : Optional.of(this.recipeGroupPrefix);
    }

    public Optional<String> getRecipeUnlockedBy() {
        return Util.isBlank(this.recipeUnlockedBy) ? Optional.empty() : Optional.of(this.recipeUnlockedBy);
    }

    public static class Builder {
        private final BYGBlockFamily family;
        private final String baseName;
        private final BlockSetType blockSetType;

        public Builder(Block block, String baseName, BlockSetType blockSetType) {
            this.family = new BYGBlockFamily(block);
            this.baseName = baseName;
            this.blockSetType = blockSetType;
        }

        public BYGBlockFamily getFamily() {
            return this.family;
        }

        public Builder button() {
            this.family.variants.put(BYGBlockFamily.Variant.BUTTON,
                    BYGBlocks.createWoodButton(baseName + "_button", blockSetType).get());
            return this;
        }

        public Builder chiseled(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.CHISELED,
                    BYGBlocks.createBlock(() -> new Block(properties), "chiseled_" + baseName + "_block").get());
            return this;
        }

        public Builder cracked(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.CRACKED,
                    BYGBlocks.createBlock(() -> new Block(properties), "cracked_" + baseName + "_block").get());
            return this;
        }

        public Builder cut(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.CUT,
                    BYGBlocks.createBlock(() -> new Block(properties), "cut_" + baseName + "_block").get());
            return this;
        }

        public Builder door() {
            this.family.variants.put(BYGBlockFamily.Variant.DOOR,
                    BYGBlocks.createDoor(baseName + "_door", blockSetType).get());
            return this;
        }

        public Builder fence() {
            this.family.variants.put(BYGBlockFamily.Variant.FENCE,
                    BYGBlocks.createFence(baseName + "_fence").get());
            return this;
        }

        public Builder fenceGate() {
            this.family.variants.put(BYGBlockFamily.Variant.FENCE_GATE,
                    BYGBlocks.createFence(baseName + "_fence_gate").get());
            return this;
        }

        public Builder hangingSign(Supplier<? extends MapColor> color, WoodType woodType) {
            this.family.variants.put(Variant.HANGING_SIGN,
                    BYGBlocks.createBlock(
                            () -> new CeilingHangingSignBlock(
                                    BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                                    woodType),
                            baseName + "_hanging_sign").get());
            this.family.variants.put(Variant.WALL_HANGING_SIGN,
                    BYGBlocks.createBlock(
                    () -> new WallHangingSignBlock(
                            BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                            woodType),
                    baseName + "_wall_hanging_sign").get());
            return this;
        }

        public Builder sign(Supplier<? extends MapColor> color, WoodType woodType) {
            this.family.variants.put(BYGBlockFamily.Variant.SIGN,
                    BYGBlocks.createBlock(
                            () -> new StandingSignBlock(
                                    BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                                    woodType),
                            baseName + "_sign").get());
            this.family.variants.put(BYGBlockFamily.Variant.WALL_SIGN,
                    BYGBlocks.createBlock(
                            () -> new WallSignBlock(
                                    BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                                    woodType),
                            baseName + "_wall_sign").get());
            return this;
        }

        public Builder slab() {
            this.family.variants.put(BYGBlockFamily.Variant.SLAB,
                    BYGBlocks.createWoodSlab(baseName + "_slab").get());
            return this;
        }

        public Builder stairs() {
            this.family.variants.put(BYGBlockFamily.Variant.STAIRS,
                    BYGBlocks.createWoodStairs(baseName + "_stairs").get());
            return this;
        }

        public Builder pressurePlate() {
            this.family.variants.put(BYGBlockFamily.Variant.PRESSURE_PLATE,
                    BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", blockSetType).get());
            return this;
        }

        public Builder polished(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.POLISHED,
                    BYGBlocks.createBlock(() -> new Block(properties), "polished_" + baseName + "_block").get());
            return this;
        }

        public Builder trapdoor(Block block) {
            this.family.variants.put(BYGBlockFamily.Variant.TRAPDOOR,
                    BYGBlocks.createTrapDoor(baseName + "_trapdoor", blockSetType).get());
            return this;
        }

        public Builder wall(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.WALL,
                    BYGBlocks.createBlock(() -> new WallBlock(properties), baseName + "_wall").get());
            return this;
        }

        public Builder dontGenerateModel() {
            this.family.generateModel = false;
            return this;
        }

        public Builder dontGenerateRecipe() {
            this.family.generateRecipe = false;
            return this;
        }

        public Builder featureLockedBehind(FeatureFlag... featureFlags) {
            this.family.requiredFeatures = FeatureFlags.REGISTRY.subset(featureFlags);
            return this;
        }

        public Builder recipeGroupPrefix(String string) {
            this.family.recipeGroupPrefix = string;
            return this;
        }

        public Builder recipeUnlockedBy(String string) {
            this.family.recipeUnlockedBy = string;
            return this;
        }
    }

    public enum Variant {
        BUTTON("button"),
        CHISELED("chiseled"),
        CRACKED("cracked"),
        CUT("cut"),
        DOOR("door"),
        FENCE("fence"),
        FENCE_GATE("fence_gate"),
        HANGING_SIGN("hanging_sign"),
        SIGN("sign"),
        SLAB("slab"),
        STAIRS("stairs"),
        PRESSURE_PLATE("pressure_plate"),
        POLISHED("polished"),
        TRAPDOOR("trapdoor"),
        WALL("wall"),
        WALL_HANGING_SIGN("wall_hanging_sign"),
        WALL_SIGN("wall_sign");

        private final String name;

        Variant(String string) {
            this.name = string;
        }

        public String getName() {
            return this.name;
        }
    }
}
