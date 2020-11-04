package corgiaoc.byg.common.world.structure.largefeature;

import corgiaoc.byg.BYG;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.core.world.BYGStructures;
import corgiaoc.byg.util.noise.fastnoise.lite.FastNoiseLite;
import net.minecraft.block.Blocks;
import net.minecraft.fluid.Fluids;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructurePiece;

import java.util.Random;

public class VolcanoPiece extends StructurePiece {

    FastNoiseLite fnlPerlin = null;

    protected VolcanoPiece(BlockPos pos) {
        super(BYGStructures.VOLCANO_PIECE, 0);
        this.boundingBox = new MutableBoundingBox(pos, pos);
    }

    public VolcanoPiece(CompoundNBT nbt) {
        super(BYGStructures.VOLCANO_PIECE, nbt);
    }

    @Override
    protected void readAdditional(CompoundNBT tagCompound) {
        //Leave this empty
    }



    @Override
    public boolean func_230383_a_(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox structureBoundingBox, ChunkPos chunkPos, BlockPos aPos) {
        BYG.LOGGER.info("BRRRRRRRRRRRRT");
        setSeed(world.getSeed());

//        if (world.getBlockState(pos.down()).getMaterial() == Material.AIR || world.getBlockState(pos.down()).getMaterial() == Material.WATER || world.getBlockState(pos.down()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
//            return false;
        int yHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, this.boundingBox.minX, this.boundingBox.minZ);

        BlockPos pos = new BlockPos(this.boundingBox.minX, yHeight, this.boundingBox.minZ);

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 25;
        double lavaLeakage = 0.7;
        int volcanoConeSize = 150;
        int volcanoStartHeight = volcanoConeSize - 5;
        double threshold = 0.5;

        MutableBoundingBox boundingBoxExpander = new MutableBoundingBox();

        for (double x = -volcanoConeSize; x <= volcanoConeSize; x++) {
            for (double y = -volcanoConeSize; y <= -15; y++) {
                for (double z = -volcanoConeSize; z <= volcanoConeSize; z++) {
                    mutable.setPos(pos).move((int)x, (int)y + volcanoStartHeight, (int)z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));

                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise - lavaLeakage >= threshold) {
                        if (mutable.getY() <= pos.getY() + (volcanoStartHeight - 19)) {
                            world.setBlockState(mutable, Blocks.LAVA.getDefaultState(), 2);
                            world.getPendingFluidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                            boundingBoxExpander.func_236989_a_(mutable);
                        }
                    }
                    else if (scaledNoise >= threshold) {
                        world.setBlockState(mutable, BYGBlocks.WARPED_CORAL_BLOCK.getDefaultState(), 2);
                    }
                }
            }
        }
        return true;
    }


    public void setSeed(long seed) {
        if (fnlPerlin == null) {
            fnlPerlin = FastNoiseLite.createSpongePerlin((int) seed);
            fnlPerlin.SetFrequency(0.2F);
        }
    }
}
