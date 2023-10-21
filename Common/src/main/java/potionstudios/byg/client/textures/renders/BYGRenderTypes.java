package potionstudios.byg.client.textures.renders;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.block.BYGWoodTypes;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

public class BYGRenderTypes {
    public static void renderTypes(Consumer<Map<Block, RenderType>> mapConsumer) {
        BYG.logDebug("BYG: Rendering Texture Cutouts...");
        Map<Block, RenderType> map = new HashMap<>();

        for (BYGWoodTypes type : BYGWoodTypes.values()) {
            final var renderType = switch (type) {
                case ASPEN, SKYRIS, MAPLE -> RenderType.translucent();
                default -> RenderType.cutoutMipped();
            };
            map.put(type.door().get(), renderType);
            map.put(type.trapdoor().get(), renderType);
            if (type.growerItem() != null)
                map.put(type.growerItem().get(), RenderType.cutoutMipped());
        }
        map.put(BYGBlocks.SHELF_FUNGI.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_BLOSSOM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WITCH_HAZEL_BRANCH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ALOE_VERA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BLOOMING_ALOE_VERA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HORSEWEED.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_SAGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BLUE_ROSE_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.MINI_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PRICKLY_PEAR_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_SUCCULENT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_CHERRY_FOLIAGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_PINK_ALLIUM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_ALLIUM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_BONE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.QUARTZ_CRYSTAL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_BELL_BLOSSOM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WAILING_VINES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SCORCHED_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SCORCHED_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_CAMPFIRE.get(), RenderType.cutoutMipped());
        //Nether
        map.put(BYGBlocks.SOUL_SHROOM_SPORE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SOUL_SHROOM_SPORE_END.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SOUL_SHROOM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.DEATH_CAP.get(), RenderType.cutoutMipped());

        map.put(BYGBlocks.ARISIAN_BLOOM_BRANCH.get(), RenderType.cutoutMipped());

        map.put(BYGBlocks.WARPED_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL_FAN.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WARPED_CORAL_WALL_FAN.get(), RenderType.cutoutMipped());

        map.put(BYGBlocks.SYTHIAN_ROOTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_SPROUT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_STALK_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_NYLIUM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_SYTHIAN_ROOTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HANGING_SYTHIAN_ROOTS_PLANT.get(), RenderType.cutoutMipped());

        //End
        map.put(BYGBlocks.IVIS_ROOTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IVIS_SPROUT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_SPROUTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.THEREAL_BELLFLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_ODDITY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_SHELL.get(), RenderType.translucent());
        map.put(BYGBlocks.BULBIS_SHELL.get(), RenderType.translucent());
        map.put(BYGBlocks.NIGHTSHADE_BERRY_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.NIGHTSHADE_ROOTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.VERMILION_SCULK_GROWTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_LANTERN.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_CRYSTAL_CLUSTER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.LARGE_THERIUM_CRYSTAL_BUD.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.MEDIUM_THERIUM_CRYSTAL_BUD.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SMALL_THERIUM_CRYSTAL_BUD.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_LANTERN.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_LANTERN.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_END_ROD.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ODDITY_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ODDITY_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_CAMPFIRE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ENDER_LILY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_BRAMBLE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FUNGAL_IMPARIUS_FILAMENT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FUNGAL_IMPARIUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_VINE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_VINE_PLANT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_MUSHROOM_BRANCH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IMPARIUS_BUSH.get(), RenderType.cutoutMipped());

        //Sea Plants
        map.put(BYGBlocks.CATTAIL_SPROUT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CATTAIL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.TINY_LILYPADS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_TINY_LILY_PADS.get(), RenderType.cutoutMipped());

        map.put(BYGBlocks.WATER_SILK.get(), RenderType.cutoutMipped());

        //Grass
        map.put(BYGBlocks.BLOOMING_WITCH_HAZEL_LEAVES.get(), RenderType.translucent());
        map.put(BYGBlocks.TALL_PRAIRIE_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BEACH_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_BEACH_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.LEAF_PILE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CLOVER_PATCH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWER_PATCH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SHRUB.get(), RenderType.cutoutMipped());


        //Saplings
        map.put(BYGBlocks.BLUE_SPRUCE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_BIRCH_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_OAK_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.JACARANDA_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.INDIGO_JACARANDA_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_JACARANDA_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_INDIGO_JACARANDA_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.INDIGO_JACARANDA_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.JOSHUA_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_BIRCH_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_OAK_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_SPRUCE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORCHARD_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PALO_VERDE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_BIRCH_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_MAPLE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_OAK_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RED_SPRUCE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SILVER_MAPLE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_CHERRY_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_BIRCH_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_SPRUCE_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BROWN_ZELKOVA_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ARAUCARIA_SAPLING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_SAPLING.get(), RenderType.cutout());

        //Mushrooms
        map.put(BYGBlocks.WHITE_PUFFBALL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WEEPING_MILKCAP.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WOOD_BLEWIT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_MUSHROOM.get(), RenderType.cutoutMipped());


        //FlowerBlocks
        map.put(BYGBlocks.ALLIUM_FLOWER_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ALPINE_BELLFLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.AMARANTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ANGELICA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HYDRANGEA_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HYDRANGEA_HEDGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BEGONIA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BISTORT.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CALIFORNIA_POPPY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CROCUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BLACK_ROSE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_AMARANTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_ROSE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CYAN_TULIP.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.DAFFODIL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.DELPHINIUM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FAIRY_SLIPPER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FIRECRACKER_FLOWER_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FOXGLOVE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.GOLDEN_SPINED_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_TULIP.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.GUZMANIA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.INCAN_LILY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.IRIS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.JAPANESE_ORCHID.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.KOVAN_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.LAZARUS_BELLFLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.LOLLIPOP_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.MAGENTA_AMARANTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.MAGENTA_TULIP.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_AMARANTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORANGE_DAISY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ORSIRIA_ROSE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PEACH_LEATHER_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ALLIUM.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ALLIUM_FLOWER_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_ANEMONE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PINK_DAFFODIL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PROTEA_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_AMARANTH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_SAGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_TULIP.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RICHEA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ROSE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SNOWDROPS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SILVER_VASE_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.VIOLET_LEATHER_FLOWER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_ANEMONE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WHITE_SAGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_CYCLAMEN.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_ROSE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WINTER_SCILLA.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_DAFFODIL.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.YELLOW_TULIP.get(), RenderType.cutoutMipped());

        //Other renders
        map.put(BYGBlocks.BARREL_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_BARREL_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CARVED_BARREL_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.WATER_BARREL_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.HONEY_BARREL_CACTUS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.AMETRINE_CLUSTER.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BORIC_FIRE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.CRYPTIC_FIRE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.THERIUM_GLASS.get(), RenderType.translucent());
        map.put(BYGBlocks.THERIUM_GLASS_PANE.get(), RenderType.translucent());
        map.put(BYGBlocks.ETHER_FOLIAGE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.VERMILION_SCULK_TENDRILS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.TALL_ETHER_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_SPROUTS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BULBIS_ANOMALY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PURPLE_BULBIS_ANOMALY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.ETHER_BULB.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BAOBAB_FRUIT_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.APPLE_FRUIT_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.GREEN_APPLE_FRUIT_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.JOSHUA_FRUIT_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_SKYRIS_LEAVES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_BAOBAB_LEAVES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.FLOWERING_JOSHUA_LEAVES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RIPE_BAOBAB_LEAVES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.RIPE_JOSHUA_LEAVES.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.BLACK_ICE.get(), RenderType.translucent());
        map.put(BYGBlocks.AMETRINE_BLOCK.get(), RenderType.translucent());
        map.put(BYGBlocks.BLUEBERRY_BUSH.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SYTHIAN_SCAFFOLDING.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.OVERGROWN_STONE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.OVERGROWN_DACITE.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.PRAIRIE_GRASS.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.LUSH_GRASS_BLOCK.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.POISON_IVY.get(), RenderType.cutoutMipped());
        map.put(BYGBlocks.SKYRIS_VINE.get(), RenderType.cutoutMipped());

        for (final var potBlock : BYGBlocks.FLOWER_POT_BLOCKS)
            map.put(potBlock.get(), RenderType.cutoutMipped());

        BYG.logDebug("BYG: Texture Cutouts Rendered!");

        mapConsumer.accept(map);
    }
}
