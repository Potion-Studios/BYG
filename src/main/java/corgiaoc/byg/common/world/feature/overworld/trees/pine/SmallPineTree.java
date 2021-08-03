
package corgiaoc.byg.common.world.feature.overworld.trees.pine;

import com.mojang.serialization.Codec;
import corgiaoc.byg.BYG;
import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;

import java.util.Random;

public class SmallPineTree extends Feature<NoFeatureConfig> {

    public SmallPineTree(Codec<NoFeatureConfig> configIn) {
        super(configIn);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (pos.getX() == -4 && pos.getZ() == -4) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlock(block, Blocks.AIR.defaultBlockState(), 2);
                    }
                }
            }

            TemplateManager templatemanager = world.getLevel().getStructureManager();
            Template template = templatemanager.get(new ResourceLocation(BYG.MOD_ID + ":features/trees/withering_oak_tree5"));

            if (template == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunkPos(null);
            template.placeInWorldChunk(world, pos, placementsettings, rand);
            return true;
        }
        return false;
    }
}