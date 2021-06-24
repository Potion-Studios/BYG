package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.textures.BYGMaterials;
import corgiaoc.byg.common.properties.blocks.*;
import corgiaoc.byg.common.properties.blocks.end.CrypticFireBlock;
import corgiaoc.byg.common.properties.blocks.end.EndPlantBlock;
import corgiaoc.byg.common.properties.blocks.grassblocks.BYGGlowCeliumBlock;
import corgiaoc.byg.common.properties.blocks.nether.BoricFireBlock;
import corgiaoc.byg.common.properties.blocks.nether.CrystalBlock;
import corgiaoc.byg.common.properties.blocks.nether.DoubleNetherPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.embur.BlueNetherrackBlock;
import corgiaoc.byg.common.properties.blocks.nether.embur.EmburPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.embur.EmburVinesPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.HangingVinesBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.HangingVinesPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.SoulShroomSporeBlock;
import corgiaoc.byg.common.properties.blocks.nether.glowstonegardens.SoulShroomSporeEndBlock;
import corgiaoc.byg.common.properties.blocks.nether.scorched.ScorchedPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.subzerohypogeal.SubzeroAshBlock;
import corgiaoc.byg.common.properties.blocks.nether.sythian.*;
import corgiaoc.byg.common.properties.blocks.nether.wailing.HangingBonesBlock;
import corgiaoc.byg.common.properties.blocks.nether.wailing.WailingGrassBlock;
import corgiaoc.byg.common.properties.blocks.nether.warped.*;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVineBlock;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVinePlantBlock;
import corgiaoc.byg.core.BYGBlocks;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;

