package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.NetherFeatures;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.byg.BYG;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.client.textures.BYGMaterials;
import potionstudios.byg.common.block.end.*;
import potionstudios.byg.common.block.end.bulbisgardens.TallBulbisBlock;
import potionstudios.byg.common.block.end.impariusgrove.FungalImpariusFilamentBlock;
import potionstudios.byg.common.block.end.impariusgrove.ImpariusVineBlock;
import potionstudios.byg.common.block.end.impariusgrove.ImpariusVinePlantBlock;
import potionstudios.byg.common.block.end.impariusgrove.TreeBranchBlock;
import potionstudios.byg.common.block.end.nightshade.NightshadeBerryBushBlock;
import potionstudios.byg.common.block.end.shattereddesert.OddityCactusBlock;
import potionstudios.byg.common.block.end.shulkrenforest.ShulkrenVineBlock;
import potionstudios.byg.common.block.end.shulkrenforest.ShulkrenVinePlantBlock;
import potionstudios.byg.common.block.end.viscalisle.SculkGrowthBlock;
import potionstudios.byg.common.block.nether.BoricFireBlock;
import potionstudios.byg.common.block.nether.CrystalBlock;
import potionstudios.byg.common.block.nether.HypogealImperiumBlock;
import potionstudios.byg.common.block.nether.crimson.CrimsonBerryBushBlock;
import potionstudios.byg.common.block.nether.embur.EmburVineBlock;
import potionstudios.byg.common.block.nether.embur.EmburVinePlantBlock;
import potionstudios.byg.common.block.nether.subzerohypogeal.BuddingSubzeroCrystalBlock;
import potionstudios.byg.common.block.nether.wailing.WailingBulbBlossomBlock;
import potionstudios.byg.common.block.nether.wailing.WailingPlantBlock;
import potionstudios.byg.common.block.nether.warped.WarpedCactusBlock;
import potionstudios.byg.common.block.sapling.BYGSapling;
import potionstudios.byg.common.entity.BYGEntityTags;
import potionstudios.byg.common.world.feature.features.end.BYGEndFeatures;
import potionstudios.byg.common.world.feature.features.end.BYGEndVegetationFeatures;
import potionstudios.byg.common.world.feature.features.nether.BYGNetherVegetationFeatures;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGHugeMushroom;
import potionstudios.byg.common.world.feature.gen.overworld.mushrooms.util.BYGMushroomToHugeMushroom;
import potionstudios.byg.common.world.feature.gen.overworld.trees.TreeSpawners;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.TreeSpawner;
import potionstudios.byg.mixin.access.*;
import potionstudios.byg.registration.BlockRegistryObject;
import potionstudios.byg.registration.RegistrationProvider;
import potionstudios.byg.util.CommonSetupLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

@SuppressWarnings("ALL")
public class BYGBlocks {
    public static final RegistrationProvider<Block> PROVIDER = RegistrationProvider.get(Registry.BLOCK_REGISTRY, BYG.MOD_ID);

    public static List<BlockRegistryObject<Block>> flowerPotBlocks = new ArrayList<>();

    public static final BlockRegistryObject<Block> ASPEN_PLANKS = createPlanks("aspen_planks");
    public static final BlockRegistryObject<Block> BAOBAB_PLANKS = createPlanks("baobab_planks");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_PLANKS = createPlanks("blue_enchanted_planks");
    public static final BlockRegistryObject<Block> CHERRY_PLANKS = createPlanks("cherry_planks");
    public static final BlockRegistryObject<Block> CIKA_PLANKS = createPlanks("cika_planks");
    public static final BlockRegistryObject<Block> CYPRESS_PLANKS = createPlanks("cypress_planks");
    public static final BlockRegistryObject<Block> EBONY_PLANKS = createPlanks("ebony_planks");
    public static final BlockRegistryObject<Block> FIR_PLANKS = createPlanks("fir_planks");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_PLANKS = createPlanks("green_enchanted_planks");
    public static final BlockRegistryObject<Block> HOLLY_PLANKS = createPlanks("holly_planks");
    public static final BlockRegistryObject<Block> JACARANDA_PLANKS = createPlanks("jacaranda_planks");
    public static final BlockRegistryObject<Block> MAHOGANY_PLANKS = createPlanks("mahogany_planks");
    public static final BlockRegistryObject<Block> MANGROVE_PLANKS = createPlanks("mangrove_planks");
    public static final BlockRegistryObject<Block> MAPLE_PLANKS = createPlanks("maple_planks");
    public static final BlockRegistryObject<Block> PINE_PLANKS = createPlanks("pine_planks");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_PLANKS = createPlanks("rainbow_eucalyptus_planks");
    public static final BlockRegistryObject<Block> REDWOOD_PLANKS = createPlanks("redwood_planks");
    public static final BlockRegistryObject<Block> SKYRIS_PLANKS = createPlanks("skyris_planks");
    public static final BlockRegistryObject<Block> WILLOW_PLANKS = createPlanks("willow_planks");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_PLANKS = createPlanks("witch_hazel_planks");
    public static final BlockRegistryObject<Block> ZELKOVA_PLANKS = createPlanks("zelkova_planks");
    public static final BlockRegistryObject<Block> SYTHIAN_PLANKS = createPlanks("sythian_planks");
    public static final BlockRegistryObject<Block> EMBUR_PLANKS = createPlanks("embur_planks");
    public static final BlockRegistryObject<Block> PALM_PLANKS = createPlanks("palm_planks");
    public static final BlockRegistryObject<Block> LAMENT_PLANKS = createPlanks("lament_planks");
    public static final BlockRegistryObject<Block> BULBIS_PLANKS = createPlanks("bulbis_planks");
    public static final BlockRegistryObject<Block> NIGHTSHADE_PLANKS = createPlanks("nightshade_planks");
    public static final BlockRegistryObject<Block> ETHER_PLANKS = createPlanks("ether_planks");
    public static final BlockRegistryObject<Block> IMPARIUS_PLANKS = createPlanks("imparius_planks");

    public static final BlockRegistryObject<Block> ASPEN_BOOKSHELF = createBookshelf("aspen_bookshelf");
    public static final BlockRegistryObject<Block> BAOBAB_BOOKSHELF = createBookshelf("baobab_bookshelf");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_BOOKSHELF = createBookshelf("blue_enchanted_bookshelf");
    public static final BlockRegistryObject<Block> CHERRY_BOOKSHELF = createBookshelf("cherry_bookshelf");
    public static final BlockRegistryObject<Block> CIKA_BOOKSHELF = createBookshelf("cika_bookshelf");
    public static final BlockRegistryObject<Block> CYPRESS_BOOKSHELF = createBookshelf("cypress_bookshelf");
    public static final BlockRegistryObject<Block> EBONY_BOOKSHELF = createBookshelf("ebony_bookshelf");
    public static final BlockRegistryObject<Block> FIR_BOOKSHELF = createBookshelf("fir_bookshelf");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_BOOKSHELF = createBookshelf("green_enchanted_bookshelf");
    public static final BlockRegistryObject<Block> HOLLY_BOOKSHELF = createBookshelf("holly_bookshelf");
    public static final BlockRegistryObject<Block> JACARANDA_BOOKSHELF = createBookshelf("jacaranda_bookshelf");
    public static final BlockRegistryObject<Block> MAHOGANY_BOOKSHELF = createBookshelf("mahogany_bookshelf");
    public static final BlockRegistryObject<Block> MANGROVE_BOOKSHELF = createBookshelf("mangrove_bookshelf");
    public static final BlockRegistryObject<Block> MAPLE_BOOKSHELF = createBookshelf("maple_bookshelf");
    public static final BlockRegistryObject<Block> PINE_BOOKSHELF = createBookshelf("pine_bookshelf");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_BOOKSHELF = createBookshelf("rainbow_eucalyptus_bookshelf");
    public static final BlockRegistryObject<Block> REDWOOD_BOOKSHELF = createBookshelf("redwood_bookshelf");
    public static final BlockRegistryObject<Block> SKYRIS_BOOKSHELF = createBookshelf("skyris_bookshelf");
    public static final BlockRegistryObject<Block> WILLOW_BOOKSHELF = createBookshelf("willow_bookshelf");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_BOOKSHELF = createBookshelf("witch_hazel_bookshelf");
    public static final BlockRegistryObject<Block> ZELKOVA_BOOKSHELF = createBookshelf("zelkova_bookshelf");
    public static final BlockRegistryObject<Block> SYTHIAN_BOOKSHELF = createBookshelf("sythian_bookshelf");
    public static final BlockRegistryObject<Block> EMBUR_BOOKSHELF = createBookshelf("embur_bookshelf");
    public static final BlockRegistryObject<Block> PALM_BOOKSHELF = createBookshelf("palm_bookshelf");
    public static final BlockRegistryObject<Block> LAMENT_BOOKSHELF = createBookshelf("lament_bookshelf");
    public static final BlockRegistryObject<Block> BULBIS_BOOKSHELF = createBookshelf("bulbis_bookshelf");
    public static final BlockRegistryObject<Block> NIGHTSHADE_BOOKSHELF = createBookshelf("nightshade_bookshelf");
    public static final BlockRegistryObject<Block> ETHER_BOOKSHELF = createBookshelf("ether_bookshelf");
    public static final BlockRegistryObject<Block> IMPARIUS_BOOKSHELF = createBookshelf("imparius_bookshelf");

    public static final BlockRegistryObject<Block> ASPEN_DOOR = createDoor("aspen_door");
    public static final BlockRegistryObject<Block> BAOBAB_DOOR = createDoor("baobab_door");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_DOOR = createDoor("blue_enchanted_door");
    public static final BlockRegistryObject<Block> CHERRY_DOOR = createDoor("cherry_door");
    public static final BlockRegistryObject<Block> CIKA_DOOR = createDoor("cika_door");
    public static final BlockRegistryObject<Block> CYPRESS_DOOR = createDoor("cypress_door");
    public static final BlockRegistryObject<Block> EBONY_DOOR = createDoor("ebony_door");
    public static final BlockRegistryObject<Block> FIR_DOOR = createDoor("fir_door");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_DOOR = createDoor("green_enchanted_door");
    public static final BlockRegistryObject<Block> HOLLY_DOOR = createDoor("holly_door");
    public static final BlockRegistryObject<Block> JACARANDA_DOOR = createDoor("jacaranda_door");
    public static final BlockRegistryObject<Block> MAHOGANY_DOOR = createDoor("mahogany_door");
    public static final BlockRegistryObject<Block> MANGROVE_DOOR = createDoor("mangrove_door");
    public static final BlockRegistryObject<Block> MAPLE_DOOR = createDoor("maple_door");
    public static final BlockRegistryObject<Block> PINE_DOOR = createDoor("pine_door");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_DOOR = createDoor("rainbow_eucalyptus_door");
    public static final BlockRegistryObject<Block> REDWOOD_DOOR = createDoor("redwood_door");
    public static final BlockRegistryObject<Block> SKYRIS_DOOR = createDoor("skyris_door");
    public static final BlockRegistryObject<Block> WILLOW_DOOR = createDoor("willow_door");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_DOOR = createDoor("witch_hazel_door");
    public static final BlockRegistryObject<Block> ZELKOVA_DOOR = createDoor("zelkova_door");
    public static final BlockRegistryObject<Block> SYTHIAN_DOOR = createDoor("sythian_door");
    public static final BlockRegistryObject<Block> EMBUR_DOOR = createDoor("embur_door");
    public static final BlockRegistryObject<Block> PALM_DOOR = createDoor("palm_door");
    public static final BlockRegistryObject<Block> LAMENT_DOOR = createDoor("lament_door");
    public static final BlockRegistryObject<Block> BULBIS_DOOR = createDoor("bulbis_door");
    public static final BlockRegistryObject<Block> NIGHTSHADE_DOOR = createDoor("nightshade_door");
    public static final BlockRegistryObject<Block> ETHER_DOOR = createDoor("ether_door");
    public static final BlockRegistryObject<Block> IMPARIUS_DOOR = createDoor("imparius_door");

    public static final BlockRegistryObject<Block> ASPEN_PRESSURE_PLATE = createWoodPressurePlate("aspen_pressure_plate");
    public static final BlockRegistryObject<Block> BAOBAB_PRESSURE_PLATE = createWoodPressurePlate("baobab_pressure_plate");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_PRESSURE_PLATE = createWoodPressurePlate("blue_enchanted_pressure_plate");
    public static final BlockRegistryObject<Block> CHERRY_PRESSURE_PLATE = createWoodPressurePlate("cherry_pressure_plate");
    public static final BlockRegistryObject<Block> CIKA_PRESSURE_PLATE = createWoodPressurePlate("cika_pressure_plate");
    public static final BlockRegistryObject<Block> CYPRESS_PRESSURE_PLATE = createWoodPressurePlate("cypress_pressure_plate");
    public static final BlockRegistryObject<Block> EBONY_PRESSURE_PLATE = createWoodPressurePlate("ebony_pressure_plate");
    public static final BlockRegistryObject<Block> FIR_PRESSURE_PLATE = createWoodPressurePlate("fir_pressure_plate");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_PRESSURE_PLATE = createWoodPressurePlate("green_enchanted_pressure_plate");
    public static final BlockRegistryObject<Block> HOLLY_PRESSURE_PLATE = createWoodPressurePlate("holly_pressure_plate");
    public static final BlockRegistryObject<Block> JACARANDA_PRESSURE_PLATE = createWoodPressurePlate("jacaranda_pressure_plate");
    public static final BlockRegistryObject<Block> MAHOGANY_PRESSURE_PLATE = createWoodPressurePlate("mahogany_pressure_plate");
    public static final BlockRegistryObject<Block> MANGROVE_PRESSURE_PLATE = createWoodPressurePlate("mangrove_pressure_plate");
    public static final BlockRegistryObject<Block> MAPLE_PRESSURE_PLATE = createWoodPressurePlate("maple_pressure_plate");
    public static final BlockRegistryObject<Block> PINE_PRESSURE_PLATE = createWoodPressurePlate("pine_pressure_plate");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_PRESSURE_PLATE = createWoodPressurePlate("rainbow_eucalyptus_pressure_plate");
    public static final BlockRegistryObject<Block> REDWOOD_PRESSURE_PLATE = createWoodPressurePlate("redwood_pressure_plate");
    public static final BlockRegistryObject<Block> SKYRIS_PRESSURE_PLATE = createWoodPressurePlate("skyris_pressure_plate");
    public static final BlockRegistryObject<Block> WILLOW_PRESSURE_PLATE = createWoodPressurePlate("willow_pressure_plate");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_PRESSURE_PLATE = createWoodPressurePlate("witch_hazel_pressure_plate");
    public static final BlockRegistryObject<Block> ZELKOVA_PRESSURE_PLATE = createWoodPressurePlate("zelkova_pressure_plate");
    public static final BlockRegistryObject<Block> SYTHIAN_PRESSURE_PLATE = createWoodPressurePlate("sythian_pressure_plate");
    public static final BlockRegistryObject<Block> EMBUR_PRESSURE_PLATE = createWoodPressurePlate("embur_pressure_plate");
    public static final BlockRegistryObject<Block> PALM_PRESSURE_PLATE = createWoodPressurePlate("palm_pressure_plate");
    public static final BlockRegistryObject<Block> LAMENT_PRESSURE_PLATE = createWoodPressurePlate("lament_pressure_plate");
    public static final BlockRegistryObject<Block> BULBIS_PRESSURE_PLATE = createWoodPressurePlate("bulbis_pressure_plate");
    public static final BlockRegistryObject<Block> NIGHTSHADE_PRESSURE_PLATE = createWoodPressurePlate("nightshade_pressure_plate");
    public static final BlockRegistryObject<Block> ETHER_PRESSURE_PLATE = createWoodPressurePlate("ether_pressure_plate");
    public static final BlockRegistryObject<Block> IMPARIUS_PRESSURE_PLATE = createWoodPressurePlate("imparius_pressure_plate");

    public static final BlockRegistryObject<Block> ASPEN_BUTTON = createWoodButton("aspen_button");
    public static final BlockRegistryObject<Block> BAOBAB_BUTTON = createWoodButton("baobab_button");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_BUTTON = createWoodButton("blue_enchanted_button");
    public static final BlockRegistryObject<Block> CHERRY_BUTTON = createWoodButton("cherry_button");
    public static final BlockRegistryObject<Block> CIKA_BUTTON = createWoodButton("cika_button");
    public static final BlockRegistryObject<Block> CYPRESS_BUTTON = createWoodButton("cypress_button");
    public static final BlockRegistryObject<Block> EBONY_BUTTON = createWoodButton("ebony_button");
    public static final BlockRegistryObject<Block> FIR_BUTTON = createWoodButton("fir_button");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_BUTTON = createWoodButton("green_enchanted_button");
    public static final BlockRegistryObject<Block> HOLLY_BUTTON = createWoodButton("holly_button");
    public static final BlockRegistryObject<Block> JACARANDA_BUTTON = createWoodButton("jacaranda_button");
    public static final BlockRegistryObject<Block> MAHOGANY_BUTTON = createWoodButton("mahogany_button");
    public static final BlockRegistryObject<Block> MANGROVE_BUTTON = createWoodButton("mangrove_button");
    public static final BlockRegistryObject<Block> MAPLE_BUTTON = createWoodButton("maple_button");
    public static final BlockRegistryObject<Block> PINE_BUTTON = createWoodButton("pine_button");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_BUTTON = createWoodButton("rainbow_eucalyptus_button");
    public static final BlockRegistryObject<Block> REDWOOD_BUTTON = createWoodButton("redwood_button");
    public static final BlockRegistryObject<Block> SKYRIS_BUTTON = createWoodButton("skyris_button");
    public static final BlockRegistryObject<Block> WILLOW_BUTTON = createWoodButton("willow_button");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_BUTTON = createWoodButton("witch_hazel_button");
    public static final BlockRegistryObject<Block> ZELKOVA_BUTTON = createWoodButton("zelkova_button");
    public static final BlockRegistryObject<Block> SYTHIAN_BUTTON = createWoodButton("sythian_button");
    public static final BlockRegistryObject<Block> EMBUR_BUTTON = createWoodButton("embur_button");
    public static final BlockRegistryObject<Block> PALM_BUTTON = createWoodButton("palm_button");
    public static final BlockRegistryObject<Block> LAMENT_BUTTON = createWoodButton("lament_button");
    public static final BlockRegistryObject<Block> BULBIS_BUTTON = createWoodButton("bulbis_button");
    public static final BlockRegistryObject<Block> NIGHTSHADE_BUTTON = createWoodButton("nightshade_button");
    public static final BlockRegistryObject<Block> ETHER_BUTTON = createWoodButton("ether_button");
    public static final BlockRegistryObject<Block> IMPARIUS_BUTTON = createWoodButton("imparius_button");

