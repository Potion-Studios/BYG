package potionstudios.byg.common.block;

import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import potionstudios.byg.common.block.nether.DoubleNetherPlantBlock;
import potionstudios.byg.common.block.nether.embur.BlueNetherrackBlock;
import potionstudios.byg.common.block.nether.embur.EmburPlantBlock;
import potionstudios.byg.common.block.nether.glowstonegardens.HangingVinesBlock;
import potionstudios.byg.common.block.nether.glowstonegardens.HangingVinesPlantBlock;
import potionstudios.byg.common.block.nether.glowstonegardens.SoulShroomSporeBlock;
import potionstudios.byg.common.block.nether.glowstonegardens.SoulShroomSporeEndBlock;
import potionstudios.byg.common.block.nether.scorched.ScorchedPlantBlock;
import potionstudios.byg.common.block.nether.subzerohypogeal.SubzeroAshBlock;
import potionstudios.byg.common.block.nether.sythian.*;
import potionstudios.byg.common.block.nether.wailing.HangingBonesBlock;
import potionstudios.byg.common.block.nether.warped.BYGWarpedBushBlock;
import potionstudios.byg.common.block.nether.warped.BYGWarpedCoralPlantBlock;
import potionstudios.byg.common.block.nether.warped.BYGWarpedCoralWallFanBlock;
import potionstudios.byg.common.block.nether.weepingmire.LamentVineBlock;
import potionstudios.byg.common.block.nether.weepingmire.LamentVinePlantBlock;

