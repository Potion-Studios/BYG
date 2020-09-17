package voronoiaoc.byg.common.properties.blocks.nether.glowstonegardens;

import net.minecraft.block.BlockState;
import net.minecraft.block.IGrowable;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.NetherVegetationFeature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class MyceliumNetherrackBlock extends SpreadableMyceliumNetherrackBlock {
    public MyceliumNetherrackBlock(Properties properties) {
        super(properties);
    }

//    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
//        return worldIn.getBlockState(pos.up()).isAir();
//    }
//
//    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
//        return true;
//    }
//
//    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
//        BlockState blockstate = worldIn.getBlockState(pos);
//        BlockPos blockpos = pos.up();
//        if (blockstate.isIn(BYGBlockList.MYCELIUM_NETHERRACK)) {
//            NetherVegetationFeature.func_236325_a_(worldIn, rand, blockpos, Features.Configs.CRIMSON_FOREST_VEGETATION_CONFIG, 3, 1);
//        }
//    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        super.animateTick(stateIn, worldIn, pos, rand);
        if (rand.nextInt(10) == 0) {
            worldIn.addParticle(ParticleTypes.MYCELIUM, (double)pos.getX() + rand.nextDouble(), (double)pos.getY() + 1.1D, (double)pos.getZ() + rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }
}