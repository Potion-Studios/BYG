package potionstudios.byg.common.world.structure.volcano;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.UniformFloat;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.synth.NormalNoise;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.stateproviders.BetweenNoiseThresholdProvider;
import potionstudios.byg.common.world.math.noise.fastnoise.lite.FastNoiseLite;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;

import java.util.List;

public class VolcanoPiece extends StructurePiece {

    private final VolcanoStructure.PieceStructureInfo structureInfo;

    protected VolcanoPiece(VolcanoStructure.PieceStructureInfo structureInfo, int genDepth, BoundingBox boundingBox) {
        super(BYGStructurePieceTypes.VOLCANO_PIECE.get(), genDepth, boundingBox);
        this.structureInfo = structureInfo;
    }

    public VolcanoPiece(StructurePieceSerializationContext context, CompoundTag tag) {
        super(BYGStructurePieceTypes.ARCH_PIECE.get(), tag);
        this.structureInfo = VolcanoStructure.PieceStructureInfo.CODEC.decode(NbtOps.INSTANCE, tag.get("volcano_info")).result().orElseThrow().getFirst();
    }

    @Override
    protected void addAdditionalSaveData(@NotNull StructurePieceSerializationContext context, CompoundTag compoundTag) {
        compoundTag.put("volcano_info", VolcanoStructure.PieceStructureInfo.CODEC.encodeStart(NbtOps.INSTANCE, this.structureInfo).result().orElseThrow());
    }


    @Override
    public void postProcess(@NotNull WorldGenLevel worldGenLevel, @NotNull StructureManager structureManager, @NotNull ChunkGenerator chunkGenerator, @NotNull RandomSource randomSource, @NotNull BoundingBox boundingBox, ChunkPos chunkPos, @NotNull BlockPos blockPos) {
        BetweenNoiseThresholdProvider weightedBlockStateProvider = new BetweenNoiseThresholdProvider(123, new NormalNoise.NoiseParameters(-9, 1.0D, 1.0D, 1.0D, 1.0D), 1,
                List.of(UniformFloat.of(-0.0045F - 0.9F, 0.0045F - 0.9F), UniformFloat.of(-0.0045F, 0.0045F)), BlockStateProvider.simple(Blocks.MAGMA_BLOCK), new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder()
                .add(Blocks.BASALT.defaultBlockState(), 9)
                .add(BYGBlocks.BLACK_SAND.defaultBlockState(), 2)
                .add(Blocks.DEEPSLATE.defaultBlockState(), 5)
                .add(Blocks.SMOOTH_BASALT.defaultBlockState(), 10).build()), false);

        double baseRadius = this.structureInfo.baseRadius();
        double leakage = this.structureInfo.leakage();
        int volcanoConeSize = this.structureInfo.volcanoConeSize();
        int volcanoStartHeight = this.structureInfo.volcanoStartHeight();
        double threshold = 0.35;
        int maxY = this.structureInfo.maxY();
        int baseHeight = this.structureInfo.origin().getY();

        int fluidYOffset = this.structureInfo.fluidY();

        FastNoiseLite spongeNoise = FastNoiseLite.createSpongeNoise(this.structureInfo.noiseSeed());

        spongeNoise.SetFrequency(0.05F);

        BlockPos subtract = this.structureInfo.origin().offset(-volcanoConeSize, 0, -volcanoConeSize);
        int startX = subtract.getX();
        int startZ = subtract.getZ();

        BlockPos add = this.structureInfo.origin().offset(volcanoConeSize, 0, volcanoConeSize);
        int endX = add.getX();
        int endZ = add.getZ();

        BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();
        int minX = Math.max(startX, chunkPos.getMinBlockX());
        int maxX = Math.min(endX, chunkPos.getMaxBlockX());

        int minZ = Math.max(startZ, chunkPos.getMinBlockZ());
        int maxZ = Math.min(endZ, chunkPos.getMaxBlockZ());

        for (int worldX = minX; worldX <= maxX; worldX++) {
            int localX = worldX - this.structureInfo.origin().getX();

            for (int worldZ = minZ; worldZ <= maxZ; worldZ++) {
                int localZ = worldZ - this.structureInfo.origin().getZ();

                float spongeNoiseValue = FastNoiseLite.getSpongeNoiseValue(spongeNoise.GetNoise(mutable.getX(), 0, mutable.getZ()));

                for (double y = -volcanoConeSize; y <= maxY; y++) {
                    mutable.set(worldX, baseHeight + y + volcanoStartHeight, worldZ);

                    double scaledNoise = (spongeNoiseValue / 13) * (-(y * baseRadius) / ((localX * localX) + (localZ * localZ)));

                    int fluidY = maxY - fluidYOffset;
                    double lava = scaledNoise - leakage - (leakage / 2) - 0.5;
                    double crater = scaledNoise - 0.05;
                    if (lava >= threshold) {
                        if (y <= fluidY) {
                            worldGenLevel.setBlock(mutable, Blocks.LAVA.defaultBlockState(), 2, 1);
                        }
                    } else if (crater >= threshold) {
                        double pct = threshold / crater;
                        double craterY = Mth.clampedLerp(maxY, fluidY, 1 - pct);
                        if (y <= craterY) {
                            worldGenLevel.setBlock(mutable, weightedBlockStateProvider.getState(randomSource, mutable), 2, 1);
                        }
                    } else if (scaledNoise >= threshold) {
                        worldGenLevel.setBlock(mutable, weightedBlockStateProvider.getState(randomSource, mutable), 2, 1);
                    }
                    mutable.move(Direction.DOWN);
                }
            }
        }
    }
}