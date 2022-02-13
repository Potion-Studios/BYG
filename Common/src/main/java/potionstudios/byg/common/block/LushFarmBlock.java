package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class LushFarmBlock extends FarmBlock {

    public LushFarmBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(MOISTURE, 7));
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
    }

//    public void GetMoisture(){
//
//
//    }

    @Override
    public void animateTick(BlockState $$0, Level $$1, BlockPos $$2, Random $$3) {
        super.animateTick($$0, $$1, $$2, $$3);

        for(int $$4 = -2; $$4 <= 2; ++$$4) {
            for(int $$5 = -2; $$5 <= 2; ++$$5) {
                if ($$4 > -2 && $$4 < 2 && $$5 == -1) {
                    $$5 = 2;
                }

                if ($$3.nextInt(16) == 0) {
                    for(int $$6 = 0; $$6 <= 1; ++$$6) {
                        BlockPos $$7 = $$2.offset($$4, $$6, $$5);
                        if ($$1.getBlockState($$7).is(BYGBlocks.THERIUM_LANTERN)) {
                            if (!$$1.isEmptyBlock($$2.offset($$4 / 2, 0, $$5 / 2))) {
                                break;
                            }

                            $$1.addParticle(ParticleTypes.WARPED_SPORE, (double)$$2.getX() + 0.5D, (double)$$2.getY() + 2.0D, (double)$$2.getZ() + 0.5D, (double)((float)$$4 + $$3.nextFloat()) - 0.5D, (float)$$6 - $$3.nextFloat() - 1.0F, (double)((float)$$5 + $$3.nextFloat()) - 0.5D);
                        }
                    }
                }
            }
        }

    }

}
