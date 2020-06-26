package voronoiaoc.byg.common.world.feature.features.overworld.structure;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.BYG;

import java.util.List;
import java.util.Random;


public class DoverQuarry1 extends Feature<NoFeatureConfig> {
    public DoverQuarry1(Codec<NoFeatureConfig> configFactory) {
        super(configFactory);
    }

    @Override
    public boolean func_230362_a_(ISeedReader world, StructureManager structureManager, ChunkGenerator changedBlock, Random rand, BlockPos position, NoFeatureConfig p_212245_5_) {
        if (rand.nextInt(10) == 0) {
            int y = world.getHeight(Heightmap.Type.WORLD_SURFACE_WG, position).getY();
            BlockPos.Mutable blockpos$Mutable = new BlockPos.Mutable().setPos(position.up(y).down(27));
            BlockPos.Mutable blockpos$Mutable2 = new BlockPos.Mutable().setPos(position.up(y).down(27));
            BlockPos.Mutable blockpos$Mutable3 = new BlockPos.Mutable();

//            for (int checkX = 0; checkX >= -18; checkX--) {
//                for (int checkY = 0; checkY <= 4; checkY++) {
//                    for (int checkZ = 0; checkZ >= -18; checkZ--) {
//                        if (world.getBlockState(blockpos$Mutable2.setPos(blockpos$Mutable.getX() + checkX, blockpos$Mutable.getY() + checkY, blockpos$Mutable.getZ() + checkZ)).getBlock() == Blocks.AIR
//                                /*|| !world.canBlockSeeSky(blockpos$Mutable3.setPos(position.getX() + checkX, position.getY() + 1, position.getZ() + checkZ))*/)
//                            return false;
//                    }
//                }
//            }
            blockpos$Mutable.setPos(position.up(y).down(27));

            TemplateManager templatemanager = ((ServerWorld) world.getWorld()).getStructureTemplateManager();
            Template template = templatemanager.getTemplate(new ResourceLocation(BYG.MOD_ID + ":features/dover_quarry1"));

            if (template == null) {
                BYG.LOGGER.warn("Dover Quarry NBT does not exist!");
                return false;
            }
            List<Pair<BlockPos, CompoundNBT>> list2 = Lists.newArrayListWithCapacity(template.blocks.size());

            PlacementSettings placementsettings = (new PlacementSettings()).setMirror(Mirror.NONE).setRotation(Rotation.NONE).setIgnoreEntities(false).setChunk(null);
//            template.addBlocksToWorld(world, blockpos$Mutable, placementsettings);

            return true;
        }
        return false;
    }
}
