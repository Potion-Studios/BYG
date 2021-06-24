package corgiaoc.byg.common.world.feature.overworld;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.SimpleBlockProviderConfig;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.fluid.Fluids;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.noise.OctaveSimplexNoiseSampler;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;
import java.util.Set;


public class WideLake extends Feature<SimpleBlockProviderConfig> {

    protected static final Set<Material> unacceptableSolidMaterials = ImmutableSet.of(Material.BAMBOO, Material.BAMBOO_SAPLING, Material.LEAVES, Material.COBWEB, Material.CACTUS, Material.REPAIR_STATION, Material.GOURD, Material.CAKE, Material.EGG, Material.BARRIER, Material.CAKE);

    protected long noiseSeed;
    protected OctaveSimplexNoiseSampler noiseGen;

    public void setSeed(long seed) {
        ChunkRandom sharedseedrandom = new ChunkRandom(seed);
        if (this.noiseSeed != seed || this.noiseGen == null) {
            this.noiseGen = new OctaveSimplexNoiseSampler(sharedseedrandom, ImmutableList.of(0));
        }

        this.noiseSeed = seed;
    }


    public WideLake(Codec<SimpleBlockProviderConfig> configFactory) {
        super(configFactory);
    }


    @Override
    public boolean generate(FeatureContext<SimpleBlockProviderConfig> context) {
        StructureWorldAccess world = context.getWorld();
        BlockPos position = context.getOrigin();
        Random random = context.getRandom();
        SimpleBlockProviderConfig config = context.getConfig();

        setSeed(world.getSeed());
        BlockPos.Mutable mutable = new BlockPos.Mutable().set(position.down(2));

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

                    double samplePerlin1 = (this.noiseGen.sample(
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
                            BlockState configState = config.getBlockProvider().getBlockState(random, mutable);

                            world.setBlockState(mutable, configState, 3);
                            if (configState == Blocks.WATER.getDefaultState())
                                world.getFluidTickScheduler().schedule(mutable, Fluids.WATER, 0);
                            else if (configState == Blocks.LAVA.getDefaultState())
                                world.getFluidTickScheduler().schedule(mutable, Fluids.LAVA, 0);

                            // remove floating plants so they aren't hovering.
                            // check above while moving up one.
                            blockState = world.getBlockState(mutable.move(Direction.UP));
                            material = blockState.getMaterial();

                            if (material == Material.PLANT && blockState.getBlock() != Blocks.LILY_PAD && blockState.getBlock() != BYGBlocks.TINY_LILYPADS) {
                                world.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);

                                // recursively moves up and breaks floating sugar cane
                                while (mutable.getY() < world.getHeight() && world.getBlockState(mutable.move(Direction.UP)) == Blocks.SUGAR_CANE.getDefaultState()) {
                                    world.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);
                                }
                            }
                            if (material == Material.REPLACEABLE_PLANT && blockState.getBlock() != Blocks.VINE) {
                                world.setBlockState(mutable, Blocks.AIR.getDefaultState(), 2);
                                world.setBlockState(mutable.up(), Blocks.AIR.getDefaultState(), 2);
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
    private boolean checkIfValidSpot(WorldAccess world, BlockPos.Mutable blockpos$Mutable, double noise) {
        Material material;
        BlockState blockState;

        //cannot be under ledge
        BlockPos.Mutable temp = new BlockPos.Mutable().set(blockpos$Mutable);
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
                BlockTags.PLANKS.contains(blockState.getBlock())) &&
                blockState.getFluidState().isEmpty() &&
                blockState.getFluidState() != Fluids.WATER.getStill(false)) {
            return false;
        }


        // places water on tips
        if ((noise < 2D && world.getBlockState(blockpos$Mutable.up()).isAir())) {
            int open = 0;
            for (Direction direction : Direction.Type.HORIZONTAL) {
                Material material2 = world.getBlockState(blockpos$Mutable.offset(direction)).getMaterial();
                if (unacceptableSolidMaterials.contains(material2)) return false;
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

                if ((!material.isSolid() || unacceptableSolidMaterials.contains(material) || BlockTags.PLANKS.contains(blockState.getBlock())) && blockState.getFluidState().isEmpty() && blockState.getFluidState() != Fluids.WATER.getStill(false)) {
                    return false;
                }
            }
        }

        return true;
    }
}