@SuppressWarnings("deprecation")
public class BYGBlockProperties {

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(
                    FabricBlockSettings.of(Material.PLANT)
                            .sounds(BlockSoundGroup.GRASS)
                            .strength(0.0f)
                            .noCollision()
                            .nonOpaque()
                            .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGDoubleNetherPlant extends DoubleNetherPlantBlock {
        public BYGDoubleNetherPlant(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGDoubleDamagePlant extends DoubleDamagePlantBlock {
        public BYGDoubleDamagePlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGDesertPlant extends BYGDesertPlants {
        public BYGDesertPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);

        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLily extends LilyPadBlock {
        public BYGLily(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .nonOpaque()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEnderLily extends LilyPadBlock {
        public BYGEnderLily(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.LILY_PAD)
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .nonOpaque()
                    .noCollision()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGTallGrass extends FernBlock {
        public BYGTallGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAmaranth extends AmaranthBlock {
        public BYGAmaranth(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAllium extends TallAlliumBlock {
        public BYGAllium(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPinkAllium extends TallPinkAlliumBlock {
        public BYGPinkAllium(String registryName) {
            super(FabricBlockSettings.of(Material.REPLACEABLE_PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(FabricBlockSettings.of(Material.ICE)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .slipperiness(0.98F)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(FabricBlockSettings.of(Material.DENSE_ICE)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .slipperiness(0.98F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(0.2f)
                    .slipperiness(0.98F)
                    .luminance((state) -> 10)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMagma extends MagmaBlock {
        public BYGMagma(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(0.2f)
                    .ticksRandomly()
                    .luminance((state) -> 10)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSubzeroAsh extends SubzeroAshBlock {
        public BYGSubzeroAsh(String registryName) {
            super(FabricBlockSettings.of(Material.SNOW_LAYER)
                    .sounds(BlockSoundGroup.SAND)
                    .strength(0.1f)
                    .breakByTool(FabricToolTags.SHOVELS)
                    .velocityMultiplier(0.6F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSubzeroAshBlock extends Block {
        public BYGSubzeroAshBlock(String registryName) {
            super(FabricBlockSettings.of(Material.SNOW_BLOCK)
                    .sounds(BlockSoundGroup.SAND)
                    .strength(0.2f)
                    .breakByTool(FabricToolTags.SHOVELS)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(FabricBlockSettings.of(Material.SOIL)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(0.2f)
                    .velocityMultiplier(0.4F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.GLOWCELIUM)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(0.6f)
                    .ticksRandomly()
                    .luminance((state) -> 10)

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, FabricBlockSettings.of(Material.LEAVES, MapColor.PALE_GREEN)
                    .strength(0.0F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(FabricBlockSettings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SOUL_SAND)
                    .strength(0.5f)
                    .velocityMultiplier(0.6F)
                    .breakByTool(FabricToolTags.SHOVELS)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }

    }

    public static class BYGNyliumSoulSoil extends Block {

        public BYGNyliumSoulSoil(String registryName) {
            super(FabricBlockSettings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SOUL_SOIL)
                    .strength(0.5f)
                    .breakByTool(FabricToolTags.SHOVELS)

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }

    }

    public static class Crystal extends CrystalBlock {
        public Crystal(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.1F)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGQuartziteSand extends Block {
        public BYGQuartziteSand(String registryName) {
            super(FabricBlockSettings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SAND)
                    .strength(0.2f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class HangingBones extends HangingBonesBlock {
        public HangingBones(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.BONE)
                    .strength(0.0F)
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class WailingVines extends VineBlock {
        public WailingVines(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.WEEPING_VINES_LOW_PITCH)
                    .strength(0.0F)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class WailingGrass extends WailingGrassBlock {
        public WailingGrass(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ScorchedPlant extends ScorchedPlantBlock {
        public ScorchedPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCactus extends WarpedCactusBlock {
        public BYGWarpedCactus(String registryName) {
            super(FabricBlockSettings.of(Material.CACTUS)
                    .sounds(BlockSoundGroup.WOOL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(FabricBlockSettings.of(Material.UNDERWATER_PLANT)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedFanCoral extends BYGWarpedFinBlock {
        public BYGWarpedFanCoral(String registryName) {
            super(FabricBlockSettings.of(Material.UNDERWATER_PLANT)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .dropsLike(BYGBlocks.WARPED_CORAL)
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .dropsLike(BYGBlocks.WARPED_CORAL)
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedBushBlock {
        public BYGWarpedBush(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(FabricBlockSettings.of(Material.BAMBOO)
                    .sounds(BlockSoundGroup.BAMBOO)
                    .strength(0.2f)
                    .nonOpaque()
                    .ticksRandomly()
                    .dynamicBounds()
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWartBlock extends Block {
        public BYGWartBlock(String registryName) {
            super(FabricBlockSettings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.WART_BLOCK)
                    .strength(1.0F)
                    .breakByTool(FabricToolTags.HOES)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentPlant extends SproutsBlock {
        public BYGLamentPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLamentVinePlant extends LamentVinePlantBlock {
        public BYGLamentVinePlant(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentVine extends LamentVineBlock {
        public BYGLamentVine(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburGelBlock extends HoneyBlock {
        public BYGEmburGelBlock(String registryName) {
            super(FabricBlockSettings.of(Material.ORGANIC_PRODUCT)
                    .sounds(BlockSoundGroup.HONEY)
                    .nonOpaque()
                    .velocityMultiplier(1.1F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburGelVine extends EmburVinesPlantBlock {
        public BYGEmburGelVine(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.HONEY)
                    .strength(0.0F)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburPlant extends EmburPlantBlock {
        public BYGEmburPlant(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(FabricBlockSettings.of(Material.BAMBOO_SAPLING)
                    .sounds(BlockSoundGroup.BAMBOO_SAPLING)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianPlant extends BYGSythianPlantBlock {
        public SythianPlant(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class EndPlant extends EndPlantBlock {
        public EndPlant(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.ROOTS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.CORAL)
                    .strength(0.2f)
                    .luminance((state) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.CORAL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .noCollision()
                    .luminance((state) -> 9)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGThatch extends HayBlock {
        public BYGThatch(String registryName) {
            super(FabricBlockSettings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.5f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchCarpet extends CarpetBlock {
        public ThatchCarpet(String registryName) {
            super(FabricBlockSettings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.5f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchStairs extends StairsBlock {
        public ThatchStairs(String registryName) {
            super(BYGBlocks.REED_THATCH.getDefaultState(), AbstractBlock.Settings.copy(BYGBlocks.REED_THATCH)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.5f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchSlab extends SlabBlock {
        public ThatchSlab(String registryName) {
            super(FabricBlockSettings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.5f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVine extends HangingVinesBlock {
        public BYGHangingVine(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
                    .luminance((state) -> 14)

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVinePlant extends HangingVinesPlantBlock {
        public BYGHangingVinePlant(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSporeEnd extends SoulShroomSporeEndBlock {
        public BYGSoulShroomSporeEnd(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.FUNGUS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
                    .luminance((state) -> 14)

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSpore extends SoulShroomSporeBlock {
        public BYGSoulShroomSpore(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.FUNGUS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRootsPlant extends HangingSythanRootsPlantBlock {
        public BYGSythianHangingRootsPlant(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRoots extends HangingSythanRootsBlock {
        public BYGSythianHangingRoots(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_SHOOTS)
                    .sounds(BlockSoundGroup.WEEPING_VINES)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class LogBlock extends PillarBlock {
        public LogBlock(AbstractBlock.Settings properties) {
            super(properties);
        }
    }

    public static class BYGNetherLog extends LogBlock {
        public BYGNetherLog(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricCampfire extends CampfireBlock {
        public BoricCampfire(String registryName) {
            super(true, 5, FabricBlockSettings.of(Material.WOOD, MapColor.SPRUCE_BROWN)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .ticksRandomly()
                    .nonOpaque()
                    .luminance((state) -> 14)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricFire extends BoricFireBlock {
        public BoricFire(String registryName) {
            super(FabricBlockSettings.of(Material.FIRE, MapColor.GREEN)
                    .sounds(BlockSoundGroup.WOOL)
                    .noCollision()
                    .breakInstantly()
                    .luminance((state) -> 14)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticFire extends CrypticFireBlock {
        public CrypticFire(String registryName) {
            super(FabricBlockSettings.of(Material.FIRE, MapColor.GREEN)
                    .sounds(BlockSoundGroup.WOOL)
                    .noCollision()
                    .breakInstantly()
                    .luminance((state) -> 14)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticCampfire extends CampfireBlock {
        public CrypticCampfire(String registryName) {
            super(true, 5, FabricBlockSettings.of(Material.WOOD, MapColor.SPRUCE_BROWN)
                    .strength(2.0F)
                    .sounds(BlockSoundGroup.WOOD)
                    .ticksRandomly()
                    .nonOpaque()
                    .luminance((state) -> 14)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherWood extends PillarBlock {
        public BYGNetherWood(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    //Saving this for later do not touch
//    @OnlyIn(Dist.CLIENT)
//    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
//    }

    public static class BYGOreAmetrine extends BYGOreBlock {
        public BYGOreAmetrine(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3.0f, 3.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 3)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGOrePendorite extends BYGOreBlock {
        public BYGOrePendorite(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3.0f, 3.0f)
                    .breakByTool(FabricToolTags.PICKAXES, 3)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPervadedNetherrack extends BYGOreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.NETHER_GOLD_ORE)
                    .strength(0.4F, 0.4F)
                    .luminance((state) -> 13)
                    .breakByTool(FabricToolTags.PICKAXES, 2)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class AnthraciteOre extends BYGOreBlock {
        public AnthraciteOre(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.NETHER_ORE)
                    .strength(0.4F, 0.4F)
                    .breakByTool(FabricToolTags.PICKAXES, 3)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGREDGlowCane extends BYGGlowcane {
        public BYGREDGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.RED_GLOWCANE)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .luminance((state) -> 10)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPINKGlowCane extends BYGGlowcane {
        public BYGPINKGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.PINK_GLOWCANE)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .luminance((state) -> 10)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPURPLEGlowCane extends BYGGlowcane {
        public BYGPURPLEGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.PURPLE_GLOWCANE)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .luminance((state) -> 10)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBLUEGlowCane extends BYGGlowcane {
        public BYGBLUEGlowCane(String registryName) {
            super(FabricBlockSettings.of(BYGMaterials.BLUE_GLOWCANE)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .luminance((state) -> 10)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0F, 0.0F)
                    .nonOpaque()
                    .noCollision()
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(FabricBlockSettings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
                    .strength(0.0f, 0.0f)
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BlockHugeMushroom extends MushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(0.2F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }
    }

    public static class BlockHugeNetherMushroom extends MushroomBlock {
        public BlockHugeNetherMushroom(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.DIRT_BROWN)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(0.2F)
                    .luminance((state) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeNetherMushroomStem extends MushroomBlock {
        public BlockHugeNetherMushroomStem(String registryName) {
            super(FabricBlockSettings.of(Material.NETHER_WOOD, MapColor.DIRT_BROWN)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(0.2F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroom extends MushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(0.2F)
                    .nonOpaque()
                    .luminance((state) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroomStem extends MushroomBlock {
        public BlockHugeGlowshroomStem(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MapColor.DIRT_BROWN)
                    .sounds(BlockSoundGroup.NETHER_STEM)
                    .strength(0.2F)
                    .luminance((state) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BulbisShell extends MushroomBlock {
        public BulbisShell(String registryName) {
            super(FabricBlockSettings.of(Material.WOOD, MapColor.CYAN)
                    .sounds(BlockSoundGroup.SHROOMLIGHT)
                    .strength(0.2F)
                    .nonOpaque()
                    .luminance((state) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateManager.getDefaultState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(FabricBlockSettings.of(Material.DECORATION, MapColor.PALE_YELLOW)
                    .sounds(BlockSoundGroup.SCAFFOLDING)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .dynamicBounds()
                    .luminance((state) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStoneStairs extends StairsBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.COBBLESTONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresTool()
                    .breakByTool(FabricToolTags.PICKAXES)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(FabricBlockSettings.of(Material.GLASS)
                    .sounds(BlockSoundGroup.SHROOMLIGHT)
                    .strength(0.3F)
                    .luminance((state) -> 15)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_BLUE)
                    .sounds(BlockSoundGroup.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrack extends BlueNetherrackBlock {
        public BYGBlueNetherrack(String registryName) {
            super(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_BLUE)
                    .sounds(BlockSoundGroup.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrackBricks extends BlueNetherrackBlock {
        public BYGBlueNetherrackBricks(String registryName) {
            super(FabricBlockSettings.of(Material.STONE, MapColor.TERRACOTTA_BLUE)
                    .sounds(BlockSoundGroup.NETHER_BRICKS)
                    .strength(0.4F, 0.4F)
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPillar extends PillarBlock {
        public BYGPillar(String registryName) {
            super(FabricBlockSettings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresTool()
                    .breakByTool(FabricToolTags.PICKAXES)

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLantern extends LanternBlock {
        public BYGLantern(String registryName) {
            super(FabricBlockSettings.of(Material.METAL)
                    .sounds(BlockSoundGroup.LANTERN)
                    .strength(3.5F)
                    .luminance((state) -> 15)
                    .nonOpaque()
                    .breakByTool(FabricToolTags.PICKAXES)
                    .requiresTool()

            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MOD_ID, registryName), this);
            BYGBlocks.blocksList.add(this);
        }
    }
}

