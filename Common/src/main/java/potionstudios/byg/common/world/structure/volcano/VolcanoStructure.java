package potionstudios.byg.common.world.structure.volcano;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.core.SectionPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.world.structure.BYGStructureTypes;

import java.util.Optional;

public class VolcanoStructure extends Structure {

    public static final Codec<VolcanoStructure> CODEC = RecordCodecBuilder.<VolcanoStructure>mapCodec(
            archStructureInstance ->
                    archStructureInstance.group(
                            settingsCodec(archStructureInstance)
                    ).apply(archStructureInstance, VolcanoStructure::new)
    ).codec();

    public VolcanoStructure(StructureSettings structureSettings) {
        super(structureSettings);
    }


    private static void generatePieces(StructurePiecesBuilder piecesBuilder, GenerationContext context) {
        WorldgenRandom random = context.random();

        int seed = random.nextInt();

        ChunkPos chunkPos = context.chunkPos();
        int blockX = chunkPos.getBlockX(random.nextInt(16));
        int blockZ = chunkPos.getBlockZ(random.nextInt(16));

        int baseHeight = context.chunkGenerator().getBaseHeight(blockX, blockZ, Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor(), context.randomState());

        BlockPos origin = new BlockPos(blockX, baseHeight, blockZ);

        double baseRadius = random.nextInt(75, 120);
        double leakage = 2 - (random.nextDouble() * 2);
        int volcanoConeSize = random.nextInt(75, 120) + 50;
        int volcanoStartHeight = volcanoConeSize - 10;
        double threshold = 1;
        int maxY = -random.nextInt(5, 35);

        int fluidYOffset = random.nextInt(2, 5);

        int coneSizePacked = SectionPos.blockToSectionCoord(volcanoConeSize);

        for (int x = -coneSizePacked; x <= coneSizePacked; x++) {
            for (int z = -coneSizePacked; z <= coneSizePacked; z++) {
                long chunk = ChunkPos.asLong(SectionPos.blockToSectionCoord(blockX) + x, SectionPos.blockToSectionCoord(blockZ) + z);
                piecesBuilder.addPiece(new VolcanoPiece(new PieceStructureInfo(origin, seed, baseRadius, leakage, volcanoConeSize, volcanoStartHeight, threshold, maxY, fluidYOffset), 0, getWritableArea(new ChunkPos(chunk), context.heightAccessor())));
            }
        }
    }


    public static BoundingBox getWritableArea(ChunkPos chunkPos, LevelHeightAccessor accessor) {
        int i = chunkPos.getMinBlockX();
        int j = chunkPos.getMinBlockZ();
        int k = accessor.getMinBuildHeight() + 1;
        int l = accessor.getMaxBuildHeight() - 1;
        return new BoundingBox(i, k, j, i + 15, l, j + 15);
    }

    private static boolean matchesBiome(BlockPos pos, ChunkGenerator generator, TagKey<Biome> biomeTagKey, RandomState randomState) {
        return generator.getBiomeSource().getNoiseBiome(QuartPos.fromBlock(pos.getX()), QuartPos.fromBlock(pos.getY()), QuartPos.fromBlock(pos.getZ()), randomState.sampler()).is(biomeTagKey);
    }


    @Override
    public @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext generationContext) {
        return onTopOfChunkCenter(generationContext, Heightmap.Types.WORLD_SURFACE_WG, (piecesBuilder) -> generatePieces(piecesBuilder, generationContext));
    }

    @Override
    public @NotNull StructureType<?> type() {
        return BYGStructureTypes.VOLCANO.get();
    }


    public record PieceStructureInfo(BlockPos origin, int noiseSeed, double baseRadius, double leakage,
                                     int volcanoConeSize, int volcanoStartHeight, double threshold, int maxY,
                                     int fluidY) {
        public static final Codec<PieceStructureInfo> CODEC = RecordCodecBuilder.create(
                builder ->
                        builder.group(
                                BlockPos.CODEC.fieldOf("origin").forGetter(PieceStructureInfo::origin),
                                Codec.INT.fieldOf("noiseSeed").forGetter(PieceStructureInfo::noiseSeed),
                                Codec.DOUBLE.fieldOf("baseRadius").forGetter(PieceStructureInfo::baseRadius),
                                Codec.DOUBLE.fieldOf("leakage").forGetter(PieceStructureInfo::leakage),
                                Codec.INT.fieldOf("volcanoConeSize").forGetter(PieceStructureInfo::volcanoConeSize),
                                Codec.INT.fieldOf("volcanoStartHeight").forGetter(PieceStructureInfo::volcanoStartHeight),
                                Codec.DOUBLE.fieldOf("threshold").forGetter(PieceStructureInfo::threshold),
                                Codec.INT.fieldOf("maxY").forGetter(PieceStructureInfo::maxY),
                                Codec.INT.fieldOf("fluidY").forGetter(PieceStructureInfo::fluidY)
                        ).apply(builder, PieceStructureInfo::new)
        );
    }
}
