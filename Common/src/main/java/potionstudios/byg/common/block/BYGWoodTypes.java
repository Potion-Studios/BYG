package potionstudios.byg.common.block;

import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_create;
import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_invokeRegister;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.common.item.BYGBoatItem;
import potionstudios.byg.common.item.BYGCreativeTab;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;
import java.util.Set;

public enum BYGWoodTypes {
    ASPEN("aspen", BYGBlockTags.GROUND_ASPEN_SAPLING, MaterialColor.TERRACOTTA_YELLOW, BYGBoatEntity.BYGType.ASPEN),
    BAOBAB("baobab", BYGBlockTags.GROUND_BAOBAB_SAPLING, MaterialColor.TERRACOTTA_GREEN, BYGBoatEntity.BYGType.BAOBAB),
    BLUE_ENCHANTED("blue_enchanted", BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, MaterialColor.COLOR_BLUE, BYGBoatEntity.BYGType.BLUE_ENCHANTED),
    BULBIS("bulbis", BYGBlockTags.GROUND_BULBIS_ODDITY, MaterialColor.COLOR_BLUE, null, null, GrowerItemType.ODDITY, true, Excludable.LEAVES);

    private final String name;
    private final WoodType woodType;
    private final TagKey<Block> saplingGroundTag;
    private final MaterialColor materialColor;
    private final BYGBoatEntity.BYGType boatType;
    private final GrowerItemType growerItemType;
    private final Set<Excludable> excludables;
    private final boolean isStem;
    @Nullable
    private final Integer leavesLightLevel;
    private boolean initialized;

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

    private RegistryObject<Item> boat;

    BYGWoodTypes(String name, TagKey<Block> saplingGroundTag, MaterialColor materialColor, @Nullable BYGBoatEntity.BYGType boatType, Excludable... excludables) {
        this(name, saplingGroundTag, materialColor, boatType, null, GrowerItemType.SAPLING, false, excludables);
    }

    BYGWoodTypes(String name, TagKey<Block> saplingGroundTag, MaterialColor materialColor, @Nullable BYGBoatEntity.BYGType boatType, @Nullable Integer leavesLightLevel, GrowerItemType growerItemType, boolean isStem, Excludable... excludables) {
        this.name = name;
        this.saplingGroundTag = saplingGroundTag;
        this.materialColor = materialColor;
        this.boatType = boatType;
        this.woodType = BYGConstants.SIGNS ? byg_invokeRegister(byg_create(BYG.createLocation(name).toString().replace(":", "/"))) : null;
        this.isStem = isStem;
        this.growerItemType = growerItemType;
        this.leavesLightLevel = leavesLightLevel;
        this.excludables =  Set.of(excludables);
    }

    public void init() {
        if (initialized)
            return;
        this.growerItem = switch (growerItemType) {
            case SAPLING -> BYGBlocks.createSapling(saplingGroundTag, name + "_sapling");
            case ODDITY -> BYGBlocks.createMushroom(saplingGroundTag, name + "_oddity");
            case FUNGUS -> BYGBlocks.createMushroom(saplingGroundTag, name + "_fungus");
        };
        BYGItems.createGrowerItem(growerItem, growerItemType == GrowerItemType.SAPLING);
        if (!excludables.contains(Excludable.LEAVES)) {
            this.leaves = leavesLightLevel == null ? BYGBlocks.createLeaves(materialColor, name + "_leaves") : BYGBlocks.createGlowingLeaves(materialColor, leavesLightLevel, name + "_leaves");
            BYGItems.createItem(leaves);
        }

        this.log = isStem ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, name + "_stem") : BYGBlocks.createLog(name + "_log");
        BYGItems.createItem(log);
        this.wood = isStem ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, name + "_wood") : BYGBlocks.createWood(name + "_wood");
        BYGItems.createItem(wood);
        this.strippedLog = isStem ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + name + "_stem") : BYGBlocks.createStrippedLog("stripped_" + name + "_log");
        BYGItems.createItem(strippedLog);
        this.strippedWood = isStem ? BYGBlocks.createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_" + name + "_wood") : BYGBlocks.createWood("stripped_" + name + "_wood");
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

        if (boatType != null) {
            this.boat = BYGItems.createItem(() -> new BYGBoatItem(boatType, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), name + "_boat");
        }
        initialized = true;
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

    public RegistryObject<Item> boat() {
        return boat;
    }

    public static void loadClass() {}

    public enum GrowerItemType {
        SAPLING,
        ODDITY,
        FUNGUS
    }

    public enum Excludable {
        LEAVES
    }
}
