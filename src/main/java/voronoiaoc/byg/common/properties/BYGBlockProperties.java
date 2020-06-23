package voronoiaoc.byg.common.properties;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.property.Properties;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.BYGMaterials;
import voronoiaoc.byg.common.properties.blocks.*;
import voronoiaoc.byg.common.properties.blocks.grassblocks.*;
import voronoiaoc.byg.common.properties.blocks.plants.*;
import voronoiaoc.byg.common.properties.blocks.warped.*;
import voronoiaoc.byg.common.properties.sythian.SythianPlantBlock;
import voronoiaoc.byg.common.properties.sythian.SythianSaplingBlock;
import voronoiaoc.byg.common.properties.sythian.SythianStalkBlock;
import voronoiaoc.byg.core.byglists.BYGBlockList;

public class BYGBlockProperties {

    public static class BYGFence extends FenceBlock {
        public BYGFence(String registryName) {
            super(Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSand extends SandBlock {
        public BYGSand(int dustColor, String registryName) {
            super(dustColor, Settings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SAND)
                    .strength(0.2f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFenceGate extends FenceGateBlock {
        public BYGFenceGate(String registryName) {
            super(Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWoodSlab extends SlabBlock {
        public BYGWoodSlab(String registryName) {
            super(Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStoneSlab extends SlabBlock {
        public BYGStoneSlab(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2.0f, 6.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStoneWall extends WallBlock {
        public BYGStoneWall(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2.0f, 6.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);

        }
    }

    public static class BYGPressurePlate extends PressurePlateBlock {
        public BYGPressurePlate(String registryName) {
            super(ActivationRule.EVERYTHING, Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .noCollision()
                    .strength(0.5F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);

        }
    }

    public static class BYGButtons extends WoodButtonBlock {
        public BYGButtons(String registryName) {
            super(Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .noCollision()
                    .strength(0.5F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);

        }
    }

    public static class BYGFlower extends FlowerBlock {
        public BYGFlower(String registryName) {
            super(StatusEffects.SATURATION, 7,
                    Settings.of(Material.PLANT)
                            .sounds(BlockSoundGroup.GRASS)
                            .strength(0.0f)
                            .noCollision()
                            .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFairySlipperFlower extends BYGFairySlipperBlock {
        public BYGFairySlipperFlower(String registryName) {
            super(StatusEffects.SATURATION, 7,
                    Settings.of(Material.PLANT)
                            .sounds(BlockSoundGroup.GRASS)
                            .strength(0.0f)
                            .noCollision()
                            .nonOpaque()
                            .lightLevel((blockStatex) -> 15)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDoublePlant extends TallPlantBlock {
        public BYGDoublePlant(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDesertPlant extends BYGDesertPlants {
        public BYGDesertPlant(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSnowyPlant extends BYGSnowyPlants {
        public BYGSnowyPlant(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBeachGrass extends BYGBeachGrassBlock {
        public BYGBeachGrass(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLily extends BYGLilyPadBlock {
        public BYGLily(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWaterSilk extends BYGWaterSilkBlock {
        public BYGWaterSilk(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .nonOpaque()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeafPile extends BYGLeafPileBlock {
        public BYGLeafPile(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


    public static class BYGTallGrass extends FernBlock {
        public BYGTallGrass(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWinterTallGrass extends BYGSnowyPlants {
        public BYGWinterTallGrass(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );

        }
    }

    public static class BYGPrairieGrass extends BYGPrairieGrassBlock {
        public BYGPrairieGrass(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .noCollision()
                    .strength(0.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGrassBlock extends GrassBlock {
        public BYGGrassBlock(String registryName) {
            super(Settings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIceBlock extends IceBlock {
        public BYGIceBlock(String registryName) {
            super(Settings.of(Material.ICE)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .slipperiness(0.98F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPackedIceBlock extends Block {
        public BYGPackedIceBlock(String registryName) {
            super(Settings.of(Material.DENSE_ICE)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .slipperiness(0.98F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGFrostMagma extends BYGFrostMagmaBlock {
        public BYGFrostMagma(String registryName) {
            super(Settings.of(Material.DENSE_ICE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .slipperiness(0.98F)
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


//    public static class BYGStoneFarmland extends BYGStoneFarmlandBlock {
//        public BYGStoneFarmland(String registryName) {
//            super(AbstractBlock.Settings.of(Material.SOIL)
//                    .sounds(BlockSoundGroup.STONE)
//                    .strength(0.2f)
//                    .ticksRandomly()
//            );
//            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
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
            super(Settings.of(Material.SOIL)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BlockOvergrownDaciteBlock extends BYGOverGrownDaciteBlock {
        public BlockOvergrownDaciteBlock(String registryName) {
            super(Settings.of(Material.SOIL)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDirt extends Block {
        public BYGDirt(String registryName) {
            super(Settings.of(Material.SOIL)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(0.2f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


    public static class BYGMud extends SoulSandBlock {
        public BYGMud(String registryName) {
            super(Settings.of(Material.SOIL)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .velocityMultiplier(0.4F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGMeadowGrass extends BYGMeadowGrassBlock {
        public BYGMeadowGrass(String registryName) {
            super(Settings.of(Material.SOLID_ORGANIC)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGlowcelium extends BYGGlowCeliumBlock {
        public BYGGlowcelium(String registryName) {
            super(Settings.of(BYGMaterials.GLOWCELIUM)
                    .sounds(BlockSoundGroup.GRAVEL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeafFoilage extends LeafFoliageBlock {
        public BYGLeafFoilage(String registryName) {
            super(DyeColor.GREEN, Settings.of(Material.LEAVES, MaterialColor.GRASS)
                    .strength(0.0F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLeaves extends LeavesBlock {
        public BYGLeaves(String registryName) {
            super(Settings.of(Material.LEAVES)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
            );

            this.setDefaultState(this.stateManager.getDefaultState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBloomingWitchhazelLeaves extends LeavesBlock {
        public BYGBloomingWitchhazelLeaves(String registryName) {
            super(Settings.of(Material.LEAVES)
                    .strength(0.2F)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GRASS)
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 12)
            );
            this.setDefaultState(this.stateManager.getDefaultState().with(DISTANCE, Integer.valueOf(7)).with(PERSISTENT, Boolean.valueOf(false)));
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPetal extends LeavesBlock {
        public BYGPetal(String registryName) {
            super(Settings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    @SuppressWarnings("deprecation")
    public static class BYGNyliumSoulSand extends Block {

        public BYGNyliumSoulSand(String registryName) {
            super(Settings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SAND)
                    .strength(0.2f)
                    .velocityMultiplier(0.6F)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
//        @OnlyIn(Dist.CLIENT)
//        public void randomDisplayTick(BlockState blockstate, World world, BlockPos pos, Random rand) {
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
            super(Settings.of(Material.AGGREGATE)
                    .sounds(BlockSoundGroup.SOUL_SOIL)
                    .strength(0.2f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCacti extends BYGWarpedCactusBlock {
        public BYGWarpedCacti(String registryName) {
            super(Settings.of(Material.CACTUS)
                    .sounds(BlockSoundGroup.WOOL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCoral extends BYGWarpedCoralPlantBlock {
        public BYGWarpedCoral(String registryName) {
            super(Settings.of(Material.UNDERWATER_PLANT)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedFanCoral extends BYGWarpedFinBlock {
        public BYGWarpedFanCoral(String registryName) {
            super(Settings.of(Material.UNDERWATER_PLANT)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .dropsLike(BYGBlockList.WARPED_CORAL)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedWallFanCoral extends BYGWarpedCoralWallFanBlock {
        public BYGWarpedWallFanCoral(String registryName) {
            super(Settings.of(Material.UNDERWATER_PLANT)
                    .sounds(BlockSoundGroup.WET_GRASS)
                    .strength(0.0F)
                    .noCollision()
                    .nonOpaque()
                    .dropsLike(BYGBlockList.WARPED_CORAL)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedBush extends BYGWarpedPlantBlock {
        public BYGWarpedBush(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class SythianStalk extends SythianStalkBlock {
        public SythianStalk(String registryName) {
            super(Settings.of(Material.BAMBOO)
                    .sounds(BlockSoundGroup.BAMBOO)
                    .strength(0.2f)
                    .nonOpaque()
                    .ticksRandomly()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class SythianSapling extends SythianSaplingBlock {
        public SythianSapling(String registryName) {
            super(Settings.of(Material.BAMBOO_SAPLING)
                    .sounds(BlockSoundGroup.BAMBOO_SAPLING)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class SythianPlant extends SythianPlantBlock {
        public SythianPlant(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSythianNylium extends BYGSythianNyliumBlock {
        public BYGSythianNylium(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(0.2f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIvisPlant extends BYGIvisPlantBlock {
        public BYGIvisPlant(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGIvisPhylium extends BYGIvisPhyliumBlock {
        public BYGIvisPhylium(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(0.2f)
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWarpedCoralBlock extends Block {
        public BYGWarpedCoralBlock(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.CORAL)
                    .strength(0.2f)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPollen extends BYGPollenBlock {
        public BYGPollen(String registryName) {
            super(Settings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.CORAL)
                    .strength(0.2f)
                    .ticksRandomly()
                    .nonOpaque()
                    .noCollision()
                    .lightLevel((blockStatex) -> 9)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPoisonIvy extends PoisonIvyBlock {
        public BYGPoisonIvy(String registryName) {
            super(AbstractBlock.Settings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGSkyrisVine extends VineBlock {
        public BYGSkyrisVine(String registryName) {
            super(Settings.of(Material.LEAVES)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.2f)
                    .ticksRandomly()
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class LogBlock extends PillarBlock {
        private final MaterialColor verticalColor;

        public LogBlock(MaterialColor verticalColorIn, Settings properties) {
            super(properties);
            this.verticalColor = verticalColorIn;
        }
    }

    public static class BYGLog extends LogBlock {
        public BYGLog(String registryName) {
            super(MaterialColor.WOOD,
                    Settings.of(Material.WOOD)
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static PillarBlock createLogBlock(MaterialColor topMaterialColor, MaterialColor sideMaterialColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (blockState) -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMaterialColor : sideMaterialColor).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    public static class BYGWood extends PillarBlock {
        public BYGWood(String registryName) {
            super(Settings.of(Material.WOOD)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BlockMushroom extends MushroomBlock {
        public BlockMushroom(String registryName) {
            super(Settings.of(Material.PLANT, MaterialColor.DIRT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

//Saving this for later do not touch
//    @OnlyIn(Dist.CLIENT)
//    public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
//        return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
//    }

    public static class BlockGlowshroom extends MushroomBlock {
        public BlockGlowshroom(String registryName) {
            super(Settings.of(Material.PLANT, MaterialColor.DIRT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f)
                    .noCollision()
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGOreAmetrine extends BYGOreBlock {
        public BYGOreAmetrine(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3.0f, 3.0f)
                    .strength(3)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGOrePendorite extends OreBlock {
        public BYGOrePendorite(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3.0f, 3.0f)
                    .strength(4)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPervadedNetherrack extends OreBlock {
        public BYGPervadedNetherrack(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(3.0f, 3.0f)
                    .strength(4)
                    .lightLevel((blockStatex) -> 8)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGREDGlowCane extends Glowcane {
        public BYGREDGlowCane(Material material, String registryName) {
            super(AbstractBlock.Settings.of(material)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(0.0f, 0.0f)
                    .noCollision()
                    .lightLevel((blockStatex) -> 10)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }
//
//    public static class BYGPINKGlowCane extends GlowcaneItem {
//        public BYGPINKGlowCane(String registryName) {
//            super(AbstractBlock.Settings.of(BYGMaterials.PINK_GLOWCANE)
//                    .sounds(BlockSoundGroup.GRASS)
//                    .strength(0.0f, 0.0f)
//                    .noCollision()
//                    .lightLevel((blockStatex) -> 10)
//            );
//            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }
//
//    public static class BYGPURPLEGlowCane extends GlowcaneItem {
//        public BYGPURPLEGlowCane(String registryName) {
//            super(AbstractBlock.Settings.of(BYGMaterials.PURPLE_GLOWCANE)
//                    .sounds(BlockSoundGroup.GRASS)
//                    .strength(0.0f, 0.0f)
//                    .noCollision()
//                    .lightLevel((blockStatex) -> 10)
//            );
//            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }
//
//    public static class BYGBLUEGlowCane extends GlowcaneItem {
//        public BYGBLUEGlowCane(String registryName) {
//            super(AbstractBlock.Settings.of(BYGMaterials.BLUE_GLOWCANE)
//                    .sounds(BlockSoundGroup.GRASS)
//                    .strength(0.0f, 0.0f)
//                    .noCollision()
//                    .lightLevel((blockStatex) -> 10)
//            );
//            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }
//
//    public static class BYGCrop extends CropsBlock {
//        public BYGCrop(String registryName) {
//            super(AbstractBlock.Settings.of(Material.PLANT)
//                    .sounds(BlockSoundGroup.GRASS)
//                    .strength(1.5f, 6.0f)
//                    .nonOpaque()
//            );
//            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
//        }
//    }

    public static class BlockCattail extends BYGRiverPlantBlock {
        public BlockCattail(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(1.5f, 6.0f)
                    .nonOpaque()
                    .noCollision()
                    .ticksRandomly()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGBerryBush extends BlueBerryBush {
        public BYGBerryBush(String registryName) {
            super(Settings.of(Material.PLANT)
                    .sounds(BlockSoundGroup.GRASS)
                    .strength(1.5f, 6.0f)
                    .noCollision()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


    public static class BlockHugeMushroom extends MushroomBlock {
        public BlockHugeMushroom(String registryName) {
            super(Settings.of(Material.PLANT, MaterialColor.DIRT)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(1.5f, 6.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
            this.setDefaultState(this.stateManager.getDefaultState().with(Properties.NORTH, Boolean.valueOf(true)).with(Properties.EAST, Boolean.valueOf(true)).with(Properties.SOUTH, Boolean.valueOf(true)).with(Properties.WEST, Boolean.valueOf(true)).with(Properties.UP, Boolean.valueOf(true)).with(Properties.DOWN, Boolean.valueOf(true)));
        }
    }

    public static class BlockHugeGlowshroom extends MushroomBlock {
        public BlockHugeGlowshroom(String registryName) {
            super(Settings.of(Material.PLANT, MaterialColor.DIRT)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(1.5f, 6.0f)
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 12)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
            this.setDefaultState(this.stateManager.getDefaultState().with(Properties.NORTH, Boolean.valueOf(true)).with(Properties.EAST, Boolean.valueOf(true)).with(Properties.SOUTH, Boolean.valueOf(true)).with(Properties.WEST, Boolean.valueOf(true)).with(Properties.UP, Boolean.valueOf(true)).with(Properties.DOWN, Boolean.valueOf(true)));
        }

        @Environment(EnvType.CLIENT)
        public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
            return adjacentBlockState.getBlock() == this ? true : super.isSideInvisible(state, adjacentBlockState, side);
        }
    }

    public static class BYGPlanks extends Block {
        public BYGPlanks(String registryName) {
            super(Settings.of(Material.WOOD, MaterialColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

//    public static class BYGScaffolding extends BYGScaffoldingBlock {
//        public BYGScaffolding(String registryName) {
//            super(AbstractBlock.Settings.of(Material.MISCELLANEOUS, MaterialColor.SAND)
//                    .sounds(BlockSoundGroup.SCAFFOLDING)
//                    .strength(2.0f, 3.0f)
//                    .noCollision()
//                    .variableOpacity()
//                    .lightLevel((blockStatex) -> 12)
//            );
//
//        }
//    }

    public static class BYGCraftingTable extends BYGCraftingTableBlock {
        public BYGCraftingTable(String registryName) {
            super(Settings.of(Material.WOOD, MaterialColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGDoors extends DoorBlock {
        public BYGDoors(String registryName) {
            super(Settings.of(Material.WOOD, MaterialColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGTrapdoors extends TrapdoorBlock {
        public BYGTrapdoors(String registryName) {
            super(Settings.of(Material.WOOD, MaterialColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
                    .nonOpaque()
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGWoodStairs extends StairsBlock {
        public BYGWoodStairs(String registryName) {
            super(Blocks.OAK_PLANKS.getDefaultState(), Settings.copy(Blocks.OAK_PLANKS)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


    public static class BYGStoneStairs extends StairsBlock {
        public BYGStoneStairs(String registryName) {
            super(Blocks.COBBLESTONE.getDefaultState(), Settings.copy(Blocks.COBBLESTONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(2.0f, 6.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }


    public static class BlockBookshelf extends BookshelfBlock {
        public BlockBookshelf(String registryName) {
            super(Settings.of(Material.WOOD, MaterialColor.BROWN)
                    .sounds(BlockSoundGroup.WOOD)
                    .strength(2.0f, 3.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGGlowCaneBlock extends Block {
        public BYGGlowCaneBlock(String registryName) {
            super(Settings.of(Material.GLASS)
                    .sounds(BlockSoundGroup.GLASS)
                    .strength(0.3F)
                    .lightLevel((blockStatex) -> 15)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStone extends Block {
        public BYGStone(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGPillar extends PillarBlock {
        public BYGPillar(String registryName) {
            super(Settings.of(Material.STONE)
                    .sounds(BlockSoundGroup.STONE)
                    .strength(1.5f, 6.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGStrippedLog extends LogBlock {
        public BYGStrippedLog(String registryName) {
            super(MaterialColor.WOOD,
                    AbstractBlock.Settings.of(Material.WOOD, MaterialColor.WOOD)
                            .sounds(BlockSoundGroup.WOOD)
                            .strength(2.0f)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }

    public static class BYGLantern extends LanternBlock {
        public BYGLantern(String registryName) {
            super(Settings.of(Material.METAL)
                    .sounds(BlockSoundGroup.LANTERN)
                    .strength(3.5F)
                    .nonOpaque()
                    .lightLevel((blockStatex) -> 15)
            );
            Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);
        }
    }
}