@SuppressWarnings("deprecation")
public class BYGBlockProperties {

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(
                    BlockBehaviour.Properties.of(Material.PLANT)
                            .sound(SoundType.GRASS)
                            .strength(0.0f)
                            .noCollission()
                            .noOcclusion()
                            .lightLevel((state) -> 8)
            );
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGDoubleNetherPlant extends DoubleNetherPlantBlock {
        public BYGDoubleNetherPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGDoubleDamagePlant extends DoubleDamagePlantBlock {
        public BYGDoubleDamagePlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createPottedBlock(this, registryName);

        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGLily extends WaterlilyBlock {
        public BYGLily(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGEnderLily extends WaterlilyBlock {
        public BYGEnderLily(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.LILY_PAD)
                    .instabreak()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
                    .noCollission()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }


    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGAmaranth extends AmaranthBlock {
        public BYGAmaranth(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGAllium extends TallAlliumBlock {
        public BYGAllium(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPinkAllium extends TallPinkAlliumBlock {
        public BYGPinkAllium(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.ICE)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .friction(0.98F)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.ICE_SOLID)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .friction(0.98F)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .friction(0.98F)
                    .lightLevel((state) -> 10)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGMagma extends MagmaBlock {
        public BYGMagma(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .randomTicks()
                    .lightLevel((state) -> 10)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSubzeroAsh extends SubzeroAshBlock {
        public BYGSubzeroAsh(String registryName) {
            super(BlockBehaviour.Properties.of(Material.TOP_SNOW)
                    .sound(SoundType.SAND)
                    .strength(0.1f)
                    .speedFactor(0.6F)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSubzeroAshBlock extends Block {
        public BYGSubzeroAshBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.SNOW)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(BlockBehaviour.Properties.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .speedFactor(0.4F)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.GRASS)
                    .strength(0.0F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(BlockBehaviour.Properties.of(Material.SAND)
                    .sound(SoundType.SOUL_SAND)
                    .strength(0.5f)
                    .speedFactor(0.6F)

            );
            BYGBlocks.createBlock(this, registryName);
        }

    }

    public static class BYGNyliumSoulSoil extends Block {

        public BYGNyliumSoulSoil(String registryName) {
            super(BlockBehaviour.Properties.of(Material.SAND)
                    .sound(SoundType.SOUL_SOIL)
                    .strength(0.5f)


            );
            BYGBlocks.createBlock(this, registryName);
        }

    }

    public static class BYGQuartziteSand extends Block {
        public BYGQuartziteSand(String registryName) {
            super(BlockBehaviour.Properties.of(Material.SAND)
                    .sound(SoundType.SAND)
                    .strength(0.2f)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class HangingBones extends HangingBonesBlock {
        public HangingBones(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.BONE_BLOCK)
                    .strength(0.0F)
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ScorchedPlant extends ScorchedPlantBlock {
        public ScorchedPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(BlockBehaviour.Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .dropsLike(BYGBlocks.WARPED_CORAL)
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedBushBlock {
        public BYGWarpedBush(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(BlockBehaviour.Properties.of(Material.BAMBOO)
                    .sound(SoundType.BAMBOO)
                    .strength(0.2f)
                    .noOcclusion()
                    .randomTicks()
                    .lightLevel((state) -> 8).dynamicShape()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGWartBlock extends Block {
        public BYGWartBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.WART_BLOCK)
                    .strength(1.0F)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLamentPlant extends NetherSproutsBlock {
        public BYGLamentPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGLamentVinePlant extends LamentVinePlantBlock {
        public BYGLamentVinePlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.LEAVES)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLamentVine extends LamentVineBlock {
        public BYGLamentVine(String registryName) {
            super(BlockBehaviour.Properties.of(Material.LEAVES)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGEmburPlant extends EmburPlantBlock {
        public BYGEmburPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(BlockBehaviour.Properties.of(Material.BAMBOO_SAPLING)
                    .sound(SoundType.BAMBOO_SAPLING)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class SythianPlant extends BYGSythianPlantBlock {
        public SythianPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(BlockBehaviour.Properties.of(Material.WOOL)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .noCollission()
                    .lightLevel((state) -> 9)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGThatch extends HayBlock {
        public BYGThatch(String registryName) {
            super(BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchCarpet extends WoolCarpetBlock {
        public ThatchCarpet(String registryName) {
            super(DyeColor.BROWN, BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchStairs extends StairBlock {
        public ThatchStairs(String registryName) {
            super(BYGBlocks.CATTAIL_THATCH.defaultBlockState(), Properties.copy(BYGBlocks.CATTAIL_THATCH)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchSlab extends SlabBlock {
        public ThatchSlab(String registryName) {
            super(BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(BlockBehaviour.Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(BlockBehaviour.Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGHangingVine extends HangingVinesBlock {
        public BYGHangingVine(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
                    .lightLevel((state) -> 14)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGHangingVinePlant extends HangingVinesPlantBlock {
        public BYGHangingVinePlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSoulShroomSporeEnd extends SoulShroomSporeEndBlock {
        public BYGSoulShroomSporeEnd(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.FUNGUS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
                    .lightLevel((state) -> 14)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSoulShroomSpore extends SoulShroomSporeBlock {
        public BYGSoulShroomSpore(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.FUNGUS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSythianHangingRootsPlant extends HangingSythanRootsPlantBlock {
        public BYGSythianHangingRootsPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSythianHangingRoots extends HangingSythanRootsBlock {
        public BYGSythianHangingRoots(String registryName) {
            super(BlockBehaviour.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class LogBlock extends RotatedPillarBlock {
        public LogBlock(Properties properties) {
            super(properties);
        }
    }

    public static class BYGNetherLog extends LogBlock {
        public BYGNetherLog(String registryName) {
            super(BlockBehaviour.Properties.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGNetherWood extends RotatedPillarBlock {
        public BYGNetherWood(String registryName) {
            super(BlockBehaviour.Properties.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    //Saving this for later do not touch
//    
//    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
//    }

    public static class BYGPervadedNetherrack extends OreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .strength(0.4F, 0.4F)
                    .lightLevel((state) -> 13)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class AnthraciteOre extends OreBlock {
        public AnthraciteOre(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.NETHER_ORE)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }


    public static class BlockHugeMushroom extends HugeMushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }
    }

    public static class BlockHugeNetherMushroom extends HugeMushroomBlock {
        public BlockHugeNetherMushroom(String registryName) {
            super(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeNetherMushroomStem extends HugeMushroomBlock {
        public BlockHugeNetherMushroomStem(String registryName) {
            super(BlockBehaviour.Properties.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BulbisShell extends HugeMushroomBlock {
        public BulbisShell(String registryName) {
            super(BlockBehaviour.Properties.of(Material.GLASS, MaterialColor.COLOR_CYAN)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.2F)
                    .noOcclusion()
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(BlockBehaviour.Properties.of(Material.DECORATION, MaterialColor.SAND)
                    .sound(SoundType.SCAFFOLDING)
                    .strength(0.0f, 0.0f)
                    .dynamicShape()
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGStoneStairs extends StairBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.COBBLESTONE)
                    
                    .sound(SoundType.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(BlockBehaviour.Properties.of(Material.GRASS)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.3F)
                    .lightLevel((state) -> 15)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGBlueNetherrackBricks extends BlueNetherrackBlock {
        public BYGBlueNetherrackBricks(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHER_BRICKS)
                    .strength(0.4F, 0.4F)

                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPillar extends RotatedPillarBlock {
        public BYGPillar(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()


            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLantern extends LanternBlock {
        public BYGLantern(String registryName) {
            super(BlockBehaviour.Properties.of(Material.METAL)
                    .sound(SoundType.LANTERN)
                    .strength(3.5F)
                    .lightLevel((state) -> 15)
                    .noOcclusion()

                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }
}

