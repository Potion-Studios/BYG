package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

public class EmburGelVines extends Feature<NoFeatureConfig> {
    public EmburGelVines(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(2) + 3;

        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (worldIn.getBlockState(pos.up()).getBlock() != BYGBlockList.EMBUR_GEL_BLOCK) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
                if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                    worldIn.setBlockState(mutable, BYGBlockList.EMBUR_GEL_VINES.getDefaultState(), 10);

            }
            return true;
        }
    }
}