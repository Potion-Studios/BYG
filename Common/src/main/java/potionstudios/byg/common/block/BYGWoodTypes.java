package potionstudios.byg.common.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import org.jetbrains.annotations.Nullable;
import potionstudios.byg.BYG;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.mixin.access.BlockSetTypeAccess;
import potionstudios.byg.mixin.access.WoodTypeAccess;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistryObject;
import potionstudios.byg.util.MultiTag;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public enum BYGWoodTypes {

    BULBIS("bulbis", new Builder()
            .MapColor(MapColor.COLOR_BLUE)
            .growerItemGroundTag(BYGBlockTags.GROUND_BULBIS_ODDITY)
            .growerItem(GrowerItemType.ODDITY)
            .exclude(BlockType.LEAVES)
            .registryName(BlockType.WOOD, "%s_wood")
            .registryName(BlockType.STRIPPED_WOOD, "stripped_%s_wood")
            .nether()),
    IMPARIUS("imparius", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_IMPARIUS_MUSHROOM)
            .exclude(BlockType.LEAVES, BlockType.STRIPPED_LOG, BlockType.STRIPPED_WOOD)
            .growerItem(GrowerItemType.MUSHROOM)
            .nether()),
    MAHOGANY("mahogany", new Builder()
            // .growerItemGroundTag(BYGBlockTags.GROUND_WHITE_MANGROVE_SAPLING)
            // .boatType(BYGBoat.BYGType.MAHOGANY)
            .MapColor(MapColor.COLOR_GREEN)
            .leavesHaveOverlay()),
    WILLOW("willow", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_WILLOW_SAPLING)
            // .boatType(BYGBoat.BYGType.WILLOW)
            .MapColor(MapColor.TERRACOTTA_GREEN)
            .leavesHaveOverlay()),
    WITCH_HAZEL("witch_hazel", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING)
            // .boatType(BYGBoat.BYGType.WITCH_HAZEL)
            .MapColor(MapColor.COLOR_ORANGE)),
    SYTHIAN("sythian", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_SYTHIAN_FUNGUS)
            .growerItem(GrowerItemType.FUNGUS)
            .nether()),
    JACARANDA("jacaranda", new Builder()
            .growerItemGroundTag(BYGBlockTags.GROUND_JACARANDA_SAPLING)
            // .boatType(BYGBoat.BYGType.JACARANDA)
            .MapColor(MapColor.TERRACOTTA_PURPLE));


	private final String name;
    private final WoodType woodType;
    private final Builder builder;
    private boolean initialized;

    private final MultiTag logTag;

    private BlockRegistryObject<Block> growerItem;

    @Nullable
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

    private BlockRegistryObject<Block> hangingSign;
    private BlockRegistryObject<Block> wallHangingSign;
    private RegistryObject<HangingSignItem> hangingSignItem;

    BYGWoodTypes(String name, Builder builder) {
        this.name = name;
        this.builder = builder;
        this.woodType = WoodTypeAccess.byg_invokeRegister(builder.woodTypeFactory
                .apply(BYG.createLocation(name).toString().replace(':', '/')));

        BlockSetTypeAccess.byg_invokeRegister(woodType.setType());
        logTag = MultiTag.create(BYG.createLocation(name + "_logs"));
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

        // In Block Family

        if (!builder.excludes.contains(BlockType.LEAVES)) {
            if (builder.isNether)
                this.leaves = BYGBlocks.createBlock(BYGBlockProperties.BYGWartBlock::new, nameOr("%s_wart_block", BlockType.LEAVES));
            else {
                this.leaves = builder.leavesFactory.apply(name + "_leaves");
            }
            BYGItems.createItem(leaves);


        }

        // In Block Family

        this.log = ifAllowed(BlockType.LOG, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("%s_stem", BlockType.LOG)) : BYGBlocks.createLog(nameOr("%s_log", BlockType.LOG)));
        BYGItems.createItem(log);
        this.wood = ifAllowed(BlockType.WOOD, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("%s_hyphae", BlockType.WOOD)) : BYGBlocks.createWood(nameOr("%s_wood", BlockType.WOOD)));
        BYGItems.createItem(wood);
        this.strippedLog = ifAllowed(BlockType.STRIPPED_LOG, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("stripped_%s_stem", BlockType.STRIPPED_LOG)) : BYGBlocks.createStrippedLog(nameOr("stripped_%s_log", BlockType.STRIPPED_LOG)));
        BYGItems.createItem(strippedLog);
        this.strippedWood = ifAllowed(BlockType.STRIPPED_WOOD, () -> builder.isNether ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, nameOr("stripped_%s_hyphae", BlockType.STRIPPED_WOOD)) : BYGBlocks.createWood(nameOr("stripped_%s_wood", BlockType.STRIPPED_WOOD)));
        BYGItems.createItem(strippedWood);

        // In Block Family

        this.planks = BYGBlocks.createPlanks(name + "_planks");
        BYGItems.createItem(planks);
        this.bookshelf = BYGBlocks.createBookshelf(name + "_bookshelf");
        BYGItems.createItem(bookshelf);
        this.craftingTable = BYGBlocks.createCraftingTable(name + "_crafting_table");
        BYGItems.createItem(craftingTable);

        // In Block Family
        this.stairs = BYGBlocks.createWoodStairs(name + "_stairs");
        BYGItems.createItem(stairs);
        this.slab = BYGBlocks.createWoodSlab(name + "_slab");
        BYGItems.createItem(slab);

        // In Block Family
        this.fence = BYGBlocks.createFence(name + "_fence");
        BYGItems.createItem(fence);
        this.fenceGate = BYGBlocks.createFenceGate(name + "_fence_gate", woodType);
        BYGItems.createItem(fenceGate);

        // In Block Family
        this.door = BYGBlocks.createDoor(name + "_door", this.woodType.setType());
        BYGItems.createItem(door);
        this.trapdoor = BYGBlocks.createTrapDoor(name + "_trapdoor", this.woodType.setType());
        BYGItems.createItem(trapdoor);

        // In Block Family
        this.pressurePlate = BYGBlocks.createWoodPressurePlate(name + "_pressure_plate", this.woodType.setType());
        BYGItems.createItem(pressurePlate);
        this.button = BYGBlocks.createWoodButton(name + "_button", this.woodType.setType());
        BYGItems.createItem(button);

        // In Block Family
        this.sign = BYGBlocks.createSign(name + "_sign", woodType, planks);
        this.wallSign = BYGBlocks.createWallSign(name + "_wall_sign", woodType, planks, sign);
        this.signItem = BYGItems.createSign(name + "_sign", sign, wallSign);

        // In Block Family
        this.hangingSign = BYGBlocks.createHangingSign(name + "_hanging_sign", woodType, planks);
        this.wallHangingSign = BYGBlocks.createWallHangingSign(name + "_wall_hanging_sign", woodType, planks, hangingSign);
        this.hangingSignItem = BYGItems.createHangingSign(name + "_hanging_sign", hangingSign, wallHangingSign);


        // if (builder.boatType != null) {
            // this.boat = BYGItems.createItem(() -> new BYGBoatItem(false, builder.boatType, new Item.Properties().stacksTo(1)), name + "_boat");
            // this.chestBoat = BYGItems.createItem(() -> new BYGBoatItem(true, builder.boatType, new Item.Properties().stacksTo(1)), name + "_chest_boat");
        // }
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

    @Nullable
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

    public BlockRegistryObject<Block> hangingSign() {
        return hangingSign;
    }

    public BlockRegistryObject<Block> wallHangingSign() {
        return wallHangingSign;
    }

    public RegistryObject<HangingSignItem> hangingSignItem() {
        return hangingSignItem;
    }

    public MultiTag logTag() {
        return logTag;
    }

    public boolean isNether() {
        return builder.isNether;
    }

    public boolean isFlammable() {
        return builder.flammable;
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

        Function<String, WoodType> woodTypeFactory = s -> new WoodType(s, new BlockSetType(s));

        private GrowerItemType growerItemType = GrowerItemType.SAPLING;
        private final EnumSet<BlockType> excludes = EnumSet.noneOf(BlockType.class);
        private TagKey<Block> growerItemGroundTag = BlockTags.DIRT;
        private MapColor mapColor;
        private Function<String, BlockRegistryObject<Block>> leavesFactory = id -> BYGBlocks.createLeaves(mapColor, id);
        private boolean isNether;
        private boolean flammable = true;
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

        /*
        public Builder boatType(BYGBoat.BYGType type) {
            // this.boatType = type;
            return this;
        } */

        public Builder MapColor(MapColor colour) {
            this.mapColor = colour;
            return this;
        }

        public Builder woodTypeFactory(Function<String, WoodType> factory) {
            this.woodTypeFactory = factory;
            return this;
        }

        public Builder nether() {
            this.isNether = true;
            notFlammable();
            this.woodTypeFactory = s -> new WoodType(s, new BlockSetType(s, true, SoundType.NETHER_WOOD, SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN, SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF, SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON), SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
            return this;
        }

        public Builder end() {
            this.woodTypeFactory = s -> new WoodType(s, new BlockSetType(s, true, SoundType.NETHER_WOOD, SoundEvents.NETHER_WOOD_DOOR_CLOSE, SoundEvents.NETHER_WOOD_DOOR_OPEN, SoundEvents.NETHER_WOOD_TRAPDOOR_CLOSE, SoundEvents.NETHER_WOOD_TRAPDOOR_OPEN, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_OFF, SoundEvents.NETHER_WOOD_PRESSURE_PLATE_CLICK_ON, SoundEvents.NETHER_WOOD_BUTTON_CLICK_OFF, SoundEvents.NETHER_WOOD_BUTTON_CLICK_ON), SoundType.NETHER_WOOD, SoundType.NETHER_WOOD_HANGING_SIGN, SoundEvents.NETHER_WOOD_FENCE_GATE_CLOSE, SoundEvents.NETHER_WOOD_FENCE_GATE_OPEN);
            return this;
        }

        public Builder notFlammable() {
            this.flammable = false;
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

        public Builder leavesFactory(Function<String, BlockRegistryObject<Block>> leavesFactory) {
            this.leavesFactory = leavesFactory;
            return this;
        }
    }
}
