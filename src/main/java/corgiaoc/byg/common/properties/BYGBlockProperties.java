package corgiaoc.byg.common.properties;

import corgiaoc.byg.client.textures.BYGMaterials;
import corgiaoc.byg.common.properties.blocks.*;
import corgiaoc.byg.common.properties.blocks.end.CrypticFireBlock;
import corgiaoc.byg.common.properties.blocks.grassblocks.BYGGlowCeliumBlock;
import corgiaoc.byg.common.properties.blocks.nether.BoricFireBlock;
import corgiaoc.byg.common.properties.blocks.nether.CrystalBlock;
import corgiaoc.byg.common.properties.blocks.nether.DoubleNetherPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.embur.BlueNetherrackBlock;
import corgiaoc.byg.common.properties.blocks.nether.embur.EmburPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.HangingVinesBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.HangingVinesPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.SoulShroomSporeBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.SoulShroomSporeEndBlock;
import corgiaoc.byg.common.properties.blocks.nether.scorched.ScorchedPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.subzerohypogeal.SubzeroAshBlock;
import corgiaoc.byg.common.properties.blocks.nether.sythian.*;
import corgiaoc.byg.common.properties.blocks.nether.wailing.HangingBonesBlock;
import corgiaoc.byg.common.properties.blocks.nether.warped.*;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVineBlock;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVinePlantBlock;
import corgiaoc.byg.core.BYGBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

