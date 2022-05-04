package potionstudios.byg.client.textures;

import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.item.BYGItems;

public class ColorManager {

    public static synchronized void onBlockColorsInit(BlockColors blockColors) {
        //registers the colors for blocks that changes colors based on biome
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageGrassColor(lightReader, pos) : GrassColor.get(0.5D, 1.0D), BYGBlocks.LUSH_GRASS_BLOCK.get(), BYGBlocks.OVERGROWN_STONE.get(), BYGBlocks.OVERGROWN_NETHERRACK.get(), BYGBlocks.TINY_LILYPADS.get(), BYGBlocks.OVERGROWN_DACITE.get(), BYGBlocks.NETHER_BRISTLE.get());
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageFoliageColor(lightReader, pos) : FoliageColor.get(0.5D, 1.0D), BYGBlocks.MAHOGANY_LEAVES.get(), BYGBlocks.POISON_IVY.get(), BYGBlocks.LEAF_PILE.get(), BYGBlocks.ORCHARD_LEAVES.get(), BYGBlocks.FLOWERING_ORCHARD_LEAVES.get(), BYGBlocks.RIPE_ORCHARD_LEAVES.get(), BYGBlocks.WILLOW_LEAVES.get(), BYGBlocks.MAPLE_LEAVES.get(), BYGBlocks.JOSHUA_LEAVES.get(), BYGBlocks.RIPE_JOSHUA_LEAVES.get(), BYGBlocks.CYPRESS_LEAVES.get());
        blockColors.register((unknown, lightReader, pos, unknown2) -> lightReader != null && pos != null ? BiomeColors.getAverageWaterColor(lightReader, pos) : -1, BYGBlocks.WATER_BARREL_CACTUS.get());
    }

    public static synchronized void onItemColorsInit(BlockColors blockColors, ItemColors itemColors) {
        // Use the Block's colour handler from BlockItem
        ItemColor itemBlockColourHandler = (stack, tintIndex) -> {
            BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return blockColors.getColor(state, null, null, tintIndex);
        };


        if (itemBlockColourHandler != null) {
            itemColors.register(itemBlockColourHandler,
                BYGItems.LUSH_GRASS_BLOCK.get(), BYGItems.OVERGROWN_NETHERRACK.get(), BYGItems.MAHOGANY_LEAVES.get(),
                BYGItems.POISON_IVY.get(), BYGItems.OVERGROWN_STONE.get(),
                BYGItems.TINY_LILYPADS.get(), BYGItems.NETHER_BRISTLE.get(), BYGItems.OVERGROWN_DACITE.get(), BYGItems.LEAF_PILE.get(),
                BYGItems.ORCHARD_LEAVES.get(), BYGItems.FLOWERING_ORCHARD_LEAVES.get(), BYGItems.RIPE_ORCHARD_LEAVES.get(),
                BYGItems.WILLOW_LEAVES.get(), BYGItems.CYPRESS_LEAVES.get(),
                BYGItems.MAPLE_LEAVES.get(), BYGItems.JOSHUA_LEAVES.get(), BYGItems.RIPE_JOSHUA_LEAVES.get());
        }
    }
}