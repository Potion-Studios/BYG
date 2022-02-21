
package potionstudios.byg.common.world.feature.gen.overworld.trees.pine;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import potionstudios.byg.BYG;

import java.util.Optional;
import java.util.Random;

public class SmallPineTree extends Feature<NoneFeatureConfiguration> {

    public SmallPineTree(Codec<NoneFeatureConfiguration> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

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
            Optional<StructureTemplate> structureTemplate = templatemanager.get(BYG.createLocation(":features/trees/withering_oak_tree5"));

            if (structureTemplate.isEmpty()) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }
            StructureTemplate template = structureTemplate.get();

            StructurePlaceSettings placementsettings = (new StructurePlaceSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false);
            template.placeInWorld(world, pos, pos, placementsettings, rand, 2);
            return true;
        }
        return false;
    }
}