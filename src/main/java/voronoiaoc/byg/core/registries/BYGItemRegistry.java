package voronoiaoc.byg.core.registries;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.entity.boat.BYGBoatEntity;
import voronoiaoc.byg.common.properties.items.*;
import voronoiaoc.byg.common.properties.items.itemtiers.BYGArmorTiers;
import voronoiaoc.byg.common.properties.items.itemtiers.BYGItemTiers;
import voronoiaoc.byg.common.properties.items.itemtiers.BYGTools;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGItemList;


public class BYGItemRegistry {
    public static void registerItems() {

        registerItem(BYGItemList.BYG_LOGO = new Item((new Item.Settings())), new Identifier(BYG.MODID, "byg_logo"));

//                registerItem(BYGItemList.SONORAN_CACTUS = new BlockItem(BYGBlockList.SONORAN_CACTUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SONORAN_CACTUS));

        registerItem(BYGItemList.PEAT = new BlockItem(BYGBlockList.PEAT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PEAT));
        registerItem(BYGItemList.MEADOW_GRASSBLOCK = new BlockItem(BYGBlockList.MEADOW_GRASSBLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MEADOW_GRASSBLOCK));
        registerItem(BYGItemList.GLOWCELIUM = new BlockItem(BYGBlockList.GLOWCELIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GLOWCELIUM));
        registerItem(BYGItemList.MEADOW_DIRT = new BlockItem(BYGBlockList.MEADOW_DIRT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MEADOW_DIRT));
        registerItem(BYGItemList.MUD_BLOCK = new BlockItem(BYGBlockList.MUD_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MUD_BLOCK));
        registerItem(BYGItemList.MUD_BRICKS = new BlockItem(BYGBlockList.MUD_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MUD_BRICKS));

        registerItem(BYGItemList.CHAIN_PLATING = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "chain_plating"));

