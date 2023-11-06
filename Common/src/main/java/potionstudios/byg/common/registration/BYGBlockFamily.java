package potionstudios.byg.common.registration;

import net.minecraft.Util;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
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
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.BYG;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.common.block.BYGBlockProperties;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.FlatVegetationBlock;
import potionstudios.byg.common.block.FruitBlock;
import potionstudios.byg.common.item.BYGBoatItem;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.mixin.access.StairBlockAccess;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.*;

@SuppressWarnings("unused")
public class BYGBlockFamily {
    private final String baseName;

    private final ResourceKey<DimensionType> dimension;

    // There is a separation between additional blocks and items and variants,
    // to make it clear which the "MAIN" block of that variant is supposed to be
    // Ex. Which of the 20 leaf blocks is the main one, the one in variants!
    private final Map<BlockVariant, Block> variants = new ConcurrentHashMap<>();
    private final Map<ItemVariant, Item> itemVariants = new ConcurrentHashMap<>();
    private final Map<ParticleVariant, SimpleParticleType> particleVariants = new ConcurrentHashMap<>();
    private final Map<BlockVariant, TagKey<Block>> blockTagKeyMap = new ConcurrentHashMap<>();
    private BiConsumer<BiConsumer<Block, Block>, BYGBlockFamily> strippables = null;
    private FeatureFlagSet requiredFeatures;
    private boolean generateModel;
    private boolean generateRecipe;
    @Nullable
    String recipeGroupPrefix;
    @Nullable
    String recipeUnlockedBy;

    private BYGBlockFamily(String baseName, ResourceKey<DimensionType> dimension) {
        this.baseName = baseName;
        this.requiredFeatures = FeatureFlags.VANILLA_SET;
        this.generateModel = true;
        this.generateRecipe = true;
        this.dimension = dimension;
    }

    public Map<BlockVariant, Block> getVariants() {
        return this.variants;
    }

    public Map<ItemVariant, Item> getItemVariants() {
        return itemVariants;
    }

    public Map<BlockVariant, TagKey<Block>> getBlockTagKeyMap() {
        return blockTagKeyMap;
    }

    public Block get(BlockVariant blockVariant) {
        return this.variants.get(blockVariant);
    }

    public Item get(ItemVariant itemVariant) { return this.itemVariants.get(itemVariant); }

    public SimpleParticleType get(ParticleVariant variant) {
        return this.particleVariants.get(variant);
    }

    public TagKey<Block> getTag(BlockVariant blockVariant) {
        return this.blockTagKeyMap.get(blockVariant);
    }

