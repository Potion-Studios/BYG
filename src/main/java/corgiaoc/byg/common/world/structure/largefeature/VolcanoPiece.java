package corgiaoc.byg.common.world.structure.largefeature;

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

    FastNoiseLite fnlPerlin;
    int baseRadius;
    double lavaLeakage;
    double threshold;
    int volcanoConeSize;
    int volcanoStartHeight;
    int volcanoSizeXMin;
    int volcanoSizeXMax;
    int volcanoSizeZMin;
    int volcanoSizeZMax;

    protected VolcanoPiece(BlockPos pos, int baseRadius, double lavaLeakage, int volcanoConeSize, int volcanoStartHeight, double threshold, FastNoiseLite fastNoiseLite, int volcanoConeSizeXMin, int volcanoConeSizeXMax, int volcanoConeSizeZMin, int volcanoConeSizeZMax) {
        super(BYGStructures.VOLCANO_PIECE, 0);
        this.boundingBox = new MutableBoundingBox(pos, pos);
        this.fnlPerlin = fastNoiseLite;
        this.baseRadius = baseRadius;
        this.volcanoConeSize = volcanoConeSize;
        this.lavaLeakage = lavaLeakage;
        this.volcanoStartHeight = volcanoStartHeight;
        this.threshold = threshold;
        this.volcanoSizeXMin = volcanoConeSizeXMin;
        this.volcanoSizeXMax = volcanoConeSizeXMax;
        this.volcanoSizeZMin = volcanoConeSizeZMin;
        this.volcanoSizeZMax = volcanoConeSizeZMax;

    }


    public VolcanoPiece(CompoundNBT nbt) {
        super(BYGStructures.VOLCANO_PIECE, nbt);
    }

    @Override
    protected void addAdditionalSaveData(CompoundNBT tagCompound) {
        //Leave this empty
    }



    @Override
    public boolean postProcess(ISeedReader world, StructureManager manager, ChunkGenerator generator, Random rand, MutableBoundingBox structureBoundingBox, ChunkPos chunkPos, BlockPos aPos) {

//        if (world.getBlockState(pos.down()).getMaterial() == Material.AIR || world.getBlockState(pos.down()).getMaterial() == Material.WATER || world.getBlockState(pos.down()).getMaterial() == Material.LAVA || world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, pos.getX(), pos.getZ()) < 4)
//            return false;
        int yHeight = world.getHeight(Heightmap.Type.OCEAN_FLOOR_WG, this.boundingBox.x0, this.boundingBox.z0);

        BlockPos pos = new BlockPos(this.boundingBox.x0, yHeight, this.boundingBox.z0);

        BlockPos.Mutable mutable = new BlockPos.Mutable();

        double baseRadius = 25;
        double lavaLeakage = 0.7;
        int volcanoConeSize = 150;
        int volcanoStartHeight = volcanoConeSize - 5;
        double threshold = 0.5;

        MutableBoundingBox boundingBoxExpander = new MutableBoundingBox();

        for (double x = -volcanoSizeXMin; x <= volcanoSizeXMax; x++) {
            for (double y = -volcanoConeSize; y <= -15; y++) {
                for (double z = -volcanoSizeXMin; z <= volcanoSizeZMax; z++) {
                    mutable.set(pos).move((int)x, (int)y + volcanoStartHeight, (int)z);
                    float noise3 = FastNoiseLite.getSpongePerlinValue(fnlPerlin.GetNoise(mutable.getX(), mutable.getZ()));

                    double scaledNoise = (noise3 / 11) * (-(y * baseRadius) / ((x * x) + (z * z)));
                    if (scaledNoise - lavaLeakage >= threshold) {
                        if (mutable.getY() <= pos.getY() + (volcanoStartHeight - 19)) {
                            world.setBlock(mutable, Blocks.LAVA.defaultBlockState(), 2);
                            world.getLiquidTicks().scheduleTick(mutable, Fluids.LAVA, 0);
                            boundingBoxExpander.move(mutable);
                        }
                    }
                    else if (scaledNoise >= threshold) {
                        world.setBlock(mutable, BYGBlocks.WARPED_CORAL_BLOCK.defaultBlockState(), 2);
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