        registerItem(BYGItemList.AMETRINE_GEMS = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_gems"));
        registerItem(BYGItemList.AMETRINE_ORE = new BlockItem(BYGBlockList.AMETRINE_ORE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.AMETRINE_ORE));
        registerItem(BYGItemList.AMETRINE_BLOCK = new BlockItem(BYGBlockList.AMETRINE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.AMETRINE_BLOCK));
        registerItem(BYGItemList.AMETRINE_HELMET = new ArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlot.HEAD, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_helmet"));
        registerItem(BYGItemList.AMETRINE_CHEST = new ArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlot.CHEST, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_chestplate"));
        registerItem(BYGItemList.AMETRINE_LEGGINGS = new ArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlot.LEGS, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_leggings"));
        registerItem(BYGItemList.AMETRINE_BOOTS = new ArmorItem(BYGArmorTiers.AMETRINE, EquipmentSlot.FEET, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_boots"));
//                registerItem(BYGItemList.AMETRINE_SHIELD = new ShieldItem(new Item.Settings().maxDamage(1000).group(BYGItemGroup.COMBAT)), Registry.BLOCK.getId("ametrine_blue_shields");
        registerItem(BYGItemList.AMETRINE_HORSE_ARMOR = new BYGHorseArmor(7, "ametrine", (new Item.Settings()).maxCount(1).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "ametrine_horse_armor"));

        registerItem(BYGItemList.PENDORITE_SCRAPS = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_scraps"));
        registerItem(BYGItemList.PENDORITE_ORE = new BlockItem(BYGBlockList.PENDORITE_ORE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PENDORITE_ORE));
        registerItem(BYGItemList.PENDORITE_BLOCK = new BlockItem(BYGBlockList.PENDORITE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PENDORITE_BLOCK));
        registerItem(BYGItemList.PENDORITE_AXE = new BYGTools.AxeItemBYG(BYGItemTiers.PENDORITE, 6.0f, -3.0F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_axe"));
        registerItem(BYGItemList.PENDORITE_PICK = new BYGTools.PickaxeItemBYG(BYGItemTiers.PENDORITE, 2, -2.8F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_pickaxe"));
        registerItem(BYGItemList.PENDORITE_SWORD = new SwordItem(BYGItemTiers.PENDORITE, 4, -2.4F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_sword"));
        registerItem(BYGItemList.PENDORITE_BATTLEAXE = new BYGTools.AxeItemBYG(BYGItemTiers.PENDORITE, 9.0f, -3.3F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_battleaxe"));
        registerItem(BYGItemList.PENDORITE_SHOVEL = new ShovelItem(BYGItemTiers.PENDORITE, 2.0F, -3.0F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_shovel"));
        registerItem(BYGItemList.PENDORITE_HOE = new BYGTools.HoeItemBYG(BYGItemTiers.PENDORITE, 0, -2.4F, (new Item.Settings()).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_hoe"));
//                registerItem(BYGItemList.PENDORITE_SHIELD = new ShieldItem(new Item.Settings().maxDamage(1000).group(BYGItemGroup.COMBAT)), Registry.BLOCK.getId("pendorite_shield");
        registerItem(BYGItemList.PENDORITE_HORSE_ARMOR = new BYGHorseArmor(7, "pendorite", (new Item.Settings()).maxCount(1).group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pendorite_horse_armor"));

        registerItem(BYGItemList.DACITE = new BlockItem(BYGBlockList.DACITE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE));
        registerItem(BYGItemList.DACITE_STAIRS = new BlockItem(BYGBlockList.DACITE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_STAIRS));
        registerItem(BYGItemList.DACITE_SLAB = new BlockItem(BYGBlockList.DACITE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_SLAB));
        registerItem(BYGItemList.DACITE_WALL = new BlockItem(BYGBlockList.DACITE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_WALL));

        registerItem(BYGItemList.DACITE_BRICKS = new BlockItem(BYGBlockList.DACITE_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_BRICKS));
        registerItem(BYGItemList.DACITE_BRICK_STAIRS = new BlockItem(BYGBlockList.DACITE_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_BRICK_STAIRS));
        registerItem(BYGItemList.DACITE_BRICK_SLAB = new BlockItem(BYGBlockList.DACITE_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_BRICK_SLAB));
        registerItem(BYGItemList.DACITE_BRICK_WALL = new BlockItem(BYGBlockList.DACITE_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_BRICK_WALL));

        registerItem(BYGItemList.DACITE_COBBLESTONE = new BlockItem(BYGBlockList.DACITE_COBBLESTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_COBBLESTONE));
        registerItem(BYGItemList.DACITE_COBBLESTONE_STAIRS = new BlockItem(BYGBlockList.DACITE_COBBLESTONE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_COBBLESTONE_STAIRS));
        registerItem(BYGItemList.DACITE_COBBLESTONE_SLAB = new BlockItem(BYGBlockList.DACITE_COBBLESTONE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_COBBLESTONE_SLAB));
        registerItem(BYGItemList.DACITE_COBBLESTONE_WALL = new BlockItem(BYGBlockList.DACITE_COBBLESTONE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_COBBLESTONE_WALL));

        registerItem(BYGItemList.DACITE_PILLAR = new BlockItem(BYGBlockList.DACITE_PILLAR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_PILLAR));
        registerItem(BYGItemList.DACITE_TILE = new BlockItem(BYGBlockList.DACITE_TILE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_TILE));
        registerItem(BYGItemList.DACITE_TILE_STAIRS = new BlockItem(BYGBlockList.DACITE_TILE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_TILE_STAIRS));
        registerItem(BYGItemList.DACITE_TILE_SLAB = new BlockItem(BYGBlockList.DACITE_TILE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_TILE_SLAB));
        registerItem(BYGItemList.DACITE_TILE_WALL = new BlockItem(BYGBlockList.DACITE_TILE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_TILE_WALL));

        registerItem(BYGItemList.MOSSY_STONE = new BlockItem(BYGBlockList.MOSSY_STONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_STONE));
        registerItem(BYGItemList.MOSSY_STONE_STAIRS = new BlockItem(BYGBlockList.MOSSY_STONE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_STONE_STAIRS));
        registerItem(BYGItemList.MOSSY_STONE_SLAB = new BlockItem(BYGBlockList.MOSSY_STONE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_STONE_SLAB));
        registerItem(BYGItemList.MOSSY_STONE_WALL = new BlockItem(BYGBlockList.MOSSY_STONE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_STONE_WALL));

        registerItem(BYGItemList.PODZOL_DACITE = new BlockItem(BYGBlockList.PODZOL_DACITE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PODZOL_DACITE));
        registerItem(BYGItemList.OVERGROWN_DACITE = new BlockItem(BYGBlockList.OVERGROWN_DACITE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.OVERGROWN_DACITE));
        //registerItem(BYGItemList.DACITE_FARMLAND = new BlockItem(BYGBlockList.DACITE_FARMLAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DACITE_FARMLAND));
        registerItem(BYGItemList.OVERGROWN_STONE = new BlockItem(BYGBlockList.OVERGROWN_STONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.OVERGROWN_STONE));
        //registerItem(BYGItemList.STONE_FARMLAND = new BlockItem(BYGBlockList.STONE_FARMLAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STONE_FARMLAND));

        registerItem(BYGItemList.RED_ROCK = new BlockItem(BYGBlockList.RED_ROCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK));
        registerItem(BYGItemList.RED_ROCK_STAIRS = new BlockItem(BYGBlockList.RED_ROCK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_STAIRS));
        registerItem(BYGItemList.RED_ROCK_SLAB = new BlockItem(BYGBlockList.RED_ROCK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_SLAB));
        registerItem(BYGItemList.RED_ROCK_WALL = new BlockItem(BYGBlockList.RED_ROCK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_WALL));

        registerItem(BYGItemList.RED_ROCK_BRICKS = new BlockItem(BYGBlockList.RED_ROCK_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_BRICKS));
        registerItem(BYGItemList.RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlockList.RED_ROCK_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_BRICK_STAIRS));
        registerItem(BYGItemList.RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlockList.RED_ROCK_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_BRICK_SLAB));
        registerItem(BYGItemList.RED_ROCK_BRICK_WALL = new BlockItem(BYGBlockList.RED_ROCK_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ROCK_BRICK_WALL));

        registerItem(BYGItemList.MOSSY_RED_ROCK_BRICKS = new BlockItem(BYGBlockList.MOSSY_RED_ROCK_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_RED_ROCK_BRICKS));
        registerItem(BYGItemList.MOSSY_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlockList.MOSSY_RED_ROCK_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_RED_ROCK_BRICK_STAIRS));
        registerItem(BYGItemList.MOSSY_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlockList.MOSSY_RED_ROCK_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_RED_ROCK_BRICK_SLAB));
        registerItem(BYGItemList.MOSSY_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlockList.MOSSY_RED_ROCK_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MOSSY_RED_ROCK_BRICK_WALL));

        registerItem(BYGItemList.CHISELED_RED_ROCK_BRICKS = new BlockItem(BYGBlockList.CHISELED_RED_ROCK_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHISELED_RED_ROCK_BRICKS));
        registerItem(BYGItemList.CHISELED_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlockList.CHISELED_RED_ROCK_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHISELED_RED_ROCK_BRICK_STAIRS));
        registerItem(BYGItemList.CHISELED_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlockList.CHISELED_RED_ROCK_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHISELED_RED_ROCK_BRICK_SLAB));
        registerItem(BYGItemList.CHISELED_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlockList.CHISELED_RED_ROCK_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHISELED_RED_ROCK_BRICK_WALL));

        registerItem(BYGItemList.CRACKED_RED_ROCK_BRICKS = new BlockItem(BYGBlockList.CRACKED_RED_ROCK_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CRACKED_RED_ROCK_BRICKS));
        registerItem(BYGItemList.CRACKED_RED_ROCK_BRICK_STAIRS = new BlockItem(BYGBlockList.CRACKED_RED_ROCK_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CRACKED_RED_ROCK_BRICK_STAIRS));
        registerItem(BYGItemList.CRACKED_RED_ROCK_BRICK_SLAB = new BlockItem(BYGBlockList.CRACKED_RED_ROCK_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CRACKED_RED_ROCK_BRICK_SLAB));
        registerItem(BYGItemList.CRACKED_RED_ROCK_BRICK_WALL = new BlockItem(BYGBlockList.CRACKED_RED_ROCK_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CRACKED_RED_ROCK_BRICK_WALL));


        registerItem(BYGItemList.ROCKY_STONE = new BlockItem(BYGBlockList.ROCKY_STONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ROCKY_STONE));
        registerItem(BYGItemList.ROCKY_STAIRS = new BlockItem(BYGBlockList.ROCKY_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ROCKY_STAIRS));
        registerItem(BYGItemList.ROCKY_SLAB = new BlockItem(BYGBlockList.ROCKY_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ROCKY_SLAB));
        registerItem(BYGItemList.ROCKY_WALL = new BlockItem(BYGBlockList.ROCKY_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ROCKY_WALL));

        registerItem(BYGItemList.SCORIA_STONE = new BlockItem(BYGBlockList.SCORIA_STONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STONE));
        registerItem(BYGItemList.SCORIA_STAIRS = new BlockItem(BYGBlockList.SCORIA_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STAIRS));
        registerItem(BYGItemList.SCORIA_SLAB = new BlockItem(BYGBlockList.SCORIA_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_SLAB));
        registerItem(BYGItemList.SCORIA_WALL = new BlockItem(BYGBlockList.SCORIA_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_WALL));

        registerItem(BYGItemList.SCORIA_COBBLESTONE = new BlockItem(BYGBlockList.SCORIA_COBBLESTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_COBBLESTONE));
        registerItem(BYGItemList.SCORIA_COBBLESTONE_STAIRS = new BlockItem(BYGBlockList.SCORIA_COBBLESTONE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_COBBLESTONE_STAIRS));
        registerItem(BYGItemList.SCORIA_COBBLESTONE_SLAB = new BlockItem(BYGBlockList.SCORIA_COBBLESTONE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_COBBLESTONE_SLAB));
        registerItem(BYGItemList.SCORIA_COBBLESTONE_WALL = new BlockItem(BYGBlockList.SCORIA_COBBLESTONE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_COBBLESTONE_WALL));

        registerItem(BYGItemList.SCORIA_PILLAR = new BlockItem(BYGBlockList.SCORIA_PILLAR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_PILLAR));
        registerItem(BYGItemList.SCORIA_STONEBRICKS = new BlockItem(BYGBlockList.SCORIA_STONEBRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STONEBRICKS));
        registerItem(BYGItemList.SCORIA_STONEBRICK_STAIRS = new BlockItem(BYGBlockList.SCORIA_STONEBRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STONEBRICK_STAIRS));
        registerItem(BYGItemList.SCORIA_STONEBRICK_SLAB = new BlockItem(BYGBlockList.SCORIA_STONEBRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STONEBRICK_SLAB));
        registerItem(BYGItemList.SCORIA_STONEBRICK_WALL = new BlockItem(BYGBlockList.SCORIA_STONEBRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SCORIA_STONEBRICK_WALL));

        registerItem(BYGItemList.SOAPSTONE = new BlockItem(BYGBlockList.SOAPSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE));
        registerItem(BYGItemList.SOAPSTONE_STAIRS = new BlockItem(BYGBlockList.SOAPSTONE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_STAIRS));
        registerItem(BYGItemList.SOAPSTONE_SLAB = new BlockItem(BYGBlockList.SOAPSTONE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_SLAB));
        registerItem(BYGItemList.SOAPSTONE_WALL = new BlockItem(BYGBlockList.SOAPSTONE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_WALL));

        registerItem(BYGItemList.POLISHED_SOAPSTONE = new BlockItem(BYGBlockList.POLISHED_SOAPSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POLISHED_SOAPSTONE));
        registerItem(BYGItemList.POLISHED_SOAPSTONE_STAIRS = new BlockItem(BYGBlockList.POLISHED_SOAPSTONE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POLISHED_SOAPSTONE_STAIRS));
        registerItem(BYGItemList.POLISHED_SOAPSTONE_SLAB = new BlockItem(BYGBlockList.POLISHED_SOAPSTONE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POLISHED_SOAPSTONE_SLAB));
        registerItem(BYGItemList.POLISHED_SOAPSTONE_WALL = new BlockItem(BYGBlockList.POLISHED_SOAPSTONE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POLISHED_SOAPSTONE_WALL));

        registerItem(BYGItemList.SOAPSTONE_BRICKS = new BlockItem(BYGBlockList.SOAPSTONE_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_BRICKS));
        registerItem(BYGItemList.SOAPSTONE_BRICK_STAIRS = new BlockItem(BYGBlockList.SOAPSTONE_BRICK_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_BRICK_STAIRS));
        registerItem(BYGItemList.SOAPSTONE_BRICK_SLAB = new BlockItem(BYGBlockList.SOAPSTONE_BRICK_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_BRICK_SLAB));
        registerItem(BYGItemList.SOAPSTONE_BRICK_WALL = new BlockItem(BYGBlockList.SOAPSTONE_BRICK_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_BRICK_WALL));

        registerItem(BYGItemList.SOAPSTONE_PILLAR = new BlockItem(BYGBlockList.SOAPSTONE_PILLAR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_PILLAR));
        registerItem(BYGItemList.SOAPSTONE_TILE = new BlockItem(BYGBlockList.SOAPSTONE_TILE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_TILE));
        registerItem(BYGItemList.SOAPSTONE_TILE_STAIRS = new BlockItem(BYGBlockList.SOAPSTONE_TILE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_TILE_STAIRS));
        registerItem(BYGItemList.SOAPSTONE_TILE_SLAB = new BlockItem(BYGBlockList.SOAPSTONE_TILE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_TILE_SLAB));
        registerItem(BYGItemList.SOAPSTONE_TILE_WALL = new BlockItem(BYGBlockList.SOAPSTONE_TILE_WALL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SOAPSTONE_TILE_WALL));

        registerItem(BYGItemList.BLACK_SAND = new BlockItem(BYGBlockList.BLACK_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_SAND));
        registerItem(BYGItemList.BLACK_SANDSTONE = new BlockItem(BYGBlockList.BLACK_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_SANDSTONE));
        registerItem(BYGItemList.BLACK_CHISELED_SANDSTONE = new BlockItem(BYGBlockList.BLACK_CHISELED_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_CHISELED_SANDSTONE));
        registerItem(BYGItemList.BLACK_CUT_SANDSTONE = new BlockItem(BYGBlockList.BLACK_CUT_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_CUT_SANDSTONE));
        registerItem(BYGItemList.BLACK_SMOOTH_SANDSTONE = new BlockItem(BYGBlockList.BLACK_SMOOTH_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_SMOOTH_SANDSTONE));

        registerItem(BYGItemList.WHITE_SAND = new BlockItem(BYGBlockList.WHITE_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_SAND));
        registerItem(BYGItemList.WHITE_SANDSTONE = new BlockItem(BYGBlockList.WHITE_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_SANDSTONE));
        registerItem(BYGItemList.WHITE_CHISELED_SANDSTONE = new BlockItem(BYGBlockList.WHITE_CHISELED_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_CHISELED_SANDSTONE));
        registerItem(BYGItemList.WHITE_CUT_SANDSTONE = new BlockItem(BYGBlockList.WHITE_CUT_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_CUT_SANDSTONE));
        registerItem(BYGItemList.WHITE_SMOOTH_SANDSTONE = new BlockItem(BYGBlockList.WHITE_SMOOTH_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_SMOOTH_SANDSTONE));

        registerItem(BYGItemList.BLUE_SAND = new BlockItem(BYGBlockList.BLUE_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SAND));
        registerItem(BYGItemList.BLUE_SANDSTONE = new BlockItem(BYGBlockList.BLUE_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SANDSTONE));
        registerItem(BYGItemList.BLUE_CHISELED_SANDSTONE = new BlockItem(BYGBlockList.BLUE_CHISELED_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_CHISELED_SANDSTONE));
        registerItem(BYGItemList.BLUE_CUT_SANDSTONE = new BlockItem(BYGBlockList.BLUE_CUT_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_CUT_SANDSTONE));
        registerItem(BYGItemList.BLUE_SMOOTH_SANDSTONE = new BlockItem(BYGBlockList.BLUE_SMOOTH_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SMOOTH_SANDSTONE));

        registerItem(BYGItemList.PURPLE_SAND = new BlockItem(BYGBlockList.PURPLE_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_SAND));
        registerItem(BYGItemList.PURPLE_SANDSTONE = new BlockItem(BYGBlockList.PURPLE_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_SANDSTONE));
        registerItem(BYGItemList.PURPLE_CHISELED_SANDSTONE = new BlockItem(BYGBlockList.PURPLE_CHISELED_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_CHISELED_SANDSTONE));
        registerItem(BYGItemList.PURPLE_CUT_SANDSTONE = new BlockItem(BYGBlockList.PURPLE_CUT_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_CUT_SANDSTONE));
        registerItem(BYGItemList.PURPLE_SMOOTH_SANDSTONE = new BlockItem(BYGBlockList.PURPLE_SMOOTH_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_SMOOTH_SANDSTONE));

        registerItem(BYGItemList.PINK_SAND = new BlockItem(BYGBlockList.PINK_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_SAND));
        registerItem(BYGItemList.PINK_SANDSTONE = new BlockItem(BYGBlockList.PINK_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_SANDSTONE));
        registerItem(BYGItemList.PINK_CHISELED_SANDSTONE = new BlockItem(BYGBlockList.PINK_CHISELED_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_CHISELED_SANDSTONE));
        registerItem(BYGItemList.PINK_CUT_SANDSTONE = new BlockItem(BYGBlockList.PINK_CUT_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_CUT_SANDSTONE));
        registerItem(BYGItemList.PINK_SMOOTH_SANDSTONE = new BlockItem(BYGBlockList.PINK_SMOOTH_SANDSTONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_SMOOTH_SANDSTONE));

        //Aspen Woodtype
        registerItem(BYGItemList.ASPEN_SAPLING = new BlockItem(BYGBlockList.ASPEN_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_SAPLING));
        registerItem(BYGItemList.ASPEN_LEAVES = new BlockItem(BYGBlockList.ASPEN_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_LEAVES));
        registerItem(BYGItemList.ASPEN_LOG = new BlockItem(BYGBlockList.ASPEN_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_LOG));
        registerItem(BYGItemList.ASPEN_WOOD = new BlockItem(BYGBlockList.ASPEN_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_WOOD));
        registerItem(BYGItemList.STRIPPED_ASPEN_LOG = new BlockItem(BYGBlockList.STRIPPED_ASPEN_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_ASPEN_LOG));
        registerItem(BYGItemList.STRIPPED_ASPEN_WOOD = new BlockItem(BYGBlockList.STRIPPED_ASPEN_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_ASPEN_WOOD));
        registerItem(BYGItemList.ASPEN_PLANKS = new BlockItem(BYGBlockList.ASPEN_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_PLANKS));
        registerItem(BYGItemList.ASPEN_BOOKSHELF = new BlockItem(BYGBlockList.ASPEN_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_BOOKSHELF));
        registerItem(BYGItemList.ASPEN_CRAFTING_TABLE = new BlockItem(BYGBlockList.ASPEN_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_CRAFTING_TABLE));
        registerItem(BYGItemList.ASPEN_STAIRS = new BlockItem(BYGBlockList.ASPEN_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_STAIRS));
        registerItem(BYGItemList.ASPEN_SLAB = new BlockItem(BYGBlockList.ASPEN_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_SLAB));
        registerItem(BYGItemList.ASPEN_FENCE = new BlockItem(BYGBlockList.ASPEN_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_FENCE));
        registerItem(BYGItemList.ASPEN_FENCE_GATE = new BlockItem(BYGBlockList.ASPEN_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_FENCE_GATE));
        registerItem(BYGItemList.ASPEN_DOOR = new TallBlockItem(BYGBlockList.ASPEN_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_DOOR));
        registerItem(BYGItemList.ASPEN_TRAPDOOR = new BlockItem(BYGBlockList.ASPEN_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_TRAPDOOR));
        registerItem(BYGItemList.ASPEN_PRESSURE_PLATE = new BlockItem(BYGBlockList.ASPEN_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_PRESSURE_PLATE));
        registerItem(BYGItemList.ASPEN_BUTTON = new BlockItem(BYGBlockList.ASPEN_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ASPEN_BUTTON));
        registerItem(BYGItemList.ASPEN_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.ASPEN, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "aspen_boat"));

        //Baobab Woodtype
        registerItem(BYGItemList.BAOBAB_SAPLING = new BlockItem(BYGBlockList.BAOBAB_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_SAPLING));
        registerItem(BYGItemList.BAOBAB_LEAVES = new BlockItem(BYGBlockList.BAOBAB_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_LEAVES));
        registerItem(BYGItemList.BAOBAB_LOG = new BlockItem(BYGBlockList.BAOBAB_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_LOG));
        registerItem(BYGItemList.BAOBAB_WOOD = new BlockItem(BYGBlockList.BAOBAB_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_WOOD));
        registerItem(BYGItemList.STRIPPED_BAOBAB_LOG = new BlockItem(BYGBlockList.STRIPPED_BAOBAB_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_BAOBAB_LOG));
        registerItem(BYGItemList.STRIPPED_BAOBAB_WOOD = new BlockItem(BYGBlockList.STRIPPED_BAOBAB_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_BAOBAB_WOOD));
        registerItem(BYGItemList.BAOBAB_PLANKS = new BlockItem(BYGBlockList.BAOBAB_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_PLANKS));
        registerItem(BYGItemList.BAOBAB_BOOKSHELF = new BlockItem(BYGBlockList.BAOBAB_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_BOOKSHELF));
        registerItem(BYGItemList.BAOBAB_CRAFTING_TABLE = new BlockItem(BYGBlockList.BAOBAB_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_CRAFTING_TABLE));
        registerItem(BYGItemList.BAOBAB_STAIRS = new BlockItem(BYGBlockList.BAOBAB_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_STAIRS));
        registerItem(BYGItemList.BAOBAB_SLAB = new BlockItem(BYGBlockList.BAOBAB_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_SLAB));
        registerItem(BYGItemList.BAOBAB_FENCE = new BlockItem(BYGBlockList.BAOBAB_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_FENCE));
        registerItem(BYGItemList.BAOBAB_FENCE_GATE = new BlockItem(BYGBlockList.BAOBAB_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_FENCE_GATE));
        registerItem(BYGItemList.BAOBAB_DOOR = new TallBlockItem(BYGBlockList.BAOBAB_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_DOOR));
        registerItem(BYGItemList.BAOBAB_TRAPDOOR = new BlockItem(BYGBlockList.BAOBAB_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_TRAPDOOR));
        registerItem(BYGItemList.BAOBAB_PRESSURE_PLATE = new BlockItem(BYGBlockList.BAOBAB_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_PRESSURE_PLATE));
        registerItem(BYGItemList.BAOBAB_BUTTON = new BlockItem(BYGBlockList.BAOBAB_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BAOBAB_BUTTON));
        registerItem(BYGItemList.BAOBAB_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.BAOBAB, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "baobab_boat"));

        //Blue Enchanted Woodtype
        registerItem(BYGItemList.BLUE_ENCHANTED_SAPLING = new BlockItem(BYGBlockList.BLUE_ENCHANTED_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_SAPLING));
        registerItem(BYGItemList.BLUE_ENCHANTED_LEAVES = new BlockItem(BYGBlockList.BLUE_ENCHANTED_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_LEAVES));
        registerItem(BYGItemList.BLUE_ENCHANTED_LOG = new BlockItem(BYGBlockList.BLUE_ENCHANTED_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_LOG));
        registerItem(BYGItemList.BLUE_ENCHANTED_WOOD = new BlockItem(BYGBlockList.BLUE_ENCHANTED_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_WOOD));
        registerItem(BYGItemList.STRIPPED_BLUE_ENCHANTED_LOG = new BlockItem(BYGBlockList.STRIPPED_BLUE_ENCHANTED_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_BLUE_ENCHANTED_LOG));
        registerItem(BYGItemList.STRIPPED_BLUE_ENCHANTED_WOOD = new BlockItem(BYGBlockList.STRIPPED_BLUE_ENCHANTED_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_BLUE_ENCHANTED_WOOD));
        registerItem(BYGItemList.BLUE_ENCHANTED_PLANKS = new BlockItem(BYGBlockList.BLUE_ENCHANTED_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_PLANKS));
        registerItem(BYGItemList.BLUE_ENCHANTED_BOOKSHELF = new BlockItem(BYGBlockList.BLUE_ENCHANTED_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_BOOKSHELF));
        registerItem(BYGItemList.BLUE_ENCHANTED_CRAFTING_TABLE = new BlockItem(BYGBlockList.BLUE_ENCHANTED_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_CRAFTING_TABLE));
        registerItem(BYGItemList.BLUE_ENCHANTED_STAIRS = new BlockItem(BYGBlockList.BLUE_ENCHANTED_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_STAIRS));
        registerItem(BYGItemList.BLUE_ENCHANTED_SLAB = new BlockItem(BYGBlockList.BLUE_ENCHANTED_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_SLAB));
        registerItem(BYGItemList.BLUE_ENCHANTED_FENCE = new BlockItem(BYGBlockList.BLUE_ENCHANTED_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_FENCE));
        registerItem(BYGItemList.BLUE_ENCHANTED_FENCE_GATE = new BlockItem(BYGBlockList.BLUE_ENCHANTED_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_FENCE_GATE));
        registerItem(BYGItemList.BLUE_ENCHANTED_DOOR = new TallBlockItem(BYGBlockList.BLUE_ENCHANTED_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_DOOR));
        registerItem(BYGItemList.BLUE_ENCHANTED_TRAPDOOR = new BlockItem(BYGBlockList.BLUE_ENCHANTED_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_TRAPDOOR));
        registerItem(BYGItemList.BLUE_ENCHANTED_PRESSURE_PLATE = new BlockItem(BYGBlockList.BLUE_ENCHANTED_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_PRESSURE_PLATE));
        registerItem(BYGItemList.BLUE_ENCHANTED_BUTTON = new BlockItem(BYGBlockList.BLUE_ENCHANTED_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_ENCHANTED_BUTTON));
        registerItem(BYGItemList.BLUE_ENCHANTED_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.BLUE_ENCHANTED, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "blue_enchanted_boat"));

        //Cherry Woodtype
        registerItem(BYGItemList.PINK_CHERRY_SAPLING = new BlockItem(BYGBlockList.PINK_CHERRY_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_CHERRY_SAPLING));
        registerItem(BYGItemList.PINK_CHERRY_FOLIAGE = new BlockItem(BYGBlockList.PINK_CHERRY_FOLIAGE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_CHERRY_FOLIAGE));
        registerItem(BYGItemList.PINK_CHERRY_LEAVES = new BlockItem(BYGBlockList.PINK_CHERRY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_CHERRY_LEAVES));
        registerItem(BYGItemList.WHITE_CHERRY_SAPLING = new BlockItem(BYGBlockList.WHITE_CHERRY_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_CHERRY_SAPLING));
        registerItem(BYGItemList.WHITE_CHERRY_FOLIAGE = new BlockItem(BYGBlockList.WHITE_CHERRY_FOLIAGE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_CHERRY_FOLIAGE));
        registerItem(BYGItemList.WHITE_CHERRY_LEAVES = new BlockItem(BYGBlockList.WHITE_CHERRY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_CHERRY_LEAVES));
        registerItem(BYGItemList.CHERRY_LOG = new BlockItem(BYGBlockList.CHERRY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_LOG));
        registerItem(BYGItemList.CHERRY_WOOD = new BlockItem(BYGBlockList.CHERRY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_WOOD));
        registerItem(BYGItemList.STRIPPED_CHERRY_LOG = new BlockItem(BYGBlockList.STRIPPED_CHERRY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CHERRY_LOG));
        registerItem(BYGItemList.STRIPPED_CHERRY_WOOD = new BlockItem(BYGBlockList.STRIPPED_CHERRY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CHERRY_WOOD));
        registerItem(BYGItemList.CHERRY_PLANKS = new BlockItem(BYGBlockList.CHERRY_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_PLANKS));
        registerItem(BYGItemList.CHERRY_BOOKSHELF = new BlockItem(BYGBlockList.CHERRY_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_BOOKSHELF));
        registerItem(BYGItemList.CHERRY_CRAFTING_TABLE = new BlockItem(BYGBlockList.CHERRY_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_CRAFTING_TABLE));
        registerItem(BYGItemList.CHERRY_STAIRS = new BlockItem(BYGBlockList.CHERRY_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_STAIRS));
        registerItem(BYGItemList.CHERRY_SLAB = new BlockItem(BYGBlockList.CHERRY_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_SLAB));
        registerItem(BYGItemList.CHERRY_FENCE = new BlockItem(BYGBlockList.CHERRY_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_FENCE));
        registerItem(BYGItemList.CHERRY_FENCE_GATE = new BlockItem(BYGBlockList.CHERRY_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_FENCE_GATE));
        registerItem(BYGItemList.CHERRY_DOOR = new TallBlockItem(BYGBlockList.CHERRY_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_DOOR));
        registerItem(BYGItemList.CHERRY_TRAPDOOR = new BlockItem(BYGBlockList.CHERRY_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_TRAPDOOR));
        registerItem(BYGItemList.CHERRY_PRESSURE_PLATE = new BlockItem(BYGBlockList.CHERRY_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_PRESSURE_PLATE));
        registerItem(BYGItemList.CHERRY_BUTTON = new BlockItem(BYGBlockList.CHERRY_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CHERRY_BUTTON));
        registerItem(BYGItemList.CHERRY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CHERRY, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "cherry_boat"));

        //Cika Woodtype
        registerItem(BYGItemList.CIKA_SAPLING = new BlockItem(BYGBlockList.CIKA_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_SAPLING));
        registerItem(BYGItemList.CIKA_LEAVES = new BlockItem(BYGBlockList.CIKA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_LEAVES));
        registerItem(BYGItemList.CIKA_LOG = new BlockItem(BYGBlockList.CIKA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_LOG));
        registerItem(BYGItemList.CIKA_WOOD = new BlockItem(BYGBlockList.CIKA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_WOOD));
        registerItem(BYGItemList.STRIPPED_CIKA_LOG = new BlockItem(BYGBlockList.STRIPPED_CIKA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CIKA_LOG));
        registerItem(BYGItemList.STRIPPED_CIKA_WOOD = new BlockItem(BYGBlockList.STRIPPED_CIKA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CIKA_WOOD));
        registerItem(BYGItemList.CIKA_PLANKS = new BlockItem(BYGBlockList.CIKA_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_PLANKS));
        registerItem(BYGItemList.CIKA_BOOKSHELF = new BlockItem(BYGBlockList.CIKA_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_BOOKSHELF));
        registerItem(BYGItemList.CIKA_CRAFTING_TABLE = new BlockItem(BYGBlockList.CIKA_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_CRAFTING_TABLE));
        registerItem(BYGItemList.CIKA_STAIRS = new BlockItem(BYGBlockList.CIKA_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_STAIRS));
        registerItem(BYGItemList.CIKA_SLAB = new BlockItem(BYGBlockList.CIKA_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_SLAB));
        registerItem(BYGItemList.CIKA_FENCE = new BlockItem(BYGBlockList.CIKA_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_FENCE));
        registerItem(BYGItemList.CIKA_FENCE_GATE = new BlockItem(BYGBlockList.CIKA_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_FENCE_GATE));
        registerItem(BYGItemList.CIKA_DOOR = new TallBlockItem(BYGBlockList.CIKA_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_DOOR));
        registerItem(BYGItemList.CIKA_TRAPDOOR = new BlockItem(BYGBlockList.CIKA_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_TRAPDOOR));
        registerItem(BYGItemList.CIKA_PRESSURE_PLATE = new BlockItem(BYGBlockList.CIKA_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_PRESSURE_PLATE));
        registerItem(BYGItemList.CIKA_BUTTON = new BlockItem(BYGBlockList.CIKA_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CIKA_BUTTON));
        registerItem(BYGItemList.CIKA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CIKA, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "cika_boat"));

        //Cypress Woodtype
        registerItem(BYGItemList.CYPRESS_SAPLING = new BlockItem(BYGBlockList.CYPRESS_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_SAPLING));
        registerItem(BYGItemList.CYPRESS_LEAVES = new BlockItem(BYGBlockList.CYPRESS_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_LEAVES));
        registerItem(BYGItemList.CYPRESS_LOG = new BlockItem(BYGBlockList.CYPRESS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_LOG));
        registerItem(BYGItemList.CYPRESS_WOOD = new BlockItem(BYGBlockList.CYPRESS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_WOOD));
        registerItem(BYGItemList.STRIPPED_CYPRESS_LOG = new BlockItem(BYGBlockList.STRIPPED_CYPRESS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CYPRESS_LOG));
        registerItem(BYGItemList.STRIPPED_CYPRESS_WOOD = new BlockItem(BYGBlockList.STRIPPED_CYPRESS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_CYPRESS_WOOD));
        registerItem(BYGItemList.CYPRESS_PLANKS = new BlockItem(BYGBlockList.CYPRESS_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_PLANKS));
        registerItem(BYGItemList.CYPRESS_BOOKSHELF = new BlockItem(BYGBlockList.CYPRESS_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_BOOKSHELF));
        registerItem(BYGItemList.CYPRESS_CRAFTING_TABLE = new BlockItem(BYGBlockList.CYPRESS_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_CRAFTING_TABLE));
        registerItem(BYGItemList.CYPRESS_STAIRS = new BlockItem(BYGBlockList.CYPRESS_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_STAIRS));
        registerItem(BYGItemList.CYPRESS_SLAB = new BlockItem(BYGBlockList.CYPRESS_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_SLAB));
        registerItem(BYGItemList.CYPRESS_FENCE = new BlockItem(BYGBlockList.CYPRESS_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_FENCE));
        registerItem(BYGItemList.CYPRESS_FENCE_GATE = new BlockItem(BYGBlockList.CYPRESS_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_FENCE_GATE));
        registerItem(BYGItemList.CYPRESS_DOOR = new TallBlockItem(BYGBlockList.CYPRESS_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_DOOR));
        registerItem(BYGItemList.CYPRESS_TRAPDOOR = new BlockItem(BYGBlockList.CYPRESS_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_TRAPDOOR));
        registerItem(BYGItemList.CYPRESS_PRESSURE_PLATE = new BlockItem(BYGBlockList.CYPRESS_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_PRESSURE_PLATE));
        registerItem(BYGItemList.CYPRESS_BUTTON = new BlockItem(BYGBlockList.CYPRESS_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYPRESS_BUTTON));
        registerItem(BYGItemList.CYPRESS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.CYPRESS, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "cypress_boat"));

        //Ebony Woodtype
        registerItem(BYGItemList.EBONY_SAPLING = new BlockItem(BYGBlockList.EBONY_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_SAPLING));
        registerItem(BYGItemList.EBONY_LEAVES = new BlockItem(BYGBlockList.EBONY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_LEAVES));
        registerItem(BYGItemList.EBONY_LOG = new BlockItem(BYGBlockList.EBONY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_LOG));
        registerItem(BYGItemList.EBONY_WOOD = new BlockItem(BYGBlockList.EBONY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_WOOD));
        registerItem(BYGItemList.STRIPPED_EBONY_LOG = new BlockItem(BYGBlockList.STRIPPED_EBONY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_EBONY_LOG));
        registerItem(BYGItemList.STRIPPED_EBONY_WOOD = new BlockItem(BYGBlockList.STRIPPED_EBONY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_EBONY_WOOD));
        registerItem(BYGItemList.EBONY_PLANKS = new BlockItem(BYGBlockList.EBONY_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_PLANKS));
        registerItem(BYGItemList.EBONY_BOOKSHELF = new BlockItem(BYGBlockList.EBONY_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_BOOKSHELF));
        registerItem(BYGItemList.EBONY_CRAFTING_TABLE = new BlockItem(BYGBlockList.EBONY_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_CRAFTING_TABLE));
        registerItem(BYGItemList.EBONY_STAIRS = new BlockItem(BYGBlockList.EBONY_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_STAIRS));
        registerItem(BYGItemList.EBONY_SLAB = new BlockItem(BYGBlockList.EBONY_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_SLAB));
        registerItem(BYGItemList.EBONY_FENCE = new BlockItem(BYGBlockList.EBONY_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_FENCE));
        registerItem(BYGItemList.EBONY_FENCE_GATE = new BlockItem(BYGBlockList.EBONY_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_FENCE_GATE));
        registerItem(BYGItemList.EBONY_DOOR = new TallBlockItem(BYGBlockList.EBONY_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_DOOR));
        registerItem(BYGItemList.EBONY_TRAPDOOR = new BlockItem(BYGBlockList.EBONY_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_TRAPDOOR));
        registerItem(BYGItemList.EBONY_PRESSURE_PLATE = new BlockItem(BYGBlockList.EBONY_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_PRESSURE_PLATE));
        registerItem(BYGItemList.EBONY_BUTTON = new BlockItem(BYGBlockList.EBONY_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EBONY_BUTTON));
        registerItem(BYGItemList.EBONY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.EBONY, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "ebony_boat"));

        //Fir Woodtype
        registerItem(BYGItemList.FIR_SAPLING = new BlockItem(BYGBlockList.FIR_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_SAPLING));
        registerItem(BYGItemList.FIR_LEAVES = new BlockItem(BYGBlockList.FIR_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_LEAVES));
        registerItem(BYGItemList.FIR_LOG = new BlockItem(BYGBlockList.FIR_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_LOG));
        registerItem(BYGItemList.FIR_WOOD = new BlockItem(BYGBlockList.FIR_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_WOOD));
        registerItem(BYGItemList.STRIPPED_FIR_LOG = new BlockItem(BYGBlockList.STRIPPED_FIR_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_FIR_LOG));
        registerItem(BYGItemList.STRIPPED_FIR_WOOD = new BlockItem(BYGBlockList.STRIPPED_FIR_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_FIR_WOOD));
        registerItem(BYGItemList.FIR_PLANKS = new BlockItem(BYGBlockList.FIR_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_PLANKS));
        registerItem(BYGItemList.FIR_BOOKSHELF = new BlockItem(BYGBlockList.FIR_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_BOOKSHELF));
        registerItem(BYGItemList.FIR_CRAFTING_TABLE = new BlockItem(BYGBlockList.FIR_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_CRAFTING_TABLE));
        registerItem(BYGItemList.FIR_STAIRS = new BlockItem(BYGBlockList.FIR_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_STAIRS));
        registerItem(BYGItemList.FIR_SLAB = new BlockItem(BYGBlockList.FIR_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_SLAB));
        registerItem(BYGItemList.FIR_FENCE = new BlockItem(BYGBlockList.FIR_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_FENCE));
        registerItem(BYGItemList.FIR_FENCE_GATE = new BlockItem(BYGBlockList.FIR_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_FENCE_GATE));
        registerItem(BYGItemList.FIR_DOOR = new TallBlockItem(BYGBlockList.FIR_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_DOOR));
        registerItem(BYGItemList.FIR_TRAPDOOR = new BlockItem(BYGBlockList.FIR_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_TRAPDOOR));
        registerItem(BYGItemList.FIR_PRESSURE_PLATE = new BlockItem(BYGBlockList.FIR_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_PRESSURE_PLATE));
        registerItem(BYGItemList.FIR_BUTTON = new BlockItem(BYGBlockList.FIR_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIR_BUTTON));
        registerItem(BYGItemList.FIR_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.FIR, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "fir_boat"));

        //Green Enchanted Woodtype
        registerItem(BYGItemList.GREEN_ENCHANTED_SAPLING = new BlockItem(BYGBlockList.GREEN_ENCHANTED_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_SAPLING));
        registerItem(BYGItemList.GREEN_ENCHANTED_LEAVES = new BlockItem(BYGBlockList.GREEN_ENCHANTED_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_LEAVES));
        registerItem(BYGItemList.GREEN_ENCHANTED_LOG = new BlockItem(BYGBlockList.GREEN_ENCHANTED_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_LOG));
        registerItem(BYGItemList.GREEN_ENCHANTED_WOOD = new BlockItem(BYGBlockList.GREEN_ENCHANTED_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_WOOD));
        registerItem(BYGItemList.STRIPPED_GREEN_ENCHANTED_LOG = new BlockItem(BYGBlockList.STRIPPED_GREEN_ENCHANTED_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_GREEN_ENCHANTED_LOG));
        registerItem(BYGItemList.STRIPPED_GREEN_ENCHANTED_WOOD = new BlockItem(BYGBlockList.STRIPPED_GREEN_ENCHANTED_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_GREEN_ENCHANTED_WOOD));
        registerItem(BYGItemList.GREEN_ENCHANTED_PLANKS = new BlockItem(BYGBlockList.GREEN_ENCHANTED_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_PLANKS));
        registerItem(BYGItemList.GREEN_ENCHANTED_BOOKSHELF = new BlockItem(BYGBlockList.GREEN_ENCHANTED_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_BOOKSHELF));
        registerItem(BYGItemList.GREEN_ENCHANTED_CRAFTING_TABLE = new BlockItem(BYGBlockList.GREEN_ENCHANTED_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_CRAFTING_TABLE));
        registerItem(BYGItemList.GREEN_ENCHANTED_STAIRS = new BlockItem(BYGBlockList.GREEN_ENCHANTED_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_STAIRS));
        registerItem(BYGItemList.GREEN_ENCHANTED_SLAB = new BlockItem(BYGBlockList.GREEN_ENCHANTED_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_SLAB));
        registerItem(BYGItemList.GREEN_ENCHANTED_FENCE = new BlockItem(BYGBlockList.GREEN_ENCHANTED_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_FENCE));
        registerItem(BYGItemList.GREEN_ENCHANTED_FENCE_GATE = new BlockItem(BYGBlockList.GREEN_ENCHANTED_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_FENCE_GATE));
        registerItem(BYGItemList.GREEN_ENCHANTED_DOOR = new TallBlockItem(BYGBlockList.GREEN_ENCHANTED_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_DOOR));
        registerItem(BYGItemList.GREEN_ENCHANTED_TRAPDOOR = new BlockItem(BYGBlockList.GREEN_ENCHANTED_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_TRAPDOOR));
        registerItem(BYGItemList.GREEN_ENCHANTED_PRESSURE_PLATE = new BlockItem(BYGBlockList.GREEN_ENCHANTED_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_PRESSURE_PLATE));
        registerItem(BYGItemList.GREEN_ENCHANTED_BUTTON = new BlockItem(BYGBlockList.GREEN_ENCHANTED_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_ENCHANTED_BUTTON));
        registerItem(BYGItemList.GREEN_ENCHANTED_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.GREEN_ENCHANTED, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "green_enchanted_boat"));

        //Holly Woodtype
        registerItem(BYGItemList.HOLLY_BERRY_LEAVES = new BlockItem(BYGBlockList.HOLLY_BERRY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_BERRY_LEAVES));
        registerItem(BYGItemList.HOLLY_BERRY = new Item(new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build())), new Identifier(BYG.MODID, "holly_berries"));
        registerItem(BYGItemList.HOLLY_SAPLING = new BlockItem(BYGBlockList.HOLLY_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_SAPLING));
        registerItem(BYGItemList.HOLLY_LEAVES = new BlockItem(BYGBlockList.HOLLY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_LEAVES));
        registerItem(BYGItemList.HOLLY_LOG = new BlockItem(BYGBlockList.HOLLY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_LOG));
        registerItem(BYGItemList.HOLLY_WOOD = new BlockItem(BYGBlockList.HOLLY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_WOOD));
        registerItem(BYGItemList.STRIPPED_HOLLY_LOG = new BlockItem(BYGBlockList.STRIPPED_HOLLY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_HOLLY_LOG));
        registerItem(BYGItemList.STRIPPED_HOLLY_WOOD = new BlockItem(BYGBlockList.STRIPPED_HOLLY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_HOLLY_WOOD));
        registerItem(BYGItemList.HOLLY_PLANKS = new BlockItem(BYGBlockList.HOLLY_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_PLANKS));
        registerItem(BYGItemList.HOLLY_BOOKSHELF = new BlockItem(BYGBlockList.HOLLY_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_BOOKSHELF));
        registerItem(BYGItemList.HOLLY_CRAFTING_TABLE = new BlockItem(BYGBlockList.HOLLY_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_CRAFTING_TABLE));
        registerItem(BYGItemList.HOLLY_STAIRS = new BlockItem(BYGBlockList.HOLLY_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_STAIRS));
        registerItem(BYGItemList.HOLLY_SLAB = new BlockItem(BYGBlockList.HOLLY_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_SLAB));
        registerItem(BYGItemList.HOLLY_FENCE = new BlockItem(BYGBlockList.HOLLY_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_FENCE));
        registerItem(BYGItemList.HOLLY_FENCE_GATE = new BlockItem(BYGBlockList.HOLLY_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_FENCE_GATE));
        registerItem(BYGItemList.HOLLY_DOOR = new TallBlockItem(BYGBlockList.HOLLY_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_DOOR));
        registerItem(BYGItemList.HOLLY_TRAPDOOR = new BlockItem(BYGBlockList.HOLLY_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_TRAPDOOR));
        registerItem(BYGItemList.HOLLY_PRESSURE_PLATE = new BlockItem(BYGBlockList.HOLLY_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_PRESSURE_PLATE));
        registerItem(BYGItemList.HOLLY_BUTTON = new BlockItem(BYGBlockList.HOLLY_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HOLLY_BUTTON));
        registerItem(BYGItemList.HOLLY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.HOLLY, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "holly_boat"));

        //Jacaranda Woodtype
        registerItem(BYGItemList.JACARANDA_SAPLING = new BlockItem(BYGBlockList.JACARANDA_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_SAPLING));
        registerItem(BYGItemList.JACARANDA_LEAVES = new BlockItem(BYGBlockList.JACARANDA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_LEAVES));
        registerItem(BYGItemList.INDIGO_JACARANDA_SAPLING = new BlockItem(BYGBlockList.INDIGO_JACARANDA_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.INDIGO_JACARANDA_SAPLING));
        registerItem(BYGItemList.INDIGO_JACARANDA_LEAVES = new BlockItem(BYGBlockList.INDIGO_JACARANDA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.INDIGO_JACARANDA_LEAVES));
        registerItem(BYGItemList.JACARANDA_LOG = new BlockItem(BYGBlockList.JACARANDA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_LOG));
        registerItem(BYGItemList.JACARANDA_WOOD = new BlockItem(BYGBlockList.JACARANDA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_WOOD));
        registerItem(BYGItemList.STRIPPED_JACARANDA_LOG = new BlockItem(BYGBlockList.STRIPPED_JACARANDA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_JACARANDA_LOG));
        registerItem(BYGItemList.STRIPPED_JACARANDA_WOOD = new BlockItem(BYGBlockList.STRIPPED_JACARANDA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_JACARANDA_WOOD));
        registerItem(BYGItemList.JACARANDA_PLANKS = new BlockItem(BYGBlockList.JACARANDA_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_PLANKS));
        registerItem(BYGItemList.JACARANDA_BOOKSHELF = new BlockItem(BYGBlockList.JACARANDA_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_BOOKSHELF));
        registerItem(BYGItemList.JACARANDA_CRAFTING_TABLE = new BlockItem(BYGBlockList.JACARANDA_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_CRAFTING_TABLE));
        registerItem(BYGItemList.JACARANDA_STAIRS = new BlockItem(BYGBlockList.JACARANDA_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_STAIRS));
        registerItem(BYGItemList.JACARANDA_SLAB = new BlockItem(BYGBlockList.JACARANDA_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_SLAB));
        registerItem(BYGItemList.JACARANDA_FENCE = new BlockItem(BYGBlockList.JACARANDA_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_FENCE));
        registerItem(BYGItemList.JACARANDA_FENCE_GATE = new BlockItem(BYGBlockList.JACARANDA_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_FENCE_GATE));
        registerItem(BYGItemList.JACARANDA_DOOR = new TallBlockItem(BYGBlockList.JACARANDA_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_DOOR));
        registerItem(BYGItemList.JACARANDA_TRAPDOOR = new BlockItem(BYGBlockList.JACARANDA_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_TRAPDOOR));
        registerItem(BYGItemList.JACARANDA_PRESSURE_PLATE = new BlockItem(BYGBlockList.JACARANDA_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_PRESSURE_PLATE));
        registerItem(BYGItemList.JACARANDA_BUTTON = new BlockItem(BYGBlockList.JACARANDA_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JACARANDA_BUTTON));
        registerItem(BYGItemList.JACARANDA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.JACARANDA, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "jacaranda_boat"));

        //Mahogany Woodtype
        registerItem(BYGItemList.MAHOGANY_SAPLING = new BlockItem(BYGBlockList.MAHOGANY_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_SAPLING));
        registerItem(BYGItemList.MAHOGANY_LEAVES = new BlockItem(BYGBlockList.MAHOGANY_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_LEAVES));
        registerItem(BYGItemList.MAHOGANY_LOG = new BlockItem(BYGBlockList.MAHOGANY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_LOG));
        registerItem(BYGItemList.MAHOGANY_WOOD = new BlockItem(BYGBlockList.MAHOGANY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_WOOD));
        registerItem(BYGItemList.STRIPPED_MAHOGANY_LOG = new BlockItem(BYGBlockList.STRIPPED_MAHOGANY_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MAHOGANY_LOG));
        registerItem(BYGItemList.STRIPPED_MAHOGANY_WOOD = new BlockItem(BYGBlockList.STRIPPED_MAHOGANY_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MAHOGANY_WOOD));
        registerItem(BYGItemList.MAHOGANY_PLANKS = new BlockItem(BYGBlockList.MAHOGANY_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_PLANKS));
        registerItem(BYGItemList.MAHOGANY_BOOKSHELF = new BlockItem(BYGBlockList.MAHOGANY_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_BOOKSHELF));
        registerItem(BYGItemList.MAHOGANY_CRAFTING_TABLE = new BlockItem(BYGBlockList.MAHOGANY_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_CRAFTING_TABLE));
        registerItem(BYGItemList.MAHOGANY_STAIRS = new BlockItem(BYGBlockList.MAHOGANY_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_STAIRS));
        registerItem(BYGItemList.MAHOGANY_SLAB = new BlockItem(BYGBlockList.MAHOGANY_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_SLAB));
        registerItem(BYGItemList.MAHOGANY_FENCE = new BlockItem(BYGBlockList.MAHOGANY_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_FENCE));
        registerItem(BYGItemList.MAHOGANY_FENCE_GATE = new BlockItem(BYGBlockList.MAHOGANY_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_FENCE_GATE));
        registerItem(BYGItemList.MAHOGANY_DOOR = new TallBlockItem(BYGBlockList.MAHOGANY_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_DOOR));
        registerItem(BYGItemList.MAHOGANY_TRAPDOOR = new BlockItem(BYGBlockList.MAHOGANY_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_TRAPDOOR));
        registerItem(BYGItemList.MAHOGANY_PRESSURE_PLATE = new BlockItem(BYGBlockList.MAHOGANY_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_PRESSURE_PLATE));
        registerItem(BYGItemList.MAHOGANY_BUTTON = new BlockItem(BYGBlockList.MAHOGANY_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAHOGANY_BUTTON));
        registerItem(BYGItemList.MAHOGANY_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MAHOGANY, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "mahogany_boat"));

