package potionstudios.byg.common.item;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.boat.BYGBoatEntity;
import potionstudios.byg.mixin.access.AxeItemAccess;
import potionstudios.byg.mixin.access.HoeItemAccess;
import potionstudios.byg.mixin.access.PickaxeItemAccess;
import potionstudios.byg.util.RegistryObject;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BYGItems {

    public static final List<RegistryObject<Item>> ITEMS = new ArrayList<>();

    public static final Item BYG_LOGO = createItem(new Item((new Item.Properties())), "byg_logo");
    //TODO: Geckolib Mojmap 1.18
    //    public static final Item MAN_O_WAR_SPAWN_EGG = createItem(new SpawnEggItem(BYGEntities.MAN_O_WAR, new Color(182, 162, 196).getRGB(), new Color(103, 59, 134).getRGB(), new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "man_o_war_spawn_egg");
    public static final Item PEAT = createItem(BYGBlocks.PEAT);
    public static final Item LUSH_GRASS_BLOCK = createItem(BYGBlocks.LUSH_GRASS_BLOCK);
    public static final Item LUSH_GRASS_PATH = createItem(BYGBlocks.LUSH_GRASS_PATH);
    public static final Item LUSH_DIRT = createItem(BYGBlocks.LUSH_DIRT);
    public static final Item LUSH_FARMLAND = createItem(BYGBlocks.LUSH_FARMLAND);

    public static final Item MUD_BALL = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "mud_ball");
    public static final Item MUD_BLOCK = createItem(BYGBlocks.MUD_BLOCK);
    public static final Item MUD_BRICKS = createItem(BYGBlocks.MUD_BRICKS);

    public static final Item CHAIN_PLATING = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "chain_plating");

    public static final Item AMETRINE_GEMS = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_gems");
    public static final Item AMETRINE_ORE = createItem(BYGBlocks.AMETRINE_ORE);
    public static final Item AMETRINE_CLUSTER = createItem(BYGBlocks.AMETRINE_CLUSTER);
    public static final Item BUDDING_AMETRINE_ORE = createItem(BYGBlocks.BUDDING_AMETRINE_ORE);
    public static final Item AMETRINE_BLOCK = createItem(BYGBlocks.AMETRINE_BLOCK);
    public static final Item AMETRINE_HELMET = createItem(new BYGArmorItem(BYGArmorMaterial.AMETRINE, EquipmentSlot.HEAD, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_helmet");
    public static final Item AMETRINE_CHEST = createItem(new BYGArmorItem(BYGArmorMaterial.AMETRINE, EquipmentSlot.CHEST, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_chestplate");
    public static final Item AMETRINE_LEGGINGS = createItem(new BYGArmorItem(BYGArmorMaterial.AMETRINE, EquipmentSlot.LEGS, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_leggings");
    public static final Item AMETRINE_BOOTS = createItem(new BYGArmorItem(BYGArmorMaterial.AMETRINE, EquipmentSlot.FEET, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_boots");
    public static final Item AMETRINE_HORSE_ARMOR = createItem(new BYGHorseArmor(15, "ametrine", (new Item.Properties()).stacksTo(1).tab(BYGCreativeTab.CREATIVE_TAB)), "ametrine_horse_armor");

    public static final Item RAW_PENDORITE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "raw_pendorite");
    public static final Item PENDORITE_INGOT = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_ingot");
    public static final Item PENDORITE_SCRAPS = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_scraps");
    public static final Item PENDORITE_ORE = createItem(BYGBlocks.PENDORITE_ORE);
    public static final Item RAW_PENDORITE_BLOCK = createItem(BYGBlocks.RAW_PENDORITE_BLOCK);
    public static final Item PENDORITE_BLOCK = createItem(BYGBlocks.PENDORITE_BLOCK);
    public static final Item PENDORITE_AXE = createItem(AxeItemAccess.byg_create(BYGTier.PENDORITE, 6.0F, -3.0F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_axe");
    public static final Item PENDORITE_PICK = createItem(PickaxeItemAccess.byg_create(BYGTier.PENDORITE, 2, -2.8F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_pickaxe");
    public static final Item PENDORITE_SWORD = createItem(new SwordItem(BYGTier.PENDORITE, 4, -2.4F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_sword");
    public static final Item PENDORITE_BATTLEAXE = createItem(AxeItemAccess.byg_create(BYGTier.PENDORITE, 7.0F, -3.3F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_battleaxe");
    public static final Item PENDORITE_SHOVEL = createItem(new ShovelItem(BYGTier.PENDORITE, 2.0F, -3.0F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_shovel");
    public static final Item PENDORITE_HOE = createItem(HoeItemAccess.byg_create(BYGTier.PENDORITE, 0, 0.0F, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_hoe");

    public static final Item PENDORITE_HORSE_ARMOR = createItem(new BYGHorseArmor(11, "pendorite", (new Item.Properties()).stacksTo(1).tab(BYGCreativeTab.CREATIVE_TAB)), "pendorite_horse_armor");

    public static final Item DACITE = createItem(BYGBlocks.DACITE);
    public static final Item DACITE_STAIRS = createItem(BYGBlocks.DACITE_STAIRS);
    public static final Item DACITE_SLAB = createItem(BYGBlocks.DACITE_SLAB);
    public static final Item DACITE_WALL = createItem(BYGBlocks.DACITE_WALL);

    public static final Item DACITE_BRICKS = createItem(BYGBlocks.DACITE_BRICKS);
    public static final Item DACITE_BRICK_STAIRS = createItem(BYGBlocks.DACITE_BRICK_STAIRS);
    public static final Item DACITE_BRICK_SLAB = createItem(BYGBlocks.DACITE_BRICK_SLAB);
    public static final Item DACITE_BRICK_WALL = createItem(BYGBlocks.DACITE_BRICK_WALL);

    public static final Item DACITE_COBBLESTONE = createItem(BYGBlocks.DACITE_COBBLESTONE);
    public static final Item DACITE_COBBLESTONE_STAIRS = createItem(BYGBlocks.DACITE_COBBLESTONE_STAIRS);
    public static final Item DACITE_COBBLESTONE_SLAB = createItem(BYGBlocks.DACITE_COBBLESTONE_SLAB);
    public static final Item DACITE_COBBLESTONE_WALL = createItem(BYGBlocks.DACITE_COBBLESTONE_WALL);

    public static final Item DACITE_PILLAR = createItem(BYGBlocks.DACITE_PILLAR);
    public static final Item DACITE_TILE = createItem(BYGBlocks.DACITE_TILE);
    public static final Item DACITE_TILE_STAIRS = createItem(BYGBlocks.DACITE_TILE_STAIRS);
    public static final Item DACITE_TILE_SLAB = createItem(BYGBlocks.DACITE_TILE_SLAB);
    public static final Item DACITE_TILE_WALL = createItem(BYGBlocks.DACITE_TILE_WALL);

    public static final Item MOSSY_STONE = createItem(BYGBlocks.MOSSY_STONE);
    public static final Item MOSSY_STONE_STAIRS = createItem(BYGBlocks.MOSSY_STONE_STAIRS);
    public static final Item MOSSY_STONE_SLAB = createItem(BYGBlocks.MOSSY_STONE_SLAB);
    public static final Item MOSSY_STONE_WALL = createItem(BYGBlocks.MOSSY_STONE_WALL);

    public static final Item PODZOL_DACITE = createItem(BYGBlocks.PODZOL_DACITE);
    public static final Item OVERGROWN_DACITE = createItem(BYGBlocks.OVERGROWN_DACITE);
    public static final Item OVERGROWN_STONE = createItem(BYGBlocks.OVERGROWN_STONE);

    public static final Item RED_ROCK = createItem(BYGBlocks.RED_ROCK);
    public static final Item RED_ROCK_STAIRS = createItem(BYGBlocks.RED_ROCK_STAIRS);
    public static final Item RED_ROCK_SLAB = createItem(BYGBlocks.RED_ROCK_SLAB);
    public static final Item RED_ROCK_WALL = createItem(BYGBlocks.RED_ROCK_WALL);

    public static final Item RED_ROCK_BRICKS = createItem(BYGBlocks.RED_ROCK_BRICKS);
    public static final Item RED_ROCK_BRICK_STAIRS = createItem(BYGBlocks.RED_ROCK_BRICK_STAIRS);
    public static final Item RED_ROCK_BRICK_SLAB = createItem(BYGBlocks.RED_ROCK_BRICK_SLAB);
    public static final Item RED_ROCK_BRICK_WALL = createItem(BYGBlocks.RED_ROCK_BRICK_WALL);

    public static final Item MOSSY_RED_ROCK_BRICKS = createItem(BYGBlocks.MOSSY_RED_ROCK_BRICKS);
    public static final Item MOSSY_RED_ROCK_BRICK_STAIRS = createItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS);
    public static final Item MOSSY_RED_ROCK_BRICK_SLAB = createItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB);
    public static final Item MOSSY_RED_ROCK_BRICK_WALL = createItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL);

    public static final Item CHISELED_RED_ROCK_BRICKS = createItem(BYGBlocks.CHISELED_RED_ROCK_BRICKS);
    public static final Item CHISELED_RED_ROCK_BRICK_STAIRS = createItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS);
    public static final Item CHISELED_RED_ROCK_BRICK_SLAB = createItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB);
    public static final Item CHISELED_RED_ROCK_BRICK_WALL = createItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL);

    public static final Item CRACKED_RED_ROCK_BRICKS = createItem(BYGBlocks.CRACKED_RED_ROCK_BRICKS);
    public static final Item CRACKED_RED_ROCK_BRICK_STAIRS = createItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS);
    public static final Item CRACKED_RED_ROCK_BRICK_SLAB = createItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB);
    public static final Item CRACKED_RED_ROCK_BRICK_WALL = createItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL);

    public static final Item ROCKY_STONE = createItem(BYGBlocks.ROCKY_STONE);
    public static final Item ROCKY_STAIRS = createItem(BYGBlocks.ROCKY_STAIRS);
    public static final Item ROCKY_SLAB = createItem(BYGBlocks.ROCKY_SLAB);
    public static final Item ROCKY_WALL = createItem(BYGBlocks.ROCKY_WALL);

    public static final Item TRAVERTINE = createItem(BYGBlocks.TRAVERTINE);
    public static final Item TRAVERTINE_STAIRS = createItem(BYGBlocks.TRAVERTINE_STAIRS);
    public static final Item TRAVERTINE_SLAB = createItem(BYGBlocks.TRAVERTINE_SLAB);
    public static final Item TRAVERTINE_WALL = createItem(BYGBlocks.TRAVERTINE_WALL);
    public static final Item POLISHED_TRAVERTINE = createItem(BYGBlocks.POLISHED_TRAVERTINE);
    public static final Item POLISHED_TRAVERTINE_STAIRS = createItem(BYGBlocks.POLISHED_TRAVERTINE_STAIRS);
    public static final Item POLISHED_TRAVERTINE_SLAB = createItem(BYGBlocks.POLISHED_TRAVERTINE_SLAB);
    public static final Item POLISHED_TRAVERTINE_WALL = createItem(BYGBlocks.POLISHED_TRAVERTINE_WALL);
    public static final Item CHISELED_TRAVERTINE = createItem(BYGBlocks.CHISELED_TRAVERTINE);
    public static final Item CHISELED_TRAVERTINE_STAIRS = createItem(BYGBlocks.CHISELED_TRAVERTINE_STAIRS);
    public static final Item CHISELED_TRAVERTINE_SLAB = createItem(BYGBlocks.CHISELED_TRAVERTINE_SLAB);
    public static final Item CHISELED_TRAVERTINE_WALL = createItem(BYGBlocks.CHISELED_TRAVERTINE_WALL);

    public static final Item EMERALDITE_ORE = createItem(BYGBlocks.EMERALDITE_ORE);
    public static final Item EMERALDITE_SHARDS = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "emeraldite_shards");

    public static final Item SCORIA_STONE = createItem(BYGBlocks.SCORIA_STONE);
    public static final Item SCORIA_STAIRS = createItem(BYGBlocks.SCORIA_STAIRS);
    public static final Item SCORIA_SLAB = createItem(BYGBlocks.SCORIA_SLAB);
    public static final Item SCORIA_WALL = createItem(BYGBlocks.SCORIA_WALL);

    public static final Item SCORIA_COBBLESTONE = createItem(BYGBlocks.SCORIA_COBBLESTONE);
    public static final Item SCORIA_COBBLESTONE_STAIRS = createItem(BYGBlocks.SCORIA_COBBLESTONE_STAIRS);
    public static final Item SCORIA_COBBLESTONE_SLAB = createItem(BYGBlocks.SCORIA_COBBLESTONE_SLAB);
    public static final Item SCORIA_COBBLESTONE_WALL = createItem(BYGBlocks.SCORIA_COBBLESTONE_WALL);

    public static final Item SCORIA_PILLAR = createItem(BYGBlocks.SCORIA_PILLAR);
    public static final Item SCORIA_STONEBRICKS = createItem(BYGBlocks.SCORIA_STONEBRICKS);
    public static final Item SCORIA_STONEBRICK_STAIRS = createItem(BYGBlocks.SCORIA_STONEBRICK_STAIRS);
    public static final Item SCORIA_STONEBRICK_SLAB = createItem(BYGBlocks.SCORIA_STONEBRICK_SLAB);
    public static final Item SCORIA_STONEBRICK_WALL = createItem(BYGBlocks.SCORIA_STONEBRICK_WALL);
    public static final Item CRACKED_SCORIA_STONE_BRICKS = createItem(BYGBlocks.CRACKED_SCORIA_STONE_BRICKS);

    public static final Item SOAPSTONE = createItem(BYGBlocks.SOAPSTONE);
    public static final Item SOAPSTONE_STAIRS = createItem(BYGBlocks.SOAPSTONE_STAIRS);
    public static final Item SOAPSTONE_SLAB = createItem(BYGBlocks.SOAPSTONE_SLAB);
    public static final Item SOAPSTONE_WALL = createItem(BYGBlocks.SOAPSTONE_WALL);

    public static final Item POLISHED_SOAPSTONE = createItem(BYGBlocks.POLISHED_SOAPSTONE);
    public static final Item POLISHED_SOAPSTONE_STAIRS = createItem(BYGBlocks.POLISHED_SOAPSTONE_STAIRS);
    public static final Item POLISHED_SOAPSTONE_SLAB = createItem(BYGBlocks.POLISHED_SOAPSTONE_SLAB);
    public static final Item POLISHED_SOAPSTONE_WALL = createItem(BYGBlocks.POLISHED_SOAPSTONE_WALL);

    public static final Item SOAPSTONE_BRICKS = createItem(BYGBlocks.SOAPSTONE_BRICKS);
    public static final Item SOAPSTONE_BRICK_STAIRS = createItem(BYGBlocks.SOAPSTONE_BRICK_STAIRS);
    public static final Item SOAPSTONE_BRICK_SLAB = createItem(BYGBlocks.SOAPSTONE_BRICK_SLAB);
    public static final Item SOAPSTONE_BRICK_WALL = createItem(BYGBlocks.SOAPSTONE_BRICK_WALL);

    public static final Item SOAPSTONE_PILLAR = createItem(BYGBlocks.SOAPSTONE_PILLAR);
    public static final Item SOAPSTONE_TILE = createItem(BYGBlocks.SOAPSTONE_TILE);
    public static final Item SOAPSTONE_TILE_STAIRS = createItem(BYGBlocks.SOAPSTONE_TILE_STAIRS);
    public static final Item SOAPSTONE_TILE_SLAB = createItem(BYGBlocks.SOAPSTONE_TILE_SLAB);
    public static final Item SOAPSTONE_TILE_WALL = createItem(BYGBlocks.SOAPSTONE_TILE_WALL);

    public static final Item BLACK_SAND = createItem(BYGBlocks.BLACK_SAND);
    public static final Item BLACK_SANDSTONE = createItem(BYGBlocks.BLACK_SANDSTONE);
    public static final Item BLACK_CHISELED_SANDSTONE = createItem(BYGBlocks.BLACK_CHISELED_SANDSTONE);
    public static final Item BLACK_CUT_SANDSTONE = createItem(BYGBlocks.BLACK_CUT_SANDSTONE);
    public static final Item BLACK_SMOOTH_SANDSTONE = createItem(BYGBlocks.BLACK_SMOOTH_SANDSTONE);

    public static final Item WHITE_SAND = createItem(BYGBlocks.WHITE_SAND);
    public static final Item WHITE_SANDSTONE = createItem(BYGBlocks.WHITE_SANDSTONE);
    public static final Item WHITE_CHISELED_SANDSTONE = createItem(BYGBlocks.WHITE_CHISELED_SANDSTONE);
    public static final Item WHITE_CUT_SANDSTONE = createItem(BYGBlocks.WHITE_CUT_SANDSTONE);
    public static final Item WHITE_SMOOTH_SANDSTONE = createItem(BYGBlocks.WHITE_SMOOTH_SANDSTONE);

    public static final Item BLUE_SAND = createItem(BYGBlocks.BLUE_SAND);
    public static final Item BLUE_SANDSTONE = createItem(BYGBlocks.BLUE_SANDSTONE);
    public static final Item BLUE_CHISELED_SANDSTONE = createItem(BYGBlocks.BLUE_CHISELED_SANDSTONE);
    public static final Item BLUE_CUT_SANDSTONE = createItem(BYGBlocks.BLUE_CUT_SANDSTONE);
    public static final Item BLUE_SMOOTH_SANDSTONE = createItem(BYGBlocks.BLUE_SMOOTH_SANDSTONE);

    public static final Item PURPLE_SAND = createItem(BYGBlocks.PURPLE_SAND);
    public static final Item PURPLE_SANDSTONE = createItem(BYGBlocks.PURPLE_SANDSTONE);
    public static final Item PURPLE_CHISELED_SANDSTONE = createItem(BYGBlocks.PURPLE_CHISELED_SANDSTONE);
    public static final Item PURPLE_CUT_SANDSTONE = createItem(BYGBlocks.PURPLE_CUT_SANDSTONE);
    public static final Item PURPLE_SMOOTH_SANDSTONE = createItem(BYGBlocks.PURPLE_SMOOTH_SANDSTONE);

    public static final Item PINK_SAND = createItem(BYGBlocks.PINK_SAND);
    public static final Item PINK_SANDSTONE = createItem(BYGBlocks.PINK_SANDSTONE);
    public static final Item PINK_CHISELED_SANDSTONE = createItem(BYGBlocks.PINK_CHISELED_SANDSTONE);
    public static final Item PINK_CUT_SANDSTONE = createItem(BYGBlocks.PINK_CUT_SANDSTONE);
    public static final Item PINK_SMOOTH_SANDSTONE = createItem(BYGBlocks.PINK_SMOOTH_SANDSTONE);

    public static final Item WINDSWEPT_SAND = createItem(BYGBlocks.WINDSWEPT_SAND);
    public static final Item WINDSWEPT_SANDSTONE = createItem(BYGBlocks.WINDSWEPT_SANDSTONE);
    public static final Item WINDSWEPT_SANDSTONE_SLAB = createItem(BYGBlocks.WINDSWEPT_SANDSTONE_SLAB);
    public static final Item WINDSWEPT_SANDSTONE_STAIRS = createItem(BYGBlocks.WINDSWEPT_SANDSTONE_STAIRS);
    public static final Item WINDSWEPT_SANDSTONE_WALL = createItem(BYGBlocks.WINDSWEPT_SANDSTONE_WALL);

    public static final Item CHISELED_WINDSWEPT_SANDSTONE = createItem(BYGBlocks.CHISELED_WINDSWEPT_SANDSTONE);
    public static final Item CHISELED_WINDSWEPT_SANDSTONE_SLAB = createItem(BYGBlocks.CHISELED_WINDSWEPT_SANDSTONE_SLAB);
    public static final Item CHISELED_WINDSWEPT_SANDSTONE_STAIRS = createItem(BYGBlocks.CHISELED_WINDSWEPT_SANDSTONE_STAIRS);
    public static final Item CHISELED_WINDSWEPT_SANDSTONE_WALL = createItem(BYGBlocks.CHISELED_WINDSWEPT_SANDSTONE_WALL);

    public static final Item CUT_WINDSWEPT_SANDSTONE = createItem(BYGBlocks.CUT_WINDSWEPT_SANDSTONE);
    public static final Item CUT_WINDSWEPT_SANDSTONE_SLAB = createItem(BYGBlocks.CUT_WINDSWEPT_SANDSTONE_SLAB);
    public static final Item CUT_WINDSWEPT_SANDSTONE_STAIRS = createItem(BYGBlocks.CUT_WINDSWEPT_SANDSTONE_STAIRS);
    public static final Item CUT_WINDSWEPT_SANDSTONE_WALL = createItem(BYGBlocks.CUT_WINDSWEPT_SANDSTONE_WALL);

    public static final Item SMOOTH_WINDSWEPT_SANDSTONE = createItem(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE);
    public static final Item SMOOTH_WINDSWEPT_SANDSTONE_SLAB = createItem(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE_SLAB);
    public static final Item SMOOTH_WINDSWEPT_SANDSTONE_STAIRS = createItem(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE_STAIRS);
    public static final Item SMOOTH_WINDSWEPT_SANDSTONE_WALL = createItem(BYGBlocks.SMOOTH_WINDSWEPT_SANDSTONE_WALL);

    public static final Item WINDSWEPT_SANDSTONE_PILLAR = createItem(BYGBlocks.WINDSWEPT_SANDSTONE_PILLAR);

    //Aspen Woodtype
    public static final Item ASPEN_SAPLING = createSaplingItem(BYGBlocks.ASPEN_SAPLING);
    public static final Item ASPEN_LEAVES = createItem(BYGBlocks.ASPEN_LEAVES);
    public static final Item ASPEN_LOG = createItem(BYGBlocks.ASPEN_LOG);
    public static final Item ASPEN_WOOD = createItem(BYGBlocks.ASPEN_WOOD);
    public static final Item STRIPPED_ASPEN_LOG = createItem(BYGBlocks.STRIPPED_ASPEN_LOG);
    public static final Item STRIPPED_ASPEN_WOOD = createItem(BYGBlocks.STRIPPED_ASPEN_WOOD);
    public static final Item ASPEN_PLANKS = createItem(BYGBlocks.ASPEN_PLANKS);
    public static final Item ASPEN_BOOKSHELF = createItem(BYGBlocks.ASPEN_BOOKSHELF);
    public static final Item ASPEN_CRAFTING_TABLE = createItem(BYGBlocks.ASPEN_CRAFTING_TABLE);
    public static final Item ASPEN_STAIRS = createItem(BYGBlocks.ASPEN_STAIRS);
    public static final Item ASPEN_SLAB = createItem(BYGBlocks.ASPEN_SLAB);
    public static final Item ASPEN_FENCE = createItem(BYGBlocks.ASPEN_FENCE);
    public static final Item ASPEN_FENCE_GATE = createItem(BYGBlocks.ASPEN_FENCE_GATE);
    public static final Item ASPEN_DOOR = createItem(BYGBlocks.ASPEN_DOOR);
    public static final Item ASPEN_TRAPDOOR = createItem(BYGBlocks.ASPEN_TRAPDOOR);
    public static final Item ASPEN_PRESSURE_PLATE = createItem(BYGBlocks.ASPEN_PRESSURE_PLATE);
    public static final Item ASPEN_BUTTON = createItem(BYGBlocks.ASPEN_BUTTON);
    public static final Item ASPEN_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.ASPEN, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "aspen_boat");

    //Baobab Woodtype
    public static final Item BAOBAB_FRUIT = createItem(new BaobabFruitItem(BYGBlocks.BAOBAB_FRUIT_BLOCK, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.5f).alwaysEat().build())), "baobab_fruit");
    public static final Item BAOBAB_SAPLING = createSaplingItem(BYGBlocks.BAOBAB_SAPLING);
    public static final Item BAOBAB_LEAVES = createItem(BYGBlocks.BAOBAB_LEAVES);
    public static final Item BAOBAB_LOG = createItem(BYGBlocks.BAOBAB_LOG);
    public static final Item BAOBAB_WOOD = createItem(BYGBlocks.BAOBAB_WOOD);
    public static final Item STRIPPED_BAOBAB_LOG = createItem(BYGBlocks.STRIPPED_BAOBAB_LOG);
    public static final Item STRIPPED_BAOBAB_WOOD = createItem(BYGBlocks.STRIPPED_BAOBAB_WOOD);
    public static final Item BAOBAB_PLANKS = createItem(BYGBlocks.BAOBAB_PLANKS);
    public static final Item BAOBAB_BOOKSHELF = createItem(BYGBlocks.BAOBAB_BOOKSHELF);
    public static final Item BAOBAB_CRAFTING_TABLE = createItem(BYGBlocks.BAOBAB_CRAFTING_TABLE);
    public static final Item BAOBAB_STAIRS = createItem(BYGBlocks.BAOBAB_STAIRS);
    public static final Item BAOBAB_SLAB = createItem(BYGBlocks.BAOBAB_SLAB);
    public static final Item BAOBAB_FENCE = createItem(BYGBlocks.BAOBAB_FENCE);
    public static final Item BAOBAB_FENCE_GATE = createItem(BYGBlocks.BAOBAB_FENCE_GATE);
    public static final Item BAOBAB_DOOR = createItem(BYGBlocks.BAOBAB_DOOR);
    public static final Item BAOBAB_TRAPDOOR = createItem(BYGBlocks.BAOBAB_TRAPDOOR);
    public static final Item BAOBAB_PRESSURE_PLATE = createItem(BYGBlocks.BAOBAB_PRESSURE_PLATE);
    public static final Item BAOBAB_BUTTON = createItem(BYGBlocks.BAOBAB_BUTTON);
    public static final Item BAOBAB_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.BAOBAB, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "baobab_boat");

    //Blue Enchanted Woodtype
    public static final Item BLUE_ENCHANTED_SAPLING = createSaplingItem(BYGBlocks.BLUE_ENCHANTED_SAPLING);
    public static final Item BLUE_ENCHANTED_LEAVES = createItem(BYGBlocks.BLUE_ENCHANTED_LEAVES);
    public static final Item BLUE_ENCHANTED_LOG = createItem(BYGBlocks.BLUE_ENCHANTED_LOG);
    public static final Item BLUE_ENCHANTED_WOOD = createItem(BYGBlocks.BLUE_ENCHANTED_WOOD);
    public static final Item STRIPPED_BLUE_ENCHANTED_LOG = createItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG);
    public static final Item STRIPPED_BLUE_ENCHANTED_WOOD = createItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD);
    public static final Item BLUE_ENCHANTED_PLANKS = createItem(BYGBlocks.BLUE_ENCHANTED_PLANKS);
    public static final Item BLUE_ENCHANTED_BOOKSHELF = createItem(BYGBlocks.BLUE_ENCHANTED_BOOKSHELF);
    public static final Item BLUE_ENCHANTED_CRAFTING_TABLE = createItem(BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE);
    public static final Item BLUE_ENCHANTED_STAIRS = createItem(BYGBlocks.BLUE_ENCHANTED_STAIRS);
    public static final Item BLUE_ENCHANTED_SLAB = createItem(BYGBlocks.BLUE_ENCHANTED_SLAB);
    public static final Item BLUE_ENCHANTED_FENCE = createItem(BYGBlocks.BLUE_ENCHANTED_FENCE);
    public static final Item BLUE_ENCHANTED_FENCE_GATE = createItem(BYGBlocks.BLUE_ENCHANTED_FENCE_GATE);
    public static final Item BLUE_ENCHANTED_DOOR = createItem(BYGBlocks.BLUE_ENCHANTED_DOOR);
    public static final Item BLUE_ENCHANTED_TRAPDOOR = createItem(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR);
    public static final Item BLUE_ENCHANTED_PRESSURE_PLATE = createItem(BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE);
    public static final Item BLUE_ENCHANTED_BUTTON = createItem(BYGBlocks.BLUE_ENCHANTED_BUTTON);
    public static final Item BLUE_ENCHANTED_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.BLUE_ENCHANTED, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "blue_enchanted_boat");

    //Bulbis Woodtype
    public static final Item PURPLE_BULBIS_ODDITY = createItem(BYGBlocks.PURPLE_BULBIS_ODDITY);
    public static final Item PURPLE_BULBIS_ANOMALY = createItem(BYGBlocks.PURPLE_BULBIS_ANOMALY);
    public static final Item PURPLE_BULBIS_SHELL = createItem(BYGBlocks.PURPLE_BULBIS_SHELL);
    public static final Item BULBIS_ODDITY = createItem(BYGBlocks.BULBIS_ODDITY);
    public static final Item BULBIS_ANOMALY = createItem(BYGBlocks.BULBIS_ANOMALY);
    public static final Item BULBIS_SHELL = createItem(BYGBlocks.BULBIS_SHELL);
    public static final Item BULBIS_STEM = createItem(BYGBlocks.BULBIS_STEM);
    public static final Item BULBIS_WOOD = createItem(BYGBlocks.BULBIS_WOOD);
    public static final Item STRIPPED_BULBIS_LOG = createItem(BYGBlocks.STRIPPED_BULBIS_LOG);
    public static final Item STRIPPED_BULBIS_WOOD = createItem(BYGBlocks.STRIPPED_BULBIS_WOOD);
    public static final Item BULBIS_PLANKS = createItem(BYGBlocks.BULBIS_PLANKS);
    public static final Item BULBIS_BOOKSHELF = createItem(BYGBlocks.BULBIS_BOOKSHELF);
    public static final Item BULBIS_CRAFTING_TABLE = createItem(BYGBlocks.BULBIS_CRAFTING_TABLE);
    public static final Item BULBIS_STAIRS = createItem(BYGBlocks.BULBIS_STAIRS);
    public static final Item BULBIS_SLAB = createItem(BYGBlocks.BULBIS_SLAB);
    public static final Item BULBIS_FENCE = createItem(BYGBlocks.BULBIS_FENCE);
    public static final Item BULBIS_FENCE_GATE = createItem(BYGBlocks.BULBIS_FENCE_GATE);
    public static final Item BULBIS_DOOR = createItem(BYGBlocks.BULBIS_DOOR);
    public static final Item BULBIS_TRAPDOOR = createItem(BYGBlocks.BULBIS_TRAPDOOR);
    public static final Item BULBIS_PRESSURE_PLATE = createItem(BYGBlocks.BULBIS_PRESSURE_PLATE);
    public static final Item BULBIS_BUTTON = createItem(BYGBlocks.BULBIS_BUTTON);


    //Cherry Woodtype
    public static final Item PINK_CHERRY_SAPLING = createSaplingItem(BYGBlocks.PINK_CHERRY_SAPLING);
    public static final Item PINK_CHERRY_FOLIAGE = createItem(BYGBlocks.PINK_CHERRY_FOLIAGE);
    public static final Item PINK_CHERRY_LEAVES = createItem(BYGBlocks.PINK_CHERRY_LEAVES);
    public static final Item WHITE_CHERRY_SAPLING = createSaplingItem(BYGBlocks.WHITE_CHERRY_SAPLING);
    public static final Item WHITE_CHERRY_FOLIAGE = createItem(BYGBlocks.WHITE_CHERRY_FOLIAGE);
    public static final Item WHITE_CHERRY_LEAVES = createItem(BYGBlocks.WHITE_CHERRY_LEAVES);
    public static final Item CHERRY_LOG = createItem(BYGBlocks.CHERRY_LOG);
    public static final Item CHERRY_WOOD = createItem(BYGBlocks.CHERRY_WOOD);
    public static final Item STRIPPED_CHERRY_LOG = createItem(BYGBlocks.STRIPPED_CHERRY_LOG);
    public static final Item STRIPPED_CHERRY_WOOD = createItem(BYGBlocks.STRIPPED_CHERRY_WOOD);
    public static final Item CHERRY_PLANKS = createItem(BYGBlocks.CHERRY_PLANKS);
    public static final Item CHERRY_BOOKSHELF = createItem(BYGBlocks.CHERRY_BOOKSHELF);
    public static final Item CHERRY_CRAFTING_TABLE = createItem(BYGBlocks.CHERRY_CRAFTING_TABLE);
    public static final Item CHERRY_STAIRS = createItem(BYGBlocks.CHERRY_STAIRS);
    public static final Item CHERRY_SLAB = createItem(BYGBlocks.CHERRY_SLAB);
    public static final Item CHERRY_FENCE = createItem(BYGBlocks.CHERRY_FENCE);
    public static final Item CHERRY_FENCE_GATE = createItem(BYGBlocks.CHERRY_FENCE_GATE);
    public static final Item CHERRY_DOOR = createItem(BYGBlocks.CHERRY_DOOR);
    public static final Item CHERRY_TRAPDOOR = createItem(BYGBlocks.CHERRY_TRAPDOOR);
    public static final Item CHERRY_PRESSURE_PLATE = createItem(BYGBlocks.CHERRY_PRESSURE_PLATE);
    public static final Item CHERRY_BUTTON = createItem(BYGBlocks.CHERRY_BUTTON);
    public static final Item CHERRY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CHERRY, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "cherry_boat");

    //Cika Woodtype
    public static final Item CIKA_SAPLING = createSaplingItem(BYGBlocks.CIKA_SAPLING);
    public static final Item CIKA_LEAVES = createItem(BYGBlocks.CIKA_LEAVES);
    public static final Item CIKA_LOG = createItem(BYGBlocks.CIKA_LOG);
    public static final Item CIKA_WOOD = createItem(BYGBlocks.CIKA_WOOD);
    public static final Item STRIPPED_CIKA_LOG = createItem(BYGBlocks.STRIPPED_CIKA_LOG);
    public static final Item STRIPPED_CIKA_WOOD = createItem(BYGBlocks.STRIPPED_CIKA_WOOD);
    public static final Item CIKA_PLANKS = createItem(BYGBlocks.CIKA_PLANKS);
    public static final Item CIKA_BOOKSHELF = createItem(BYGBlocks.CIKA_BOOKSHELF);
    public static final Item CIKA_CRAFTING_TABLE = createItem(BYGBlocks.CIKA_CRAFTING_TABLE);
    public static final Item CIKA_STAIRS = createItem(BYGBlocks.CIKA_STAIRS);
    public static final Item CIKA_SLAB = createItem(BYGBlocks.CIKA_SLAB);
    public static final Item CIKA_FENCE = createItem(BYGBlocks.CIKA_FENCE);
    public static final Item CIKA_FENCE_GATE = createItem(BYGBlocks.CIKA_FENCE_GATE);
    public static final Item CIKA_DOOR = createItem(BYGBlocks.CIKA_DOOR);
    public static final Item CIKA_TRAPDOOR = createItem(BYGBlocks.CIKA_TRAPDOOR);
    public static final Item CIKA_PRESSURE_PLATE = createItem(BYGBlocks.CIKA_PRESSURE_PLATE);
    public static final Item CIKA_BUTTON = createItem(BYGBlocks.CIKA_BUTTON);
    public static final Item CIKA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CIKA, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "cika_boat");

    //Cypress Woodtype
    public static final Item CYPRESS_SAPLING = createSaplingItem(BYGBlocks.CYPRESS_SAPLING);
    public static final Item CYPRESS_LEAVES = createItem(BYGBlocks.CYPRESS_LEAVES);
    public static final Item CYPRESS_LOG = createItem(BYGBlocks.CYPRESS_LOG);
    public static final Item CYPRESS_WOOD = createItem(BYGBlocks.CYPRESS_WOOD);
    public static final Item STRIPPED_CYPRESS_LOG = createItem(BYGBlocks.STRIPPED_CYPRESS_LOG);
    public static final Item STRIPPED_CYPRESS_WOOD = createItem(BYGBlocks.STRIPPED_CYPRESS_WOOD);
    public static final Item CYPRESS_PLANKS = createItem(BYGBlocks.CYPRESS_PLANKS);
    public static final Item CYPRESS_BOOKSHELF = createItem(BYGBlocks.CYPRESS_BOOKSHELF);
    public static final Item CYPRESS_CRAFTING_TABLE = createItem(BYGBlocks.CYPRESS_CRAFTING_TABLE);
    public static final Item CYPRESS_STAIRS = createItem(BYGBlocks.CYPRESS_STAIRS);
    public static final Item CYPRESS_SLAB = createItem(BYGBlocks.CYPRESS_SLAB);
    public static final Item CYPRESS_FENCE = createItem(BYGBlocks.CYPRESS_FENCE);
    public static final Item CYPRESS_FENCE_GATE = createItem(BYGBlocks.CYPRESS_FENCE_GATE);
    public static final Item CYPRESS_DOOR = createItem(BYGBlocks.CYPRESS_DOOR);
    public static final Item CYPRESS_TRAPDOOR = createItem(BYGBlocks.CYPRESS_TRAPDOOR);
    public static final Item CYPRESS_PRESSURE_PLATE = createItem(BYGBlocks.CYPRESS_PRESSURE_PLATE);
    public static final Item CYPRESS_BUTTON = createItem(BYGBlocks.CYPRESS_BUTTON);
    public static final Item CYPRESS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CYPRESS, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "cypress_boat");

    //Ebony Woodtype
    public static final Item EBONY_SAPLING = createSaplingItem(BYGBlocks.EBONY_SAPLING);
    public static final Item EBONY_LEAVES = createItem(BYGBlocks.EBONY_LEAVES);
    public static final Item EBONY_LOG = createItem(BYGBlocks.EBONY_LOG);
    public static final Item EBONY_WOOD = createItem(BYGBlocks.EBONY_WOOD);
    public static final Item STRIPPED_EBONY_LOG = createItem(BYGBlocks.STRIPPED_EBONY_LOG);
    public static final Item STRIPPED_EBONY_WOOD = createItem(BYGBlocks.STRIPPED_EBONY_WOOD);
    public static final Item EBONY_PLANKS = createItem(BYGBlocks.EBONY_PLANKS);
    public static final Item EBONY_BOOKSHELF = createItem(BYGBlocks.EBONY_BOOKSHELF);
    public static final Item EBONY_CRAFTING_TABLE = createItem(BYGBlocks.EBONY_CRAFTING_TABLE);
    public static final Item EBONY_STAIRS = createItem(BYGBlocks.EBONY_STAIRS);
    public static final Item EBONY_SLAB = createItem(BYGBlocks.EBONY_SLAB);
    public static final Item EBONY_FENCE = createItem(BYGBlocks.EBONY_FENCE);
    public static final Item EBONY_FENCE_GATE = createItem(BYGBlocks.EBONY_FENCE_GATE);
    public static final Item EBONY_DOOR = createItem(BYGBlocks.EBONY_DOOR);
    public static final Item EBONY_TRAPDOOR = createItem(BYGBlocks.EBONY_TRAPDOOR);
    public static final Item EBONY_PRESSURE_PLATE = createItem(BYGBlocks.EBONY_PRESSURE_PLATE);
    public static final Item EBONY_BUTTON = createItem(BYGBlocks.EBONY_BUTTON);
    public static final Item EBONY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.EBONY, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "ebony_boat");

    //Ether Woodtype
    public static final Item ETHER_BULBS = createItem(new BlockItem(BYGBlocks.ETHER_BULB, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().saturationMod(5.0f).effect(new MobEffectInstance(MobEffects.GLOWING, 200, 0), 1.0F).alwaysEat().build())), "ether_bulbs");

    public static final Item ETHER_SAPLING = createSaplingItem(BYGBlocks.ETHER_SAPLING);
    public static final Item ETHER_LEAVES = createItem(BYGBlocks.ETHER_LEAVES);
    public static final Item ETHER_LOG = createItem(BYGBlocks.ETHER_LOG);
    public static final Item ETHER_WOOD = createItem(BYGBlocks.ETHER_WOOD);
    public static final Item STRIPPED_ETHER_LOG = createItem(BYGBlocks.STRIPPED_ETHER_LOG);
    public static final Item STRIPPED_ETHER_WOOD = createItem(BYGBlocks.STRIPPED_ETHER_WOOD);
    public static final Item ETHER_PLANKS = createItem(BYGBlocks.ETHER_PLANKS);
    public static final Item ETHER_BOOKSHELF = createItem(BYGBlocks.ETHER_BOOKSHELF);
    public static final Item ETHER_CRAFTING_TABLE = createItem(BYGBlocks.ETHER_CRAFTING_TABLE);
    public static final Item ETHER_STAIRS = createItem(BYGBlocks.ETHER_STAIRS);
    public static final Item ETHER_SLAB = createItem(BYGBlocks.ETHER_SLAB);
    public static final Item ETHER_FENCE = createItem(BYGBlocks.ETHER_FENCE);
    public static final Item ETHER_FENCE_GATE = createItem(BYGBlocks.ETHER_FENCE_GATE);
    public static final Item ETHER_DOOR = createItem(BYGBlocks.ETHER_DOOR);
    public static final Item ETHER_TRAPDOOR = createItem(BYGBlocks.ETHER_TRAPDOOR);
    public static final Item ETHER_PRESSURE_PLATE = createItem(BYGBlocks.ETHER_PRESSURE_PLATE);
    public static final Item ETHER_BUTTON = createItem(BYGBlocks.ETHER_BUTTON);

    //Fir Woodtype
    public static final Item FIR_SAPLING = createSaplingItem(BYGBlocks.FIR_SAPLING);
    public static final Item FIR_LEAVES = createItem(BYGBlocks.FIR_LEAVES);
    public static final Item FIR_LOG = createItem(BYGBlocks.FIR_LOG);
    public static final Item FIR_WOOD = createItem(BYGBlocks.FIR_WOOD);
    public static final Item STRIPPED_FIR_LOG = createItem(BYGBlocks.STRIPPED_FIR_LOG);
    public static final Item STRIPPED_FIR_WOOD = createItem(BYGBlocks.STRIPPED_FIR_WOOD);
    public static final Item FIR_PLANKS = createItem(BYGBlocks.FIR_PLANKS);
    public static final Item FIR_BOOKSHELF = createItem(BYGBlocks.FIR_BOOKSHELF);
    public static final Item FIR_CRAFTING_TABLE = createItem(BYGBlocks.FIR_CRAFTING_TABLE);
    public static final Item FIR_STAIRS = createItem(BYGBlocks.FIR_STAIRS);
    public static final Item FIR_SLAB = createItem(BYGBlocks.FIR_SLAB);
    public static final Item FIR_FENCE = createItem(BYGBlocks.FIR_FENCE);
    public static final Item FIR_FENCE_GATE = createItem(BYGBlocks.FIR_FENCE_GATE);
    public static final Item FIR_DOOR = createItem(BYGBlocks.FIR_DOOR);
    public static final Item FIR_TRAPDOOR = createItem(BYGBlocks.FIR_TRAPDOOR);
    public static final Item FIR_PRESSURE_PLATE = createItem(BYGBlocks.FIR_PRESSURE_PLATE);
    public static final Item FIR_BUTTON = createItem(BYGBlocks.FIR_BUTTON);
    public static final Item FIR_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.FIR, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "fir_boat");

    //Green Enchanted Woodtype
    public static final Item GREEN_ENCHANTED_SAPLING = createSaplingItem(BYGBlocks.GREEN_ENCHANTED_SAPLING);
    public static final Item GREEN_ENCHANTED_LEAVES = createItem(BYGBlocks.GREEN_ENCHANTED_LEAVES);
    public static final Item GREEN_ENCHANTED_LOG = createItem(BYGBlocks.GREEN_ENCHANTED_LOG);
    public static final Item GREEN_ENCHANTED_WOOD = createItem(BYGBlocks.GREEN_ENCHANTED_WOOD);
    public static final Item STRIPPED_GREEN_ENCHANTED_LOG = createItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG);
    public static final Item STRIPPED_GREEN_ENCHANTED_WOOD = createItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD);
    public static final Item GREEN_ENCHANTED_PLANKS = createItem(BYGBlocks.GREEN_ENCHANTED_PLANKS);
    public static final Item GREEN_ENCHANTED_BOOKSHELF = createItem(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF);
    public static final Item GREEN_ENCHANTED_CRAFTING_TABLE = createItem(BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE);
    public static final Item GREEN_ENCHANTED_STAIRS = createItem(BYGBlocks.GREEN_ENCHANTED_STAIRS);
    public static final Item GREEN_ENCHANTED_SLAB = createItem(BYGBlocks.GREEN_ENCHANTED_SLAB);
    public static final Item GREEN_ENCHANTED_FENCE = createItem(BYGBlocks.GREEN_ENCHANTED_FENCE);
    public static final Item GREEN_ENCHANTED_FENCE_GATE = createItem(BYGBlocks.GREEN_ENCHANTED_FENCE_GATE);
    public static final Item GREEN_ENCHANTED_DOOR = createItem(BYGBlocks.GREEN_ENCHANTED_DOOR);
    public static final Item GREEN_ENCHANTED_TRAPDOOR = createItem(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR);
    public static final Item GREEN_ENCHANTED_PRESSURE_PLATE = createItem(BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE);
    public static final Item GREEN_ENCHANTED_BUTTON = createItem(BYGBlocks.GREEN_ENCHANTED_BUTTON);
    public static final Item GREEN_ENCHANTED_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.GREEN_ENCHANTED, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "green_enchanted_boat");

    //Holly Woodtype
    public static final Item HOLLY_BERRY_LEAVES = createItem(BYGBlocks.HOLLY_BERRY_LEAVES);
    public static final Item HOLLY_BERRY = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 1.0F).build())), "holly_berries");
    public static final Item HOLLY_SAPLING = createSaplingItem(BYGBlocks.HOLLY_SAPLING);
    public static final Item HOLLY_LEAVES = createItem(BYGBlocks.HOLLY_LEAVES);
    public static final Item HOLLY_LOG = createItem(BYGBlocks.HOLLY_LOG);
    public static final Item HOLLY_WOOD = createItem(BYGBlocks.HOLLY_WOOD);
    public static final Item STRIPPED_HOLLY_LOG = createItem(BYGBlocks.STRIPPED_HOLLY_LOG);
    public static final Item STRIPPED_HOLLY_WOOD = createItem(BYGBlocks.STRIPPED_HOLLY_WOOD);
    public static final Item HOLLY_PLANKS = createItem(BYGBlocks.HOLLY_PLANKS);
    public static final Item HOLLY_BOOKSHELF = createItem(BYGBlocks.HOLLY_BOOKSHELF);
    public static final Item HOLLY_CRAFTING_TABLE = createItem(BYGBlocks.HOLLY_CRAFTING_TABLE);
    public static final Item HOLLY_STAIRS = createItem(BYGBlocks.HOLLY_STAIRS);
    public static final Item HOLLY_SLAB = createItem(BYGBlocks.HOLLY_SLAB);
    public static final Item HOLLY_FENCE = createItem(BYGBlocks.HOLLY_FENCE);
    public static final Item HOLLY_FENCE_GATE = createItem(BYGBlocks.HOLLY_FENCE_GATE);
    public static final Item HOLLY_DOOR = createItem(BYGBlocks.HOLLY_DOOR);
    public static final Item HOLLY_TRAPDOOR = createItem(BYGBlocks.HOLLY_TRAPDOOR);
    public static final Item HOLLY_PRESSURE_PLATE = createItem(BYGBlocks.HOLLY_PRESSURE_PLATE);
    public static final Item HOLLY_BUTTON = createItem(BYGBlocks.HOLLY_BUTTON);
    public static final Item HOLLY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.HOLLY, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "holly_boat");

    //Imparius Woodtype
    public static final Item IMPARIUS_VINE = createItem(BYGBlocks.IMPARIUS_VINE);
    public static final Item IMPARIUS_MUSHROOM_BRANCH = createItem(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH);
    public static final Item IMPARIUS_MUSHROOM_BLOCK = createItem(BYGBlocks.IMPARIUS_MUSHROOM_BLOCK);
    public static final Item IMPARIUS_MUSHROOM = createItem(BYGBlocks.IMPARIUS_MUSHROOM);
    public static final Item IMPARIUS_STEM = createItem(BYGBlocks.IMPARIUS_STEM);
    public static final Item IMPARIUS_HYPHAE = createItem(BYGBlocks.IMPARIUS_HYPHAE);
    public static final Item FUNGAL_IMPARIUS_FILAMENT_BLOCK = createItem(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT_BLOCK);
    public static final Item FUNGAL_IMPARIUS_FILAMENT = createItem(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT);
    public static final Item FUNGAL_IMPARIUS_BLOCK = createItem(BYGBlocks.FUNGAL_IMPARIUS_BLOCK);
    public static final Item FUNGAL_IMPARIUS = createItem(BYGBlocks.FUNGAL_IMPARIUS);
    public static final Item FUNGAL_IMPARIUS_STEM = createItem(BYGBlocks.FUNGAL_IMPARIUS_STEM);
    public static final Item FUNGAL_IMPARIUS_HYPHAE = createItem(BYGBlocks.FUNGAL_IMPARIUS_HYPHAE);
    public static final Item IMPARIUS_PLANKS = createItem(BYGBlocks.IMPARIUS_PLANKS);
    public static final Item IMPARIUS_BOOKSHELF = createItem(BYGBlocks.IMPARIUS_BOOKSHELF);
    public static final Item IMPARIUS_CRAFTING_TABLE = createItem(BYGBlocks.IMPARIUS_CRAFTING_TABLE);
    public static final Item IMPARIUS_STAIRS = createItem(BYGBlocks.IMPARIUS_STAIRS);
    public static final Item IMPARIUS_SLAB = createItem(BYGBlocks.IMPARIUS_SLAB);
    public static final Item IMPARIUS_FENCE = createItem(BYGBlocks.IMPARIUS_FENCE);
    public static final Item IMPARIUS_FENCE_GATE = createItem(BYGBlocks.IMPARIUS_FENCE_GATE);
    public static final Item IMPARIUS_DOOR = createItem(BYGBlocks.IMPARIUS_DOOR);
    public static final Item IMPARIUS_TRAPDOOR = createItem(BYGBlocks.IMPARIUS_TRAPDOOR);
    public static final Item IMPARIUS_PRESSURE_PLATE = createItem(BYGBlocks.IMPARIUS_PRESSURE_PLATE);
    public static final Item IMPARIUS_BUTTON = createItem(BYGBlocks.IMPARIUS_BUTTON);

    //Jacaranda Woodtype
    public static final Item JACARANDA_BUSH = createItem(BYGBlocks.JACARANDA_BUSH);
    public static final Item FLOWERING_JACARANDA_BUSH = createItem(BYGBlocks.FLOWERING_JACARANDA_BUSH);
    public static final Item JACARANDA_SAPLING = createSaplingItem(BYGBlocks.JACARANDA_SAPLING);
    public static final Item JACARANDA_LEAVES = createItem(BYGBlocks.JACARANDA_LEAVES);
    public static final Item FLOWERING_JACARANDA_LEAVES = createItem(BYGBlocks.FLOWERING_JACARANDA_LEAVES);
    public static final Item INDIGO_JACARANDA_BUSH = createItem(BYGBlocks.INDIGO_JACARANDA_BUSH);
    public static final Item FLOWERING_INDIGO_JACARANDA_BUSH = createItem(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH);
    public static final Item INDIGO_JACARANDA_SAPLING = createSaplingItem(BYGBlocks.INDIGO_JACARANDA_SAPLING);
    public static final Item INDIGO_JACARANDA_LEAVES = createItem(BYGBlocks.INDIGO_JACARANDA_LEAVES);
    public static final Item FLOWERING_INDIGO_JACARANDA_LEAVES = createItem(BYGBlocks.FLOWERING_INDIGO_JACARANDA_LEAVES);
    public static final Item JACARANDA_LOG = createItem(BYGBlocks.JACARANDA_LOG);
    public static final Item JACARANDA_WOOD = createItem(BYGBlocks.JACARANDA_WOOD);
    public static final Item STRIPPED_JACARANDA_LOG = createItem(BYGBlocks.STRIPPED_JACARANDA_LOG);
    public static final Item STRIPPED_JACARANDA_WOOD = createItem(BYGBlocks.STRIPPED_JACARANDA_WOOD);
    public static final Item JACARANDA_PLANKS = createItem(BYGBlocks.JACARANDA_PLANKS);
    public static final Item JACARANDA_BOOKSHELF = createItem(BYGBlocks.JACARANDA_BOOKSHELF);
    public static final Item JACARANDA_CRAFTING_TABLE = createItem(BYGBlocks.JACARANDA_CRAFTING_TABLE);
    public static final Item JACARANDA_STAIRS = createItem(BYGBlocks.JACARANDA_STAIRS);
    public static final Item JACARANDA_SLAB = createItem(BYGBlocks.JACARANDA_SLAB);
    public static final Item JACARANDA_FENCE = createItem(BYGBlocks.JACARANDA_FENCE);
    public static final Item JACARANDA_FENCE_GATE = createItem(BYGBlocks.JACARANDA_FENCE_GATE);
    public static final Item JACARANDA_DOOR = createItem(BYGBlocks.JACARANDA_DOOR);
    public static final Item JACARANDA_TRAPDOOR = createItem(BYGBlocks.JACARANDA_TRAPDOOR);
    public static final Item JACARANDA_PRESSURE_PLATE = createItem(BYGBlocks.JACARANDA_PRESSURE_PLATE);
    public static final Item JACARANDA_BUTTON = createItem(BYGBlocks.JACARANDA_BUTTON);
    public static final Item JACARANDA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.JACARANDA, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "jacaranda_boat");

    //Lament Woodtype
    public static final Item LAMENT_SAPLING = createSaplingItem(BYGBlocks.LAMENT_SAPLING);
    public static final Item LAMENT_LEAVES = createItem(BYGBlocks.LAMENT_LEAVES);
    public static final Item LAMENT_VINE = createItem(BYGBlocks.LAMENT_VINE);
    public static final Item LAMENT_SPROUTS = createItem(BYGBlocks.LAMENT_SPROUTS);
    public static final Item LAMENT_LOG = createItem(BYGBlocks.LAMENT_LOG);
    public static final Item LAMENT_WOOD = createItem(BYGBlocks.LAMENT_WOOD);
    public static final Item STRIPPED_LAMENT_LOG = createItem(BYGBlocks.STRIPPED_LAMENT_LOG);
    public static final Item STRIPPED_LAMENT_WOOD = createItem(BYGBlocks.STRIPPED_LAMENT_WOOD);
    public static final Item LAMENT_PLANKS = createItem(BYGBlocks.LAMENT_PLANKS);
    public static final Item LAMENT_BOOKSHELF = createItem(BYGBlocks.LAMENT_BOOKSHELF);
    public static final Item LAMENT_CRAFTING_TABLE = createItem(BYGBlocks.LAMENT_CRAFTING_TABLE);
    public static final Item LAMENT_STAIRS = createItem(BYGBlocks.LAMENT_STAIRS);
    public static final Item LAMENT_SLAB = createItem(BYGBlocks.LAMENT_SLAB);
    public static final Item LAMENT_FENCE = createItem(BYGBlocks.LAMENT_FENCE);
    public static final Item LAMENT_FENCE_GATE = createItem(BYGBlocks.LAMENT_FENCE_GATE);
    public static final Item LAMENT_DOOR = createItem(BYGBlocks.LAMENT_DOOR);
    public static final Item LAMENT_TRAPDOOR = createItem(BYGBlocks.LAMENT_TRAPDOOR);
    public static final Item LAMENT_PRESSURE_PLATE = createItem(BYGBlocks.LAMENT_PRESSURE_PLATE);
    public static final Item LAMENT_BUTTON = createItem(BYGBlocks.LAMENT_BUTTON);

    //Mahogany Woodtype
    public static final Item MAHOGANY_SAPLING = createSaplingItem(BYGBlocks.MAHOGANY_SAPLING);
    public static final Item MAHOGANY_LEAVES = createItem(BYGBlocks.MAHOGANY_LEAVES);
    public static final Item MAHOGANY_LOG = createItem(BYGBlocks.MAHOGANY_LOG);
    public static final Item MAHOGANY_WOOD = createItem(BYGBlocks.MAHOGANY_WOOD);
    public static final Item STRIPPED_MAHOGANY_LOG = createItem(BYGBlocks.STRIPPED_MAHOGANY_LOG);
    public static final Item STRIPPED_MAHOGANY_WOOD = createItem(BYGBlocks.STRIPPED_MAHOGANY_WOOD);
    public static final Item MAHOGANY_PLANKS = createItem(BYGBlocks.MAHOGANY_PLANKS);
    public static final Item MAHOGANY_BOOKSHELF = createItem(BYGBlocks.MAHOGANY_BOOKSHELF);
    public static final Item MAHOGANY_CRAFTING_TABLE = createItem(BYGBlocks.MAHOGANY_CRAFTING_TABLE);
    public static final Item MAHOGANY_STAIRS = createItem(BYGBlocks.MAHOGANY_STAIRS);
    public static final Item MAHOGANY_SLAB = createItem(BYGBlocks.MAHOGANY_SLAB);
    public static final Item MAHOGANY_FENCE = createItem(BYGBlocks.MAHOGANY_FENCE);
    public static final Item MAHOGANY_FENCE_GATE = createItem(BYGBlocks.MAHOGANY_FENCE_GATE);
    public static final Item MAHOGANY_DOOR = createItem(BYGBlocks.MAHOGANY_DOOR);
    public static final Item MAHOGANY_TRAPDOOR = createItem(BYGBlocks.MAHOGANY_TRAPDOOR);
    public static final Item MAHOGANY_PRESSURE_PLATE = createItem(BYGBlocks.MAHOGANY_PRESSURE_PLATE);
    public static final Item MAHOGANY_BUTTON = createItem(BYGBlocks.MAHOGANY_BUTTON);
    public static final Item MAHOGANY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MAHOGANY, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "mahogany_boat");

    //Mangrove Woodtype
    public static final Item MANGROVE_SAPLING = createSaplingItem(BYGBlocks.MANGROVE_SAPLING);
    public static final Item MANGROVE_LEAVES = createItem(BYGBlocks.MANGROVE_LEAVES);
    public static final Item MANGROVE_LOG = createItem(BYGBlocks.MANGROVE_LOG);
    public static final Item MANGROVE_WOOD = createItem(BYGBlocks.MANGROVE_WOOD);
    public static final Item STRIPPED_MANGROVE_LOG = createItem(BYGBlocks.STRIPPED_MANGROVE_LOG);
    public static final Item STRIPPED_MANGROVE_WOOD = createItem(BYGBlocks.STRIPPED_MANGROVE_WOOD);
    public static final Item MANGROVE_PLANKS = createItem(BYGBlocks.MANGROVE_PLANKS);
    public static final Item MANGROVE_BOOKSHELF = createItem(BYGBlocks.MANGROVE_BOOKSHELF);
    public static final Item MANGROVE_CRAFTING_TABLE = createItem(BYGBlocks.MANGROVE_CRAFTING_TABLE);
    public static final Item MANGROVE_STAIRS = createItem(BYGBlocks.MANGROVE_STAIRS);
    public static final Item MANGROVE_SLAB = createItem(BYGBlocks.MANGROVE_SLAB);
    public static final Item MANGROVE_FENCE = createItem(BYGBlocks.MANGROVE_FENCE);
    public static final Item MANGROVE_FENCE_GATE = createItem(BYGBlocks.MANGROVE_FENCE_GATE);
    public static final Item MANGROVE_DOOR = createItem(BYGBlocks.MANGROVE_DOOR);
    public static final Item MANGROVE_TRAPDOOR = createItem(BYGBlocks.MANGROVE_TRAPDOOR);
    public static final Item MANGROVE_PRESSURE_PLATE = createItem(BYGBlocks.MANGROVE_PRESSURE_PLATE);
    public static final Item MANGROVE_BUTTON = createItem(BYGBlocks.MANGROVE_BUTTON);
    public static final Item MANGROVE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MANGROVE, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "mangrove_boat");

    //Maple Woodtype
    public static final Item MAPLE_SAPLING = createSaplingItem(BYGBlocks.MAPLE_SAPLING);
    public static final Item MAPLE_LEAVES = createItem(BYGBlocks.MAPLE_LEAVES);
    public static final Item RED_MAPLE_SAPLING = createSaplingItem(BYGBlocks.RED_MAPLE_SAPLING);
    public static final Item RED_MAPLE_LEAVES = createItem(BYGBlocks.RED_MAPLE_LEAVES);
    public static final Item SILVER_MAPLE_SAPLING = createSaplingItem(BYGBlocks.SILVER_MAPLE_SAPLING);
    public static final Item SILVER_MAPLE_LEAVES = createItem(BYGBlocks.SILVER_MAPLE_LEAVES);
    public static final Item MAPLE_LOG = createItem(BYGBlocks.MAPLE_LOG);
    public static final Item MAPLE_WOOD = createItem(BYGBlocks.MAPLE_WOOD);
    public static final Item STRIPPED_MAPLE_LOG = createItem(BYGBlocks.STRIPPED_MAPLE_LOG);
    public static final Item STRIPPED_MAPLE_WOOD = createItem(BYGBlocks.STRIPPED_MAPLE_WOOD);
    public static final Item MAPLE_PLANKS = createItem(BYGBlocks.MAPLE_PLANKS);
    public static final Item MAPLE_BOOKSHELF = createItem(BYGBlocks.MAPLE_BOOKSHELF);
    public static final Item MAPLE_CRAFTING_TABLE = createItem(BYGBlocks.MAPLE_CRAFTING_TABLE);
    public static final Item MAPLE_STAIRS = createItem(BYGBlocks.MAPLE_STAIRS);
    public static final Item MAPLE_SLAB = createItem(BYGBlocks.MAPLE_SLAB);
    public static final Item MAPLE_FENCE = createItem(BYGBlocks.MAPLE_FENCE);
    public static final Item MAPLE_FENCE_GATE = createItem(BYGBlocks.MAPLE_FENCE_GATE);
    public static final Item MAPLE_DOOR = createItem(BYGBlocks.MAPLE_DOOR);
    public static final Item MAPLE_TRAPDOOR = createItem(BYGBlocks.MAPLE_TRAPDOOR);
    public static final Item MAPLE_PRESSURE_PLATE = createItem(BYGBlocks.MAPLE_PRESSURE_PLATE);
    public static final Item MAPLE_BUTTON = createItem(BYGBlocks.MAPLE_BUTTON);
    public static final Item MAPLE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MAPLE, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "maple_boat");

    //Nightshade Woodtype
    public static final Item NIGHTSHADE_SAPLING = createSaplingItem(BYGBlocks.NIGHTSHADE_SAPLING);
    public static final Item FLOWERING_NIGHTSHADE_LEAVES = createItem(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES);
    public static final Item NIGHTSHADE_LEAVES = createItem(BYGBlocks.NIGHTSHADE_LEAVES);
    public static final Item IMBUED_NIGHTSHADE_LOG = createItem(BYGBlocks.IMBUED_NIGHTSHADE_LOG);
    public static final Item NIGHTSHADE_LOG = createItem(BYGBlocks.NIGHTSHADE_LOG);
    public static final Item NIGHTSHADE_WOOD = createItem(BYGBlocks.NIGHTSHADE_WOOD);
    public static final Item STRIPPED_NIGHTSHADE_LOG = createItem(BYGBlocks.STRIPPED_NIGHTSHADE_LOG);
    public static final Item STRIPPED_NIGHTSHADE_WOOD = createItem(BYGBlocks.STRIPPED_NIGHTSHADE_WOOD);
    public static final Item NIGHTSHADE_PLANKS = createItem(BYGBlocks.NIGHTSHADE_PLANKS);
    public static final Item NIGHTSHADE_BOOKSHELF = createItem(BYGBlocks.NIGHTSHADE_BOOKSHELF);
    public static final Item NIGHTSHADE_CRAFTING_TABLE = createItem(BYGBlocks.NIGHTSHADE_CRAFTING_TABLE);
    public static final Item NIGHTSHADE_STAIRS = createItem(BYGBlocks.NIGHTSHADE_STAIRS);
    public static final Item NIGHTSHADE_SLAB = createItem(BYGBlocks.NIGHTSHADE_SLAB);
    public static final Item NIGHTSHADE_FENCE = createItem(BYGBlocks.NIGHTSHADE_FENCE);
    public static final Item NIGHTSHADE_FENCE_GATE = createItem(BYGBlocks.NIGHTSHADE_FENCE_GATE);
    public static final Item NIGHTSHADE_DOOR = createItem(BYGBlocks.NIGHTSHADE_DOOR);
    public static final Item NIGHTSHADE_TRAPDOOR = createItem(BYGBlocks.NIGHTSHADE_TRAPDOOR);
    public static final Item NIGHTSHADE_PRESSURE_PLATE = createItem(BYGBlocks.NIGHTSHADE_PRESSURE_PLATE);
    public static final Item NIGHTSHADE_BUTTON = createItem(BYGBlocks.NIGHTSHADE_BUTTON);

    //Palm Woodtype
    public static final Item PALM_SAPLING = createSaplingItem(BYGBlocks.PALM_SAPLING);
    public static final Item PALM_LEAVES = createItem(BYGBlocks.PALM_LEAVES);
    public static final Item PALM_LOG = createItem(BYGBlocks.PALM_LOG);
    public static final Item PALM_WOOD = createItem(BYGBlocks.PALM_WOOD);
    public static final Item STRIPPED_PALM_LOG = createItem(BYGBlocks.STRIPPED_PALM_LOG);
    public static final Item STRIPPED_PALM_WOOD = createItem(BYGBlocks.STRIPPED_PALM_WOOD);
    public static final Item PALM_PLANKS = createItem(BYGBlocks.PALM_PLANKS);
    public static final Item PALM_BOOKSHELF = createItem(BYGBlocks.PALM_BOOKSHELF);
    public static final Item PALM_CRAFTING_TABLE = createItem(BYGBlocks.PALM_CRAFTING_TABLE);
    public static final Item PALM_STAIRS = createItem(BYGBlocks.PALM_STAIRS);
    public static final Item PALM_SLAB = createItem(BYGBlocks.PALM_SLAB);
    public static final Item PALM_FENCE = createItem(BYGBlocks.PALM_FENCE);
    public static final Item PALM_FENCE_GATE = createItem(BYGBlocks.PALM_FENCE_GATE);
    public static final Item PALM_DOOR = createItem(BYGBlocks.PALM_DOOR);
    public static final Item PALM_TRAPDOOR = createItem(BYGBlocks.PALM_TRAPDOOR);
    public static final Item PALM_PRESSURE_PLATE = createItem(BYGBlocks.PALM_PRESSURE_PLATE);
    public static final Item PALM_BUTTON = createItem(BYGBlocks.PALM_BUTTON);
    public static final Item PALM_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.PALM, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "palm_boat");

    //Palo Verde Woodtype
    public static final Item FLOWERING_PALO_VERDE_LEAVES = createItem(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES);
    public static final Item PALO_VERDE_SAPLING = createSaplingItem(BYGBlocks.PALO_VERDE_SAPLING);
    public static final Item PALO_VERDE_LEAVES = createItem(BYGBlocks.PALO_VERDE_LEAVES);
    public static final Item PALO_VERDE_LOG = createItem(BYGBlocks.PALO_VERDE_LOG);
    public static final Item PALO_VERDE_WOOD = createItem(BYGBlocks.PALO_VERDE_WOOD);
    public static final Item STRIPPED_PALO_VERDE_LOG = createItem(BYGBlocks.STRIPPED_PALO_VERDE_LOG);
    public static final Item STRIPPED_PALO_VERDE_WOOD = createItem(BYGBlocks.STRIPPED_PALO_VERDE_WOOD);

    //Pine Woodtype
    public static final Item PINE_SAPLING = createSaplingItem(BYGBlocks.PINE_SAPLING);
    public static final Item PINE_LEAVES = createItem(BYGBlocks.PINE_LEAVES);
    public static final Item PINE_LOG = createItem(BYGBlocks.PINE_LOG);
    public static final Item PINE_WOOD = createItem(BYGBlocks.PINE_WOOD);
    public static final Item STRIPPED_PINE_LOG = createItem(BYGBlocks.STRIPPED_PINE_LOG);
    public static final Item STRIPPED_PINE_WOOD = createItem(BYGBlocks.STRIPPED_PINE_WOOD);
    public static final Item PINE_PLANKS = createItem(BYGBlocks.PINE_PLANKS);
    public static final Item PINE_BOOKSHELF = createItem(BYGBlocks.PINE_BOOKSHELF);
    public static final Item PINE_CRAFTING_TABLE = createItem(BYGBlocks.PINE_CRAFTING_TABLE);
    public static final Item PINE_STAIRS = createItem(BYGBlocks.PINE_STAIRS);
    public static final Item PINE_SLAB = createItem(BYGBlocks.PINE_SLAB);
    public static final Item PINE_FENCE = createItem(BYGBlocks.PINE_FENCE);
    public static final Item PINE_FENCE_GATE = createItem(BYGBlocks.PINE_FENCE_GATE);
    public static final Item PINE_DOOR = createItem(BYGBlocks.PINE_DOOR);
    public static final Item PINE_TRAPDOOR = createItem(BYGBlocks.PINE_TRAPDOOR);
    public static final Item PINE_PRESSURE_PLATE = createItem(BYGBlocks.PINE_PRESSURE_PLATE);
    public static final Item PINE_BUTTON = createItem(BYGBlocks.PINE_BUTTON);
    public static final Item PINE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.PINE, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "pine_boat");

    //Rainbow Eucalyptus Woodtype
    public static final Item RAINBOW_EUCALYPTUS_SAPLING = createSaplingItem(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING);
    public static final Item RAINBOW_EUCALYPTUS_LEAVES = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES);
    public static final Item RAINBOW_EUCALYPTUS_LOG = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_LOG);
    public static final Item RAINBOW_EUCALYPTUS_WOOD = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD);
    public static final Item STRIPPED_RAINBOW_EUCALYPTUS_LOG = createItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG);
    public static final Item STRIPPED_RAINBOW_EUCALYPTUS_WOOD = createItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD);
    public static final Item RAINBOW_EUCALYPTUS_PLANKS = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS);
    public static final Item RAINBOW_EUCALYPTUS_BOOKSHELF = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF);
    public static final Item RAINBOW_EUCALYPTUS_CRAFTING_TABLE = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE);
    public static final Item RAINBOW_EUCALYPTUS_STAIRS = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS);
    public static final Item RAINBOW_EUCALYPTUS_SLAB = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB);
    public static final Item RAINBOW_EUCALYPTUS_FENCE = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE);
    public static final Item RAINBOW_EUCALYPTUS_FENCE_GATE = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE);
    public static final Item RAINBOW_EUCALYPTUS_DOOR = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR);
    public static final Item RAINBOW_EUCALYPTUS_TRAPDOOR = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR);
    public static final Item RAINBOW_EUCALYPTUS_PRESSURE_PLATE = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE);
    public static final Item RAINBOW_EUCALYPTUS_BUTTON = createItem(BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON);
    public static final Item RAINBOW_EUCALYPTUS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "rainbow_eucalyptus_boat");

    //Redwood Woodtype
    public static final Item REDWOOD_SAPLING = createSaplingItem(BYGBlocks.REDWOOD_SAPLING);
    public static final Item REDWOOD_LEAVES = createItem(BYGBlocks.REDWOOD_LEAVES);
    public static final Item REDWOOD_LOG = createItem(BYGBlocks.REDWOOD_LOG);
    public static final Item REDWOOD_WOOD = createItem(BYGBlocks.REDWOOD_WOOD);
    public static final Item STRIPPED_REDWOOD_LOG = createItem(BYGBlocks.STRIPPED_REDWOOD_LOG);
    public static final Item STRIPPED_REDWOOD_WOOD = createItem(BYGBlocks.STRIPPED_REDWOOD_WOOD);
    public static final Item REDWOOD_PLANKS = createItem(BYGBlocks.REDWOOD_PLANKS);
    public static final Item REDWOOD_BOOKSHELF = createItem(BYGBlocks.REDWOOD_BOOKSHELF);
    public static final Item REDWOOD_CRAFTING_TABLE = createItem(BYGBlocks.REDWOOD_CRAFTING_TABLE);
    public static final Item REDWOOD_STAIRS = createItem(BYGBlocks.REDWOOD_STAIRS);
    public static final Item REDWOOD_SLAB = createItem(BYGBlocks.REDWOOD_SLAB);
    public static final Item REDWOOD_FENCE = createItem(BYGBlocks.REDWOOD_FENCE);
    public static final Item REDWOOD_FENCE_GATE = createItem(BYGBlocks.REDWOOD_FENCE_GATE);
    public static final Item REDWOOD_DOOR = createItem(BYGBlocks.REDWOOD_DOOR);
    public static final Item REDWOOD_TRAPDOOR = createItem(BYGBlocks.REDWOOD_TRAPDOOR);
    public static final Item REDWOOD_PRESSURE_PLATE = createItem(BYGBlocks.REDWOOD_PRESSURE_PLATE);
    public static final Item REDWOOD_BUTTON = createItem(BYGBlocks.REDWOOD_BUTTON);
    public static final Item REDWOOD_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.REDWOOD, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "redwood_boat");

    //Skyris Woodtype
    public static final Item SKYRIS_LEAVES_GREEN_APPLE = createItem(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE);
    public static final Item GREEN_APPLE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(4).saturationMod(0.35f).build())), "green_apple");
    public static final Item GREEN_APPLE_PIE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.4f).effect(new MobEffectInstance(MobEffects.DIG_SPEED, 200, 0), 1.0F).build())), "green_apple_pie");
    public static final Item SKYRIS_SAPLING = createSaplingItem(BYGBlocks.SKYRIS_SAPLING);
    public static final Item SKYRIS_VINE = createItem(BYGBlocks.SKYRIS_VINE);
    public static final Item SKYRIS_LEAVES = createItem(BYGBlocks.SKYRIS_LEAVES);
    public static final Item SKYRIS_LOG = createItem(BYGBlocks.SKYRIS_LOG);
    public static final Item SKYRIS_WOOD = createItem(BYGBlocks.SKYRIS_WOOD);
    public static final Item STRIPPED_SKYRIS_LOG = createItem(BYGBlocks.STRIPPED_SKYRIS_LOG);
    public static final Item STRIPPED_SKYRIS_WOOD = createItem(BYGBlocks.STRIPPED_SKYRIS_WOOD);
    public static final Item SKYRIS_PLANKS = createItem(BYGBlocks.SKYRIS_PLANKS);
    public static final Item SKYRIS_BOOKSHELF = createItem(BYGBlocks.SKYRIS_BOOKSHELF);
    public static final Item SKYRIS_CRAFTING_TABLE = createItem(BYGBlocks.SKYRIS_CRAFTING_TABLE);
    public static final Item SKYRIS_STAIRS = createItem(BYGBlocks.SKYRIS_STAIRS);
    public static final Item SKYRIS_SLAB = createItem(BYGBlocks.SKYRIS_SLAB);
    public static final Item SKYRIS_FENCE = createItem(BYGBlocks.SKYRIS_FENCE);
    public static final Item SKYRIS_FENCE_GATE = createItem(BYGBlocks.SKYRIS_FENCE_GATE);
    public static final Item SKYRIS_DOOR = createItem(BYGBlocks.SKYRIS_DOOR);
    public static final Item SKYRIS_TRAPDOOR = createItem(BYGBlocks.SKYRIS_TRAPDOOR);
    public static final Item SKYRIS_PRESSURE_PLATE = createItem(BYGBlocks.SKYRIS_PRESSURE_PLATE);
    public static final Item SKYRIS_BUTTON = createItem(BYGBlocks.SKYRIS_BUTTON);
    public static final Item SKYRIS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.SKYRIS, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "skyris_boat");

    //Willow Woodtype
    public static final Item WILLOW_SAPLING = createSaplingItem(BYGBlocks.WILLOW_SAPLING);
    public static final Item WILLOW_LEAVES = createItem(BYGBlocks.WILLOW_LEAVES);
    public static final Item WILLOW_LOG = createItem(BYGBlocks.WILLOW_LOG);
    public static final Item WILLOW_WOOD = createItem(BYGBlocks.WILLOW_WOOD);
    public static final Item STRIPPED_WILLOW_LOG = createItem(BYGBlocks.STRIPPED_WILLOW_LOG);
    public static final Item STRIPPED_WILLOW_WOOD = createItem(BYGBlocks.STRIPPED_WILLOW_WOOD);
    public static final Item WILLOW_PLANKS = createItem(BYGBlocks.WILLOW_PLANKS);
    public static final Item WILLOW_BOOKSHELF = createItem(BYGBlocks.WILLOW_BOOKSHELF);
    public static final Item WILLOW_CRAFTING_TABLE = createItem(BYGBlocks.WILLOW_CRAFTING_TABLE);
    public static final Item WILLOW_STAIRS = createItem(BYGBlocks.WILLOW_STAIRS);
    public static final Item WILLOW_SLAB = createItem(BYGBlocks.WILLOW_SLAB);
    public static final Item WILLOW_FENCE = createItem(BYGBlocks.WILLOW_FENCE);
    public static final Item WILLOW_FENCE_GATE = createItem(BYGBlocks.WILLOW_FENCE_GATE);
    public static final Item WILLOW_DOOR = createItem(BYGBlocks.WILLOW_DOOR);
    public static final Item WILLOW_TRAPDOOR = createItem(BYGBlocks.WILLOW_TRAPDOOR);
    public static final Item WILLOW_PRESSURE_PLATE = createItem(BYGBlocks.WILLOW_PRESSURE_PLATE);
    public static final Item WILLOW_BUTTON = createItem(BYGBlocks.WILLOW_BUTTON);
    public static final Item WILLOW_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.WILLOW, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "willow_boat");

    //Witch-Hazel Woodtype
    public static final Item WITCH_HAZEL_BLOSSOM = createItem(BYGBlocks.WITCH_HAZEL_BLOSSOM);
    public static final Item WITCH_HAZEL_BRANCH = createItem(BYGBlocks.WITCH_HAZEL_BRANCH);

    public static final Item BLOOMING_WITCH_HAZEL_LEAVES = createItem(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES);
    public static final Item WITCH_HAZEL_SAPLING = createSaplingItem(BYGBlocks.WITCH_HAZEL_SAPLING);
    public static final Item WITCH_HAZEL_LEAVES = createItem(BYGBlocks.WITCH_HAZEL_LEAVES);
    public static final Item WITCH_HAZEL_LOG = createItem(BYGBlocks.WITCH_HAZEL_LOG);
    public static final Item WITCH_HAZEL_WOOD = createItem(BYGBlocks.WITCH_HAZEL_WOOD);
    public static final Item STRIPPED_WITCH_HAZEL_LOG = createItem(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG);
    public static final Item STRIPPED_WITCH_HAZEL_WOOD = createItem(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD);
    public static final Item WITCH_HAZEL_PLANKS = createItem(BYGBlocks.WITCH_HAZEL_PLANKS);
    public static final Item WITCH_HAZEL_BOOKSHELF = createItem(BYGBlocks.WITCH_HAZEL_BOOKSHELF);
    public static final Item WITCH_HAZEL_CRAFTING_TABLE = createItem(BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE);
    public static final Item WITCH_HAZEL_STAIRS = createItem(BYGBlocks.WITCH_HAZEL_STAIRS);
    public static final Item WITCH_HAZEL_SLAB = createItem(BYGBlocks.WITCH_HAZEL_SLAB);
    public static final Item WITCH_HAZEL_FENCE = createItem(BYGBlocks.WITCH_HAZEL_FENCE);
    public static final Item WITCH_HAZEL_FENCE_GATE = createItem(BYGBlocks.WITCH_HAZEL_FENCE_GATE);
    public static final Item WITCH_HAZEL_DOOR = createItem(BYGBlocks.WITCH_HAZEL_DOOR);
    public static final Item WITCH_HAZEL_TRAPDOOR = createItem(BYGBlocks.WITCH_HAZEL_TRAPDOOR);
    public static final Item WITCH_HAZEL_PRESSURE_PLATE = createItem(BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE);
    public static final Item WITCH_HAZEL_BUTTON = createItem(BYGBlocks.WITCH_HAZEL_BUTTON);
    public static final Item WITCH_HAZEL_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.WITCH_HAZEL, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "witch_hazel_boat");

    //Zelkova Woodtype
    public static final Item ZELKOVA_SAPLING = createSaplingItem(BYGBlocks.ZELKOVA_SAPLING);
    public static final Item ZELKOVA_LEAVES = createItem(BYGBlocks.ZELKOVA_LEAVES);
    public static final Item ZELKOVA_LOG = createItem(BYGBlocks.ZELKOVA_LOG);
    public static final Item ZELKOVA_WOOD = createItem(BYGBlocks.ZELKOVA_WOOD);
    public static final Item STRIPPED_ZELKOVA_LOG = createItem(BYGBlocks.STRIPPED_ZELKOVA_LOG);
    public static final Item STRIPPED_ZELKOVA_WOOD = createItem(BYGBlocks.STRIPPED_ZELKOVA_WOOD);
    public static final Item ZELKOVA_PLANKS = createItem(BYGBlocks.ZELKOVA_PLANKS);
    public static final Item ZELKOVA_BOOKSHELF = createItem(BYGBlocks.ZELKOVA_BOOKSHELF);
    public static final Item ZELKOVA_CRAFTING_TABLE = createItem(BYGBlocks.ZELKOVA_CRAFTING_TABLE);
    public static final Item ZELKOVA_STAIRS = createItem(BYGBlocks.ZELKOVA_STAIRS);
    public static final Item ZELKOVA_SLAB = createItem(BYGBlocks.ZELKOVA_SLAB);
    public static final Item ZELKOVA_FENCE = createItem(BYGBlocks.ZELKOVA_FENCE);
    public static final Item ZELKOVA_FENCE_GATE = createItem(BYGBlocks.ZELKOVA_FENCE_GATE);
    public static final Item ZELKOVA_DOOR = createItem(BYGBlocks.ZELKOVA_DOOR);
    public static final Item ZELKOVA_TRAPDOOR = createItem(BYGBlocks.ZELKOVA_TRAPDOOR);
    public static final Item ZELKOVA_PRESSURE_PLATE = createItem(BYGBlocks.ZELKOVA_PRESSURE_PLATE);
    public static final Item ZELKOVA_BUTTON = createItem(BYGBlocks.ZELKOVA_BUTTON);
    public static final Item ZELKOVA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.ZELKOVA, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).stacksTo(1)), "zelkova_boat");

    //Sythian Woodtype
    public static final Item SYTHIAN_WART_BLOCK = createItem(BYGBlocks.SYTHIAN_WART_BLOCK);
    public static final Item SYTHIAN_FUNGUS = createItem(BYGBlocks.SYTHIAN_FUNGUS);
    public static final Item SYTHIAN_STEM = createItem(BYGBlocks.SYTHIAN_STEM);
    public static final Item SYTHIAN_HYPHAE = createItem(BYGBlocks.SYTHIAN_HYPHAE);
    public static final Item STRIPPED_SYTHIAN_STEM = createItem(BYGBlocks.STRIPPED_SYTHIAN_STEM);
    public static final Item STRIPPED_SYTHIAN_HYPHAE = createItem(BYGBlocks.STRIPPED_SYTHIAN_HYPHAE);
    public static final Item SYTHIAN_PLANKS = createItem(BYGBlocks.SYTHIAN_PLANKS);
    public static final Item SYTHIAN_BOOKSHELF = createItem(BYGBlocks.SYTHIAN_BOOKSHELF);
    public static final Item SYTHIAN_CRAFTING_TABLE = createItem(BYGBlocks.SYTHIAN_CRAFTING_TABLE);
    public static final Item SYTHIAN_STAIRS = createItem(BYGBlocks.SYTHIAN_STAIRS);
    public static final Item SYTHIAN_SLAB = createItem(BYGBlocks.SYTHIAN_SLAB);
    public static final Item SYTHIAN_FENCE = createItem(BYGBlocks.SYTHIAN_FENCE);
    public static final Item SYTHIAN_FENCE_GATE = createItem(BYGBlocks.SYTHIAN_FENCE_GATE);
    public static final Item SYTHIAN_DOOR = createItem(BYGBlocks.SYTHIAN_DOOR);
    public static final Item SYTHIAN_TRAPDOOR = createItem(BYGBlocks.SYTHIAN_TRAPDOOR);
    public static final Item SYTHIAN_PRESSURE_PLATE = createItem(BYGBlocks.SYTHIAN_PRESSURE_PLATE);
    public static final Item SYTHIAN_BUTTON = createItem(BYGBlocks.SYTHIAN_BUTTON);

    //Embur Woodtype
    public static final Item EMBUR_GEL_BALL = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "embur_gel_ball");
    public static final Item EMBUR_GEL_BLOCK = createItem(BYGBlocks.EMBUR_GEL_BLOCK);
    public static final Item EMBUR_GEL_BRANCH = createItem(BYGBlocks.EMBUR_GEL_BRANCH);
    public static final Item EMBUR_GEL_VINES = createItem(BYGBlocks.EMBUR_GEL_VINES);
    public static final Item EMBUR_WART = createItem(BYGBlocks.EMBUR_WART);
    public static final Item EMBUR_PEDU = createItem(BYGBlocks.EMBUR_PEDU);
    public static final Item EMBUR_HYPHAE = createItem(BYGBlocks.EMBUR_HYPHAE);
    public static final Item STRIPPED_EMBUR_PEDU = createItem(BYGBlocks.STRIPPED_EMBUR_PEDU);
    public static final Item STRIPPED_EMBUR_HYPHAE = createItem(BYGBlocks.STRIPPED_EMBUR_HYPHAE);
    public static final Item EMBUR_PLANKS = createItem(BYGBlocks.EMBUR_PLANKS);
    public static final Item EMBUR_BOOKSHELF = createItem(BYGBlocks.EMBUR_BOOKSHELF);
    public static final Item EMBUR_CRAFTING_TABLE = createItem(BYGBlocks.EMBUR_CRAFTING_TABLE);
    public static final Item EMBUR_STAIRS = createItem(BYGBlocks.EMBUR_STAIRS);
    public static final Item EMBUR_SLAB = createItem(BYGBlocks.EMBUR_SLAB);
    public static final Item EMBUR_FENCE = createItem(BYGBlocks.EMBUR_FENCE);
    public static final Item EMBUR_FENCE_GATE = createItem(BYGBlocks.EMBUR_FENCE_GATE);
    public static final Item EMBUR_DOOR = createItem(BYGBlocks.EMBUR_DOOR);
    public static final Item EMBUR_TRAPDOOR = createItem(BYGBlocks.EMBUR_TRAPDOOR);
    public static final Item EMBUR_PRESSURE_PLATE = createItem(BYGBlocks.EMBUR_PRESSURE_PLATE);
    public static final Item EMBUR_BUTTON = createItem(BYGBlocks.EMBUR_BUTTON);

    //SaplingItems
    public static final Item WITHERING_OAK_SAPLING = createItem(BYGBlocks.WITHERING_OAK_SAPLING);
    public static final Item WITHERING_OAK_LEAVES = createItem(BYGBlocks.WITHERING_OAK_LEAVES);
    public static final Item WITHERING_OAK_LOG = createItem(BYGBlocks.WITHERING_OAK_LOG);
    public static final Item WITHERING_OAK_WOOD = createItem(BYGBlocks.WITHERING_OAK_WOOD);

    public static final Item ARAUCARIA_SAPLING = createItem(BYGBlocks.ARAUCARIA_SAPLING);
    public static final Item ARAUCARIA_LEAVES = createItem(BYGBlocks.ARAUCARIA_LEAVES);

    public static final Item BLUE_SPRUCE_SAPLING = createItem(BYGBlocks.BLUE_SPRUCE_SAPLING);
    public static final Item BLUE_SPRUCE_LEAVES = createItem(BYGBlocks.BLUE_SPRUCE_LEAVES);

    public static final Item BROWN_BIRCH_SAPLING = createItem(BYGBlocks.BROWN_BIRCH_SAPLING);
    public static final Item BROWN_BIRCH_LEAVES = createItem(BYGBlocks.BROWN_BIRCH_LEAVES);

    public static final Item BROWN_OAK_SAPLING = createItem(BYGBlocks.BROWN_OAK_SAPLING);
    public static final Item BROWN_OAK_LEAVES = createItem(BYGBlocks.BROWN_OAK_LEAVES);

    public static final Item BROWN_ZELKOVA_SAPLING = createItem(BYGBlocks.BROWN_ZELKOVA_SAPLING);
    public static final Item BROWN_ZELKOVA_LEAVES = createItem(BYGBlocks.BROWN_ZELKOVA_LEAVES);

    public static final Item JOSHUA_SAPLING = createItem(BYGBlocks.JOSHUA_SAPLING);
    public static final Item JOSHUA_LEAVES = createItem(BYGBlocks.JOSHUA_LEAVES);
    public static final Item RIPE_JOSHUA_LEAVES = createItem(BYGBlocks.RIPE_JOSHUA_LEAVES);
    public static final Item COOKED_JOSHUA_FRUIT = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(5).saturationMod(0.4f).build())), "cooked_joshua_fruit");
    public static final Item JOSHUA_FRUIT = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.35f).build())), "joshua_fruit");


    public static final Item ORANGE_BIRCH_SAPLING = createItem(BYGBlocks.ORANGE_BIRCH_SAPLING);
    public static final Item ORANGE_BIRCH_LEAVES = createItem(BYGBlocks.ORANGE_BIRCH_LEAVES);

    public static final Item ORANGE_OAK_SAPLING = createItem(BYGBlocks.ORANGE_OAK_SAPLING);
    public static final Item ORANGE_OAK_LEAVES = createItem(BYGBlocks.ORANGE_OAK_LEAVES);

    public static final Item ORANGE_SPRUCE_SAPLING = createItem(BYGBlocks.ORANGE_SPRUCE_SAPLING);
    public static final Item ORANGE_SPRUCE_LEAVES = createItem(BYGBlocks.ORANGE_SPRUCE_LEAVES);

    public static final Item ORCHARD_SAPLING = createItem(BYGBlocks.ORCHARD_SAPLING);
    public static final Item RIPE_ORCHARD_LEAVES = createItem(BYGBlocks.RIPE_ORCHARD_LEAVES);
    public static final Item FLOWERING_ORCHARD_LEAVES = createItem(BYGBlocks.FLOWERING_ORCHARD_LEAVES);
    public static final Item ORCHARD_LEAVES = createItem(BYGBlocks.ORCHARD_LEAVES);

    public static final Item RED_BIRCH_SAPLING = createItem(BYGBlocks.RED_BIRCH_SAPLING);
    public static final Item RED_BIRCH_LEAVES = createItem(BYGBlocks.RED_BIRCH_LEAVES);

    public static final Item RED_OAK_SAPLING = createItem(BYGBlocks.RED_OAK_SAPLING);
    public static final Item RED_OAK_LEAVES = createItem(BYGBlocks.RED_OAK_LEAVES);

    public static final Item RED_SPRUCE_SAPLING = createItem(BYGBlocks.RED_SPRUCE_SAPLING);
    public static final Item RED_SPRUCE_LEAVES = createItem(BYGBlocks.RED_SPRUCE_LEAVES);

    public static final Item YELLOW_BIRCH_SAPLING = createItem(BYGBlocks.YELLOW_BIRCH_SAPLING);
    public static final Item YELLOW_BIRCH_LEAVES = createItem(BYGBlocks.YELLOW_BIRCH_LEAVES);

    public static final Item YELLOW_SPRUCE_SAPLING = createItem(BYGBlocks.YELLOW_SPRUCE_SAPLING);
    public static final Item YELLOW_SPRUCE_LEAVES = createItem(BYGBlocks.YELLOW_SPRUCE_LEAVES);

    public static final Item FIRECRACKER_LEAVES = createItem(BYGBlocks.FIRECRACKER_LEAVES);
    public static final Item FIRECRACKER_FLOWER_BUSH = createItem(BYGBlocks.FIRECRACKER_FLOWER_BUSH);

    //Nether
    public static final Item OVERGROWN_CRIMSON_BLACKSTONE = createItem(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE);
    public static final Item TALL_CRIMSON_ROOTS = createItem(BYGBlocks.TALL_CRIMSON_ROOTS);
    public static final Item CRIMSON_BERRIES = createItem(new ItemNameBlockItem(BYGBlocks.CRIMSON_BERRY_BUSH, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build())), "crimson_berries");
    public static final Item CRIMSON_BERRY_PIE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 200, 0), 1.0F).build())), "crimson_berry_pie");

    public static final Item WARPED_CACTUS = createItem(BYGBlocks.WARPED_CACTUS);
    public static final Item WARPED_BUSH = createItem(BYGBlocks.WARPED_BUSH);
    public static final Item WARPED_CORAL_BLOCK = createItem(BYGBlocks.WARPED_CORAL_BLOCK);
    public static final Item WARPED_CORAL = createItem(BYGBlocks.WARPED_CORAL);
    public static final Item WARPED_CORAL_FAN = createItem(BYGBlocks.WARPED_CORAL_FAN);
    public static final Item WARPED_SOUL_SAND = createItem(BYGBlocks.WARPED_SOUL_SAND);
    public static final Item WARPED_SOUL_SOIL = createItem(BYGBlocks.WARPED_SOUL_SOIL);

    public static final Item FROST_MAGMA = createItem(BYGBlocks.FROST_MAGMA);
    public static final Item SUBZERO_ASH = createItem(BYGBlocks.SUBZERO_ASH);
    public static final Item SUBZERO_ASH_BLOCK = createItem(BYGBlocks.SUBZERO_ASH_BLOCK);
    public static final Item SUBZERO_CRYSTAL_BLOCK = createItem(BYGBlocks.SUBZERO_CRYSTAL_BLOCK);
    public static final Item BUDDING_SUBZERO_CRYSTAL = createItem(BYGBlocks.BUDDING_SUBZERO_CRYSTAL);
    public static final Item SMALL_SUBZERO_CRYSTAL_BUD = createItem(BYGBlocks.SMALL_SUBZERO_CRYSTAL_BUD);
    public static final Item MEDIUM_SUBZERO_CRYSTAL_BUD = createItem(BYGBlocks.MEDIUM_SUBZERO_CRYSTAL_BUD);
    public static final Item LARGE_SUBZERO_CRYSTAL_BUD = createItem(BYGBlocks.LARGE_SUBZERO_CRYSTAL_BUD);
    public static final Item SUBZERO_CRYSTAL_CLUSTER = createItem(BYGBlocks.SUBZERO_CRYSTAL_CLUSTER);
    public static final Item SUBZERO_CRYSTAL_SHARD = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "subzero_crystal_shard");
    public static final Item HYPOGEAL_IMPERIUM = createItem(BYGBlocks.HYPOGEAL_IMPERIUM);

    public static final Item ANTHRACITE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "anthracite");
    public static final Item ANTHRACITE_BLOCK = createItem(BYGBlocks.ANTHRACITE_BLOCK);
    public static final Item ANTHRACITE_ORE = createItem(BYGBlocks.ANTHRACITE_ORE);
    public static final Item BRIMSTONE = createItem(BYGBlocks.BRIMSTONE);
    public static final Item BRIM_POWDER = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "brim_powder");
    public static final Item BORIC_CAMPFIRE = createItem(BYGBlocks.BORIC_CAMPFIRE);
    public static final Item BORIC_LANTERN = createItem(BYGBlocks.BORIC_LANTERN);
    public static final Item YELLOW_NETHER_BRICKS = createItem(BYGBlocks.YELLOW_NETHER_BRICKS);
    public static final Item YELLOW_NETHER_BRICK = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "yellow_nether_brick");
    public static final Item MAGMATIC_STONE = createItem(BYGBlocks.MAGMATIC_STONE);

    public static final Item HANGING_BONE = createItem(BYGBlocks.HANGING_BONE);
    public static final Item QUARTZ_CRYSTAL = createItem(BYGBlocks.QUARTZ_CRYSTAL);
    public static final Item QUARTZITE_SAND = createItem(BYGBlocks.QUARTZITE_SAND);
    public static final Item RAW_QUARTZ_BLOCK = createItem(BYGBlocks.RAW_QUARTZ_BLOCK);
    public static final Item BLUE_NETHER_GOLD_ORE = createItem(BYGBlocks.BLUE_NETHER_GOLD_ORE);
    public static final Item BLUE_NETHER_QUARTZ_ORE = createItem(BYGBlocks.BLUE_NETHER_QUARTZ_ORE);
    public static final Item BRIMSTONE_NETHER_GOLD_ORE = createItem(BYGBlocks.BRIMSTONE_NETHER_GOLD_ORE);
    public static final Item BRIMSTONE_NETHER_QUARTZ_ORE = createItem(BYGBlocks.BRIMSTONE_NETHER_QUARTZ_ORE);

    public static final Item WAILING_BELL_BLOSSOM = createItem(BYGBlocks.WAILING_BELL_BLOSSOM);
    public static final Item WAILING_VINES = createItem(BYGBlocks.WAILING_VINES);
    public static final Item WAILING_NYLIUM = createItem(BYGBlocks.WAILING_NYLIUM);
    public static final Item WAILING_GRASS = createItem(BYGBlocks.WAILING_GRASS);
    public static final Item DUSTED_POLISHED_BLACKSTONE_BRICKS = createItem(BYGBlocks.DUSTED_POLISHED_BLACKSTONE_BRICKS);
    public static final Item SCORCHED_BUSH = createItem(BYGBlocks.SCORCHED_BUSH);
    public static final Item SCORCHED_GRASS = createItem(BYGBlocks.SCORCHED_GRASS);
    public static final Item ARISIAN_BLOOM_BRANCH = createItem(BYGBlocks.ARISIAN_BLOOM_BRANCH);

    public static final Item SOUL_SHROOM = createItem(BYGBlocks.SOUL_SHROOM);
    public static final Item SOUL_SHROOM_SPORE_END = createItem(BYGBlocks.SOUL_SHROOM_SPORE_END);
    public static final Item SOUL_SHROOM_STEM = createItem(BYGBlocks.SOUL_SHROOM_STEM);
    public static final Item SOUL_SHROOM_BLOCK = createItem(BYGBlocks.SOUL_SHROOM_BLOCK);
    public static final Item DEATH_CAP = createItem(BYGBlocks.DEATH_CAP);
    public static final Item DEATH_CAP_MUSHROOM_BLOCK = createItem(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK);

    public static final Item WEEPING_ROOTS = createItem(BYGBlocks.WEEPING_ROOTS);
    public static final Item NETHER_BRISTLE = createItem(BYGBlocks.NETHER_BRISTLE);
    public static final Item MYCELIUM_NETHERRACK = createItem(BYGBlocks.MYCELIUM_NETHERRACK);
    public static final Item OVERGROWN_NETHERRACK = createItem(BYGBlocks.OVERGROWN_NETHERRACK);

    public static final Item PERVADED_NETHERRACK = createItem(BYGBlocks.PERVADED_NETHERRACK);
    public static final Item GLOWSTONE_LANTERN = createItem(BYGBlocks.GLOWSTONE_LANTERN);
    public static final Item GLOWSTONE_LAMP = createItem(BYGBlocks.GLOWSTONE_LAMP);

    public static final Item SYTHIAN_NYLIUM = createItem(BYGBlocks.SYTHIAN_NYLIUM);
    public static final Item SYTHIAN_ROOTS = createItem(BYGBlocks.SYTHIAN_ROOTS);
    public static final Item SYTHIAN_SPROUT = createItem(BYGBlocks.SYTHIAN_SPROUT);
    public static final Item SYTHIAN_STALK_BLOCK = createItem(BYGBlocks.SYTHIAN_STALK_BLOCK);
    public static final Item SYTHIAN_SCAFFOLDING = createItem(BYGBlocks.SYTHIAN_SCAFFOLDING);
    public static final Item HANGING_SYTHIAN_ROOTS = createItem(BYGBlocks.HANGING_SYTHIAN_ROOTS);

    public static final Item EMBUR_NYLIUM = createItem(BYGBlocks.EMBUR_NYLIUM);
    public static final Item EMBUR_SPROUTS = createItem(BYGBlocks.EMBUR_SPROUTS);
    public static final Item EMBUR_ROOTS = createItem(BYGBlocks.EMBUR_ROOTS);
    public static final Item TALL_EMBUR_ROOTS = createItem(BYGBlocks.TALL_EMBUR_ROOTS);
    public static final Item EMBUR_LILY = createItem(BYGBlocks.EMBUR_LILY);

    public static final Item BLUE_NETHERRACK_BRICK = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "blue_nether_brick");
    public static final Item BLUE_NETHERRACK = createItem(BYGBlocks.BLUE_NETHERRACK);
    public static final Item BLUE_NETHERRACK_BRICKS = createItem(BYGBlocks.BLUE_NETHERRACK_BRICKS);


    //End
    public static final Item IVIS_PHYLIUM = createItem(BYGBlocks.IVIS_PHYLIUM);
    public static final Item IVIS_ROOTS = createItem(BYGBlocks.IVIS_ROOTS);
    public static final Item IVIS_SPROUT = createItem(BYGBlocks.IVIS_SPROUT);
    public static final Item ENDER_LILY = createItem(BYGBlocks.ENDER_LILY);

    public static final Item IMPARIUS_BUSH = createItem(BYGBlocks.IMPARIUS_BUSH);
    public static final Item IMPARIUS_PHYLIUM = createItem(BYGBlocks.IMPARIUS_PHYLIUM);
    public static final Item CHISELED_FUNGAL_IMPARIUS = createItem(BYGBlocks.CHISELED_FUNGAL_IMPARIUS);
    public static final Item CHISELED_FUNGAL_IMPARIUS_SLAB = createItem(BYGBlocks.CHISELED_FUNGAL_IMPARIUS_SLAB);
    public static final Item CHISELED_FUNGAL_IMPARIUS_STAIRS = createItem(BYGBlocks.CHISELED_FUNGAL_IMPARIUS_STAIRS);
    public static final Item CHISELED_FUNGAL_IMPARIUS_WALL = createItem(BYGBlocks.CHISELED_FUNGAL_IMPARIUS_WALL);

    public static final Item ETHER_PHYLIUM = createItem(BYGBlocks.ETHER_PHYLIUM);
    public static final Item ETHER_SOIL = createItem(BYGBlocks.ETHER_SOIL);
    public static final Item ETHER_STONE = createItem(BYGBlocks.ETHER_STONE);
    public static final Item ETHER_STONE_SLAB = createItem(BYGBlocks.ETHER_STONE_SLAB);
    public static final Item ETHER_STONE_STAIRS = createItem(BYGBlocks.ETHER_STONE_STAIRS);
    public static final Item ETHER_STONE_WALL = createItem(BYGBlocks.ETHER_STONE_WALL);

    public static final Item COBBLED_ETHER_STONE = createItem(BYGBlocks.COBBLED_ETHER_STONE);
    public static final Item COBBLED_ETHER_STONE_SLAB = createItem(BYGBlocks.COBBLED_ETHER_STONE_SLAB);
    public static final Item COBBLED_ETHER_STONE_STAIRS = createItem(BYGBlocks.COBBLED_ETHER_STONE_STAIRS);
    public static final Item COBBLED_ETHER_STONE_WALL = createItem(BYGBlocks.COBBLED_ETHER_STONE_WALL);

    public static final Item CARVED_ETHER_STONE = createItem(BYGBlocks.CARVED_ETHER_STONE);
    public static final Item CARVED_ETHER_STONE_SLAB = createItem(BYGBlocks.CARVED_ETHER_STONE_SLAB);
    public static final Item CARVED_ETHER_STONE_STAIRS = createItem(BYGBlocks.CARVED_ETHER_STONE_STAIRS);
    public static final Item CARVED_ETHER_STONE_WALL = createItem(BYGBlocks.CARVED_ETHER_STONE_WALL);

    public static final Item BULBIS_SPROUTS = createItem(BYGBlocks.BULBIS_SPROUTS);
    public static final Item BULBIS_PHYCELIUM = createItem(BYGBlocks.BULBIS_PHYCELIUM);

    public static final Item LIGNITE_ORE = createItem(BYGBlocks.LIGNITE_ORE);
    public static final Item LIGNITE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "lignite");
    public static final Item LIGNITE_BLOCK = createItem(BYGBlocks.LIGNITE_BLOCK);

    public static final Item ETHER_FOLIAGE = createItem(BYGBlocks.ETHER_FOLIAGE);
    public static final Item TALL_ETHER_GRASS = createItem(BYGBlocks.TALL_ETHER_GRASS);
    public static final Item ETHER_GRASS = createItem(BYGBlocks.ETHER_GRASS);
    public static final Item ETHER_BUSH = createItem(BYGBlocks.ETHER_BUSH);
    public static final Item THEREAL_BELLFLOWER = createItem(BYGBlocks.THEREAL_BELLFLOWER);

    public static final Item NIGHTSHADE_BERRIES = createItem(new ItemNameBlockItem(BYGBlocks.NIGHTSHADE_BERRY_BUSH, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build())), "nightshade_berries");
    public static final Item NIGHTSHADE_BERRY_PIE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 200, 0), 1.0F).build())), "nightshade_berry_pie");
    public static final Item NIGHTSHADE_PHYLIUM = createItem(BYGBlocks.NIGHTSHADE_PHYLIUM);
    public static final Item NIGHTSHADE_SPROUTS = createItem(BYGBlocks.NIGHTSHADE_SPROUTS);
    public static final Item NIGHTSHADE_ROOTS = createItem(BYGBlocks.NIGHTSHADE_ROOTS);

    public static final Item PURPUR_STONE = createItem(BYGBlocks.PURPUR_STONE);
    public static final Item PURPUR_STONE_SLAB = createItem(BYGBlocks.PURPUR_STONE_SLAB);
    public static final Item PURPUR_STONE_STAIRS = createItem(BYGBlocks.PURPUR_STONE_STAIRS);
    public static final Item PURPUR_STONE_WALL = createItem(BYGBlocks.PURPUR_STONE_WALL);

    public static final Item ODDITY_CACTUS = createItem(BYGBlocks.ODDITY_CACTUS);
    public static final Item ODDITY_BUSH = createItem(BYGBlocks.ODDITY_BUSH);
    public static final Item END_SAND = createItem(BYGBlocks.END_SAND);

    public static final Item THERIUM_SHARD = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "therium_shard");
    public static final Item THERIUM_CRYSTAL = createItem(BYGBlocks.THERIUM_CRYSTAL);
    public static final Item THERIUM_BLOCK = createItem(BYGBlocks.THERIUM_BLOCK);
    public static final Item CHISELED_THERIUM = createItem(BYGBlocks.CHISELED_THERIUM);
    public static final Item CHISELED_THERIUM_STAIRS = createItem(BYGBlocks.CHISELED_THERIUM_STAIRS);
    public static final Item CHISELED_THERIUM_SLAB = createItem(BYGBlocks.CHISELED_THERIUM_SLAB);
    public static final Item CHISELED_THERIUM_WALL = createItem(BYGBlocks.CHISELED_THERIUM_WALL);
    public static final Item SHINY_CHISELED_THERIUM = createItem(BYGBlocks.SHINY_CHISELED_THERIUM);
    public static final Item SHINY_CHISELED_THERIUM_STAIRS = createItem(BYGBlocks.SHINY_CHISELED_THERIUM_STAIRS);
    public static final Item SHINY_CHISELED_THERIUM_SLAB = createItem(BYGBlocks.SHINY_CHISELED_THERIUM_SLAB);
    public static final Item SHINY_CHISELED_THERIUM_WALL = createItem(BYGBlocks.SHINY_CHISELED_THERIUM_WALL);
    public static final Item THERIUM_GLASS = createItem(BYGBlocks.THERIUM_GLASS);
    public static final Item THERIUM_GLASS_PANE = createItem(BYGBlocks.THERIUM_GLASS_PANE);
    public static final Item THERIUM_LANTERN = createItem(BYGBlocks.THERIUM_LANTERN);
    public static final Item THERIUM_LAMP = createItem(BYGBlocks.THERIUM_LAMP);

    public static final Item VERMILION_SCULK_TENDRILS = createItem(BYGBlocks.VERMILION_SCULK_TENDRILS);
    public static final Item VERMILION_SCULK_GROWTH = createItem(BYGBlocks.VERMILION_SCULK_GROWTH);
    public static final Item VERMILION_SCULK = createItem(BYGBlocks.VERMILION_SCULK);

    public static final Item SHULKREN_FUNGUS = createItem(BYGBlocks.SHULKREN_FUNGUS);
    public static final Item SHULKREN_WART_BLOCK = createItem(BYGBlocks.SHULKREN_WART_BLOCK);
    public static final Item SHULKREN_MOSS_BLANKET = createItem(BYGBlocks.SHULKREN_MOSS_BLANKET);
    public static final Item SHULKREN_VINE = createItem(BYGBlocks.SHULKREN_VINE);
    public static final Item SHULKREN_PHYLIUM = createItem(BYGBlocks.SHULKREN_PHYLIUM);
    public static final Item PURPLE_SHROOMLIGHT = createItem(BYGBlocks.PURPLE_SHROOMLIGHT);

    public static final Item CRYPTIC_END_ROD = createItem(BYGBlocks.CRYPTIC_END_ROD);
    public static final Item CRYPTIC_CAMPFIRE = createItem(BYGBlocks.CRYPTIC_CAMPFIRE);
    public static final Item CRYPTIC_LANTERN = createItem(BYGBlocks.CRYPTIC_LANTERN);
    public static final Item CRYPTIC_MAGMA_BLOCK = createItem(BYGBlocks.CRYPTIC_MAGMA_BLOCK);
    public static final Item CRYPTIC_REDSTONE_ORE = createItem(BYGBlocks.CRYPTIC_REDSTONE_ORE);
    public static final Item CRYPTIC_STONE = createItem(BYGBlocks.CRYPTIC_STONE);
    public static final Item CRYPTIC_STONE_SLAB = createItem(BYGBlocks.CRYPTIC_STONE_SLAB);
    public static final Item CRYPTIC_STONE_STAIRS = createItem(BYGBlocks.CRYPTIC_STONE_STAIRS);
    public static final Item CRYPTIC_STONE_WALL = createItem(BYGBlocks.CRYPTIC_STONE_WALL);
    public static final Item CRYPTIC_VENT = createItem(BYGBlocks.CRYPTIC_VENT);
    public static final Item TALL_CRYPTIC_VENT = createItem(BYGBlocks.TALL_CRYPTIC_VENT);
    public static final Item CRYPTIC_BRAMBLE = createItem(BYGBlocks.CRYPTIC_BRAMBLE);
    public static final Item CRYPTIC_BRAMBLE_BRANCH = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "cryptic_bramble_branch");

    //Ice
    public static final Item BLACK_ICE = createItem(BYGBlocks.BLACK_ICE);
    public static final Item PACKED_BLACK_ICE = createItem(BYGBlocks.PACKED_BLACK_ICE);

    //Mushrooms
    public static final Item GREEN_MUSHSHROOM = createItem(BYGBlocks.GREEN_MUSHROOM);
    public static final Item GREEN_MUSHROOM_BLOCK = createItem(BYGBlocks.GREEN_MUSHROOM_BLOCK);
    public static final Item WEEPING_MILKCAP = createItem(BYGBlocks.WEEPING_MILKCAP);
    public static final Item MILKCAP_MUSHROOM_BLOCK = createItem(BYGBlocks.MILKCAP_MUSHROOM_BLOCK);
    public static final Item WOOD_BLEWIT = createItem(BYGBlocks.WOOD_BLEWIT);
    public static final Item BLEWIT_MUSHROOM_BLOCK = createItem(BYGBlocks.BLEWIT_MUSHROOM_BLOCK);
    public static final Item WHITE_PUFFBALL_SPORES = createItem(new ItemNameBlockItem(BYGBlocks.WHITE_PUFFBALL, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "white_puffball_spores");
    public static final Item WHITE_PUFFBALL_CAP = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(1).saturationMod(0.2f).build())), "white_puffball_cap");
    public static final Item COOKED_WHITE_PUFFBALL_CAP = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(3).saturationMod(0.6f).build())), "cooked_white_puffball_cap");
    public static final Item WHITE_PUFFBALL_STEW = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(9).saturationMod(1.0f).build())), "white_puffball_stew");

    public static final Item WHITE_MUSHROOM_STEM = createItem(BYGBlocks.WHITE_MUSHROOM_STEM);
    public static final Item BROWN_MUSHROOM_STEM = createItem(BYGBlocks.BROWN_MUSHROOM_STEM);

    //Plants
    public static final Item SHRUB = createItem(BYGBlocks.SHRUB);
    public static final Item BLUE_BERRY = createItem(new ItemNameBlockItem(BYGBlocks.BLUEBERRY_BUSH, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).build())), "blueberries");
    public static final Item BLUEBERRY_PIE = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).food(new FoodProperties.Builder().nutrition(6).saturationMod(0.3f).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200, 0), 1.0F).build())), "blueberry_pie");

    public static final Item ALOE_VERA_JUICE = createItem(new HoneyBottleItem(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).food(new FoodProperties.Builder().nutrition(3).saturationMod(1.0F).build())), "aloe_vera_juice");
    public static final Item ALOE_VERA = createItem(BYGBlocks.ALOE_VERA);
    public static final Item GOLDEN_SPINED_CACTUS = createItem(BYGBlocks.GOLDEN_SPINED_CACTUS);
    public static final Item HORSEWEED = createItem(BYGBlocks.HORSEWEED);
    public static final Item MINI_CACTUS = createItem(BYGBlocks.MINI_CACTUS);
    public static final Item POISON_IVY = createItem(BYGBlocks.POISON_IVY);
    public static final Item PRICKLY_PEAR_CACTUS = createItem(BYGBlocks.PRICKLY_PEAR_CACTUS);
    public static final Item PRAIRIE_GRASS = createItem(BYGBlocks.PRAIRIE_GRASS);
    public static final Item CATTAIL_SPROUT = createItem(new CattailSproutItem(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), BYGBlocks.CATTAIL_SPROUT);
    public static final Item CATTAIL_THATCH = createItem(BYGBlocks.CATTAIL_THATCH);
    public static final Item CATTAIL_THATCH_STAIRS = createItem(BYGBlocks.CATTAIL_THATCH_STAIRS);
    public static final Item CATTAIL_THATCH_CARPET = createItem(BYGBlocks.CATTAIL_THATCH_CARPET);
    public static final Item CATTAIL_THATCH_SLAB = createItem(BYGBlocks.CATTAIL_THATCH_SLAB);

    public static final Item TALL_PRAIRIE_GRASS = createItem(BYGBlocks.TALL_PRAIRIE_GRASS);
    public static final Item TINY_LILYPADS = createItem(new BYGLilyItem(BYGBlocks.TINY_LILYPADS, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), BYGBlocks.TINY_LILYPADS);
    public static final Item WATER_SILK = createItem(new BYGWaterSilkItem(BYGBlocks.WATER_SILK, (new Item.Properties()).tab(BYGCreativeTab.CREATIVE_TAB)), BYGBlocks.WATER_SILK);
    public static final Item WINTER_SUCCULENT = createItem(BYGBlocks.WINTER_SUCCULENT);

    public static final Item BEACH_GRASS = createItem(BYGBlocks.BEACH_GRASS);
    public static final Item LEAF_PILE = createItem(BYGBlocks.LEAF_PILE);
    public static final Item CLOVER_PATCH = createItem(BYGBlocks.CLOVER_PATCH);
    public static final Item FLOWER_PATCH = createItem(BYGBlocks.FLOWER_PATCH);

    //Petal Blocks
    public static final Item WHITE_PETAL = createItem(BYGBlocks.WHITE_PETAL);
    public static final Item BLUE_PETAL = createItem(BYGBlocks.BLUE_PETAL);
    public static final Item LIGHT_BLUE_PETAL = createItem(BYGBlocks.LIGHT_BLUE_PETAL);
    public static final Item PURPLE_PETAL = createItem(BYGBlocks.PURPLE_PETAL);
    public static final Item RED_PETAL = createItem(BYGBlocks.RED_PETAL);
    public static final Item YELLOW_PETAL = createItem(BYGBlocks.YELLOW_PETAL);
    public static final Item PLANT_STEM = createItem(BYGBlocks.PLANT_STEM);
    public static final Item POLLEN_BLOCK = createItem(BYGBlocks.POLLEN_BLOCK);
    public static final Item POLLEN_DUST = createItem(new Item(new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), "pollen_dust");

    //FlowerItems
    public static final Item ALLIUM_FLOWER_BUSH = createItem(BYGBlocks.ALLIUM_FLOWER_BUSH);
    public static final Item TALL_ALLIUM = createItem(BYGBlocks.TALL_ALLIUM);
    public static final Item ALPINE_BELLFLOWER = createItem(BYGBlocks.ALPINE_BELLFLOWER);
    public static final Item AMARANTH = createItem(BYGBlocks.AMARANTH);
    public static final Item ANGELICA = createItem(BYGBlocks.ANGELICA);
    public static final Item HYDRANGEA_BUSH = createItem(BYGBlocks.HYDRANGEA_BUSH);
    public static final Item HYDRANGEA_HEDGE = createItem(BYGBlocks.HYDRANGEA_HEDGE);
    public static final Item BEGONIA = createItem(BYGBlocks.BEGONIA);
    public static final Item BISTORT = createItem(BYGBlocks.BISTORT);
    public static final Item BLACK_ROSE = createItem(BYGBlocks.BLACK_ROSE);
    public static final Item BLUE_SAGE = createItem(BYGBlocks.BLUE_SAGE);
    public static final Item CALIFORNIA_POPPY = createItem(BYGBlocks.CALIFORNIA_POPPY);
    public static final Item CROCUS = createItem(BYGBlocks.CROCUS);
    public static final Item CYAN_AMARANTH = createItem(BYGBlocks.CYAN_AMARANTH);
    public static final Item CYAN_ROSE = createItem(BYGBlocks.CYAN_ROSE);
    public static final Item CYAN_TULIP = createItem(BYGBlocks.CYAN_TULIP);
    public static final Item DAFFODIL = createItem(BYGBlocks.DAFFODIL);
    public static final Item DELPHINIUM = createItem(BYGBlocks.DELPHINIUM);
    public static final Item FAIRY_SLIPPER = createItem(BYGBlocks.FAIRY_SLIPPER);
    public static final Item FOXGLOVE = createItem(BYGBlocks.FOXGLOVE);
    public static final Item GREEN_TULIP = createItem(BYGBlocks.GREEN_TULIP);
    public static final Item GUZMANIA = createItem(BYGBlocks.GUZMANIA);
    public static final Item INCAN_LILY = createItem(BYGBlocks.INCAN_LILY);
    public static final Item IRIS = createItem(BYGBlocks.IRIS);
    public static final Item JAPANESE_ORCHID = createItem(BYGBlocks.JAPANESE_ORCHID);
    public static final Item KOVAN_FLOWER = createItem(BYGBlocks.KOVAN_FLOWER);
    public static final Item LAZARUS_BELLFLOWER = createItem(BYGBlocks.LAZARUS_BELLFLOWER);
    public static final Item LOLLIPOP_FLOWER = createItem(BYGBlocks.LOLLIPOP_FLOWER);
    public static final Item MAGENTA_AMARANTH = createItem(BYGBlocks.MAGENTA_AMARANTH);
    public static final Item MAGENTA_TULIP = createItem(BYGBlocks.MAGENTA_TULIP);
    public static final Item ORANGE_AMARANTH = createItem(BYGBlocks.ORANGE_AMARANTH);
    public static final Item ORANGE_DAISY = createItem(BYGBlocks.ORANGE_DAISY);
    public static final Item ORSIRIA_ROSE = createItem(BYGBlocks.ORSIRIA_ROSE);
    public static final Item PEACH_LEATHER_FLOWER = createItem(BYGBlocks.PEACH_LEATHER_FLOWER);
    public static final Item PINK_ALLIUM = createItem(BYGBlocks.PINK_ALLIUM);
    public static final Item PINK_ALLIUM_FLOWER_BUSH = createItem(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH);
    public static final Item TALL_PINK_ALLIUM = createItem(BYGBlocks.TALL_PINK_ALLIUM);
    public static final Item PINK_ANEMONE = createItem(BYGBlocks.PINK_ANEMONE);
    public static final Item PINK_DAFFODIL = createItem(BYGBlocks.PINK_DAFFODIL);
    public static final Item PROTEA_FLOWER = createItem(BYGBlocks.PROTEA_FLOWER);
    public static final Item PURPLE_AMARANTH = createItem(BYGBlocks.PURPLE_AMARANTH);
    public static final Item PURPLE_SAGE = createItem(BYGBlocks.PURPLE_SAGE);
    public static final Item PURPLE_TULIP = createItem(BYGBlocks.PURPLE_TULIP);
    public static final Item RICHEA = createItem(BYGBlocks.RICHEA);
    public static final Item ROSE = createItem(BYGBlocks.ROSE);
    public static final Item SILVER_VASE_FLOWER = createItem(BYGBlocks.SILVER_VASE_FLOWER);
    public static final Item SNOWDROPS = createItem(BYGBlocks.SNOWDROPS);
    public static final Item TORCH_GINGER = createItem(BYGBlocks.TORCH_GINGER);
    public static final Item VIOLET_LEATHER_FLOWER = createItem(BYGBlocks.VIOLET_LEATHER_FLOWER);
    public static final Item WHITE_ANEMONE = createItem(BYGBlocks.WHITE_ANEMONE);
    public static final Item WHITE_SAGE = createItem(BYGBlocks.WHITE_SAGE);
    public static final Item WINTER_CYCLAMEN = createItem(BYGBlocks.WINTER_CYCLAMEN);
    public static final Item WINTER_ROSE = createItem(BYGBlocks.WINTER_ROSE);
    public static final Item WINTER_SCILLA = createItem(BYGBlocks.WINTER_SCILLA);
    public static final Item YELLOW_DAFFODIL = createItem(BYGBlocks.YELLOW_DAFFODIL);
    public static final Item YELLOW_TULIP = createItem(BYGBlocks.YELLOW_TULIP);

    public static BlockItem createItem(Block block) {
        return createItem(new BlockItem(block, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), block);
    }

    public static BlockItem createSaplingItem(Block block) {
        return createItem(new BYGSaplingItem(block, new Item.Properties().tab(BYGCreativeTab.CREATIVE_TAB)), block);
    }

    public static <T extends Item> T createItem(T item, Block block) {
        ResourceLocation id = Registry.BLOCK.getKey(block);
        if (id == null || id.equals(new ResourceLocation("minecraft:air"))) {
            boolean recovered = false;
            for (RegistryObject<Block> blockRegistryObject : BYGBlocks.BLOCKS) {
                if (blockRegistryObject.object() == block) {
                    recovered = true;
                    id = BYG.createLocation(blockRegistryObject.id());
                    break;
                }
            }
            if (recovered) {
                BYG.LOGGER.error(String.format("Block \"%s\" was null in the block registry. Using value from BYG's tracked registered blocks...", id.toString()));
            } else {
                throw new IllegalArgumentException("Could not construct item from block using BYG's tracked block list! This should not be possible...");
            }
        }

        return createItem(item, id.getPath());
    }

    public static <T extends Item> T createItem(T item, String id) {
        ITEMS.add(new RegistryObject<>(item, id));
        return item;
    }

    public static Collection<RegistryObject<Item>> bootStrap() {
        return ITEMS;
    }

    public static void init() {
    }

    static {
        BYG.LOGGER.info("BYG Items class loaded.");
    }
}
