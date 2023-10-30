package potionstudios.byg.common.block;

import net.minecraft.Util;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import potionstudios.byg.BYG;
import potionstudios.byg.common.item.BYGBoatItem;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.mixin.access.StairBlockAccess;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class BYGBlockFamily {
    private final Block baseBlock;
    private final String baseName;
    private final Map<BlockVariant, Block> variants = new ConcurrentHashMap<>();
    private final Map<ItemVariant, Item> itemVariants = new ConcurrentHashMap<>();
    private final Map<GrowerItemType, TagKey<Block>> tagKeyMap = new ConcurrentHashMap<>();
    private FeatureFlagSet requiredFeatures;
    private boolean generateModel;
    private boolean generateRecipe;
    @Nullable
    String recipeGroupPrefix;
    @Nullable
    String recipeUnlockedBy;

    private BYGBlockFamily(String baseName, Block block) {
        this.baseName = baseName;
        this.requiredFeatures = FeatureFlags.VANILLA_SET;
        this.generateModel = true;
        this.generateRecipe = true;
        this.baseBlock = block;
    }

    public Block getBaseBlock() {
        return this.baseBlock;
    }

    public Map<BlockVariant, Block> getVariants() {
        return this.variants;
    }

    public Map<ItemVariant, Item> getItemVariants() {
        return itemVariants;
    }

    public Map<GrowerItemType, TagKey<Block>> getTagKeyMap() {
        return tagKeyMap;
    }

    public Block get(BlockVariant blockVariant) {
        return this.variants.get(blockVariant);
    }

    public Item get(ItemVariant itemVariant) { return this.itemVariants.get(itemVariant); }

    public TagKey<Block> getTag(GrowerItemType growerItemType) {
        return this.tagKeyMap.get(growerItemType);
    }

    public boolean shouldGenerateModel() {
        return this.generateModel;
    }

    public boolean shouldGenerateRecipe(FeatureFlagSet featureFlagSet) {
        return this.generateRecipe && this.requiredFeatures.isSubsetOf(featureFlagSet);
    }
    public String getBaseName() {
        return baseName;
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
            RegistryObject<? extends Block> planks = BYGBlocks.createPlanks(baseName + "_planks");
            this.family = new BYGBlockFamily(baseName, planks.get());
            this.family.variants.put(BlockVariant.PLANKS, planks.get());
            this.family.variants.put(BlockVariant.BASE_BLOCK, planks.get());
            BYGItems.createItem(planks);
            this.baseName = baseName;
            this.woodType = woodType;
            this.color = color;
            this.isNotOverworld = isNotOverworld;
        }

        public BYGBlockFamily build() {
            return this.family;
        }

        public WoodBuilder bookshelf() {
            RegistryObject<? extends Block> block = BYGBlocks.createBookshelf(baseName + "_bookshelf");
            this.family.variants.put(BlockVariant.BOOKSHELF,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder button() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodButton(baseName + "_button", woodType.setType());
            this.family.variants.put(BlockVariant.BUTTON,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder craftingTable() {
            RegistryObject<? extends Block> block = BYGBlocks.createCraftingTable(baseName + "_crafting_table");
            this.family.variants.put(BlockVariant.CRAFTING_TABLE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder door() {
            RegistryObject<? extends Block> block = BYGBlocks.createDoor(baseName + "_door", woodType.setType());
            this.family.variants.put(BlockVariant.DOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder fence() {
            RegistryObject<? extends Block> block = BYGBlocks.createFence(baseName + "_fence");
            this.family.variants.put(BlockVariant.FENCE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder fenceGate() {
            RegistryObject<? extends Block> block = BYGBlocks.createFenceGate(baseName + "_fence_gate", woodType);
            this.family.variants.put(BlockVariant.FENCE_GATE,
                    block.get());
            BYGItems.createItem(block);
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
            this.family.variants.put(BlockVariant.GROWER, growerBlock.get());
            this.family.variants.put(BlockVariant.POTTED,
                    BYGBlocks.FLOWER_POT_BLOCKS.get(growerBlock.getId()).get());
            BYGItems.createGrowerItem(growerBlock, growerItemType == BYGBlockFamily.GrowerItemType.SAPLING);
            return this;
        }

        public WoodBuilder hangingSign() {
            RegistryObject<? extends Block> sign = BYGBlocks.createBlock(
                    () -> new CeilingHangingSignBlock(
                            BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                            woodType),
                    baseName + "_hanging_sign");
            RegistryObject<? extends Block> wallSign = BYGBlocks.createBlock(
                    () -> new WallHangingSignBlock(
                            BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                            woodType),
                    baseName + "_wall_hanging_sign");
            this.family.variants.put(BlockVariant.HANGING_SIGN,
                    sign.get());
            this.family.variants.put(BlockVariant.WALL_HANGING_SIGN,
                    wallSign.get());
            BYGItems.createHangingSign(baseName + "_hanging_sign", sign, wallSign);
            return this;
        }

        public WoodBuilder leaves(Function<String, BlockRegistryObject<Block>> leavesFactory) {
            if(this.family.variants.containsKey(BlockVariant.LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = leavesFactory.apply(baseName + "_leaves");
            this.family.variants.put(BlockVariant.LEAVES,
                    registryObject.get()
                    );
            BYGItems.createItem(registryObject);
            return this;
        }

        public WoodBuilder leaves() {
            if(this.family.variants.containsKey(BlockVariant.LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = isNotOverworld ?
                    BYGBlocks.createBlock(BYGBlockProperties.BYGWartBlock::new, baseName + "_wart_block")
                    : BYGBlocks.createLeaves(color.get(), baseName + "_leaves");
            this.family.variants.put(BlockVariant.LEAVES,
                        registryObject.get()
                    );
            BYGItems.createItem(registryObject);
            return this;
        }

        public WoodBuilder log() {
            RegistryObject<? extends Block> block = isNotOverworld ?
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_stem")
                    : BYGBlocks.createLog(baseName + "_log");
            this.family.variants.put(BlockVariant.LOG,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder pressurePlate() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", woodType.setType());
            this.family.variants.put(BlockVariant.PRESSURE_PLATE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder sign() {
            RegistryObject<? extends Block> signBlock = BYGBlocks.createBlock(() -> new StandingSignBlock(
                    BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                    woodType), baseName + "_sign");
            RegistryObject<? extends Block> wallSign = BYGBlocks.createBlock(() -> new WallSignBlock(
                            BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).mapColor(color.get()),
                            woodType), baseName + "_wall_sign");
            this.family.variants.put(BlockVariant.SIGN,
                    signBlock.get());
            this.family.variants.put(BlockVariant.WALL_SIGN,
                    wallSign.get());
            BYGItems.createSign(baseName + "_sign", signBlock, wallSign);
            return this;
        }

        public WoodBuilder slab() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodSlab(baseName + "_slab");
            this.family.variants.put(BlockVariant.SLAB,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder stairs() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodStairs(baseName + "_stairs");
            this.family.variants.put(BlockVariant.STAIRS,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder strippedLog() {
            RegistryObject<? extends Block> block = isNotOverworld ?
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_stem")
                    : BYGBlocks.createLog("stripped_" + baseName + "_log");
            this.family.variants.put(BlockVariant.STRIPPED_LOG,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder strippedWood() {
            RegistryObject<? extends Block> block = isNotOverworld ?
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_hyphae")
                    : BYGBlocks.createLog("stripped_" + baseName + "_wood");
            this.family.variants.put(BlockVariant.STRIPPED_WOOD,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder trapdoor() {
            RegistryObject<? extends Block> block = BYGBlocks.createTrapDoor(baseName + "_trapdoor", woodType.setType());
            this.family.variants.put(BlockVariant.TRAPDOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder wood() {
            RegistryObject<? extends Block> block = isNotOverworld ?
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_hyphae")
                    : BYGBlocks.createLog(baseName + "_wood");
            this.family.variants.put(BlockVariant.WOOD,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public WoodBuilder boat() {
            RegistryObject<Item> item = BYGItems.createItem(() ->
                    new BYGBoatItem(false, family,
                            new Item.Properties().stacksTo(1)), baseName + "_boat");
            this.family.itemVariants.put(ItemVariant.BOAT, item.get());
            return this;
        }

        public WoodBuilder chestBoat() {
            RegistryObject<Item> item = BYGItems.createItem(() ->
                    new BYGBoatItem(true, family,
                            new Item.Properties().stacksTo(1)), baseName + "_chest_boat");
            this.family.itemVariants.put(ItemVariant.CHEST_BOAT, item.get());
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

        public Builder(String baseName, BlockSetType blockSetType, Supplier<? extends Block> supplier) {
            RegistryObject<? extends Block> baseBlock = BYGBlocks.createBlock(supplier, baseName + "_block");
            this.family = new BYGBlockFamily(baseName, baseBlock.get());
            this.family.variants.put(BlockVariant.BASE_BLOCK, baseBlock.get());
            BYGItems.createItem(baseBlock);
            this.baseName = baseName;
            this.blockSetType = blockSetType;
        }

        public BYGBlockFamily build() {
            return this.family;
        }

        public Builder button() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodButton(baseName + "_button", blockSetType);
            this.family.variants.put(BlockVariant.BUTTON,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder chiseled(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "chiseled_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CHISELED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder chiseled_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("chiseled_", BlockVariant.CHISELED_STAIRS, properties);
        }

        public Builder chiseled_slab(BlockBehaviour.Properties properties) {
            return subType_slab("chiseled_", BlockVariant.CHISELED_SLAB, properties);
        }

        public Builder chiseled_wall(BlockBehaviour.Properties properties) {
            return subType_wall("chiseled_", BlockVariant.CHISELED_WALL, properties);
        }

        public Builder cracked(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "cracked_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CRACKED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder cracked_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cracked_", BlockVariant.CRACKED_STAIRS, properties);
        }

        public Builder cracked_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cracked_", BlockVariant.CRACKED_SLAB, properties);
        }

        public Builder cracked_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cracked_", BlockVariant.CRACKED_WALL, properties);
        }

        public Builder cut(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "cut_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CUT,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder cut_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cut_", BlockVariant.CUT_STAIRS, properties);
        }

        public Builder cut_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cut_", BlockVariant.CUT_SLAB, properties);
        }

        public Builder cut_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cut_", BlockVariant.CUT_WALL, properties);
        }

        public Builder door() {
            RegistryObject<? extends Block> block = BYGBlocks.createDoor(baseName + "_door", blockSetType);
            this.family.variants.put(BlockVariant.DOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder fence() {
            RegistryObject<? extends Block> block = BYGBlocks.createFence(baseName + "_fence");
            this.family.variants.put(BlockVariant.FENCE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder slab() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodSlab(baseName + "_slab");
            this.family.variants.put(BlockVariant.SLAB,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder stairs() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodStairs(baseName + "_stairs");
            this.family.variants.put(BlockVariant.STAIRS,
                    block.get());
            return this;
        }

        public Builder pressurePlate() {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", blockSetType);
            this.family.variants.put(BlockVariant.PRESSURE_PLATE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder polished(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "polished_" + baseName + "_block");
            this.family.variants.put(BlockVariant.POLISHED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder polished_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("polished_", BlockVariant.POLISHED_STAIRS, properties);
        }

        public Builder polished_slab(BlockBehaviour.Properties properties) {
            return subType_slab("polished_", BlockVariant.POLISHED_SLAB, properties);
        }

        public Builder polished_wall(BlockBehaviour.Properties properties) {
            return subType_wall("polished_", BlockVariant.POLISHED_WALL, properties);
        }

        public Builder trapdoor() {
            RegistryObject<? extends Block> block = BYGBlocks.createTrapDoor(baseName + "_trapdoor", blockSetType);
            this.family.variants.put(BlockVariant.TRAPDOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        private Builder subType_stairs(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_stairs";
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(
                    () -> StairBlockAccess.byg_create(BuiltInRegistries.BLOCK
                                    .get(BYG.createLocation(id.replace("_stairs", "block"))).defaultBlockState(),
                            properties), id);
            this.family.variants.put(blockVariant,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        private Builder subType_slab(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_slab";
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(() -> new SlabBlock(properties), id);
            this.family.variants.put(blockVariant,
                    block.get()
            );
            BYGItems.createItem(block);
            return this;
        }

        private Builder subType_wall(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_wall";
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new WallBlock(properties), id);
            this.family.variants.put(blockVariant,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public Builder wall(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new WallBlock(properties), baseName + "_wall");
            this.family.variants.put(BlockVariant.WALL,
                    block.get());
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

    public enum ItemVariant {
        BOAT("boat"),
        CHEST_BOAT("chest_boat");

        private final String name;

        ItemVariant(String string) {
            this.name = string;
        }

        public String getName() {
            return this.name;
        }
    }

    public enum BlockVariant {
        BASE_BLOCK("base_block"),
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

        BlockVariant(String string) {
            this.name = string;
        }

        public String getName() {
            return this.name;
        }
    }
}