        //Mangrove Woodtype
        registerItem(BYGItemList.MANGROVE_SAPLING = new BlockItem(BYGBlockList.MANGROVE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_SAPLING));
        registerItem(BYGItemList.MANGROVE_LEAVES = new BlockItem(BYGBlockList.MANGROVE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_LEAVES));
        registerItem(BYGItemList.MANGROVE_LOG = new BlockItem(BYGBlockList.MANGROVE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_LOG));
        registerItem(BYGItemList.MANGROVE_WOOD = new BlockItem(BYGBlockList.MANGROVE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_WOOD));
        registerItem(BYGItemList.STRIPPED_MANGROVE_LOG = new BlockItem(BYGBlockList.STRIPPED_MANGROVE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MANGROVE_LOG));
        registerItem(BYGItemList.STRIPPED_MANGROVE_WOOD = new BlockItem(BYGBlockList.STRIPPED_MANGROVE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MANGROVE_WOOD));
        registerItem(BYGItemList.MANGROVE_PLANKS = new BlockItem(BYGBlockList.MANGROVE_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_PLANKS));
        registerItem(BYGItemList.MANGROVE_BOOKSHELF = new BlockItem(BYGBlockList.MANGROVE_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_BOOKSHELF));
        registerItem(BYGItemList.MANGROVE_CRAFTING_TABLE = new BlockItem(BYGBlockList.MANGROVE_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_CRAFTING_TABLE));
        registerItem(BYGItemList.MANGROVE_STAIRS = new BlockItem(BYGBlockList.MANGROVE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_STAIRS));
        registerItem(BYGItemList.MANGROVE_SLAB = new BlockItem(BYGBlockList.MANGROVE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_SLAB));
        registerItem(BYGItemList.MANGROVE_FENCE = new BlockItem(BYGBlockList.MANGROVE_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_FENCE));
        registerItem(BYGItemList.MANGROVE_FENCE_GATE = new BlockItem(BYGBlockList.MANGROVE_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_FENCE_GATE));
        registerItem(BYGItemList.MANGROVE_DOOR = new TallBlockItem(BYGBlockList.MANGROVE_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_DOOR));
        registerItem(BYGItemList.MANGROVE_TRAPDOOR = new BlockItem(BYGBlockList.MANGROVE_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_TRAPDOOR));
        registerItem(BYGItemList.MANGROVE_PRESSURE_PLATE = new BlockItem(BYGBlockList.MANGROVE_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_PRESSURE_PLATE));
        registerItem(BYGItemList.MANGROVE_BUTTON = new BlockItem(BYGBlockList.MANGROVE_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MANGROVE_BUTTON));
        registerItem(BYGItemList.MANGROVE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MANGROVE, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "mangrove_boat"));

        //Maple Woodtype
        registerItem(BYGItemList.MAPLE_SAPLING = new BlockItem(BYGBlockList.MAPLE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_SAPLING));
        registerItem(BYGItemList.MAPLE_LEAVES = new BlockItem(BYGBlockList.MAPLE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_LEAVES));
        registerItem(BYGItemList.RED_MAPLE_SAPLING = new BlockItem(BYGBlockList.RED_MAPLE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_MAPLE_SAPLING));
        registerItem(BYGItemList.RED_MAPLE_LEAVES = new BlockItem(BYGBlockList.RED_MAPLE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_MAPLE_LEAVES));
        registerItem(BYGItemList.SILVER_MAPLE_SAPLING = new BlockItem(BYGBlockList.SILVER_MAPLE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SILVER_MAPLE_SAPLING));
        registerItem(BYGItemList.SILVER_MAPLE_LEAVES = new BlockItem(BYGBlockList.SILVER_MAPLE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SILVER_MAPLE_LEAVES));
        registerItem(BYGItemList.MAPLE_LOG = new BlockItem(BYGBlockList.MAPLE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_LOG));
        registerItem(BYGItemList.MAPLE_WOOD = new BlockItem(BYGBlockList.MAPLE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_WOOD));
        registerItem(BYGItemList.STRIPPED_MAPLE_LOG = new BlockItem(BYGBlockList.STRIPPED_MAPLE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MAPLE_LOG));
        registerItem(BYGItemList.STRIPPED_MAPLE_WOOD = new BlockItem(BYGBlockList.STRIPPED_MAPLE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_MAPLE_WOOD));
        registerItem(BYGItemList.MAPLE_PLANKS = new BlockItem(BYGBlockList.MAPLE_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_PLANKS));
        registerItem(BYGItemList.MAPLE_BOOKSHELF = new BlockItem(BYGBlockList.MAPLE_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_BOOKSHELF));
        registerItem(BYGItemList.MAPLE_CRAFTING_TABLE = new BlockItem(BYGBlockList.MAPLE_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_CRAFTING_TABLE));
        registerItem(BYGItemList.MAPLE_STAIRS = new BlockItem(BYGBlockList.MAPLE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_STAIRS));
        registerItem(BYGItemList.MAPLE_SLAB = new BlockItem(BYGBlockList.MAPLE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_SLAB));
        registerItem(BYGItemList.MAPLE_FENCE = new BlockItem(BYGBlockList.MAPLE_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_FENCE));
        registerItem(BYGItemList.MAPLE_FENCE_GATE = new BlockItem(BYGBlockList.MAPLE_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_FENCE_GATE));
        registerItem(BYGItemList.MAPLE_DOOR = new TallBlockItem(BYGBlockList.MAPLE_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_DOOR));
        registerItem(BYGItemList.MAPLE_TRAPDOOR = new BlockItem(BYGBlockList.MAPLE_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_TRAPDOOR));
        registerItem(BYGItemList.MAPLE_PRESSURE_PLATE = new BlockItem(BYGBlockList.MAPLE_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_PRESSURE_PLATE));
        registerItem(BYGItemList.MAPLE_BUTTON = new BlockItem(BYGBlockList.MAPLE_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAPLE_BUTTON));
        registerItem(BYGItemList.MAPLE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.MAPLE, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "maple_boat"));

        //Palo Verde Woodtype
        registerItem(BYGItemList.FLOWERING_PALO_VERDE_LEAVES = new BlockItem(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES));
        registerItem(BYGItemList.PALO_VERDE_SAPLING = new BlockItem(BYGBlockList.PALO_VERDE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PALO_VERDE_SAPLING));
        registerItem(BYGItemList.PALO_VERDE_LEAVES = new BlockItem(BYGBlockList.PALO_VERDE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PALO_VERDE_LEAVES));
        registerItem(BYGItemList.PALO_VERDE_LOG = new BlockItem(BYGBlockList.PALO_VERDE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PALO_VERDE_LOG));
        registerItem(BYGItemList.PALO_VERDE_WOOD = new BlockItem(BYGBlockList.PALO_VERDE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PALO_VERDE_WOOD));
        registerItem(BYGItemList.STRIPPED_PALO_VERDE_LOG = new BlockItem(BYGBlockList.STRIPPED_PALO_VERDE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_PALO_VERDE_LOG));
        registerItem(BYGItemList.STRIPPED_PALO_VERDE_WOOD = new BlockItem(BYGBlockList.STRIPPED_PALO_VERDE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_PALO_VERDE_WOOD));

        //Pine Woodtype
        registerItem(BYGItemList.PINE_SAPLING = new BlockItem(BYGBlockList.PINE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_SAPLING));
        registerItem(BYGItemList.PINE_LEAVES = new BlockItem(BYGBlockList.PINE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_LEAVES));
        registerItem(BYGItemList.PINE_LOG = new BlockItem(BYGBlockList.PINE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_LOG));
        registerItem(BYGItemList.PINE_WOOD = new BlockItem(BYGBlockList.PINE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_WOOD));
        registerItem(BYGItemList.STRIPPED_PINE_LOG = new BlockItem(BYGBlockList.STRIPPED_PINE_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_PINE_LOG));
        registerItem(BYGItemList.STRIPPED_PINE_WOOD = new BlockItem(BYGBlockList.STRIPPED_PINE_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_PINE_WOOD));
        registerItem(BYGItemList.PINE_PLANKS = new BlockItem(BYGBlockList.PINE_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_PLANKS));
        registerItem(BYGItemList.PINE_BOOKSHELF = new BlockItem(BYGBlockList.PINE_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_BOOKSHELF));
        registerItem(BYGItemList.PINE_CRAFTING_TABLE = new BlockItem(BYGBlockList.PINE_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_CRAFTING_TABLE));
        registerItem(BYGItemList.PINE_STAIRS = new BlockItem(BYGBlockList.PINE_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_STAIRS));
        registerItem(BYGItemList.PINE_SLAB = new BlockItem(BYGBlockList.PINE_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_SLAB));
        registerItem(BYGItemList.PINE_FENCE = new BlockItem(BYGBlockList.PINE_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_FENCE));
        registerItem(BYGItemList.PINE_FENCE_GATE = new BlockItem(BYGBlockList.PINE_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_FENCE_GATE));
        registerItem(BYGItemList.PINE_DOOR = new TallBlockItem(BYGBlockList.PINE_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_DOOR));
        registerItem(BYGItemList.PINE_TRAPDOOR = new BlockItem(BYGBlockList.PINE_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_TRAPDOOR));
        registerItem(BYGItemList.PINE_PRESSURE_PLATE = new BlockItem(BYGBlockList.PINE_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_PRESSURE_PLATE));
        registerItem(BYGItemList.PINE_BUTTON = new BlockItem(BYGBlockList.PINE_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINE_BUTTON));
        registerItem(BYGItemList.PINE_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.PINE, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "pine_boat"));

        //Rainbow Eucalyptus Woodtype
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_SAPLING = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_SAPLING));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_LEAVES = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_LOG = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_LOG));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_WOOD = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_WOOD));
        registerItem(BYGItemList.STRIPPED_RAINBOW_EUCALYPTUS_LOG = new BlockItem(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_LOG));
        registerItem(BYGItemList.STRIPPED_RAINBOW_EUCALYPTUS_WOOD = new BlockItem(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_RAINBOW_EUCALYPTUS_WOOD));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_PLANKS = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_PLANKS));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_BOOKSHELF = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_BOOKSHELF));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_CRAFTING_TABLE = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_CRAFTING_TABLE));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_STAIRS = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_STAIRS));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_SLAB = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_SLAB));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_FENCE = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_FENCE_GATE = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_FENCE_GATE));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_DOOR = new TallBlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_DOOR));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_TRAPDOOR = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_TRAPDOOR));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_PRESSURE_PLATE = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_PRESSURE_PLATE));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_BUTTON = new BlockItem(BYGBlockList.RAINBOW_EUCALYPTUS_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RAINBOW_EUCALYPTUS_BUTTON));
        registerItem(BYGItemList.RAINBOW_EUCALYPTUS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.RAINBOW_EUCALYPTUS, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "rainbow_eucalyptus_boat"));

        //Redwood Woodtype
        registerItem(BYGItemList.REDWOOD_SAPLING = new BlockItem(BYGBlockList.REDWOOD_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_SAPLING));
        registerItem(BYGItemList.REDWOOD_LEAVES = new BlockItem(BYGBlockList.REDWOOD_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_LEAVES));
        registerItem(BYGItemList.REDWOOD_LOG = new BlockItem(BYGBlockList.REDWOOD_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_LOG));
        registerItem(BYGItemList.REDWOOD_WOOD = new BlockItem(BYGBlockList.REDWOOD_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_WOOD));
        registerItem(BYGItemList.STRIPPED_REDWOOD_LOG = new BlockItem(BYGBlockList.STRIPPED_REDWOOD_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_REDWOOD_LOG));
        registerItem(BYGItemList.STRIPPED_REDWOOD_WOOD = new BlockItem(BYGBlockList.STRIPPED_REDWOOD_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_REDWOOD_WOOD));
        registerItem(BYGItemList.REDWOOD_PLANKS = new BlockItem(BYGBlockList.REDWOOD_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_PLANKS));
        registerItem(BYGItemList.REDWOOD_BOOKSHELF = new BlockItem(BYGBlockList.REDWOOD_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_BOOKSHELF));
        registerItem(BYGItemList.REDWOOD_CRAFTING_TABLE = new BlockItem(BYGBlockList.REDWOOD_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_CRAFTING_TABLE));
        registerItem(BYGItemList.REDWOOD_STAIRS = new BlockItem(BYGBlockList.REDWOOD_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_STAIRS));
        registerItem(BYGItemList.REDWOOD_SLAB = new BlockItem(BYGBlockList.REDWOOD_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_SLAB));
        registerItem(BYGItemList.REDWOOD_FENCE = new BlockItem(BYGBlockList.REDWOOD_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_FENCE));
        registerItem(BYGItemList.REDWOOD_FENCE_GATE = new BlockItem(BYGBlockList.REDWOOD_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_FENCE_GATE));
        registerItem(BYGItemList.REDWOOD_DOOR = new TallBlockItem(BYGBlockList.REDWOOD_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_DOOR));
        registerItem(BYGItemList.REDWOOD_TRAPDOOR = new BlockItem(BYGBlockList.REDWOOD_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_TRAPDOOR));
        registerItem(BYGItemList.REDWOOD_PRESSURE_PLATE = new BlockItem(BYGBlockList.REDWOOD_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_PRESSURE_PLATE));
        registerItem(BYGItemList.REDWOOD_BUTTON = new BlockItem(BYGBlockList.REDWOOD_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REDWOOD_BUTTON));
        registerItem(BYGItemList.REDWOOD_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.REDWOOD, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "redwood_boat"));

        //Skyris Woodtype
        registerItem(BYGItemList.SKYRIS_LEAVES_GREEN_APPLE = new BlockItem(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE));
        registerItem(BYGItemList.GREEN_APPLE = new Item(new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(4).saturationModifier(0.35f).build())), new Identifier(BYG.MODID, "green_apple"));
        registerItem(BYGItemList.SKYRIS_SAPLING = new BlockItem(BYGBlockList.SKYRIS_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_SAPLING));
        registerItem(BYGItemList.SKYRIS_VINE = new BlockItem(BYGBlockList.SKYRIS_VINE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_VINE));
        registerItem(BYGItemList.SKYRIS_LEAVES = new BlockItem(BYGBlockList.SKYRIS_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_LEAVES));
        registerItem(BYGItemList.SKYRIS_LOG = new BlockItem(BYGBlockList.SKYRIS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_LOG));
        registerItem(BYGItemList.SKYRIS_WOOD = new BlockItem(BYGBlockList.SKYRIS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_WOOD));
        registerItem(BYGItemList.STRIPPED_SKYRIS_LOG = new BlockItem(BYGBlockList.STRIPPED_SKYRIS_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_SKYRIS_LOG));
        registerItem(BYGItemList.STRIPPED_SKYRIS_WOOD = new BlockItem(BYGBlockList.STRIPPED_SKYRIS_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_SKYRIS_WOOD));
        registerItem(BYGItemList.SKYRIS_PLANKS = new BlockItem(BYGBlockList.SKYRIS_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_PLANKS));
        registerItem(BYGItemList.SKYRIS_BOOKSHELF = new BlockItem(BYGBlockList.SKYRIS_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_BOOKSHELF));
        registerItem(BYGItemList.SKYRIS_CRAFTING_TABLE = new BlockItem(BYGBlockList.SKYRIS_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_CRAFTING_TABLE));
        registerItem(BYGItemList.SKYRIS_STAIRS = new BlockItem(BYGBlockList.SKYRIS_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_STAIRS));
        registerItem(BYGItemList.SKYRIS_SLAB = new BlockItem(BYGBlockList.SKYRIS_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_SLAB));
        registerItem(BYGItemList.SKYRIS_FENCE = new BlockItem(BYGBlockList.SKYRIS_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_FENCE));
        registerItem(BYGItemList.SKYRIS_FENCE_GATE = new BlockItem(BYGBlockList.SKYRIS_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_FENCE_GATE));
        registerItem(BYGItemList.SKYRIS_DOOR = new TallBlockItem(BYGBlockList.SKYRIS_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_DOOR));
        registerItem(BYGItemList.SKYRIS_TRAPDOOR = new BlockItem(BYGBlockList.SKYRIS_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_TRAPDOOR));
        registerItem(BYGItemList.SKYRIS_PRESSURE_PLATE = new BlockItem(BYGBlockList.SKYRIS_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_PRESSURE_PLATE));
        registerItem(BYGItemList.SKYRIS_BUTTON = new BlockItem(BYGBlockList.SKYRIS_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SKYRIS_BUTTON));
        registerItem(BYGItemList.SKYRIS_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.SKYRIS, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "skyris_boat"));

        //Willow Woodtype
        registerItem(BYGItemList.WILLOW_SAPLING = new BlockItem(BYGBlockList.WILLOW_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_SAPLING));
        registerItem(BYGItemList.WILLOW_LEAVES = new BlockItem(BYGBlockList.WILLOW_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_LEAVES));
        registerItem(BYGItemList.WILLOW_LOG = new BlockItem(BYGBlockList.WILLOW_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_LOG));
        registerItem(BYGItemList.WILLOW_WOOD = new BlockItem(BYGBlockList.WILLOW_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_WOOD));
        registerItem(BYGItemList.STRIPPED_WILLOW_LOG = new BlockItem(BYGBlockList.STRIPPED_WILLOW_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_WILLOW_LOG));
        registerItem(BYGItemList.STRIPPED_WILLOW_WOOD = new BlockItem(BYGBlockList.STRIPPED_WILLOW_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_WILLOW_WOOD));
        registerItem(BYGItemList.WILLOW_PLANKS = new BlockItem(BYGBlockList.WILLOW_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_PLANKS));
        registerItem(BYGItemList.WILLOW_BOOKSHELF = new BlockItem(BYGBlockList.WILLOW_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_BOOKSHELF));
        registerItem(BYGItemList.WILLOW_CRAFTING_TABLE = new BlockItem(BYGBlockList.WILLOW_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_CRAFTING_TABLE));
        registerItem(BYGItemList.WILLOW_STAIRS = new BlockItem(BYGBlockList.WILLOW_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_STAIRS));
        registerItem(BYGItemList.WILLOW_SLAB = new BlockItem(BYGBlockList.WILLOW_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_SLAB));
        registerItem(BYGItemList.WILLOW_FENCE = new BlockItem(BYGBlockList.WILLOW_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_FENCE));
        registerItem(BYGItemList.WILLOW_FENCE_GATE = new BlockItem(BYGBlockList.WILLOW_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_FENCE_GATE));
        registerItem(BYGItemList.WILLOW_DOOR = new TallBlockItem(BYGBlockList.WILLOW_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_DOOR));
        registerItem(BYGItemList.WILLOW_TRAPDOOR = new BlockItem(BYGBlockList.WILLOW_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_TRAPDOOR));
        registerItem(BYGItemList.WILLOW_PRESSURE_PLATE = new BlockItem(BYGBlockList.WILLOW_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_PRESSURE_PLATE));
        registerItem(BYGItemList.WILLOW_BUTTON = new BlockItem(BYGBlockList.WILLOW_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILLOW_BUTTON));
        registerItem(BYGItemList.WILLOW_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.WILLOW, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "willow_boat"));

        //Witch-Hazel Woodtype
        registerItem(BYGItemList.BLOOMING_WITCH_HAZEL_LEAVES = new BlockItem(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES));
        registerItem(BYGItemList.WITCH_HAZEL_SAPLING = new BlockItem(BYGBlockList.WITCH_HAZEL_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_SAPLING));
        registerItem(BYGItemList.WITCH_HAZEL_LEAVES = new BlockItem(BYGBlockList.WITCH_HAZEL_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_LEAVES));
        registerItem(BYGItemList.WITCH_HAZEL_LOG = new BlockItem(BYGBlockList.WITCH_HAZEL_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_LOG));
        registerItem(BYGItemList.WITCH_HAZEL_WOOD = new BlockItem(BYGBlockList.WITCH_HAZEL_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_WOOD));
        registerItem(BYGItemList.STRIPPED_WITCH_HAZEL_LOG = new BlockItem(BYGBlockList.STRIPPED_WITCH_HAZEL_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_WITCH_HAZEL_LOG));
        registerItem(BYGItemList.STRIPPED_WITCH_HAZEL_WOOD = new BlockItem(BYGBlockList.STRIPPED_WITCH_HAZEL_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_WITCH_HAZEL_WOOD));
        registerItem(BYGItemList.WITCH_HAZEL_PLANKS = new BlockItem(BYGBlockList.WITCH_HAZEL_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_PLANKS));
        registerItem(BYGItemList.WITCH_HAZEL_BOOKSHELF = new BlockItem(BYGBlockList.WITCH_HAZEL_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_BOOKSHELF));
        registerItem(BYGItemList.WITCH_HAZEL_CRAFTING_TABLE = new BlockItem(BYGBlockList.WITCH_HAZEL_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_CRAFTING_TABLE));
        registerItem(BYGItemList.WITCH_HAZEL_STAIRS = new BlockItem(BYGBlockList.WITCH_HAZEL_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_STAIRS));
        registerItem(BYGItemList.WITCH_HAZEL_SLAB = new BlockItem(BYGBlockList.WITCH_HAZEL_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_SLAB));
        registerItem(BYGItemList.WITCH_HAZEL_FENCE = new BlockItem(BYGBlockList.WITCH_HAZEL_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_FENCE));
        registerItem(BYGItemList.WITCH_HAZEL_FENCE_GATE = new BlockItem(BYGBlockList.WITCH_HAZEL_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_FENCE_GATE));
        registerItem(BYGItemList.WITCH_HAZEL_DOOR = new TallBlockItem(BYGBlockList.WITCH_HAZEL_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_DOOR));
        registerItem(BYGItemList.WITCH_HAZEL_TRAPDOOR = new BlockItem(BYGBlockList.WITCH_HAZEL_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_TRAPDOOR));
        registerItem(BYGItemList.WITCH_HAZEL_PRESSURE_PLATE = new BlockItem(BYGBlockList.WITCH_HAZEL_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_PRESSURE_PLATE));
        registerItem(BYGItemList.WITCH_HAZEL_BUTTON = new BlockItem(BYGBlockList.WITCH_HAZEL_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WITCH_HAZEL_BUTTON));
        registerItem(BYGItemList.WITCH_HAZEL_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.WITCH_HAZEL, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "witch_hazel_boat"));

        //Zelkova Woodtype
        registerItem(BYGItemList.ZELKOVA_SAPLING = new BlockItem(BYGBlockList.ZELKOVA_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_SAPLING));
        registerItem(BYGItemList.ZELKOVA_LEAVES = new BlockItem(BYGBlockList.ZELKOVA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_LEAVES));
        registerItem(BYGItemList.ZELKOVA_LOG = new BlockItem(BYGBlockList.ZELKOVA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_LOG));
        registerItem(BYGItemList.ZELKOVA_WOOD = new BlockItem(BYGBlockList.ZELKOVA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_WOOD));
        registerItem(BYGItemList.STRIPPED_ZELKOVA_LOG = new BlockItem(BYGBlockList.STRIPPED_ZELKOVA_LOG, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_ZELKOVA_LOG));
        registerItem(BYGItemList.STRIPPED_ZELKOVA_WOOD = new BlockItem(BYGBlockList.STRIPPED_ZELKOVA_WOOD, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.STRIPPED_ZELKOVA_WOOD));
        registerItem(BYGItemList.ZELKOVA_PLANKS = new BlockItem(BYGBlockList.ZELKOVA_PLANKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_PLANKS));
        registerItem(BYGItemList.ZELKOVA_BOOKSHELF = new BlockItem(BYGBlockList.ZELKOVA_BOOKSHELF, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_BOOKSHELF));
        registerItem(BYGItemList.ZELKOVA_CRAFTING_TABLE = new BlockItem(BYGBlockList.ZELKOVA_CRAFTING_TABLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_CRAFTING_TABLE));
        registerItem(BYGItemList.ZELKOVA_STAIRS = new BlockItem(BYGBlockList.ZELKOVA_STAIRS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_STAIRS));
        registerItem(BYGItemList.ZELKOVA_SLAB = new BlockItem(BYGBlockList.ZELKOVA_SLAB, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_SLAB));
        registerItem(BYGItemList.ZELKOVA_FENCE = new BlockItem(BYGBlockList.ZELKOVA_FENCE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_FENCE));
        registerItem(BYGItemList.ZELKOVA_FENCE_GATE = new BlockItem(BYGBlockList.ZELKOVA_FENCE_GATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_FENCE_GATE));
        registerItem(BYGItemList.ZELKOVA_DOOR = new TallBlockItem(BYGBlockList.ZELKOVA_DOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_DOOR));
        registerItem(BYGItemList.ZELKOVA_TRAPDOOR = new BlockItem(BYGBlockList.ZELKOVA_TRAPDOOR, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_TRAPDOOR));
        registerItem(BYGItemList.ZELKOVA_PRESSURE_PLATE = new BlockItem(BYGBlockList.ZELKOVA_PRESSURE_PLATE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_PRESSURE_PLATE));
        registerItem(BYGItemList.ZELKOVA_BUTTON = new BlockItem(BYGBlockList.ZELKOVA_BUTTON, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ZELKOVA_BUTTON));
        registerItem(BYGItemList.ZELKOVA_BOAT = new BYGBoatItem(BYGBoatEntity.BYGType.ZELKOVA, new Item.Settings().group(BYG.BYG_TAB).maxCount(1)), new Identifier(BYG.MODID, "zelkova_boat"));

        //SaplingItems
        registerItem(BYGItemList.BLUE_SPRUCE_SAPLING = new BlockItem(BYGBlockList.BLUE_SPRUCE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SPRUCE_SAPLING));
        registerItem(BYGItemList.BLUE_SPRUCE_LEAVES = new BlockItem(BYGBlockList.BLUE_SPRUCE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SPRUCE_LEAVES));

        registerItem(BYGItemList.BROWN_BIRCH_SAPLING = new BlockItem(BYGBlockList.BROWN_BIRCH_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BROWN_BIRCH_SAPLING));
        registerItem(BYGItemList.BROWN_BIRCH_LEAVES = new BlockItem(BYGBlockList.BROWN_BIRCH_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BROWN_BIRCH_LEAVES));

        registerItem(BYGItemList.BROWN_OAK_SAPLING = new BlockItem(BYGBlockList.BROWN_OAK_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BROWN_OAK_SAPLING));
        registerItem(BYGItemList.BROWN_OAK_LEAVES = new BlockItem(BYGBlockList.BROWN_OAK_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BROWN_OAK_LEAVES));

        registerItem(BYGItemList.JOSHUA_SAPLING = new BlockItem(BYGBlockList.JOSHUA_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JOSHUA_SAPLING));
        registerItem(BYGItemList.JOSHUA_LEAVES = new BlockItem(BYGBlockList.JOSHUA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JOSHUA_LEAVES));
        registerItem(BYGItemList.RIPE_JOSHUA_LEAVES = new BlockItem(BYGBlockList.RIPE_JOSHUA_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RIPE_JOSHUA_LEAVES));
        registerItem(BYGItemList.COOKED_JOSHUA_FRUIT = new Item(new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(5).saturationModifier(0.4f).build())), new Identifier(BYG.MODID, "cooked_joshua_fruit"));
        registerItem(BYGItemList.JOSHUA_FRUIT = new Item(new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.35f).build())), new Identifier(BYG.MODID, "joshua_fruit"));


        registerItem(BYGItemList.ORANGE_BIRCH_SAPLING = new BlockItem(BYGBlockList.ORANGE_BIRCH_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_BIRCH_SAPLING));
        registerItem(BYGItemList.ORANGE_BIRCH_LEAVES = new BlockItem(BYGBlockList.ORANGE_BIRCH_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_BIRCH_LEAVES));

        registerItem(BYGItemList.ORANGE_OAK_SAPLING = new BlockItem(BYGBlockList.ORANGE_OAK_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_OAK_SAPLING));
        registerItem(BYGItemList.ORANGE_OAK_LEAVES = new BlockItem(BYGBlockList.ORANGE_OAK_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_OAK_LEAVES));

        registerItem(BYGItemList.ORANGE_SPRUCE_SAPLING = new BlockItem(BYGBlockList.ORANGE_SPRUCE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_SPRUCE_SAPLING));
        registerItem(BYGItemList.ORANGE_SPRUCE_LEAVES = new BlockItem(BYGBlockList.ORANGE_SPRUCE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_SPRUCE_LEAVES));

        registerItem(BYGItemList.ORCHARD_SAPLING = new BlockItem(BYGBlockList.ORCHARD_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORCHARD_SAPLING));
        registerItem(BYGItemList.RIPE_ORCHARD_LEAVES = new BlockItem(BYGBlockList.RIPE_ORCHARD_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RIPE_ORCHARD_LEAVES));
        registerItem(BYGItemList.FLOWERING_ORCHARD_LEAVES = new BlockItem(BYGBlockList.FLOWERING_ORCHARD_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FLOWERING_ORCHARD_LEAVES));
        registerItem(BYGItemList.ORCHARD_LEAVES = new BlockItem(BYGBlockList.ORCHARD_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORCHARD_LEAVES));

        registerItem(BYGItemList.RED_BIRCH_SAPLING = new BlockItem(BYGBlockList.RED_BIRCH_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_BIRCH_SAPLING));
        registerItem(BYGItemList.RED_BIRCH_LEAVES = new BlockItem(BYGBlockList.RED_BIRCH_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_BIRCH_LEAVES));

        registerItem(BYGItemList.RED_OAK_SAPLING = new BlockItem(BYGBlockList.RED_OAK_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_OAK_SAPLING));
        registerItem(BYGItemList.RED_OAK_LEAVES = new BlockItem(BYGBlockList.RED_OAK_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_OAK_LEAVES));

        registerItem(BYGItemList.RED_SPRUCE_SAPLING = new BlockItem(BYGBlockList.RED_SPRUCE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_SPRUCE_SAPLING));
        registerItem(BYGItemList.RED_SPRUCE_LEAVES = new BlockItem(BYGBlockList.RED_SPRUCE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_SPRUCE_LEAVES));

        registerItem(BYGItemList.YELLOW_BIRCH_SAPLING = new BlockItem(BYGBlockList.YELLOW_BIRCH_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_BIRCH_SAPLING));
        registerItem(BYGItemList.YELLOW_BIRCH_LEAVES = new BlockItem(BYGBlockList.YELLOW_BIRCH_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_BIRCH_LEAVES));

        registerItem(BYGItemList.YELLOW_SPRUCE_SAPLING = new BlockItem(BYGBlockList.YELLOW_SPRUCE_SAPLING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_SPRUCE_SAPLING));
        registerItem(BYGItemList.YELLOW_SPRUCE_LEAVES = new BlockItem(BYGBlockList.YELLOW_SPRUCE_LEAVES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_SPRUCE_LEAVES));


