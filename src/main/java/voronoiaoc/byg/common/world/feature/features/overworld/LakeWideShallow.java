package voronoiaoc.byg.common.world.feature.features.overworld;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;


public class LakeWideShallow extends Feature<NoneFeatureConfiguration> {

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(Material.BAMBOO, Material.BAMBOO_SAPLING, Material.LEAVES, Material.WEB, Material.CACTUS, Material.METAL, Material.VEGETABLE, Material.CAKE, Material.EGG, Material.BARRIER, Material.CAKE);

    protected long noiseSeed;
    protected PerlinSimplexNoise noiseGen;

    public void setSeed(long seed) {
        WorldgenRandom sharedseedrandom = new WorldgenRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinSimplexNoise(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    public LakeWideShallow(Codec<NoneFeatureConfiguration> configFactory) {
        super(configFactory);
    }


    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        setSeed(world.getSeed());
        BlockPos.MutableBlockPos blockpos$Mutable = new BlockPos.MutableBlockPos().set(pos.below(2));

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

                    double samplePerlin1 = (this.noiseGen.getValue(
                            (double) pos.getX() + x * 0.05D,
                            (double) pos.getZ() + z * 0.05D, true) + 1)
                            * 3.0D;

                    for (int y = 0; y > -samplePerlin1; --y) {

                        blockpos$Mutable.set(pos).move(x, y, z);

                        // checks if the spot is solid all around (diagonally too) and has nothing solid above it
                        containedFlag = checkIfValidSpot(world, blockpos$Mutable, samplePerlin1);

                        // Is spot within the mask (sorta a roundish area) and is contained
                        if (containedFlag) {
                            // check below without moving down

                            // sets the water
                            world.setBlock(blockpos$Mutable, Blocks.WATER.defaultBlockState(), 3);
                            world.getLiquidTicks().scheduleTick(blockpos$Mutable, Fluids.WATER, 0);

                            // remove floating plants so they aren't hovering.
                            // check above while moving up one.
                            blockState = world.getBlockState(blockpos$Mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANT && blockState.getBlock() != Blocks.LILY_PAD) {
                                world.setBlock(blockpos$Mutable, Blocks.AIR.defaultBlockState(), 2);

                                // recursively moves up and breaks floating sugar cane
                                while (blockpos$Mutable.getY() < world.getMaxBuildHeight() && world.getBlockState(blockpos$Mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.defaultBlockState()) {
                                    world.setBlock(blockpos$Mutable, Blocks.AIR.defaultBlockState(), 2);
                                }
                            }
                            if (material == Material.PLANT && blockState.getBlock() != Blocks.VINE) {
                                world.setBlock(blockpos$Mutable, Blocks.AIR.defaultBlockState(), 2);
                                world.setBlock(blockpos$Mutable.above(), Blocks.AIR.defaultBlockState(), 2);
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
    private boolean checkIfValidSpot(WorldGenLevel world, BlockPos.MutableBlockPos blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;

        //cannot be under ledge
        BlockPos.MutableBlockPos temp = new BlockPos.MutableBlockPos().set(blockpos$Mutable);
        blockState = world.getBlockState(temp.above());
        while (!blockState.getFluidState().isEmpty() && temp.getY() < 255) {
            temp.move(Direction.UP);
        }
        if (!blockState.isAir() && blockState.getFluidState().isEmpty())
            return false;


        // must be solid below
        // Will also return false if an unacceptable solid material is found.
        blockState = world.getBlockState(blockpos$Mutable.below());
        material = blockState.getMaterial();
        if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                BlockTags.PLANKS.contains(blockState.getBlock())) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getSource(false)) {
            return false;
        }


        // places water on tips
        if ((noise < 2D && world.getBlockState(blockpos$Mutable.above()).isAir())) {
            int open = 0;
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                if (world.getBlockState(blockpos$Mutable.relative(direction)).isAir()) open++;
            }
            if (open == 1) return true;
        }

        // Must be solid all around even diagonally.
        // Will also return false if an unacceptable solid material is found.
        for (int x2 = -1; x2 < 2; x2++) {
            for (int z2 = -1; z2 < 2; z2++) {
                blockState = world.getBlockState(blockpos$Mutable.offset(x2, 0, z2));
                material = blockState.getMaterial();

                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) || BlockTags.PLANKS.contains(blockState.getBlock())) && blockState.getFluidState().isEmpty() && blockState.getFluidState() != Fluids.WATER.getSource(false)) {
                    return false;
                }
            }
        }

        return true;
    }
}