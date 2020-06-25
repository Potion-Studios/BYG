package voronoiaoc.byg.common.properties.vanilla;//package voronoiaoc.byg.common.properties.vanilla;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.HoeItem;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Set;

public class BYGHoeables {
    public static void tillablesBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoe Tillables...");
        addTillable(BYGBlockList.OVERGROWN_STONE, Blocks.FARMLAND.getDefaultState());
        addTillable(BYGBlockList.OVERGROWN_DACITE, Blocks.FARMLAND.getDefaultState());
        addTillable(BYGBlockList.PODZOL_DACITE, Blocks.FARMLAND.getDefaultState());
        addTillable(BYGBlockList.MEADOW_GRASSBLOCK, Blocks.FARMLAND.getDefaultState());
        addTillable(BYGBlockList.MEADOW_DIRT, Blocks.FARMLAND.getDefaultState());
        addTillable(BYGBlockList.PEAT, Blocks.FARMLAND.getDefaultState());
        BYG.LOGGER.debug("BYG: Added Hoe Tillables!!");
    }

    public static void effectiveBlocksBYG() {
        BYG.LOGGER.debug("BYG: Adding Hoe Effective Blocks...");
        addEffectiveBlocks(BYGBlockList.ASPEN_LEAVES);
        addEffectiveBlocks(BYGBlockList.BAOBAB_LEAVES);
        addEffectiveBlocks(BYGBlockList.BLOOMING_WITCH_HAZEL_LEAVES);
        addEffectiveBlocks(BYGBlockList.BLUE_ENCHANTED_LEAVES);
        addEffectiveBlocks(BYGBlockList.BLUE_SPRUCE_LEAVES);
        addEffectiveBlocks(BYGBlockList.BROWN_BIRCH_LEAVES);
        addEffectiveBlocks(BYGBlockList.BROWN_OAK_LEAVES);
        addEffectiveBlocks(BYGBlockList.CIKA_LEAVES);
        addEffectiveBlocks(BYGBlockList.CYPRESS_LEAVES);
        addEffectiveBlocks(BYGBlockList.EBONY_LEAVES);
        addEffectiveBlocks(BYGBlockList.FIR_LEAVES);
        addEffectiveBlocks(BYGBlockList.FLOWERING_ORCHARD_LEAVES);
        addEffectiveBlocks(BYGBlockList.FLOWERING_PALO_VERDE_LEAVES);
        addEffectiveBlocks(BYGBlockList.GREEN_ENCHANTED_LEAVES);
        addEffectiveBlocks(BYGBlockList.HOLLY_BERRY_LEAVES);
        addEffectiveBlocks(BYGBlockList.HOLLY_LEAVES);
        addEffectiveBlocks(BYGBlockList.INDIGO_JACARANDA_LEAVES);
        addEffectiveBlocks(BYGBlockList.JACARANDA_LEAVES);
        addEffectiveBlocks(BYGBlockList.JOSHUA_LEAVES);
        addEffectiveBlocks(BYGBlockList.MAHOGANY_LEAVES);
        addEffectiveBlocks(BYGBlockList.MAPLE_LEAVES);
        addEffectiveBlocks(BYGBlockList.ORANGE_BIRCH_LEAVES);
        addEffectiveBlocks(BYGBlockList.ORANGE_OAK_LEAVES);
        addEffectiveBlocks(BYGBlockList.ORANGE_SPRUCE_LEAVES);
        addEffectiveBlocks(BYGBlockList.ORCHARD_LEAVES);
        addEffectiveBlocks(BYGBlockList.PALO_VERDE_LEAVES);
        addEffectiveBlocks(BYGBlockList.PINE_LEAVES);
        addEffectiveBlocks(BYGBlockList.PINK_CHERRY_LEAVES);
        addEffectiveBlocks(BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES);
        addEffectiveBlocks(BYGBlockList.RED_BIRCH_LEAVES);
        addEffectiveBlocks(BYGBlockList.RED_MAPLE_LEAVES);
        addEffectiveBlocks(BYGBlockList.RED_OAK_LEAVES);
        addEffectiveBlocks(BYGBlockList.RED_SPRUCE_LEAVES);
        addEffectiveBlocks(BYGBlockList.REDWOOD_LEAVES);
        addEffectiveBlocks(BYGBlockList.RIPE_JOSHUA_LEAVES);
        addEffectiveBlocks(BYGBlockList.RIPE_ORCHARD_LEAVES);
        addEffectiveBlocks(BYGBlockList.SILVER_MAPLE_LEAVES);
        addEffectiveBlocks(BYGBlockList.SKYRIS_LEAVES);
        addEffectiveBlocks(BYGBlockList.WHITE_CHERRY_LEAVES);
        addEffectiveBlocks(BYGBlockList.WILLOW_LEAVES);
        addEffectiveBlocks(BYGBlockList.WITCH_HAZEL_LEAVES);
        addEffectiveBlocks(BYGBlockList.YELLOW_BIRCH_LEAVES);
        addEffectiveBlocks(BYGBlockList.YELLOW_SPRUCE_LEAVES);
        addEffectiveBlocks(BYGBlockList.ZELKOVA_LEAVES);
        addEffectiveBlocks(BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE);
        BYG.LOGGER.debug("BYG: Added Hoe Effective Blocks!");

    }

    public static void addTillable(Block block, BlockState state) {
        HoeItem.TILLED_BLOCKS = Maps.newHashMap(HoeItem.TILLED_BLOCKS);
        HoeItem.TILLED_BLOCKS.put(block, state);
    }

    public static void addEffectiveBlocks(Block block) {
        Set<Block> effectiveBlocksSet = Sets.newHashSet(HoeItem.EFFECTIVE_BLOCKS);
        effectiveBlocksSet.add(block);
        HoeItem.EFFECTIVE_BLOCKS = ImmutableSet.copyOf(effectiveBlocksSet);
    }
}