//                  GlowcaneItem
        registerItem(BYGItemList.BLUE_GLOWCANE_DUST = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "blue_glowcane_dust"));
        registerItem(BYGItemList.BLUE_GLOWCANE = new BlockItem(BYGBlockList.BLUE_GLOWCANE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_GLOWCANE));
        registerItem(BYGItemList.BLUE_GLOWCANE_BLOCK = new BlockItem(BYGBlockList.BLUE_GLOWCANE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_GLOWCANE_BLOCK));

        registerItem(BYGItemList.PINK_GLOWCANE_DUST = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pink_glowcane_dust"));
        registerItem(BYGItemList.PINK_GLOWCANE = new BlockItem(BYGBlockList.PINK_GLOWCANE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_GLOWCANE));
        registerItem(BYGItemList.PINK_GLOWCANE_BLOCK = new BlockItem(BYGBlockList.PINK_GLOWCANE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_GLOWCANE_BLOCK));

        registerItem(BYGItemList.PURPLE_GLOWCANE_DUST = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "purple_glowcane_dust"));
        registerItem(BYGItemList.PURPLE_GLOWCANE = new BlockItem(BYGBlockList.PURPLE_GLOWCANE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_GLOWCANE));
        registerItem(BYGItemList.PURPLE_GLOWCANE_BLOCK = new BlockItem(BYGBlockList.PURPLE_GLOWCANE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_GLOWCANE_BLOCK));

        registerItem(BYGItemList.RED_GLOWCANE_DUST = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "red_glowcane_dust"));
        registerItem(BYGItemList.RED_GLOWCANE = new BlockItem(BYGBlockList.RED_GLOWCANE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_GLOWCANE));
        registerItem(BYGItemList.RED_GLOWCANE_BLOCK = new BlockItem(BYGBlockList.RED_GLOWCANE_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_GLOWCANE_BLOCK));

        //Glowshroom
        registerItem(BYGItemList.BLUE_GLOWSHROOM = new BlockItem(BYGBlockList.BLUE_GLOWSHROOM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_GLOWSHROOM));
        registerItem(BYGItemList.BLUE_GLOWSHROOM_BLOCK = new BlockItem(BYGBlockList.BLUE_GLOWSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_GLOWSHROOM_BLOCK));
        registerItem(BYGItemList.PURPLE_GLOWSHROOM = new BlockItem(BYGBlockList.PURPLE_GLOWSHROOM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_GLOWSHROOM));
        registerItem(BYGItemList.PURPLE_GLOWSHROOM_BLOCK = new BlockItem(BYGBlockList.PURPLE_GLOWSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_GLOWSHROOM_BLOCK));
        registerItem(BYGItemList.RED_GLOWSHROOM_STEM = new BlockItem(BYGBlockList.RED_GLOWSHROOM_STEM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_GLOWSHROOM_STEM));
        registerItem(BYGItemList.YELLOW_GLOWSHROOM_STEM = new BlockItem(BYGBlockList.YELLOW_GLOWSHROOM_STEM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_GLOWSHROOM_STEM));

        //Nether
        registerItem(BYGItemList.PERVADED_NETHERRACK = new BlockItem(BYGBlockList.PERVADED_NETHERRACK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PERVADED_NETHERRACK));

        registerItem(BYGItemList.GLOWSTONE_LANTERN = new BlockItem(BYGBlockList.GLOWSTONE_LANTERN, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GLOWSTONE_LANTERN));
        registerItem(BYGItemList.GLOWSTONE_LAMP = new BlockItem(BYGBlockList.GLOWSTONE_LAMP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GLOWSTONE_LAMP));

        registerItem(BYGItemList.WEEPING_ROOTS_PLANT = new BlockItem(BYGBlockList.WEEPING_ROOTS_PLANT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WEEPING_ROOTS_PLANT));

        registerItem(BYGItemList.NETHER_BRISTLE = new BlockItem(BYGBlockList.NETHER_BRISTLE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.NETHER_BRISTLE));
        registerItem(BYGItemList.OVERGROWN_NETHERRACK = new BlockItem(BYGBlockList.OVERGROWN_NETHERRACK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.OVERGROWN_NETHERRACK));
        registerItem(BYGItemList.WARPED_CACTUS = new BlockItem(BYGBlockList.WARPED_CACTUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WARPED_CACTUS));
        registerItem(BYGItemList.WARPED_BUSH = new BlockItem(BYGBlockList.WARPED_BUSH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WARPED_BUSH));
        registerItem(BYGItemList.WARPED_CORAL_BLOCK = new BlockItem(BYGBlockList.WARPED_CORAL_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WARPED_CORAL_BLOCK));
        registerItem(BYGItemList.WARPED_CORAL = new BlockItem(BYGBlockList.WARPED_CORAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WARPED_CORAL));
        registerItem(BYGItemList.WARPED_CORAL_FAN = new BlockItem(BYGBlockList.WARPED_CORAL_FAN, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WARPED_CORAL_FAN));
        registerItem(BYGItemList.NYLIUM_SOUL_SAND = new BlockItem(BYGBlockList.NYLIUM_SOUL_SAND, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.NYLIUM_SOUL_SAND));
        registerItem(BYGItemList.NYLIUM_SOUL_SOIL = new BlockItem(BYGBlockList.NYLIUM_SOUL_SOIL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.NYLIUM_SOUL_SOIL));

        registerItem(BYGItemList.SYTHIAN_NYLIUM = new BlockItem(BYGBlockList.SYTHIAN_NYLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SYTHIAN_NYLIUM));
        registerItem(BYGItemList.SYTHIAN_ROOTS = new BlockItem(BYGBlockList.SYTHIAN_ROOTS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SYTHIAN_ROOTS));
        registerItem(BYGItemList.SYTHIAN_SPROUT = new BlockItem(BYGBlockList.SYTHIAN_SPROUT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SYTHIAN_SPROUT));
        registerItem(BYGItemList.SYTHIAN_STALK_BLOCK = new BlockItem(BYGBlockList.SYTHIAN_STALK_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SYTHIAN_STALK_BLOCK));
        registerItem(BYGItemList.SYTHIAN_SCAFFOLDING = new ScaffoldingItem(BYGBlockList.SYTHIAN_SCAFFOLDING, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SYTHIAN_SCAFFOLDING));

        registerItem(BYGItemList.EMBUR_GEL_BALL = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "embur_gel_ball"));
        registerItem(BYGItemList.EMBUR_GEL_BLOCK = new BlockItem(BYGBlockList.EMBUR_GEL_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_GEL_BLOCK));
        registerItem(BYGItemList.EMBUR_GEL_VINES = new BlockItem(BYGBlockList.EMBUR_GEL_VINES, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_GEL_VINES));
        registerItem(BYGItemList.EMBUR_NYLIUM = new BlockItem(BYGBlockList.EMBUR_NYLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_NYLIUM));
        registerItem(BYGItemList.EMBUR_PEDU = new BlockItem(BYGBlockList.EMBUR_PEDU, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_PEDU));
        registerItem(BYGItemList.EMBUR_ROOTS = new BlockItem(BYGBlockList.EMBUR_ROOTS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_ROOTS));
        registerItem(BYGItemList.EMBUR_WART = new BlockItem(BYGBlockList.EMBUR_WART, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.EMBUR_WART));
        registerItem(BYGItemList.TALL_EMBUR_ROOTS = new BlockItem(BYGBlockList.TALL_EMBUR_ROOTS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TALL_EMBUR_ROOTS));
        registerItem(BYGItemList.EMBUR_LILY = (new EmburLilyItem(BYGBlockList.EMBUR_LILY, (new Item.Settings()).group(BYG.BYG_TAB))), Registry.BLOCK.getId(BYGBlockList.EMBUR_LILY));
        registerItem(BYGItemList.BLUE_NETHERRACK_BRICK = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "blue_nether_brick"));
        registerItem(BYGItemList.BLUE_NETHERRACK = new BlockItem(BYGBlockList.BLUE_NETHERRACK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_NETHERRACK));
        registerItem(BYGItemList.BLUE_NETHERRACK_BRICKS = new BlockItem(BYGBlockList.BLUE_NETHERRACK_BRICKS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_NETHERRACK_BRICKS));


        //End
        registerItem(BYGItemList.IVIS_PHYLIUM = new BlockItem(BYGBlockList.IVIS_PHYLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.IVIS_PHYLIUM));
        registerItem(BYGItemList.IVIS_ROOTS = new BlockItem(BYGBlockList.IVIS_ROOTS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.IVIS_ROOTS));
        registerItem(BYGItemList.IVIS_SPROUT = new BlockItem(BYGBlockList.IVIS_SPROUT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.IVIS_SPROUT));

        //Ice
        registerItem(BYGItemList.BLACK_ICE = new BlockItem(BYGBlockList.BLACK_ICE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_ICE));
        registerItem(BYGItemList.PACKED_BLACK_ICE = new BlockItem(BYGBlockList.PACKED_BLACK_ICE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PACKED_BLACK_ICE));
        registerItem(BYGItemList.FROST_MAGMA = new BlockItem(BYGBlockList.FROST_MAGMA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FROST_MAGMA));
