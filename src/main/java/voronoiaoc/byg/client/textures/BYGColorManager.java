package voronoiaoc.byg.client.textures;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import voronoiaoc.byg.core.byglists.BYGBlockList;
import voronoiaoc.byg.core.byglists.BYGItemList;

@Environment(EnvType.CLIENT)
public class BYGColorManager {

    public static void addColors() {
        //Foilage
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getDefaultColor(),
                BYGBlockList.MAHOGANY_LEAVES, BYGBlockList.POISON_IVY, BYGBlockList.LEAF_PILE, BYGBlockList.ORCHARD_LEAVES, BYGBlockList.FLOWERING_ORCHARD_LEAVES, BYGBlockList.RIPE_ORCHARD_LEAVES, BYGBlockList.RAINBOW_EUCALYPTUS_LEAVES, BYGBlockList.WILLOW_LEAVES, BYGBlockList.MAPLE_LEAVES, BYGBlockList.JOSHUA_LEAVES, BYGBlockList.RIPE_JOSHUA_LEAVES
        );

        //Grass
        ColorProviderRegistry.BLOCK.register(
                (state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : FoliageColors.getDefaultColor(),
                BYGBlockList.MEADOW_GRASSBLOCK, BYGBlockList.OVERGROWN_STONE, BYGBlockList.OVERGROWN_NETHERRACK, BYGBlockList.SHORT_GRASS, BYGBlockList.TINY_LILYPADS, BYGBlockList.OVERGROWN_DACITE, BYGBlockList.GLOWCELIUM, BYGBlockList.WILTED_GRASS, BYGBlockList.WEED_GRASS, BYGBlockList.NETHER_BRISTLE, BYGBlockList.WATER_SILK
        );

        //Items
        ColorProviderRegistry.ITEM.register(((stack, tintIndex) -> FoliageColors.getDefaultColor()),
                BYGItemList.MEADOW_GRASSBLOCK, BYGItemList.OVERGROWN_NETHERRACK, BYGItemList.MAHOGANY_LEAVES, BYGItemList.POISON_IVY, BYGItemList.OVERGROWN_STONE, BYGItemList.SHORT_GRASS, BYGItemList.TINY_LILYPADS, BYGItemList.NETHER_BRISTLE, BYGItemList.OVERGROWN_DACITE, BYGItemList.GLOWCELIUM, BYGItemList.WILTED_GRASS, BYGItemList.WEED_GRASS, BYGItemList.LEAF_PILE, BYGItemList.ORCHARD_LEAVES, BYGItemList.FLOWERING_ORCHARD_LEAVES, BYGItemList.RIPE_ORCHARD_LEAVES, BYGItemList.RAINBOW_EUCALYPTUS_LEAVES, BYGItemList.WILLOW_LEAVES, BYGItemList.WATER_SILK, BYGItemList.MAPLE_LEAVES, BYGItemList.JOSHUA_LEAVES, BYGItemList.RIPE_JOSHUA_LEAVES
        );
    }
}
