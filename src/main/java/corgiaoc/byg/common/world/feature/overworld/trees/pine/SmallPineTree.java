package corgiaoc.byg.common.world.feature.overworld.trees.pine;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import net.minecraft.block.Blocks;
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

import java.util.Random;

public class SmallPineTree extends Feature<DefaultFeatureConfig> {

    public SmallPineTree(Codec<DefaultFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        if (pos.getX() == -8 && pos.getZ() == -9) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            StructureManager templatemanager = world.toServerWorld().getStructureManager();
            Structure template = templatemanager.getStructure(new Identifier(BYG.MOD_ID + ":features/trees/ether_tree5"));

            if (template == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            StructurePlacementData placementsettings = (new StructurePlacementData()).setMirror(BlockMirror.NONE).setRotation(BlockRotation.NONE).setIgnoreEntities(false).setChunkPosition(null);
            template.place(world, pos, placementsettings, rand);
            return true;
        }
        return false;
    }
}
