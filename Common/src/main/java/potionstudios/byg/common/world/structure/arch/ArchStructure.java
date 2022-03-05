package potionstudios.byg.common.world.structure.arch;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.QuartPos;
import net.minecraft.core.SectionPos;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGenerator;
import net.minecraft.world.level.levelgen.structure.pieces.PieceGeneratorSupplier;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.util.Mth.lerp;

public class ArchStructure extends StructureFeature<ArchConfiguration> {
    public ArchStructure(Codec<ArchConfiguration> $$0) {
        super($$0, PieceGeneratorSupplier.simple(PieceGeneratorSupplier.checkForBiomeOnTop(Heightmap.Types.WORLD_SURFACE_WG), ArchStructure::generatePieces));
    }

    private static void generatePieces(StructurePiecesBuilder piecesBuilder, PieceGenerator.Context<ArchConfiguration> context) {
        WorldgenRandom random = context.random();
        double angle = random.nextDouble(Math.PI * 2);
        ChunkPos chunkPos = context.chunkPos();
        int blockX = chunkPos.getBlockX(random.nextInt(16));
        int blockZ = chunkPos.getBlockZ(random.nextInt(16));

        ChunkGenerator generator = context.chunkGenerator();
        ArchConfiguration config = context.config();
        int length = config.length().sample(random) / 2;
        int archHeight = config.height().sample(random);
        BlockPos center = new BlockPos(blockX, generator.getBaseHeight(blockX, blockZ, Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor()) + archHeight, blockZ);
        double xOffset = Math.sin(angle) * length;
        double zOffset = Math.cos(angle) * length;

        BlockPos start = center.offset(-xOffset, 0, -zOffset);
        start = new BlockPos(start.getX(), generator.getBaseHeight(start.getX(), start.getZ(), Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor()) - 5, start.getZ());
        BlockPos end = center.offset(xOffset, 0, zOffset);
        end = new BlockPos(end.getX(), generator.getBaseHeight(end.getX(), end.getZ(), Heightmap.Types.OCEAN_FLOOR_WG, context.heightAccessor()) - 5, end.getZ());

        Long2ObjectOpenHashMap<Set<BlockPos>> chunkSortedPositions = new Long2ObjectOpenHashMap<>();

        int points = 1000;

        if (config.biomeEnforcement() != ArchConfiguration.EMPTY) {
            if (!matchesBiome(start, generator, config.biomeEnforcement()) || !matchesBiome(end, generator, config.biomeEnforcement())) {
                return;
            }
        }


        BlendingFunction blendingFunction = config.blendingFunction().getRandomValue(random).orElseThrow();
        BlendingFunction blendingFunction2 = random.nextFloat() < config.matchingBlendingFunctionChance().sample(random) ? blendingFunction : config.blendingFunction().getRandomValue(random).orElseThrow();
        for (int pointCount = points; pointCount >= 1; pointCount--) {
            double factor = (double) pointCount / points;
            {
                BlockPos startToCenterLerpPos = new BlockPos(lerp(factor, start.getX(), center.getX()), blendingFunction.apply(factor, start.getY(), center.getY()), lerp(factor, start.getZ(), center.getZ()));
                long chunkKey = ChunkPos.asLong(SectionPos.blockToSectionCoord(startToCenterLerpPos.getX()), SectionPos.blockToSectionCoord(startToCenterLerpPos.getZ()));
                chunkSortedPositions.computeIfAbsent(chunkKey, (key -> new HashSet<>())).add(startToCenterLerpPos);
            }

            {
                BlockPos centerToEndLerpPos = new BlockPos(lerp(factor, end.getX(), center.getX()), blendingFunction2.apply(factor, end.getY(), center.getY()), lerp(factor, end.getZ(), center.getZ()));
                long centerToEndChunkKey = ChunkPos.asLong(SectionPos.blockToSectionCoord(centerToEndLerpPos.getX()), SectionPos.blockToSectionCoord(centerToEndLerpPos.getZ()));
                chunkSortedPositions.computeIfAbsent(centerToEndChunkKey, (key -> new HashSet<>())).add(centerToEndLerpPos);
            }
        }

        chunkSortedPositions.forEach((offsetChunkPos, set) -> {
            ChunkPos movingChunkPos = new ChunkPos(offsetChunkPos);
            piecesBuilder.addPiece(new ArchPiece(set, config.sphereConfig(), 0, getWritableArea(movingChunkPos, context.heightAccessor())));
        });


    }

    private static BoundingBox getWritableArea(ChunkPos chunkPos, LevelHeightAccessor accessor) {
        int i = chunkPos.getMinBlockX();
        int j = chunkPos.getMinBlockZ();
        int k = accessor.getMinBuildHeight() + 1;
        int l = accessor.getMaxBuildHeight() - 1;
        return new BoundingBox(i, k, j, i + 15, l, j + 15);
    }

    private static boolean matchesBiome(BlockPos pos, ChunkGenerator generator, TagKey<Biome> biomeTagKey) {
        return generator.getNoiseBiome(QuartPos.fromBlock(pos.getX()), QuartPos.fromBlock(pos.getY()), QuartPos.fromBlock(pos.getZ())).is(biomeTagKey);
    }
}
