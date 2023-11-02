package potionstudios.byg.common;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FireBlock;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import potionstudios.byg.BYG;
import potionstudios.byg.common.registration.BYGBlockFamilies;
import potionstudios.byg.common.registration.BYGBlockFamily;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;
import potionstudios.byg.mixin.access.FireBlockAccess;
import potionstudios.byg.reg.RegistryObject;

import javax.annotation.Nullable;

public class BYGFlammables {
    public static void flammableBlock(@Nullable Block block, int flameOdds, int burnOdds) {
        if (block != null) {
            FireBlock fire = (FireBlock) Blocks.FIRE;
            ((FireBlockAccess) fire).byg_setFlammable(block, flameOdds, burnOdds);
        }
    }
    public static void flammableBlock(@Nullable RegistryObject<? extends Block> block, int flameOdds, int burnOdds) {
        flammableBlock(block == null ? null : block.get(), flameOdds, burnOdds);
    }

    public static void flammablesBYG() {
        BYG.logDebug("BYG: Adding Flammables...");

        for(BYGBlockFamily family: BYGBlockFamilies.woodFamilyMap.values()) {
            if (family.getDimension().equals(BuiltinDimensionTypes.OVERWORLD)) {
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.LOG), 5, 5);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.STRIPPED_LOG), 5, 5);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.WOOD), 5, 5);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.STRIPPED_WOOD), 5, 5);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.BOOKSHELF), 5, 20);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.SLAB), 5, 20);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.STAIRS), 5, 20);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.PLANKS), 5, 20);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.FENCE), 5, 20);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.LEAVES), 30, 60);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.FRUIT_LEAVES), 30, 60);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.FLOWERING_LEAVES), 30, 60);
                flammableBlock(family.get(BYGBlockFamily.BlockVariant.FRUIT_BLOCK), 30, 60);
            }
        }

        //Logs
        flammableBlock(BYGBlocks.PALO_VERDE_LOG.get(), 5, 5);

        //Stripped Logs
        flammableBlock(BYGBlocks.STRIPPED_PALO_VERDE_LOG.get(), 5, 5);

        //Wood
        flammableBlock(BYGBlocks.PALO_VERDE_WOOD.get(), 5, 5);

        //Stripped Wood
        flammableBlock(BYGBlocks.STRIPPED_PALO_VERDE_WOOD.get(), 5, 5);

        //Leaves
        flammableBlock(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BLUE_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BROWN_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.BROWN_OAK_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FLOWERING_PALO_VERDE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_OAK_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.ORANGE_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.PALO_VERDE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RED_OAK_LEAVES.get(), 30, 60);

        flammableBlock(BYGBlocks.SILVER_MAPLE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.RED_MAPLE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.YELLOW_BIRCH_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.YELLOW_SPRUCE_LEAVES.get(), 30, 60);
        flammableBlock(BYGBlocks.FIRECRACKER_LEAVES.get(), 60, 30);
        flammableBlock(BYGBlocks.RED_BIRCH_LEAVES.get(), 60, 30);
        flammableBlock(BYGBlocks.RED_SPRUCE_LEAVES.get(), 60, 30);

        //Flowers
        flammableBlock(BYGBlocks.ALLIUM_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.ALPINE_BELLFLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.ANGELICA.get(), 60, 100);
        flammableBlock(BYGBlocks.HYDRANGEA_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.HYDRANGEA_HEDGE.get(), 60, 100);
        flammableBlock(BYGBlocks.BEGONIA.get(), 60, 100);
        flammableBlock(BYGBlocks.BISTORT.get(), 60, 100);
        flammableBlock(BYGBlocks.BLACK_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.BLUE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.BLUE_ROSE_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.CALIFORNIA_POPPY.get(), 60, 100);
        flammableBlock(BYGBlocks.CROCUS.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.CYAN_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.DELPHINIUM.get(), 60, 100);
        flammableBlock(BYGBlocks.FAIRY_SLIPPER.get(), 60, 100);
        flammableBlock(BYGBlocks.FIRECRACKER_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.FOXGLOVE.get(), 60, 100);
        flammableBlock(BYGBlocks.GOLDEN_SPINED_CACTUS.get(), 60, 100);
        flammableBlock(BYGBlocks.GREEN_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.GUZMANIA.get(), 60, 100);
        flammableBlock(BYGBlocks.INCAN_LILY.get(), 60, 100);
        flammableBlock(BYGBlocks.IRIS.get(), 60, 100);
        flammableBlock(BYGBlocks.JAPANESE_ORCHID.get(), 60, 100);
        flammableBlock(BYGBlocks.KOVAN_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.LAZARUS_BELLFLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.LOLLIPOP_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.MAGENTA_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.MAGENTA_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.ORANGE_DAISY.get(), 60, 100);
        flammableBlock(BYGBlocks.ORSIRIA_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.PEACH_LEATHER_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ALLIUM.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_ANEMONE.get(), 60, 100);
        flammableBlock(BYGBlocks.PINK_DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.PRAIRIE_GRASS.get(), 60, 100);
        flammableBlock(BYGBlocks.PROTEA_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_AMARANTH.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.PURPLE_TULIP.get(), 60, 100);
        flammableBlock(BYGBlocks.RICHEA.get(), 60, 100);
        flammableBlock(BYGBlocks.ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.SILVER_VASE_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.SNOWDROPS.get(), 60, 100);
        flammableBlock(BYGBlocks.VIOLET_LEATHER_FLOWER.get(), 60, 100);
        flammableBlock(BYGBlocks.WHITE_ANEMONE.get(), 60, 100);
        flammableBlock(BYGBlocks.WHITE_SAGE.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_CYCLAMEN.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_ROSE.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_SCILLA.get(), 60, 100);
        flammableBlock(BYGBlocks.YELLOW_DAFFODIL.get(), 60, 100);
        flammableBlock(BYGBlocks.YELLOW_TULIP.get(), 60, 100);

        //Plants
        flammableBlock(BYGBlocks.FLOWER_PATCH.get(), 60, 100);
        flammableBlock(BYGBlocks.CLOVER_PATCH.get(), 60, 100);
        flammableBlock(BYGBlocks.HORSEWEED.get(), 60, 100);
        flammableBlock(BYGBlocks.WINTER_SUCCULENT.get(), 60, 100);
        flammableBlock(BYGBlocks.POISON_IVY.get(), 15, 100);
        flammableBlock(BYGBlocks.SHRUB.get(), 15, 100);
        flammableBlock(BYGBlocks.JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.FLOWERING_JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.INDIGO_JACARANDA_BUSH.get(), 15, 100);
        flammableBlock(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH.get(), 15, 100);

        BYG.logInfo("BYG: Added Flammables!");
    }
}
