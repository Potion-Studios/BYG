package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
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
import corgiaoc.byg.common.properties.blocks.nether.wailing.WailingPlantBlock;
import corgiaoc.byg.common.properties.blocks.nether.warped.*;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVineBlock;
import corgiaoc.byg.common.properties.blocks.nether.weepingmire.LamentVinePlantBlock;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.DyeColor;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.ToolType;

@SuppressWarnings("deprecation")
public class BYGBlockProperties {

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(
                    AbstractBlock.Properties.of(Material.PLANT)
                            .sound(SoundType.GRASS)
                            .strength(0.0f)
                            .noCollission()
                            .noOcclusion()
                            .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGDoubleNetherPlant extends DoubleNetherPlantBlock {
        public BYGDoubleNetherPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGDoubleDamagePlant extends DoubleDamagePlantBlock {
        public BYGDoubleDamagePlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);

        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLily extends LilyPadBlock {
        public BYGLily(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEnderLily extends LilyPadBlock {
        public BYGEnderLily(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.LILY_PAD)
                    .instabreak()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
                    .noCollission()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGTallGrass extends TallGrassBlock {
        public BYGTallGrass(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAmaranth extends AmaranthBlock {
        public BYGAmaranth(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAllium extends TallAlliumBlock {
        public BYGAllium(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPinkAllium extends TallPinkAlliumBlock {
        public BYGPinkAllium(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.ICE)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .friction(0.98F)
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.ICE_SOLID)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .friction(0.98F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .friction(0.98F)
                    .lightLevel((state) -> 10)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMagma extends MagmaBlock {
        public BYGMagma(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .randomTicks()
                    .lightLevel((state) -> 10)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSubzeroAsh extends SubzeroAshBlock {
        public BYGSubzeroAsh(String registryName) {
            super(AbstractBlock.Properties.of(Material.TOP_SNOW)
                    .sound(SoundType.SAND)
                    .strength(0.1f)
                    .harvestTool(ToolType.SHOVEL)
                    .speedFactor(0.6F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSubzeroAshBlock extends Block {
        public BYGSubzeroAshBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.SNOW)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
                    .harvestTool(ToolType.SHOVEL)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(AbstractBlock.Properties.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .speedFactor(0.4F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(AbstractBlock.Properties.of(BYGMaterials.GLOWCELIUM)
                    .sound(SoundType.GRAVEL)
                    .strength(0.6f)
                    .randomTicks()
                    .lightLevel((state) -> 10)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, AbstractBlock.Properties.of(Material.LEAVES, MaterialColor.GRASS)
                    .strength(0.0F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(AbstractBlock.Properties.of(Material.SAND)
                    .sound(SoundType.SOUL_SAND)
                    .strength(0.5f)
                    .speedFactor(0.6F)
                    .harvestTool(ToolType.SHOVEL)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }

    }

    public static class BYGNyliumSoulSoil extends Block {

        public BYGNyliumSoulSoil(String registryName) {
            super(AbstractBlock.Properties.of(Material.SAND)
                    .sound(SoundType.SOUL_SOIL)
                    .strength(0.5f)
                    .harvestTool(ToolType.SHOVEL)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }

    }

    public static class Crystal extends CrystalBlock {
        public Crystal(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.GLASS)
                    .strength(0.1F)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGQuartziteSand extends Block {
        public BYGQuartziteSand(String registryName) {
            super(AbstractBlock.Properties.of(Material.SAND)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
                    .harvestTool(ToolType.SHOVEL)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class HangingBones extends HangingBonesBlock {
        public HangingBones(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.BONE_BLOCK)
                    .strength(0.0F)
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ScorchedPlant extends ScorchedPlantBlock {
        public ScorchedPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCactus extends WarpedCactusBlock {
        public BYGWarpedCactus(String registryName) {
            super(AbstractBlock.Properties.of(Material.CACTUS)
                    .sound(SoundType.WOOL)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(AbstractBlock.Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedFanCoral extends BYGWarpedFinBlock {
        public BYGWarpedFanCoral(String registryName) {
            super(AbstractBlock.Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .dropsLike(BYGBlocks.WARPED_CORAL)
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .dropsLike(BYGBlocks.WARPED_CORAL)
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedBushBlock {
        public BYGWarpedBush(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(AbstractBlock.Properties.of(Material.BAMBOO)
                    .sound(SoundType.BAMBOO)
                    .strength(0.2f)
                    .noOcclusion()
                    .randomTicks()
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWartBlock extends Block {
        public BYGWartBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.GRASS)
                    .sound(SoundType.WART_BLOCK)
                    .strength(1.0F)
                    .harvestTool(ToolType.HOE)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentPlant extends NetherSproutsBlock {
        public BYGLamentPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLamentVinePlant extends LamentVinePlantBlock {
        public BYGLamentVinePlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.LEAVES)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentVine extends LamentVineBlock {
        public BYGLamentVine(String registryName) {
            super(AbstractBlock.Properties.of(Material.LEAVES)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburPlant extends EmburPlantBlock {
        public BYGEmburPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(AbstractBlock.Properties.of(Material.BAMBOO_SAPLING)
                    .sound(SoundType.BAMBOO_SAPLING)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianPlant extends BYGSythianPlantBlock {
        public SythianPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.ROOTS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .lightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(AbstractBlock.Properties.of(Material.LEAVES)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .noCollission()
                    .lightLevel((state) -> 9)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGThatch extends HayBlock {
        public BYGThatch(String registryName) {
            super(AbstractBlock.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchCarpet extends CarpetBlock {
        public ThatchCarpet(String registryName) {
            super(DyeColor.BROWN, AbstractBlock.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchStairs extends StairsBlock {
        public ThatchStairs(String registryName) {
            super(BYGBlocks.REED_THATCH.defaultBlockState(), AbstractBlock.Properties.copy(BYGBlocks.REED_THATCH)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchSlab extends SlabBlock {
        public ThatchSlab(String registryName) {
            super(AbstractBlock.Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(AbstractBlock.Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(AbstractBlock.Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVine extends HangingVinesBlock {
        public BYGHangingVine(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
                    .lightLevel((state) -> 14)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVinePlant extends HangingVinesPlantBlock {
        public BYGHangingVinePlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSporeEnd extends SoulShroomSporeEndBlock {
        public BYGSoulShroomSporeEnd(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.FUNGUS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
                    .lightLevel((state) -> 14)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSpore extends SoulShroomSporeBlock {
        public BYGSoulShroomSpore(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.FUNGUS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRootsPlant extends HangingSythanRootsPlantBlock {
        public BYGSythianHangingRootsPlant(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRoots extends HangingSythanRootsBlock {
        public BYGSythianHangingRoots(String registryName) {
            super(AbstractBlock.Properties.of(Material.REPLACEABLE_FIREPROOF_PLANT)
                    .sound(SoundType.WEEPING_VINES)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class LogBlock extends RotatedPillarBlock {
        public LogBlock(AbstractBlock.Properties properties) {
            super(properties);
        }
    }

    public static class BYGNetherLog extends LogBlock {
        public BYGNetherLog(String registryName) {
            super(AbstractBlock.Properties.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricCampfire extends CampfireBlock {
        public BoricCampfire(String registryName) {
            super(true, 5, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.PODZOL)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricFire extends BoricFireBlock {
        public BoricFire(String registryName) {
            super(AbstractBlock.Properties.of(Material.FIRE, MaterialColor.COLOR_GREEN)
                    .sound(SoundType.WOOL)
                    .noCollission()
                    .instabreak()
                    .lightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticFire extends CrypticFireBlock {
        public CrypticFire(String registryName) {
            super(AbstractBlock.Properties.of(Material.FIRE, MaterialColor.COLOR_GREEN)
                    .sound(SoundType.WOOL)
                    .noCollission()
                    .instabreak()
                    .lightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticCampfire extends CampfireBlock {
        public CrypticCampfire(String registryName) {
            super(true, 5, AbstractBlock.Properties.of(Material.WOOD, MaterialColor.PODZOL)
                    .strength(2.0F)
                    .sound(SoundType.WOOD)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherWood extends RotatedPillarBlock {
        public BYGNetherWood(String registryName) {
            super(AbstractBlock.Properties.of(Material.NETHER_WOOD)
                    .sound(SoundType.STEM)
                    .strength(2.0f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    //Saving this for later do not touch
//    @OnlyIn(Dist.CLIENT)
//    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
//    }

    public static class BYGPervadedNetherrack extends BYGOreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.NETHER_GOLD_ORE)
                    .strength(0.4F, 0.4F)
                    .harvestLevel(2)
                    .lightLevel((state) -> 13)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class AnthraciteOre extends BYGOreBlock {
        public AnthraciteOre(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.NETHER_ORE)
                    .strength(0.4F, 0.4F)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGREDGlowCane extends BYGGlowcane {
        public BYGREDGlowCane(String registryName) {
            super(AbstractBlock.Properties.of(BYGMaterials.RED_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPINKGlowCane extends BYGGlowcane {
        public BYGPINKGlowCane(String registryName) {
            super(AbstractBlock.Properties.of(BYGMaterials.PINK_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPURPLEGlowCane extends BYGGlowcane {
        public BYGPURPLEGlowCane(String registryName) {
            super(AbstractBlock.Properties.of(BYGMaterials.PURPLE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBLUEGlowCane extends BYGGlowcane {
        public BYGBLUEGlowCane(String registryName) {
            super(AbstractBlock.Properties.of(BYGMaterials.BLUE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((state) -> 10)
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F, 0.0F)
                    .noOcclusion()
                    .noCollission()
                    .randomTicks()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(AbstractBlock.Properties.of(Material.PLANT)
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .strength(0.0f, 0.0f)
                    .noCollission()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BlockHugeMushroom extends HugeMushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }
    }

    public static class BlockHugeNetherMushroom extends HugeMushroomBlock {
        public BlockHugeNetherMushroom(String registryName) {
            super(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .lightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeNetherMushroomStem extends HugeMushroomBlock {
        public BlockHugeNetherMushroomStem(String registryName) {
            super(AbstractBlock.Properties.of(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroom extends HugeMushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .noOcclusion()
                    .lightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroomStem extends HugeMushroomBlock {
        public BlockHugeGlowshroomStem(String registryName) {
            super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.STEM)
                    .strength(0.2F)
                    .lightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BulbisShell extends HugeMushroomBlock {
        public BulbisShell(String registryName) {
            super(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.COLOR_CYAN)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.2F)
                    .noOcclusion()
                    .lightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.registerDefaultState(this.stateDefinition.any().setValue(NORTH, true).setValue(EAST, true).setValue(SOUTH, true).setValue(WEST, true).setValue(UP, true).setValue(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(AbstractBlock.Properties.of(Material.DECORATION, MaterialColor.SAND)
                    .sound(SoundType.SCAFFOLDING)
                    .strength(0.0f, 0.0f)
                    .dynamicShape()
                    .lightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStoneStairs extends StairsBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.defaultBlockState(), AbstractBlock.Properties.copy(Blocks.COBBLESTONE)
                    .sound(SoundType.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(AbstractBlock.Properties.of(Material.GLASS)
                    .sound(SoundType.SHROOMLIGHT)
                    .strength(0.3F)
                    .lightLevel((state) -> 15)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrack extends BlueNetherrackBlock {
        public BYGBlueNetherrack(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrackBricks extends BlueNetherrackBlock {
        public BYGBlueNetherrackBricks(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHER_BRICKS)
                    .strength(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPillar extends RotatedPillarBlock {
        public BYGPillar(String registryName) {
            super(AbstractBlock.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .harvestTool(ToolType.PICKAXE)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLantern extends LanternBlock {
        public BYGLantern(String registryName) {
            super(AbstractBlock.Properties.of(Material.METAL)
                    .sound(SoundType.LANTERN)
                    .strength(3.5F)
                    .lightLevel((state) -> 15)
                    .noOcclusion()
                    .harvestTool(ToolType.PICKAXE)
                    .requiresCorrectToolForDrops()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }
}

