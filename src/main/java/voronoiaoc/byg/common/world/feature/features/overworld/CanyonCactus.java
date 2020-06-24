package voronoiaoc.byg.common.world.feature.features.overworld;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class CanyonCactus extends Feature<NoFeatureConfig> {
    public CanyonCactus(Function<Dynamic<?>, ? extends NoFeatureConfig> config) {
        super(config);
    }

    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != Blocks.RED_SAND)
            return false;
        if (pos.getY() < 140)
            return false;
        else {
            worldIn.setBlockState(pos, Blocks.CACTUS.getDefaultState(), 2);
            worldIn.setBlockState(pos.up(), Blocks.CACTUS.getDefaultState(), 2);
            return true;
        }
    }
}