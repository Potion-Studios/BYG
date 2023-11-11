package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.FarmBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.client.textures.renders.BYGParticleTypes;
import potionstudios.byg.util.BYGUtil;

import java.util.function.BiPredicate;

public class LushFarmBlock extends FarmBlock {
    public static final int THERIUM_LANTERN_SEARCH_RANGE = 7;
    public static final BiPredicate<LevelReader, BlockPos> IS_THERIUM_LANTERN = (levelReader, movingPos) -> levelReader.getBlockState(movingPos).is(BYGBlocks.THERIUM_LANTERN.get());

    public LushFarmBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void randomTick(@NotNull BlockState blockState, @NotNull ServerLevel serverLevel, @NotNull BlockPos blockPos, @NotNull RandomSource random) {
        boolean foundTheriumLamp = BYGUtil.isNearby(serverLevel, blockPos, THERIUM_LANTERN_SEARCH_RANGE, IS_THERIUM_LANTERN);

        if (!foundTheriumLamp) {
            super.randomTick(blockState, serverLevel, blockPos, random);
        } else {
            serverLevel.setBlock(blockPos, blockState.setValue(MOISTURE, 7), 2);
        }
    }

    @Override
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource random) {
        super.animateTick(blockState, level, blockPos, random);

        if (random.nextInt(10) == 0 && BYGUtil.isNearby(level, blockPos, THERIUM_LANTERN_SEARCH_RANGE, IS_THERIUM_LANTERN)) {
            level.addParticle(BYGParticleTypes.THERIUM_GLINT.get(), (double)blockPos.getX() + random.nextDouble(), (double)blockPos.getY() + 1.1D, (double)blockPos.getZ() + random.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
    }

}
