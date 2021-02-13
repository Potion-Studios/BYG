package corgiaoc.byg.core;

import corgiaoc.byg.BYG;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import corgiaoc.byg.common.properties.BYGCreativeTab;
import corgiaoc.byg.common.properties.items.*;
import corgiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import corgiaoc.byg.common.properties.items.itemtiers.BYGItemTiers;
import corgiaoc.byg.common.properties.items.itemtiers.BYGWaterSilkItem;
import corgiaoc.byg.common.properties.items.itemtiers.LigniteItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("deprecation")
public class BYGItems {

    public static List<Item> itemsList = new ArrayList<>();

    public static final Item BYG_LOGO = createItem(new Item((new Item.Properties())), "byg_logo");
    public static final Item PEAT = createItem(new BlockItem(BYGBlocks.PEAT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PEAT));
    public static final Item MEADOW_GRASSBLOCK = createItem(new BlockItem(BYGBlocks.MEADOW_GRASSBLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MEADOW_GRASSBLOCK));
    public static final Item MEADOW_GRASS_PATH = createItem(new BlockItem(BYGBlocks.MEADOW_GRASS_PATH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MEADOW_GRASS_PATH));
    public static final Item MEADOW_DIRT = createItem(new BlockItem(BYGBlocks.MEADOW_DIRT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MEADOW_DIRT));
    public static final Item GLOWCELIUM = createItem(new BlockItem(BYGBlocks.GLOWCELIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GLOWCELIUM));
    public static final Item MUD_BALL = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "mud_ball");
    public static final Item MUD_BLOCK = createItem(new BlockItem(BYGBlocks.MUD_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MUD_BLOCK));
    public static final Item MUD_BRICKS = createItem(new BlockItem(BYGBlocks.MUD_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MUD_BRICKS));

    public static final Item CHAIN_PLATING = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "chain_plating");

    public static final Item AMETRINE_GEMS = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "ametrine_gems");
    public static final Item AMETRINE_ORE = createItem(new BlockItem(BYGBlocks.AMETRINE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.AMETRINE_ORE));
    public static final Item AMETRINE_BLOCK = createItem(new BlockItem(BYGBlocks.AMETRINE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.AMETRINE_BLOCK));
    public static final Item AMETRINE_HELMET = createItem(new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.HEAD, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "ametrine_helmet");
    public static final Item AMETRINE_CHEST = createItem(new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.CHEST, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "ametrine_chestplate");
    public static final Item AMETRINE_LEGGINGS = createItem(new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.LEGS, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "ametrine_leggings");
    public static final Item AMETRINE_BOOTS = createItem(new BYGArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlotType.FEET, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "ametrine_boots");
    public static final Item AMETRINE_HORSE_ARMOR = createItem(new BYGHorseArmor(15, "ametrine", (new Item.Properties()).maxStackSize(1).group(BYGCreativeTab.creativeTab)), "ametrine_horse_armor");

    public static final Item PENDORITE_SCRAPS = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "pendorite_scraps");
    public static final Item PENDORITE_ORE = createItem(new BlockItem(BYGBlocks.PENDORITE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PENDORITE_ORE));
    public static final Item PENDORITE_BLOCK = createItem(new BlockItem(BYGBlocks.PENDORITE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PENDORITE_BLOCK));
    public static final Item PENDORITE_AXE = createItem(new AxeItem(BYGItemTiers.PENDORITE, 6.0F, -3.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_axe");
    public static final Item PENDORITE_PICK = createItem(new PickaxeItem(BYGItemTiers.PENDORITE, 2, -2.8F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_pickaxe");
    public static final Item PENDORITE_SWORD = createItem(new SwordItem(BYGItemTiers.PENDORITE, 4, -2.4F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_sword");
    public static final Item PENDORITE_BATTLEAXE = createItem(new AxeItem(BYGItemTiers.PENDORITE, 7.0F, -3.3F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_battleaxe");
    public static final Item PENDORITE_SHOVEL = createItem(new ShovelItem(BYGItemTiers.PENDORITE, 2.0F, -3.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_shovel");
    public static final Item PENDORITE_HOE = createItem(new HoeItem(BYGItemTiers.PENDORITE, 0, 0.0F, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), "pendorite_hoe");

    public static final Item PENDORITE_HORSE_ARMOR = createItem(new BYGHorseArmor(11, "pendorite", (new Item.Properties()).maxStackSize(1).group(BYGCreativeTab.creativeTab)), "pendorite_horse_armor");

    public static final Item DACITE = createItem(new BlockItem(BYGBlocks.DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE));
    public static final Item DACITE_STAIRS = createItem(new BlockItem(BYGBlocks.DACITE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_STAIRS));
    public static final Item DACITE_SLAB = createItem(new BlockItem(BYGBlocks.DACITE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_SLAB));
    public static final Item DACITE_WALL = createItem(new BlockItem(BYGBlocks.DACITE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_WALL));

    public static final Item DACITE_BRICKS = createItem(new BlockItem(BYGBlocks.DACITE_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_BRICKS));
    public static final Item DACITE_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.DACITE_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_BRICK_STAIRS));
    public static final Item DACITE_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.DACITE_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_BRICK_SLAB));
    public static final Item DACITE_BRICK_WALL = createItem(new BlockItem(BYGBlocks.DACITE_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_BRICK_WALL));

    public static final Item DACITE_COBBLESTONE = createItem(new BlockItem(BYGBlocks.DACITE_COBBLESTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_COBBLESTONE));
    public static final Item DACITE_COBBLESTONE_STAIRS = createItem(new BlockItem(BYGBlocks.DACITE_COBBLESTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_COBBLESTONE_STAIRS));
    public static final Item DACITE_COBBLESTONE_SLAB = createItem(new BlockItem(BYGBlocks.DACITE_COBBLESTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_COBBLESTONE_SLAB));
    public static final Item DACITE_COBBLESTONE_WALL = createItem(new BlockItem(BYGBlocks.DACITE_COBBLESTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_COBBLESTONE_WALL));

    public static final Item DACITE_PILLAR = createItem(new BlockItem(BYGBlocks.DACITE_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_PILLAR));
    public static final Item DACITE_TILE = createItem(new BlockItem(BYGBlocks.DACITE_TILE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_TILE));
    public static final Item DACITE_TILE_STAIRS = createItem(new BlockItem(BYGBlocks.DACITE_TILE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_TILE_STAIRS));
    public static final Item DACITE_TILE_SLAB = createItem(new BlockItem(BYGBlocks.DACITE_TILE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_TILE_SLAB));
    public static final Item DACITE_TILE_WALL = createItem(new BlockItem(BYGBlocks.DACITE_TILE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DACITE_TILE_WALL));

    public static final Item MOSSY_STONE = createItem(new BlockItem(BYGBlocks.MOSSY_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_STONE));
    public static final Item MOSSY_STONE_STAIRS = createItem(new BlockItem(BYGBlocks.MOSSY_STONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_STONE_STAIRS));
    public static final Item MOSSY_STONE_SLAB = createItem(new BlockItem(BYGBlocks.MOSSY_STONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_STONE_SLAB));
    public static final Item MOSSY_STONE_WALL = createItem(new BlockItem(BYGBlocks.MOSSY_STONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_STONE_WALL));

    public static final Item PODZOL_DACITE = createItem(new BlockItem(BYGBlocks.PODZOL_DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PODZOL_DACITE));
    public static final Item OVERGROWN_DACITE = createItem(new BlockItem(BYGBlocks.OVERGROWN_DACITE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.OVERGROWN_DACITE));
    public static final Item OVERGROWN_STONE = createItem(new BlockItem(BYGBlocks.OVERGROWN_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.OVERGROWN_STONE));

    public static final Item RED_ROCK = createItem(new BlockItem(BYGBlocks.RED_ROCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK));
    public static final Item RED_ROCK_STAIRS = createItem(new BlockItem(BYGBlocks.RED_ROCK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_STAIRS));
    public static final Item RED_ROCK_SLAB = createItem(new BlockItem(BYGBlocks.RED_ROCK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_SLAB));
    public static final Item RED_ROCK_WALL = createItem(new BlockItem(BYGBlocks.RED_ROCK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_WALL));

    public static final Item RED_ROCK_BRICKS = createItem(new BlockItem(BYGBlocks.RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_BRICKS));
    public static final Item RED_ROCK_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_BRICK_STAIRS));
    public static final Item RED_ROCK_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_BRICK_SLAB));
    public static final Item RED_ROCK_BRICK_WALL = createItem(new BlockItem(BYGBlocks.RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ROCK_BRICK_WALL));

    public static final Item MOSSY_RED_ROCK_BRICKS = createItem(new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_RED_ROCK_BRICKS));
    public static final Item MOSSY_RED_ROCK_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_RED_ROCK_BRICK_STAIRS));
    public static final Item MOSSY_RED_ROCK_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_RED_ROCK_BRICK_SLAB));
    public static final Item MOSSY_RED_ROCK_BRICK_WALL = createItem(new BlockItem(BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_RED_ROCK_BRICK_WALL));

    public static final Item CHISELED_RED_ROCK_BRICKS = createItem(new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_RED_ROCK_BRICKS));
    public static final Item CHISELED_RED_ROCK_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_RED_ROCK_BRICK_STAIRS));
    public static final Item CHISELED_RED_ROCK_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_RED_ROCK_BRICK_SLAB));
    public static final Item CHISELED_RED_ROCK_BRICK_WALL = createItem(new BlockItem(BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_RED_ROCK_BRICK_WALL));

    public static final Item CRACKED_RED_ROCK_BRICKS = createItem(new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRACKED_RED_ROCK_BRICKS));
    public static final Item CRACKED_RED_ROCK_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRACKED_RED_ROCK_BRICK_STAIRS));
    public static final Item CRACKED_RED_ROCK_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRACKED_RED_ROCK_BRICK_SLAB));
    public static final Item CRACKED_RED_ROCK_BRICK_WALL = createItem(new BlockItem(BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRACKED_RED_ROCK_BRICK_WALL));


    public static final Item ROCKY_STONE = createItem(new BlockItem(BYGBlocks.ROCKY_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ROCKY_STONE));
    public static final Item ROCKY_STAIRS = createItem(new BlockItem(BYGBlocks.ROCKY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ROCKY_STAIRS));
    public static final Item ROCKY_SLAB = createItem(new BlockItem(BYGBlocks.ROCKY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ROCKY_SLAB));
    public static final Item ROCKY_WALL = createItem(new BlockItem(BYGBlocks.ROCKY_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ROCKY_WALL));

    public static final Item SCORIA_STONE = createItem(new BlockItem(BYGBlocks.SCORIA_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STONE));
    public static final Item SCORIA_STAIRS = createItem(new BlockItem(BYGBlocks.SCORIA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STAIRS));
    public static final Item SCORIA_SLAB = createItem(new BlockItem(BYGBlocks.SCORIA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_SLAB));
    public static final Item SCORIA_WALL = createItem(new BlockItem(BYGBlocks.SCORIA_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_WALL));

    public static final Item SCORIA_COBBLESTONE = createItem(new BlockItem(BYGBlocks.SCORIA_COBBLESTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_COBBLESTONE));
    public static final Item SCORIA_COBBLESTONE_STAIRS = createItem(new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_COBBLESTONE_STAIRS));
    public static final Item SCORIA_COBBLESTONE_SLAB = createItem(new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_COBBLESTONE_SLAB));
    public static final Item SCORIA_COBBLESTONE_WALL = createItem(new BlockItem(BYGBlocks.SCORIA_COBBLESTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_COBBLESTONE_WALL));

    public static final Item SCORIA_PILLAR = createItem(new BlockItem(BYGBlocks.SCORIA_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_PILLAR));
    public static final Item SCORIA_STONEBRICKS = createItem(new BlockItem(BYGBlocks.SCORIA_STONEBRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STONEBRICKS));
    public static final Item SCORIA_STONEBRICK_STAIRS = createItem(new BlockItem(BYGBlocks.SCORIA_STONEBRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STONEBRICK_STAIRS));
    public static final Item SCORIA_STONEBRICK_SLAB = createItem(new BlockItem(BYGBlocks.SCORIA_STONEBRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STONEBRICK_SLAB));
    public static final Item SCORIA_STONEBRICK_WALL = createItem(new BlockItem(BYGBlocks.SCORIA_STONEBRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORIA_STONEBRICK_WALL));

    public static final Item SOAPSTONE = createItem(new BlockItem(BYGBlocks.SOAPSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE));
    public static final Item SOAPSTONE_STAIRS = createItem(new BlockItem(BYGBlocks.SOAPSTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_STAIRS));
    public static final Item SOAPSTONE_SLAB = createItem(new BlockItem(BYGBlocks.SOAPSTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_SLAB));
    public static final Item SOAPSTONE_WALL = createItem(new BlockItem(BYGBlocks.SOAPSTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_WALL));

    public static final Item POLISHED_SOAPSTONE = createItem(new BlockItem(BYGBlocks.POLISHED_SOAPSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POLISHED_SOAPSTONE));
    public static final Item POLISHED_SOAPSTONE_STAIRS = createItem(new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POLISHED_SOAPSTONE_STAIRS));
    public static final Item POLISHED_SOAPSTONE_SLAB = createItem(new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POLISHED_SOAPSTONE_SLAB));
    public static final Item POLISHED_SOAPSTONE_WALL = createItem(new BlockItem(BYGBlocks.POLISHED_SOAPSTONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POLISHED_SOAPSTONE_WALL));

    public static final Item SOAPSTONE_BRICKS = createItem(new BlockItem(BYGBlocks.SOAPSTONE_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_BRICKS));
    public static final Item SOAPSTONE_BRICK_STAIRS = createItem(new BlockItem(BYGBlocks.SOAPSTONE_BRICK_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_BRICK_STAIRS));
    public static final Item SOAPSTONE_BRICK_SLAB = createItem(new BlockItem(BYGBlocks.SOAPSTONE_BRICK_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_BRICK_SLAB));
    public static final Item SOAPSTONE_BRICK_WALL = createItem(new BlockItem(BYGBlocks.SOAPSTONE_BRICK_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_BRICK_WALL));

    public static final Item SOAPSTONE_PILLAR = createItem(new BlockItem(BYGBlocks.SOAPSTONE_PILLAR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_PILLAR));
    public static final Item SOAPSTONE_TILE = createItem(new BlockItem(BYGBlocks.SOAPSTONE_TILE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_TILE));
    public static final Item SOAPSTONE_TILE_STAIRS = createItem(new BlockItem(BYGBlocks.SOAPSTONE_TILE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_TILE_STAIRS));
    public static final Item SOAPSTONE_TILE_SLAB = createItem(new BlockItem(BYGBlocks.SOAPSTONE_TILE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_TILE_SLAB));
    public static final Item SOAPSTONE_TILE_WALL = createItem(new BlockItem(BYGBlocks.SOAPSTONE_TILE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOAPSTONE_TILE_WALL));

    public static final Item BLACK_SAND = createItem(new BlockItem(BYGBlocks.BLACK_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_SAND));
    public static final Item BLACK_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLACK_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_SANDSTONE));
    public static final Item BLACK_CHISELED_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLACK_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_CHISELED_SANDSTONE));
    public static final Item BLACK_CUT_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLACK_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_CUT_SANDSTONE));
    public static final Item BLACK_SMOOTH_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLACK_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_SMOOTH_SANDSTONE));

    public static final Item WHITE_SAND = createItem(new BlockItem(BYGBlocks.WHITE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_SAND));
    public static final Item WHITE_SANDSTONE = createItem(new BlockItem(BYGBlocks.WHITE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_SANDSTONE));
    public static final Item WHITE_CHISELED_SANDSTONE = createItem(new BlockItem(BYGBlocks.WHITE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_CHISELED_SANDSTONE));
    public static final Item WHITE_CUT_SANDSTONE = createItem(new BlockItem(BYGBlocks.WHITE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_CUT_SANDSTONE));
    public static final Item WHITE_SMOOTH_SANDSTONE = createItem(new BlockItem(BYGBlocks.WHITE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_SMOOTH_SANDSTONE));

    public static final Item BLUE_SAND = createItem(new BlockItem(BYGBlocks.BLUE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SAND));
    public static final Item BLUE_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLUE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SANDSTONE));
    public static final Item BLUE_CHISELED_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLUE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_CHISELED_SANDSTONE));
    public static final Item BLUE_CUT_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLUE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_CUT_SANDSTONE));
    public static final Item BLUE_SMOOTH_SANDSTONE = createItem(new BlockItem(BYGBlocks.BLUE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SMOOTH_SANDSTONE));

    public static final Item PURPLE_SAND = createItem(new BlockItem(BYGBlocks.PURPLE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_SAND));
    public static final Item PURPLE_SANDSTONE = createItem(new BlockItem(BYGBlocks.PURPLE_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_SANDSTONE));
    public static final Item PURPLE_CHISELED_SANDSTONE = createItem(new BlockItem(BYGBlocks.PURPLE_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_CHISELED_SANDSTONE));
    public static final Item PURPLE_CUT_SANDSTONE = createItem(new BlockItem(BYGBlocks.PURPLE_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_CUT_SANDSTONE));
    public static final Item PURPLE_SMOOTH_SANDSTONE = createItem(new BlockItem(BYGBlocks.PURPLE_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_SMOOTH_SANDSTONE));

    public static final Item PINK_SAND = createItem(new BlockItem(BYGBlocks.PINK_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_SAND));
    public static final Item PINK_SANDSTONE = createItem(new BlockItem(BYGBlocks.PINK_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_SANDSTONE));
    public static final Item PINK_CHISELED_SANDSTONE = createItem(new BlockItem(BYGBlocks.PINK_CHISELED_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_CHISELED_SANDSTONE));
    public static final Item PINK_CUT_SANDSTONE = createItem(new BlockItem(BYGBlocks.PINK_CUT_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_CUT_SANDSTONE));
    public static final Item PINK_SMOOTH_SANDSTONE = createItem(new BlockItem(BYGBlocks.PINK_SMOOTH_SANDSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_SMOOTH_SANDSTONE));

    //Aspen Woodtype
    public static final Item ASPEN_SAPLING = createItem(new BlockItem(BYGBlocks.ASPEN_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_SAPLING));
    public static final Item ASPEN_LEAVES = createItem(new BlockItem(BYGBlocks.ASPEN_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_LEAVES));
    public static final Item ASPEN_LOG = createItem(new BlockItem(BYGBlocks.ASPEN_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_LOG));
    public static final Item ASPEN_WOOD = createItem(new BlockItem(BYGBlocks.ASPEN_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_WOOD));
    public static final Item STRIPPED_ASPEN_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_ASPEN_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ASPEN_LOG));
    public static final Item STRIPPED_ASPEN_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_ASPEN_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ASPEN_WOOD));
    public static final Item ASPEN_PLANKS = createItem(new BlockItem(BYGBlocks.ASPEN_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_PLANKS));
    public static final Item ASPEN_BOOKSHELF = createItem(new BlockItem(BYGBlocks.ASPEN_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_BOOKSHELF));
    public static final Item ASPEN_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.ASPEN_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_CRAFTING_TABLE));
    public static final Item ASPEN_STAIRS = createItem(new BlockItem(BYGBlocks.ASPEN_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_STAIRS));
    public static final Item ASPEN_SLAB = createItem(new BlockItem(BYGBlocks.ASPEN_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_SLAB));
    public static final Item ASPEN_FENCE = createItem(new BlockItem(BYGBlocks.ASPEN_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_FENCE));
    public static final Item ASPEN_FENCE_GATE = createItem(new BlockItem(BYGBlocks.ASPEN_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_FENCE_GATE));
    public static final Item ASPEN_DOOR = createItem(new TallBlockItem(BYGBlocks.ASPEN_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_DOOR));
    public static final Item ASPEN_TRAPDOOR = createItem(new BlockItem(BYGBlocks.ASPEN_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_TRAPDOOR));
    public static final Item ASPEN_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.ASPEN_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_PRESSURE_PLATE));
    public static final Item ASPEN_BUTTON = createItem(new BlockItem(BYGBlocks.ASPEN_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ASPEN_BUTTON));
    public static final Item ASPEN_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.ASPEN, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "aspen_boat");

    //Baobab Woodtype
    public static final Item BAOBAB_FRUIT = createItem(new BaobabFruitItem(BYGBlocks.BAOBAB_FRUIT_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(3).saturation(0.5f).setAlwaysEdible().build())), "baobab_fruit");
    public static final Item BAOBAB_SAPLING = createItem(new BlockItem(BYGBlocks.BAOBAB_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_SAPLING));
    public static final Item BAOBAB_LEAVES = createItem(new BlockItem(BYGBlocks.BAOBAB_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_LEAVES));
    public static final Item BAOBAB_LOG = createItem(new BlockItem(BYGBlocks.BAOBAB_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_LOG));
    public static final Item BAOBAB_WOOD = createItem(new BlockItem(BYGBlocks.BAOBAB_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_WOOD));
    public static final Item STRIPPED_BAOBAB_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_BAOBAB_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BAOBAB_LOG));
    public static final Item STRIPPED_BAOBAB_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_BAOBAB_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BAOBAB_WOOD));
    public static final Item BAOBAB_PLANKS = createItem(new BlockItem(BYGBlocks.BAOBAB_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_PLANKS));
    public static final Item BAOBAB_BOOKSHELF = createItem(new BlockItem(BYGBlocks.BAOBAB_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_BOOKSHELF));
    public static final Item BAOBAB_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.BAOBAB_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_CRAFTING_TABLE));
    public static final Item BAOBAB_STAIRS = createItem(new BlockItem(BYGBlocks.BAOBAB_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_STAIRS));
    public static final Item BAOBAB_SLAB = createItem(new BlockItem(BYGBlocks.BAOBAB_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_SLAB));
    public static final Item BAOBAB_FENCE = createItem(new BlockItem(BYGBlocks.BAOBAB_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_FENCE));
    public static final Item BAOBAB_FENCE_GATE = createItem(new BlockItem(BYGBlocks.BAOBAB_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_FENCE_GATE));
    public static final Item BAOBAB_DOOR = createItem(new TallBlockItem(BYGBlocks.BAOBAB_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_DOOR));
    public static final Item BAOBAB_TRAPDOOR = createItem(new BlockItem(BYGBlocks.BAOBAB_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_TRAPDOOR));
    public static final Item BAOBAB_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.BAOBAB_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_PRESSURE_PLATE));
    public static final Item BAOBAB_BUTTON = createItem(new BlockItem(BYGBlocks.BAOBAB_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BAOBAB_BUTTON));
    public static final Item BAOBAB_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.BAOBAB, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "baobab_boat");

    //Blue Enchanted Woodtype
    public static final Item BLUE_ENCHANTED_SAPLING = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_SAPLING));
    public static final Item BLUE_ENCHANTED_LEAVES = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_LEAVES));
    public static final Item BLUE_ENCHANTED_LOG = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_LOG));
    public static final Item BLUE_ENCHANTED_WOOD = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_WOOD));
    public static final Item STRIPPED_BLUE_ENCHANTED_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BLUE_ENCHANTED_LOG));
    public static final Item STRIPPED_BLUE_ENCHANTED_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BLUE_ENCHANTED_WOOD));
    public static final Item BLUE_ENCHANTED_PLANKS = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_PLANKS));
    public static final Item BLUE_ENCHANTED_BOOKSHELF = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_BOOKSHELF));
    public static final Item BLUE_ENCHANTED_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_CRAFTING_TABLE));
    public static final Item BLUE_ENCHANTED_STAIRS = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_STAIRS));
    public static final Item BLUE_ENCHANTED_SLAB = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_SLAB));
    public static final Item BLUE_ENCHANTED_FENCE = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_FENCE));
    public static final Item BLUE_ENCHANTED_FENCE_GATE = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_FENCE_GATE));
    public static final Item BLUE_ENCHANTED_DOOR = createItem(new TallBlockItem(BYGBlocks.BLUE_ENCHANTED_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_DOOR));
    public static final Item BLUE_ENCHANTED_TRAPDOOR = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_TRAPDOOR));
    public static final Item BLUE_ENCHANTED_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_PRESSURE_PLATE));
    public static final Item BLUE_ENCHANTED_BUTTON = createItem(new BlockItem(BYGBlocks.BLUE_ENCHANTED_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_ENCHANTED_BUTTON));
    public static final Item BLUE_ENCHANTED_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.BLUE_ENCHANTED, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "blue_enchanted_boat");

    //Bulbis Woodtype
    public static final Item PURPLE_BULBIS_ODDITY = createItem(new BlockItem(BYGBlocks.PURPLE_BULBIS_ODDITY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_BULBIS_ODDITY));
    public static final Item PURPLE_BULBIS_ANOMALY = createItem(new BlockItem(BYGBlocks.PURPLE_BULBIS_ANOMALY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_BULBIS_ANOMALY));
    public static final Item PURPLE_BULBIS_SHELL = createItem(new BlockItem(BYGBlocks.PURPLE_BULBIS_SHELL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_BULBIS_SHELL));
    public static final Item BULBIS_ODDITY = createItem(new BlockItem(BYGBlocks.BULBIS_ODDITY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_ODDITY));
    public static final Item BULBIS_ANOMALY = createItem(new BlockItem(BYGBlocks.BULBIS_ANOMALY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_ANOMALY));
    public static final Item BULBIS_SHELL = createItem(new BlockItem(BYGBlocks.BULBIS_SHELL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_SHELL));
    public static final Item BULBIS_STEM = createItem(new BlockItem(BYGBlocks.BULBIS_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_STEM));
    public static final Item BULBIS_WOOD = createItem(new BlockItem(BYGBlocks.BULBIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_WOOD));
    public static final Item STRIPPED_BULBIS_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_BULBIS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BULBIS_LOG));
    public static final Item STRIPPED_BULBIS_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_BULBIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_BULBIS_WOOD));
    public static final Item BULBIS_PLANKS = createItem(new BlockItem(BYGBlocks.BULBIS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_PLANKS));
    public static final Item BULBIS_BOOKSHELF = createItem(new BlockItem(BYGBlocks.BULBIS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_BOOKSHELF));
    public static final Item BULBIS_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.BULBIS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_CRAFTING_TABLE));
    public static final Item BULBIS_STAIRS = createItem(new BlockItem(BYGBlocks.BULBIS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_STAIRS));
    public static final Item BULBIS_SLAB = createItem(new BlockItem(BYGBlocks.BULBIS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_SLAB));
    public static final Item BULBIS_FENCE = createItem(new BlockItem(BYGBlocks.BULBIS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_FENCE));
    public static final Item BULBIS_FENCE_GATE = createItem(new BlockItem(BYGBlocks.BULBIS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_FENCE_GATE));
    public static final Item BULBIS_DOOR = createItem(new TallBlockItem(BYGBlocks.BULBIS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_DOOR));
    public static final Item BULBIS_TRAPDOOR = createItem(new BlockItem(BYGBlocks.BULBIS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_TRAPDOOR));
    public static final Item BULBIS_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.BULBIS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_PRESSURE_PLATE));
    public static final Item BULBIS_BUTTON = createItem(new BlockItem(BYGBlocks.BULBIS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_BUTTON));


    //Cherry Woodtype
    public static final Item PINK_CHERRY_SAPLING = createItem(new BlockItem(BYGBlocks.PINK_CHERRY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_CHERRY_SAPLING));
    public static final Item PINK_CHERRY_FOLIAGE = createItem(new BlockItem(BYGBlocks.PINK_CHERRY_FOLIAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_CHERRY_FOLIAGE));
    public static final Item PINK_CHERRY_LEAVES = createItem(new BlockItem(BYGBlocks.PINK_CHERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_CHERRY_LEAVES));
    public static final Item WHITE_CHERRY_SAPLING = createItem(new BlockItem(BYGBlocks.WHITE_CHERRY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_CHERRY_SAPLING));
    public static final Item WHITE_CHERRY_FOLIAGE = createItem(new BlockItem(BYGBlocks.WHITE_CHERRY_FOLIAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_CHERRY_FOLIAGE));
    public static final Item WHITE_CHERRY_LEAVES = createItem(new BlockItem(BYGBlocks.WHITE_CHERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_CHERRY_LEAVES));
    public static final Item CHERRY_LOG = createItem(new BlockItem(BYGBlocks.CHERRY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_LOG));
    public static final Item CHERRY_WOOD = createItem(new BlockItem(BYGBlocks.CHERRY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_WOOD));
    public static final Item STRIPPED_CHERRY_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_CHERRY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CHERRY_LOG));
    public static final Item STRIPPED_CHERRY_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_CHERRY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CHERRY_WOOD));
    public static final Item CHERRY_PLANKS = createItem(new BlockItem(BYGBlocks.CHERRY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_PLANKS));
    public static final Item CHERRY_BOOKSHELF = createItem(new BlockItem(BYGBlocks.CHERRY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_BOOKSHELF));
    public static final Item CHERRY_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.CHERRY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_CRAFTING_TABLE));
    public static final Item CHERRY_STAIRS = createItem(new BlockItem(BYGBlocks.CHERRY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_STAIRS));
    public static final Item CHERRY_SLAB = createItem(new BlockItem(BYGBlocks.CHERRY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_SLAB));
    public static final Item CHERRY_FENCE = createItem(new BlockItem(BYGBlocks.CHERRY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_FENCE));
    public static final Item CHERRY_FENCE_GATE = createItem(new BlockItem(BYGBlocks.CHERRY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_FENCE_GATE));
    public static final Item CHERRY_DOOR = createItem(new TallBlockItem(BYGBlocks.CHERRY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_DOOR));
    public static final Item CHERRY_TRAPDOOR = createItem(new BlockItem(BYGBlocks.CHERRY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_TRAPDOOR));
    public static final Item CHERRY_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.CHERRY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_PRESSURE_PLATE));
    public static final Item CHERRY_BUTTON = createItem(new BlockItem(BYGBlocks.CHERRY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHERRY_BUTTON));
    public static final Item CHERRY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CHERRY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "cherry_boat");

    //Cika Woodtype
    public static final Item CIKA_SAPLING = createItem(new BlockItem(BYGBlocks.CIKA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_SAPLING));
    public static final Item CIKA_LEAVES = createItem(new BlockItem(BYGBlocks.CIKA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_LEAVES));
    public static final Item CIKA_LOG = createItem(new BlockItem(BYGBlocks.CIKA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_LOG));
    public static final Item CIKA_WOOD = createItem(new BlockItem(BYGBlocks.CIKA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_WOOD));
    public static final Item STRIPPED_CIKA_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_CIKA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CIKA_LOG));
    public static final Item STRIPPED_CIKA_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_CIKA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CIKA_WOOD));
    public static final Item CIKA_PLANKS = createItem(new BlockItem(BYGBlocks.CIKA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_PLANKS));
    public static final Item CIKA_BOOKSHELF = createItem(new BlockItem(BYGBlocks.CIKA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_BOOKSHELF));
    public static final Item CIKA_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.CIKA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_CRAFTING_TABLE));
    public static final Item CIKA_STAIRS = createItem(new BlockItem(BYGBlocks.CIKA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_STAIRS));
    public static final Item CIKA_SLAB = createItem(new BlockItem(BYGBlocks.CIKA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_SLAB));
    public static final Item CIKA_FENCE = createItem(new BlockItem(BYGBlocks.CIKA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_FENCE));
    public static final Item CIKA_FENCE_GATE = createItem(new BlockItem(BYGBlocks.CIKA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_FENCE_GATE));
    public static final Item CIKA_DOOR = createItem(new TallBlockItem(BYGBlocks.CIKA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_DOOR));
    public static final Item CIKA_TRAPDOOR = createItem(new BlockItem(BYGBlocks.CIKA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_TRAPDOOR));
    public static final Item CIKA_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.CIKA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_PRESSURE_PLATE));
    public static final Item CIKA_BUTTON = createItem(new BlockItem(BYGBlocks.CIKA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CIKA_BUTTON));
    public static final Item CIKA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CIKA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "cika_boat");

    //Cypress Woodtype
    public static final Item CYPRESS_SAPLING = createItem(new BlockItem(BYGBlocks.CYPRESS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_SAPLING));
    public static final Item CYPRESS_LEAVES = createItem(new BlockItem(BYGBlocks.CYPRESS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_LEAVES));
    public static final Item CYPRESS_LOG = createItem(new BlockItem(BYGBlocks.CYPRESS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_LOG));
    public static final Item CYPRESS_WOOD = createItem(new BlockItem(BYGBlocks.CYPRESS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_WOOD));
    public static final Item STRIPPED_CYPRESS_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_CYPRESS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CYPRESS_LOG));
    public static final Item STRIPPED_CYPRESS_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_CYPRESS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_CYPRESS_WOOD));
    public static final Item CYPRESS_PLANKS = createItem(new BlockItem(BYGBlocks.CYPRESS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_PLANKS));
    public static final Item CYPRESS_BOOKSHELF = createItem(new BlockItem(BYGBlocks.CYPRESS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_BOOKSHELF));
    public static final Item CYPRESS_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.CYPRESS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_CRAFTING_TABLE));
    public static final Item CYPRESS_STAIRS = createItem(new BlockItem(BYGBlocks.CYPRESS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_STAIRS));
    public static final Item CYPRESS_SLAB = createItem(new BlockItem(BYGBlocks.CYPRESS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_SLAB));
    public static final Item CYPRESS_FENCE = createItem(new BlockItem(BYGBlocks.CYPRESS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_FENCE));
    public static final Item CYPRESS_FENCE_GATE = createItem(new BlockItem(BYGBlocks.CYPRESS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_FENCE_GATE));
    public static final Item CYPRESS_DOOR = createItem(new TallBlockItem(BYGBlocks.CYPRESS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_DOOR));
    public static final Item CYPRESS_TRAPDOOR = createItem(new BlockItem(BYGBlocks.CYPRESS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_TRAPDOOR));
    public static final Item CYPRESS_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.CYPRESS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_PRESSURE_PLATE));
    public static final Item CYPRESS_BUTTON = createItem(new BlockItem(BYGBlocks.CYPRESS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYPRESS_BUTTON));
    public static final Item CYPRESS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.CYPRESS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "cypress_boat");

    //Ebony Woodtype
    public static final Item EBONY_SAPLING = createItem(new BlockItem(BYGBlocks.EBONY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_SAPLING));
    public static final Item EBONY_LEAVES = createItem(new BlockItem(BYGBlocks.EBONY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_LEAVES));
    public static final Item EBONY_LOG = createItem(new BlockItem(BYGBlocks.EBONY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_LOG));
    public static final Item EBONY_WOOD = createItem(new BlockItem(BYGBlocks.EBONY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_WOOD));
    public static final Item STRIPPED_EBONY_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_EBONY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_EBONY_LOG));
    public static final Item STRIPPED_EBONY_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_EBONY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_EBONY_WOOD));
    public static final Item EBONY_PLANKS = createItem(new BlockItem(BYGBlocks.EBONY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_PLANKS));
    public static final Item EBONY_BOOKSHELF = createItem(new BlockItem(BYGBlocks.EBONY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_BOOKSHELF));
    public static final Item EBONY_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.EBONY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_CRAFTING_TABLE));
    public static final Item EBONY_STAIRS = createItem(new BlockItem(BYGBlocks.EBONY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_STAIRS));
    public static final Item EBONY_SLAB = createItem(new BlockItem(BYGBlocks.EBONY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_SLAB));
    public static final Item EBONY_FENCE = createItem(new BlockItem(BYGBlocks.EBONY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_FENCE));
    public static final Item EBONY_FENCE_GATE = createItem(new BlockItem(BYGBlocks.EBONY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_FENCE_GATE));
    public static final Item EBONY_DOOR = createItem(new TallBlockItem(BYGBlocks.EBONY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_DOOR));
    public static final Item EBONY_TRAPDOOR = createItem(new BlockItem(BYGBlocks.EBONY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_TRAPDOOR));
    public static final Item EBONY_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.EBONY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_PRESSURE_PLATE));
    public static final Item EBONY_BUTTON = createItem(new BlockItem(BYGBlocks.EBONY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EBONY_BUTTON));
    public static final Item EBONY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.EBONY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "ebony_boat");

    //Ether Woodtype
    public static final Item ETHER_BULBS = createItem(new BlockItem(BYGBlocks.ETHER_BULB, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().saturation(5.0f).effect(new EffectInstance(Effects.GLOWING, 200, 0), 1.0F).setAlwaysEdible().build())), "ether_bulbs");

    public static final Item ETHER_SAPLING = createItem(new BlockItem(BYGBlocks.ETHER_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_SAPLING));
    public static final Item ETHER_LEAVES = createItem(new BlockItem(BYGBlocks.ETHER_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_LEAVES));
    public static final Item ETHER_LOG = createItem(new BlockItem(BYGBlocks.ETHER_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_LOG));
    public static final Item ETHER_WOOD = createItem(new BlockItem(BYGBlocks.ETHER_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_WOOD));
    public static final Item STRIPPED_ETHER_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_ETHER_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ETHER_LOG));
    public static final Item STRIPPED_ETHER_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_ETHER_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ETHER_WOOD));
    public static final Item ETHER_PLANKS = createItem(new BlockItem(BYGBlocks.ETHER_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_PLANKS));
    public static final Item ETHER_BOOKSHELF = createItem(new BlockItem(BYGBlocks.ETHER_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_BOOKSHELF));
    public static final Item ETHER_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.ETHER_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_CRAFTING_TABLE));
    public static final Item ETHER_STAIRS = createItem(new BlockItem(BYGBlocks.ETHER_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_STAIRS));
    public static final Item ETHER_SLAB = createItem(new BlockItem(BYGBlocks.ETHER_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_SLAB));
    public static final Item ETHER_FENCE = createItem(new BlockItem(BYGBlocks.ETHER_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_FENCE));
    public static final Item ETHER_FENCE_GATE = createItem(new BlockItem(BYGBlocks.ETHER_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_FENCE_GATE));
    public static final Item ETHER_DOOR = createItem(new TallBlockItem(BYGBlocks.ETHER_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_DOOR));
    public static final Item ETHER_TRAPDOOR = createItem(new BlockItem(BYGBlocks.ETHER_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_TRAPDOOR));
    public static final Item ETHER_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.ETHER_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_PRESSURE_PLATE));
    public static final Item ETHER_BUTTON = createItem(new BlockItem(BYGBlocks.ETHER_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_BUTTON));

    //Fir Woodtype
    public static final Item FIR_SAPLING = createItem(new BlockItem(BYGBlocks.FIR_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_SAPLING));
    public static final Item FIR_LEAVES = createItem(new BlockItem(BYGBlocks.FIR_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_LEAVES));
    public static final Item FIR_LOG = createItem(new BlockItem(BYGBlocks.FIR_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_LOG));
    public static final Item FIR_WOOD = createItem(new BlockItem(BYGBlocks.FIR_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_WOOD));
    public static final Item STRIPPED_FIR_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_FIR_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_FIR_LOG));
    public static final Item STRIPPED_FIR_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_FIR_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_FIR_WOOD));
    public static final Item FIR_PLANKS = createItem(new BlockItem(BYGBlocks.FIR_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_PLANKS));
    public static final Item FIR_BOOKSHELF = createItem(new BlockItem(BYGBlocks.FIR_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_BOOKSHELF));
    public static final Item FIR_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.FIR_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_CRAFTING_TABLE));
    public static final Item FIR_STAIRS = createItem(new BlockItem(BYGBlocks.FIR_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_STAIRS));
    public static final Item FIR_SLAB = createItem(new BlockItem(BYGBlocks.FIR_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_SLAB));
    public static final Item FIR_FENCE = createItem(new BlockItem(BYGBlocks.FIR_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_FENCE));
    public static final Item FIR_FENCE_GATE = createItem(new BlockItem(BYGBlocks.FIR_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_FENCE_GATE));
    public static final Item FIR_DOOR = createItem(new TallBlockItem(BYGBlocks.FIR_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_DOOR));
    public static final Item FIR_TRAPDOOR = createItem(new BlockItem(BYGBlocks.FIR_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_TRAPDOOR));
    public static final Item FIR_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.FIR_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_PRESSURE_PLATE));
    public static final Item FIR_BUTTON = createItem(new BlockItem(BYGBlocks.FIR_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIR_BUTTON));
    public static final Item FIR_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.FIR, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "fir_boat");

    //Green Enchanted Woodtype
    public static final Item GREEN_ENCHANTED_SAPLING = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_SAPLING));
    public static final Item GREEN_ENCHANTED_LEAVES = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_LEAVES));
    public static final Item GREEN_ENCHANTED_LOG = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_LOG));
    public static final Item GREEN_ENCHANTED_WOOD = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_WOOD));
    public static final Item STRIPPED_GREEN_ENCHANTED_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_GREEN_ENCHANTED_LOG));
    public static final Item STRIPPED_GREEN_ENCHANTED_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_GREEN_ENCHANTED_WOOD));
    public static final Item GREEN_ENCHANTED_PLANKS = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_PLANKS));
    public static final Item GREEN_ENCHANTED_BOOKSHELF = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_BOOKSHELF));
    public static final Item GREEN_ENCHANTED_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_CRAFTING_TABLE));
    public static final Item GREEN_ENCHANTED_STAIRS = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_STAIRS));
    public static final Item GREEN_ENCHANTED_SLAB = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_SLAB));
    public static final Item GREEN_ENCHANTED_FENCE = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_FENCE));
    public static final Item GREEN_ENCHANTED_FENCE_GATE = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_FENCE_GATE));
    public static final Item GREEN_ENCHANTED_DOOR = createItem(new TallBlockItem(BYGBlocks.GREEN_ENCHANTED_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_DOOR));
    public static final Item GREEN_ENCHANTED_TRAPDOOR = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_TRAPDOOR));
    public static final Item GREEN_ENCHANTED_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_PRESSURE_PLATE));
    public static final Item GREEN_ENCHANTED_BUTTON = createItem(new BlockItem(BYGBlocks.GREEN_ENCHANTED_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_ENCHANTED_BUTTON));
    public static final Item GREEN_ENCHANTED_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.GREEN_ENCHANTED, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "green_enchanted_boat");

    //Holly Woodtype
    public static final Item HOLLY_BERRY_LEAVES = createItem(new BlockItem(BYGBlocks.HOLLY_BERRY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_BERRY_LEAVES));
    public static final Item HOLLY_BERRY = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.1f).effect(new EffectInstance(Effects.POISON, 200, 0), 1.0F).build())), "holly_berries");
    public static final Item HOLLY_SAPLING = createItem(new BlockItem(BYGBlocks.HOLLY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_SAPLING));
    public static final Item HOLLY_LEAVES = createItem(new BlockItem(BYGBlocks.HOLLY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_LEAVES));
    public static final Item HOLLY_LOG = createItem(new BlockItem(BYGBlocks.HOLLY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_LOG));
    public static final Item HOLLY_WOOD = createItem(new BlockItem(BYGBlocks.HOLLY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_WOOD));
    public static final Item STRIPPED_HOLLY_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_HOLLY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_HOLLY_LOG));
    public static final Item STRIPPED_HOLLY_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_HOLLY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_HOLLY_WOOD));
    public static final Item HOLLY_PLANKS = createItem(new BlockItem(BYGBlocks.HOLLY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_PLANKS));
    public static final Item HOLLY_BOOKSHELF = createItem(new BlockItem(BYGBlocks.HOLLY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_BOOKSHELF));
    public static final Item HOLLY_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.HOLLY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_CRAFTING_TABLE));
    public static final Item HOLLY_STAIRS = createItem(new BlockItem(BYGBlocks.HOLLY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_STAIRS));
    public static final Item HOLLY_SLAB = createItem(new BlockItem(BYGBlocks.HOLLY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_SLAB));
    public static final Item HOLLY_FENCE = createItem(new BlockItem(BYGBlocks.HOLLY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_FENCE));
    public static final Item HOLLY_FENCE_GATE = createItem(new BlockItem(BYGBlocks.HOLLY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_FENCE_GATE));
    public static final Item HOLLY_DOOR = createItem(new TallBlockItem(BYGBlocks.HOLLY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_DOOR));
    public static final Item HOLLY_TRAPDOOR = createItem(new BlockItem(BYGBlocks.HOLLY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_TRAPDOOR));
    public static final Item HOLLY_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.HOLLY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_PRESSURE_PLATE));
    public static final Item HOLLY_BUTTON = createItem(new BlockItem(BYGBlocks.HOLLY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HOLLY_BUTTON));
    public static final Item HOLLY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.HOLLY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "holly_boat");

    //Jacaranda Woodtype
    public static final Item JACARANDA_SAPLING = createItem(new BlockItem(BYGBlocks.JACARANDA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_SAPLING));
    public static final Item JACARANDA_LEAVES = createItem(new BlockItem(BYGBlocks.JACARANDA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_LEAVES));
    public static final Item INDIGO_JACARANDA_SAPLING = createItem(new BlockItem(BYGBlocks.INDIGO_JACARANDA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.INDIGO_JACARANDA_SAPLING));
    public static final Item INDIGO_JACARANDA_LEAVES = createItem(new BlockItem(BYGBlocks.INDIGO_JACARANDA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.INDIGO_JACARANDA_LEAVES));
    public static final Item JACARANDA_LOG = createItem(new BlockItem(BYGBlocks.JACARANDA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_LOG));
    public static final Item JACARANDA_WOOD = createItem(new BlockItem(BYGBlocks.JACARANDA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_WOOD));
    public static final Item STRIPPED_JACARANDA_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_JACARANDA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_JACARANDA_LOG));
    public static final Item STRIPPED_JACARANDA_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_JACARANDA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_JACARANDA_WOOD));
    public static final Item JACARANDA_PLANKS = createItem(new BlockItem(BYGBlocks.JACARANDA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_PLANKS));
    public static final Item JACARANDA_BOOKSHELF = createItem(new BlockItem(BYGBlocks.JACARANDA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_BOOKSHELF));
    public static final Item JACARANDA_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.JACARANDA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_CRAFTING_TABLE));
    public static final Item JACARANDA_STAIRS = createItem(new BlockItem(BYGBlocks.JACARANDA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_STAIRS));
    public static final Item JACARANDA_SLAB = createItem(new BlockItem(BYGBlocks.JACARANDA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_SLAB));
    public static final Item JACARANDA_FENCE = createItem(new BlockItem(BYGBlocks.JACARANDA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_FENCE));
    public static final Item JACARANDA_FENCE_GATE = createItem(new BlockItem(BYGBlocks.JACARANDA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_FENCE_GATE));
    public static final Item JACARANDA_DOOR = createItem(new TallBlockItem(BYGBlocks.JACARANDA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_DOOR));
    public static final Item JACARANDA_TRAPDOOR = createItem(new BlockItem(BYGBlocks.JACARANDA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_TRAPDOOR));
    public static final Item JACARANDA_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.JACARANDA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_PRESSURE_PLATE));
    public static final Item JACARANDA_BUTTON = createItem(new BlockItem(BYGBlocks.JACARANDA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JACARANDA_BUTTON));
    public static final Item JACARANDA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.JACARANDA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "jacaranda_boat");

    //Lament Woodtype
    public static final Item LAMENT_SAPLING = createItem(new BlockItem(BYGBlocks.LAMENT_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_SAPLING));
    public static final Item LAMENT_LEAVES = createItem(new BlockItem(BYGBlocks.LAMENT_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_LEAVES));
    public static final Item LAMENT_VINE = createItem(new BlockItem(BYGBlocks.LAMENT_VINE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_VINE));
    public static final Item LAMENT_SPROUTS = createItem(new BlockItem(BYGBlocks.LAMENT_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_SPROUTS));
    public static final Item LAMENT_LOG = createItem(new BlockItem(BYGBlocks.LAMENT_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_LOG));
    public static final Item LAMENT_WOOD = createItem(new BlockItem(BYGBlocks.LAMENT_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_WOOD));
    public static final Item STRIPPED_LAMENT_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_LAMENT_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_LAMENT_LOG));
    public static final Item STRIPPED_LAMENT_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_LAMENT_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_LAMENT_WOOD));
    public static final Item LAMENT_PLANKS = createItem(new BlockItem(BYGBlocks.LAMENT_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_PLANKS));
    public static final Item LAMENT_BOOKSHELF = createItem(new BlockItem(BYGBlocks.LAMENT_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_BOOKSHELF));
    public static final Item LAMENT_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.LAMENT_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_CRAFTING_TABLE));
    public static final Item LAMENT_STAIRS = createItem(new BlockItem(BYGBlocks.LAMENT_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_STAIRS));
    public static final Item LAMENT_SLAB = createItem(new BlockItem(BYGBlocks.LAMENT_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_SLAB));
    public static final Item LAMENT_FENCE = createItem(new BlockItem(BYGBlocks.LAMENT_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_FENCE));
    public static final Item LAMENT_FENCE_GATE = createItem(new BlockItem(BYGBlocks.LAMENT_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_FENCE_GATE));
    public static final Item LAMENT_DOOR = createItem(new TallBlockItem(BYGBlocks.LAMENT_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_DOOR));
    public static final Item LAMENT_TRAPDOOR = createItem(new BlockItem(BYGBlocks.LAMENT_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_TRAPDOOR));
    public static final Item LAMENT_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.LAMENT_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_PRESSURE_PLATE));
    public static final Item LAMENT_BUTTON = createItem(new BlockItem(BYGBlocks.LAMENT_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAMENT_BUTTON));

    //Mahogany Woodtype
    public static final Item MAHOGANY_SAPLING = createItem(new BlockItem(BYGBlocks.MAHOGANY_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_SAPLING));
    public static final Item MAHOGANY_LEAVES = createItem(new BlockItem(BYGBlocks.MAHOGANY_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_LEAVES));
    public static final Item MAHOGANY_LOG = createItem(new BlockItem(BYGBlocks.MAHOGANY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_LOG));
    public static final Item MAHOGANY_WOOD = createItem(new BlockItem(BYGBlocks.MAHOGANY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_WOOD));
    public static final Item STRIPPED_MAHOGANY_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_MAHOGANY_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MAHOGANY_LOG));
    public static final Item STRIPPED_MAHOGANY_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_MAHOGANY_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MAHOGANY_WOOD));
    public static final Item MAHOGANY_PLANKS = createItem(new BlockItem(BYGBlocks.MAHOGANY_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_PLANKS));
    public static final Item MAHOGANY_BOOKSHELF = createItem(new BlockItem(BYGBlocks.MAHOGANY_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_BOOKSHELF));
    public static final Item MAHOGANY_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.MAHOGANY_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_CRAFTING_TABLE));
    public static final Item MAHOGANY_STAIRS = createItem(new BlockItem(BYGBlocks.MAHOGANY_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_STAIRS));
    public static final Item MAHOGANY_SLAB = createItem(new BlockItem(BYGBlocks.MAHOGANY_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_SLAB));
    public static final Item MAHOGANY_FENCE = createItem(new BlockItem(BYGBlocks.MAHOGANY_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_FENCE));
    public static final Item MAHOGANY_FENCE_GATE = createItem(new BlockItem(BYGBlocks.MAHOGANY_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_FENCE_GATE));
    public static final Item MAHOGANY_DOOR = createItem(new TallBlockItem(BYGBlocks.MAHOGANY_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_DOOR));
    public static final Item MAHOGANY_TRAPDOOR = createItem(new BlockItem(BYGBlocks.MAHOGANY_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_TRAPDOOR));
    public static final Item MAHOGANY_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.MAHOGANY_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_PRESSURE_PLATE));
    public static final Item MAHOGANY_BUTTON = createItem(new BlockItem(BYGBlocks.MAHOGANY_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAHOGANY_BUTTON));
    public static final Item MAHOGANY_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MAHOGANY, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "mahogany_boat");

    //Mangrove Woodtype
    public static final Item MANGROVE_SAPLING = createItem(new BlockItem(BYGBlocks.MANGROVE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_SAPLING));
    public static final Item MANGROVE_LEAVES = createItem(new BlockItem(BYGBlocks.MANGROVE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_LEAVES));
    public static final Item MANGROVE_LOG = createItem(new BlockItem(BYGBlocks.MANGROVE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_LOG));
    public static final Item MANGROVE_WOOD = createItem(new BlockItem(BYGBlocks.MANGROVE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_WOOD));
    public static final Item STRIPPED_MANGROVE_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_MANGROVE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MANGROVE_LOG));
    public static final Item STRIPPED_MANGROVE_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_MANGROVE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MANGROVE_WOOD));
    public static final Item MANGROVE_PLANKS = createItem(new BlockItem(BYGBlocks.MANGROVE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_PLANKS));
    public static final Item MANGROVE_BOOKSHELF = createItem(new BlockItem(BYGBlocks.MANGROVE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_BOOKSHELF));
    public static final Item MANGROVE_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.MANGROVE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_CRAFTING_TABLE));
    public static final Item MANGROVE_STAIRS = createItem(new BlockItem(BYGBlocks.MANGROVE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_STAIRS));
    public static final Item MANGROVE_SLAB = createItem(new BlockItem(BYGBlocks.MANGROVE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_SLAB));
    public static final Item MANGROVE_FENCE = createItem(new BlockItem(BYGBlocks.MANGROVE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_FENCE));
    public static final Item MANGROVE_FENCE_GATE = createItem(new BlockItem(BYGBlocks.MANGROVE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_FENCE_GATE));
    public static final Item MANGROVE_DOOR = createItem(new TallBlockItem(BYGBlocks.MANGROVE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_DOOR));
    public static final Item MANGROVE_TRAPDOOR = createItem(new BlockItem(BYGBlocks.MANGROVE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_TRAPDOOR));
    public static final Item MANGROVE_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.MANGROVE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_PRESSURE_PLATE));
    public static final Item MANGROVE_BUTTON = createItem(new BlockItem(BYGBlocks.MANGROVE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MANGROVE_BUTTON));
    public static final Item MANGROVE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MANGROVE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "mangrove_boat");

    //Maple Woodtype
    public static final Item MAPLE_SAPLING = createItem(new BlockItem(BYGBlocks.MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_SAPLING));
    public static final Item MAPLE_LEAVES = createItem(new BlockItem(BYGBlocks.MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_LEAVES));
    public static final Item RED_MAPLE_SAPLING = createItem(new BlockItem(BYGBlocks.RED_MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_MAPLE_SAPLING));
    public static final Item RED_MAPLE_LEAVES = createItem(new BlockItem(BYGBlocks.RED_MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_MAPLE_LEAVES));
    public static final Item SILVER_MAPLE_SAPLING = createItem(new BlockItem(BYGBlocks.SILVER_MAPLE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SILVER_MAPLE_SAPLING));
    public static final Item SILVER_MAPLE_LEAVES = createItem(new BlockItem(BYGBlocks.SILVER_MAPLE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SILVER_MAPLE_LEAVES));
    public static final Item MAPLE_LOG = createItem(new BlockItem(BYGBlocks.MAPLE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_LOG));
    public static final Item MAPLE_WOOD = createItem(new BlockItem(BYGBlocks.MAPLE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_WOOD));
    public static final Item STRIPPED_MAPLE_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_MAPLE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MAPLE_LOG));
    public static final Item STRIPPED_MAPLE_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_MAPLE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_MAPLE_WOOD));
    public static final Item MAPLE_PLANKS = createItem(new BlockItem(BYGBlocks.MAPLE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_PLANKS));
    public static final Item MAPLE_BOOKSHELF = createItem(new BlockItem(BYGBlocks.MAPLE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_BOOKSHELF));
    public static final Item MAPLE_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.MAPLE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_CRAFTING_TABLE));
    public static final Item MAPLE_STAIRS = createItem(new BlockItem(BYGBlocks.MAPLE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_STAIRS));
    public static final Item MAPLE_SLAB = createItem(new BlockItem(BYGBlocks.MAPLE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_SLAB));
    public static final Item MAPLE_FENCE = createItem(new BlockItem(BYGBlocks.MAPLE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_FENCE));
    public static final Item MAPLE_FENCE_GATE = createItem(new BlockItem(BYGBlocks.MAPLE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_FENCE_GATE));
    public static final Item MAPLE_DOOR = createItem(new TallBlockItem(BYGBlocks.MAPLE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_DOOR));
    public static final Item MAPLE_TRAPDOOR = createItem(new BlockItem(BYGBlocks.MAPLE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_TRAPDOOR));
    public static final Item MAPLE_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.MAPLE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_PRESSURE_PLATE));
    public static final Item MAPLE_BUTTON = createItem(new BlockItem(BYGBlocks.MAPLE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAPLE_BUTTON));
    public static final Item MAPLE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.MAPLE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "maple_boat");

    //Nightshade Woodtype
    public static final Item NIGHTSHADE_SAPLING = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_SAPLING));
    public static final Item FLOWERING_NIGHTSHADE_LEAVES = createItem(new BlockItem(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FLOWERING_NIGHTSHADE_LEAVES));
    public static final Item NIGHTSHADE_LEAVES = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_LEAVES));
    public static final Item IMBUED_NIGHTSHADE_LOG = createItem(new BlockItem(BYGBlocks.IMBUED_NIGHTSHADE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.IMBUED_NIGHTSHADE_LOG));
    public static final Item NIGHTSHADE_LOG = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_LOG));
    public static final Item NIGHTSHADE_WOOD = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_WOOD));
    public static final Item STRIPPED_NIGHTSHADE_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_NIGHTSHADE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_NIGHTSHADE_LOG));
    public static final Item STRIPPED_NIGHTSHADE_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_NIGHTSHADE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_NIGHTSHADE_WOOD));
    public static final Item NIGHTSHADE_PLANKS = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_PLANKS));
    public static final Item NIGHTSHADE_BOOKSHELF = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_BOOKSHELF));
    public static final Item NIGHTSHADE_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_CRAFTING_TABLE));
    public static final Item NIGHTSHADE_STAIRS = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_STAIRS));
    public static final Item NIGHTSHADE_SLAB = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_SLAB));
    public static final Item NIGHTSHADE_FENCE = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_FENCE));
    public static final Item NIGHTSHADE_FENCE_GATE = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_FENCE_GATE));
    public static final Item NIGHTSHADE_DOOR = createItem(new TallBlockItem(BYGBlocks.NIGHTSHADE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_DOOR));
    public static final Item NIGHTSHADE_TRAPDOOR = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_TRAPDOOR));
    public static final Item NIGHTSHADE_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_PRESSURE_PLATE));
    public static final Item NIGHTSHADE_BUTTON = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_BUTTON));

    //Palm Woodtype
    public static final Item PALM_SAPLING = createItem(new BlockItem(BYGBlocks.PALM_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_SAPLING));
    public static final Item PALM_LEAVES = createItem(new BlockItem(BYGBlocks.PALM_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_LEAVES));
    public static final Item PALM_LOG = createItem(new BlockItem(BYGBlocks.PALM_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_LOG));
    public static final Item PALM_WOOD = createItem(new BlockItem(BYGBlocks.PALM_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_WOOD));
    public static final Item STRIPPED_PALM_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_PALM_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PALM_LOG));
    public static final Item STRIPPED_PALM_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_PALM_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PALM_WOOD));
    public static final Item PALM_PLANKS = createItem(new BlockItem(BYGBlocks.PALM_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_PLANKS));
    public static final Item PALM_BOOKSHELF = createItem(new BlockItem(BYGBlocks.PALM_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_BOOKSHELF));
    public static final Item PALM_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.PALM_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_CRAFTING_TABLE));
    public static final Item PALM_STAIRS = createItem(new BlockItem(BYGBlocks.PALM_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_STAIRS));
    public static final Item PALM_SLAB = createItem(new BlockItem(BYGBlocks.PALM_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_SLAB));
    public static final Item PALM_FENCE = createItem(new BlockItem(BYGBlocks.PALM_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_FENCE));
    public static final Item PALM_FENCE_GATE = createItem(new BlockItem(BYGBlocks.PALM_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_FENCE_GATE));
    public static final Item PALM_DOOR = createItem(new TallBlockItem(BYGBlocks.PALM_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_DOOR));
    public static final Item PALM_TRAPDOOR = createItem(new BlockItem(BYGBlocks.PALM_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_TRAPDOOR));
    public static final Item PALM_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.PALM_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_PRESSURE_PLATE));
    public static final Item PALM_BUTTON = createItem(new BlockItem(BYGBlocks.PALM_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALM_BUTTON));
    public static final Item PALM_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.PALM, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "palm_boat");

    //Palo Verde Woodtype
    public static final Item FLOWERING_PALO_VERDE_LEAVES = createItem(new BlockItem(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES));
    public static final Item PALO_VERDE_SAPLING = createItem(new BlockItem(BYGBlocks.PALO_VERDE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALO_VERDE_SAPLING));
    public static final Item PALO_VERDE_LEAVES = createItem(new BlockItem(BYGBlocks.PALO_VERDE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALO_VERDE_LEAVES));
    public static final Item PALO_VERDE_LOG = createItem(new BlockItem(BYGBlocks.PALO_VERDE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALO_VERDE_LOG));
    public static final Item PALO_VERDE_WOOD = createItem(new BlockItem(BYGBlocks.PALO_VERDE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PALO_VERDE_WOOD));
    public static final Item STRIPPED_PALO_VERDE_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_PALO_VERDE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PALO_VERDE_LOG));
    public static final Item STRIPPED_PALO_VERDE_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_PALO_VERDE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PALO_VERDE_WOOD));

    //Pine Woodtype
    public static final Item PINE_SAPLING = createItem(new BlockItem(BYGBlocks.PINE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_SAPLING));
    public static final Item PINE_LEAVES = createItem(new BlockItem(BYGBlocks.PINE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_LEAVES));
    public static final Item PINE_LOG = createItem(new BlockItem(BYGBlocks.PINE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_LOG));
    public static final Item PINE_WOOD = createItem(new BlockItem(BYGBlocks.PINE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_WOOD));
    public static final Item STRIPPED_PINE_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_PINE_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PINE_LOG));
    public static final Item STRIPPED_PINE_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_PINE_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_PINE_WOOD));
    public static final Item PINE_PLANKS = createItem(new BlockItem(BYGBlocks.PINE_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_PLANKS));
    public static final Item PINE_BOOKSHELF = createItem(new BlockItem(BYGBlocks.PINE_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_BOOKSHELF));
    public static final Item PINE_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.PINE_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_CRAFTING_TABLE));
    public static final Item PINE_STAIRS = createItem(new BlockItem(BYGBlocks.PINE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_STAIRS));
    public static final Item PINE_SLAB = createItem(new BlockItem(BYGBlocks.PINE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_SLAB));
    public static final Item PINE_FENCE = createItem(new BlockItem(BYGBlocks.PINE_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_FENCE));
    public static final Item PINE_FENCE_GATE = createItem(new BlockItem(BYGBlocks.PINE_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_FENCE_GATE));
    public static final Item PINE_DOOR = createItem(new TallBlockItem(BYGBlocks.PINE_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_DOOR));
    public static final Item PINE_TRAPDOOR = createItem(new BlockItem(BYGBlocks.PINE_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_TRAPDOOR));
    public static final Item PINE_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.PINE_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_PRESSURE_PLATE));
    public static final Item PINE_BUTTON = createItem(new BlockItem(BYGBlocks.PINE_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINE_BUTTON));
    public static final Item PINE_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.PINE, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "pine_boat");

    //Rainbow Eucalyptus Woodtype
    public static final Item RAINBOW_EUCALYPTUS_SAPLING = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_SAPLING));
    public static final Item RAINBOW_EUCALYPTUS_LEAVES = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES));
    public static final Item RAINBOW_EUCALYPTUS_LOG = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_LOG));
    public static final Item RAINBOW_EUCALYPTUS_WOOD = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_WOOD));
    public static final Item STRIPPED_RAINBOW_EUCALYPTUS_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_LOG));
    public static final Item STRIPPED_RAINBOW_EUCALYPTUS_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_RAINBOW_EUCALYPTUS_WOOD));
    public static final Item RAINBOW_EUCALYPTUS_PLANKS = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_PLANKS));
    public static final Item RAINBOW_EUCALYPTUS_BOOKSHELF = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_BOOKSHELF));
    public static final Item RAINBOW_EUCALYPTUS_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_CRAFTING_TABLE));
    public static final Item RAINBOW_EUCALYPTUS_STAIRS = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_STAIRS));
    public static final Item RAINBOW_EUCALYPTUS_SLAB = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_SLAB));
    public static final Item RAINBOW_EUCALYPTUS_FENCE = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE));
    public static final Item RAINBOW_EUCALYPTUS_FENCE_GATE = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_FENCE_GATE));
    public static final Item RAINBOW_EUCALYPTUS_DOOR = createItem(new TallBlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_DOOR));
    public static final Item RAINBOW_EUCALYPTUS_TRAPDOOR = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_TRAPDOOR));
    public static final Item RAINBOW_EUCALYPTUS_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_PRESSURE_PLATE));
    public static final Item RAINBOW_EUCALYPTUS_BUTTON = createItem(new BlockItem(BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAINBOW_EUCALYPTUS_BUTTON));
    public static final Item RAINBOW_EUCALYPTUS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "rainbow_eucalyptus_boat");

    //Redwood Woodtype
    public static final Item REDWOOD_SAPLING = createItem(new BlockItem(BYGBlocks.REDWOOD_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_SAPLING));
    public static final Item REDWOOD_LEAVES = createItem(new BlockItem(BYGBlocks.REDWOOD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_LEAVES));
    public static final Item REDWOOD_LOG = createItem(new BlockItem(BYGBlocks.REDWOOD_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_LOG));
    public static final Item REDWOOD_WOOD = createItem(new BlockItem(BYGBlocks.REDWOOD_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_WOOD));
    public static final Item STRIPPED_REDWOOD_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_REDWOOD_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_REDWOOD_LOG));
    public static final Item STRIPPED_REDWOOD_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_REDWOOD_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_REDWOOD_WOOD));
    public static final Item REDWOOD_PLANKS = createItem(new BlockItem(BYGBlocks.REDWOOD_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_PLANKS));
    public static final Item REDWOOD_BOOKSHELF = createItem(new BlockItem(BYGBlocks.REDWOOD_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_BOOKSHELF));
    public static final Item REDWOOD_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.REDWOOD_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_CRAFTING_TABLE));
    public static final Item REDWOOD_STAIRS = createItem(new BlockItem(BYGBlocks.REDWOOD_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_STAIRS));
    public static final Item REDWOOD_SLAB = createItem(new BlockItem(BYGBlocks.REDWOOD_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_SLAB));
    public static final Item REDWOOD_FENCE = createItem(new BlockItem(BYGBlocks.REDWOOD_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_FENCE));
    public static final Item REDWOOD_FENCE_GATE = createItem(new BlockItem(BYGBlocks.REDWOOD_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_FENCE_GATE));
    public static final Item REDWOOD_DOOR = createItem(new TallBlockItem(BYGBlocks.REDWOOD_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_DOOR));
    public static final Item REDWOOD_TRAPDOOR = createItem(new BlockItem(BYGBlocks.REDWOOD_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_TRAPDOOR));
    public static final Item REDWOOD_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.REDWOOD_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_PRESSURE_PLATE));
    public static final Item REDWOOD_BUTTON = createItem(new BlockItem(BYGBlocks.REDWOOD_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REDWOOD_BUTTON));
    public static final Item REDWOOD_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.REDWOOD, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "redwood_boat");

    //Skyris Woodtype
    public static final Item SKYRIS_LEAVES_GREEN_APPLE = createItem(new BlockItem(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_LEAVES_GREEN_APPLE));
    public static final Item GREEN_APPLE = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(4).saturation(0.35f).build())), "green_apple");
    public static final Item SKYRIS_SAPLING = createItem(new BlockItem(BYGBlocks.SKYRIS_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_SAPLING));
    public static final Item SKYRIS_VINE = createItem(new BlockItem(BYGBlocks.SKYRIS_VINE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_VINE));
    public static final Item SKYRIS_LEAVES = createItem(new BlockItem(BYGBlocks.SKYRIS_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_LEAVES));
    public static final Item SKYRIS_LOG = createItem(new BlockItem(BYGBlocks.SKYRIS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_LOG));
    public static final Item SKYRIS_WOOD = createItem(new BlockItem(BYGBlocks.SKYRIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_WOOD));
    public static final Item STRIPPED_SKYRIS_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_SKYRIS_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_SKYRIS_LOG));
    public static final Item STRIPPED_SKYRIS_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_SKYRIS_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_SKYRIS_WOOD));
    public static final Item SKYRIS_PLANKS = createItem(new BlockItem(BYGBlocks.SKYRIS_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_PLANKS));
    public static final Item SKYRIS_BOOKSHELF = createItem(new BlockItem(BYGBlocks.SKYRIS_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_BOOKSHELF));
    public static final Item SKYRIS_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.SKYRIS_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_CRAFTING_TABLE));
    public static final Item SKYRIS_STAIRS = createItem(new BlockItem(BYGBlocks.SKYRIS_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_STAIRS));
    public static final Item SKYRIS_SLAB = createItem(new BlockItem(BYGBlocks.SKYRIS_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_SLAB));
    public static final Item SKYRIS_FENCE = createItem(new BlockItem(BYGBlocks.SKYRIS_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_FENCE));
    public static final Item SKYRIS_FENCE_GATE = createItem(new BlockItem(BYGBlocks.SKYRIS_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_FENCE_GATE));
    public static final Item SKYRIS_DOOR = createItem(new TallBlockItem(BYGBlocks.SKYRIS_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_DOOR));
    public static final Item SKYRIS_TRAPDOOR = createItem(new BlockItem(BYGBlocks.SKYRIS_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_TRAPDOOR));
    public static final Item SKYRIS_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.SKYRIS_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_PRESSURE_PLATE));
    public static final Item SKYRIS_BUTTON = createItem(new BlockItem(BYGBlocks.SKYRIS_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SKYRIS_BUTTON));
    public static final Item SKYRIS_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.SKYRIS, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "skyris_boat");

    //Willow Woodtype
    public static final Item WILLOW_SAPLING = createItem(new BlockItem(BYGBlocks.WILLOW_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_SAPLING));
    public static final Item WILLOW_LEAVES = createItem(new BlockItem(BYGBlocks.WILLOW_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_LEAVES));
    public static final Item WILLOW_LOG = createItem(new BlockItem(BYGBlocks.WILLOW_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_LOG));
    public static final Item WILLOW_WOOD = createItem(new BlockItem(BYGBlocks.WILLOW_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_WOOD));
    public static final Item STRIPPED_WILLOW_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_WILLOW_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_WILLOW_LOG));
    public static final Item STRIPPED_WILLOW_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_WILLOW_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_WILLOW_WOOD));
    public static final Item WILLOW_PLANKS = createItem(new BlockItem(BYGBlocks.WILLOW_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_PLANKS));
    public static final Item WILLOW_BOOKSHELF = createItem(new BlockItem(BYGBlocks.WILLOW_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_BOOKSHELF));
    public static final Item WILLOW_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.WILLOW_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_CRAFTING_TABLE));
    public static final Item WILLOW_STAIRS = createItem(new BlockItem(BYGBlocks.WILLOW_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_STAIRS));
    public static final Item WILLOW_SLAB = createItem(new BlockItem(BYGBlocks.WILLOW_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_SLAB));
    public static final Item WILLOW_FENCE = createItem(new BlockItem(BYGBlocks.WILLOW_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_FENCE));
    public static final Item WILLOW_FENCE_GATE = createItem(new BlockItem(BYGBlocks.WILLOW_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_FENCE_GATE));
    public static final Item WILLOW_DOOR = createItem(new TallBlockItem(BYGBlocks.WILLOW_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_DOOR));
    public static final Item WILLOW_TRAPDOOR = createItem(new BlockItem(BYGBlocks.WILLOW_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_TRAPDOOR));
    public static final Item WILLOW_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.WILLOW_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_PRESSURE_PLATE));
    public static final Item WILLOW_BUTTON = createItem(new BlockItem(BYGBlocks.WILLOW_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILLOW_BUTTON));
    public static final Item WILLOW_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.WILLOW, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "willow_boat");

    //Witch-Hazel Woodtype
    public static final Item BLOOMING_WITCH_HAZEL_LEAVES = createItem(new BlockItem(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES));
    public static final Item WITCH_HAZEL_SAPLING = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_SAPLING));
    public static final Item WITCH_HAZEL_LEAVES = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_LEAVES));
    public static final Item WITCH_HAZEL_LOG = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_LOG));
    public static final Item WITCH_HAZEL_WOOD = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_WOOD));
    public static final Item STRIPPED_WITCH_HAZEL_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_WITCH_HAZEL_LOG));
    public static final Item STRIPPED_WITCH_HAZEL_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_WITCH_HAZEL_WOOD));
    public static final Item WITCH_HAZEL_PLANKS = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_PLANKS));
    public static final Item WITCH_HAZEL_BOOKSHELF = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_BOOKSHELF));
    public static final Item WITCH_HAZEL_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_CRAFTING_TABLE));
    public static final Item WITCH_HAZEL_STAIRS = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_STAIRS));
    public static final Item WITCH_HAZEL_SLAB = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_SLAB));
    public static final Item WITCH_HAZEL_FENCE = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_FENCE));
    public static final Item WITCH_HAZEL_FENCE_GATE = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_FENCE_GATE));
    public static final Item WITCH_HAZEL_DOOR = createItem(new TallBlockItem(BYGBlocks.WITCH_HAZEL_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_DOOR));
    public static final Item WITCH_HAZEL_TRAPDOOR = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_TRAPDOOR));
    public static final Item WITCH_HAZEL_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_PRESSURE_PLATE));
    public static final Item WITCH_HAZEL_BUTTON = createItem(new BlockItem(BYGBlocks.WITCH_HAZEL_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITCH_HAZEL_BUTTON));
    public static final Item WITCH_HAZEL_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.WITCH_HAZEL, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "witch_hazel_boat");

    //Zelkova Woodtype
    public static final Item ZELKOVA_SAPLING = createItem(new BlockItem(BYGBlocks.ZELKOVA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_SAPLING));
    public static final Item ZELKOVA_LEAVES = createItem(new BlockItem(BYGBlocks.ZELKOVA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_LEAVES));
    public static final Item ZELKOVA_LOG = createItem(new BlockItem(BYGBlocks.ZELKOVA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_LOG));
    public static final Item ZELKOVA_WOOD = createItem(new BlockItem(BYGBlocks.ZELKOVA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_WOOD));
    public static final Item STRIPPED_ZELKOVA_LOG = createItem(new BlockItem(BYGBlocks.STRIPPED_ZELKOVA_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ZELKOVA_LOG));
    public static final Item STRIPPED_ZELKOVA_WOOD = createItem(new BlockItem(BYGBlocks.STRIPPED_ZELKOVA_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_ZELKOVA_WOOD));
    public static final Item ZELKOVA_PLANKS = createItem(new BlockItem(BYGBlocks.ZELKOVA_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_PLANKS));
    public static final Item ZELKOVA_BOOKSHELF = createItem(new BlockItem(BYGBlocks.ZELKOVA_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_BOOKSHELF));
    public static final Item ZELKOVA_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.ZELKOVA_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_CRAFTING_TABLE));
    public static final Item ZELKOVA_STAIRS = createItem(new BlockItem(BYGBlocks.ZELKOVA_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_STAIRS));
    public static final Item ZELKOVA_SLAB = createItem(new BlockItem(BYGBlocks.ZELKOVA_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_SLAB));
    public static final Item ZELKOVA_FENCE = createItem(new BlockItem(BYGBlocks.ZELKOVA_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_FENCE));
    public static final Item ZELKOVA_FENCE_GATE = createItem(new BlockItem(BYGBlocks.ZELKOVA_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_FENCE_GATE));
    public static final Item ZELKOVA_DOOR = createItem(new TallBlockItem(BYGBlocks.ZELKOVA_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_DOOR));
    public static final Item ZELKOVA_TRAPDOOR = createItem(new BlockItem(BYGBlocks.ZELKOVA_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_TRAPDOOR));
    public static final Item ZELKOVA_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.ZELKOVA_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_PRESSURE_PLATE));
    public static final Item ZELKOVA_BUTTON = createItem(new BlockItem(BYGBlocks.ZELKOVA_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ZELKOVA_BUTTON));
    public static final Item ZELKOVA_BOAT = createItem(new BYGBoatItem(BYGBoatEntity.BYGType.ZELKOVA, new Item.Properties().group(BYGCreativeTab.creativeTab).maxStackSize(1)), "zelkova_boat");

    //Sythian Woodtype
    public static final Item SYTHIAN_WART_BLOCK = createItem(new BlockItem(BYGBlocks.SYTHIAN_WART_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_WART_BLOCK));
    public static final Item SYTHIAN_FUNGUS = createItem(new BlockItem(BYGBlocks.SYTHIAN_FUNGUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_FUNGUS));
    public static final Item SYTHIAN_STEM = createItem(new BlockItem(BYGBlocks.SYTHIAN_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_STEM));
    public static final Item SYTHIAN_HYPHAE = createItem(new BlockItem(BYGBlocks.SYTHIAN_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_HYPHAE));
    public static final Item STRIPPED_SYTHIAN_STEM = createItem(new BlockItem(BYGBlocks.STRIPPED_SYTHIAN_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_SYTHIAN_STEM));
    public static final Item STRIPPED_SYTHIAN_HYPHAE = createItem(new BlockItem(BYGBlocks.STRIPPED_SYTHIAN_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_SYTHIAN_HYPHAE));
    public static final Item SYTHIAN_PLANKS = createItem(new BlockItem(BYGBlocks.SYTHIAN_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_PLANKS));
    public static final Item SYTHIAN_BOOKSHELF = createItem(new BlockItem(BYGBlocks.SYTHIAN_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_BOOKSHELF));
    public static final Item SYTHIAN_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.SYTHIAN_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_CRAFTING_TABLE));
    public static final Item SYTHIAN_STAIRS = createItem(new BlockItem(BYGBlocks.SYTHIAN_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_STAIRS));
    public static final Item SYTHIAN_SLAB = createItem(new BlockItem(BYGBlocks.SYTHIAN_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_SLAB));
    public static final Item SYTHIAN_FENCE = createItem(new BlockItem(BYGBlocks.SYTHIAN_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_FENCE));
    public static final Item SYTHIAN_FENCE_GATE = createItem(new BlockItem(BYGBlocks.SYTHIAN_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_FENCE_GATE));
    public static final Item SYTHIAN_DOOR = createItem(new TallBlockItem(BYGBlocks.SYTHIAN_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_DOOR));
    public static final Item SYTHIAN_TRAPDOOR = createItem(new BlockItem(BYGBlocks.SYTHIAN_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_TRAPDOOR));
    public static final Item SYTHIAN_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.SYTHIAN_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_PRESSURE_PLATE));
    public static final Item SYTHIAN_BUTTON = createItem(new BlockItem(BYGBlocks.SYTHIAN_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_BUTTON));

    //Embur Woodtype
    public static final Item EMBUR_GEL_BALL = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "embur_gel_ball");
    public static final Item EMBUR_GEL_BLOCK = createItem(new BlockItem(BYGBlocks.EMBUR_GEL_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_GEL_BLOCK));
    public static final Item EMBUR_GEL_VINES = createItem(new BlockItem(BYGBlocks.EMBUR_GEL_VINES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_GEL_VINES));
    public static final Item EMBUR_WART = createItem(new BlockItem(BYGBlocks.EMBUR_WART, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_WART));
    public static final Item EMBUR_PEDU = createItem(new BlockItem(BYGBlocks.EMBUR_PEDU, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_PEDU));
    public static final Item EMBUR_HYPHAE = createItem(new BlockItem(BYGBlocks.EMBUR_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_HYPHAE));
    public static final Item STRIPPED_EMBUR_PEDU = createItem(new BlockItem(BYGBlocks.STRIPPED_EMBUR_PEDU, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_EMBUR_PEDU));
    public static final Item STRIPPED_EMBUR_HYPHAE = createItem(new BlockItem(BYGBlocks.STRIPPED_EMBUR_HYPHAE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.STRIPPED_EMBUR_HYPHAE));
    public static final Item EMBUR_PLANKS = createItem(new BlockItem(BYGBlocks.EMBUR_PLANKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_PLANKS));
    public static final Item EMBUR_BOOKSHELF = createItem(new BlockItem(BYGBlocks.EMBUR_BOOKSHELF, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_BOOKSHELF));
    public static final Item EMBUR_CRAFTING_TABLE = createItem(new BlockItem(BYGBlocks.EMBUR_CRAFTING_TABLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_CRAFTING_TABLE));
    public static final Item EMBUR_STAIRS = createItem(new BlockItem(BYGBlocks.EMBUR_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_STAIRS));
    public static final Item EMBUR_SLAB = createItem(new BlockItem(BYGBlocks.EMBUR_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_SLAB));
    public static final Item EMBUR_FENCE = createItem(new BlockItem(BYGBlocks.EMBUR_FENCE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_FENCE));
    public static final Item EMBUR_FENCE_GATE = createItem(new BlockItem(BYGBlocks.EMBUR_FENCE_GATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_FENCE_GATE));
    public static final Item EMBUR_DOOR = createItem(new TallBlockItem(BYGBlocks.EMBUR_DOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_DOOR));
    public static final Item EMBUR_TRAPDOOR = createItem(new BlockItem(BYGBlocks.EMBUR_TRAPDOOR, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_TRAPDOOR));
    public static final Item EMBUR_PRESSURE_PLATE = createItem(new BlockItem(BYGBlocks.EMBUR_PRESSURE_PLATE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_PRESSURE_PLATE));
    public static final Item EMBUR_BUTTON = createItem(new BlockItem(BYGBlocks.EMBUR_BUTTON, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_BUTTON));

    //SaplingItems
    public static final Item WITHERING_OAK_SAPLING = createItem(new BlockItem(BYGBlocks.WITHERING_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITHERING_OAK_SAPLING));
    public static final Item WITHERING_OAK_LEAVES = createItem(new BlockItem(BYGBlocks.WITHERING_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITHERING_OAK_LEAVES));
    public static final Item WITHERING_OAK_LOG = createItem(new BlockItem(BYGBlocks.WITHERING_OAK_LOG, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITHERING_OAK_LOG));
    public static final Item WITHERING_OAK_WOOD = createItem(new BlockItem(BYGBlocks.WITHERING_OAK_WOOD, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WITHERING_OAK_WOOD));

    public static final Item ARAUCARIA_SAPLING = createItem(new BlockItem(BYGBlocks.ARAUCARIA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ARAUCARIA_SAPLING));
    public static final Item ARAUCARIA_LEAVES = createItem(new BlockItem(BYGBlocks.ARAUCARIA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ARAUCARIA_LEAVES));

    public static final Item BLUE_SPRUCE_SAPLING = createItem(new BlockItem(BYGBlocks.BLUE_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SPRUCE_SAPLING));
    public static final Item BLUE_SPRUCE_LEAVES = createItem(new BlockItem(BYGBlocks.BLUE_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SPRUCE_LEAVES));

    public static final Item BROWN_BIRCH_SAPLING = createItem(new BlockItem(BYGBlocks.BROWN_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_BIRCH_SAPLING));
    public static final Item BROWN_BIRCH_LEAVES = createItem(new BlockItem(BYGBlocks.BROWN_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_BIRCH_LEAVES));

    public static final Item BROWN_OAK_SAPLING = createItem(new BlockItem(BYGBlocks.BROWN_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_OAK_SAPLING));
    public static final Item BROWN_OAK_LEAVES = createItem(new BlockItem(BYGBlocks.BROWN_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_OAK_LEAVES));

    public static final Item BROWN_ZELKOVA_SAPLING = createItem(new BlockItem(BYGBlocks.BROWN_ZELKOVA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_ZELKOVA_SAPLING));
    public static final Item BROWN_ZELKOVA_LEAVES = createItem(new BlockItem(BYGBlocks.BROWN_ZELKOVA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_ZELKOVA_LEAVES));

    public static final Item JOSHUA_SAPLING = createItem(new BlockItem(BYGBlocks.JOSHUA_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JOSHUA_SAPLING));
    public static final Item JOSHUA_LEAVES = createItem(new BlockItem(BYGBlocks.JOSHUA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JOSHUA_LEAVES));
    public static final Item RIPE_JOSHUA_LEAVES = createItem(new BlockItem(BYGBlocks.RIPE_JOSHUA_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RIPE_JOSHUA_LEAVES));
    public static final Item COOKED_JOSHUA_FRUIT = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(5).saturation(0.4f).build())), "cooked_joshua_fruit");
    public static final Item JOSHUA_FRUIT = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.35f).build())), "joshua_fruit");


    public static final Item ORANGE_BIRCH_SAPLING = createItem(new BlockItem(BYGBlocks.ORANGE_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_BIRCH_SAPLING));
    public static final Item ORANGE_BIRCH_LEAVES = createItem(new BlockItem(BYGBlocks.ORANGE_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_BIRCH_LEAVES));

    public static final Item ORANGE_OAK_SAPLING = createItem(new BlockItem(BYGBlocks.ORANGE_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_OAK_SAPLING));
    public static final Item ORANGE_OAK_LEAVES = createItem(new BlockItem(BYGBlocks.ORANGE_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_OAK_LEAVES));

    public static final Item ORANGE_SPRUCE_SAPLING = createItem(new BlockItem(BYGBlocks.ORANGE_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_SPRUCE_SAPLING));
    public static final Item ORANGE_SPRUCE_LEAVES = createItem(new BlockItem(BYGBlocks.ORANGE_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_SPRUCE_LEAVES));

    public static final Item ORCHARD_SAPLING = createItem(new BlockItem(BYGBlocks.ORCHARD_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORCHARD_SAPLING));
    public static final Item RIPE_ORCHARD_LEAVES = createItem(new BlockItem(BYGBlocks.RIPE_ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RIPE_ORCHARD_LEAVES));
    public static final Item FLOWERING_ORCHARD_LEAVES = createItem(new BlockItem(BYGBlocks.FLOWERING_ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FLOWERING_ORCHARD_LEAVES));
    public static final Item ORCHARD_LEAVES = createItem(new BlockItem(BYGBlocks.ORCHARD_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORCHARD_LEAVES));

    public static final Item RED_BIRCH_SAPLING = createItem(new BlockItem(BYGBlocks.RED_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_BIRCH_SAPLING));
    public static final Item RED_BIRCH_LEAVES = createItem(new BlockItem(BYGBlocks.RED_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_BIRCH_LEAVES));

    public static final Item RED_OAK_SAPLING = createItem(new BlockItem(BYGBlocks.RED_OAK_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_OAK_SAPLING));
    public static final Item RED_OAK_LEAVES = createItem(new BlockItem(BYGBlocks.RED_OAK_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_OAK_LEAVES));

    public static final Item RED_SPRUCE_SAPLING = createItem(new BlockItem(BYGBlocks.RED_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_SPRUCE_SAPLING));
    public static final Item RED_SPRUCE_LEAVES = createItem(new BlockItem(BYGBlocks.RED_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_SPRUCE_LEAVES));

    public static final Item YELLOW_BIRCH_SAPLING = createItem(new BlockItem(BYGBlocks.YELLOW_BIRCH_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_BIRCH_SAPLING));
    public static final Item YELLOW_BIRCH_LEAVES = createItem(new BlockItem(BYGBlocks.YELLOW_BIRCH_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_BIRCH_LEAVES));

    public static final Item YELLOW_SPRUCE_SAPLING = createItem(new BlockItem(BYGBlocks.YELLOW_SPRUCE_SAPLING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_SPRUCE_SAPLING));
    public static final Item YELLOW_SPRUCE_LEAVES = createItem(new BlockItem(BYGBlocks.YELLOW_SPRUCE_LEAVES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_SPRUCE_LEAVES));

    //Glowcane
    public static final Item BLUE_GLOWCANE_DUST = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "blue_glowcane_dust");
    public static final Item BLUE_GLOWCANE = createItem(new BlockItem(BYGBlocks.BLUE_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_GLOWCANE));
    public static final Item BLUE_GLOWCANE_BLOCK = createItem(new BlockItem(BYGBlocks.BLUE_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_GLOWCANE_BLOCK));

    public static final Item PINK_GLOWCANE_DUST = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "pink_glowcane_dust");
    public static final Item PINK_GLOWCANE = createItem(new BlockItem(BYGBlocks.PINK_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_GLOWCANE));
    public static final Item PINK_GLOWCANE_BLOCK = createItem(new BlockItem(BYGBlocks.PINK_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_GLOWCANE_BLOCK));

    public static final Item PURPLE_GLOWCANE_DUST = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "purple_glowcane_dust");
    public static final Item PURPLE_GLOWCANE = createItem(new BlockItem(BYGBlocks.PURPLE_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_GLOWCANE));
    public static final Item PURPLE_GLOWCANE_BLOCK = createItem(new BlockItem(BYGBlocks.PURPLE_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_GLOWCANE_BLOCK));

    public static final Item RED_GLOWCANE_DUST = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "red_glowcane_dust");
    public static final Item RED_GLOWCANE = createItem(new BlockItem(BYGBlocks.RED_GLOWCANE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_GLOWCANE));
    public static final Item RED_GLOWCANE_BLOCK = createItem(new BlockItem(BYGBlocks.RED_GLOWCANE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_GLOWCANE_BLOCK));

    //Glowshroom
    public static final Item BLUE_GLOWSHROOM = createItem(new BlockItem(BYGBlocks.BLUE_GLOWSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_GLOWSHROOM));
    public static final Item BLUE_GLOWSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.BLUE_GLOWSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_GLOWSHROOM_BLOCK));
    public static final Item PURPLE_GLOWSHROOM = createItem(new BlockItem(BYGBlocks.PURPLE_GLOWSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_GLOWSHROOM));
    public static final Item PURPLE_GLOWSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_GLOWSHROOM_BLOCK));
    public static final Item RED_GLOWSHROOM_STEM = createItem(new BlockItem(BYGBlocks.RED_GLOWSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_GLOWSHROOM_STEM));
    public static final Item YELLOW_GLOWSHROOM_STEM = createItem(new BlockItem(BYGBlocks.YELLOW_GLOWSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_GLOWSHROOM_STEM));

    //Nether
    public static final Item OVERGROWN_CRIMSON_BLACKSTONE = createItem(new BlockItem(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE));
    public static final Item TALL_CRIMSON_ROOTS = createItem(new BlockItem(BYGBlocks.TALL_CRIMSON_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_CRIMSON_ROOTS));
    public static final Item CRIMSON_BERRIES = createItem(new BlockNamedItem(BYGBlocks.CRIMSON_BERRY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(3).saturation(0.4f).build())), "crimson_berries");

    public static final Item WARPED_CACTUS = createItem(new BlockItem(BYGBlocks.WARPED_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WARPED_CACTUS));
    public static final Item WARPED_BUSH = createItem(new BlockItem(BYGBlocks.WARPED_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WARPED_BUSH));
    public static final Item WARPED_CORAL_BLOCK = createItem(new BlockItem(BYGBlocks.WARPED_CORAL_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WARPED_CORAL_BLOCK));
    public static final Item WARPED_CORAL = createItem(new BlockItem(BYGBlocks.WARPED_CORAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WARPED_CORAL));
    public static final Item WARPED_CORAL_FAN = createItem(new BlockItem(BYGBlocks.WARPED_CORAL_FAN, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WARPED_CORAL_FAN));
    public static final Item NYLIUM_SOUL_SAND = createItem(new BlockItem(BYGBlocks.NYLIUM_SOUL_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NYLIUM_SOUL_SAND));
    public static final Item NYLIUM_SOUL_SOIL = createItem(new BlockItem(BYGBlocks.NYLIUM_SOUL_SOIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NYLIUM_SOUL_SOIL));

    public static final Item FROST_MAGMA = createItem(new BlockItem(BYGBlocks.FROST_MAGMA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FROST_MAGMA));
    public static final Item SUBZERO_ASH = createItem(new BlockItem(BYGBlocks.SUBZERO_ASH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SUBZERO_ASH));
    public static final Item SUBZERO_ASH_BLOCK = createItem(new BlockItem(BYGBlocks.SUBZERO_ASH_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SUBZERO_ASH_BLOCK));

    public static final Item ANTHRACITE = createItem(new AnthraciteItem(new Item.Properties().group(BYGCreativeTab.creativeTab)), "anthracite");
    public static final Item ANTHRACITE_BLOCK = createItem(new AnthraciteBlockItem(BYGBlocks.ANTHRACITE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ANTHRACITE_BLOCK));
    public static final Item ANTHRACITE_ORE = createItem(new BlockItem(BYGBlocks.ANTHRACITE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ANTHRACITE_ORE));
    public static final Item BRIMSTONE = createItem(new BlockItem(BYGBlocks.BRIMSTONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BRIMSTONE));
    public static final Item BRIM_POWDER = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "brim_powder");
    public static final Item BORIC_CAMPFIRE = createItem(new BlockItem(BYGBlocks.BORIC_CAMPFIRE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BORIC_CAMPFIRE));
    public static final Item YELLOW_NETHER_BRICKS = createItem(new BlockItem(BYGBlocks.YELLOW_NETHER_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_NETHER_BRICKS));
    public static final Item YELLOW_NETHER_BRICK = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "yellow_nether_brick");
    public static final Item MAGMATIC_STONE = createItem(new BlockItem(BYGBlocks.MAGMATIC_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAGMATIC_STONE));

    public static final Item HANGING_BONE = createItem(new BlockItem(BYGBlocks.HANGING_BONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HANGING_BONE));
    public static final Item QUARTZ_CRYSTAL = createItem(new BlockItem(BYGBlocks.QUARTZ_CRYSTAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.QUARTZ_CRYSTAL));
    public static final Item QUARTZITE_SAND = createItem(new BlockItem(BYGBlocks.QUARTZITE_SAND, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.QUARTZITE_SAND));
    public static final Item RAW_QUARTZ_BLOCK = createItem(new BlockItem(BYGBlocks.RAW_QUARTZ_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RAW_QUARTZ_BLOCK));

    public static final Item WHALING_VINES = createItem(new BlockItem(BYGBlocks.WAILING_VINES, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WAILING_VINES));
    public static final Item WHALING_GRASS = createItem(new BlockItem(BYGBlocks.WAILING_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WAILING_GRASS));
    public static final Item SCORCHED_BUSH = createItem(new BlockItem(BYGBlocks.SCORCHED_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORCHED_BUSH));
    public static final Item SCORCHED_GRASS = createItem(new BlockItem(BYGBlocks.SCORCHED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SCORCHED_GRASS));

    public static final Item SOUL_SHROOM = createItem(new BlockItem(BYGBlocks.SOUL_SHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).effect(new EffectInstance(Effects.WEAKNESS, 200, 0), 1.0F).build())), Registry.BLOCK.getKey(BYGBlocks.SOUL_SHROOM));
    public static final Item SOUL_SHROOM_SPORE_END = createItem(new BlockItem(BYGBlocks.SOUL_SHROOM_SPORE_END, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOUL_SHROOM_SPORE_END));
    public static final Item SOUL_SHROOM_STEM = createItem(new BlockItem(BYGBlocks.SOUL_SHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOUL_SHROOM_STEM));
    public static final Item SOUL_SHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.SOUL_SHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SOUL_SHROOM_BLOCK));
    public static final Item DEATH_CAP = createItem(new BlockItem(BYGBlocks.DEATH_CAP, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).effect(new EffectInstance(Effects.WITHER, 200, 0), 1.0F).build())), Registry.BLOCK.getKey(BYGBlocks.DEATH_CAP));
    public static final Item DEATH_CAP_MUSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DEATH_CAP_MUSHROOM_BLOCK));

    public static final Item WEEPING_ROOTS = createItem(new BlockItem(BYGBlocks.WEEPING_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WEEPING_ROOTS));
    public static final Item NETHER_BRISTLE = createItem(new BlockItem(BYGBlocks.NETHER_BRISTLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NETHER_BRISTLE));
    public static final Item MYCELIUM_NETHERRACK = createItem(new BlockItem(BYGBlocks.MYCELIUM_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MYCELIUM_NETHERRACK));
    public static final Item OVERGROWN_NETHERRACK = createItem(new BlockItem(BYGBlocks.OVERGROWN_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.OVERGROWN_NETHERRACK));
    public static final Item MOSSY_NETHERRACK = createItem(new BlockItem(BYGBlocks.MOSSY_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MOSSY_NETHERRACK));

    public static final Item PERVADED_NETHERRACK = createItem(new BlockItem(BYGBlocks.PERVADED_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PERVADED_NETHERRACK));
    public static final Item GLOWSTONE_LANTERN = createItem(new BlockItem(BYGBlocks.GLOWSTONE_LANTERN, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GLOWSTONE_LANTERN));
    public static final Item GLOWSTONE_LAMP = createItem(new BlockItem(BYGBlocks.GLOWSTONE_LAMP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GLOWSTONE_LAMP));

    public static final Item SYTHIAN_NYLIUM = createItem(new BlockItem(BYGBlocks.SYTHIAN_NYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_NYLIUM));
    public static final Item SYTHIAN_ROOTS = createItem(new BlockItem(BYGBlocks.SYTHIAN_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_ROOTS));
    public static final Item SYTHIAN_SPROUT = createItem(new BlockItem(BYGBlocks.SYTHIAN_SPROUT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_SPROUT));
    public static final Item SYTHIAN_STALK_BLOCK = createItem(new BlockItem(BYGBlocks.SYTHIAN_STALK_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_STALK_BLOCK));
    public static final Item SYTHIAN_SCAFFOLDING = createItem(new ScaffoldingItem(BYGBlocks.SYTHIAN_SCAFFOLDING, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SYTHIAN_SCAFFOLDING));
    public static final Item HANGING_SYTHIAN_ROOTS = createItem(new BlockItem(BYGBlocks.HANGING_SYTHIAN_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HANGING_SYTHIAN_ROOTS));

    public static final Item EMBUR_NYLIUM = createItem(new BlockItem(BYGBlocks.EMBUR_NYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_NYLIUM));
    public static final Item EMBUR_SPROUTS = createItem(new BlockItem(BYGBlocks.EMBUR_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_SPROUTS));
    public static final Item EMBUR_ROOTS = createItem(new BlockItem(BYGBlocks.EMBUR_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_ROOTS));
    public static final Item TALL_EMBUR_ROOTS = createItem(new BlockItem(BYGBlocks.TALL_EMBUR_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_EMBUR_ROOTS));
    public static final Item EMBUR_LILY = createItem(new EmburLilyItem(BYGBlocks.EMBUR_LILY, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.EMBUR_LILY));

    public static final Item BLUE_NETHERRACK_BRICK = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "blue_nether_brick");
    public static final Item BLUE_NETHERRACK = createItem(new BlockItem(BYGBlocks.BLUE_NETHERRACK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_NETHERRACK));
    public static final Item BLUE_NETHERRACK_BRICKS = createItem(new BlockItem(BYGBlocks.BLUE_NETHERRACK_BRICKS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_NETHERRACK_BRICKS));


    //End
    public static final Item IVIS_PHYLIUM = createItem(new BlockItem(BYGBlocks.IVIS_PHYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.IVIS_PHYLIUM));
    public static final Item IVIS_ROOTS = createItem(new BlockItem(BYGBlocks.IVIS_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.IVIS_ROOTS));
    public static final Item IVIS_SPROUT = createItem(new BlockItem(BYGBlocks.IVIS_SPROUT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.IVIS_SPROUT));
    public static final Item ENDER_LILY = createItem(new EmburLilyItem(BYGBlocks.ENDER_LILY, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ENDER_LILY));

    public static final Item ETHER_PHYLIUM = createItem(new BlockItem(BYGBlocks.ETHER_PHYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_PHYLIUM));
    public static final Item ETHER_SOIL = createItem(new BlockItem(BYGBlocks.ETHER_SOIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_SOIL));
    public static final Item ETHER_STONE = createItem(new BlockItem(BYGBlocks.ETHER_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_STONE));
    public static final Item ETHER_STONE_SLAB = createItem(new BlockItem(BYGBlocks.ETHER_STONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_STONE_SLAB));
    public static final Item ETHER_STONE_STAIRS = createItem(new BlockItem(BYGBlocks.ETHER_STONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_STONE_STAIRS));
    public static final Item ETHER_STONE_WALL = createItem(new BlockItem(BYGBlocks.ETHER_STONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_STONE_WALL));

    public static final Item BULBIS_SPROUTS = createItem(new BlockItem(BYGBlocks.BULBIS_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_SPROUTS));
    public static final Item BULBIS_PHYCELIUM = createItem(new BlockItem(BYGBlocks.BULBIS_PHYCELIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BULBIS_PHYCELIUM));

    public static final Item LIGNITE_ORE = createItem(new BlockItem(BYGBlocks.LIGNITE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LIGNITE_ORE));
    public static final Item LIGNITE = createItem(new LigniteItem(new Item.Properties().group(BYGCreativeTab.creativeTab)), "lignite");
    public static final Item LIGNITE_BLOCK = createItem(new LigniteBlockItem(BYGBlocks.LIGNITE_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LIGNITE_BLOCK));

    public static final Item ETHER_FOLIAGE = createItem(new BlockItem(BYGBlocks.ETHER_FOLIAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_FOLIAGE));
    public static final Item TALL_ETHER_GRASS = createItem(new BlockItem(BYGBlocks.TALL_ETHER_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_ETHER_GRASS));
    public static final Item ETHER_GRASS = createItem(new BlockItem(BYGBlocks.ETHER_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_GRASS));
    public static final Item ETHER_BUSH = createItem(new BlockItem(BYGBlocks.ETHER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ETHER_BUSH));
    public static final Item THEREAL_BELLFLOWER = createItem(new BlockItem(BYGBlocks.THEREAL_BELLFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THEREAL_BELLFLOWER));

    public static final Item NIGHTSHADE_BERRIES = createItem(new BlockNamedItem(BYGBlocks.NIGHTSHADE_BERRY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(3).saturation(0.4f).build())), "nightshade_berries");
    public static final Item NIGHTSHADE_PHYLIUM = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_PHYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_PHYLIUM));
    public static final Item NIGHTSHADE_SPROUTS = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_SPROUTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_SPROUTS));
    public static final Item NIGHTSHADE_ROOTS = createItem(new BlockItem(BYGBlocks.NIGHTSHADE_ROOTS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.NIGHTSHADE_ROOTS));

    public static final Item PURPUR_STONE = createItem(new BlockItem(BYGBlocks.PURPUR_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPUR_STONE));
    public static final Item PURPUR_STONE_SLAB = createItem(new BlockItem(BYGBlocks.PURPUR_STONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPUR_STONE_SLAB));
    public static final Item PURPUR_STONE_STAIRS = createItem(new BlockItem(BYGBlocks.PURPUR_STONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPUR_STONE_STAIRS));
    public static final Item PURPUR_STONE_WALL = createItem(new BlockItem(BYGBlocks.PURPUR_STONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPUR_STONE_WALL));

    public static final Item ODDITY_CACTUS = createItem(new BlockItem(BYGBlocks.ODDITY_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ODDITY_CACTUS));
    public static final Item ODDITY_BUSH = createItem(new BlockItem(BYGBlocks.ODDITY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ODDITY_BUSH));

    public static final Item THERIUM_SHARD = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "therium_shard");
    public static final Item THERIUM_CRYSTAL = createItem(new BlockItem(BYGBlocks.THERIUM_CRYSTAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_CRYSTAL));
    public static final Item THERIUM_BLOCK = createItem(new BlockItem(BYGBlocks.THERIUM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_BLOCK));
    public static final Item CHISELED_THERIUM = createItem(new BlockItem(BYGBlocks.CHISELED_THERIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_THERIUM));
    public static final Item CHISELED_THERIUM_STAIRS = createItem(new BlockItem(BYGBlocks.CHISELED_THERIUM_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_THERIUM_STAIRS));
    public static final Item CHISELED_THERIUM_SLAB = createItem(new BlockItem(BYGBlocks.CHISELED_THERIUM_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_THERIUM_SLAB));
    public static final Item CHISELED_THERIUM_WALL = createItem(new BlockItem(BYGBlocks.CHISELED_THERIUM_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CHISELED_THERIUM_WALL));
    public static final Item SHINY_CHISELED_THERIUM = createItem(new BlockItem(BYGBlocks.SHINY_CHISELED_THERIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHINY_CHISELED_THERIUM));
    public static final Item SHINY_CHISELED_THERIUM_STAIRS = createItem(new BlockItem(BYGBlocks.SHINY_CHISELED_THERIUM_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHINY_CHISELED_THERIUM_STAIRS));
    public static final Item SHINY_CHISELED_THERIUM_SLAB = createItem(new BlockItem(BYGBlocks.SHINY_CHISELED_THERIUM_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHINY_CHISELED_THERIUM_SLAB));
    public static final Item SHINY_CHISELED_THERIUM_WALL = createItem(new BlockItem(BYGBlocks.SHINY_CHISELED_THERIUM_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHINY_CHISELED_THERIUM_WALL));
    public static final Item THERIUM_GLASS = createItem(new BlockItem(BYGBlocks.THERIUM_GLASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_GLASS));
    public static final Item THERIUM_GLASS_PANE = createItem(new BlockItem(BYGBlocks.THERIUM_GLASS_PANE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_GLASS_PANE));
    public static final Item THERIUM_LANTERN = createItem(new BlockItem(BYGBlocks.THERIUM_LANTERN, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_LANTERN));
    public static final Item THERIUM_LAMP = createItem(new BlockItem(BYGBlocks.THERIUM_LAMP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.THERIUM_LAMP));

    public static final Item VERMILION_SCULK_TENDRILS = createItem(new BlockItem(BYGBlocks.VERMILION_SCULK_TENDRILS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.VERMILION_SCULK_TENDRILS));
    public static final Item VERMILION_SCULK_GROWTH = createItem(new BlockItem(BYGBlocks.VERMILION_SCULK_GROWTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.VERMILION_SCULK_GROWTH));
    public static final Item VERMILION_SCULK = createItem(new BlockItem(BYGBlocks.VERMILION_SCULK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.VERMILION_SCULK));

    public static final Item SHULKREN_FUNGUS = createItem(new BlockItem(BYGBlocks.SHULKREN_FUNGUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHULKREN_FUNGUS));
    public static final Item SHULKREN_WART_BLOCK = createItem(new BlockItem(BYGBlocks.SHULKREN_WART_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHULKREN_WART_BLOCK));
    public static final Item SHULKREN_MOSS_BLANKET = createItem(new BlockItem(BYGBlocks.SHULKREN_MOSS_BLANKET, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHULKREN_MOSS_BLANKET));
    public static final Item SHULKREN_VINE = createItem(new BlockItem(BYGBlocks.SHULKREN_VINE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHULKREN_VINE));
    public static final Item SHULKREN_PHYLIUM = createItem(new BlockItem(BYGBlocks.SHULKREN_PHYLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHULKREN_PHYLIUM));
    public static final Item PURPLE_SHROOMLIGHT = createItem(new BlockItem(BYGBlocks.PURPLE_SHROOMLIGHT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_SHROOMLIGHT));

    public static final Item CRYPTIC_CAMPFIRE = createItem(new BlockItem(BYGBlocks.CRYPTIC_CAMPFIRE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_CAMPFIRE));
    public static final Item CRYPTIC_MAGMA_BLOCK = createItem(new BlockItem(BYGBlocks.CRYPTIC_MAGMA_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_MAGMA_BLOCK));
    public static final Item CRYPTIC_REDSTONE_ORE = createItem(new BlockItem(BYGBlocks.CRYPTIC_REDSTONE_ORE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_REDSTONE_ORE));
    public static final Item CRYPTIC_STONE = createItem(new BlockItem(BYGBlocks.CRYPTIC_STONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_STONE));
    public static final Item CRYPTIC_STONE_SLAB = createItem(new BlockItem(BYGBlocks.CRYPTIC_STONE_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_STONE_SLAB));
    public static final Item CRYPTIC_STONE_STAIRS = createItem(new BlockItem(BYGBlocks.CRYPTIC_STONE_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_STONE_STAIRS));
    public static final Item CRYPTIC_STONE_WALL = createItem(new BlockItem(BYGBlocks.CRYPTIC_STONE_WALL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_STONE_WALL));
    public static final Item CRYPTIC_VENT = createItem(new BlockItem(BYGBlocks.CRYPTIC_VENT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_VENT));
    public static final Item TALL_CRYPTIC_VENT = createItem(new BlockItem(BYGBlocks.TALL_CRYPTIC_VENT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_CRYPTIC_VENT));
    public static final Item CRYPTIC_BRAMBLE = createItem(new BlockItem(BYGBlocks.CRYPTIC_BRAMBLE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CRYPTIC_BRAMBLE));
    public static final Item CRYPTIC_BRAMBLE_BRANCH = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "cryptic_bramble_branch");

    //Ice
    public static final Item BLACK_ICE = createItem(new BlockItem(BYGBlocks.BLACK_ICE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_ICE));
    public static final Item PACKED_BLACK_ICE = createItem(new BlockItem(BYGBlocks.PACKED_BLACK_ICE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PACKED_BLACK_ICE));

    //Mushrooms
    public static final Item GREEN_MUSHSHROOM = createItem(new BlockItem(BYGBlocks.GREEN_MUSHROOM, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())), Registry.BLOCK.getKey(BYGBlocks.GREEN_MUSHROOM));
    public static final Item GREEN_MUSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.GREEN_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_MUSHROOM_BLOCK));
    public static final Item WEEPING_MILKCAP = createItem(new BlockItem(BYGBlocks.WEEPING_MILKCAP, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())), Registry.BLOCK.getKey(BYGBlocks.WEEPING_MILKCAP));
    public static final Item MILKCAP_MUSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.MILKCAP_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MILKCAP_MUSHROOM_BLOCK));
    public static final Item WOOD_BLEWIT = createItem(new BlockItem(BYGBlocks.WOOD_BLEWIT, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())), Registry.BLOCK.getKey(BYGBlocks.WOOD_BLEWIT));
    public static final Item BLEWIT_MUSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.BLEWIT_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLEWIT_MUSHROOM_BLOCK));
    public static final Item BLACK_PUFF = createItem(new BlockItem(BYGBlocks.BLACK_PUFF, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.6f).build())), Registry.BLOCK.getKey(BYGBlocks.BLACK_PUFF));
    public static final Item PUFF_MUSHROOM_BLOCK = createItem(new BlockItem(BYGBlocks.PUFF_MUSHROOM_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PUFF_MUSHROOM_BLOCK));
    public static final Item WHITE_MUSHROOM_STEM = createItem(new BlockItem(BYGBlocks.WHITE_MUSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_MUSHROOM_STEM));
    public static final Item BROWN_MUSHROOM_STEM = createItem(new BlockItem(BYGBlocks.BROWN_MUSHROOM_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BROWN_MUSHROOM_STEM));

    //Plants
    public static final Item BLUE_BERRY = createItem(new BlockNamedItem(BYGBlocks.BLUEBERRY_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab).food(new Food.Builder().hunger(2).saturation(0.1f).effect(new EffectInstance(Effects.SPEED, 200, 0), 1.0F).build())), "blueberries");
    public static final Item CATTAIL = createItem(new BlockItem(BYGBlocks.CATTAIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CATTAIL));
    public static final Item GOLDEN_SPINED_CACTUS = createItem(new BlockItem(BYGBlocks.GOLDEN_SPINED_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GOLDEN_SPINED_CACTUS));
    public static final Item HORSEWEED = createItem(new BlockItem(BYGBlocks.HORSEWEED, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.HORSEWEED));
    public static final Item MINI_CACTUS = createItem(new BlockItem(BYGBlocks.MINI_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MINI_CACTUS));
    public static final Item POISON_IVY = createItem(new BlockItem(BYGBlocks.POISON_IVY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POISON_IVY));
    public static final Item PRICKLY_PEAR_CACTUS = createItem(new BlockItem(BYGBlocks.PRICKLY_PEAR_CACTUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PRICKLY_PEAR_CACTUS));
    public static final Item PRAIRIE_GRASS = createItem(new BlockItem(BYGBlocks.PRAIRIE_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PRAIRIE_GRASS));
    public static final Item REEDS = createItem(new BlockItem(BYGBlocks.REEDS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REEDS));
    public static final Item REED_THATCH = createItem(new BlockItem(BYGBlocks.REED_THATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REED_THATCH));
    public static final Item REED_THATCH_STAIRS = createItem(new BlockItem(BYGBlocks.REED_THATCH_STAIRS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REED_THATCH_STAIRS));
    public static final Item REED_THATCH_CARPET = createItem(new BlockItem(BYGBlocks.REED_THATCH_CARPET, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REED_THATCH_CARPET));
    public static final Item REED_THATCH_SLAB = createItem(new BlockItem(BYGBlocks.REED_THATCH_SLAB, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.REED_THATCH_SLAB));

    public static final Item SHORT_GRASS = createItem(new BlockItem(BYGBlocks.SHORT_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHORT_GRASS));
    public static final Item TALL_PRAIRIE_GRASS = createItem(new BlockItem(BYGBlocks.TALL_PRAIRIE_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_PRAIRIE_GRASS));
    public static final Item TINY_LILYPADS = createItem(new BYGLilyItem(BYGBlocks.TINY_LILYPADS, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TINY_LILYPADS));
    public static final Item WATER_SILK = createItem(new BYGWaterSilkItem(BYGBlocks.WATER_SILK, (new Item.Properties()).group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WATER_SILK));
    public static final Item WINTER_SUCCULENT = createItem(new BlockItem(BYGBlocks.WINTER_SUCCULENT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WINTER_SUCCULENT));

    public static final Item WINTER_GRASS = createItem(new BlockItem(BYGBlocks.WINTER_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WINTER_GRASS));
    public static final Item WEED_GRASS = createItem(new BlockItem(BYGBlocks.WEED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WEED_GRASS));
    public static final Item WILTED_GRASS = createItem(new BlockItem(BYGBlocks.WILTED_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WILTED_GRASS));
    public static final Item SHORT_BEACH_GRASS = createItem(new BlockItem(BYGBlocks.SHORT_BEACH_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SHORT_BEACH_GRASS));
    public static final Item BEACH_GRASS = createItem(new BlockItem(BYGBlocks.BEACH_GRASS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BEACH_GRASS));
    public static final Item LEAF_PILE = createItem(new BlockItem(BYGBlocks.LEAF_PILE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LEAF_PILE));
    public static final Item CLOVER_PATCH = createItem(new BlockItem(BYGBlocks.CLOVER_PATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CLOVER_PATCH));
    public static final Item FLOWER_PATCH = createItem(new BlockItem(BYGBlocks.FLOWER_PATCH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FLOWER_PATCH));


    //Petal Blocks
    public static final Item WHITE_PETAL = createItem(new BlockItem(BYGBlocks.WHITE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_PETAL));
    public static final Item BLUE_PETAL = createItem(new BlockItem(BYGBlocks.BLUE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_PETAL));
    public static final Item LIGHT_BLUE_PETAL = createItem(new BlockItem(BYGBlocks.LIGHT_BLUE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LIGHT_BLUE_PETAL));
    public static final Item PURPLE_PETAL = createItem(new BlockItem(BYGBlocks.PURPLE_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_PETAL));
    public static final Item RED_PETAL = createItem(new BlockItem(BYGBlocks.RED_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_PETAL));
    public static final Item YELLOW_PETAL = createItem(new BlockItem(BYGBlocks.YELLOW_PETAL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_PETAL));
    public static final Item PLANT_STEM = createItem(new BlockItem(BYGBlocks.PLANT_STEM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PLANT_STEM));
    public static final Item POLLEN_BLOCK = createItem(new BlockItem(BYGBlocks.POLLEN_BLOCK, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.POLLEN_BLOCK));
    public static final Item POLLEN_DUST = createItem(new Item(new Item.Properties().group(BYGCreativeTab.creativeTab)), "pollen_dust");

    //FlowerItems
    public static final Item ALLIUM_FLOWER_BUSH = createItem(new BlockItem(BYGBlocks.ALLIUM_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ALLIUM_FLOWER_BUSH));
    public static final Item TALL_ALLIUM = createItem(new BlockItem(BYGBlocks.TALL_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_ALLIUM));
    public static final Item ALPINE_BELLFLOWER = createItem(new BlockItem(BYGBlocks.ALPINE_BELLFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ALPINE_BELLFLOWER));
    public static final Item AMARANTH = createItem(new BlockItem(BYGBlocks.AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.AMARANTH));
    public static final Item ANGELICA = createItem(new BlockItem(BYGBlocks.ANGELICA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ANGELICA));
    public static final Item AZALEA = createItem(new BlockItem(BYGBlocks.AZALEA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.AZALEA));
    public static final Item BEGONIA = createItem(new BlockItem(BYGBlocks.BEGONIA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BEGONIA));
    public static final Item BISTORT = createItem(new BlockItem(BYGBlocks.BISTORT, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BISTORT));
    public static final Item BLACK_ROSE = createItem(new BlockItem(BYGBlocks.BLACK_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLACK_ROSE));
    public static final Item BLUE_SAGE = createItem(new BlockItem(BYGBlocks.BLUE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.BLUE_SAGE));
    public static final Item CALIFORNIA_POPPY = createItem(new BlockItem(BYGBlocks.CALIFORNIA_POPPY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CALIFORNIA_POPPY));
    public static final Item CROCUS = createItem(new BlockItem(BYGBlocks.CROCUS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CROCUS));
    public static final Item CYAN_AMARANTH = createItem(new BlockItem(BYGBlocks.CYAN_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYAN_AMARANTH));
    public static final Item CYAN_ROSE = createItem(new BlockItem(BYGBlocks.CYAN_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYAN_ROSE));
    public static final Item CYAN_TULIP = createItem(new BlockItem(BYGBlocks.CYAN_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.CYAN_TULIP));
    public static final Item DAFFODIL = createItem(new BlockItem(BYGBlocks.DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DAFFODIL));
    public static final Item DELPHINIUM = createItem(new BlockItem(BYGBlocks.DELPHINIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.DELPHINIUM));
    public static final Item FAIRY_SLIPPER = createItem(new BlockItem(BYGBlocks.FAIRY_SLIPPER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FAIRY_SLIPPER));
    public static final Item FIRECRACKER_FLOWER_BUSH = createItem(new BlockItem(BYGBlocks.FIRECRACKER_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FIRECRACKER_FLOWER_BUSH));
    public static final Item FOXGLOVE = createItem(new BlockItem(BYGBlocks.FOXGLOVE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.FOXGLOVE));
    public static final Item GREEN_TULIP = createItem(new BlockItem(BYGBlocks.GREEN_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GREEN_TULIP));
    public static final Item GUZMANIA = createItem(new BlockItem(BYGBlocks.GUZMANIA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.GUZMANIA));
    public static final Item INCAN_LILY = createItem(new BlockItem(BYGBlocks.INCAN_LILY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.INCAN_LILY));
    public static final Item IRIS = createItem(new BlockItem(BYGBlocks.IRIS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.IRIS));
    public static final Item JAPANESE_ORCHID = createItem(new BlockItem(BYGBlocks.JAPANESE_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.JAPANESE_ORCHID));
    public static final Item KOVAN_FLOWER = createItem(new BlockItem(BYGBlocks.KOVAN_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.KOVAN_FLOWER));
    public static final Item LAZARUS_BELLFLOWER = createItem(new BlockItem(BYGBlocks.LAZARUS_BELLFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LAZARUS_BELLFLOWER));
    public static final Item LOLIPOP_FLOWER = createItem(new BlockItem(BYGBlocks.LOLIPOP_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.LOLIPOP_FLOWER));
    public static final Item MAGENTA_AMARANTH = createItem(new BlockItem(BYGBlocks.MAGENTA_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAGENTA_AMARANTH));
    public static final Item MAGENTA_TULIP = createItem(new BlockItem(BYGBlocks.MAGENTA_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.MAGENTA_TULIP));
    public static final Item ORANGE_AMARANTH = createItem(new BlockItem(BYGBlocks.ORANGE_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_AMARANTH));
    public static final Item ORANGE_DAISY = createItem(new BlockItem(BYGBlocks.ORANGE_DAISY, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORANGE_DAISY));
    public static final Item ORSIRIA_ROSE = createItem(new BlockItem(BYGBlocks.ORSIRIA_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ORSIRIA_ROSE));
    public static final Item PEACH_LEATHER_FLOWER = createItem(new BlockItem(BYGBlocks.PEACH_LEATHER_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PEACH_LEATHER_FLOWER));
    public static final Item PINK_ALLIUM = createItem(new BlockItem(BYGBlocks.PINK_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_ALLIUM));
    public static final Item PINK_ALLIUM_FLOWER_BUSH = createItem(new BlockItem(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH));
    public static final Item TALL_PINK_ALLIUM = createItem(new BlockItem(BYGBlocks.TALL_PINK_ALLIUM, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TALL_PINK_ALLIUM));
    public static final Item PINK_ANEMONE = createItem(new BlockItem(BYGBlocks.PINK_ANEMONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_ANEMONE));
    public static final Item PINK_DAFFODIL = createItem(new BlockItem(BYGBlocks.PINK_DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_DAFFODIL));
    public static final Item PINK_ORCHID = createItem(new BlockItem(BYGBlocks.PINK_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PINK_ORCHID));
    public static final Item PROTEA_FLOWER = createItem(new BlockItem(BYGBlocks.PROTEA_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PROTEA_FLOWER));
    public static final Item PURPLE_AMARANTH = createItem(new BlockItem(BYGBlocks.PURPLE_AMARANTH, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_AMARANTH));
    public static final Item PURPLE_ORCHID = createItem(new BlockItem(BYGBlocks.PURPLE_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_ORCHID));
    public static final Item PURPLE_SAGE = createItem(new BlockItem(BYGBlocks.PURPLE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_SAGE));
    public static final Item PURPLE_TULIP = createItem(new BlockItem(BYGBlocks.PURPLE_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.PURPLE_TULIP));
    public static final Item RED_CORNFLOWER = createItem(new BlockItem(BYGBlocks.RED_CORNFLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_CORNFLOWER));
    public static final Item RED_ORCHID = createItem(new BlockItem(BYGBlocks.RED_ORCHID, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RED_ORCHID));
    public static final Item RICHEA = createItem(new BlockItem(BYGBlocks.RICHEA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.RICHEA));
    public static final Item ROSE = createItem(new BlockItem(BYGBlocks.ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.ROSE));
    public static final Item SILVER_VASE_FLOWER = createItem(new BlockItem(BYGBlocks.SILVER_VASE_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SILVER_VASE_FLOWER));
    public static final Item SNOWDROPS = createItem(new BlockItem(BYGBlocks.SNOWDROPS, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.SNOWDROPS));
    public static final Item TORCH_GINGER = createItem(new BlockItem(BYGBlocks.TORCH_GINGER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.TORCH_GINGER));
    public static final Item VIOLET_LEATHER_FLOWER = createItem(new BlockItem(BYGBlocks.VIOLET_LEATHER_FLOWER, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.VIOLET_LEATHER_FLOWER));
    public static final Item WHITE_ANEMONE = createItem(new BlockItem(BYGBlocks.WHITE_ANEMONE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_ANEMONE));
    public static final Item WHITE_SAGE = createItem(new BlockItem(BYGBlocks.WHITE_SAGE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WHITE_SAGE));
    public static final Item WINTER_CYCLAMEN = createItem(new BlockItem(BYGBlocks.WINTER_CYCLAMEN, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WINTER_CYCLAMEN));
    public static final Item WINTER_ROSE = createItem(new BlockItem(BYGBlocks.WINTER_ROSE, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WINTER_ROSE));
    public static final Item WINTER_SCILLA = createItem(new BlockItem(BYGBlocks.WINTER_SCILLA, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.WINTER_SCILLA));
    public static final Item YELLOW_DAFFODIL = createItem(new BlockItem(BYGBlocks.YELLOW_DAFFODIL, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_DAFFODIL));
    public static final Item YELLOW_TULIP = createItem(new BlockItem(BYGBlocks.YELLOW_TULIP, new Item.Properties().group(BYGCreativeTab.creativeTab)), Registry.BLOCK.getKey(BYGBlocks.YELLOW_TULIP));

    public static Item createItem(Item item, ResourceLocation id) {
        if (id != null && !id.equals(new ResourceLocation("minecraft:air"))) {
//            Registry.register(Registry.ITEM, id, item);
            item.setRegistryName(id); //Forge
            itemsList.add(item);
            return item;
        } else {
            return null;
        }
    }

    public static Item createItem(Item item, String id) {
//        Registry.register(Registry.ITEM, new ResourceLocation(BYG.MOD_ID, id), item);
        item.setRegistryName(new ResourceLocation(BYG.MOD_ID, id)); //Forge
        itemsList.add(item);
        return item;
    }

    public static void init() {
    }
}
