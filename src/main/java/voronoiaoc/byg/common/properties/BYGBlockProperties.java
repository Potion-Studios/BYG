package voronoiaoc.byg.common.properties;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.BYGMaterials;
import voronoiaoc.byg.common.properties.blocks.*;
import voronoiaoc.byg.common.properties.blocks.embur.EmburNyliumBlock;
import voronoiaoc.byg.common.properties.blocks.embur.EmburPlantBlock;
import voronoiaoc.byg.common.properties.blocks.embur.EmburVinesPlantBlock;
import voronoiaoc.byg.common.properties.blocks.grassblocks.*;
import voronoiaoc.byg.common.properties.blocks.plants.*;
import voronoiaoc.byg.common.properties.blocks.sythian.SythianPlantBlock;
import voronoiaoc.byg.common.properties.blocks.sythian.SythianSaplingBlock;
import voronoiaoc.byg.common.properties.blocks.sythian.SythianStalkBlock;
import voronoiaoc.byg.common.properties.blocks.warped.*;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGBlockProperties {

    public static class BYGFence extends FenceBlock {
        public BYGFence(String registryName) {
            super(Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSand extends SandBlock {
        public BYGSand(int dustColor, String registryName) {
            super(dustColor, Properties.of(Material.SAND)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFenceGate extends FenceGateBlock {
        public BYGFenceGate(String registryName) {
            super(Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWoodSlab extends SlabBlock {
        public BYGWoodSlab(String registryName) {
            super(Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStoneSlab extends SlabBlock {
        public BYGStoneSlab(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStoneWall extends WallBlock {
        public BYGStoneWall(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(2.0f, 6.0f)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);

        }
    }

    public static class BYGPressurePlate extends PressurePlateBlock {
        public BYGPressurePlate(String registryName) {
            super(Sensitivity.EVERYTHING, Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .noCollission()
                    .strength(0.5F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);

        }
    }

    public static class BYGButtons extends WoodButtonBlock {
        public BYGButtons(String registryName) {
            super(Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .noCollission()
                    .strength(0.5F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);

        }
    }

    public static class BYGFlower extends FlowerBlock {
        public BYGFlower(String registryName) {
            super(MobEffects.SATURATION, 7,
                    Properties.of(Material.PLANT)
                            .sound(SoundType.GRASS)
                            .strength(0.0f)
                            .noCollission()
                            .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(MobEffects.SATURATION, 7,
                    Properties.of(Material.PLANT)
                            .sound(SoundType.GRASS)
                            .strength(0.0f)
                            .noCollission()
                            .noOcclusion()
                            .lightLevel((blockStatex) -> 15)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDoublePlant extends DoublePlantBlock {
        public BYGDoublePlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDoubleDamagePlant extends DoubleDamagePlantBlock {
        public BYGDoubleDamagePlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDesertPlant extends BYGDesertPlants {
        public BYGDesertPlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLily extends BYGLilyPadBlock {
        public BYGLily(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGEmburLily extends NetherLilyBlock {
        public BYGEmburLily(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noOcclusion()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BYGTallGrass extends TallGrassBlock {
        public BYGTallGrass(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGAmaranth extends AmaranthBlock {
        public BYGAmaranth(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGTallAllium extends TallAlliumBlock {
        public BYGTallAllium(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPinkTallAllium extends TallPinkAlliumBlock {
        public BYGPinkTallAllium(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .noCollission()
                    .strength(0.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGrassBlock extends GrassBlock {
        public BYGGrassBlock(String registryName) {
            super(Properties.of(Material.DIRT)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(Properties.of(Material.ICE)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .friction(0.98F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(Properties.of(Material.ICE_SOLID)
                    .sound(SoundType.GLASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .friction(0.98F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(Properties.of(Material.ICE_SOLID)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .friction(0.98F)
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


//    public static class BYGStoneFarmland extends BYGStoneFarmlandBlock {
//        public BYGStoneFarmland(String registryName) {
//            super(AbstractBlock.Settings.of(Material.SOIL)
//                    .sounds(BlockSoundGroup.STONE)
//                    .strength(0.2f)
//                    .ticksRandomly()
//            );
//            Registry.newDecorator(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }
//
//    public static class BYGDaciteFarmland extends BYGDaciteFarmlandBlock {
//        public BYGDaciteFarmland(String registryName) {
//            super(AbstractBlock.Settings.of(Material.SOIL)
//                    .sounds(BlockSoundGroup.STONE)
//                    .strength(0.2f)
//                    .ticksRandomly()
//            );
//
//        }
//    }

    public static class BlockOvergrownStoneBlock extends BYGOverGrownStoneBlock {
        public BlockOvergrownStoneBlock(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BlockOvergrownDaciteBlock extends BYGOverGrownDaciteBlock {
        public BlockOvergrownDaciteBlock(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDirt extends Block {
        public BYGDirt(String registryName) {
            super(Properties.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BYGMud extends Block {
        public BYGMud(String registryName) {
            super(Properties.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .speedFactor(0.4F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGMeadowGrass extends BYGMeadowGrassBlock {
        public BYGMeadowGrass(String registryName) {
            super(Properties.of(Material.GRASS)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(Properties.of(Material.DIRT)
                    .sound(SoundType.GRAVEL)
                    .strength(0.2f)
                    .randomTicks()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, Properties.of(Material.LEAVES, MaterialColor.GRASS)
                    .strength(0.0F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeaves extends LeavesBlock {
        public BYGLeaves(String registryName) {
            super(FabricBlockSettings.of(Material.LEAVES)
                    .hardness(0.2F)
                    .ticksRandomly()
                    .sounds(SoundType.GRASS)
                    .nonOpaque()
                    .breakByTool(FabricToolTags.HOES, 0)
                    .build()
            );

            this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));

            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);


        }
    }

    public static class BYGBloomingWitchhazelLeaves extends LeavesBlock {
        public BYGBloomingWitchhazelLeaves(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .strength(0.2F)
                    .randomTicks()
                    .sound(SoundType.GRASS)
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 12)
            );
            this.registerDefaultState(this.stateDefinition.any().setValue(DISTANCE, Integer.valueOf(7)).setValue(PERSISTENT, Boolean.valueOf(false)));
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPetal extends Block {
        public BYGPetal(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    @SuppressWarnings("deprecation")
    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(Properties.of(Material.SAND)
                    .sound(SoundType.SAND)
                    .strength(0.2f)
                    .speedFactor(0.6F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
//    //        public void randomDisplayTick(BlockState blockstate, World world, BlockPos pos, Random rand) {
//            VoxelShape shape = this.getShape(blockstate, world, pos, ISelectionContext.dummy());
//            Vec3d vec3d = shape.getBoundingBox().getCenter();
//            double getX = (double) pos.getX() + vec3d.x;
//            double getZ = (double) pos.getZ() + vec3d.z;
//
//            for (int idx = 0; idx < 15; ++idx) {
//                if (rand.nextBoolean()) {
//                    world.addParticle(BYGParticleList.NYLIUM_SOUL_SAND_AMBIENCE, getX + (double) (rand.nextFloat() / 5.0F), (double) pos.getY() + (double) rand.nextFloat(), getZ + (double) (rand.nextFloat() / 5.0F), 0.0D, 0.02D, 0.0D);
//                }
//            }
//
//        }
    }

    public static class BYGNyliumSoulSoil extends Block {
        public BYGNyliumSoulSoil(String registryName) {
            super(Properties.of(Material.SAND)
                    .sound(SoundType.SOUL_SOIL)
                    .strength(0.2f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCacti extends BYGWarpedCactusBlock {
        public BYGWarpedCacti(String registryName) {
            super(Properties.of(Material.CACTUS)
                    .sound(SoundType.WOOL)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedFanCoral extends BYGWarpedFinBlock {
        public BYGWarpedFanCoral(String registryName) {
            super(Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .dropsLike(BYGBlockList.WARPED_CORAL)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(Properties.of(Material.WATER_PLANT)
                    .sound(SoundType.WET_GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
                    .dropsLike(BYGBlockList.WARPED_CORAL)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedPlantBlock {
        public BYGWarpedBush(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(Properties.of(Material.BAMBOO)
                    .sound(SoundType.BAMBOO)
                    .strength(0.2f)
                    .noOcclusion()
                    .randomTicks()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGEmburGelBlock extends HoneyBlock {
        public BYGEmburGelBlock(String registryName) {
            super(Properties.of(Material.CLAY)
                    .sound(SoundType.HONEY_BLOCK)
                    .noOcclusion()
                    .speedFactor(1.6F)
                    .friction(0.6F)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGEmburGelVine extends EmburVinesPlantBlock {
        public BYGEmburGelVine(String registryName) {
            super(BlockBehaviour.Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.0F)
                    .randomTicks()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGEmburPlant extends EmburPlantBlock {
        public BYGEmburPlant(String registryName) {
            super(BlockBehaviour.Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0F)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGEmberNylium extends EmburNyliumBlock {
        public BYGEmberNylium(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.4F)
                    .randomTicks()
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class SythianPlant extends SythianPlantBlock {
        public SythianPlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSythianNylium extends BYGSythianNyliumBlock {
        public BYGSythianNylium(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.4f)
                    .requiresCorrectToolForDrops()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class OvergrownNetherrack extends OvergrownNetherrackBlock {
        public OvergrownNetherrack(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.2f)
                    .requiresCorrectToolForDrops()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIvisPlant extends BYGIvisPlantBlock {
        public BYGIvisPlant(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0.0f)
                    .noCollission()
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIvisPhylium extends BYGIvisPhyliumBlock {
        public BYGIvisPhylium(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(0.2f)
                    .randomTicks()
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.CORAL_BLOCK)
                    .strength(0.2f)
                    .randomTicks()
                    .noOcclusion()
                    .noCollission()
                    .lightLevel((blockStatex) -> 9)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGHangingVine extends HangingVinesBlock {
        public BYGHangingVine(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGHangingVinePlant extends HangingVinesPlantBlock {
        public BYGHangingVinePlant(String registryName) {
            super(Properties.of(Material.LEAVES)
                    .sound(SoundType.GRASS)
                    .strength(0.2f)
                    .randomTicks()
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class LogBlock extends RotatedPillarBlock {
        private final MaterialColor verticalColor;

        public LogBlock(MaterialColor verticalColorIn, Properties properties) {
            super(properties);
            this.verticalColor = verticalColorIn;
        }
    }

    public static class BYGLog extends LogBlock {
        public BYGLog(String registryName) {
            super(MaterialColor.WOOD,
                    Properties.of(Material.WOOD)
                            .sound(SoundType.WOOD)
                            .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWood extends RotatedPillarBlock {
        public BYGWood(String registryName) {
            super(Properties.of(Material.WOOD)
                    .sound(SoundType.WOOD)
                    .strength(2.0f)

            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGOreAmetrine extends BYGOreBlock {
        public BYGOreAmetrine(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(30.0f, 1200F)
                    .requiresCorrectToolForDrops()

            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGOrePendorite extends OreBlock {
        public BYGOrePendorite(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(30.0f, 1200f)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPervadedNetherrack extends OreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(3.0f, 3.0f)
                    .requiresCorrectToolForDrops()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGREDGlowCane extends Glowcane {
        public BYGREDGlowCane(String registryName) {
            super(BlockBehaviour.Properties.of(BYGMaterials.RED_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPINKGlowCane extends Glowcane {
        public BYGPINKGlowCane(String registryName) {
            super(BlockBehaviour.Properties.of(BYGMaterials.PINK_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPURPLEGlowCane extends Glowcane {
        public BYGPURPLEGlowCane(String registryName) {
            super(BlockBehaviour.Properties.of(BYGMaterials.PURPLE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBLUEGlowCane extends Glowcane {
        public BYGBLUEGlowCane(String registryName) {
            super(BlockBehaviour.Properties.of(BYGMaterials.BLUE_GLOWCANE)
                    .sound(SoundType.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollission()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

//
//    public static class BYGCrop extends CropsBlock {
//        public BYGCrop(String registryName) {
//            super(AbstractBlock.Settings.of(Material.PLANT)
//                    .sounds(BlockSoundGroup.GRASS)
//                    .strength(1.5f, 6.0f)
//                    .nonOpaque()
//            );
//            Registry.newDecorator(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.GRASS)
                    .strength(0, 0)
                    .noOcclusion()
                    .noCollission()
                    .randomTicks()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(Properties.of(Material.PLANT)
                    .sound(SoundType.SWEET_BERRY_BUSH)
                    .strength(0.0f, 0.0f)
                    .noCollission()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BlockHugeMushroom extends HugeMushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(Properties.of(Material.PLANT, MaterialColor.DIRT)
                    .sound(SoundType.WOOD)
                    .strength(1.5f, 6.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
            this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, Boolean.valueOf(true)).setValue(BlockStateProperties.EAST, Boolean.valueOf(true)).setValue(BlockStateProperties.SOUTH, Boolean.valueOf(true)).setValue(BlockStateProperties.WEST, Boolean.valueOf(true)).setValue(BlockStateProperties.UP, Boolean.valueOf(true)).setValue(BlockStateProperties.DOWN, Boolean.valueOf(true)));
        }
    }

    public static class BlockHugeGlowshroom extends HugeMushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(Properties.of(Material.PLANT, MaterialColor.DIRT)
                    .sound(SoundType.WOOD)
                    .strength(1.5f, 6.0f)
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 12)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
            this.registerDefaultState(this.stateDefinition.any().setValue(BlockStateProperties.NORTH, Boolean.valueOf(true)).setValue(BlockStateProperties.EAST, Boolean.valueOf(true)).setValue(BlockStateProperties.SOUTH, Boolean.valueOf(true)).setValue(BlockStateProperties.WEST, Boolean.valueOf(true)).setValue(BlockStateProperties.UP, Boolean.valueOf(true)).setValue(BlockStateProperties.DOWN, Boolean.valueOf(true)));
        }

        @Environment(EnvType.CLIENT)
        public boolean skipRendering(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this || super.skipRendering(state, adjacentBlockState, side);
        }
    }

    public static class BYGPlanks extends Block {
        public BYGPlanks(String registryName) {
            super(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGScaffolding extends BYGScaffoldingBlock {
        public BYGScaffolding(String registryName) {
            super(Properties.of(Material.DECORATION, MaterialColor.SAND)
                    .sound(SoundType.SCAFFOLDING)
                    .strength(2.0f, 3.0f)
                    .noCollission()
                    .lightLevel((blockStatex) -> 12)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGCraftingTable extends BYGCraftingTableBlock {
        public BYGCraftingTable(String registryName) {
            super(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.WOOD)
                    .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDoors extends DoorBlock {
        public BYGDoors(String registryName) {
            super(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGTrapdoors extends TrapDoorBlock {
        public BYGTrapdoors(String registryName) {
            super(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
                    .noOcclusion()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWoodStairs extends StairBlock {
        public BYGWoodStairs(String registryName) {
            super(Blocks.OAK_PLANKS.defaultBlockState(), Properties.copy(Blocks.OAK_PLANKS));
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BYGStoneStairs extends StairBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.defaultBlockState(), Properties.copy(Blocks.COBBLESTONE));
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BlockBookshelf extends BookshelfBlock {
        public BlockBookshelf(String registryName) {
            super(Properties.of(Material.WOOD, MaterialColor.COLOR_BROWN)
                    .sound(SoundType.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(Properties.of(Material.GLASS)
                    .sound(SoundType.GLASS)
                    .strength(0.3F)
                    .lightLevel((blockStatex) -> 15)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGNetherrack extends Block {
        public BYGNetherrack(String registryName) {
            super(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.TERRACOTTA_BLUE)
                    .sound(SoundType.NETHERRACK)
                    .strength(0.4F, 0.4F)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGNetherBricks extends Block {
        public BYGNetherBricks(String registryName) {
            super(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS));
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPillar extends RotatedPillarBlock {
        public BYGPillar(String registryName) {
            super(Properties.of(Material.STONE)
                    .sound(SoundType.STONE)
                    .strength(1.5f, 6.0f)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }


    public static class BYGStrippedLog extends LogBlock {
        public BYGStrippedLog(String registryName) {
            super(MaterialColor.WOOD,
                    Properties.of(Material.WOOD, MaterialColor.WOOD)
                            .sound(SoundType.WOOD)
                            .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLantern extends Lantern {
        public BYGLantern(String registryName) {
            super(Properties.of(Material.METAL)
                    .sound(SoundType.LANTERN)
                    .strength(3.5F)
                    .noOcclusion()
                    .lightLevel((blockStatex) -> 15)
                    .requiresCorrectToolForDrops()
            );
            Registry.register(Registry.BLOCK, new ResourceLocation(BYG.MODID, registryName), this);
        }
    }
}
