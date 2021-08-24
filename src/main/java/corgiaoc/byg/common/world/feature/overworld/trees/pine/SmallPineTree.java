
package corgiaoc.byg.common.world.feature.overworld.trees.pine;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;

import java.util.Random;

public class SmallPineTree extends Feature<NoneFeatureConfiguration> {

    public SmallPineTree(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        if (pos.getX() == -4 && pos.getZ() == -4) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos(checkX, checkY, checkZ);
                        world.setBlock(block, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }

            StructureManager templatemanager = world.getLevel().getStructureManager();
            StructureTemplate template = templatemanager.get(new ResourceLocation(BYG.MOD_ID + ":features/trees/withering_oak_tree5"));

            if (template == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            StructurePlaceSettings placementsettings = (new StructurePlaceSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunkPos(null);
            template.placeInWorldChunk(world, pos, placementsettings, rand);
            return true;
        }
        return false;
    }
}