package potionstudios.byg.common.block;

import net.minecraft.core.Registry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.common.item.BYGBoatItem;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.mixin.access.WoodTypeAccess;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistryObject;
import potionstudios.byg.util.MultiTag;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public enum BYGWoodTypes {
    ASPEN("aspen", new Builder()
            .boatType(BYGBoatEntity.BYGType.ASPEN)
            .materialColor(MaterialColor.TERRACOTTA_YELLOW)
            .growerItemGroundTag(BYGBlockTags.GROUND_ASPEN_SAPLING)),
    BAOBAB("baobab", new Builder()
            .boatType(BYGBoatEntity.BYGType.BAOBAB)
            .growerItemGroundTag(BYGBlockTags.GROUND_BAOBAB_SAPLING)
            .materialColor(MaterialColor.TERRACOTTA_GREEN)),
    BLUE_ENCHANTED("blue_enchanted", new Builder()
            .boatType(BYGBoatEntity.BYGType.BLUE_ENCHANTED)
            .growerItemGroundTag(BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING)
            .materialColor(MaterialColor.COLOR_BLUE)
            .leavesLightLevel(15)),
    BULBIS("bulbis", new Builder()
            .materialColor(MaterialColor.COLOR_BLUE)
            .growerItemGroundTag(BYGBlockTags.GROUND_BULBIS_ODDITY)
            .growerItem(GrowerItemType.ODDITY)
            .exclude(BlockType.LEAVES)
            .registryName(BlockType.WOOD, "%s_wood")
            .registryName(BlockType.STRIPPED_WOOD, "stripped_%s_wood")
            .nether()),
    CHERRY("cherry", new Builder()
            .exclude(BlockType.SAPLING, BlockType.LEAVES)
            .boatType(BYGBoatEntity.BYGType.CHERRY)),
    CIKA("cika", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_CIKA_SAPLING)
            .boatType(BYGBoatEntity.BYGType.CIKA)
            .materialColor(MaterialColor.TERRACOTTA_ORANGE)),
    CYPRESS("cypress", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_CYPRESS_SAPLING)
            .boatType(BYGBoatEntity.BYGType.CYPRESS)
            .materialColor(MaterialColor.TERRACOTTA_LIGHT_GREEN)),
    EBONY("ebony", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_EBONY_SAPLING)
            .boatType(BYGBoatEntity.BYGType.EBONY)
            .materialColor(MaterialColor.COLOR_GREEN)),
    ETHER("ether", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_ETHER_SAPLING)
            .materialColor(MaterialColor.COLOR_CYAN)),
    FIR("fir", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_FIR_SAPLING)
            .materialColor(MaterialColor.COLOR_GREEN)
            .boatType(BYGBoatEntity.BYGType.FIR)),
    GREEN_ENCHANTED("green_enchanted", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING)
            .boatType(BYGBoatEntity.BYGType.GREEN_ENCHANTED)
            .materialColor(MaterialColor.COLOR_GREEN)
            .leavesLightLevel(15)),
    HOLLY("holly", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_HOLLY_SAPLING)
            .materialColor(MaterialColor.TERRACOTTA_GREEN)
            .boatType(BYGBoatEntity.BYGType.HOLLY)),
    IMPARIUS("imparius", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_IMPARIUS_MUSHROOM)
            .exclude(BlockType.LEAVES, BlockType.STRIPPED_LOG, BlockType.STRIPPED_WOOD)
            .growerItem(GrowerItemType.MUSHROOM)
            .nether()),
    MAHOGANY("mahogany", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_MANGROVE_SAPLING)
            .boatType(BYGBoatEntity.BYGType.MAHOGANY)
            .materialColor(MaterialColor.COLOR_GREEN)
            .leavesHaveOverlay()),
    MANGROVE("mangrove", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_MANGROVE_SAPLING)
            .boatType(BYGBoatEntity.BYGType.MANGROVE)
            .materialColor(MaterialColor.COLOR_GREEN)),
    PALM("palm", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_PALM_SAPLING)
            .boatType(BYGBoatEntity.BYGType.PALM)
            .materialColor(MaterialColor.COLOR_GREEN)),
    PINE("pine", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_PINE_SAPLING)
            .boatType(BYGBoatEntity.BYGType.PINE)
            .materialColor(MaterialColor.TERRACOTTA_GREEN)),
    RAINBOW_EUCALYPTUS("rainbow_eucalyptus", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_RAINBOW_EUCALYPTUS_SAPLING)
            .boatType(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS)
            .materialColor(MaterialColor.COLOR_GREEN)),
    REDWOOD("redwood", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_REDWOOD_SAPLING)
            .boatType(BYGBoatEntity.BYGType.REDWOOD)
            .materialColor(MaterialColor.COLOR_GREEN)),
    WILLOW("willow", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_WILLOW_SAPLING)
            .boatType(BYGBoatEntity.BYGType.WILLOW)
            .materialColor(MaterialColor.TERRACOTTA_GREEN)
            .leavesHaveOverlay()),
    WITCH_HAZEL("witch_hazel", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING)
            .boatType(BYGBoatEntity.BYGType.WITCH_HAZEL)
            .materialColor(MaterialColor.COLOR_ORANGE)),
    ZELKOVA("zelkova", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_ZELKOVA_SAPLING)
            .boatType(BYGBoatEntity.BYGType.ZELKOVA)
            .materialColor(MaterialColor.TERRACOTTA_RED)),
    SYTHIAN("sythian", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_SYTHIAN_FUNGUS)
            .growerItem(GrowerItemType.FUNGUS)
            .nether()),
    EMBUR("embur", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_EMBUR_WART)
            .growerItem(GrowerItemType.WART)
            .exclude(BlockType.LEAVES)
            .registryName(BlockType.LOG, "%s_pedu")
            .registryName(BlockType.STRIPPED_LOG, "stripped_%s_pedu")
            .nether()),
    NIGHTSHADE("nightshade", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_NIGHTSHADE_SAPLING)
            .materialColor(MaterialColor.COLOR_ORANGE)),
    SKYRIS("skyris", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_SKYRIS_SAPLING)
            .materialColor(MaterialColor.COLOR_PINK)
            .boatType(BYGBoatEntity.BYGType.SKYRIS)),
    LAMENT("lament", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_LAMENT_SAPLING)
            .materialColor(MaterialColor.COLOR_MAGENTA)),
    MAPLE("maple", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_MAPLE_SAPLING)
            .materialColor(MaterialColor.COLOR_GREEN)
            .boatType(BYGBoatEntity.BYGType.MAPLE)),
    JACARANDA("jacaranda", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_JACARANDA_SAPLING)
            .boatType(BYGBoatEntity.BYGType.JACARANDA)
            .materialColor(MaterialColor.TERRACOTTA_PURPLE));

    public static final Map<String, BYGWoodTypes> LOOKUP = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(BYGWoodTypes::toString, Function.identity()));;

    private final String name;
    private final WoodType woodType;
    private final Builder builder;
    private boolean initialized;

    private final MultiTag logTag;

    private BlockRegistryObject<Block> growerItem;
    private BlockRegistryObject<Block> leaves;

    private BlockRegistryObject<Block> log;
    private BlockRegistryObject<Block> wood;
    private BlockRegistryObject<Block> strippedLog;
    private BlockRegistryObject<Block> strippedWood;

    private BlockRegistryObject<Block> planks;
    private BlockRegistryObject<Block> bookshelf;
    private BlockRegistryObject<Block> craftingTable;
    private BlockRegistryObject<Block> stairs;
    private BlockRegistryObject<Block> slab;

    private BlockRegistryObject<Block> fence;
    private BlockRegistryObject<Block> fenceGate;

    private BlockRegistryObject<Block> door;
    private BlockRegistryObject<Block> trapdoor;

    private BlockRegistryObject<Block> pressurePlate;
    private BlockRegistryObject<Block> button;

    private BlockRegistryObject<Block> sign;
    private BlockRegistryObject<Block> wallSign;
    private RegistryObject<SignItem> signItem;

    private RegistryObject<BYGBoatItem> boat;

    BYGWoodTypes(String name, Builder builder) {
        this.name = name;
        this.builder = builder;
        this.woodType = WoodTypeAccess.byg_create(name);

        logTag = MultiTag.create(BYG.createLocation("wood/" + name + "_logs"));
    }

    public void init() {
        if (initialized)
            return;
        if (!builder.excludes.contains(BlockType.SAPLING)) {
        this.growerItem = switch (builder.growerItemType) {
            case SAPLING -> BYGBlocks.createSapling(builder.growerItemGroundTag, name + "_sapling");
            case ODDITY -> BYGBlocks.createMushroom(builder.growerItemGroundTag, name + "_oddity");
            case FUNGUS -> BYGBlocks.createFungus(builder.growerItemGroundTag, name + "_fungus");
            case MUSHROOM -> BYGBlocks.createMushroom(builder.growerItemGroundTag, name + "_mushroom");
            case WART -> BYGBlocks.createFungus(builder.growerItemGroundTag, name + "_wart");
        };
        BYGItems.createGrowerItem(growerItem, builder.growerItemType == GrowerItemType.SAPLING);
        }
        if (!builder.excludes.contains(BlockType.LEAVES)) {
            if (builder.isNether)
                this.leaves = BYGBlocks.createBlock(BYGBlockProperties.BYGWartBlock::new, nameOr("%s_wart_block", BlockType.LEAVES));
            else
                this.leaves = builder.leavesLightLevel == null ? BYGBlocks.createLeaves(builder.materialColor, name + "_leaves") : BYGBlocks.createGlowingLeaves(builder.materialColor, builder.leavesLightLevel, name + "_leaves");
            BYGItems.createItem(leaves);
        }

        this.log = ifAllowed(BlockType.LOG, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("%s_stem", BlockType.LOG)) : BYGBlocks.createLog(nameOr("%s_log", BlockType.LOG)));
        BYGItems.createItem(log);
        this.wood = ifAllowed(BlockType.WOOD, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("%s_hyphae", BlockType.WOOD)) : BYGBlocks.createWood(nameOr("%s_wood", BlockType.WOOD)));
        BYGItems.createItem(wood);
        this.strippedLog = ifAllowed(BlockType.STRIPPED_LOG, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("stripped_%s_stem", BlockType.STRIPPED_LOG)) : BYGBlocks.createStrippedLog(nameOr("stripped_%s_log", BlockType.STRIPPED_LOG)));
        BYGItems.createItem(strippedLog);
        this.strippedWood = ifAllowed(BlockType.STRIPPED_WOOD, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("stripped_%s_hyphae", BlockType.STRIPPED_WOOD)) : BYGBlocks.createWood(nameOr("stripped_%s_wood", BlockType.STRIPPED_WOOD)));
        BYGItems.createItem(strippedWood);

        this.planks = BYGBlocks.createPlanks(name + "_planks");
        BYGItems.createItem(planks);
        this.bookshelf = BYGBlocks.createBookshelf(name + "_bookshelf");
        BYGItems.createItem(bookshelf);
        this.craftingTable = BYGBlocks.createCraftingTable(name + "_crafting_table");
        BYGItems.createItem(craftingTable);
        this.stairs = BYGBlocks.createWoodStairs(name + "_stairs");
        BYGItems.createItem(stairs);
        this.slab = BYGBlocks.createWoodSlab(name + "_slab");
        BYGItems.createItem(slab);

        this.fence = BYGBlocks.createFence(name + "_fence");
        BYGItems.createItem(fence);
        this.fenceGate = BYGBlocks.createFenceGate(name + "_fence_gate");
        BYGItems.createItem(fenceGate);

        this.door = BYGBlocks.createDoor(name + "_door");
        BYGItems.createItem(door);
        this.trapdoor = BYGBlocks.createTrapDoor(name + "_trapdoor");
        BYGItems.createItem(trapdoor);

        this.pressurePlate = BYGBlocks.createWoodPressurePlate(name + "_pressure_plate");
        BYGItems.createItem(pressurePlate);
        this.button = BYGBlocks.createWoodButton(name + "_button");
        BYGItems.createItem(button);

        this.sign = BYGBlocks.createSign(name + "_sign", woodType, planks);
        this.wallSign = BYGBlocks.createWallSign(name + "_wall_sign", woodType, planks);
        this.signItem = BYGItems.createSign(name + "_sign", sign, wallSign);

        if (builder.boatType != null) {
            this.boat = BYGItems.createItem(() -> new BYGBoatItem(builder.boatType, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), name + "_boat");
        }
        initialized = true;
    }

    private String nameOr(String defaultName, BlockType blockType) {
        return builder.registryName.computeIfAbsent(blockType, k -> defaultName).formatted(name);
    }

    private <T> T ifAllowed(BlockType type, Supplier<? extends T> sup) {
        return builder.excludes.contains(type) ? null : sup.get();
    }

    @Override
    public String toString() {
        return name;
    }

    public BlockRegistryObject<Block> planks() {
        return planks;
    }
    public BlockRegistryObject<Block> growerItem() {
        return growerItem;
    }
    public WoodType woodType() {
        return woodType;
    }

    public BlockRegistryObject<Block> leaves() {
        return leaves;
    }

    public BlockRegistryObject<Block> log() {
        return log;
    }

    public BlockRegistryObject<Block> wood() {
        return wood;
    }

    public BlockRegistryObject<Block> strippedLog() {
        return strippedLog;
    }

    public BlockRegistryObject<Block> strippedWood() {
        return strippedWood;
    }

    public BlockRegistryObject<Block> bookshelf() {
        return bookshelf;
    }

    public BlockRegistryObject<Block> craftingTable() {
        return craftingTable;
    }

    public BlockRegistryObject<Block> stairs() {
        return stairs;
    }

    public BlockRegistryObject<Block> slab() {
        return slab;
    }

    public BlockRegistryObject<Block> fence() {
        return fence;
    }

    public BlockRegistryObject<Block> fenceGate() {
        return fenceGate;
    }

    public BlockRegistryObject<Block> door() {
        return door;
    }

    public BlockRegistryObject<Block> trapdoor() {
        return trapdoor;
    }

    public BlockRegistryObject<Block> pressurePlate() {
        return pressurePlate;
    }

    public BlockRegistryObject<Block> button() {
        return button;
    }

    public BlockRegistryObject<Block> sign() {
        return sign;
    }

    public BlockRegistryObject<Block> wallSign() {
        return wallSign;
    }

    public RegistryObject<SignItem> signItem() {
        return signItem;
    }

    public RegistryObject<BYGBoatItem> boat() {
        return boat;
    }

    public MultiTag logTag() {
        return logTag;
    }

    public BYGBoatEntity.BYGType boatType() {
        return builder.boatType;
    }

    public boolean isNether() {
        return builder.isNether;
    }

    public boolean leavesHaveOverlay() {
        return builder.leavesHaveOverlay;
    }

    public enum GrowerItemType {
        SAPLING,
        ODDITY,
        FUNGUS,
        MUSHROOM,
        WART
    }

    public enum BlockType {
        LEAVES,
        SAPLING,
        WOOD,
        LOG,
        STRIPPED_WOOD,
        STRIPPED_LOG
    }

    public static final class Builder {
        private final Map<BlockType, String> registryName = new HashMap<>();
        private GrowerItemType growerItemType = GrowerItemType.SAPLING;
        private final EnumSet<BlockType> excludes = EnumSet.noneOf(BlockType.class);
        private TagKey<Block> growerItemGroundTag = BlockTags.DIRT;
        private BYGBoatEntity.BYGType boatType;
        private MaterialColor materialColor;
        private Integer leavesLightLevel;
        private boolean isNether;
        private boolean leavesHaveOverlay;

        public Builder growerItem(GrowerItemType type) {
            this.growerItemType = type;
            return this;
        }
        public Builder exclude(BlockType... types) {
            excludes.addAll(List.of(types));
            return this;
        }
        public Builder growerItemGroundTag(TagKey<Block> tag) {
            this.growerItemGroundTag = tag;
            return this;
        }
        public Builder boatType(BYGBoatEntity.BYGType type) {
            this.boatType = type;
            return this;
        }
        public Builder materialColor(MaterialColor colour) {
            this.materialColor = colour;
            return this;
        }
        public Builder leavesLightLevel(Integer leavesLightLevel) {
            this.leavesLightLevel = leavesLightLevel;
            return this;
        }
        public Builder nether() {
            this.isNether = true;
            return this;
        }
        public Builder registryName(BlockType blockType, String name) {
            this.registryName.put(blockType, name);
            return this;
        }
        public Builder leavesHaveOverlay() {
            this.leavesHaveOverlay = true;
            return this;
        }
    }
}