    public static final BlockRegistryObject<Block> ASPEN_TRAPDOOR = createTrapDoor("aspen_trapdoor");
    public static final BlockRegistryObject<Block> BAOBAB_TRAPDOOR = createTrapDoor("baobab_trapdoor");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_TRAPDOOR = createTrapDoor("blue_enchanted_trapdoor");
    public static final BlockRegistryObject<Block> CHERRY_TRAPDOOR = createTrapDoor("cherry_trapdoor");
    public static final BlockRegistryObject<Block> CIKA_TRAPDOOR = createTrapDoor("cika_trapdoor");
    public static final BlockRegistryObject<Block> CYPRESS_TRAPDOOR = createTrapDoor("cypress_trapdoor");
    public static final BlockRegistryObject<Block> EBONY_TRAPDOOR = createTrapDoor("ebony_trapdoor");
    public static final BlockRegistryObject<Block> FIR_TRAPDOOR = createTrapDoor("fir_trapdoor");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_TRAPDOOR = createTrapDoor("green_enchanted_trapdoor");
    public static final BlockRegistryObject<Block> HOLLY_TRAPDOOR = createTrapDoor("holly_trapdoor");
    public static final BlockRegistryObject<Block> JACARANDA_TRAPDOOR = createTrapDoor("jacaranda_trapdoor");
    public static final BlockRegistryObject<Block> MAHOGANY_TRAPDOOR = createTrapDoor("mahogany_trapdoor");
    public static final BlockRegistryObject<Block> MANGROVE_TRAPDOOR = createTrapDoor("mangrove_trapdoor");
    public static final BlockRegistryObject<Block> MAPLE_TRAPDOOR = createTrapDoor("maple_trapdoor");
    public static final BlockRegistryObject<Block> PINE_TRAPDOOR = createTrapDoor("pine_trapdoor");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_TRAPDOOR = createTrapDoor("rainbow_eucalyptus_trapdoor");
    public static final BlockRegistryObject<Block> REDWOOD_TRAPDOOR = createTrapDoor("redwood_trapdoor");
    public static final BlockRegistryObject<Block> SKYRIS_TRAPDOOR = createTrapDoor("skyris_trapdoor");
    public static final BlockRegistryObject<Block> WILLOW_TRAPDOOR = createTrapDoor("willow_trapdoor");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_TRAPDOOR = createTrapDoor("witch_hazel_trapdoor");
    public static final BlockRegistryObject<Block> ZELKOVA_TRAPDOOR = createTrapDoor("zelkova_trapdoor");
    public static final BlockRegistryObject<Block> SYTHIAN_TRAPDOOR = createTrapDoor("sythian_trapdoor");
    public static final BlockRegistryObject<Block> EMBUR_TRAPDOOR = createTrapDoor("embur_trapdoor");
    public static final BlockRegistryObject<Block> PALM_TRAPDOOR = createTrapDoor("palm_trapdoor");
    public static final BlockRegistryObject<Block> LAMENT_TRAPDOOR = createTrapDoor("lament_trapdoor");
    public static final BlockRegistryObject<Block> BULBIS_TRAPDOOR = createTrapDoor("bulbis_trapdoor");
    public static final BlockRegistryObject<Block> NIGHTSHADE_TRAPDOOR = createTrapDoor("nightshade_trapdoor");
    public static final BlockRegistryObject<Block> ETHER_TRAPDOOR = createTrapDoor("ether_trapdoor");
    public static final BlockRegistryObject<Block> IMPARIUS_TRAPDOOR = createTrapDoor("imparius_trapdoor");

    public static final BlockRegistryObject<Block> ASPEN_CRAFTING_TABLE = createCraftingTable("aspen_crafting_table");
    public static final BlockRegistryObject<Block> BAOBAB_CRAFTING_TABLE = createCraftingTable("baobab_crafting_table");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_CRAFTING_TABLE = createCraftingTable("blue_enchanted_crafting_table");
    public static final BlockRegistryObject<Block> CHERRY_CRAFTING_TABLE = createCraftingTable("cherry_crafting_table");
    public static final BlockRegistryObject<Block> CIKA_CRAFTING_TABLE = createCraftingTable("cika_crafting_table");
    public static final BlockRegistryObject<Block> CYPRESS_CRAFTING_TABLE = createCraftingTable("cypress_crafting_table");
    public static final BlockRegistryObject<Block> EBONY_CRAFTING_TABLE = createCraftingTable("ebony_crafting_table");
    public static final BlockRegistryObject<Block> FIR_CRAFTING_TABLE = createCraftingTable("fir_crafting_table");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_CRAFTING_TABLE = createCraftingTable("green_enchanted_crafting_table");
    public static final BlockRegistryObject<Block> HOLLY_CRAFTING_TABLE = createCraftingTable("holly_crafting_table");
    public static final BlockRegistryObject<Block> JACARANDA_CRAFTING_TABLE = createCraftingTable("jacaranda_crafting_table");
    public static final BlockRegistryObject<Block> MAHOGANY_CRAFTING_TABLE = createCraftingTable("mahogany_crafting_table");
    public static final BlockRegistryObject<Block> MANGROVE_CRAFTING_TABLE = createCraftingTable("mangrove_crafting_table");
    public static final BlockRegistryObject<Block> MAPLE_CRAFTING_TABLE = createCraftingTable("maple_crafting_table");
    public static final BlockRegistryObject<Block> PINE_CRAFTING_TABLE = createCraftingTable("pine_crafting_table");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_CRAFTING_TABLE = createCraftingTable("rainbow_eucalyptus_crafting_table");
    public static final BlockRegistryObject<Block> REDWOOD_CRAFTING_TABLE = createCraftingTable("redwood_crafting_table");
    public static final BlockRegistryObject<Block> SKYRIS_CRAFTING_TABLE = createCraftingTable("skyris_crafting_table");
    public static final BlockRegistryObject<Block> WILLOW_CRAFTING_TABLE = createCraftingTable("willow_crafting_table");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_CRAFTING_TABLE = createCraftingTable("witch_hazel_crafting_table");
    public static final BlockRegistryObject<Block> ZELKOVA_CRAFTING_TABLE = createCraftingTable("zelkova_crafting_table");
    public static final BlockRegistryObject<Block> SYTHIAN_CRAFTING_TABLE = createCraftingTable("sythian_crafting_table");
    public static final BlockRegistryObject<Block> EMBUR_CRAFTING_TABLE = createCraftingTable("embur_crafting_table");
    public static final BlockRegistryObject<Block> PALM_CRAFTING_TABLE = createCraftingTable("palm_crafting_table");
    public static final BlockRegistryObject<Block> LAMENT_CRAFTING_TABLE = createCraftingTable("lament_crafting_table");
    public static final BlockRegistryObject<Block> BULBIS_CRAFTING_TABLE = createCraftingTable("bulbis_crafting_table");
    public static final BlockRegistryObject<Block> NIGHTSHADE_CRAFTING_TABLE = createCraftingTable("nightshade_crafting_table");
    public static final BlockRegistryObject<Block> ETHER_CRAFTING_TABLE = createCraftingTable("ether_crafting_table");
    public static final BlockRegistryObject<Block> IMPARIUS_CRAFTING_TABLE = createCraftingTable("imparius_crafting_table");

    public static final BlockRegistryObject<Block> ASPEN_FENCE_GATE = createFenceGate("aspen_fence_gate");
    public static final BlockRegistryObject<Block> BAOBAB_FENCE_GATE = createFenceGate("baobab_fence_gate");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_FENCE_GATE = createFenceGate("blue_enchanted_fence_gate");
    public static final BlockRegistryObject<Block> CHERRY_FENCE_GATE = createFenceGate("cherry_fence_gate");
    public static final BlockRegistryObject<Block> CIKA_FENCE_GATE = createFenceGate("cika_fence_gate");
    public static final BlockRegistryObject<Block> CYPRESS_FENCE_GATE = createFenceGate("cypress_fence_gate");
    public static final BlockRegistryObject<Block> EBONY_FENCE_GATE = createFenceGate("ebony_fence_gate");
    public static final BlockRegistryObject<Block> FIR_FENCE_GATE = createFenceGate("fir_fence_gate");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_FENCE_GATE = createFenceGate("green_enchanted_fence_gate");
    public static final BlockRegistryObject<Block> HOLLY_FENCE_GATE = createFenceGate("holly_fence_gate");
    public static final BlockRegistryObject<Block> JACARANDA_FENCE_GATE = createFenceGate("jacaranda_fence_gate");
    public static final BlockRegistryObject<Block> MAHOGANY_FENCE_GATE = createFenceGate("mahogany_fence_gate");
    public static final BlockRegistryObject<Block> MANGROVE_FENCE_GATE = createFenceGate("mangrove_fence_gate");
    public static final BlockRegistryObject<Block> MAPLE_FENCE_GATE = createFenceGate("maple_fence_gate");
    public static final BlockRegistryObject<Block> PINE_FENCE_GATE = createFenceGate("pine_fence_gate");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_FENCE_GATE = createFenceGate("rainbow_eucalyptus_fence_gate");
    public static final BlockRegistryObject<Block> REDWOOD_FENCE_GATE = createFenceGate("redwood_fence_gate");
    public static final BlockRegistryObject<Block> SKYRIS_FENCE_GATE = createFenceGate("skyris_fence_gate");
    public static final BlockRegistryObject<Block> WILLOW_FENCE_GATE = createFenceGate("willow_fence_gate");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_FENCE_GATE = createFenceGate("witch_hazel_fence_gate");
    public static final BlockRegistryObject<Block> ZELKOVA_FENCE_GATE = createFenceGate("zelkova_fence_gate");
    public static final BlockRegistryObject<Block> SYTHIAN_FENCE_GATE = createFenceGate("sythian_fence_gate");
    public static final BlockRegistryObject<Block> EMBUR_FENCE_GATE = createFenceGate("embur_fence_gate");
    public static final BlockRegistryObject<Block> PALM_FENCE_GATE = createFenceGate("palm_fence_gate");
    public static final BlockRegistryObject<Block> LAMENT_FENCE_GATE = createFenceGate("lament_fence_gate");
    public static final BlockRegistryObject<Block> BULBIS_FENCE_GATE = createFenceGate("bulbis_fence_gate");
    public static final BlockRegistryObject<Block> NIGHTSHADE_FENCE_GATE = createFenceGate("nightshade_fence_gate");
    public static final BlockRegistryObject<Block> ETHER_FENCE_GATE = createFenceGate("ether_fence_gate");
    public static final BlockRegistryObject<Block> IMPARIUS_FENCE_GATE = createFenceGate("imparius_fence_gate");

    public static final BlockRegistryObject<Block> ASPEN_SLAB = createWoodSlab("aspen_slab");
    public static final BlockRegistryObject<Block> BAOBAB_SLAB = createWoodSlab("baobab_slab");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_SLAB = createWoodSlab("blue_enchanted_slab");
    public static final BlockRegistryObject<Block> CHERRY_SLAB = createWoodSlab("cherry_slab");
    public static final BlockRegistryObject<Block> CIKA_SLAB = createWoodSlab("cika_slab");
    public static final BlockRegistryObject<Block> CYPRESS_SLAB = createWoodSlab("cypress_slab");
    public static final BlockRegistryObject<Block> EBONY_SLAB = createWoodSlab("ebony_slab");
    public static final BlockRegistryObject<Block> FIR_SLAB = createWoodSlab("fir_slab");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_SLAB = createWoodSlab("green_enchanted_slab");
    public static final BlockRegistryObject<Block> HOLLY_SLAB = createWoodSlab("holly_slab");
    public static final BlockRegistryObject<Block> JACARANDA_SLAB = createWoodSlab("jacaranda_slab");
    public static final BlockRegistryObject<Block> MAHOGANY_SLAB = createWoodSlab("mahogany_slab");
    public static final BlockRegistryObject<Block> MANGROVE_SLAB = createWoodSlab("mangrove_slab");
    public static final BlockRegistryObject<Block> MAPLE_SLAB = createWoodSlab("maple_slab");
    public static final BlockRegistryObject<Block> PINE_SLAB = createWoodSlab("pine_slab");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_SLAB = createWoodSlab("rainbow_eucalyptus_slab");
    public static final BlockRegistryObject<Block> REDWOOD_SLAB = createWoodSlab("redwood_slab");
    public static final BlockRegistryObject<Block> SKYRIS_SLAB = createWoodSlab("skyris_slab");
    public static final BlockRegistryObject<Block> WILLOW_SLAB = createWoodSlab("willow_slab");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_SLAB = createWoodSlab("witch_hazel_slab");
    public static final BlockRegistryObject<Block> ZELKOVA_SLAB = createWoodSlab("zelkova_slab");
    public static final BlockRegistryObject<Block> SYTHIAN_SLAB = createWoodSlab("sythian_slab");
    public static final BlockRegistryObject<Block> EMBUR_SLAB = createWoodSlab("embur_slab");
    public static final BlockRegistryObject<Block> PALM_SLAB = createWoodSlab("palm_slab");
    public static final BlockRegistryObject<Block> LAMENT_SLAB = createWoodSlab("lament_slab");
    public static final BlockRegistryObject<Block> BULBIS_SLAB = createWoodSlab("bulbis_slab");
    public static final BlockRegistryObject<Block> NIGHTSHADE_SLAB = createWoodSlab("nightshade_slab");
    public static final BlockRegistryObject<Block> ETHER_SLAB = createWoodSlab("ether_slab");
    public static final BlockRegistryObject<Block> IMPARIUS_SLAB = createWoodSlab("imparius_slab");

    public static final BlockRegistryObject<Block> ASPEN_STAIRS = createWoodStairs("aspen_stairs");
    public static final BlockRegistryObject<Block> BAOBAB_STAIRS = createWoodStairs("baobab_stairs");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_STAIRS = createWoodStairs("blue_enchanted_stairs");
    public static final BlockRegistryObject<Block> CHERRY_STAIRS = createWoodStairs("cherry_stairs");
    public static final BlockRegistryObject<Block> CIKA_STAIRS = createWoodStairs("cika_stairs");
    public static final BlockRegistryObject<Block> CYPRESS_STAIRS = createWoodStairs("cypress_stairs");
    public static final BlockRegistryObject<Block> EBONY_STAIRS = createWoodStairs("ebony_stairs");
    public static final BlockRegistryObject<Block> FIR_STAIRS = createWoodStairs("fir_stairs");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_STAIRS = createWoodStairs("green_enchanted_stairs");
    public static final BlockRegistryObject<Block> HOLLY_STAIRS = createWoodStairs("holly_stairs");
    public static final BlockRegistryObject<Block> JACARANDA_STAIRS = createWoodStairs("jacaranda_stairs");
    public static final BlockRegistryObject<Block> MAHOGANY_STAIRS = createWoodStairs("mahogany_stairs");
    public static final BlockRegistryObject<Block> MANGROVE_STAIRS = createWoodStairs("mangrove_stairs");
    public static final BlockRegistryObject<Block> MAPLE_STAIRS = createWoodStairs("maple_stairs");
    public static final BlockRegistryObject<Block> PINE_STAIRS = createWoodStairs("pine_stairs");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_STAIRS = createWoodStairs("rainbow_eucalyptus_stairs");
    public static final BlockRegistryObject<Block> REDWOOD_STAIRS = createWoodStairs("redwood_stairs");
    public static final BlockRegistryObject<Block> SKYRIS_STAIRS = createWoodStairs("skyris_stairs");
    public static final BlockRegistryObject<Block> WILLOW_STAIRS = createWoodStairs("willow_stairs");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_STAIRS = createWoodStairs("witch_hazel_stairs");
    public static final BlockRegistryObject<Block> ZELKOVA_STAIRS = createWoodStairs("zelkova_stairs");
    public static final BlockRegistryObject<Block> SYTHIAN_STAIRS = createWoodStairs("sythian_stairs");
    public static final BlockRegistryObject<Block> EMBUR_STAIRS = createWoodStairs("embur_stairs");
    public static final BlockRegistryObject<Block> PALM_STAIRS = createWoodStairs("palm_stairs");
    public static final BlockRegistryObject<Block> LAMENT_STAIRS = createWoodStairs("lament_stairs");
    public static final BlockRegistryObject<Block> BULBIS_STAIRS = createWoodStairs("bulbis_stairs");
    public static final BlockRegistryObject<Block> NIGHTSHADE_STAIRS = createWoodStairs("nightshade_stairs");
    public static final BlockRegistryObject<Block> ETHER_STAIRS = createWoodStairs("ether_stairs");
    public static final BlockRegistryObject<Block> IMPARIUS_STAIRS = createWoodStairs("imparius_stairs");

    public static final BlockRegistryObject<Block> ASPEN_FENCE = createFence("aspen_fence");
    public static final BlockRegistryObject<Block> BAOBAB_FENCE = createFence("baobab_fence");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_FENCE = createFence("blue_enchanted_fence");
    public static final BlockRegistryObject<Block> CHERRY_FENCE = createFence("cherry_fence");
    public static final BlockRegistryObject<Block> CIKA_FENCE = createFence("cika_fence");
    public static final BlockRegistryObject<Block> CYPRESS_FENCE = createFence("cypress_fence");
    public static final BlockRegistryObject<Block> EBONY_FENCE = createFence("ebony_fence");
    public static final BlockRegistryObject<Block> FIR_FENCE = createFence("fir_fence");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_FENCE = createFence("green_enchanted_fence");
    public static final BlockRegistryObject<Block> HOLLY_FENCE = createFence("holly_fence");
    public static final BlockRegistryObject<Block> JACARANDA_FENCE = createFence("jacaranda_fence");
    public static final BlockRegistryObject<Block> MAHOGANY_FENCE = createFence("mahogany_fence");
    public static final BlockRegistryObject<Block> MANGROVE_FENCE = createFence("mangrove_fence");
    public static final BlockRegistryObject<Block> MAPLE_FENCE = createFence("maple_fence");
    public static final BlockRegistryObject<Block> PINE_FENCE = createFence("pine_fence");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_FENCE = createFence("rainbow_eucalyptus_fence");
    public static final BlockRegistryObject<Block> REDWOOD_FENCE = createFence("redwood_fence");
    public static final BlockRegistryObject<Block> SKYRIS_FENCE = createFence("skyris_fence");
    public static final BlockRegistryObject<Block> WILLOW_FENCE = createFence("willow_fence");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_FENCE = createFence("witch_hazel_fence");
    public static final BlockRegistryObject<Block> ZELKOVA_FENCE = createFence("zelkova_fence");
    public static final BlockRegistryObject<Block> SYTHIAN_FENCE = createFence("sythian_fence");
    public static final BlockRegistryObject<Block> EMBUR_FENCE = createFence("embur_fence");
    public static final BlockRegistryObject<Block> PALM_FENCE = createFence("palm_fence");
    public static final BlockRegistryObject<Block> LAMENT_FENCE = createFence("lament_fence");
    public static final BlockRegistryObject<Block> BULBIS_FENCE = createFence("bulbis_fence");
    public static final BlockRegistryObject<Block> NIGHTSHADE_FENCE = createFence("nightshade_fence");
    public static final BlockRegistryObject<Block> ETHER_FENCE = createFence("ether_fence");
    public static final BlockRegistryObject<Block> IMPARIUS_FENCE = createFence("imparius_fence");

