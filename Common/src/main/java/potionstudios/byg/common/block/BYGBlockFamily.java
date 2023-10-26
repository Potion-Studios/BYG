package potionstudios.byg.common.block;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import potionstudios.byg.BYG;
import potionstudios.byg.mixin.access.StairBlockAccess;
import potionstudios.byg.reg.BlockRegistryObject;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class BYGBlockFamily {
    private final Block baseBlock;
    private final Map<Variant, Block> variants = new HashMap<>();
    private final Map<GrowerItemType, TagKey<Block>> tagKeyMap = new HashMap<>();
    private FeatureFlagSet requiredFeatures;
    private boolean generateModel;
    private boolean generateRecipe;
    @Nullable
    String recipeGroupPrefix;
    @Nullable
    String recipeUnlockedBy;

    private BYGBlockFamily(Block block) {
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

    public Map<GrowerItemType, TagKey<Block>> getTagKeyMap() {
        return tagKeyMap;
    }

    public Block get(Variant variant) {
        return this.variants.get(variant);
    }

    public TagKey<Block> getTag(GrowerItemType growerItemType) {
        return this.tagKeyMap.get(growerItemType);
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

    public static class WoodBuilder {
        private final BYGBlockFamily family;
        private final String baseName;
        private final WoodType woodType;
        private final Supplier<? extends MapColor> color;

        private final boolean isNotOverworld;

        public WoodBuilder(String baseName, WoodType woodType, Supplier<? extends MapColor> color,
                           boolean isNotOverworld) {
            Block planks = BYGBlocks.createPlanks(baseName + "_planks").get();
            this.family = new BYGBlockFamily(planks);
            this.family.variants.put(Variant.PLANKS, planks);
            this.baseName = baseName;
            this.woodType = woodType;
            this.color = color;
            this.isNotOverworld = isNotOverworld;
        }

        public BYGBlockFamily build() {
            return this.family;
        }

        // Needs special model
        public WoodBuilder bookshelf() {
            this.family.variants.put(Variant.BOOKSHELF,
                    BYGBlocks.createBookshelf(baseName + "_bookshelf").get());
            return this;
        }

        public WoodBuilder button() {
            this.family.variants.put(BYGBlockFamily.Variant.BUTTON,
                    BYGBlocks.createWoodButton(baseName + "_button", woodType.setType()).get());
            return this;
        }

        public WoodBuilder craftingTable() {
            this.family.variants.put(Variant.CRAFTING_TABLE,
                    BYGBlocks.createCraftingTable(baseName + "_crafting_table").get());
            return this;
        }

        public WoodBuilder door() {
            this.family.variants.put(BYGBlockFamily.Variant.DOOR,
                    BYGBlocks.createDoor(baseName + "_door", woodType.setType()).get());
            return this;
        }

        public WoodBuilder fence() {
            this.family.variants.put(BYGBlockFamily.Variant.FENCE,
                    BYGBlocks.createFence(baseName + "_fence").get());
            return this;
        }

        public WoodBuilder fenceGate() {
            this.family.variants.put(BYGBlockFamily.Variant.FENCE_GATE,
                    BYGBlocks.createFence(baseName + "_fence_gate").get());
            return this;
        }

        public WoodBuilder growerItem(GrowerItemType growerItemType, String itemName) {
            TagKey<Block> tagKey = createTag(BYG.createLocation("may_place_on/" + itemName));
            this.family.tagKeyMap
                    .put(growerItemType, tagKey);
            BlockRegistryObject<Block> growerBlock =
                    switch (growerItemType) {
                        case NETHER_PLANT -> BYGBlocks.createFungus(tagKey, itemName);
                        case MUSHROOM -> BYGBlocks.createMushroom(tagKey, itemName);
                        default -> BYGBlocks.createSapling(tagKey, itemName);
                    };
            this.family.variants.put(Variant.GROWER, growerBlock.get());
            this.family.variants.put(Variant.POTTED,
                    BYGBlocks.FLOWER_POT_BLOCKS.get(growerBlock.getId()).get());
            return this;
        }

        public WoodBuilder hangingSign() {
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

        public WoodBuilder leaves(Function<String, BlockRegistryObject<Block>> leavesFactory) {
            if(this.family.variants.containsKey(Variant.LEAVES)) {
                return this;
            }
            this.family.variants.put(Variant.LEAVES,
                    leavesFactory.apply(baseName + "_leaves").get()
                    );
            return this;
        }

        public WoodBuilder leaves() {
            if(this.family.variants.containsKey(Variant.LEAVES)) {
                return this;
            }
            this.family.variants.put(Variant.LEAVES,
                    isNotOverworld ?
                            BYGBlocks.createBlock(BYGBlockProperties.BYGWartBlock::new, baseName + "_wart_block").get()
                            : BYGBlocks.createLeaves(color.get(), baseName + "_leaves").get()
                    );
            return this;
        }

        // Need custom model

        public WoodBuilder log() {
            this.family.variants.put(Variant.LOG,
                    isNotOverworld ?
                            BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_stem").get()
                            : BYGBlocks.createLog(baseName + "_log").get());
            return this;
        }

        public WoodBuilder pressurePlate() {
            this.family.variants.put(BYGBlockFamily.Variant.PRESSURE_PLATE,
                    BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", woodType.setType()).get());
            return this;
        }

        public WoodBuilder sign() {
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

        public WoodBuilder slab() {
            this.family.variants.put(BYGBlockFamily.Variant.SLAB,
                    BYGBlocks.createWoodSlab(baseName + "_slab").get());
            return this;
        }

        public WoodBuilder stairs() {
            this.family.variants.put(BYGBlockFamily.Variant.STAIRS,
                    BYGBlocks.createWoodStairs(baseName + "_stairs").get());
            return this;
        }

        // Need custom model

        public WoodBuilder strippedLog() {
            this.family.variants.put(Variant.STRIPPED_LOG,
                    isNotOverworld ?
                            BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_stem").get()
                            : BYGBlocks.createLog("stripped_" + baseName + "_log").get());
            return this;
        }

        // Need custom model

        public WoodBuilder strippedWood() {
            this.family.variants.put(Variant.STRIPPED_WOOD,
                    isNotOverworld ?
                            BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_hyphae").get()
                            : BYGBlocks.createLog("stripped_" + baseName + "_wood").get());
            return this;
        }

        public WoodBuilder trapdoor() {
            this.family.variants.put(BYGBlockFamily.Variant.TRAPDOOR,
                    BYGBlocks.createTrapDoor(baseName + "_trapdoor", woodType.setType()).get());
            return this;
        }

        // Need custom model

        public WoodBuilder wood() {
            this.family.variants.put(Variant.WOOD,
                    isNotOverworld ?
                            BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_hyphae").get()
                            : BYGBlocks.createLog(baseName + "_wood").get());
            return this;
        }

        private static TagKey<Block> createTag(ResourceLocation location) {
            return TagKey.create(Registries.BLOCK, location);
        }
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

        public BYGBlockFamily build() {
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

        public Builder chiseled_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("chiseled_", Variant.CHISELED_STAIRS, properties);
        }

        public Builder chiseled_slab(BlockBehaviour.Properties properties) {
            return subType_slab("chiseled_", Variant.CHISELED_SLAB, properties);
        }

        public Builder chiseled_wall(BlockBehaviour.Properties properties) {
            return subType_wall("chiseled_", Variant.CHISELED_WALL, properties);
        }

        public Builder cracked(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.CRACKED,
                    BYGBlocks.createBlock(() -> new Block(properties), "cracked_" + baseName + "_block").get());
            return this;
        }

        public Builder cracked_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cracked_", Variant.CRACKED_STAIRS, properties);
        }

        public Builder cracked_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cracked_", Variant.CRACKED_SLAB, properties);
        }

        public Builder cracked_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cracked_", Variant.CRACKED_WALL, properties);
        }

        public Builder cut(BlockBehaviour.Properties properties) {
            this.family.variants.put(BYGBlockFamily.Variant.CUT,
                    BYGBlocks.createBlock(() -> new Block(properties), "cut_" + baseName + "_block").get());
            return this;
        }

        public Builder cut_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cut_", Variant.CUT_STAIRS, properties);
        }

        public Builder cut_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cut_", Variant.CUT_SLAB, properties);
        }

        public Builder cut_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cut_", Variant.CUT_WALL, properties);
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

        public Builder polished_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("polished_", Variant.POLISHED_STAIRS, properties);
        }

        public Builder polished_slab(BlockBehaviour.Properties properties) {
            return subType_slab("polished_", Variant.POLISHED_SLAB, properties);
        }

        public Builder polished_wall(BlockBehaviour.Properties properties) {
            return subType_wall("polished_", Variant.POLISHED_WALL, properties);
        }

        public Builder trapdoor() {
            this.family.variants.put(BYGBlockFamily.Variant.TRAPDOOR,
                    BYGBlocks.createTrapDoor(baseName + "_trapdoor", blockSetType).get());
            return this;
        }

        private Builder subType_stairs(String prefix, Variant variant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_stairs";
            this.family.variants.put(variant,
                    BYGBlocks.createBlock(
                            () -> StairBlockAccess.byg_create(BuiltInRegistries.BLOCK
                                            .get(BYG.createLocation(id.replace("_stairs", "block"))).defaultBlockState(),
                                    properties), id).get());
            return this;
        }

        private Builder subType_slab(String prefix, Variant variant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_slab";
            this.family.variants.put(variant,
                    BYGBlocks.createBlock(() -> new SlabBlock(properties), id).get()
            );
            return this;
        }

        private Builder subType_wall(String prefix, Variant variant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_wall";
            this.family.variants.put(variant,
                    BYGBlocks.createBlock(() -> new WallBlock(properties), id).get());
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


    public enum GrowerItemType {
        SAPLING,
        MUSHROOM,
        NETHER_PLANT,
        END_PLANT,
        DESERT_PLANT
    }

    public enum Variant {
        BOOKSHELF("bookshelf"),
        BUTTON("button"),
        CHISELED("chiseled"),
        CHISELED_STAIRS("chiseled_stairs"),
        CHISELED_SLAB("chiseled_slab"),
        CHISELED_WALL("chiseled_wall"),
        CRACKED("cracked"),
        CRACKED_STAIRS("cracked_stairs"),
        CRACKED_SLAB("cracked_slab"),
        CRACKED_WALL("cracked_wall"),
        CRAFTING_TABLE("crafting_table"),
        CUT("cut"),
        CUT_STAIRS("cut_stairs"),
        CUT_SLAB("cut_slab"),
        CUT_WALL("cut_wall"),
        DOOR("door"),
        HANGING_SIGN("hanging_sign"),
        FENCE("fence"),
        FENCE_GATE("fence_gate"),
        GROWER("grower"),
        LEAVES("leaves"),
        LOG("log"),
        PLANKS("planks"),
        PRESSURE_PLATE("pressure_plate"),
        POLISHED("polished"),
        POLISHED_STAIRS("polished_stairs"),
        POLISHED_SLAB("polished_slab"),
        POLISHED_WALL("polished_wall"),
        POTTED("potted"),
        SIGN("sign"),
        SLAB("slab"),
        STAIRS("stairs"),
        STRIPPED_LOG("stripped_log"),
        STRIPPED_WOOD("stripped_wood"),
        TRAPDOOR("trapdoor"),
        WALL("wall"),
        WALL_HANGING_SIGN("wall_hanging_sign"),
        WALL_SIGN("wall_sign"),
        WOOD("wood");

        private final String name;

        Variant(String string) {
            this.name = string;
        }

        public String getName() {
            return this.name;
        }
    }
}
