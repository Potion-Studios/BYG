package voronoiaoc.byg.common.world.structure.village;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.structure.*;
import net.minecraft.structure.pool.StructurePoolBasedGenerator;
import net.minecraft.structure.pool.StructurePoolElement;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.ChunkRandom;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.StructurePoolFeatureConfig;
import voronoiaoc.byg.common.world.structure.village.villagepools.*;

import java.util.List;

public class BYGVillagePieces {

    public static void addPieces(ChunkGenerator chunkGenerator, StructureManager structureManager, BlockPos pos, List<StructurePiece> pieces, ChunkRandom random, StructurePoolFeatureConfig config) {
        BYGGuianaVillagePools.init();
        BYGGrasslandVillagePools.init();
        BYGJungleVillagePools.init();
        BYGAdobeVillagePools.init();
        BYGSkyrisVillagePools.init();
        StructurePoolBasedGenerator.addPieces(config.startPool, config.size, Pieces::new, chunkGenerator, structureManager, pos, pieces, random, true, true);
    }

    public static class Pieces extends PoolStructurePiece {
        public Pieces(StructureManager structureManager, StructurePoolElement structurePoolElement, BlockPos blockPos, int i, BlockRotation blockRotation, BlockBox blockBox) {
            super(StructurePieceType.VILLAGE, structureManager, structurePoolElement, blockPos, i, blockRotation, blockBox);
        }

        public Pieces(StructureManager structureManager, CompoundTag compoundTag) {
            super(structureManager, compoundTag, StructurePieceType.VILLAGE);
        }
    }
}
