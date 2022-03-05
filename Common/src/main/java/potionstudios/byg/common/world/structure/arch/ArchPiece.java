package potionstudios.byg.common.world.structure.arch;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.StructureFeatureManager;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import potionstudios.byg.common.world.feature.BYGFeatures;
import potionstudios.byg.common.world.feature.config.NoisySphereConfig;
import potionstudios.byg.common.world.structure.BYGStructurePieceTypes;

import java.util.HashSet;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

public class ArchPiece extends StructurePiece {

    private final Set<BlockPos> positions = new HashSet<>();
    private final NoisySphereConfig config;

    public ArchPiece(Set<BlockPos> positions, NoisySphereConfig config, int $$1, BoundingBox $$2) {
        super(BYGStructurePieceTypes.ARCH_PIECE, $$1, $$2);
        this.config = config;
        this.positions.addAll(positions);
    }

    public ArchPiece(CompoundTag tag) {
        super(BYGStructurePieceTypes.ARCH_PIECE, tag);
        ListTag positions = tag.getList("positions", Tag.TAG_COMPOUND);

        for (Tag position : positions) {
            this.positions.add(NbtUtils.readBlockPos((CompoundTag) position));
        }
       this.config = NoisySphereConfig.CODEC.decode(NbtOps.INSTANCE, tag.get("config")).result().orElseThrow().getFirst();
    }

    @Override
    protected void addAdditionalSaveData(StructurePieceSerializationContext structurePieceSerializationContext, CompoundTag compoundTag) {
        ListTag positions = new ListTag();

        for (BlockPos position : this.positions) {
            positions.add(NbtUtils.writeBlockPos(position));
        }
        compoundTag.put("positions", positions);
        compoundTag.put("config", NoisySphereConfig.CODEC.encodeStart(NbtOps.INSTANCE, this.config).result().orElseThrow());
    }

    @Override
    public void postProcess(WorldGenLevel worldGenLevel, StructureFeatureManager structureFeatureManager, ChunkGenerator chunkGenerator, Random random, BoundingBox boundingBox, ChunkPos chunkPos, BlockPos blockPos) {
        for (BlockPos position : this.positions) {
            if (position.getY() == Integer.MIN_VALUE) {
                position = new BlockPos(position.getX(), worldGenLevel.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, position.getX(), position.getZ()) + 1, position.getZ());
            }
            BYGFeatures.BOULDER.place(new FeaturePlaceContext<>(Optional.empty(), worldGenLevel, chunkGenerator, random, position, this.config));
        }
    }
}
