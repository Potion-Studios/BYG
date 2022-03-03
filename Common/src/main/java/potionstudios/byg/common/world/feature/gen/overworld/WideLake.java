package potionstudios.byg.common.world.feature.gen.overworld;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.synth.PerlinSimplexNoise;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.config.SimpleBlockProviderConfig;

import java.util.Random;
import java.util.Set;


public class WideLake extends Feature<SimpleBlockProviderConfig> {

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(Material.BAMBOO, Material.BAMBOO_SAPLING, Material.LEAVES, Material.WEB, Material.CACTUS, Material.HEAVY_METAL, Material.VEGETABLE, Material.CAKE, Material.EGG, Material.BARRIER, Material.CAKE);

    protected long noiseSeed;
    protected PerlinSimplexNoise noiseGen;

    public void setSeed(long seed) {
        WorldgenRandom sharedseedrandom = new WorldgenRandom(new XoroshiroRandomSource(seed));
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new PerlinSimplexNoise(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    public WideLake(Codec<SimpleBlockProviderConfig> configFactory) {
        super(configFactory);
    }

    @Override
    public boolean place(FeaturePlaceContext<SimpleBlockProviderConfig> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator chunkSettings, Random random, BlockPos position, SimpleBlockProviderConfig config) {
        setSeed(world.getSeed());
        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(position.below(2));

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
                            (double) position.getX() + x * 0.05D,
                            (double) position.getZ() + z * 0.05D, true) + 1)
                            * 3.0D;

                    for (int y = 0; y > -samplePerlin1; --y) {

                        mutable.set(position).move(x, y, z);

                        // checks if the spot is solid all around (diagonally too) and has nothing solid above it
                        containedFlag = checkIfValidSpot(world, mutable, samplePerlin1);

                        // Is spot within the mask (sorta a roundish area) and is contained
                        if (containedFlag) {
                            // check below without moving down

                            // sets the fluid block
                            BlockState configState = config.getBlockProvider().getState(random, mutable);

                            world.setBlock(mutable, configState, 3);
                            if (configState == Blocks.WATER.defaultBlockState())
                                world.scheduleTick(mutable, Fluids.WATER, 0);
                            else if (configState == Blocks.LAVA.defaultBlockState())
                                world.scheduleTick(mutable, Fluids.LAVA, 0);

                            // remove floating plants so they aren't hovering.
                            // check above while moving up one.
                            blockState = world.getBlockState(mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANT && blockState.getBlock() != Blocks.LILY_PAD && blockState.getBlock() != BYGBlocks.ENDER_LILY && blockState.getBlock() != BYGBlocks.TINY_LILYPADS) {
                                world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);

                                // recursively moves up and breaks floating sugar cane
                                while (mutable.getY() < world.getMaxBuildHeight() && world.getBlockState(mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.defaultBlockState()) {
                                    world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
                                }
                            }
                            if (material == Material.REPLACEABLE_PLANT && blockState.getBlock() != Blocks.VINE) {
                                world.setBlock(mutable, Blocks.AIR.defaultBlockState(), 2);
                                world.setBlock(mutable.above(), Blocks.AIR.defaultBlockState(), 2);
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
    private boolean checkIfValidSpot(LevelAccessor world, BlockPos.MutableBlockPos blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;

        //cannot be under ledge
        BlockPos.MutableBlockPos temp = new BlockPos.MutableBlockPos().set(blockpos$Mutable);
        blockState = world.getBlockState(temp.above());
        while (!blockState.getFluidState().isEmpty() && temp.getY() < world.getMaxBuildHeight()) {
            temp.move(Direction.UP);
        }
        if (!blockState.isAir() && blockState.getFluidState().isEmpty())
            return false;


        // must be solid below
        // Will also return false if an unacceptable solid material is found.
        blockState = world.getBlockState(blockpos$Mutable.below());
        material = blockState.getMaterial();
        if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) ||
                blockState.is(BlockTags.PLANKS)) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getSource(false)) {
            return false;
        }


        // places water on tips
        if ((noise < 2D && world.getBlockState(blockpos$Mutable.above()).isAir())) {
            int open = 0;
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                Material material2 = world.getBlockState(blockpos$Mutable.relative(direction)).getMaterial();
                if (unacceptableSolidMaterials.contains(material2)) return false;
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

                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) || blockState.is(BlockTags.PLANKS)) && blockState.getFluidState().isEmpty() && blockState.getFluidState() != Fluids.WATER.getSource(false)) {
                    return false;
                }
            }
        }

        return true;
    }
}