    public BiConsumer<BiConsumer<Block, Block>, BYGBlockFamily> getStrippables() {
        return strippables;
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

    public ResourceKey<DimensionType> getDimension() {
        return dimension;
    }

    public BYGBlockFamily spreadable(SpreadableTypes spreadableType,
                                  Function<BYGBlockFamily, ? extends Block> blockToSpreadToo,
                                  MapColor color,
                                  Supplier<ResourceKey<ConfiguredFeature<?, ?>>> feature,
                                  String id) {
        RegistryObject<? extends Block> block;
        if(dimension.equals(BuiltinDimensionTypes.END)) {
            if(SpreadableTypes.DIRT.equals(spreadableType)) {
                block = BYGBlocks.createEndDirtSpreadable(() -> blockToSpreadToo.apply(this), color, feature, id);
            } else {
                block = BYGBlocks.createEndStoneSpreadable(() -> blockToSpreadToo.apply(this), color, feature, id);
            }
        } else if(dimension.equals(BuiltinDimensionTypes.NETHER)) {
            if(SpreadableTypes.DIRT.equals(spreadableType)) {
                block = BYGBlocks.createNetherSpreadable(() -> blockToSpreadToo.apply(this), color, feature, id);
            } else {
                block = BYGBlocks.createNetherStoneSpreadable(() -> blockToSpreadToo.apply(this), color, feature, id);
            }
        } else {
            if(SpreadableTypes.DIRT.equals(spreadableType)) {
                block = BYGBlocks.createDirtSpreadable(() -> blockToSpreadToo.apply(this), color, id);
            } else {
                block = BYGBlocks.createStoneSpreadable(() -> blockToSpreadToo.apply(this), color, id);
            }
        }
        this.variants.put(BlockVariant.SPREAD_TO, blockToSpreadToo.apply(this));
        this.variants.put(BlockVariant.SPREADABLE, block.get());
        BYGItems.createItem(block);
        return this;
    }

    public static class OrganicBuilder {
        private final BYGBlockFamily family;
        private final String baseName;
        private final WoodType woodType;
        private final Supplier<? extends MapColor> color;

        public OrganicBuilder(String baseName, WoodType woodType, Supplier<? extends MapColor> color,
                              ResourceKey<DimensionType> dimension, boolean hasPlanks) {
            this.family = new BYGBlockFamily(baseName, dimension);
            if(hasPlanks) {
                RegistryObject<? extends Block> planks = BYGBlocks.createPlanks(baseName + "_planks");
                this.family.variants.put(BlockVariant.PLANKS, planks.get());
                this.family.variants.put(BlockVariant.BASE_BLOCK, planks.get());
                BYGItems.createItem(planks);
            }
            this.baseName = baseName;
            this.woodType = woodType;
            this.color = color;
        }

        public BYGBlockFamily build() {
            return this.family;
        }

        public OrganicBuilder bookshelf() {
            RegistryObject<? extends Block> block = BYGBlocks.createBookshelf(baseName + "_bookshelf");
            this.family.variants.put(BlockVariant.BOOKSHELF,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder bush(Supplier<RegistryObject<? extends Block>> supplier,
                                   String fruitName,
                                   Function<Block, Item> bushItem) {
            RegistryObject<? extends Block> block = supplier.get();
            this.family.variants.put(BlockVariant.BUSH,
                    block.get());
            Item unregisteredItem = bushItem.apply(block.get());
            if(unregisteredItem != null) {
                Item fruit = BYGItems.createItem(() -> unregisteredItem, fruitName).get();
                this.family.itemVariants.put(ItemVariant.FRUIT, fruit);
            }
            return this;
        }

        public OrganicBuilder button() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodButton(baseName + "_button", woodType.setType());
            this.family.variants.put(BlockVariant.BUTTON,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder craftingTable() {
            RegistryObject<? extends Block> block = BYGBlocks.createCraftingTable(baseName + "_crafting_table");
            this.family.variants.put(BlockVariant.CRAFTING_TABLE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder door() {
            RegistryObject<? extends Block> block = BYGBlocks.createDoor(baseName + "_door", woodType.setType());
            this.family.variants.put(BlockVariant.DOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder fence() {
            RegistryObject<? extends Block> block = BYGBlocks.createFence(baseName + "_fence");
            this.family.variants.put(BlockVariant.FENCE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder fenceGate() {
            RegistryObject<? extends Block> block = BYGBlocks.createFenceGate(baseName + "_fence_gate", woodType);
            this.family.variants.put(BlockVariant.FENCE_GATE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder foliage() {
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(() ->
                    new FlatVegetationBlock(BlockBehaviour.Properties.of().noCollission()
                            .instabreak().sound(SoundType.GRASS)), baseName + "_foliage");
            family.variants.put(BlockVariant.FOLIAGE, block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder floweringLeaves(BiFunction<String, BYGBlockFamily, BlockRegistryObject<Block>> leavesFactory) {
            if(this.family.variants.containsKey(BlockVariant.FLOWERING_LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = leavesFactory.apply(baseName + "_leaves", family);
            this.family.variants.put(BlockVariant.FLOWERING_LEAVES,
                    registryObject.get()
            );
            BYGItems.createItem(registryObject);
            return this;
        }


        // Registers Fruit Block, Fruit Item and Fruit Leaves
        public OrganicBuilder fruit(String fruitBlockName, String fruitItemName, String leafName, Function<Block, Item> itemGenerator) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createFruitBlock(fruitBlockName, family);
            family.variants.put(BlockVariant.FRUIT_BLOCK, block.get());
            if(itemGenerator != null) {
                RegistryObject<? extends Item> item =
                        BYGItems.createItem(() -> itemGenerator.apply(block.get()), fruitItemName);
                family.itemVariants.put(ItemVariant.FRUIT, item.get());
            }
            fruitLeaves((s, family) -> BYGBlocks.createFruitLeaves(MapColor.COLOR_GREEN,
                    () -> block.get().defaultBlockState().setValue(FruitBlock.AGE, 0),
                    leafName, 0.04F), leafName);
            return this;
        }

        public OrganicBuilder fruitBlock(String fruitBlockName, Supplier<Block> blockGenerator, String fruitItemName, Function<Block, Item> itemGenerator) {
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(blockGenerator, fruitBlockName);
            family.variants.put(BlockVariant.FRUIT_BLOCK, block.get());
            RegistryObject<? extends Item> item =
                    BYGItems.createItem(() -> itemGenerator.apply(block.get()), fruitItemName);
            family.itemVariants.put(ItemVariant.FRUIT, item.get());
            return this;
        }

        private OrganicBuilder fruitLeaves(BiFunction<String, BYGBlockFamily, BlockRegistryObject<Block>> leavesFactory, String name) {
            if(this.family.variants.containsKey(BlockVariant.FRUIT_LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = leavesFactory.apply(name, family);
            this.family.variants.put(BlockVariant.FRUIT_LEAVES,
                    registryObject.get()
            );
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder grass(@NotNull Supplier<? extends RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> registryObject = supplier.get();
            this.family.variants.put(BlockVariant.GRASS, registryObject.get());
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder growerItem(GrowerTypes growerType, String itemName,
                                         Consumer<TagKey<Block>> additionalTags) {
            TagKey<Block> tagKey = createTag(BYG.createLocation("may_place_on/" + itemName));
            additionalTags.accept(tagKey);
            this.family.blockTagKeyMap.put(BlockVariant.GROWER, tagKey);
            BlockRegistryObject<Block> growerBlock =
                    switch (growerType) {
                        case NETHER_PLANT -> BYGBlocks.createFungus(tagKey, itemName);
                        case MUSHROOM -> BYGBlocks.createMushroom(tagKey, itemName);
                        default -> BYGBlocks.createSapling(tagKey, itemName);
                    };
            this.family.variants.put(BlockVariant.GROWER, growerBlock.get());
            this.family.variants.put(BlockVariant.POTTED,
                    BYGBlocks.FLOWER_POT_BLOCKS.get(growerBlock.getId()).get());
            BYGItems.createGrowerItem(growerBlock, growerType == GrowerTypes.PLANT);
            return this;
        }

        public OrganicBuilder hangingSign() {
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

        public OrganicBuilder imbuedLog() {
            RegistryObject<? extends Block> block = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLog("imbued_" + baseName + "_log") :
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "imbued_" + baseName + "_stem");
            this.family.variants.put(BlockVariant.IMBUED_LOG,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder leaves(BiFunction<String, BYGBlockFamily, BlockRegistryObject<Block>> leavesFactory) {
            if(this.family.variants.containsKey(BlockVariant.LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = leavesFactory.apply(baseName + "_leaves", family);
            this.family.variants.put(BlockVariant.LEAVES,
                    registryObject.get()
                    );
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder leaves() {
            if(this.family.variants.containsKey(BlockVariant.LEAVES)) {
                return this;
            }
            RegistryObject<? extends Block> registryObject = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLeaves(color.get(), baseName + "_leaves") :
                    BYGBlocks.createBlock(BYGBlockProperties.BYGWartBlock::new, baseName + "_wart_block");
            this.family.variants.put(BlockVariant.LEAVES,
                        registryObject.get()
                    );
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder leafParticles(Supplier<SimpleParticleType> particle, String id) {
            RegistryObject<? extends ParticleType<?>> particles = BYGParticleTypes.createSimpleParticle(particle, id);
            family.particleVariants.put(ParticleVariant.LEAVES, (SimpleParticleType) particles.get());
            return this;
        }

        public OrganicBuilder log() {
            RegistryObject<? extends Block> block = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLog(baseName + "_log")
                    : BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_stem");
            this.family.variants.put(BlockVariant.LOG,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder pressurePlate() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", woodType.setType());
            this.family.variants.put(BlockVariant.PRESSURE_PLATE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder processedFood(String itemName, Supplier<? extends Item> supplier) {
            RegistryObject<? extends Item> item = BYGItems.createItem(supplier, itemName);
            this.family.itemVariants.put(ItemVariant.PROCESSED_FOOD,
                    item.get());
            return this;
        }

        public OrganicBuilder roots(@NotNull Supplier<? extends RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> registryObject = supplier.get();
            this.family.variants.put(BlockVariant.ROOTS, registryObject.get());
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder sign() {
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

        public OrganicBuilder soil() {
            RegistryObject<? extends Block> soil = BYGBlocks.createDirt(baseName + "_soil");
            this.family.variants.put(BlockVariant.SOIL, soil.get());
            BYGItems.createItem(soil);
            return this;
        }

        public OrganicBuilder slab() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodSlab(baseName + "_slab");
            this.family.variants.put(BlockVariant.SLAB,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder stairs() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodStairs(baseName + "_stairs");
            this.family.variants.put(BlockVariant.STAIRS,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder strippedLog() {
            RegistryObject<? extends Block> block = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLog("stripped_" + baseName + "_log")
                    : BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_stem");
            this.family.variants.put(BlockVariant.STRIPPED_LOG,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder strippables(BiConsumer<BiConsumer<Block, Block>, BYGBlockFamily> consumer) {
            family.strippables = consumer;
            return this;
        }

        public OrganicBuilder strippedWood() {
            RegistryObject<? extends Block> block = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLog("stripped_" + baseName + "_wood")
                    : BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + baseName + "_hyphae");
            this.family.variants.put(BlockVariant.STRIPPED_WOOD,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder sprouts(@NotNull Supplier<? extends RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> registryObject = supplier.get();
            this.family.variants.put(BlockVariant.SPROUTS, registryObject.get());
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder tallGrass(@NotNull Supplier<? extends RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> registryObject = supplier.get();
            this.family.variants.put(BlockVariant.TALL_GRASS, registryObject.get());
            BYGItems.createItem(registryObject);
            return this;
        }

        public OrganicBuilder trapdoor() {
            RegistryObject<? extends Block> block = BYGBlocks.createTrapDoor(baseName + "_trapdoor", woodType.setType());
            this.family.variants.put(BlockVariant.TRAPDOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder vine(Supplier<Block> supplier, String id) {
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(supplier, id);
            family.variants.put(BlockVariant.VINE, block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder wood() {
            RegistryObject<? extends Block> block = !family.getDimension().equals(BuiltinDimensionTypes.NETHER) ?
                    BYGBlocks.createLog(baseName + "_wood") :
                    BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, baseName + "_hyphae");
            this.family.variants.put(BlockVariant.WOOD,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public OrganicBuilder boat() {
            RegistryObject<Item> item = BYGItems.createItem(() ->
                    new BYGBoatItem(false, family,
                            new Item.Properties().stacksTo(1)), baseName + "_boat");
            this.family.itemVariants.put(ItemVariant.BOAT, item.get());
            return this;
        }

        public OrganicBuilder chestBoat() {
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

    public static class InorganicBuilder {
        private final BYGBlockFamily family;
        private final String baseName;
        private final BlockSetType blockSetType;

        public InorganicBuilder(String baseName, BlockSetType blockSetType, RegistryObject<? extends Block> block,
                                ResourceKey<DimensionType> dimension) {
            this.family = new BYGBlockFamily(baseName, dimension);
            this.family.variants.put(BlockVariant.BASE_BLOCK, block.get());
            BYGItems.createItem(block);
            this.baseName = baseName;
            this.blockSetType = blockSetType;
        }

        public BYGBlockFamily build() {
            return this.family;
        }

        public InorganicBuilder button() {
            RegistryObject<? extends Block> block = BYGBlocks.createWoodButton(baseName + "_button", blockSetType);
            this.family.variants.put(BlockVariant.BUTTON,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder carved(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "carved_" + baseName );
            this.family.variants.put(BlockVariant.CARVED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder carved_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("carved_", BlockVariant.CARVED_STAIRS, properties);
        }

        public InorganicBuilder carved_slab(BlockBehaviour.Properties properties) {
            return subType_slab("carved_", BlockVariant.CARVED_SLAB, properties);
        }

        public InorganicBuilder carved_wall(BlockBehaviour.Properties properties) {
            return subType_wall("carved_", BlockVariant.CARVED_WALL, properties);
        }

        public InorganicBuilder chiseled(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "chiseled_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CHISELED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder chiseled_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("chiseled_", BlockVariant.CHISELED_STAIRS, properties);
        }

        public InorganicBuilder chiseled_slab(BlockBehaviour.Properties properties) {
            return subType_slab("chiseled_", BlockVariant.CHISELED_SLAB, properties);
        }

        public InorganicBuilder chiseled_wall(BlockBehaviour.Properties properties) {
            return subType_wall("chiseled_", BlockVariant.CHISELED_WALL, properties);
        }

        public InorganicBuilder cobbled(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "cobbled_" + baseName);
            this.family.variants.put(BlockVariant.COBBLED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder cobbled_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cobbled_", BlockVariant.COBBLED_STAIRS, properties);
        }

        public InorganicBuilder cobbled_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cobbled_", BlockVariant.COBBLED_SLAB, properties);
        }

        public InorganicBuilder cobbled_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cobbled_", BlockVariant.COBBLED_WALL, properties);
        }

        public InorganicBuilder cracked(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "cracked_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CRACKED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder cracked_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cracked_", BlockVariant.CRACKED_STAIRS, properties);
        }

        public InorganicBuilder cracked_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cracked_", BlockVariant.CRACKED_SLAB, properties);
        }

        public InorganicBuilder cracked_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cracked_", BlockVariant.CRACKED_WALL, properties);
        }

        public InorganicBuilder cut(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "cut_" + baseName + "_block");
            this.family.variants.put(BlockVariant.CUT,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder cut_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("cut_", BlockVariant.CUT_STAIRS, properties);
        }

        public InorganicBuilder cut_slab(BlockBehaviour.Properties properties) {
            return subType_slab("cut_", BlockVariant.CUT_SLAB, properties);
        }

        public InorganicBuilder cut_wall(BlockBehaviour.Properties properties) {
            return subType_wall("cut_", BlockVariant.CUT_WALL, properties);
        }

        public InorganicBuilder door() {
            RegistryObject<? extends Block> block = BYGBlocks.createDoor(baseName + "_door", blockSetType);
            this.family.variants.put(BlockVariant.DOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder fence() {
            RegistryObject<? extends Block> block = BYGBlocks.createFence(baseName + "_fence");
            this.family.variants.put(BlockVariant.FENCE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder growth(Supplier<RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> block = supplier.get();
            this.family.variants.put(BlockVariant.GROWTH,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder slab() {
            RegistryObject<? extends Block> block = BYGBlocks.createStoneSlab(baseName + "_slab");
            this.family.variants.put(BlockVariant.SLAB,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder stairs() {
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(BYGBlockProperties.BYGStoneStairs::new,
                    baseName + "_stairs");
            this.family.variants.put(BlockVariant.STAIRS,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder pressurePlate() {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createWoodPressurePlate(baseName + "_pressure_plate", blockSetType);
            this.family.variants.put(BlockVariant.PRESSURE_PLATE,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder polished(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new Block(properties), "polished_" + baseName + "_block");
            this.family.variants.put(BlockVariant.POLISHED,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder polished_stairs(BlockBehaviour.Properties properties) {
            return subType_stairs("polished_", BlockVariant.POLISHED_STAIRS, properties);
        }

        public InorganicBuilder polished_slab(BlockBehaviour.Properties properties) {
            return subType_slab("polished_", BlockVariant.POLISHED_SLAB, properties);
        }

        public InorganicBuilder polished_wall(BlockBehaviour.Properties properties) {
            return subType_wall("polished_", BlockVariant.POLISHED_WALL, properties);
        }

        public InorganicBuilder trapdoor() {
            RegistryObject<? extends Block> block = BYGBlocks.createTrapDoor(baseName + "_trapdoor", blockSetType);
            this.family.variants.put(BlockVariant.TRAPDOOR,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        private InorganicBuilder subType_stairs(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
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

        private InorganicBuilder subType_slab(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_slab";
            RegistryObject<? extends Block> block = BYGBlocks.createBlock(() -> new SlabBlock(properties), id);
            this.family.variants.put(blockVariant,
                    block.get()
            );
            BYGItems.createItem(block);
            return this;
        }

        private InorganicBuilder subType_wall(String prefix, BlockVariant blockVariant, BlockBehaviour.Properties properties) {
            String id = prefix + baseName + "_wall";
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new WallBlock(properties), id);
            this.family.variants.put(blockVariant,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder tendrils(Supplier<RegistryObject<? extends Block>> supplier) {
            RegistryObject<? extends Block> block = supplier.get();
            this.family.variants.put(BlockVariant.TENDRILS,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder wall(BlockBehaviour.Properties properties) {
            RegistryObject<? extends Block> block =
                    BYGBlocks.createBlock(() -> new WallBlock(properties), baseName + "_wall");
            this.family.variants.put(BlockVariant.WALL,
                    block.get());
            BYGItems.createItem(block);
            return this;
        }

        public InorganicBuilder dontGenerateModel() {
            this.family.generateModel = false;
            return this;
        }

        public InorganicBuilder dontGenerateRecipe() {
            this.family.generateRecipe = false;
            return this;
        }

        public InorganicBuilder featureLockedBehind(FeatureFlag... featureFlags) {
            this.family.requiredFeatures = FeatureFlags.REGISTRY.subset(featureFlags);
            return this;
        }

        public InorganicBuilder recipeGroupPrefix(String string) {
            this.family.recipeGroupPrefix = string;
            return this;
        }

        public InorganicBuilder recipeUnlockedBy(String string) {
            this.family.recipeUnlockedBy = string;
            return this;
        }
    }

    public enum SpreadableTypes {
        STONE,
        DIRT
    }


    public enum GrowerTypes {
        PLANT,
        MUSHROOM,
        NETHER_PLANT,
        END_PLANT,
        DESERT_PLANT
    }

    public enum ParticleVariant {
        LEAVES,
        GLINT
    }

    public enum ItemVariant {
        BOAT("boat"),
        CHEST_BOAT("chest_boat"),
        FRUIT("fruit"),
        PROCESSED_FOOD("processed_food");

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
        BUSH("bush"),
        BUTTON("button"),
        CARVED("carved"),
        CARVED_STAIRS("carved_stairs"),
        CARVED_SLAB("carved_slab"),
        CARVED_WALL("carved_wall"),
        CHISELED("chiseled"),
        CHISELED_STAIRS("chiseled_stairs"),
        CHISELED_SLAB("chiseled_slab"),
        CHISELED_WALL("chiseled_wall"),
        COBBLED("cobbled"),
        COBBLED_STAIRS("cobbled_stairs"),
        COBBLED_SLAB("cobbled_slab"),
        COBBLED_WALL("cobbled_wall"),
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
        FOLIAGE("foliage"),
        FLOWERING_LEAVES("flowering_leaves"),
        FRUIT_BLOCK("fruit_block"),
        FRUIT_LEAVES("fruit_leaves"),
        GRASS("grass"),
        GROWER("grower"),
        GROWTH("growth"),
        IMBUED_LOG("imbued"),
        LEAVES("leaves"),
        LOG("log"),
        PLANKS("planks"),
        PRESSURE_PLATE("pressure_plate"),
        POLISHED("polished"),
        POLISHED_STAIRS("polished_stairs"),
        POLISHED_SLAB("polished_slab"),
        POLISHED_WALL("polished_wall"),
        POTTED("potted"),
        ROOTS("roots"),
        SIGN("sign"),
        SLAB("slab"),
        SOIL("soil"),
        SPREADABLE("spreadable"),
        SPREAD_TO("spread_to"),
        SPROUTS("sprouts"),
        STAIRS("stairs"),
        STRIPPED_LOG("stripped_log"),
        STRIPPED_WOOD("stripped_wood"),
        TALL_GRASS("tall_grass"),
        TENDRILS("tendrils"),
        TRAPDOOR("trapdoor"),
        WALL("wall"),
        WALL_HANGING_SIGN("wall_hanging_sign"),
        WALL_SIGN("wall_sign"),
        WOOD("wood"),
        VINE("vine");

        private final String name;

        BlockVariant(String string) {
            this.name = string;
        }

        public String getName() {
            return this.name;
        }
    }
}
