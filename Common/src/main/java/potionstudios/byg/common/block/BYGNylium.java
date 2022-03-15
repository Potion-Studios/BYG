package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.mixin.access.NyliumBlockAccess;

import java.util.Random;
import java.util.function.Supplier;

public class BYGNylium extends NyliumBlock {

    private final Supplier<ConfiguredFeature<?, ?>> feature;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, Supplier<ConfiguredFeature<?, ?>> feature, Block dirtBlock) {
        super(properties);
        this.feature = feature;
        this.dirtBlock = dirtBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (!NyliumBlockAccess.byg_invokeCanBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
        }
    }

    @Override
    public boolean isBonemealSuccess(Level $$0, Random $$1, BlockPos $$2, BlockState $$3) {
        return this.feature.get() != null;
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter $$0, BlockPos $$1, BlockState $$2, boolean $$3) {
        return this.feature.get() != null;
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        ConfiguredFeature<?, ?> configuredFeature = this.feature.get();
        configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, pos);
    }
}
