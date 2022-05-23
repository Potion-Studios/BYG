package potionstudios.byg.common.block;

import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_create;
import static potionstudios.byg.mixin.access.WoodTypeAccess.byg_invokeRegister;
import net.minecraft.MethodsReturnNonnullByDefault;
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

@MethodsReturnNonnullByDefault
public enum BYGWoodTypes {
    ASPEN("aspen", BYGBlockTags.GROUND_ASPEN_SAPLING, MaterialColor.TERRACOTTA_YELLOW, BYGBoatEntity.BYGType.ASPEN),
    BAOBAB("baobab", BYGBlockTags.GROUND_BAOBAB_SAPLING, MaterialColor.TERRACOTTA_GREEN, BYGBoatEntity.BYGType.BAOBAB),
    BLUE_ENCHANTED("blue_enchanted", BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, MaterialColor.COLOR_BLUE, BYGBoatEntity.BYGType.BLUE_ENCHANTED);

    private final String name;
    private final WoodType woodType;
    private final TagKey<Block> saplingGroundTag;
    private final MaterialColor materialColor;
    private final BYGBoatEntity.BYGType boatType;
    @Nullable
    private final Integer leavesLightLevel;
    private boolean initialized;

    private BlockRegistryObject<Block> sapling;
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

    BYGWoodTypes(String name, TagKey<Block> saplingGroundTag, MaterialColor materialColor, BYGBoatEntity.BYGType boatType) {
        this(name, saplingGroundTag, materialColor, boatType, null);
    }

    BYGWoodTypes(String name, TagKey<Block> saplingGroundTag, MaterialColor materialColor, BYGBoatEntity.BYGType boatType, @Nullable Integer leavesLightLevel) {
        this.name = name;
        this.saplingGroundTag = saplingGroundTag;
        this.materialColor = materialColor;
        this.boatType = boatType;
        this.woodType = BYGConstants.SIGNS ? byg_invokeRegister(byg_create(BYG.createLocation(name).toString().replace(":", "/"))) : null;
        this.leavesLightLevel = leavesLightLevel;
    }

    public void init() {
        if (initialized)
            return;
        this.sapling = BYGBlocks.createSapling(saplingGroundTag, name + "_sapling");
        BYGItems.createSaplingItem(sapling);
        this.leaves = leavesLightLevel == null ? BYGBlocks.createLeaves(materialColor, name + "_leaves") : BYGBlocks.createGlowingLeaves(materialColor, leavesLightLevel, name + "_leaves");
        BYGItems.createItem(leaves);

        this.log = BYGBlocks.createLog(name + "_log");
        BYGItems.createItem(log);
        this.wood = BYGBlocks.createWood(name + "_wood");
        BYGItems.createItem(wood);
        this.strippedLog = BYGBlocks.createStrippedLog("stripped_" + name + "_log");
        BYGItems.createItem(strippedLog);
        this.strippedWood = BYGBlocks.createWood("stripped_" + name + "_wood");
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

        this.boat = BYGItems.createItem(() -> new BYGBoatItem(boatType, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), name + "_boat");
        initialized = true;
    }

    @Override
    public String toString() {
        return name;
    }

    public BlockRegistryObject<Block> planks() {
        return planks;
    }
    public BlockRegistryObject<Block> sapling() {
        return sapling;
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
}
