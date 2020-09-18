package voronoiaoc.byg.common.properties.blocks.nether.embur;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.server.ServerWorld;
import voronoiaoc.byg.common.world.feature.biomefeatures.BYGFeatureConfigs;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class EmburNyliumBlock extends SpreadableEmburBlock implements IGrowable {
    public EmburNyliumBlock(Properties properties) {
        super(properties);
    }

    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return worldIn.getBlockState(pos.up()).isAir();
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return true;
    }

    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = worldIn.getBlockState(pos);
        BlockPos blockpos = pos.up();
        if (blockstate.isIn(BYGBlockList.EMBUR_NYLIUM)) {
            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, BYGFeatureConfigs.EMBUR_ROOTS, 3, 1);
        }
    }
}