    public static final BlockRegistryObject<Block> ASPEN_SIGN = createSign("aspen_sign", BYGWoodType.ASPEN, ASPEN_PLANKS);
    public static final BlockRegistryObject<Block> BAOBAB_SIGN = createSign("baobab_sign", BYGWoodType.BAOBAB, BAOBAB_PLANKS);
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_SIGN = createSign("blue_enchanted_sign", BYGWoodType.BLUE_ENCHANTED, BLUE_ENCHANTED_PLANKS);
    public static final BlockRegistryObject<Block> CHERRY_SIGN = createSign("cherry_sign", BYGWoodType.CHERRY, CHERRY_PLANKS);
    public static final BlockRegistryObject<Block> CIKA_SIGN = createSign("cika_sign", BYGWoodType.CIKA, CIKA_PLANKS);
    public static final BlockRegistryObject<Block> CYPRESS_SIGN = createSign("cypress_sign", BYGWoodType.CYPRESS, CYPRESS_PLANKS);
    public static final BlockRegistryObject<Block> EBONY_SIGN = createSign("ebony_sign", BYGWoodType.EBONY, EBONY_PLANKS);
    public static final BlockRegistryObject<Block> FIR_SIGN = createSign("fir_sign", BYGWoodType.FIR, FIR_PLANKS);
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_SIGN = createSign("green_enchanted_sign", BYGWoodType.GREEN_ENCHANTED, GREEN_ENCHANTED_PLANKS);
    public static final BlockRegistryObject<Block> HOLLY_SIGN = createSign("holly_sign", BYGWoodType.HOLLY, HOLLY_PLANKS);
    public static final BlockRegistryObject<Block> JACARANDA_SIGN = createSign("jacaranda_sign", BYGWoodType.JACARANDA, JACARANDA_PLANKS);
    public static final BlockRegistryObject<Block> MAHOGANY_SIGN = createSign("mahogany_sign", BYGWoodType.MAHOGANY, MAHOGANY_PLANKS);
    public static final BlockRegistryObject<Block> MANGROVE_SIGN = createSign("mangrove_sign", BYGWoodType.MANGROVE, MANGROVE_PLANKS);
    public static final BlockRegistryObject<Block> MAPLE_SIGN = createSign("maple_sign", BYGWoodType.MAPLE, MAPLE_PLANKS);
    public static final BlockRegistryObject<Block> PINE_SIGN = createSign("pine_sign", BYGWoodType.PINE, PINE_PLANKS);
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_SIGN = createSign("rainbow_eucalyptus_sign", BYGWoodType.RAINBOW_EUCALYPTUS, RAINBOW_EUCALYPTUS_PLANKS);
    public static final BlockRegistryObject<Block> REDWOOD_SIGN = createSign("redwood_sign", BYGWoodType.REDWOOD, REDWOOD_PLANKS);
    public static final BlockRegistryObject<Block> SKYRIS_SIGN = createSign("skyris_sign", BYGWoodType.SKYRIS, SKYRIS_PLANKS);
    public static final BlockRegistryObject<Block> WILLOW_SIGN = createSign("willow_sign", BYGWoodType.WILLOW, WILLOW_PLANKS);
    public static final BlockRegistryObject<Block> WITCH_HAZEL_SIGN = createSign("witch_hazel_sign", BYGWoodType.WITCH_HAZEL, WITCH_HAZEL_PLANKS);
    public static final BlockRegistryObject<Block> ZELKOVA_SIGN = createSign("zelkova_sign", BYGWoodType.ZELKOVA, ZELKOVA_PLANKS);
    public static final BlockRegistryObject<Block> SYTHIAN_SIGN = createSign("sythian_sign", BYGWoodType.SYTHIAN, SYTHIAN_PLANKS);
    public static final BlockRegistryObject<Block> EMBUR_SIGN = createSign("embur_sign", BYGWoodType.EMBUR, EMBUR_PLANKS);
    public static final BlockRegistryObject<Block> PALM_SIGN = createSign("palm_sign", BYGWoodType.PALM, PALM_PLANKS);
    public static final BlockRegistryObject<Block> LAMENT_SIGN = createSign("lament_sign", BYGWoodType.LAMENT, LAMENT_PLANKS);
    public static final BlockRegistryObject<Block> BULBIS_SIGN = createSign("bulbis_sign", BYGWoodType.BULBIS, BULBIS_PLANKS);
    public static final BlockRegistryObject<Block> NIGHTSHADE_SIGN = createSign("nightshade_sign", BYGWoodType.NIGHTSHADE, NIGHTSHADE_PLANKS);
    public static final BlockRegistryObject<Block> ETHER_SIGN = createSign("ether_sign", BYGWoodType.ETHER, ETHER_PLANKS);
    public static final BlockRegistryObject<Block> IMPARIUS_SIGN = createSign("imparius_sign", BYGWoodType.IMPARIUS, IMPARIUS_PLANKS);

    public static final BlockRegistryObject<Block> ASPEN_WALL_SIGN = createWallSign("aspen_wall_sign", BYGWoodType.ASPEN, ASPEN_PLANKS);
    public static final BlockRegistryObject<Block> BAOBAB_WALL_SIGN = createWallSign("baobab_wall_sign", BYGWoodType.BAOBAB, BAOBAB_PLANKS);
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_WALL_SIGN = createWallSign("blue_enchanted_wall_sign", BYGWoodType.BLUE_ENCHANTED, BLUE_ENCHANTED_PLANKS);
    public static final BlockRegistryObject<Block> CHERRY_WALL_SIGN = createWallSign("cherry_wall_sign", BYGWoodType.CHERRY, CHERRY_PLANKS);
    public static final BlockRegistryObject<Block> CIKA_WALL_SIGN = createWallSign("cika_wall_sign", BYGWoodType.CIKA, CIKA_PLANKS);
    public static final BlockRegistryObject<Block> CYPRESS_WALL_SIGN = createWallSign("cypress_wall_sign", BYGWoodType.CYPRESS, CYPRESS_PLANKS);
    public static final BlockRegistryObject<Block> EBONY_WALL_SIGN = createWallSign("ebony_wall_sign", BYGWoodType.EBONY, EBONY_PLANKS);
    public static final BlockRegistryObject<Block> FIR_WALL_SIGN = createWallSign("fir_wall_sign", BYGWoodType.FIR, FIR_PLANKS);
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_WALL_SIGN = createWallSign("green_enchanted_wall_sign", BYGWoodType.GREEN_ENCHANTED, GREEN_ENCHANTED_PLANKS);
    public static final BlockRegistryObject<Block> HOLLY_WALL_SIGN = createWallSign("holly_wall_sign", BYGWoodType.HOLLY, HOLLY_PLANKS);
    public static final BlockRegistryObject<Block> JACARANDA_WALL_SIGN = createWallSign("jacaranda_wall_sign", BYGWoodType.JACARANDA, JACARANDA_PLANKS);
    public static final BlockRegistryObject<Block> MAHOGANY_WALL_SIGN = createWallSign("mahogany_wall_sign", BYGWoodType.MAHOGANY, MAHOGANY_PLANKS);
    public static final BlockRegistryObject<Block> MANGROVE_WALL_SIGN = createWallSign("mangrove_wall_sign", BYGWoodType.MANGROVE, MANGROVE_PLANKS);
    public static final BlockRegistryObject<Block> MAPLE_WALL_SIGN = createWallSign("maple_wall_sign", BYGWoodType.MAPLE, MAPLE_PLANKS);
    public static final BlockRegistryObject<Block> PINE_WALL_SIGN = createWallSign("pine_wall_sign", BYGWoodType.PINE, PINE_PLANKS);
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_WALL_SIGN = createWallSign("rainbow_eucalyptus_wall_sign", BYGWoodType.RAINBOW_EUCALYPTUS, RAINBOW_EUCALYPTUS_PLANKS);
    public static final BlockRegistryObject<Block> REDWOOD_WALL_SIGN = createWallSign("redwood_wall_sign", BYGWoodType.REDWOOD, REDWOOD_PLANKS);
    public static final BlockRegistryObject<Block> SKYRIS_WALL_SIGN = createWallSign("skyris_wall_sign", BYGWoodType.SKYRIS, SKYRIS_PLANKS);
    public static final BlockRegistryObject<Block> WILLOW_WALL_SIGN = createWallSign("willow_wall_sign", BYGWoodType.WILLOW, WILLOW_PLANKS);
    public static final BlockRegistryObject<Block> WITCH_HAZEL_WALL_SIGN = createWallSign("witch_hazel_wall_sign", BYGWoodType.WITCH_HAZEL, WITCH_HAZEL_PLANKS);
    public static final BlockRegistryObject<Block> ZELKOVA_WALL_SIGN = createWallSign("zelkova_wall_sign", BYGWoodType.ZELKOVA, ZELKOVA_PLANKS);
    public static final BlockRegistryObject<Block> SYTHIAN_WALL_SIGN = createWallSign("sythian_wall_sign", BYGWoodType.SYTHIAN, SYTHIAN_PLANKS);
    public static final BlockRegistryObject<Block> EMBUR_WALL_SIGN = createWallSign("embur_wall_sign", BYGWoodType.EMBUR, EMBUR_PLANKS);
    public static final BlockRegistryObject<Block> PALM_WALL_SIGN = createWallSign("palm_wall_sign", BYGWoodType.PALM, PALM_PLANKS);
    public static final BlockRegistryObject<Block> LAMENT_WALL_SIGN = createWallSign("lament_wall_sign", BYGWoodType.LAMENT, LAMENT_PLANKS);
    public static final BlockRegistryObject<Block> BULBIS_WALL_SIGN = createWallSign("bulbis_wall_sign", BYGWoodType.BULBIS, BULBIS_PLANKS);
    public static final BlockRegistryObject<Block> NIGHTSHADE_WALL_SIGN = createWallSign("nightshade_wall_sign", BYGWoodType.NIGHTSHADE, NIGHTSHADE_PLANKS);
    public static final BlockRegistryObject<Block> ETHER_WALL_SIGN = createWallSign("ether_wall_sign", BYGWoodType.ETHER, ETHER_PLANKS);
    public static final BlockRegistryObject<Block> IMPARIUS_WALL_SIGN = createWallSign("imparius_wall_sign", BYGWoodType.IMPARIUS, IMPARIUS_PLANKS);