//
//
        //Mushrooms
        registerItem(BYGItemList.GREEN_MUSHSHROOM = new BlockItem(BYGBlockList.GREEN_MUSHSHROOM, new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())), Registry.BLOCK.getId(BYGBlockList.GREEN_MUSHSHROOM));
        registerItem(BYGItemList.GREEN_MUSHROOM_BLOCK = new BlockItem(BYGBlockList.GREEN_MUSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_MUSHROOM_BLOCK));
        registerItem(BYGItemList.WEEPING_MILKCAP = new BlockItem(BYGBlockList.WEEPING_MILKCAP, new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())), Registry.BLOCK.getId(BYGBlockList.WEEPING_MILKCAP));
        registerItem(BYGItemList.MILKCAP_MUSHROOM_BLOCK = new BlockItem(BYGBlockList.MILKCAP_MUSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MILKCAP_MUSHROOM_BLOCK));
        registerItem(BYGItemList.WOOD_BLEWIT = new BlockItem(BYGBlockList.WOOD_BLEWIT, new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())), Registry.BLOCK.getId(BYGBlockList.WOOD_BLEWIT));
        registerItem(BYGItemList.BLEWIT_MUSHROOM_BLOCK = new BlockItem(BYGBlockList.BLEWIT_MUSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLEWIT_MUSHROOM_BLOCK));
        registerItem(BYGItemList.BLACK_PUFF = new BlockItem(BYGBlockList.BLACK_PUFF, new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.6f).build())), Registry.BLOCK.getId(BYGBlockList.BLACK_PUFF));
        registerItem(BYGItemList.PUFF_MUSHROOM_BLOCK = new BlockItem(BYGBlockList.PUFF_MUSHROOM_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PUFF_MUSHROOM_BLOCK));
        registerItem(BYGItemList.WHITE_MUSHROOM_STEM = new BlockItem(BYGBlockList.WHITE_MUSHROOM_STEM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_MUSHROOM_STEM));
        registerItem(BYGItemList.BROWN_MUSHROOM_STEM = new BlockItem(BYGBlockList.BROWN_MUSHROOM_STEM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BROWN_MUSHROOM_STEM));

        //Plants
        registerItem(BYGItemList.BLUE_BERRY = new AliasedBlockItem(BYGBlockList.BLUEBERRY_BUSH, new Item.Settings().group(BYG.BYG_TAB).food(new FoodComponent.Builder().hunger(2).saturationModifier(0.1f).build())), new Identifier(BYG.MODID, "blueberries"));
        registerItem(BYGItemList.CATTAIL = new BlockItem(BYGBlockList.CATTAIL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CATTAIL));
        registerItem(BYGItemList.GOLDEN_SPINED_CACTUS = new BlockItem(BYGBlockList.GOLDEN_SPINED_CACTUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GOLDEN_SPINED_CACTUS));
        registerItem(BYGItemList.HORSEWEED = new BlockItem(BYGBlockList.HORSEWEED, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.HORSEWEED));
        registerItem(BYGItemList.MINI_CACTUS = new BlockItem(BYGBlockList.MINI_CACTUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MINI_CACTUS));
        registerItem(BYGItemList.POISON_IVY = new BlockItem(BYGBlockList.POISON_IVY, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POISON_IVY));
        registerItem(BYGItemList.PRICKLY_PEAR_CACTUS = new BlockItem(BYGBlockList.PRICKLY_PEAR_CACTUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PRICKLY_PEAR_CACTUS));
        registerItem(BYGItemList.PRAIRIE_GRASS = new BlockItem(BYGBlockList.PRAIRIE_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PRAIRIE_GRASS));
        registerItem(BYGItemList.REEDS = new BlockItem(BYGBlockList.REEDS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.REEDS));
        registerItem(BYGItemList.SHORT_GRASS = new BlockItem(BYGBlockList.SHORT_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SHORT_GRASS));
        registerItem(BYGItemList.TALL_PRAIRIE_GRASS = new BlockItem(BYGBlockList.TALL_PRAIRIE_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TALL_PRAIRIE_GRASS));
        registerItem(BYGItemList.TINY_LILYPADS = new BYGLilyItem(BYGBlockList.TINY_LILYPADS, (new Item.Settings()).group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TINY_LILYPADS));
        registerItem(BYGItemList.WATER_SILK = new BYGWaterSilkItem(BYGBlockList.WATER_SILK, (new Item.Settings()).group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WATER_SILK));
        registerItem(BYGItemList.WINTER_SUCCULENT = new BlockItem(BYGBlockList.WINTER_SUCCULENT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WINTER_SUCCULENT));


        registerItem(BYGItemList.WINTER_GRASS = new BlockItem(BYGBlockList.WINTER_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WINTER_GRASS));
        registerItem(BYGItemList.WEED_GRASS = new BlockItem(BYGBlockList.WEED_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WEED_GRASS));
        registerItem(BYGItemList.WILTED_GRASS = new BlockItem(BYGBlockList.WILTED_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WILTED_GRASS));
        registerItem(BYGItemList.SHORT_BEACH_GRASS = new BlockItem(BYGBlockList.SHORT_BEACH_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SHORT_BEACH_GRASS));
        registerItem(BYGItemList.BEACH_GRASS = new BlockItem(BYGBlockList.BEACH_GRASS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BEACH_GRASS));
        registerItem(BYGItemList.LEAF_PILE = new BlockItem(BYGBlockList.LEAF_PILE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.LEAF_PILE));
        registerItem(BYGItemList.CLOVER_PATCH = new BlockItem(BYGBlockList.CLOVER_PATCH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CLOVER_PATCH));
        registerItem(BYGItemList.FLOWER_PATCH = new BlockItem(BYGBlockList.FLOWER_PATCH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FLOWER_PATCH));


        //Petal BYGBlockRenders
        registerItem(BYGItemList.WHITE_PETAL = new BlockItem(BYGBlockList.WHITE_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_PETAL));
        registerItem(BYGItemList.BLUE_PETAL = new BlockItem(BYGBlockList.BLUE_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_PETAL));
        registerItem(BYGItemList.LIGHT_BLUE_PETAL = new BlockItem(BYGBlockList.LIGHT_BLUE_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.LIGHT_BLUE_PETAL));
        registerItem(BYGItemList.PURPLE_PETAL = new BlockItem(BYGBlockList.PURPLE_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_PETAL));
        registerItem(BYGItemList.RED_PETAL = new BlockItem(BYGBlockList.RED_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_PETAL));
        registerItem(BYGItemList.YELLOW_PETAL = new BlockItem(BYGBlockList.YELLOW_PETAL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_PETAL));
        registerItem(BYGItemList.PLANT_STEM = new BlockItem(BYGBlockList.PLANT_STEM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PLANT_STEM));
        registerItem(BYGItemList.POLLEN_BLOCK = new BlockItem(BYGBlockList.POLLEN_BLOCK, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.POLLEN_BLOCK));
        registerItem(BYGItemList.POLLEN_DUST = new Item(new Item.Settings().group(BYG.BYG_TAB)), new Identifier(BYG.MODID, "pollen_dust"));

        //FlowerItems
        registerItem(BYGItemList.TALL_ALLIUM = new BlockItem(BYGBlockList.TALL_ALLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TALL_ALLIUM));
        registerItem(BYGItemList.TALL_PINK_ALLIUM = new BlockItem(BYGBlockList.TALL_PINK_ALLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TALL_PINK_ALLIUM));
        registerItem(BYGItemList.ALLIUM_FLOWER_BUSH = new BlockItem(BYGBlockList.ALLIUM_FLOWER_BUSH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ALLIUM_FLOWER_BUSH));
        registerItem(BYGItemList.ALPINE_BELLFLOWER = new BlockItem(BYGBlockList.ALPINE_BELLFLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ALPINE_BELLFLOWER));
        registerItem(BYGItemList.AMARANTH = new BlockItem(BYGBlockList.AMARANTH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.AMARANTH));
        registerItem(BYGItemList.ANGELICA = new BlockItem(BYGBlockList.ANGELICA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ANGELICA));
        registerItem(BYGItemList.AZALEA = new BlockItem(BYGBlockList.AZALEA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.AZALEA));
        registerItem(BYGItemList.BEGONIA = new BlockItem(BYGBlockList.BEGONIA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BEGONIA));
        registerItem(BYGItemList.BISTORT = new BlockItem(BYGBlockList.BISTORT, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BISTORT));
        registerItem(BYGItemList.BLACK_ROSE = new BlockItem(BYGBlockList.BLACK_ROSE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLACK_ROSE));
        registerItem(BYGItemList.BLUE_SAGE = new BlockItem(BYGBlockList.BLUE_SAGE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.BLUE_SAGE));
        registerItem(BYGItemList.CALIFORNIA_POPPY = new BlockItem(BYGBlockList.CALIFORNIA_POPPY, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CALIFORNIA_POPPY));
        registerItem(BYGItemList.CROCUS = new BlockItem(BYGBlockList.CROCUS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CROCUS));
        registerItem(BYGItemList.CYAN_AMARANTH = new BlockItem(BYGBlockList.CYAN_AMARANTH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYAN_AMARANTH));
        registerItem(BYGItemList.CYAN_ROSE = new BlockItem(BYGBlockList.CYAN_ROSE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYAN_ROSE));
        registerItem(BYGItemList.CYAN_TULIP = new BlockItem(BYGBlockList.CYAN_TULIP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.CYAN_TULIP));
        registerItem(BYGItemList.DAFFODIL = new BlockItem(BYGBlockList.DAFFODIL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DAFFODIL));
        registerItem(BYGItemList.DELPHINIUM = new BlockItem(BYGBlockList.DELPHINIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.DELPHINIUM));
        registerItem(BYGItemList.FAIRY_SLIPPER = new BlockItem(BYGBlockList.FAIRY_SLIPPER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FAIRY_SLIPPER));
        registerItem(BYGItemList.FIRECRACKER_FLOWER_BUSH = new BlockItem(BYGBlockList.FIRECRACKER_FLOWER_BUSH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FIRECRACKER_FLOWER_BUSH));
        registerItem(BYGItemList.FOXGLOVE = new BlockItem(BYGBlockList.FOXGLOVE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.FOXGLOVE));
        registerItem(BYGItemList.GREEN_TULIP = new BlockItem(BYGBlockList.GREEN_TULIP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GREEN_TULIP));
        registerItem(BYGItemList.GUZMANIA = new BlockItem(BYGBlockList.GUZMANIA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.GUZMANIA));
        registerItem(BYGItemList.INCAN_LILY = new BlockItem(BYGBlockList.INCAN_LILY, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.INCAN_LILY));
        registerItem(BYGItemList.IRIS = new BlockItem(BYGBlockList.IRIS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.IRIS));
        registerItem(BYGItemList.JAPANESE_ORCHID = new BlockItem(BYGBlockList.JAPANESE_ORCHID, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.JAPANESE_ORCHID));
        registerItem(BYGItemList.KOVAN_FLOWER = new BlockItem(BYGBlockList.KOVAN_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.KOVAN_FLOWER));
        registerItem(BYGItemList.LAZARUS_BELLFLOWER = new BlockItem(BYGBlockList.LAZARUS_BELLFLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.LAZARUS_BELLFLOWER));
        registerItem(BYGItemList.LOLIPOP_FLOWER = new BlockItem(BYGBlockList.LOLIPOP_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.LOLIPOP_FLOWER));
        registerItem(BYGItemList.MAGENTA_AMARANTH = new BlockItem(BYGBlockList.MAGENTA_AMARANTH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAGENTA_AMARANTH));
        registerItem(BYGItemList.MAGENTA_TULIP = new BlockItem(BYGBlockList.MAGENTA_TULIP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.MAGENTA_TULIP));
        registerItem(BYGItemList.ORANGE_AMARANTH = new BlockItem(BYGBlockList.ORANGE_AMARANTH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_AMARANTH));
        registerItem(BYGItemList.ORANGE_DAISY = new BlockItem(BYGBlockList.ORANGE_DAISY, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORANGE_DAISY));
        registerItem(BYGItemList.ORSIRIA_ROSE = new BlockItem(BYGBlockList.ORSIRIA_ROSE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ORSIRIA_ROSE));
        registerItem(BYGItemList.PEACH_LEATHER_FLOWER = new BlockItem(BYGBlockList.PEACH_LEATHER_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PEACH_LEATHER_FLOWER));
        registerItem(BYGItemList.PINK_ALLIUM = new BlockItem(BYGBlockList.PINK_ALLIUM, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_ALLIUM));
        registerItem(BYGItemList.PINK_ALLIUM_FLOWER_BUSH = new BlockItem(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_ALLIUM_FLOWER_BUSH));
        registerItem(BYGItemList.PINK_ANEMONE = new BlockItem(BYGBlockList.PINK_ANEMONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_ANEMONE));
        registerItem(BYGItemList.PINK_DAFFODIL = new BlockItem(BYGBlockList.PINK_DAFFODIL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_DAFFODIL));
        registerItem(BYGItemList.PINK_ORCHID = new BlockItem(BYGBlockList.PINK_ORCHID, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PINK_ORCHID));
        registerItem(BYGItemList.PROTEA_FLOWER = new BlockItem(BYGBlockList.PROTEA_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PROTEA_FLOWER));
        registerItem(BYGItemList.PURPLE_AMARANTH = new BlockItem(BYGBlockList.PURPLE_AMARANTH, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_AMARANTH));
        registerItem(BYGItemList.PURPLE_ORCHID = new BlockItem(BYGBlockList.PURPLE_ORCHID, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_ORCHID));
        registerItem(BYGItemList.PURPLE_SAGE = new BlockItem(BYGBlockList.PURPLE_SAGE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_SAGE));
        registerItem(BYGItemList.PURPLE_TULIP = new BlockItem(BYGBlockList.PURPLE_TULIP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.PURPLE_TULIP));
        registerItem(BYGItemList.RED_CORNFLOWER = new BlockItem(BYGBlockList.RED_CORNFLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_CORNFLOWER));
        registerItem(BYGItemList.RED_ORCHID = new BlockItem(BYGBlockList.RED_ORCHID, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RED_ORCHID));
        registerItem(BYGItemList.RICHEA = new BlockItem(BYGBlockList.RICHEA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.RICHEA));
        registerItem(BYGItemList.ROSE = new BlockItem(BYGBlockList.ROSE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.ROSE));
        registerItem(BYGItemList.SILVER_VASE_FLOWER = new BlockItem(BYGBlockList.SILVER_VASE_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SILVER_VASE_FLOWER));
        registerItem(BYGItemList.SNOWDROPS = new BlockItem(BYGBlockList.SNOWDROPS, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.SNOWDROPS));
        registerItem(BYGItemList.TORCH_GINGER = new BlockItem(BYGBlockList.TORCH_GINGER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.TORCH_GINGER));
        registerItem(BYGItemList.VIOLET_LEATHER_FLOWER = new BlockItem(BYGBlockList.VIOLET_LEATHER_FLOWER, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.VIOLET_LEATHER_FLOWER));
        registerItem(BYGItemList.WHITE_ANEMONE = new BlockItem(BYGBlockList.WHITE_ANEMONE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_ANEMONE));
        registerItem(BYGItemList.WHITE_SAGE = new BlockItem(BYGBlockList.WHITE_SAGE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WHITE_SAGE));
        registerItem(BYGItemList.WINTER_CYCLAMEN = new BlockItem(BYGBlockList.WINTER_CYCLAMEN, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WINTER_CYCLAMEN));
        registerItem(BYGItemList.WINTER_ROSE = new BlockItem(BYGBlockList.WINTER_ROSE, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WINTER_ROSE));
        registerItem(BYGItemList.WINTER_SCILLA = new BlockItem(BYGBlockList.WINTER_SCILLA, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.WINTER_SCILLA));
        registerItem(BYGItemList.YELLOW_DAFFODIL = new BlockItem(BYGBlockList.YELLOW_DAFFODIL, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_DAFFODIL));
        registerItem(BYGItemList.YELLOW_TULIP = new BlockItem(BYGBlockList.YELLOW_TULIP, new Item.Settings().group(BYG.BYG_TAB)), Registry.BLOCK.getId(BYGBlockList.YELLOW_TULIP));
        BYG.LOGGER.info("BYG: Items registered!");
    }

    public static void registerItem(Item item, Identifier identifier) {
        if (identifier != null && !identifier.equals(new Identifier("minecraft:air")))
            Registry.register(Registry.ITEM, identifier, item);
        else {
            assert identifier != null;
            BYG.LOGGER.error(identifier.toString() + " is missing block");
        }
    }
}
