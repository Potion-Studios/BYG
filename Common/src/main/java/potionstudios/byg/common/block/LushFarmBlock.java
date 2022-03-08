package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.util.BYGUtil;

import java.util.Random;
import java.util.function.BiPredicate;

public class LushFarmBlock extends FarmBlock {
    public static final int THERIUM_LANTERN_SEARCH_RANGE = 7;
    public static final BiPredicate<LevelReader, BlockPos> IS_THERIUM_LANTERN = (levelReader, movingPos) -> levelReader.getBlockState(movingPos).is(BYGBlocks.THERIUM_LANTERN);

    public LushFarmBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, Random random) {
        boolean foundTheriumLamp = BYGUtil.isNearby(serverLevel, blockPos, THERIUM_LANTERN_SEARCH_RANGE, IS_THERIUM_LANTERN);

        if (!foundTheriumLamp) {
            super.randomTick(blockState, serverLevel, blockPos, random);
        } else {
            serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, 7), 2);
        }
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, Random random) {
        super.animateTick(blockState, level, blockPos, random);

        if (random.nextInt(10) == 0 && BYGUtil.isNearby(level, blockPos, THERIUM_LANTERN_SEARCH_RANGE, IS_THERIUM_LANTERN)) {
//            level.addParticle(ParticleTypes.WARPED_SPORE, blockPos.getX() + 0.5D, blockPos.getY() + 2.0D, blockPos.getZ() + 0.5D, (double) random.nextDouble() - 0.5D, random.nextDouble() - 1.0F, random.nextDouble() - 0.5D);
            level.addParticle(BYGParticleTypes.THERIUM_GLINT, (double)blockPos.getX() + random.nextDouble(), (double)blockPos.getY() + 1.1D, (double)blockPos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

}