    public static final BlockRegistryObject<Block> FORAGERS_TABLE = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.FLETCHING_TABLE)), "foragers_table");


    public static final BlockRegistryObject<Block> PEAT = createDirt("peat");
    public static final BlockRegistryObject<Block> LUSH_DIRT = createDirt("lush_dirt");
    public static final BlockRegistryObject<Block> LUSH_FARMLAND = createLushFarmland("lush_farmland");

    public static final BlockRegistryObject<Block> ETHER_SOIL = createDirt("ether_soil");
    public static final BlockRegistryObject<Block> MUD_BLOCK = createBlock(BYGBlockProperties.BYGMud::new, "mud_block");
    public static final BlockRegistryObject<Block> MUD_BRICKS = createDirt("mud_bricks");

    public static final BlockRegistryObject<Block> ARAUCARIA_SAPLING = createSapling(BYGBlockTags.GROUND_ARAUCARIA_SAPLING, "araucaria_sapling");
    public static final BlockRegistryObject<Block> ASPEN_SAPLING = createSapling(BYGBlockTags.GROUND_ASPEN_SAPLING, "aspen_sapling");
    public static final BlockRegistryObject<Block> BAOBAB_SAPLING = createSapling(BYGBlockTags.GROUND_BAOBAB_SAPLING, "baobab_sapling");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_SAPLING = createSapling(BYGBlockTags.GROUND_BLUE_ENCHANTED_SAPLING, "blue_enchanted_sapling");
    public static final BlockRegistryObject<Block> BLUE_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_BLUE_SPRUCE_SAPLING, "blue_spruce_sapling");
    public static final BlockRegistryObject<Block> BROWN_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_BIRCH_SAPLING, "brown_birch_sapling");
    public static final BlockRegistryObject<Block> BROWN_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_OAK_SAPLING, "brown_oak_sapling");
    public static final BlockRegistryObject<Block> BROWN_ZELKOVA_SAPLING = createSapling(BYGBlockTags.GROUND_BROWN_ZELKOVA_SAPLING, "brown_zelkova_sapling");
    public static final BlockRegistryObject<Block> CIKA_SAPLING = createSapling(BYGBlockTags.GROUND_CIKA_SAPLING, "cika_sapling");
    public static final BlockRegistryObject<Block> CYPRESS_SAPLING = createSapling(BYGBlockTags.GROUND_CYPRESS_SAPLING, "cypress_sapling");
    public static final BlockRegistryObject<Block> EBONY_SAPLING = createSapling(BYGBlockTags.GROUND_EBONY_SAPLING, "ebony_sapling");
    public static final BlockRegistryObject<Block> FIR_SAPLING = createSapling(BYGBlockTags.GROUND_FIR_SAPLING, "fir_sapling");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_SAPLING = createSapling(BYGBlockTags.GROUND_GREEN_ENCHANTED_SAPLING, "green_enchanted_sapling");
    public static final BlockRegistryObject<Block> HOLLY_SAPLING = createSapling(BYGBlockTags.GROUND_HOLLY_SAPLING, "holly_sapling");
    public static final BlockRegistryObject<Block> FLOWERING_JACARANDA_BUSH = createFloweringJacarandaBush(1, TreeSpawners.JACARANDA, "flowering_jacaranda_bush");
    public static final BlockRegistryObject<Block> FLOWERING_INDIGO_JACARANDA_BUSH = createFloweringIndigoJacarandaBush(1, TreeSpawners.INDIGO_JACARANDA, "flowering_indigo_jacaranda_bush");
    public static final BlockRegistryObject<Block> JACARANDA_SAPLING = createSapling(BYGBlockTags.GROUND_JACARANDA_SAPLING, "jacaranda_sapling");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_SAPLING = createSapling(BYGBlockTags.GROUND_INDIGO_JACARANDA_SAPLING, "indigo_jacaranda_sapling");
    public static final BlockRegistryObject<Block> JOSHUA_SAPLING = createSapling(BYGBlockTags.GROUND_JOSHUA_SAPLING, "joshua_sapling");
    public static final BlockRegistryObject<Block> MAHOGANY_SAPLING = createSapling(BYGBlockTags.GROUND_MAHOGANY_SAPLING, "mahogany_sapling");
    public static final BlockRegistryObject<Block> MANGROVE_SAPLING = createSapling(BYGBlockTags.GROUND_MANGROVE_SAPLING, "mangrove_sapling");
    public static final BlockRegistryObject<Block> MAPLE_SAPLING = createSapling(BYGBlockTags.GROUND_MAPLE_SAPLING, "maple_sapling");
    public static final BlockRegistryObject<Block> ORANGE_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_BIRCH_SAPLING, "orange_birch_sapling");
    public static final BlockRegistryObject<Block> ORANGE_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_OAK_SAPLING, "orange_oak_sapling");
    public static final BlockRegistryObject<Block> ORANGE_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_ORANGE_SPRUCE_SAPLING, "orange_spruce_sapling");
    public static final BlockRegistryObject<Block> ORCHARD_SAPLING = createSapling(BYGBlockTags.GROUND_ORCHARD_SAPLING, "orchard_sapling");
    public static final BlockRegistryObject<Block> PALO_VERDE_SAPLING = createSapling(BYGBlockTags.GROUND_PALO_VERDE_SAPLING, "palo_verde_sapling");
    public static final BlockRegistryObject<Block> PINE_SAPLING = createSapling(BYGBlockTags.GROUND_PINE_SAPLING, "pine_sapling");
    public static final BlockRegistryObject<Block> PINK_CHERRY_SAPLING = createSapling(BYGBlockTags.GROUND_PINK_CHERRY_SAPLING, "pink_cherry_sapling");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_SAPLING = createSapling(BYGBlockTags.GROUND_RAINBOW_EUCALYPTUS_SAPLING, "rainbow_eucalyptus_sapling");
    public static final BlockRegistryObject<Block> RED_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_RED_BIRCH_SAPLING, "red_birch_sapling");
    public static final BlockRegistryObject<Block> RED_MAPLE_SAPLING = createSapling(BYGBlockTags.GROUND_RED_MAPLE_SAPLING, "red_maple_sapling");
    public static final BlockRegistryObject<Block> RED_OAK_SAPLING = createSapling(BYGBlockTags.GROUND_RED_OAK_SAPLING, "red_oak_sapling");
    public static final BlockRegistryObject<Block> RED_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_RED_SPRUCE_SAPLING, "red_spruce_sapling");
    public static final BlockRegistryObject<Block> REDWOOD_SAPLING = createSapling(BYGBlockTags.GROUND_REDWOOD_SAPLING, "redwood_sapling");
    public static final BlockRegistryObject<Block> SILVER_MAPLE_SAPLING = createSapling(BYGBlockTags.GROUND_SILVER_MAPLE_SAPLING, "silver_maple_sapling");
    public static final BlockRegistryObject<Block> SKYRIS_SAPLING = createSapling(BYGBlockTags.GROUND_SKYRIS_SAPLING, "skyris_sapling");
    public static final BlockRegistryObject<Block> WHITE_CHERRY_SAPLING = createSapling(BYGBlockTags.GROUND_WHITE_CHERRY_SAPLING, "white_cherry_sapling");
    public static final BlockRegistryObject<Block> WILLOW_SAPLING = createSapling(BYGBlockTags.GROUND_WILLOW_SAPLING, "willow_sapling");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_SAPLING = createSapling(BYGBlockTags.GROUND_WITCH_HAZEL_SAPLING, "witch_hazel_sapling");
    public static final BlockRegistryObject<Block> YELLOW_BIRCH_SAPLING = createSapling(BYGBlockTags.GROUND_YELLOW_BIRCH_SAPLING, "yellow_birch_sapling");
    public static final BlockRegistryObject<Block> YELLOW_SPRUCE_SAPLING = createSapling(BYGBlockTags.GROUND_YELLOW_SPRUCE_SAPLING, "yellow_spruce_sapling");
    public static final BlockRegistryObject<Block> ZELKOVA_SAPLING = createSapling(BYGBlockTags.GROUND_ZELKOVA_SAPLING, "zelkova_sapling");
    public static final BlockRegistryObject<Block> PALM_SAPLING = createSapling(BYGBlockTags.GROUND_PALM_SAPLING, "palm_sapling");
    public static final BlockRegistryObject<Block> LAMENT_SAPLING = createSapling(BYGBlockTags.GROUND_LAMENT_SAPLING, "lament_sapling");
    public static final BlockRegistryObject<Block> WITHERING_OAK_SAPLING = createNetherMushroomPlant(new BYGMushroomToHugeMushroom.WitheringOak(), "withering_oak_sapling");
    public static final BlockRegistryObject<Block> ETHER_SAPLING = createSapling(BYGBlockTags.GROUND_ETHER_SAPLING, "ether_sapling");
    public static final BlockRegistryObject<Block> NIGHTSHADE_SAPLING = createSapling(BYGBlockTags.GROUND_NIGHTSHADE_SAPLING, "nightshade_sapling");

    public static final BlockRegistryObject<Block> JACARANDA_BUSH = createJacarandaBush("jacaranda_bush");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_BUSH = createIndigoJacarandaBush("indigo_jacaranda_bush");
    public static final BlockRegistryObject<Block> SHRUB = createShrub(TreeSpawners.SHRUB, "shrub");

    public static final BlockRegistryObject<Block> WITCH_HAZEL_BRANCH = createTreeBranchBlock(MaterialColor.COLOR_ORANGE, "witch_hazel_branch");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_BLOSSOM = createWitchHazelBlossomBlock(MaterialColor.COLOR_YELLOW, "witch_hazel_blossom");

    public static final BlockRegistryObject<Block> ARAUCARIA_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "araucaria_leaves");
    public static final BlockRegistryObject<Block> ASPEN_LEAVES = createLeaves(MaterialColor.TERRACOTTA_YELLOW, "aspen_leaves");
    public static final BlockRegistryObject<Block> BAOBAB_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "baobab_leaves");
    public static final BlockRegistryObject<Block> BLOOMING_WITCH_HAZEL_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE,  "blooming_witch_hazel_leaves");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_LEAVES = createGlowingLeaves(MaterialColor.COLOR_BLUE, 15, "blue_enchanted_leaves");
    public static final BlockRegistryObject<Block> BLUE_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_BLUE, "blue_spruce_leaves");
    public static final BlockRegistryObject<Block> BROWN_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_birch_leaves");
    public static final BlockRegistryObject<Block> BROWN_OAK_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_oak_leaves");
    public static final BlockRegistryObject<Block> BROWN_ZELKOVA_LEAVES = createLeaves(MaterialColor.COLOR_BROWN, "brown_zelkova_leaves");
    public static final BlockRegistryObject<Block> CIKA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_ORANGE, "cika_leaves");
    public static final BlockRegistryObject<Block> CYPRESS_LEAVES = createLeaves(MaterialColor.TERRACOTTA_LIGHT_GREEN, "cypress_leaves");
    public static final BlockRegistryObject<Block> EBONY_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "ebony_leaves");
    public static final BlockRegistryObject<Block> FIR_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "fir_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_ORCHARD_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "flowering_orchard_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_PALO_VERDE_LEAVES = createFloweringPaloVerdeLeaves(MaterialColor.COLOR_YELLOW, "flowering_palo_verde_leaves");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_LEAVES = createGlowingLeaves(MaterialColor.COLOR_GREEN, 15, "green_enchanted_leaves");
    public static final BlockRegistryObject<Block> HOLLY_BERRY_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "holly_berry_leaves");
    public static final BlockRegistryObject<Block> HOLLY_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "holly_leaves");
    public static final BlockRegistryObject<Block> JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_PURPLE, "jacaranda_leaves");
    public static final BlockRegistryObject<Block> INDIGO_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_BLUE, "indigo_jacaranda_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_PURPLE, "flowering_jacaranda_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_INDIGO_JACARANDA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_BLUE, "flowering_indigo_jacaranda_leaves");
    public static final BlockRegistryObject<Block> JOSHUA_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "joshua_leaves");
    public static final BlockRegistryObject<Block> RIPE_JOSHUA_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "ripe_joshua_leaves");
    public static final BlockRegistryObject<Block> MAHOGANY_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "mahogany_leaves");
    public static final BlockRegistryObject<Block> MANGROVE_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "mangrove_leaves");
    public static final BlockRegistryObject<Block> MAPLE_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "maple_leaves");
    public static final BlockRegistryObject<Block> ORANGE_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_birch_leaves");
    public static final BlockRegistryObject<Block> ORANGE_OAK_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_oak_leaves");
    public static final BlockRegistryObject<Block> ORANGE_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "orange_spruce_leaves");
    public static final BlockRegistryObject<Block> ORCHARD_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "orchard_leaves");
    public static final BlockRegistryObject<Block> PALO_VERDE_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "palo_verde_leaves");
    public static final BlockRegistryObject<Block> PINE_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "pine_leaves");
    public static final BlockRegistryObject<Block> PINK_CHERRY_LEAVES = createLeaves(MaterialColor.COLOR_PINK, "pink_cherry_leaves");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "rainbow_eucalyptus_leaves");
    public static final BlockRegistryObject<Block> RED_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_birch_leaves");
    public static final BlockRegistryObject<Block> RED_MAPLE_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_maple_leaves");
    public static final BlockRegistryObject<Block> RED_OAK_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_oak_leaves");
    public static final BlockRegistryObject<Block> RED_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_RED, "red_spruce_leaves");
    public static final BlockRegistryObject<Block> REDWOOD_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "redwood_leaves");
    public static final BlockRegistryObject<Block> RIPE_ORCHARD_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "ripe_orchard_leaves");
    public static final BlockRegistryObject<Block> SILVER_MAPLE_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_GRAY, "silver_maple_leaves");
    public static final BlockRegistryObject<Block> SKYRIS_LEAVES_GREEN_APPLE = createLeaves(MaterialColor.COLOR_PINK, "green_apple_skyris_leaves");
    public static final BlockRegistryObject<Block> SKYRIS_LEAVES = createLeaves(MaterialColor.COLOR_PINK, "skyris_leaves");
    public static final BlockRegistryObject<Block> WHITE_CHERRY_LEAVES = createLeaves(MaterialColor.COLOR_LIGHT_GRAY, "white_cherry_leaves");
    public static final BlockRegistryObject<Block> WILLOW_LEAVES = createLeaves(MaterialColor.TERRACOTTA_GREEN, "willow_leaves");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "witch_hazel_leaves");
    public static final BlockRegistryObject<Block> YELLOW_BIRCH_LEAVES = createLeaves(MaterialColor.COLOR_YELLOW, "yellow_birch_leaves");
    public static final BlockRegistryObject<Block> YELLOW_SPRUCE_LEAVES = createLeaves(MaterialColor.COLOR_YELLOW, "yellow_spruce_leaves");
    public static final BlockRegistryObject<Block> ZELKOVA_LEAVES = createLeaves(MaterialColor.TERRACOTTA_RED, "zelkova_leaves");
    public static final BlockRegistryObject<Block> PALM_LEAVES = createLeaves(MaterialColor.COLOR_GREEN, "palm_leaves");
    public static final BlockRegistryObject<Block> LAMENT_LEAVES = createLeaves(MaterialColor.COLOR_MAGENTA, "lament_leaves");
    public static final BlockRegistryObject<Block> WITHERING_OAK_LEAVES = createLeaves(MaterialColor.COLOR_GRAY, "withering_oak_leaves");
    public static final BlockRegistryObject<Block> FLOWERING_NIGHTSHADE_LEAVES = createGlowingLeaves(MaterialColor.COLOR_ORANGE, 15, "flowering_nightshade_leaves");
    public static final BlockRegistryObject<Block> NIGHTSHADE_LEAVES = createLeaves(MaterialColor.COLOR_ORANGE, "nightshade_leaves");
    public static final BlockRegistryObject<Block> ETHER_LEAVES = createLeaves(MaterialColor.COLOR_CYAN, "ether_leaves");
    public static final BlockRegistryObject<Block> FIRECRACKER_LEAVES = createFirecrackerLeavesBlock(MaterialColor.COLOR_GREEN, "firecracker_leaves");

    public static final BlockRegistryObject<Block> GREEN_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "green_mushroom_block");
    public static final BlockRegistryObject<Block> MILKCAP_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "weeping_milkcap_mushroom_block");
    public static final BlockRegistryObject<Block> BLEWIT_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "wood_blewit_mushroom_block");
    public static final BlockRegistryObject<Block> WHITE_MUSHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "white_mushroom_stem");
    public static final BlockRegistryObject<Block> BROWN_MUSHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeMushroom::new, "brown_mushroom_stem");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_STEM = createBlock(BYGBlockProperties.BlockHugeNetherMushroomStem::new, "soul_shroom_stem");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeNetherMushroom::new, "soul_shroom_block");
    public static final BlockRegistryObject<Block> DEATH_CAP_MUSHROOM_BLOCK = createBlock(BYGBlockProperties.BlockHugeNetherMushroom::new, "death_cap_mushroom_block");
    public static final BlockRegistryObject<Block> BULBIS_SHELL = createBlock(BYGBlockProperties.BulbisShell::new, "bulbis_shell");
    public static final BlockRegistryObject<Block> PURPLE_BULBIS_SHELL = createBlock(BYGBlockProperties.BulbisShell::new, "purple_bulbis_shell");

    public static final BlockRegistryObject<Block> CATTAIL_SPROUT = createCattailSproutBlock("cattail_sprout");
    public static final BlockRegistryObject<Block> CATTAIL = createCattailPlantBlock("cattail");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH = createBlock(BYGBlockProperties.BYGThatch::new, "cattail_thatch");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_CARPET = createBlock(BYGBlockProperties.ThatchCarpet::new, "cattail_thatch_carpet");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_STAIRS = createBlock(BYGBlockProperties.ThatchStairs::new, "cattail_thatch_stairs");
    public static final BlockRegistryObject<Block> CATTAIL_THATCH_SLAB = createBlock(BYGBlockProperties.ThatchSlab::new, "cattail_thatch_slab");
    public static final BlockRegistryObject<Block> HORSEWEED = createFlower("horseweed", BYGBlockTags.GROUND_HORSEWEED);
    public static final BlockRegistryObject<Block> ALOE_VERA = createAloeVeraPlantBlock("aloe_vera");
    public static final BlockRegistryObject<Block> BLOOMING_ALOE_VERA = createBloomingAloeVeraPlantBlock("blooming_aloe_vera");
    public static final BlockRegistryObject<Block> MINI_CACTUS = createDesertPlant("mini_cactus", BYGBlockTags.GROUND_MINI_CACTUS);
    public static final BlockRegistryObject<Block> PRICKLY_PEAR_CACTUS = createDesertPlant("prickly_pear_cactus", BYGBlockTags.GROUND_PRICKLY_PEAR_CACTUS);
    public static final BlockRegistryObject<Block> WINTER_SUCCULENT = createFlower("winter_succulent", BYGBlockTags.GROUND_WINTER_SUCCULENT);
    public static final BlockRegistryObject<Block> TALL_PRAIRIE_GRASS = createTallFlower("tall_prairie_grass", BYGBlockTags.GROUND_TALL_PRAIRIE_GRASS);
    public static final BlockRegistryObject<Block> POISON_IVY = createBlock(BYGBlockProperties.BYGPoisonIvy::new, "poison_ivy");
    public static final BlockRegistryObject<Block> SKYRIS_VINE = createBlock(BYGBlockProperties.BYGSkyrisVine::new, "skyris_vine");
    public static final BlockRegistryObject<Block> BLUEBERRY_BUSH = createBlueBerryBush("blueberry_bush");
    public static final BlockRegistryObject<Block> TINY_LILYPADS = createBlock(BYGBlockProperties.BYGLily::new, "tiny_lilypads");
    public static final BlockRegistryObject<Block> WATER_SILK = createBlock(BYGBlockProperties.BYGWaterSilk::new, "water_silk");
    public static final BlockRegistryObject<Block> WEEPING_ROOTS = createBlock(BYGBlockProperties.BYGHangingVine::new, "weeping_roots");
    public static final BlockRegistryObject<Block> WEEPING_ROOTS_PLANT = createBlock(BYGBlockProperties.BYGHangingVinePlant::new, "weeping_roots_plant");
    public static final BlockRegistryObject<Block> BEACH_GRASS = createBlock(BYGBlockProperties.BYGBeachGrass::new, "beach_grass");
    public static final BlockRegistryObject<Block> LEAF_PILE = createBlock(BYGBlockProperties.BYGLeafPile::new, "leaf_pile");
    public static final BlockRegistryObject<Block> CLOVER_PATCH = createBlock(BYGBlockProperties.BYGLeafPile::new, "clover_patch");
    public static final BlockRegistryObject<Block> FLOWER_PATCH = createBlock(BYGBlockProperties.BYGLeafPile::new, "flower_patch");
    public static final BlockRegistryObject<Block> BAOBAB_FRUIT_BLOCK = createBaobabFruitBlock("baobab_fruit_block");
    public static final BlockRegistryObject<Block> ETHER_BULB = createEtherBulbBlock("ether_bulbs_block");

    public static final BlockRegistryObject<Block> ANTHRACITE_BLOCK = createBlock(BYGBlockProperties.AnthraciteOre::new, "anthracite_block");
    public static final BlockRegistryObject<Block> ANTHRACITE_ORE = createBlock(BYGBlockProperties.AnthraciteOre::new, "anthracite_ore");

    public static final BlockRegistryObject<Block> NETHER_BRISTLE = createBlock(BYGBlockProperties.BYGDoubleDamagePlant::new, "nether_bristle");

    public static final BlockRegistryObject<Block> CRIMSON_BERRY_BUSH = createCrimsonBerryBush("crimson_berry_bush");
    public static final BlockRegistryObject<Block> TALL_CRIMSON_ROOTS = createBlock(BYGBlockProperties.BYGDoubleNetherPlant::new, "tall_crimson_roots");
    public static final BlockRegistryObject<Block> BRIMSTONE = createNetherStone(MaterialColor.TERRACOTTA_YELLOW, "brimstone");
    public static final BlockRegistryObject<Block> YELLOW_NETHER_BRICKS = createBlock(BYGBlockProperties.BYGNetherrack::new, "yellow_nether_bricks");
    public static final BlockRegistryObject<Block> BORIC_CAMPFIRE = createCampfireBlock(3, "boric_campfire");
    public static final BlockRegistryObject<Block> BORIC_FIRE = createBoricFireBlock(MaterialColor.COLOR_GREEN, "boric_fire");
    public static final BlockRegistryObject<Block> BORIC_LANTERN = createLanternBlock(MaterialColor.COLOR_GREEN, "boric_lantern");

    public static final BlockRegistryObject<Block> HANGING_BONE = createBlock(BYGBlockProperties.HangingBones::new, "hanging_bones");
    public static final BlockRegistryObject<Block> QUARTZ_CRYSTAL = createDullCrystal("quartz_crystal", BYGEntityTags.NOT_HURT_BY_QUARTZ_CRYSTALS);
    public static final BlockRegistryObject<Block> QUARTZITE_SAND = createBlock(BYGBlockProperties.BYGQuartziteSand::new, "quartzite_sand");
    public static final BlockRegistryObject<Block> RAW_QUARTZ_BLOCK = createBlock(BYGBlockProperties.BYGStone::new, "raw_quartz_block");
    public static final BlockRegistryObject<Block> BLUE_NETHER_QUARTZ_ORE = createNetherOre(SoundType.NETHER_ORE, MaterialColor.TERRACOTTA_BLUE, "blue_nether_quartz_ore", UniformInt.of(2, 5));
    public static final BlockRegistryObject<Block> BLUE_NETHER_GOLD_ORE = createNetherOre(SoundType.NETHER_GOLD_ORE, MaterialColor.TERRACOTTA_BLUE, "blue_nether_gold_ore", UniformInt.of(0, 1));
    public static final BlockRegistryObject<Block> BRIMSTONE_NETHER_QUARTZ_ORE = createNetherOre(SoundType.NETHER_ORE, MaterialColor.TERRACOTTA_YELLOW, "brimstone_nether_quartz_ore", UniformInt.of(2, 5));
    public static final BlockRegistryObject<Block> BRIMSTONE_NETHER_GOLD_ORE = createNetherOre(SoundType.NETHER_GOLD_ORE, MaterialColor.TERRACOTTA_YELLOW, "brimstone_nether_gold_ore", UniformInt.of(0, 1));

    public static final BlockRegistryObject<Block> WAILING_BELL_BLOSSOM = createWailingBellBlossom("wailing_bell_blossom");
    public static final BlockRegistryObject<Block> WAILING_VINES = createWailingVine("wailing_vine");
    public static final BlockRegistryObject<Block> WAILING_GRASS = createWailingPlant("wailing_grass");
    public static final BlockRegistryObject<Block> MAGMATIC_STONE = createBlock(BYGBlockProperties.BYGNetherrack::new, "magmatic_stone");
    public static final BlockRegistryObject<Block> SCORCHED_BUSH = createBlock(BYGBlockProperties.ScorchedPlant::new, "scorched_bush");
    public static final BlockRegistryObject<Block> SCORCHED_GRASS = createBlock(BYGBlockProperties.ScorchedPlant::new, "scorched_grass");

    public static final BlockRegistryObject<Block> WARPED_CACTUS = createWarpedCactus("warped_cactus");
    public static final BlockRegistryObject<Block> WARPED_BUSH = createBlock(BYGBlockProperties.BYGWarpedBush::new, "warped_bush");
    public static final BlockRegistryObject<Block> WARPED_CORAL_BLOCK = createBlock(BYGBlockProperties.BYGWarpedCoralBlock::new, "warped_coral_block");
    public static final BlockRegistryObject<Block> WARPED_CORAL = createBlock(BYGBlockProperties.BYGWarpedCoral::new, "warped_coral");
    public static final BlockRegistryObject<Block> WARPED_CORAL_FAN = createBlock(BYGBlockProperties.BYGWarpedCoral::new, "warped_coral_fan");
    public static final BlockRegistryObject<Block> WARPED_CORAL_WALL_FAN = createBlock(BYGBlockProperties.BYGWarpedWallFanCoral::new, "warped_coral_wall_fan");
    public static final BlockRegistryObject<Block> WARPED_SOUL_SAND = createBlock(BYGBlockProperties.BYGNyliumSoulSand::new, "warped_soul_sand");
    public static final BlockRegistryObject<Block> WARPED_SOUL_SOIL = createBlock(BYGBlockProperties.BYGNyliumSoulSoil::new, "warped_soul_soil");

    public static final BlockRegistryObject<Block> SYTHIAN_WART_BLOCK = createBlock(BYGBlockProperties.BYGWartBlock::new, "sythian_wart_block");
    public static final BlockRegistryObject<Block> SYTHIAN_ROOTS = createBlock(BYGBlockProperties.SythianPlant::new, "sythian_roots");
    public static final BlockRegistryObject<Block> SYTHIAN_SPROUT = createBlock(BYGBlockProperties.SythianPlant::new, "sythian_sprout");
    public static final BlockRegistryObject<Block> SYTHIAN_STALK_BLOCK = createBlock(BYGBlockProperties.SythianStalk::new, "sythian_stalk_block");
    public static final BlockRegistryObject<Block> SYTHIAN_SCAFFOLDING = createBlock(BYGBlockProperties.BYGScaffolding::new, "sythian_scaffolding");
    public static final BlockRegistryObject<Block> SYTHIAN_SAPLING = createBlock(BYGBlockProperties.SythianSapling::new, "sythian_sapling");

    public static final BlockRegistryObject<Block> HANGING_SYTHIAN_ROOTS = createBlock(BYGBlockProperties.BYGSythianHangingRoots::new, "hanging_sythian_roots");
    public static final BlockRegistryObject<Block> HANGING_SYTHIAN_ROOTS_PLANT = createBlock(BYGBlockProperties.BYGSythianHangingRootsPlant::new, "hanging_sythian_roots_plant");

    public static final BlockRegistryObject<Block> EMBUR_LILY = createBlock(BYGBlockProperties.BYGEmburLily::new, "embur_lily");
    public static final BlockRegistryObject<Block> EMBUR_GEL_BLOCK = createEmburGelBlock("embur_gel_block");
    public static final BlockRegistryObject<Block> EMBUR_GEL_VINES = createEmburGelVine("embur_gel_vines");
    public static final BlockRegistryObject<Block> EMBUR_GEL_VINES_PLANT = createEmburGelVinePlant("embur_gel_vines_plant");
    public static final BlockRegistryObject<Block> EMBUR_GEL_BRANCH = createEmburGelBranch("embur_gel_branch");

    public static final BlockRegistryObject<Block> EMBUR_SPROUTS = createBlock(() -> new NetherSproutsBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT, MaterialColor.COLOR_CYAN).noCollission().instabreak().sound(SoundType.NETHER_SPROUTS)), "embur_sprouts");
    public static final BlockRegistryObject<Block> EMBUR_ROOTS = createBlock(BYGBlockProperties.BYGEmburPlant::new, "embur_roots");
    public static final BlockRegistryObject<Block> EMBUR_WART = createNetherMushroomPlant(new BYGMushroomToHugeMushroom.EmburWart(), "embur_wart");
    public static final BlockRegistryObject<Block> TALL_EMBUR_ROOTS = createBlock(BYGBlockProperties.BYGDoubleNetherPlant::new, "tall_embur_roots");

    public static final BlockRegistryObject<Block> BLUE_NETHERRACK = createNetherStone(MaterialColor.TERRACOTTA_BLUE, "blue_netherrack");
    public static final BlockRegistryObject<Block> BLUE_NETHERRACK_BRICKS = createBlock(BYGBlockProperties.BYGBlueNetherrackBricks::new, "blue_nether_bricks");

    public static final BlockRegistryObject<Block> BULBIS_SPROUTS = createIvisBulbisPlant("bulbis_sprouts");
    public static final BlockRegistryObject<Block> IVIS_ROOTS = createIvisBulbisPlant("ivis_roots");
    public static final BlockRegistryObject<Block> IVIS_SPROUT = createIvisBulbisPlant("ivis_sprout");
    public static final BlockRegistryObject<Block> ENDER_LILY = createBlock(BYGBlockProperties.BYGEnderLily::new, "ender_lily");

    public static final BlockRegistryObject<Block> ETHER_FOLIAGE = createBlock(BYGBlockProperties.BYGLeafFoilage::new, "ether_foliage");
    public static final BlockRegistryObject<Block> TALL_ETHER_GRASS = createTallEtherPlant("tall_ether_grass");
    public static final BlockRegistryObject<Block> ETHER_GRASS = createEtherPlant("ether_grass");
    public static final BlockRegistryObject<Block> ETHER_BUSH = createEtherPlant("ether_bush");
    public static final BlockRegistryObject<Block> THEREAL_BELLFLOWER = createEtherPlant("thereal_bellflower");
    public static final BlockRegistryObject<Block> NIGHTSHADE_SPROUTS = createNightshadePlant("nightshade_sprouts");
    public static final BlockRegistryObject<Block> NIGHTSHADE_ROOTS = createTallNightshadePlant("nightshade_roots");
    public static final BlockRegistryObject<Block> NIGHTSHADE_BERRY_BUSH = createNightshadeBerryBush("nightshade_berry_bush");

    public static final BlockRegistryObject<Block> PURPUR_STONE = createBlock(BYGBlockProperties.BYGStone::new, "purpur_stone");
    public static final BlockRegistryObject<Block> PURPUR_STONE_SLAB = createStoneSlab("purpur_stone_slab");
    public static final BlockRegistryObject<Block> PURPUR_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "purpur_stone_stairs");
    public static final BlockRegistryObject<Block> PURPUR_STONE_WALL = createStoneWall("purpur_stone_wall");
    public static final BlockRegistryObject<Block> ETHER_STONE = createEtherStone("ether_stone");
    public static final BlockRegistryObject<Block> ETHER_STONE_SLAB = createStoneSlab("ether_stone_slab");
    public static final BlockRegistryObject<Block> ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "ether_stone_stairs");
    public static final BlockRegistryObject<Block> ETHER_STONE_WALL = createStoneWall("ether_stone_wall");

    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE = createEtherStone("cobbled_ether_stone");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_SLAB = createStoneSlab("cobbled_ether_stone_slab");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cobbled_ether_stone_stairs");
    public static final BlockRegistryObject<Block> COBBLED_ETHER_STONE_WALL = createStoneWall("cobbled_ether_stone_wall");

    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE = createEtherStone("carved_ether_stone");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_SLAB = createStoneSlab("carved_ether_stone_slab");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "carved_ether_stone_stairs");
    public static final BlockRegistryObject<Block> CARVED_ETHER_STONE_WALL = createStoneWall("carved_ether_stone_wall");

    public static final BlockRegistryObject<Block> LIGNITE_BLOCK = createBlock(BYGBlockProperties.AnthraciteOre::new, "lignite_block");
    public static final BlockRegistryObject<Block> LIGNITE_ORE = createBlock(BYGBlockProperties.AnthraciteOre::new, "lignite_ore");

    public static final BlockRegistryObject<Block> ODDITY_CACTUS = createOddityCactus("oddity_cactus");
    public static final BlockRegistryObject<Block> ODDITY_BUSH = createOddityDesertPlant("oddity_bush");
    public static final BlockRegistryObject<Block> END_SAND = createSand(MaterialColor.SAND, 16053687, "end_sand");

    public static final BlockRegistryObject<Block> VERMILION_SCULK_TENDRILS = createSculkPlant("vermilion_sculk_tendrils");
    public static final BlockRegistryObject<Block> VERMILION_SCULK_GROWTH = createSculkGrowth("vermilion_sculk_growth");
    public static final BlockRegistryObject<Block> THERIUM_CRYSTAL = createTheriumCrystal("therium_crystal");
    public static final BlockRegistryObject<Block> THERIUM_BLOCK = createTheriumBlock("therium_block");
    public static final BlockRegistryObject<Block> THERIUM_LANTERN = createLanternBlock(MaterialColor.COLOR_CYAN, "therium_lantern");
    public static final BlockRegistryObject<Block> THERIUM_LAMP = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN)), "therium_lamp");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM = createChiseledTherium("chiseled_therium");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_STAIRS = createChiseledTheriumStairs("chiseled_therium_stairs");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_SLAB = createChiseledTheriumSlab("chiseled_therium_slab");
    public static final BlockRegistryObject<Block> CHISELED_THERIUM_WALL = createChiseledTheriumWall("chiseled_therium_wall");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM = createShinyChiseledTherium("shiny_chiseled_therium");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_STAIRS = createShinyChiseledTheriumStairs("shiny_chiseled_therium_stairs");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_SLAB = createShinyChiseledTheriumSlab("shiny_chiseled_therium_slab");
    public static final BlockRegistryObject<Block> SHINY_CHISELED_THERIUM_WALL = createShinyChiseledTheriumWall("shiny_chiseled_therium_wall");
    public static final BlockRegistryObject<Block> THERIUM_GLASS = createTheriumGlass("therium_glass");
    public static final BlockRegistryObject<Block> THERIUM_GLASS_PANE = createTheriumGlassPane("therium_glass_pane");

    public static final BlockRegistryObject<Block> CRYPTIC_END_ROD = createEndRodBlock(MaterialColor.COLOR_RED, "cryptic_end_rod");
    public static final BlockRegistryObject<Block> CRYPTIC_CAMPFIRE = createCampfireBlock(4, "cryptic_campfire");
    public static final BlockRegistryObject<Block> CRYPTIC_LANTERN = createCrypticLanternBlock(MaterialColor.COLOR_RED, "cryptic_lantern");
    public static final BlockRegistryObject<Block> CRYPTIC_FIRE = createCrypticFireBlock(MaterialColor.COLOR_RED, "cryptic_fire");
    public static final BlockRegistryObject<Block> CRYPTIC_MAGMA_BLOCK = createBlock(BYGBlockProperties.BYGMagma::new, "cryptic_magma_block");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE = createBlock(BYGBlockProperties.BYGStone::new, "cryptic_stone");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_SLAB = createStoneSlab("cryptic_stone_slab");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cryptic_stone_stairs");
    public static final BlockRegistryObject<Block> CRYPTIC_STONE_WALL = createStoneWall("cryptic_stone_wall");
    public static final BlockRegistryObject<Block> CRYPTIC_VENT = createVent("cryptic_vent");
    public static final BlockRegistryObject<Block> TALL_CRYPTIC_VENT = createTallVent("tall_cryptic_vent");
    public static final BlockRegistryObject<Block> CRYPTIC_REDSTONE_ORE = createBlock(() -> new RedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.NETHER_GOLD_ORE).strength(0.4F, 0.4F).lightLevel(litBlockEmission(13)).requiresCorrectToolForDrops()), "cryptic_redstone_ore");
    public static final BlockRegistryObject<Block> CRYPTIC_BRAMBLE = createStoneEndPlant("cryptic_bramble");

    public static final BlockRegistryObject<Block> IMPARIUS_MUSHROOM_BLOCK = createImpariusMushroom("imparius_mushroom_block");
    public static final BlockRegistryObject<Block> IMPARIUS_MUSHROOM_BRANCH = createGlowingTreeBranchBlock(MaterialColor.COLOR_CYAN, "imparius_mushroom_branch");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_BLOCK = createFungalImparius("fungal_imparius_block");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS = createFungalImparius("chiseled_fungal_imparius");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_SLAB = createChiseledFungalImpariusSlab("chiseled_fungal_imparius_slab");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_STAIRS = createChiseledFungalImpariusStairs("chiseled_fungal_imparius_stairs");
    public static final BlockRegistryObject<Block> CHISELED_FUNGAL_IMPARIUS_WALL = createChiseledFungalImpariusWall("chiseled_fungal_imparius_wall");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_FILAMENT_BLOCK = createFungalImpariusFilamentBlock("fungal_imparius_filament_block");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_FILAMENT = createFungalImpariusFilament("fungal_imparius_filament");
    public static final BlockRegistryObject<Block> IMPARIUS_VINE = createImpariusVine("imparius_vine");
    public static final BlockRegistryObject<Block> IMPARIUS_VINE_PLANT = createImpariusVinePlant("imparius_vine_plant");
    public static final BlockRegistryObject<Block> IMPARIUS_BUSH = createImpariusPlant("imparius_bush");

    public static final BlockRegistryObject<Block> SHULKREN_MOSS_BLANKET = createSculkGrowth("shulkren_moss_blanket");
    public static final BlockRegistryObject<Block> SHULKREN_WART_BLOCK = createBlock(BYGBlockProperties.BYGWartBlock::new, "shulkren_wart_block");
    public static final BlockRegistryObject<Block> SHULKREN_VINE = createShulkrenVine("shulkren_vine");
    public static final BlockRegistryObject<Block> SHULKREN_VINE_PLANT = createShulkrenVinePlant("shulkren_vine_plant");
    public static final BlockRegistryObject<Block> PURPLE_SHROOMLIGHT = createShroomlight("purple_shroomlight");

    public static final BlockRegistryObject<Block> GLOWSTONE_LAMP = createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.SEA_LANTERN)),"glowstone_lamp");
    public static final BlockRegistryObject<Block> PERVADED_NETHERRACK = createBlock(BYGBlockProperties.BYGPervadedNetherrack::new, "pervaded_netherrack");
    public static final BlockRegistryObject<Block> GLOWSTONE_LANTERN = createLanternBlock(MaterialColor.TERRACOTTA_PURPLE, "glowstone_lantern");
    public static final BlockRegistryObject<Block> PACKED_BLACK_ICE = createBlock(BYGBlockProperties.BYGPackedIceBlock::new, "packed_black_ice");
    public static final BlockRegistryObject<Block> BLACK_ICE = createBlock(BYGBlockProperties.BYGIceBlock::new, "black_ice");
    public static final BlockRegistryObject<Block> FROST_MAGMA = createBlock(BYGBlockProperties.BYGFrostMagma::new, "frost_magma");
    public static final BlockRegistryObject<Block> SUBZERO_ASH = createBlock(BYGBlockProperties.BYGSubzeroAsh::new, "subzero_ash");
    public static final BlockRegistryObject<Block> SUBZERO_ASH_BLOCK = createBlock(BYGBlockProperties.BYGSubzeroAshBlock::new, "subzero_ash_block");
    public static final BlockRegistryObject<Block> SUBZERO_CRYSTAL_BLOCK = createSubzeroCrystalBlock("subzero_crystal_block");
    public static final BlockRegistryObject<Block> BUDDING_SUBZERO_CRYSTAL = createBuddingSubzeroCrystal("budding_subzero_crystal");
    public static final BlockRegistryObject<Block> SUBZERO_CRYSTAL_CLUSTER = createSubzeroCrystalCluster(5, 7, 3, "subzero_crystal_cluster");
    public static final BlockRegistryObject<Block> LARGE_SUBZERO_CRYSTAL_BUD = createSubzeroCrystalCluster(4, 5, 3, "large_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> MEDIUM_SUBZERO_CRYSTAL_BUD = createSubzeroCrystalCluster(2, 4, 3, "medium_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> SMALL_SUBZERO_CRYSTAL_BUD = createSubzeroCrystalCluster(1, 3, 4, "small_subzero_crystal_bud");
    public static final BlockRegistryObject<Block> LAMENT_SPROUTS = createBlock(BYGBlockProperties.BYGLamentPlant::new, "lament_sprouts");
    public static final BlockRegistryObject<Block> LAMENT_VINE = createBlock(BYGBlockProperties.BYGLamentVine::new, "lament_vine");
    public static final BlockRegistryObject<Block> LAMENT_VINE_PLANT = createBlock(BYGBlockProperties.BYGLamentVinePlant::new, "lament_vine_plant");

    public static final BlockRegistryObject<Block> PINK_CHERRY_FOLIAGE = createBlock(BYGBlockProperties.BYGLeafFoilage::new, "pink_cherry_foliage");
    public static final BlockRegistryObject<Block> WHITE_CHERRY_FOLIAGE = createBlock(BYGBlockProperties.BYGLeafFoilage::new, "white_cherry_foliage");

    public static final BlockRegistryObject<Block> WHITE_PETAL = createPetal("white_petal_block");
    public static final BlockRegistryObject<Block> RED_PETAL = createPetal("red_petal_block");
    public static final BlockRegistryObject<Block> PURPLE_PETAL = createPetal("purple_petal_block");
    public static final BlockRegistryObject<Block> BLUE_PETAL = createPetal("blue_petal_block");
    public static final BlockRegistryObject<Block> LIGHT_BLUE_PETAL = createPetal("light_blue_petal_block");
    public static final BlockRegistryObject<Block> YELLOW_PETAL = createPetal("yellow_petal_block");
    public static final BlockRegistryObject<Block> PLANT_STEM = createLog("plant_stem");
    public static final BlockRegistryObject<Block> POLLEN_BLOCK = createBlock(BYGBlockProperties.BYGPollen::new, "pollen_block");

    public static final BlockRegistryObject<Block> CRACKED_RED_SAND = createSand(MaterialColor.COLOR_ORANGE, 11098145, "cracked_red_sand");

    public static final BlockRegistryObject<Block> BLACK_SAND = createSand(MaterialColor.TERRACOTTA_BLACK, 5197647, "black_sand");
    public static final BlockRegistryObject<Block> BLACK_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_sandstone");
    public static final BlockRegistryObject<Block> BLACK_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_chiseled_sandstone");
    public static final BlockRegistryObject<Block> BLACK_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_cut_sandstone");
    public static final BlockRegistryObject<Block> BLACK_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "black_smooth_sandstone");

    public static final BlockRegistryObject<Block> WHITE_SAND = createSand(MaterialColor.TERRACOTTA_WHITE, 15395562, "white_sand");
    public static final BlockRegistryObject<Block> WHITE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_sandstone");
    public static final BlockRegistryObject<Block> WHITE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_chiseled_sandstone");
    public static final BlockRegistryObject<Block> WHITE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_cut_sandstone");
    public static final BlockRegistryObject<Block> WHITE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "white_smooth_sandstone");

    public static final BlockRegistryObject<Block> BLUE_SAND = createSand(MaterialColor.TERRACOTTA_WHITE, 13559021, "blue_sand");
    public static final BlockRegistryObject<Block> BLUE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_sandstone");
    public static final BlockRegistryObject<Block> BLUE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_chiseled_sandstone");
    public static final BlockRegistryObject<Block> BLUE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_cut_sandstone");
    public static final BlockRegistryObject<Block> BLUE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "blue_smooth_sandstone");

    public static final BlockRegistryObject<Block> PURPLE_SAND = createSand(MaterialColor.TERRACOTTA_PURPLE, 12887002, "purple_sand");
    public static final BlockRegistryObject<Block> PURPLE_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_chiseled_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_cut_sandstone");
    public static final BlockRegistryObject<Block> PURPLE_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "purple_smooth_sandstone");

    public static final BlockRegistryObject<Block> PINK_SAND = createSand(MaterialColor.COLOR_PINK, 15585004, "pink_sand");
    public static final BlockRegistryObject<Block> PINK_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_sandstone");
    public static final BlockRegistryObject<Block> PINK_CHISELED_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_chiseled_sandstone");
    public static final BlockRegistryObject<Block> PINK_CUT_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_cut_sandstone");
    public static final BlockRegistryObject<Block> PINK_SMOOTH_SANDSTONE = createBlock(BYGBlockProperties.BYGStone::new, "pink_smooth_sandstone");

    public static final BlockRegistryObject<Block> WINDSWEPT_SAND = createSand(MaterialColor.TERRACOTTA_PINK, 15585004, "windswept_sand");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> CHISELED_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "chiseled_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> CUT_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "cut_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE = createSandstone(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_SLAB = createSandstoneSlab(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_slab");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_STAIRS = createSandstoneStairs(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_stairs");
    public static final BlockRegistryObject<Block> SMOOTH_WINDSWEPT_SANDSTONE_WALL = createSandstoneWall(MaterialColor.TERRACOTTA_PINK, "smooth_windswept_sandstone_wall");

    public static final BlockRegistryObject<Block> WINDSWEPT_SANDSTONE_PILLAR = createSandstonePillar(MaterialColor.TERRACOTTA_PINK, "windswept_sandstone_pillar");


    public static final BlockRegistryObject<Block> ASPEN_LOG = createLog("aspen_log");
    public static final BlockRegistryObject<Block> BAOBAB_LOG = createLog("baobab_log");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_LOG = createLog("blue_enchanted_log");
    public static final BlockRegistryObject<Block> CHERRY_LOG = createLog("cherry_log");
    public static final BlockRegistryObject<Block> CIKA_LOG = createLog("cika_log");
    public static final BlockRegistryObject<Block> CYPRESS_LOG = createLog("cypress_log");
    public static final BlockRegistryObject<Block> EBONY_LOG = createLog("ebony_log");
    public static final BlockRegistryObject<Block> FIR_LOG = createLog("fir_log");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_LOG = createLog("green_enchanted_log");
    public static final BlockRegistryObject<Block> HOLLY_LOG = createLog("holly_log");
    public static final BlockRegistryObject<Block> JACARANDA_LOG = createLog("jacaranda_log");
    public static final BlockRegistryObject<Block> MAHOGANY_LOG = createLog("mahogany_log");
    public static final BlockRegistryObject<Block> MANGROVE_LOG = createLog("mangrove_log");
    public static final BlockRegistryObject<Block> MAPLE_LOG = createLog("maple_log");
    public static final BlockRegistryObject<Block> PALO_VERDE_LOG = createLog("palo_verde_log");
    public static final BlockRegistryObject<Block> PINE_LOG = createLog("pine_log");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_LOG = createLog("rainbow_eucalyptus_log");
    public static final BlockRegistryObject<Block> REDWOOD_LOG = createLog("redwood_log");
    public static final BlockRegistryObject<Block> SKYRIS_LOG = createLog("skyris_log");
    public static final BlockRegistryObject<Block> WILLOW_LOG = createLog("willow_log");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_LOG = createLog("witch_hazel_log");
    public static final BlockRegistryObject<Block> ZELKOVA_LOG = createLog("zelkova_log");
    public static final BlockRegistryObject<Block> SYTHIAN_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "sythian_stem");
    public static final BlockRegistryObject<Block> EMBUR_PEDU = createBlock(BYGBlockProperties.BYGNetherLog::new, "embur_pedu");
    public static final BlockRegistryObject<Block> PALM_LOG = createLog("palm_log");
    public static final BlockRegistryObject<Block> LAMENT_LOG = createBlock(BYGBlockProperties.BYGNetherLog::new, "lament_log");
    public static final BlockRegistryObject<Block> WITHERING_OAK_LOG = createLog("withering_oak_log");
    public static final BlockRegistryObject<Block> BULBIS_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "bulbis_stem");
    public static final BlockRegistryObject<Block> NIGHTSHADE_LOG = createLog("nightshade_log");
    public static final BlockRegistryObject<Block> IMBUED_NIGHTSHADE_LOG = createLog("imbued_nightshade_log");
    public static final BlockRegistryObject<Block> ETHER_LOG = createLog("ether_log");
    public static final BlockRegistryObject<Block> IMPARIUS_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "imparius_stem");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "fungal_imparius_stem");


    public static final BlockRegistryObject<Block> ASPEN_WOOD = createWood("aspen_wood");
    public static final BlockRegistryObject<Block> BAOBAB_WOOD = createWood("baobab_wood");
    public static final BlockRegistryObject<Block> BLUE_ENCHANTED_WOOD = createWood("blue_enchanted_wood");
    public static final BlockRegistryObject<Block> CHERRY_WOOD = createWood("cherry_wood");
    public static final BlockRegistryObject<Block> CIKA_WOOD = createWood("cika_wood");
    public static final BlockRegistryObject<Block> CYPRESS_WOOD = createWood("cypress_wood");
    public static final BlockRegistryObject<Block> EBONY_WOOD = createWood("ebony_wood");
    public static final BlockRegistryObject<Block> FIR_WOOD = createWood("fir_wood");
    public static final BlockRegistryObject<Block> GREEN_ENCHANTED_WOOD = createWood("green_enchanted_wood");
    public static final BlockRegistryObject<Block> HOLLY_WOOD = createWood("holly_wood");
    public static final BlockRegistryObject<Block> JACARANDA_WOOD = createWood("jacaranda_wood");
    public static final BlockRegistryObject<Block> MAHOGANY_WOOD = createWood("mahogany_wood");
    public static final BlockRegistryObject<Block> MANGROVE_WOOD = createWood("mangrove_wood");
    public static final BlockRegistryObject<Block> MAPLE_WOOD = createWood("maple_wood");
    public static final BlockRegistryObject<Block> PALO_VERDE_WOOD = createWood("palo_verde_wood");
    public static final BlockRegistryObject<Block> PINE_WOOD = createWood("pine_wood");
    public static final BlockRegistryObject<Block> RAINBOW_EUCALYPTUS_WOOD = createWood("rainbow_eucalyptus_wood");
    public static final BlockRegistryObject<Block> REDWOOD_WOOD = createWood("redwood_wood");
    public static final BlockRegistryObject<Block> SKYRIS_WOOD = createWood("skyris_wood");
    public static final BlockRegistryObject<Block> WILLOW_WOOD = createWood("willow_wood");
    public static final BlockRegistryObject<Block> WITCH_HAZEL_WOOD = createWood("witch_hazel_wood");
    public static final BlockRegistryObject<Block> ZELKOVA_WOOD = createWood("zelkova_wood");
    public static final BlockRegistryObject<Block> SYTHIAN_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "sythian_hyphae");
    public static final BlockRegistryObject<Block> EMBUR_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "embur_hyphae");
    public static final BlockRegistryObject<Block> PALM_WOOD = createWood("palm_wood");
    public static final BlockRegistryObject<Block> LAMENT_WOOD = createBlock(BYGBlockProperties.BYGNetherWood::new, "lament_wood");
    public static final BlockRegistryObject<Block> WITHERING_OAK_WOOD = createWood("withering_oak_wood");
    public static final BlockRegistryObject<Block> BULBIS_WOOD = createBlock(BYGBlockProperties.BYGNetherWood::new, "bulbis_wood");
    public static final BlockRegistryObject<Block> NIGHTSHADE_WOOD = createWood("nightshade_wood");
    public static final BlockRegistryObject<Block> ETHER_WOOD = createWood("ether_wood");
    public static final BlockRegistryObject<Block> IMPARIUS_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "imparius_hyphae");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "fungal_imparius_hyphae");

    public static final BlockRegistryObject<Block> WHITE_PUFFBALL = createWhitePuffBlock(SoundType.FUNGUS, MaterialColor.TERRACOTTA_WHITE, "white_puffball");
    public static final BlockRegistryObject<Block> WEEPING_MILKCAP = createMushroomPlant(new BYGMushroomToHugeMushroom.WeepingMilkCap(), "weeping_milkcap");
    public static final BlockRegistryObject<Block> WOOD_BLEWIT = createMushroomPlant(new BYGMushroomToHugeMushroom.WoodBlewit(), "wood_blewit");
    public static final BlockRegistryObject<Block> GREEN_MUSHROOM = createMushroomPlant(new BYGMushroomToHugeMushroom.GreenMushroom(), "green_mushroom");

    public static final BlockRegistryObject<Block> SYTHIAN_FUNGUS = createNetherMushroomPlant(new BYGMushroomToHugeMushroom.SythianFungus(), "sythian_fungus");
    public static final BlockRegistryObject<Block> SOUL_SHROOM = createNetherMushroomPlant(new BYGMushroomToHugeMushroom.SoulShroom(), "soul_shroom");
    public static final BlockRegistryObject<Block> DEATH_CAP = createNetherMushroomPlant(new BYGMushroomToHugeMushroom.DeathCap(), "death_cap");

    public static final BlockRegistryObject<Block> BULBIS_ODDITY = createMushroomPlant(new BYGMushroomToHugeMushroom.Bulbis(), "bulbis_oddity");
    public static final BlockRegistryObject<Block> PURPLE_BULBIS_ODDITY = createMushroomPlant(new BYGMushroomToHugeMushroom.PurpleBulbis(), "purple_bulbis_oddity");
    public static final BlockRegistryObject<Block> SHULKREN_FUNGUS = createMushroomPlant(new BYGMushroomToHugeMushroom.ShulkrenFungus(), "shulkren_fungus");
    public static final BlockRegistryObject<Block> IMPARIUS_MUSHROOM = createMushroomPlant(new BYGMushroomToHugeMushroom.ImpariusMushroom(), "imparius_mushroom");
    public static final BlockRegistryObject<Block> FUNGAL_IMPARIUS = createMushroomPlant(new BYGMushroomToHugeMushroom.FungalImparius(), "fungal_imparius");

    public static final BlockRegistryObject<Block> BULBIS_ANOMALY = createTallBulbis("bulbis_anomaly");
    public static final BlockRegistryObject<Block> PURPLE_BULBIS_ANOMALY = createTallBulbis("purple_bulbis_anomaly");

    public static final BlockRegistryObject<Block> SOUL_SHROOM_SPORE = createBlock(BYGBlockProperties.BYGSoulShroomSpore::new, "soul_shroom_spore");
    public static final BlockRegistryObject<Block> SOUL_SHROOM_SPORE_END = createBlock(BYGBlockProperties.BYGSoulShroomSporeEnd::new, "soul_shroom_spore_end");

    public static final BlockRegistryObject<Block> RAW_PENDORITE_BLOCK = createRawPendoriteBlock("raw_pendorite_block");
    public static final BlockRegistryObject<Block> PENDORITE_ORE = createPendoriteOre("pendorite_ore");
    public static final BlockRegistryObject<Block> AMETRINE_ORE = createAmetrineOre("ametrine_ore");
    public static final BlockRegistryObject<Block> PENDORITE_BLOCK = createPendoriteBlock("pendorite_block");
    public static final BlockRegistryObject<Block> AMETRINE_BLOCK = createAmetrineBlock("ametrine_block");
    public static final BlockRegistryObject<Block> BUDDING_AMETRINE_ORE = createBuddingAmetrineOre("budding_ametrine_ore");
    public static final BlockRegistryObject<Block> AMETRINE_CLUSTER = createAmetrineCluster("ametrine_cluster");
    public static final BlockRegistryObject<Block> DACITE = createDacite("dacite");
    public static final BlockRegistryObject<Block> DACITE_SLAB = createStoneSlab("dacite_slab");
    public static final BlockRegistryObject<Block> DACITE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_stairs");
    public static final BlockRegistryObject<Block> DACITE_WALL = createStoneWall("dacite_wall");
    public static final BlockRegistryObject<Block> DACITE_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "dacite_bricks");
    public static final BlockRegistryObject<Block> DACITE_BRICK_SLAB = createStoneSlab("dacite_brick_slab");
    public static final BlockRegistryObject<Block> DACITE_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_brick_stairs");
    public static final BlockRegistryObject<Block> DACITE_BRICK_WALL = createStoneWall("dacite_brick_wall");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE = createBlock(BYGBlockProperties.BYGStone::new, "dacite_cobblestone");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_SLAB = createStoneSlab("dacite_cobblestone_slab");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_cobblestone_stairs");
    public static final BlockRegistryObject<Block> DACITE_COBBLESTONE_WALL = createStoneWall("dacite_cobblestone_wall");
    public static final BlockRegistryObject<Block> DACITE_PILLAR = createBlock(BYGBlockProperties.BYGPillar::new, "dacite_pillar");
    public static final BlockRegistryObject<Block> DACITE_TILE = createBlock(BYGBlockProperties.BYGStone::new, "dacite_tile");
    public static final BlockRegistryObject<Block> DACITE_TILE_SLAB = createStoneSlab("dacite_tile_slab");
    public static final BlockRegistryObject<Block> DACITE_TILE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "dacite_tile_stairs");
    public static final BlockRegistryObject<Block> DACITE_TILE_WALL = createStoneWall("dacite_tile_wall");

    public static final BlockRegistryObject<Block> RED_ROCK = createRedRock("red_rock");
    public static final BlockRegistryObject<Block> RED_ROCK_SLAB = createStoneSlab("red_rock_slab");
    public static final BlockRegistryObject<Block> RED_ROCK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "red_rock_stairs");
    public static final BlockRegistryObject<Block> RED_ROCK_WALL = createStoneWall("red_rock_wall");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "red_rock_bricks");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_SLAB = createStoneSlab("red_rock_brick_slab");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> RED_ROCK_BRICK_WALL = createStoneWall("red_rock_brick_wall");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "cracked_red_rock_bricks");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_SLAB = createStoneSlab("cracked_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "cracked_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> CRACKED_RED_ROCK_BRICK_WALL = createStoneWall("cracked_red_rock_brick_wall");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "chiseled_red_rock_bricks");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_SLAB = createStoneSlab("chiseled_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "chiseled_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> CHISELED_RED_ROCK_BRICK_WALL = createStoneWall("chiseled_red_rock_brick_wall");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "mossy_red_rock_bricks");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_SLAB = createStoneSlab("mossy_red_rock_brick_slab");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "mossy_red_rock_brick_stairs");
    public static final BlockRegistryObject<Block> MOSSY_RED_ROCK_BRICK_WALL = createStoneWall("mossy_red_rock_brick_wall");

    public static final BlockRegistryObject<Block> MOSSY_STONE = createMossyStone("mossy_stone");
    public static final BlockRegistryObject<Block> MOSSY_STONE_SLAB = createStoneSlab("mossy_stone_slab");
    public static final BlockRegistryObject<Block> MOSSY_STONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "mossy_stone_stairs");
    public static final BlockRegistryObject<Block> MOSSY_STONE_WALL = createStoneWall("mossy_stone_wall");

    public static final BlockRegistryObject<Block> ROCKY_STONE = createRockyStone("rocky_stone");
    public static final BlockRegistryObject<Block> ROCKY_SLAB = createStoneSlab("rocky_stone_slab");
    public static final BlockRegistryObject<Block> ROCKY_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "rocky_stone_stairs");
    public static final BlockRegistryObject<Block> ROCKY_WALL = createStoneWall("rocky_stone_wall");

    public static final BlockRegistryObject<Block> TRAVERTINE = createTravertine("travertine");
    public static final BlockRegistryObject<Block> TRAVERTINE_SLAB = createTravertineSlab("travertine_slab");
    public static final BlockRegistryObject<Block> TRAVERTINE_STAIRS = createTravertineStairs("travertine_stairs");
    public static final BlockRegistryObject<Block> TRAVERTINE_WALL = createTravertineWall("travertine_wall");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE = createTravertine("polished_travertine");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_SLAB = createTravertineSlab("polished_travertine_slab");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_STAIRS = createTravertineStairs("polished_travertine_stairs");
    public static final BlockRegistryObject<Block> POLISHED_TRAVERTINE_WALL = createTravertineWall("polished_travertine_wall");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE = createTravertine("chiseled_travertine");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_SLAB = createTravertineSlab("chiseled_travertine_slab");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_STAIRS = createTravertineStairs("chiseled_travertine_stairs");
    public static final BlockRegistryObject<Block> CHISELED_TRAVERTINE_WALL = createTravertineWall("chiseled_travertine_wall");

    public static final BlockRegistryObject<Block> SCORIA_STONE = createScoria("scoria_stone");
    public static final BlockRegistryObject<Block> SCORIA_SLAB = createScoriaStoneSlab("scoria_stone_slab");
    public static final BlockRegistryObject<Block> SCORIA_STAIRS = createScoriaStoneStairs("scoria_stone_stairs");
    public static final BlockRegistryObject<Block> SCORIA_WALL = createScoriaStoneWall("scoria_stone_wall");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE = createScoria("scoria_cobblestone");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_SLAB = createScoriaStoneSlab("scoria_cobblestone_slab");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_STAIRS = createScoriaStoneStairs("scoria_cobblestone_stairs");
    public static final BlockRegistryObject<Block> SCORIA_COBBLESTONE_WALL = createScoriaStoneWall("scoria_cobblestone_wall");
    public static final BlockRegistryObject<Block> SCORIA_PILLAR = createScoriaStonePillar("scoria_pillar");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICKS = createScoria("scoria_stonebricks");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_SLAB = createScoriaStoneSlab("scoria_stonebrick_slab");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_STAIRS = createScoriaStoneStairs("scoria_stonebrick_stairs");
    public static final BlockRegistryObject<Block> SCORIA_STONEBRICK_WALL = createScoriaStoneWall("scoria_stonebrick_wall");
    public static final BlockRegistryObject<Block> CRACKED_SCORIA_STONE_BRICKS = createScoria("cracked_scoria_stone_bricks");
    public static final BlockRegistryObject<Block> EMERALDITE_ORE = createEmeralditeOre("emeraldite_ore");

    public static final BlockRegistryObject<Block> DUSTED_POLISHED_BLACKSTONE_BRICKS = createDustedPolishedBlackstoneBricks("dusted_polished_blackstone_bricks");
    public static final BlockRegistryObject<Block> ARISIAN_BLOOM_BRANCH = createArisianBloomBranch("arisian_bloom_branch");

    public static final BlockRegistryObject<Block> SOAPSTONE = createSoapstone("soapstone");
    public static final BlockRegistryObject<Block> SOAPSTONE_SLAB = createStoneSlab("soapstone_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_WALL = createStoneWall("soapstone_wall");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE = createBlock(BYGBlockProperties.BYGStone::new, "polished_soapstone");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_SLAB = createStoneSlab("polished_soapstone_slab");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "polished_soapstone_stairs");
    public static final BlockRegistryObject<Block> POLISHED_SOAPSTONE_WALL = createStoneWall("polished_soapstone_wall");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICKS = createBlock(BYGBlockProperties.BYGStone::new, "soapstone_bricks");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_SLAB = createStoneSlab("soapstone_brick_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_brick_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_BRICK_WALL = createStoneWall("soapstone_brick_wall");
    public static final BlockRegistryObject<Block> SOAPSTONE_PILLAR = createBlock(BYGBlockProperties.BYGPillar::new, "soapstone_pillar");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE = createBlock(BYGBlockProperties.BYGStone::new, "soapstone_tile");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_SLAB = createStoneSlab("soapstone_tile_slab");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_STAIRS = createBlock(BYGBlockProperties.BYGStoneStairs::new, "soapstone_tile_stairs");
    public static final BlockRegistryObject<Block> SOAPSTONE_TILE_WALL = createStoneWall("soapstone_tile_wall");

    public static final BlockRegistryObject<Block> STRIPPED_ASPEN_LOG = createStrippedLog("stripped_aspen_log");
    public static final BlockRegistryObject<Block> STRIPPED_BAOBAB_LOG = createStrippedLog("stripped_baobab_log");
    public static final BlockRegistryObject<Block> STRIPPED_BLUE_ENCHANTED_LOG = createStrippedLog("stripped_blue_enchanted_log");
    public static final BlockRegistryObject<Block> STRIPPED_CHERRY_LOG = createStrippedLog("stripped_cherry_log");
    public static final BlockRegistryObject<Block> STRIPPED_CIKA_LOG = createStrippedLog("stripped_cika_log");
    public static final BlockRegistryObject<Block> STRIPPED_CYPRESS_LOG = createStrippedLog("stripped_cypress_log");
    public static final BlockRegistryObject<Block> STRIPPED_EBONY_LOG = createStrippedLog("stripped_ebony_log");
    public static final BlockRegistryObject<Block> STRIPPED_FIR_LOG = createStrippedLog("stripped_fir_log");
    public static final BlockRegistryObject<Block> STRIPPED_GREEN_ENCHANTED_LOG = createStrippedLog("stripped_green_enchanted_log");
    public static final BlockRegistryObject<Block> STRIPPED_HOLLY_LOG = createStrippedLog("stripped_holly_log");
    public static final BlockRegistryObject<Block> STRIPPED_JACARANDA_LOG = createStrippedLog("stripped_jacaranda_log");
    public static final BlockRegistryObject<Block> STRIPPED_MAHOGANY_LOG = createStrippedLog("stripped_mahogany_log");
    public static final BlockRegistryObject<Block> STRIPPED_MANGROVE_LOG = createStrippedLog("stripped_mangrove_log");
    public static final BlockRegistryObject<Block> STRIPPED_MAPLE_LOG = createStrippedLog("stripped_maple_log");
    public static final BlockRegistryObject<Block> STRIPPED_PALO_VERDE_LOG = createStrippedLog("stripped_palo_verde_log");
    public static final BlockRegistryObject<Block> STRIPPED_PINE_LOG = createStrippedLog("stripped_pine_log");
    public static final BlockRegistryObject<Block> STRIPPED_RAINBOW_EUCALYPTUS_LOG = createStrippedLog("stripped_rainbow_eucalyptus_log");
    public static final BlockRegistryObject<Block> STRIPPED_SKYRIS_LOG = createStrippedLog("stripped_skyris_log");
    public static final BlockRegistryObject<Block> STRIPPED_WILLOW_LOG = createStrippedLog("stripped_willow_log");
    public static final BlockRegistryObject<Block> STRIPPED_REDWOOD_LOG = createStrippedLog("stripped_redwood_log");
    public static final BlockRegistryObject<Block> STRIPPED_WITCH_HAZEL_LOG = createStrippedLog("stripped_witch_hazel_log");
    public static final BlockRegistryObject<Block> STRIPPED_ZELKOVA_LOG = createStrippedLog("stripped_zelkova_log");
    public static final BlockRegistryObject<Block> STRIPPED_SYTHIAN_STEM = createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_sythian_stem");
    public static final BlockRegistryObject<Block> STRIPPED_EMBUR_PEDU = createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_embur_pedu");
    public static final BlockRegistryObject<Block> STRIPPED_PALM_LOG = createStrippedLog("stripped_palm_log");
    public static final BlockRegistryObject<Block> STRIPPED_LAMENT_LOG = createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_lament_log");
    public static final BlockRegistryObject<Block> STRIPPED_BULBIS_LOG = createBlock(BYGBlockProperties.BYGNetherLog::new, "stripped_bulbis_stem");
    public static final BlockRegistryObject<Block> STRIPPED_NIGHTSHADE_LOG = createStrippedLog("stripped_nightshade_log");
    public static final BlockRegistryObject<Block> STRIPPED_ETHER_LOG = createStrippedLog("stripped_ether_log");

    public static final BlockRegistryObject<Block> STRIPPED_ASPEN_WOOD = createWood("stripped_aspen_wood");
    public static final BlockRegistryObject<Block> STRIPPED_BAOBAB_WOOD = createWood("stripped_baobab_wood");
    public static final BlockRegistryObject<Block> STRIPPED_BLUE_ENCHANTED_WOOD = createWood("stripped_blue_enchanted_wood");
    public static final BlockRegistryObject<Block> STRIPPED_CHERRY_WOOD = createWood("stripped_cherry_wood");
    public static final BlockRegistryObject<Block> STRIPPED_CIKA_WOOD = createWood("stripped_cika_wood");
    public static final BlockRegistryObject<Block> STRIPPED_CYPRESS_WOOD = createWood("stripped_cypress_wood");
    public static final BlockRegistryObject<Block> STRIPPED_EBONY_WOOD = createWood("stripped_ebony_wood");
    public static final BlockRegistryObject<Block> STRIPPED_FIR_WOOD = createWood("stripped_fir_wood");
    public static final BlockRegistryObject<Block> STRIPPED_GREEN_ENCHANTED_WOOD = createWood("stripped_green_enchanted_wood");
    public static final BlockRegistryObject<Block> STRIPPED_HOLLY_WOOD = createWood("stripped_holly_wood");
    public static final BlockRegistryObject<Block> STRIPPED_JACARANDA_WOOD = createWood("stripped_jacaranda_wood");
    public static final BlockRegistryObject<Block> STRIPPED_MAHOGANY_WOOD = createWood("stripped_mahogany_wood");
    public static final BlockRegistryObject<Block> STRIPPED_MANGROVE_WOOD = createWood("stripped_mangrove_wood");
    public static final BlockRegistryObject<Block> STRIPPED_MAPLE_WOOD = createWood("stripped_maple_wood");
    public static final BlockRegistryObject<Block> STRIPPED_PALO_VERDE_WOOD = createWood("stripped_palo_verde_wood");
    public static final BlockRegistryObject<Block> STRIPPED_PINE_WOOD = createWood("stripped_pine_wood");
    public static final BlockRegistryObject<Block> STRIPPED_RAINBOW_EUCALYPTUS_WOOD = createWood("stripped_rainbow_eucalyptus_wood");
    public static final BlockRegistryObject<Block> STRIPPED_SKYRIS_WOOD = createWood("stripped_skyris_wood");
    public static final BlockRegistryObject<Block> STRIPPED_WILLOW_WOOD = createWood("stripped_willow_wood");
    public static final BlockRegistryObject<Block> STRIPPED_REDWOOD_WOOD = createWood("stripped_redwood_wood");
    public static final BlockRegistryObject<Block> STRIPPED_WITCH_HAZEL_WOOD = createWood("stripped_witch_hazel_wood");
    public static final BlockRegistryObject<Block> STRIPPED_ZELKOVA_WOOD = createWood("stripped_zelkova_wood");
    public static final BlockRegistryObject<Block> STRIPPED_SYTHIAN_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "stripped_sythian_hyphae");
    public static final BlockRegistryObject<Block> STRIPPED_EMBUR_HYPHAE = createBlock(BYGBlockProperties.BYGNetherWood::new, "stripped_embur_hyphae");
    public static final BlockRegistryObject<Block> STRIPPED_PALM_WOOD = createWood("stripped_palm_wood");
    public static final BlockRegistryObject<Block> STRIPPED_LAMENT_WOOD = createBlock(BYGBlockProperties.BYGNetherWood::new, "stripped_lament_wood");
    public static final BlockRegistryObject<Block> STRIPPED_BULBIS_WOOD = createBlock(BYGBlockProperties.BYGNetherWood::new, "stripped_bulbis_wood");
    public static final BlockRegistryObject<Block> STRIPPED_NIGHTSHADE_WOOD = createWood("stripped_nightshade_wood");
    public static final BlockRegistryObject<Block> STRIPPED_ETHER_WOOD = createWood("stripped_ether_wood");

    public static final BlockRegistryObject<Block> TALL_ALLIUM = createTallFlower("tall_allium", BYGBlockTags.GROUND_TALL_ALLIUM);
    public static final BlockRegistryObject<Block> TALL_PINK_ALLIUM = createTallFlower("tall_pink_allium", BYGBlockTags.GROUND_TALL_PINK_ALLIUM);
    public static final BlockRegistryObject<Block> ALLIUM_FLOWER_BUSH = createBlock(BYGBlockProperties.BYGAllium::new, "allium_flower_bush");
    public static final BlockRegistryObject<Block> AMARANTH = createBlock(BYGBlockProperties.BYGAmaranth::new, "amaranth");
    public static final BlockRegistryObject<Block> ALPINE_BELLFLOWER = createFlower("alpine_bellflower", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> ANGELICA = createFlower("angelica", BYGBlockTags.GROUND_ANGELICA);
    public static final BlockRegistryObject<Block> BARREL_CACTUS = createBarrelCactus("barrel_cactus");
    public static final BlockRegistryObject<Block> FLOWERING_BARREL_CACTUS = createBarrelCactus("flowering_barrel_cactus");
    public static final BlockRegistryObject<Block> CARVED_BARREL_CACTUS = createCarvedBarrelCactus("carved_barrel_cactus");
    public static final BlockRegistryObject<Block> WATER_BARREL_CACTUS = createWaterBarrelCactus("water_barrel_cactus");
    public static final BlockRegistryObject<Block> HONEY_BARREL_CACTUS = createHoneyBarrelCactus("honey_barrel_cactus");
    public static final BlockRegistryObject<Block> BEGONIA = createFlower("begonia", BYGBlockTags.GROUND_BEGONIA);
    public static final BlockRegistryObject<Block> BISTORT = createFlower("bistort", BYGBlockTags.GROUND_BISTORT);
    public static final BlockRegistryObject<Block> BLUE_SAGE = createFlower("blue_sage", BYGBlockTags.GROUND_BLUE_SAGE);
    public static final BlockRegistryObject<Block> CALIFORNIA_POPPY = createFlower("california_poppy", BYGBlockTags.GROUND_CALIFORNIA_POPPY);
    public static final BlockRegistryObject<Block> CROCUS = createFlower("crocus", BYGBlockTags.GROUND_CROCUS);
    public static final BlockRegistryObject<Block> BLACK_ROSE = createFlower("black_rose", BYGBlockTags.GROUND_BLACK_ROSE);
    public static final BlockRegistryObject<Block> CYAN_AMARANTH = createBlock(BYGBlockProperties.BYGAmaranth::new, "cyan_amaranth");
    public static final BlockRegistryObject<Block> CYAN_ROSE = createFlower("cyan_rose", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> CYAN_TULIP = createFlower("cyan_tulip", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> DAFFODIL = createFlower("daffodil", BYGBlockTags.GROUND_ALPINE_BELLFLOWER);
    public static final BlockRegistryObject<Block> DELPHINIUM = createTallFlower("delphinium", BYGBlockTags.GROUND_DELPHINIUM);
    public static final BlockRegistryObject<Block> FAIRY_SLIPPER = createPottedBlock(BYGBlockProperties.BYGFairySlipperFlower::new, "fairy_slipper");
    public static final BlockRegistryObject<Block> FIRECRACKER_FLOWER_BUSH = createShrub(TreeSpawners.FIRECRACKER, "firecracker_flower_bush");
    public static final BlockRegistryObject<Block> FOXGLOVE = createTallFlower("foxglove", BYGBlockTags.GROUND_FOXGLOVE);
    public static final BlockRegistryObject<Block> GOLDEN_SPINED_CACTUS = createDesertPlant("golden_spined_cactus", BYGBlockTags.GROUND_GOLDEN_SPINED_CACTUS);
    public static final BlockRegistryObject<Block> GREEN_TULIP = createFlower("green_tulip", BYGBlockTags.GROUND_GREEN_TULIP);
    public static final BlockRegistryObject<Block> GUZMANIA = createFlower("guzmania", BYGBlockTags.GROUND_GUZMANIA);
    public static final BlockRegistryObject<Block> INCAN_LILY = createFlower("incan_lily", BYGBlockTags.GROUND_INCAN_LILY);
    public static final BlockRegistryObject<Block> IRIS = createFlower("iris", BYGBlockTags.GROUND_IRIS);
    public static final BlockRegistryObject<Block> JAPANESE_ORCHID = createTallFlower("japanese_orchid", BYGBlockTags.GROUND_JAPANESE_ORCHID);
    public static final BlockRegistryObject<Block> KOVAN_FLOWER = createFlower("kovan_flower", BYGBlockTags.GROUND_KOVAN_FLOWER);
    public static final BlockRegistryObject<Block> LAZARUS_BELLFLOWER = createFlower("lazarus_bellflower", BYGBlockTags.GROUND_LAZARUS_BELLFLOWER);
    public static final BlockRegistryObject<Block> LOLLIPOP_FLOWER = createFlower("lollipop_flower", BYGBlockTags.GROUND_LOLLIPOP_FLOWER);
    public static final BlockRegistryObject<Block> MAGENTA_AMARANTH = createBlock(BYGBlockProperties.BYGAmaranth::new, "magenta_amaranth");
    public static final BlockRegistryObject<Block> MAGENTA_TULIP = createFlower("magenta_tulip", BYGBlockTags.GROUND_MAGENTA_TULIP);
    public static final BlockRegistryObject<Block> ORANGE_AMARANTH = createBlock(BYGBlockProperties.BYGAmaranth::new, "orange_amaranth");
    public static final BlockRegistryObject<Block> ORANGE_DAISY = createFlower("orange_daisy", BYGBlockTags.GROUND_ORANGE_DAISY);
    public static final BlockRegistryObject<Block> ORSIRIA_ROSE = createFlower("osiria_rose", BYGBlockTags.GROUND_ORSIRIA_ROSE);
    public static final BlockRegistryObject<Block> PEACH_LEATHER_FLOWER = createFlower("peach_leather_flower", BYGBlockTags.GROUND_PEACH_LEATHER_FLOWER);
    public static final BlockRegistryObject<Block> PINK_ALLIUM = createFlower("pink_allium", BYGBlockTags.GROUND_PINK_ALLIUM);
    public static final BlockRegistryObject<Block> PINK_ALLIUM_FLOWER_BUSH = createBlock(BYGBlockProperties.BYGPinkAllium::new, "pink_allium_flower_bush");
    public static final BlockRegistryObject<Block> PINK_ANEMONE = createFlower("pink_anemone", BYGBlockTags.GROUND_PINK_ANEMONE);
    public static final BlockRegistryObject<Block> PINK_DAFFODIL = createFlower("pink_daffodil", BYGBlockTags.GROUND_PINK_DAFFODIL);
    public static final BlockRegistryObject<Block> PRAIRIE_GRASS = createBlock(BYGBlockProperties.BYGPrairieGrass::new, "prairie_grass");
    public static final BlockRegistryObject<Block> PROTEA_FLOWER = createFlower("protea_flower", BYGBlockTags.GROUND_PROTEA_FLOWER);
    public static final BlockRegistryObject<Block> PURPLE_AMARANTH = createBlock(BYGBlockProperties.BYGAmaranth::new, "purple_amaranth");
    public static final BlockRegistryObject<Block> PURPLE_SAGE = createFlower("purple_sage", BYGBlockTags.GROUND_PURPLE_SAGE);
    public static final BlockRegistryObject<Block> PURPLE_TULIP = createFlower("purple_tulip", BYGBlockTags.GROUND_PURPLE_TULIP);
    public static final BlockRegistryObject<Block> RICHEA = createFlower("richea", BYGBlockTags.GROUND_RICHEA);
    public static final BlockRegistryObject<Block> ROSE = createFlower("rose", BYGBlockTags.GROUND_ROSE);
    public static final BlockRegistryObject<Block> SNOWDROPS = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "snowdrops");
    public static final BlockRegistryObject<Block> SILVER_VASE_FLOWER = createFlower("silver_vase_flower", BYGBlockTags.GROUND_SILVER_VASE_FLOWER);
    public static final BlockRegistryObject<Block> TORCH_GINGER = createFlower("torch_ginger", BYGBlockTags.GROUND_TORCH_GINGER);
    public static final BlockRegistryObject<Block> VIOLET_LEATHER_FLOWER = createFlower("violet_leather_flower", BYGBlockTags.GROUND_VIOLET_LEATHER_FLOWER);
    public static final BlockRegistryObject<Block> WHITE_ANEMONE = createFlower("white_anemone", BYGBlockTags.GROUND_WHITE_ANEMONE);
    public static final BlockRegistryObject<Block> WHITE_SAGE = createFlower("white_sage", BYGBlockTags.GROUND_WHITE_SAGE);
    public static final BlockRegistryObject<Block> WINTER_CYCLAMEN = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_cyclamen");
    public static final BlockRegistryObject<Block> WINTER_ROSE = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_rose");
    public static final BlockRegistryObject<Block> WINTER_SCILLA = createPottedBlock(BYGBlockProperties.BYGSnowyPlant::new, "winter_scilla");
    public static final BlockRegistryObject<Block> YELLOW_DAFFODIL = createFlower("yellow_daffodil", BYGBlockTags.GROUND_YELLOW_DAFFODIL);
    public static final BlockRegistryObject<Block> YELLOW_TULIP = createFlower("yellow_tulip", BYGBlockTags.GROUND_YELLOW_TULIP);
    public static final BlockRegistryObject<Block> HYDRANGEA_BUSH = createHydrangeaBush("hydrangea_bush", BYGBlockTags.GROUND_HYDRANGEA_BUSH);
    public static final BlockRegistryObject<Block> HYDRANGEA_HEDGE = createHydrangeaHedge("hydrangea_hedge", BYGBlockTags.GROUND_HYDRANGEA_BUSH);
    public static final BlockRegistryObject<Block> PODZOL_DACITE = createBlock(() -> SnowyDirtBlockAccess.byg_create(BlockBehaviour.Properties.copy(BYGBlocks.DACITE.get())), "podzol_dacite");
    public static final BlockRegistryObject<Block> OVERGROWN_DACITE = createStoneSpreadable(DACITE, MaterialColor.COLOR_GREEN, "overgrown_dacite");
    public static final BlockRegistryObject<Block> OVERGROWN_STONE = createStoneSpreadable(() -> Blocks.STONE, MaterialColor.COLOR_GREEN, "overgrown_stone");
    public static final BlockRegistryObject<Block> OVERGROWN_CRIMSON_BLACKSTONE = createNetherStoneSpreadable(Blocks.BLACKSTONE, MaterialColor.COLOR_RED, () -> NetherFeatures.CRIMSON_FOREST_VEGETATION_BONEMEAL.value(), "overgrown_crimson_blackstone");
    public static final BlockRegistryObject<Block> MYCELIUM_NETHERRACK = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_GRAY, () -> BYGNetherVegetationFeatures.WAILING_VEGETATION.value(), "mycelium_netherrack");
    public static final BlockRegistryObject<Block> OVERGROWN_NETHERRACK = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_GREEN, () -> NetherFeatures.TWISTING_VINES_BONEMEAL.value(), "overgrown_netherrack");
    public static final BlockRegistryObject<Block> IVIS_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_PURPLE, () -> BYGEndVegetationFeatures.IVIS_PLANTS.value(), "ivis_phylium");
    public static final BlockRegistryObject<Block> EMBUR_NYLIUM = createNetherSpreadable(BLUE_NETHERRACK, MaterialColor.COLOR_ORANGE, () -> BYGNetherVegetationFeatures.EMBUR_SPROUT.value(), "embur_nylium");
    public static final BlockRegistryObject<Block> SYTHIAN_NYLIUM = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_YELLOW, () -> BYGNetherVegetationFeatures.SYTHIAN_VEGETATION.value(), "sythian_nylium");
    public static final BlockRegistryObject<Block> WAILING_NYLIUM = createNetherSpreadable(() -> Blocks.NETHERRACK, MaterialColor.COLOR_PURPLE, () -> BYGNetherVegetationFeatures.WAILING_VEGETATION.value(), "wailing_nylium");
    public static final BlockRegistryObject<Block> LUSH_GRASS_BLOCK = createDirtSpreadable(LUSH_DIRT, MaterialColor.COLOR_GREEN, "lush_grass_block");
    public static final BlockRegistryObject<Block> NIGHTSHADE_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_BLUE, () -> BYGEndVegetationFeatures.NIGHTSHADE_PLANTS.value(), "nightshade_phylium");
    public static final BlockRegistryObject<Block> ETHER_PHYLIUM = createEndDirtSpreadable(BYGBlocks.ETHER_SOIL, MaterialColor.COLOR_MAGENTA, () -> BYGEndVegetationFeatures.ETHER_PLANTS.value(), "ether_phylium");
    public static final BlockRegistryObject<Block> VERMILION_SCULK = createEndStoneSpreadable(BYGBlocks.ETHER_STONE, MaterialColor.COLOR_RED, () -> BYGEndFeatures.ISLAND_SCULK_PLANTS.value().feature().value(), "vermilion_sculk");
    public static final BlockRegistryObject<Block> SHULKREN_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_LIGHT_GREEN, () -> BYGEndVegetationFeatures.SHULKREN_PLANTS.value(), "shulkren_phylium");
    public static final BlockRegistryObject<DirtPathBlock> LUSH_GRASS_PATH = createBlock(() -> DirtPathBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.DIRT).strength(0.65F).sound(SoundType.GRASS).isViewBlocking((state, reader, pos) -> true).isSuffocating((state, reader, pos) -> true)), "lush_grass_path");
    public static final BlockRegistryObject<Block> BULBIS_PHYCELIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.TERRACOTTA_WHITE, () -> BYGEndVegetationFeatures.BULBIS_ANOMALIES.value(), "bulbis_phycelium");
    public static final BlockRegistryObject<Block> IMPARIUS_PHYLIUM = createEndStoneSpreadable(() -> Blocks.END_STONE, MaterialColor.COLOR_CYAN, () -> BYGEndVegetationFeatures.IMPARIUS_PLANTS.value(), "imparius_phylium");

    public static final BlockRegistryObject<Block> HYPOGEAL_IMPERIUM = createHypogealBlock("hypogeal_imperium");
