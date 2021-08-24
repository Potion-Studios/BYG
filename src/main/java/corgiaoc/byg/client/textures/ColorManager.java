package corgiaoc.byg.client.textures;

import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.BYGItems;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.GrassColors;
import net.minecraft.world.biome.BiomeColors;

public class ColorManager {

    public static void onBlockColorsInit(BlockColors blockColors) {
        //registers the colors for blocks that changes colors based on biome
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageGrassColor(lightReader, pos) : GrassColors.get(0.5D, 1.0D), BYGBlocks.MEADOW_GRASSBLOCK, BYGBlocks.OVERGROWN_STONE, BYGBlocks.OVERGROWN_NETHERRACK, BYGBlocks.SHORT_GRASS, BYGBlocks.TINY_LILYPADS, BYGBlocks.OVERGROWN_DACITE, BYGBlocks.GLOWCELIUM, BYGBlocks.WILTED_GRASS, BYGBlocks.WEED_GRASS, BYGBlocks.NETHER_BRISTLE, BYGBlocks.WATER_SILK);
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageFoliageColor(lightReader, pos) : FoliageColors.get(0.5D, 1.0D), BYGBlocks.MAHOGANY_LEAVES, BYGBlocks.POISON_IVY, BYGBlocks.LEAF_PILE, BYGBlocks.ORCHARD_LEAVES, BYGBlocks.FLOWERING_ORCHARD_LEAVES, BYGBlocks.RIPE_ORCHARD_LEAVES, BYGBlocks.RAINBOW_EUCALYPTUS_LEAVES, BYGBlocks.WILLOW_LEAVES, BYGBlocks.MAPLE_LEAVES, BYGBlocks.JOSHUA_LEAVES, BYGBlocks.RIPE_JOSHUA_LEAVES, BYGBlocks.MOSSY_NETHERRACK);
    }

    public static void onItemColorsInit(BlockColors blockColors, ItemColors itemColors) {
        // Use the Block's colour handler for an ItemBlock
        IItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(state, null, null, tintIndex);
        };

        if (itemBlockColourHandler != null) {
            itemColors.register(itemBlockColourHandler,
                    BYGItems.MEADOW_GRASSBLOCK, BYGItems.OVERGROWN_NETHERRACK, BYGItems.MAHOGANY_LEAVES,
                    BYGItems.POISON_IVY, BYGItems.OVERGROWN_STONE, BYGItems.SHORT_GRASS,
                    BYGItems.TINY_LILYPADS, BYGItems.NETHER_BRISTLE, BYGItems.OVERGROWN_DACITE,
                    BYGItems.GLOWCELIUM, BYGItems.WILTED_GRASS, BYGItems.WEED_GRASS, BYGItems.LEAF_PILE,
                    BYGItems.ORCHARD_LEAVES, BYGItems.FLOWERING_ORCHARD_LEAVES, BYGItems.RIPE_ORCHARD_LEAVES,
                    BYGItems.RAINBOW_EUCALYPTUS_LEAVES, BYGItems.WILLOW_LEAVES, BYGItems.WATER_SILK,
                    BYGItems.MAPLE_LEAVES, BYGItems.JOSHUA_LEAVES, BYGItems.RIPE_JOSHUA_LEAVES, BYGBlocks.MOSSY_NETHERRACK);
        }

    }
}
