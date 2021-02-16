package corgiaoc.byg.common.properties;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.textures.BYGMaterials;
import corgiaoc.byg.common.properties.blocks.*;
import corgiaoc.byg.common.properties.blocks.end.CrypticFireBlock;
import corgiaoc.byg.common.properties.blocks.end.IvisPlantBlock;
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
import corgiaoc.byg.common.properties.blocks.nether.wailing.WhalingGrassBlock;
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
                    AbstractBlock.Properties.create(Material.PLANTS)
                            .sound(SoundType.PLANT)
                            .hardnessAndResistance(0.0f)
                            .doesNotBlockMovement()
                            .notSolid()
                            .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGDoubleNetherPlant extends DoubleNetherPlantBlock {
        public BYGDoubleNetherPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGDoubleDamagePlant extends DoubleDamagePlantBlock {
        public BYGDoubleDamagePlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGDesertPlant extends BYGDesertPlants {
        public BYGDesertPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);
        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            BYGBlocks.createPottedBlock(this, registryName);

        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLily extends LilyPadBlock {
        public BYGLily(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .notSolid()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEnderLily extends LilyPadBlock {
        public BYGEnderLily(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.LILY_PADS)
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .notSolid()
                    .doesNotBlockMovement()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGTallGrass extends TallGrassBlock {
        public BYGTallGrass(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAmaranth extends AmaranthBlock {
        public BYGAmaranth(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGAllium extends TallAlliumBlock {
        public BYGAllium(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPinkAllium extends TallPinkAlliumBlock {
        public BYGPinkAllium(String registryName) {
            super(AbstractBlock.Properties.create(Material.TALL_PLANTS)
                    .sound(SoundType.PLANT)
                    .doesNotBlockMovement()
                    .hardnessAndResistance(0.0f)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.ICE)
                    .sound(SoundType.GLASS)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .slipperiness(0.98F)
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.PACKED_ICE)
                    .sound(SoundType.GLASS)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .slipperiness(0.98F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(0.2f)
                    .slipperiness(0.98F)
                    .setLightLevel((state) -> 10)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMagma extends MagmaBlock {
        public BYGMagma(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .setLightLevel((state) -> 10)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSubzeroAsh extends SubzeroAshBlock {
        public BYGSubzeroAsh(String registryName) {
            super(AbstractBlock.Properties.create(Material.SNOW)
                    .sound(SoundType.SAND)
                    .hardnessAndResistance(0.1f)
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
            super(AbstractBlock.Properties.create(Material.SNOW_BLOCK)
                    .sound(SoundType.SAND)
                    .hardnessAndResistance(0.2f)
                    .harvestTool(ToolType.SHOVEL)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(AbstractBlock.Properties.create(Material.EARTH)
                    .sound(SoundType.GROUND)
                    .hardnessAndResistance(0.2f)
                    .speedFactor(0.4F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(AbstractBlock.Properties.create(BYGMaterials.GLOWCELIUM)
                    .sound(SoundType.GROUND)
                    .hardnessAndResistance(0.6f)
                    .tickRandomly()
                    .setLightLevel((state) -> 10)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, AbstractBlock.Properties.create(Material.LEAVES, MaterialColor.GRASS)
                    .hardnessAndResistance(0.0F)
                    .tickRandomly()
                    .sound(SoundType.PLANT)
                    .notSolid()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(AbstractBlock.Properties.create(Material.SAND)
                    .sound(SoundType.SOUL_SAND)
                    .hardnessAndResistance(0.5f)
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
            super(AbstractBlock.Properties.create(Material.SAND)
                    .sound(SoundType.SOUL_SOIL)
                    .hardnessAndResistance(0.5f)
                    .harvestTool(ToolType.SHOVEL)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }

    }

    public static class Crystal extends CrystalBlock {
        public Crystal(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.GLASS)
                    .hardnessAndResistance(0.1F)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGQuartziteSand extends Block {
        public BYGQuartziteSand(String registryName) {
            super(AbstractBlock.Properties.create(Material.SAND)
                    .sound(SoundType.SAND)
                    .hardnessAndResistance(0.2f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class HangingBones extends HangingBonesBlock {
        public HangingBones(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.BONE)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class WailingVines extends VineBlock {
        public WailingVines(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.NETHER_VINE_LOWER_PITCH)
                    .hardnessAndResistance(0.0F)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class WhalingGrass extends WhalingGrassBlock {
        public WhalingGrass(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ScorchedPlant extends ScorchedPlantBlock {
        public ScorchedPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCactus extends WarpedCactusBlock {
        public BYGWarpedCactus(String registryName) {
            super(AbstractBlock.Properties.create(Material.CACTUS)
                    .sound(SoundType.CLOTH)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .notSolid()
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(AbstractBlock.Properties.create(Material.OCEAN_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedFanCoral extends BYGWarpedFinBlock {
        public BYGWarpedFanCoral(String registryName) {
            super(AbstractBlock.Properties.create(Material.OCEAN_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
                    .lootFrom(BYGBlocks.WARPED_CORAL)
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.WET_GRASS)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
                    .lootFrom(BYGBlocks.WARPED_CORAL)
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedBushBlock {
        public BYGWarpedBush(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(AbstractBlock.Properties.create(Material.BAMBOO)
                    .sound(SoundType.BAMBOO)
                    .hardnessAndResistance(0.2f)
                    .notSolid()
                    .tickRandomly()
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWartBlock extends Block {
        public BYGWartBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.ORGANIC)
                    .sound(SoundType.WART)
                    .hardnessAndResistance(1.0F)
                    .harvestTool(ToolType.HOE)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentPlant extends NetherSproutsBlock {
        public BYGLamentPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGLamentVinePlant extends LamentVinePlantBlock {
        public BYGLamentVinePlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLamentVine extends LamentVineBlock {
        public BYGLamentVine(String registryName) {
            super(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburGelBlock extends HoneyBlock {
        public BYGEmburGelBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.CLAY)
                    .sound(SoundType.HONEY)
                    .notSolid()
                    .speedFactor(1.1F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburGelVine extends EmburVinesPlantBlock {
        public BYGEmburGelVine(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.HONEY)
                    .hardnessAndResistance(0.0F)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGEmburPlant extends EmburPlantBlock {
        public BYGEmburPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0F)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(AbstractBlock.Properties.create(Material.BAMBOO_SAPLING)
                    .sound(SoundType.BAMBOO_SAPLING)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class SythianPlant extends BYGSythianPlantBlock {
        public SythianPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class IvisPlant extends IvisPlantBlock {
        public IvisPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.ROOT)
                    .hardnessAndResistance(0.0f)
                    .doesNotBlockMovement()
                    .notSolid()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);

        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.CORAL)
                    .hardnessAndResistance(0.2f)
                    .setLightLevel((state) -> 8)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.CORAL)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .notSolid()
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 9)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGThatch extends HayBlock {
        public BYGThatch(String registryName) {
            super(AbstractBlock.Properties.create(Material.ORGANIC)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchCarpet extends CarpetBlock {
        public ThatchCarpet(String registryName) {
            super(DyeColor.BROWN, AbstractBlock.Properties.create(Material.ORGANIC)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchStairs extends StairsBlock {
        public ThatchStairs(String registryName) {
            super(BYGBlocks.REED_THATCH.getDefaultState(), AbstractBlock.Properties.from(BYGBlocks.REED_THATCH)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class ThatchSlab extends SlabBlock {
        public ThatchSlab(String registryName) {
            super(AbstractBlock.Properties.create(Material.ORGANIC)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.5f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(AbstractBlock.Properties.create(Material.LEAVES)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVine extends HangingVinesBlock {
        public BYGHangingVine(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 14)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGHangingVinePlant extends HangingVinesPlantBlock {
        public BYGHangingVinePlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSporeEnd extends SoulShroomSporeEndBlock {
        public BYGSoulShroomSporeEnd(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.FUNGUS)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 14)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSoulShroomSpore extends SoulShroomSporeBlock {
        public BYGSoulShroomSpore(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.FUNGUS)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRootsPlant extends HangingSythanRootsPlantBlock {
        public BYGSythianHangingRootsPlant(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGSythianHangingRoots extends HangingSythanRootsBlock {
        public BYGSythianHangingRoots(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_PLANTS)
                    .sound(SoundType.NETHER_VINE)
                    .hardnessAndResistance(0.2f)
                    .tickRandomly()
                    .doesNotBlockMovement()
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
            super(AbstractBlock.Properties.create(Material.NETHER_WOOD)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(2.0f)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricCampfire extends CampfireBlock {
        public BoricCampfire(String registryName) {
            super(true, 5, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
                    .hardnessAndResistance(2.0F)
                    .sound(SoundType.WOOD)
                    .tickRandomly()
                    .notSolid()
                    .setLightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BoricFire extends BoricFireBlock {
        public BoricFire(String registryName) {
            super(AbstractBlock.Properties.create(Material.FIRE, MaterialColor.GREEN)
                    .sound(SoundType.CLOTH)
                    .doesNotBlockMovement()
                    .zeroHardnessAndResistance()
                    .setLightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticFire extends CrypticFireBlock {
        public CrypticFire(String registryName) {
            super(AbstractBlock.Properties.create(Material.FIRE, MaterialColor.GREEN)
                    .sound(SoundType.CLOTH)
                    .doesNotBlockMovement()
                    .zeroHardnessAndResistance()
                    .setLightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class CrypticCampfire extends CampfireBlock {
        public CrypticCampfire(String registryName) {
            super(true, 5, AbstractBlock.Properties.create(Material.WOOD, MaterialColor.OBSIDIAN)
                    .hardnessAndResistance(2.0F)
                    .sound(SoundType.WOOD)
                    .tickRandomly()
                    .notSolid()
                    .setLightLevel((state) -> 14)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherWood extends RotatedPillarBlock {
        public BYGNetherWood(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_WOOD)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(2.0f)
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

    public static class BYGOreAmetrine extends BYGOreBlock {
        public BYGOreAmetrine(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(3.0f, 3.0f)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGOrePendorite extends BYGOreBlock {
        public BYGOrePendorite(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(3.0f, 3.0f)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPervadedNetherrack extends BYGOreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.NETHER_GOLD)
                    .hardnessAndResistance(0.4F, 0.4F)
                    .harvestLevel(2)
                    .setLightLevel((state) -> 13)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class AnthraciteOre extends BYGOreBlock {
        public AnthraciteOre(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.NETHER_ORE)
                    .hardnessAndResistance(0.4F, 0.4F)
                    .harvestLevel(3)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGREDGlowCane extends BYGGlowcane {
        public BYGREDGlowCane(String registryName) {
            super(AbstractBlock.Properties.create(BYGMaterials.RED_GLOWCANE)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 10)
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPINKGlowCane extends BYGGlowcane {
        public BYGPINKGlowCane(String registryName) {
            super(AbstractBlock.Properties.create(BYGMaterials.PINK_GLOWCANE)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 10)
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPURPLEGlowCane extends BYGGlowcane {
        public BYGPURPLEGlowCane(String registryName) {
            super(AbstractBlock.Properties.create(BYGMaterials.PURPLE_GLOWCANE)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 10)
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBLUEGlowCane extends BYGGlowcane {
        public BYGBLUEGlowCane(String registryName) {
            super(AbstractBlock.Properties.create(BYGMaterials.BLUE_GLOWCANE)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
                    .setLightLevel((state) -> 10)
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.PLANT)
                    .hardnessAndResistance(0.0F, 0.0F)
                    .notSolid()
                    .doesNotBlockMovement()
                    .tickRandomly()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(AbstractBlock.Properties.create(Material.PLANTS)
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }


    public static class BlockHugeMushroom extends HugeMushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(0.2F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }
    }

    public static class BlockHugeNetherMushroom extends HugeMushroomBlock {
        public BlockHugeNetherMushroom(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(0.2F)
                    .setLightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeNetherMushroomStem extends HugeMushroomBlock {
        public BlockHugeNetherMushroomStem(String registryName) {
            super(AbstractBlock.Properties.create(Material.NETHER_WOOD, MaterialColor.DIRT)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(0.2F)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroom extends HugeMushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(0.2F)
                    .notSolid()
                    .setLightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BlockHugeGlowshroomStem extends HugeMushroomBlock {
        public BlockHugeGlowshroomStem(String registryName) {
            super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.DIRT)
                    .sound(SoundType.HYPHAE)
                    .hardnessAndResistance(0.2F)
                    .setLightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BulbisShell extends HugeMushroomBlock {
        public BulbisShell(String registryName) {
            super(AbstractBlock.Properties.create(Material.WOOD, MaterialColor.CYAN)
                    .sound(SoundType.SHROOMLIGHT)
                    .hardnessAndResistance(0.2F)
                    .notSolid()
                    .setLightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
            this.setDefaultState(this.stateContainer.getBaseState().with(NORTH, true).with(EAST, true).with(SOUTH, true).with(WEST, true).with(UP, true).with(DOWN, true));
        }

        @OnlyIn(Dist.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(AbstractBlock.Properties.create(Material.MISCELLANEOUS, MaterialColor.SAND)
                    .sound(SoundType.SCAFFOLDING)
                    .hardnessAndResistance(0.0f, 0.0f)
                    .doesNotBlockMovement()
                    .variableOpacity()
                    .setLightLevel((state) -> 12)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStoneStairs extends StairsBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.getDefaultState(), AbstractBlock.Properties.from(Blocks.COBBLESTONE)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(2.0f, 6.0f)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(AbstractBlock.Properties.create(Material.GLASS)
                    .sound(SoundType.SHROOMLIGHT)
                    .hardnessAndResistance(0.3F)
                    .setLightLevel((state) -> 15)
            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(1.5f, 6.0f)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .sound(SoundType.NETHERRACK)
                    .hardnessAndResistance(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrack extends BlueNetherrackBlock {
        public BYGBlueNetherrack(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .sound(SoundType.NETHERRACK)
                    .hardnessAndResistance(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGBlueNetherrackBricks extends BlueNetherrackBlock {
        public BYGBlueNetherrackBricks(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK, MaterialColor.BLUE_TERRACOTTA)
                    .sound(SoundType.NETHER_BRICK)
                    .hardnessAndResistance(0.4F, 0.4F)
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGPillar extends RotatedPillarBlock {
        public BYGPillar(String registryName) {
            super(AbstractBlock.Properties.create(Material.ROCK)
                    .sound(SoundType.STONE)
                    .hardnessAndResistance(1.5f, 6.0f)
                    .setRequiresTool()
                    .harvestTool(ToolType.PICKAXE)

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }

    public static class BYGLantern extends LanternBlock {
        public BYGLantern(String registryName) {
            super(AbstractBlock.Properties.create(Material.IRON)
                    .sound(SoundType.LANTERN)
                    .hardnessAndResistance(3.5F)
                    .setLightLevel((state) -> 15)
                    .notSolid()
                    .harvestTool(ToolType.PICKAXE)
                    .setRequiresTool()

            );
            //Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MOD_ID, registryName), this);
            setRegistryName(new ResourceLocation(BYG.MOD_ID, registryName)); //Forge
            BYGBlocks.blocksList.add(this);
        }
    }
}