//    public static final BlockRO<Block> BORIC_TORCH = createBlock(new BoricTorchBlock(AbstractBlock.Properties.of(Material.WOOD).instabreak().lightLevel((state) -> 14), BoricFlameParticle.BoricParticleData.BORIC), "boric_torch");

    static BlockRegistryObject<Block> createChiseledFungalImpariusSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledFungalImpariusStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledFungalImpariusWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).sound(SoundType.HONEY_BLOCK).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createSubzeroCrystalCluster(int light, int i, int j, String id) {
        return createBlock(() -> new AmethystClusterBlock(i, j, BlockBehaviour.Properties.of(BYGMaterials.SUBZERO_CRYSTAL).sound(SoundType.GLASS).strength(1.5f).requiresCorrectToolForDrops().noOcclusion().lightLevel((state) -> light)), id);
    }

    static BlockRegistryObject<Block> createHypogealBlock(String id) {
        return createBlock(() -> new HypogealImperiumBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.GLASS).strength(1.5f).requiresCorrectToolForDrops().lightLevel(litBlockEmission(13))), id);
    }

    static BlockRegistryObject<Block> createBuddingSubzeroCrystal(String id) {
        return createBlock(() -> new BuddingSubzeroCrystalBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.GLASS).lightLevel((state) -> 8).noDrops().randomTicks().requiresCorrectToolForDrops().strength(1.5f, 1.5f)), id);
    }

    static BlockRegistryObject<Block> createSubzeroCrystalBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE).sound(SoundType.GLASS).lightLevel((state) -> 8).strength(1.5f, 1.5f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createTravertineSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createTravertineStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createTravertineWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createScoriaStoneSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createScoriaStoneStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createScoriaStoneWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createScoriaStonePillar(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(1.5f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createWailingBellBlossom(String id) {
        return createBlock(() -> new WailingBulbBlossomBlock(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.COLOR_PURPLE).sound(SoundType.SHROOMLIGHT).noOcclusion().lightLevel((state) -> 14)), id);
    }

    static BlockRegistryObject<Block> createWailingVine(String id) {
        return createBlock(() -> new VineBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.TWISTING_VINES).instabreak().randomTicks().noCollission()), id);
    }

    static BlockRegistryObject<Block> createWailingPlant(String id) {
        return createBlock(() -> new WailingPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.ROOTS).instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createEmburGelBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.CLAY, MaterialColor.TERRACOTTA_YELLOW).sound(SoundType.HONEY_BLOCK).noOcclusion().speedFactor(1.3f)), id);
    }

    static BlockRegistryObject<Block> createEmburGelVine(String id) {
        return createBlock(() -> new EmburVineBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.TERRACOTTA_YELLOW).instabreak().randomTicks().sound(SoundType.HONEY_BLOCK).noCollission()), id);
    }

    static BlockRegistryObject<Block> createEmburGelVinePlant(String id) {
        return createBlock(() -> new EmburVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES, MaterialColor.TERRACOTTA_YELLOW).instabreak().randomTicks().sound(SoundType.HONEY_BLOCK).noCollission()), id);
    }

    static BlockRegistryObject<Block> createEmburGelBranch(String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.TERRACOTTA_YELLOW).instabreak().sound(SoundType.HONEY_BLOCK).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    static BlockRegistryObject<Block> createArisianBloomBranch(String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.COLOR_PURPLE).instabreak().sound(SoundType.GRASS).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    static BlockRegistryObject<Block> createTheriumBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).sound(SoundType.GLASS).noDrops().lightLevel((state) -> 12).strength(-1.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createTheriumGlass(String id) {
        return createBlock(() -> new GlassBlock(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).sound(SoundType.GLASS).lightLevel((state) -> 12).noOcclusion().isValidSpawn(BYGBlocks::neverAllowSpawn).isRedstoneConductor(BYGBlocks::isntSolid).isSuffocating(BYGBlocks::isntSolid).isViewBlocking(BYGBlocks::isntSolid).strength(0.4f, 8.0f)), id);
    }

    static BlockRegistryObject<Block> createTheriumGlassPane(String id) {
        return createBlock(() -> IronBarsBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN).sound(SoundType.GLASS).lightLevel((state) -> 12).noOcclusion().strength(0.4f, 8.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledTherium(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledTheriumStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PRISMARINE).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledTheriumSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createChiseledTheriumWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createShinyChiseledTherium(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createShinyChiseledTheriumStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Blocks.PRISMARINE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.PRISMARINE).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createShinyChiseledTheriumSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createShinyChiseledTheriumWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_CYAN).requiresCorrectToolForDrops().sound(SoundType.GLASS).lightLevel((state) -> 12).strength(1.5f, 9.0f)), id);
    }

    static BlockRegistryObject<Block> createFence(String id) {
        return createBlock(() -> new FenceBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createFenceGate(String id) {
        return createBlock(() -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createSand(MaterialColor color, int dustColor, String id) {
        return createBlock(() -> new SandBlock(dustColor, BlockBehaviour.Properties.of(Material.SAND, color).sound(SoundType.SAND).strength(0.2f)), id);
    }

    static BlockRegistryObject<Block> createSandstone(MaterialColor color, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createSandstoneSlab(MaterialColor color, String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createSandstoneWall(MaterialColor color, String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createSandstoneStairs(MaterialColor color, String id) {
        return createBlock(() -> StairBlockAccess.byg_create(BYGBlocks.WINDSWEPT_SANDSTONE.defaultBlockState(), BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createSandstonePillar(MaterialColor color, String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)), id);
    }

    static BlockRegistryObject<Block> createWoodSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createStoneSlab(String id) {
        return createBlock(() -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createStoneWall(String id) {
        return createBlock(() -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createWoodPressurePlate(String id) {
        return createBlock(() -> PressurePlateBlockAccess.byg_create(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).noCollission().strength(0.5F)), id);
    }

    static BlockRegistryObject<Block> createWoodStairs(String id) {
        return createBlock(() -> StairBlockAccess.byg_create(Registry.BLOCK.get(BYG.createLocation(id.replace("_stairs", "planks"))).defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createTrapDoor(String id) {
        return createBlock(() -> TrapDoorBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createCraftingTable(String id) {
        return createBlock(() -> new BYGCraftingTableBlock(BlockBehaviour.Properties.copy(Blocks.CRAFTING_TABLE)), id);
    }

    static BlockRegistryObject<Block> createWoodButton(String id) {
        return createBlock(() -> WoodButtonBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.DECORATION).sound(SoundType.WOOD).noCollission().strength(0.5F)), id);
    }

    static BlockRegistryObject<Block> createBookshelf(String id) {
        return createBlock(() -> new BookshelfBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createDoor(String id) {
        return createBlock(() -> DoorBlockAccess.byg_create(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createPlanks(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN).sound(SoundType.WOOD).strength(2.0f, 3.0f)), id);
    }

    static BlockRegistryObject<Block> createWood(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createStrippedLog(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createLog(String id) {
        return createBlock(() -> new RotatedPillarBlock(BlockBehaviour.Properties.of(Material.WOOD).sound(SoundType.WOOD).strength(2.0f)), id);
    }

    static BlockRegistryObject<Block> createSoapstone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLACK).sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createTravertine(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.SNOW).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createNetherStone(MaterialColor color, String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().sound(SoundType.NETHERRACK).strength(0.4f, 0.4f)), id);
    }

    static BlockRegistryObject<Block> createBoricFireBlock(MaterialColor color, String id) {
        return createBlock(() -> new BoricFireBlock(BlockBehaviour.Properties.of(Material.FIRE, color).sound(SoundType.WOOL).noCollission().instabreak().lightLevel((state) -> 14)), id);
    }

    static BlockRegistryObject<Block> createDesertPlant(String id, TagKey<Block> groundTag) {
        return createPottedBlock(() -> new DesertPlant(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    static BlockRegistryObject<Block> createCrypticFireBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticFireBlock(BlockBehaviour.Properties.of(Material.FIRE, color).sound(SoundType.WOOL).noCollission().instabreak().lightLevel((state) -> 14)), id);
    }

    static BlockRegistryObject<Block> createDustedPolishedBlackstoneBricks(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BRICKS).requiresCorrectToolForDrops().strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createScoria(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_RED).sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createDacite(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_WHITE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createEtherStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_CYAN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createRockyStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.STONE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createMossyStone(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_GREEN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createRedRock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_ORANGE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createAmetrineOre(String id) {
        return createBlock(() -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f), UniformInt.of(3, 9)), id);
    }

    static BlockRegistryObject<Block> createBuddingAmetrineOre(String id) {
        return createBlock(() -> new BuddingAmetrineBlock(BlockBehaviour.Properties.copy(Blocks.BUDDING_AMETHYST).requiresCorrectToolForDrops().sound(SoundType.STONE).randomTicks()), id);
    }

    static BlockRegistryObject<Block> createAmetrineBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PINK).isSuffocating(BYGBlocks::isntSolid).isViewBlocking(BYGBlocks::isntSolid).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.GLASS).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createCampfireBlock(int type, String id) {
        return createBlock(() -> new CampfireBlock(true, type, BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.PODZOL).strength(2.0F).sound(SoundType.WOOD).noOcclusion().lightLevel(litBlockEmission(14))), id);
    }


    static BlockRegistryObject<Block> createPendoriteOre(String id) {
        return createBlock(() -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createPendoriteBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createRawPendoriteBlock(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.TERRACOTTA_PURPLE).requiresCorrectToolForDrops().sound(SoundType.ANCIENT_DEBRIS).strength(1.5f, 6.0f)), id);
    }

    static BlockRegistryObject<Block> createEmeralditeOre(String id) {
        return createBlock(() -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_GREEN).requiresCorrectToolForDrops().sound(SoundType.STONE).strength(1.5f, 6.0f), UniformInt.of(4, 7)), id);
    }

    static BlockRegistryObject<Block> createNetherOre(SoundType sound, MaterialColor color, String id, UniformInt xpRange) {
        return createBlock(() -> new OreBlock(BlockBehaviour.Properties.of(Material.STONE, color).requiresCorrectToolForDrops().sound(sound).strength(3.0f, 3.0f), xpRange), id);
    }

    static BlockRegistryObject<Block> createBarrelCactus(String id) {
        return createBlock(() -> new AbstractBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }

    static BlockRegistryObject<Block> createCarvedBarrelCactus(String id) {
        return createBlock(() -> new CarvedBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }

    static BlockRegistryObject<Block> createWaterBarrelCactus(String id) {
        return createBlock(() -> new WaterBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }
    static BlockRegistryObject<Block> createHoneyBarrelCactus(String id) {
        return createBlock(() -> new HoneyBarrelCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS, MaterialColor.COLOR_GREEN).sound(SoundType.WOOL).strength(0.4f)), id);
    }

    static BlockRegistryObject<Block> createLanternBlock(MaterialColor color, String id) {
        return createBlock(() -> new LanternBlock(BlockBehaviour.Properties.of(Material.METAL, color).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.LANTERN).strength(3.5f).lightLevel((state) -> 15)), id);
    }

    static BlockRegistryObject<Block> createCrypticLanternBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticLanternBlock(BlockBehaviour.Properties.of(Material.METAL, color).noOcclusion().requiresCorrectToolForDrops().sound(SoundType.LANTERN).strength(3.5f).lightLevel((state) -> 15)), id);
    }

    static BlockRegistryObject<Block> createEndRodBlock(MaterialColor color, String id) {
        return createBlock(() -> new CrypticEndRodBlock(BlockBehaviour.Properties.of(Material.DECORATION, color).sound(SoundType.CANDLE).instabreak().noOcclusion().lightLevel((state) -> 14)), id);
    }

    static BlockRegistryObject<Block> createCattailSproutBlock(String id) {
        return createBlock(() -> new CattailSproutBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).randomTicks().noCollission().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createCattailPlantBlock(String id) {
        return createBlock(() -> new CattailPlantBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).noCollission().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createAloeVeraPlantBlock(String id) {
        return createBlock(() -> new AloeVeraBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).randomTicks().noCollission().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createBloomingAloeVeraPlantBlock(String id) {
        return createBlock(() -> new BloomingAloeVeraBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.TERRACOTTA_GREEN).sound(SoundType.WET_GRASS).strength(0.0f).noCollission().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createWhitePuffBlock(SoundType sound, MaterialColor color, String id) {
        return createPottedBlock(() -> new WhitePuffballBlock(BlockBehaviour.Properties.of(Material.PLANT, color).sound(sound).noOcclusion().noCollission().strength(0.0f).randomTicks()), id);
    }

    static BlockRegistryObject<Block> createMushroomPlant(BYGHugeMushroom mushroom, String id) {
        return createPottedBlock(() -> new BYGMushroomPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks(), mushroom, false), id);
    }

    static BlockRegistryObject<Block> createNetherMushroomPlant(BYGHugeMushroom mushroom, String id) {
        return createPottedBlock(() -> new BYGMushroomPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.FUNGUS).strength(0.0f).noCollission().randomTicks(), mushroom, true), id);
    }

    static BlockRegistryObject<Block> createHydrangeaBush(String id, TagKey<Block> groundTag) {
        return createPottedBlock(() -> new HydrangeaBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    static BlockRegistryObject<Block> createHydrangeaHedge(String id, TagKey<Block> groundTag) {
        return createBlock(() -> new HydrangeaHedgeBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.AZALEA).instabreak().noOcclusion(), groundTag), id);
    }

    static BlockRegistryObject<Block> createFlower(String id, TagKey<Block> groundTag) {
        return createPottedBlock(() -> new BYGFlowerBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    static BlockRegistryObject<Block> createTallFlower(String id, TagKey<Block> groundTag) {
        return createBlock(() -> new BYGTallFlowerBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().noOcclusion(), groundTag), id);
    }

    static BlockRegistryObject<Block> createStoneEndPlant(String id) {
        return createBlock(() -> new StoneEndPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createTallBulbis(String id) {
        return createBlock(() -> new TallBulbisBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.SHROOMLIGHT).strength(0.0f).noCollission().noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createVent(String id) {
        return createBlock(() -> new VentBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createTallVent(String id) {
        return createBlock(() -> new TallVentBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(2.0f, 6.0f).requiresCorrectToolForDrops()), id);
    }

    static BlockRegistryObject<Block> createTheriumCrystal(String id) {
        return createBlock(() -> new TheriumCrystalBlock(BlockBehaviour.Properties.of(Material.GLASS).sound(SoundType.GLASS).strength(0.1f).noOcclusion().requiresCorrectToolForDrops().noCollission().lightLevel((state) -> 6)), id);
    }

    static BlockRegistryObject<Block> createAmetrineCluster(String id) {
        return createBlock(() -> new AmethystClusterBlock(7, 3, BlockBehaviour.Properties.of(BYGMaterials.AMETRINE).sound(SoundType.GLASS).strength(1.5f).randomTicks().requiresCorrectToolForDrops().noCollission().lightLevel((state) -> 6)), id);
    }

    static BlockRegistryObject<Block> createDullCrystal(String id, TagKey<EntityType<?>> noInjury) {
        return createBlock(() -> new CrystalBlock(BlockBehaviour.Properties.of(Material.STONE).sound(SoundType.STONE).strength(0.1f).noOcclusion().noCollission().requiresCorrectToolForDrops(), noInjury), id);
    }

    static BlockRegistryObject<Block> createSculkGrowth(String id) {
        return createBlock(() -> new SculkGrowthBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().randomTicks().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createIvisBulbisPlant(String id) {
        return createBlock(() -> new IvisPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createEtherPlant(String id) {
        return createBlock(() -> new EtherPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createTallEtherPlant(String id) {
        return createBlock(() -> new TallEtherPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createNightshadePlant(String id) {
        return createBlock(() -> new NightshadePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createTallNightshadePlant(String id) {
        return createBlock(() -> new TallNightshadePlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).sound(SoundType.ROOTS).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createSculkPlant(String id) {
        return createBlock(() -> new SculkPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createImpariusPlant(String id) {
        return createBlock(() -> new ImpariusPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createOddityDesertPlant(String id) {
        return createBlock(() -> new DesertOddityPlantBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT).sound(SoundType.TWISTING_VINES).instabreak().noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createWarpedCactus(String id) {
        return createBlock(() -> new WarpedCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL).strength(0.2f).randomTicks().noOcclusion().lightLevel((state) -> 8)), id);
    }

    static BlockRegistryObject<Block> createOddityCactus(String id) {
        return createBlock(() -> new OddityCactusBlock(BlockBehaviour.Properties.of(Material.CACTUS).sound(SoundType.WOOL).strength(0.2f).randomTicks().noOcclusion().lightLevel((state) -> 8)), id);
    }

    static BlockRegistryObject<Block> createCrimsonBerryBush(String id) {
        return createBlock(() -> new CrimsonBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createBlueBerryBush(String id) {
        return createBlock(() -> new BlueBerryBush(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createBaobabFruitBlock(String id) {
        return createBlock(() -> new BaobabFruitBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createEtherBulbBlock(String id) {
        return createBlock(() -> new EtherBulbsBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).randomTicks().instabreak().lightLevel((state) -> state.getValue(EtherBulbsBlock.AGE) >= 2 ? 15 : 4).noCollission()), id);
    }

    static BlockRegistryObject<Block> createNightshadeBerryBush(String id) {
        return createNightshadeBerryBush(5, id);
    }

    static BlockRegistryObject<Block> createNightshadeBerryBush(int lightLevel, String id) {
        return createBlock(() -> new NightshadeBerryBushBlock(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.SWEET_BERRY_BUSH).lightLevel((state) -> lightLevel).randomTicks().instabreak().noCollission()), id);
    }

    static BlockRegistryObject<Block> createSapling(TagKey<Block> groundTag, String id) {
        final Supplier<Block> createBlock = () -> new BYGSapling(id, BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GRASS).strength(0.0f).noCollission().randomTicks(), groundTag);
        final var blockRo = createPottedBlock(createBlock, id);
        CommonSetupLoad.ENTRIES.add(() -> ((CommonSetupLoad) blockRo.get())::load);
        return blockRo;
    }

    static BlockRegistryObject<Block> createShrub(TreeSpawner tree, String id) {
        return createPottedBlock(() -> new ShrubBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_GREEN).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().noCollission(), tree), id);
    }

    static BlockRegistryObject<Block> createJacarandaBush(String id) {
        return createPottedBlock(() -> new JacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createFloweringJacarandaBush(int taskRange, TreeSpawner tree, String id) {
        return createPottedBlock(() -> new FloweringJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_PURPLE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion(), tree, taskRange), id);
    }

    static BlockRegistryObject<Block> createIndigoJacarandaBush(String id) {
        return createPottedBlock(() -> new IndigoJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createFloweringIndigoJacarandaBush(int taskRange, TreeSpawner tree, String id) {
        return createPottedBlock(() -> new FloweringJacarandaBushBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).sound(SoundType.SWEET_BERRY_BUSH).noOcclusion(), tree, taskRange), id);
    }

    public static BlockRegistryObject<Block> createPottedBlock(Supplier<Block> blockForPot, String id) {
        final var b = createBlock(blockForPot, id);
        final BlockRegistryObject<Block> potted = createBlock(() -> BYGBlockFactory.INSTANCE.createPottedBlock(b, BlockBehaviour.Properties.of(Material.DECORATION).instabreak().noOcclusion()), "potted_" + id);
        flowerPotBlocks.add(potted);
        return b;
    }

    static BlockRegistryObject<Block> createShroomlight(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_PURPLE).strength(1.0F).sound(SoundType.SHROOMLIGHT).lightLevel((state) -> 14)), id);
    }

    static BlockRegistryObject<Block> createImpariusVine(String id) {
        return createBlock(() -> new ImpariusVineBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    static BlockRegistryObject<Block> createImpariusVinePlant(String id) {
        return createBlock(() -> new ImpariusVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    static BlockRegistryObject<Block> createImpariusMushroom(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_CYAN).strength(0.2F).sound(SoundType.TWISTING_VINES).speedFactor(0.5F).jumpFactor(0.5F)), id);
    }

    static BlockRegistryObject<Block> createTreeBranchBlock(MaterialColor color, String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.WOOD).noOcclusion().noCollission()), id);
    }

    static BlockRegistryObject<Block> createGlowingTreeBranchBlock(MaterialColor color, String id) {
        return createBlock(() -> new TreeBranchBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.TWISTING_VINES).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    static BlockRegistryObject<Block> createWitchHazelBlossomBlock(MaterialColor color, String id) {
        return createBlock(() -> new WitchHazelBlossomBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, color).instabreak().sound(SoundType.TWISTING_VINES).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    static BlockRegistryObject<Block> createFungalImpariusFilamentBlock(String id) {
        return createBlock(() -> new SlimeBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE).strength(0.2F).sound(SoundType.HONEY_BLOCK).speedFactor(0.5F).jumpFactor(2.5F).lightLevel((state) -> 15)), id);
    }

    static BlockRegistryObject<Block> createFungalImpariusFilament(String id) {
        return createBlock(() -> new FungalImpariusFilamentBlock(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.COLOR_LIGHT_BLUE).instabreak().sound(SoundType.HONEY_BLOCK).noOcclusion().noCollission().lightLevel((state) -> 10)), id);
    }

    static BlockRegistryObject<Block> createFungalImparius(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS, MaterialColor.WARPED_WART_BLOCK).strength(0.2F).sound(SoundType.HONEY_BLOCK)), id);
    }

    static BlockRegistryObject<Block> createShulkrenVine(String id) {
        return createBlock(() -> new ShulkrenVineBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    static BlockRegistryObject<Block> createShulkrenVinePlant(String id) {
        return createBlock(() -> new ShulkrenVinePlantBlock(BlockBehaviour.Properties.of(Material.LEAVES).instabreak().randomTicks().sound(SoundType.WEEPING_VINES).noCollission()), id);
    }

    static BlockRegistryObject<Block> createLeaves(MaterialColor color, String id) {
        return createBlock(() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    static BlockRegistryObject<Block> createGlowingLeaves(MaterialColor color, int lightLevel, String id) {
        return createBlock(() -> new LeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false).lightLevel((state) -> lightLevel)), id);
    }

    static BlockRegistryObject<Block> createFirecrackerLeavesBlock(MaterialColor color, String id) {
        return createBlock(() -> new FirecrackerLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    static BlockRegistryObject<Block> createFloweringPaloVerdeLeaves(MaterialColor color, String id) {
        return createBlock(() -> new FloweringPaloVerdeLeavesBlock(BlockBehaviour.Properties.of(Material.LEAVES, color).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isViewBlocking((state, world, pos) -> false).isSuffocating((state, world, pos) -> false)), id);
    }

    static BlockRegistryObject<Block> createPetal(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.GRASS).sound(SoundType.GRASS).strength(0.2f).noOcclusion()), id);
    }

    static BlockRegistryObject<Block> createDirt(String id) {
        return createBlock(() -> new Block(BlockBehaviour.Properties.of(Material.DIRT).sound(SoundType.GRAVEL).strength(0.2f).randomTicks()), id);
    }

    static BlockRegistryObject<Block> createLushFarmland(String id) {
        return createBlock(() -> new LushFarmBlock(BlockBehaviour.Properties.copy(Blocks.FARMLAND).strength(0.2f)), id);
    }

    static BlockRegistryObject<Block> createDirtSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, String id) {
        return createBlock(() -> new BYGGrassBlock(BlockBehaviour.Properties.of(Material.DIRT, color).sound(SoundType.GRASS).strength(0.4f).randomTicks(), blockToSpreadToo.get()), id);
    }

    static BlockRegistryObject<Block> createStoneSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, String id) {
        return createBlock(() -> new BYGGrassBlock(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.STONE).strength(1.5f, 6.0f).randomTicks().requiresCorrectToolForDrops(), blockToSpreadToo.get()), id);
    }

    static BlockRegistryObject<Block> createEndStoneSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.STONE).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    static BlockRegistryObject<Block> createEndDirtSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    static BlockRegistryObject<Block> createNetherSpreadable(Supplier<? extends Block> blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4F).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo.get()), id);
    }

    static BlockRegistryObject<Block> createNetherStoneSpreadable(Block blockToSpreadToo, MaterialColor color, Supplier<ConfiguredFeature<?, ?>> feature, String id) {
        return createBlock(() -> new BYGNylium(BlockBehaviour.Properties.of(Material.STONE, color).sound(SoundType.NYLIUM).strength(0.4f).randomTicks().requiresCorrectToolForDrops(), feature, blockToSpreadToo), id);
    }

    private static BlockRegistryObject<Block> createSign(String id, WoodType type, Supplier<? extends Block> color) {
        return createSignSpecificColor(id, type, () -> color.get().defaultMaterialColor());
    }

    private static BlockRegistryObject<Block> createSignSpecificColor(String id, WoodType type, Supplier<? extends MaterialColor> color) {
        return BYGConstants.SIGNS ? createBlock(() -> new StandingSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).color(color.get()), type), id) : null;
    }

    private static BlockRegistryObject<Block> createWallSign(String id, WoodType type, Supplier<? extends Block> color) {
        return BYGConstants.SIGNS ? createSignSpecificColor(id, type, () -> color.get().defaultMaterialColor()) : null;
    }

    private static Block createWallSign(String id, WoodType type, MaterialColor color) {
        return null; //createBlock(new WallSignBlock(BlockBehaviour.Properties.copy(Blocks.OAK_SIGN).color(color), type), id);
    }

    public static <B extends Block> BlockRegistryObject<B> createBlock(Supplier<? extends B> block, String id) {
        final var ro = PROVIDER.<B>register(id, block);
        return BlockRegistryObject.wrap(ro);
    }

    private static Boolean neverAllowSpawn(BlockState state, BlockGetter reader, BlockPos pos, EntityType<?> entity) {
        return false;
    }

    private static boolean isntSolid(BlockState state, BlockGetter reader, BlockPos pos) {
        return false;
    }

    private static ToIntFunction<BlockState> litBlockEmission(int light) {
        return (state) -> {
            return state.getValue(BlockStateProperties.LIT) ? light : 0;
        };
    }

    public static void loadClass() {}
}
