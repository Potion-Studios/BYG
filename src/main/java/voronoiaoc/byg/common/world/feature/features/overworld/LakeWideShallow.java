package voronoiaoc.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;

import java.util.Random;
import java.util.Set;


public class LakeWideShallow extends Feature<NoFeatureConfig> {

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(Material.BAMBOO, Material.BAMBOO_SAPLING, Material.LEAVES, Material.WEB, Material.CACTUS, Material.ANVIL, Material.GOURD, Material.CAKE, Material.DRAGON_EGG, Material.BARRIER, Material.CAKE);

    protected long noiseSeed;
    protected PerlinNoiseGenerator noiseGen;

    public void setSeed(long seed) {
        SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    public LakeWideShallow(Codec<NoFeatureConfig> configFactory) {
        super(configFactory);
    }


    @Override
    public boolean func_230362_a_(ISeedReader world, StructureManager structureManager, ChunkGenerator chunkSettings, Random random, BlockPos position, NoFeatureConfig configBlock) {
        setSeed(world.getSeed());
        BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().setPos(position.down(2));

        // creates the actual lakes
        boolean containedFlag;
        Material material;
        BlockState blockState;
        for (int x = -2; x < 18; ++x) {
            for (int z = -2; z < 18; ++z) {

                int xTemp = x - 10;
                int zTemp = z - 10;
                //circle shaped
                if (xTemp * xTemp + zTemp * zTemp < 64) {

                    double samplePerlin1 = (this.noiseGen.noiseAt(
                            (double) position.getX() + x * 0.05D,
                            (double) position.getZ() + z * 0.05D, true) + 1)
                            * 3.0D;

                    for (int y = 0; y > -samplePerlin1; --y) {

                        blockpos$Mutable.setPos(position).move(x, y, z);

                        // checks if the spot is solid all around (diagonally too) and has nothing solid above it
                        containedFlag = checkIfValidSpot(world, blockpos$Mutable, samplePerlin1);

                        // Is spot within the mask (sorta a roundish area) and is contained
                        if (containedFlag) {
                            // check below without moving down

                            // sets the water
                            world.setBlockState(blockpos$Mutable, Blocks.WATER.getDefaultState(), 3);
                            world.getPendingFluidTicks().scheduleTick(blockpos$Mutable, Fluids.WATER, 0);

                            // remove floating plants so they aren't hovering.
                            // check above while moving up one.
                            blockState = world.getBlockState(blockpos$Mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANTS && blockState.getBlock() != Blocks.LILY_PAD) {
                                world.setBlockState(blockpos$Mutable, Blocks.AIR.getDefaultState(), 2);

                                // recursively moves up and breaks floating sugar cane
                                while (blockpos$Mutable.getY() < world.getHeight() && world.getBlockState(blockpos$Mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.getDefaultState()) {
                                    world.setBlockState(blockpos$Mutable, Blocks.AIR.getDefaultState(), 2);
                                }
                            }
                            if (material == Material.TALL_PLANTS && blockState.getBlock() != Blocks.VINE) {
                                world.setBlockState(blockpos$Mutable, Blocks.AIR.getDefaultState(), 2);
                                world.setBlockState(blockpos$Mutable.up(), Blocks.AIR.getDefaultState(), 2);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * checks if the spot is surrounded by solid blocks below and all around horizontally plus nothing solid above.
     *
     * @param world            - world to check for materials in
     * @param blockpos$Mutable - location to check if valid
     * @return - if the spot is valid
     */
    private boolean checkIfValidSpot(IWorld world, BlockPos.Mutable blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;

        //cannot be under ledge
        BlockPos.Mutable temp = new BlockPos.Mutable().setPos(blockpos$Mutable);
        blockState = world.getBlockState(temp.up());
        while (!blockState.getFluidState().isEmpty() && temp.getY() < 255) {
            temp.move(Direction.UP);
        }
        if (!blockState.isAir() && blockState.getFluidState().isEmpty())
            return false;


        // must be solid below
        // Will also return false if an unacceptable solid material is found.
        blockState = world.getBlockState(blockpos$Mutable.down());
        material = blockState.getMaterial();
        if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                BlockTags.PLANKS.func_230235_a_(blockState.getBlock())) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getStillFluidState(false)) {
            return false;
        }


        // places water on tips
        if ((noise < 2D && world.getBlockState(blockpos$Mutable.up()).isAir())) {
            int open = 0;
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (world.getBlockState(blockpos$Mutable.offset(direction)).isAir()) open++;
            }
            if (open == 1) return true;
        }

        // Must be solid all around even diagonally.
        // Will also return false if an unacceptable solid material is found.
        for (int x2 = -1; x2 < 2; x2++) {
            for (int z2 = -1; z2 < 2; z2++) {
                blockState = world.getBlockState(blockpos$Mutable.add(x2, 0, z2));
                material = blockState.getMaterial();

                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) || BlockTags.PLANKS.func_230235_a_(blockState.getBlock())) && blockState.getFluidState().isEmpty() && blockState.getFluidState() != Fluids.WATER.getStillFluidState(false)) {
                    return false;
                }
            }
        }

        return true;
    }
}