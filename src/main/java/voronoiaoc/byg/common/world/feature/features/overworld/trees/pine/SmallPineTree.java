package voronoiaoc.byg.common.world.feature.features.overworld.trees.pine;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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
import voronoiaoc.byg.BYG;

import java.util.Random;

public class SmallPineTree extends Feature<NoneFeatureConfiguration> {

    public SmallPineTree(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(WorldGenLevel serverWorldAccess, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        if (pos.getX() == -8 && pos.getZ() == -9) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos(checkX, checkY, checkZ);
                        serverWorldAccess.setBlock(block, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }

            StructureManager templatemanager = ((ServerLevel) serverWorldAccess).getStructureManager();
            StructureTemplate template = templatemanager.get(new ResourceLocation(BYG.MODID, ":features/trees/redwood_treexl_piece1"));
            StructureTemplate template2 = templatemanager.get(new ResourceLocation(BYG.MODID + ":features/trees/redwood_treexl_piece2"));

            if (template == null || template2 == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            StructurePlaceSettings placementsettings = (new StructurePlaceSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunkPos(null);
            template.placeInWorld(serverWorldAccess, pos, placementsettings, random);
            template2.placeInWorld(serverWorldAccess, pos.above(32), placementsettings, random);
            return true;
        }
        return false;
    }
}
