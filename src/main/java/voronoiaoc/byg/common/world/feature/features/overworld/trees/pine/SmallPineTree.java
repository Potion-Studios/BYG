package voronoiaoc.byg.common.world.feature.features.overworld.trees.pine;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.structure.Structure;
import net.minecraft.structure.StructureManager;
import net.minecraft.structure.StructurePlacementData;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.BYG;

import java.util.Random;

public class SmallPineTree extends Feature<DefaultFeatureConfig> {

    public SmallPineTree(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(StructureWorldAccess serverWorldAccess, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (pos.getX() == -8 && pos.getZ() == -9) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        serverWorldAccess.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            StructureManager templatemanager = ((ServerWorld) serverWorldAccess).getStructureManager();
            Structure template = templatemanager.getStructure(new Identifier(BYG.MODID, ":features/trees/redwood_treexl_piece1"));
            Structure template2 = templatemanager.getStructure(new Identifier(BYG.MODID + ":features/trees/redwood_treexl_piece2"));

            if (template == null || template2 == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            StructurePlacementData placementsettings = (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(BlockRotation.NONE).setIgnoreEntities(false).setChunkPosition(null);
            template.placeAndNotifyListeners(serverWorldAccess, pos, placementsettings, random);
            template2.placeAndNotifyListeners(serverWorldAccess, pos.up(32), placementsettings, random);
            return true;
        }
        return false;
    }
}
