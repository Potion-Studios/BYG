package voronoiaoc.byg.common.world.feature.features.overworld.trees.pine;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.BYG;

import java.util.Random;
import java.util.function.Function;

public class SmallPineTree extends Feature<NoFeatureConfig> {

    public static Template template = null;

    public SmallPineTree(Function<Dynamic<?>, ? extends NoFeatureConfig> configIn) {
        super(configIn);
    }

    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {


        if (pos.getX() == -8 && pos.getZ() == -4) {
            for (int checkX = pos.getX() + -16; checkX <= pos.getX() + 16; checkX++) {
                for (int checkY = pos.getY(); checkY <= 25; checkY++) {
                    for (int checkZ = pos.getZ() + -16; checkZ <= pos.getZ() + 16; checkZ++) {
                        BlockPos.Mutable block = new BlockPos.Mutable(checkX, checkY, checkZ);
                        world.setBlockState(block, Blocks.AIR.getDefaultState(), 2);
                    }
                }
            }

            TemplateManager templatemanager = ((ServerWorld) world.getWorld()).getSaveHandler().getStructureTemplateManager();

            if (template == null)
                template = templatemanager.getTemplate(new ResourceLocation(BYG.MOD_ID + ":features/trees/ancient_tree2"));

            if (template == null) {
                BYG.LOGGER.warn("NBT does not exist!");
                return false;
            }

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
            template.addBlocksToWorld(world, pos, placementsettings);
            return true;
        }
        return false;
    }
}