@SuppressWarnings("deprecation")
public class BYGBlockProperties {

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(
                    FabricBlockSettings.of(Material.PLANT)
                            .sound(SoundType.GRASS)
                            .strength(0.0f)
                            .noCollission()
                            .noOcclusion()
                            .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGDoubleNetherPlant extends DoubleNetherPlantBlock {
        public BYGDoubleNetherPlant(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
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
            super(FabricBlockSettings.of(Material.PLANT)
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
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
            BYGBlocks.createPottedBlock(this, registryName);

        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
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
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGEnderLily extends WaterlilyBlock {
        public BYGEnderLily(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.LILY_PAD)
                    .instabreak()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
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
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }


    public static class BYGTallGrass extends TallGrassBlock {
        public BYGTallGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
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
            super(FabricBlockSettings.of(Material.ICE)
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
            super(FabricBlockSettings.of(Material.ICE_SOLID)
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
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES)
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
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES)
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
            super(FabricBlockSettings.of(Material.TOP_SNOW).breakByTool(FabricToolTags.SHOVELS)
                    .sound(SoundType.SAND)
                    .strength(0.1f)
                    .speedFactor(0.6F)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGSubzeroAshBlock extends Block {
        public BYGSubzeroAshBlock(String registryName) {
            super(FabricBlockSettings.of(Material.SNOW).breakByTool(FabricToolTags.SHOVELS)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(FabricBlockSettings.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .speedFactor(0.4F)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.GLOWCELIUM)
                    .sound(SoundType.GRAVEL)
                    .strength(0.6f)
                    .randomTicks()
                    .lightLevel((state) -> 10)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }


    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, FabricBlockSettings.of(Material.LEAVES, MaterialColor.GRASS)
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
            super(FabricBlockSettings.of(Material.SAND).breakByTool(FabricToolTags.SHOVELS)
                    .sound(SoundType.SOUL_SAND)
                    .strength(0.5f)
                    .speedFactor(0.6F)

            );
            BYGBlocks.createBlock(this, registryName);
        }

    }

    public static class BYGNyliumSoulSoil extends Block {

        public BYGNyliumSoulSoil(String registryName) {
            super(FabricBlockSettings.of(Material.SAND).breakByTool(FabricToolTags.SHOVELS)
                    .sound(SoundType.SOUL_SOIL)
                    .strength(0.5f)


            );
            BYGBlocks.createBlock(this, registryName);
        }

    }

    public static class Crystal extends CrystalBlock {
        public Crystal(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sound(SoundType.GLASS)
                    .strength(0.1F)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGQuartziteSand extends Block {
        public BYGQuartziteSand(String registryName) {
            super(FabricBlockSettings.of(Material.SAND).breakByTool(FabricToolTags.SHOVELS)
                    .sound(SoundType.SAND)
                    .strength(0.2f)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class HangingBones extends HangingBonesBlock {
        public HangingBones(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sound(SoundType.BONE_BLOCK)
                    .strength(0.0F)
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ScorchedPlant extends ScorchedPlantBlock {
        public ScorchedPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWarpedCactus extends WarpedCactusBlock {
        public BYGWarpedCactus(String registryName) {
            super(FabricBlockSettings.of(Material.CACTUS)
                    .sound(SoundType.WOOL)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(FabricBlockSettings.of(Material.WATER_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.BAMBOO)
                    .sound(SoundType.BAMBOO)
                    .strength(0.2f)
                    .noOcclusion()
                    .randomTicks()
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);

        }
    }

    public static class BYGWartBlock extends Block {
        public BYGWartBlock(String registryName) {
            super(FabricBlockSettings.of(Material.GRASS).breakByTool(FabricToolTags.HOES)
                    .sound(SoundType.WART_BLOCK)
                    .strength(1.0F)

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLamentPlant extends NetherSproutsBlock {
        public BYGLamentPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
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
            super(FabricBlockSettings.of(Material.LEAVES)
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
            super(FabricBlockSettings.of(Material.LEAVES)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.BAMBOO_SAPLING)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.STONE)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .lightLevel((state) -> 8)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(FabricBlockSettings.of(Material.WOOL)
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
            super(FabricBlockSettings.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchCarpet extends WoolCarpetBlock {
        public ThatchCarpet(String registryName) {
            super(DyeColor.BROWN, FabricBlockSettings.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchStairs extends StairBlock {
        public ThatchStairs(String registryName) {
            super(BYGBlocks.REED_THATCH.defaultBlockState(), Properties.copy(BYGBlocks.REED_THATCH)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class ThatchSlab extends SlabBlock {
        public ThatchSlab(String registryName) {
            super(FabricBlockSettings.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
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
            super(FabricBlockSettings.of(Material.LEAVES)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.REPLACEABLE_FIREPROOF_PLANT)
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
            super(FabricBlockSettings.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BoricCampfire extends CampfireBlock {
        public BoricCampfire(String registryName) {
            super(true, 5, FabricBlockSettings.of(Material.WOOD, MaterialColor.PODZOL)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((state) -> 14)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BoricFire extends BoricFireBlock {
        public BoricFire(String registryName) {
            super(FabricBlockSettings.of(Material.FIRE, MaterialColor.COLOR_GREEN)
                    .sound(SoundType.WOOL)
                    .noCollission()
                    .instabreak()
                    .lightLevel((state) -> 14)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class CrypticFire extends CrypticFireBlock {
        public CrypticFire(String registryName) {
            super(FabricBlockSettings.of(Material.FIRE, MaterialColor.COLOR_GREEN)
                    .sound(SoundType.WOOL)
                    .noCollission()
                    .instabreak()
                    .lightLevel((state) -> 14)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class CrypticCampfire extends CampfireBlock {
        public CrypticCampfire(String registryName) {
            super(true, 5, FabricBlockSettings.of(Material.WOOD, MaterialColor.PODZOL)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .noOcclusion()
                    .lightLevel((state) -> 14)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGNetherWood extends RotatedPillarBlock {
        public BYGNetherWood(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    //Saving this for later do not touch
//    @Environment(EnvType.CLIENT)
//    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
//    }

    public static class BYGPervadedNetherrack extends BYGOreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 2)
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .strength(0.4F, 0.4F)
                    .lightLevel((state) -> 13)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class AnthraciteOre extends BYGOreBlock {
        public AnthraciteOre(String registryName) {
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES, 3)
                    .sound(SoundType.NETHER_ORE)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGREDGlowCane extends BYGGlowcane {
        public BYGREDGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.RED_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPINKGlowCane extends BYGGlowcane {
        public BYGPINKGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.PINK_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPURPLEGlowCane extends BYGGlowcane {
        public BYGPURPLEGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.PURPLE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGBLUEGlowCane extends BYGGlowcane {
        public BYGBLUEGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.BLUE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F, 0.0F)
                    .noOcclusion()
                    .noCollission()
                    .randomTicks()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .strength(0.0f, 0.0f)
                    .noCollission()
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }


    public static class BlockHugeMushroom extends HugeMushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }
    }

    public static class BlockHugeNetherMushroom extends HugeMushroomBlock {
        public BlockHugeNetherMushroom(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeNetherMushroomStem extends HugeMushroomBlock {
        public BlockHugeNetherMushroomStem(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroom extends HugeMushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(FabricBlockSettings.of(Material.GLASS, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .noOcclusion()
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroomStem extends HugeMushroomBlock {
        public BlockHugeGlowshroomStem(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BulbisShell extends HugeMushroomBlock {
        public BulbisShell(String registryName) {
            super(FabricBlockSettings.of(Material.GLASS, MaterialColor.COLOR_CYAN)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.2F)
                    .noOcclusion()
                    .lightLevel((state) -> 12)
            );
            BYGBlocks.createBlock(this, registryName);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(FabricBlockSettings.of(Material.DECORATION, MaterialColor.SAND)
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
            super(Blocks.COBBLESTONE.defaultBlockState(), FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .sound(SoundType.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(FabricBlockSettings.of(Material.GRASS)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.3F)
                    .lightLevel((state) -> 15)
            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(FabricBlockSettings.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).breakByTool(FabricToolTags.PICKAXES)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGBlueNetherrackBricks extends BlueNetherrackBlock {
        public BYGBlueNetherrackBricks(String registryName) {
            super(FabricBlockSettings.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE).breakByTool(FabricToolTags.PICKAXES)
                    .sound(SoundType.NETHER_BRICKS)
                    .strength(0.4F, 0.4F)

                    .requiresCorrectToolForDrops()

            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGPillar extends RotatedPillarBlock {
        public BYGPillar(String registryName) {
            super(FabricBlockSettings.of(Material.STONE).breakByTool(FabricToolTags.PICKAXES)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()


            );
            BYGBlocks.createBlock(this, registryName);
        }
    }

    public static class BYGLantern extends Lantern {
        public BYGLantern(String registryName) {
            super(FabricBlockSettings.of(Material.METAL).breakByTool(FabricToolTags.PICKAXES)
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

