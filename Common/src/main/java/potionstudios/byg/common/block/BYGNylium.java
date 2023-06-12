package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.mixin.access.NyliumBlockAccess;

import java.util.function.Supplier;

public class BYGNylium extends NyliumBlock {

    private final Supplier<ResourceKey<ConfiguredFeature<?, ?>>> feature;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, Supplier<ResourceKey<ConfiguredFeature<?, ?>>> feature, Block dirtBlock) {
        super(properties);
        this.feature = feature;
        this.dirtBlock = dirtBlock;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!NyliumBlockAccess.byg_invokeCanBeNylium(state, world, pos)) {
            world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
        }
    }

    @Override
    public boolean isBonemealSuccess(Level $$0, RandomSource $$1, BlockPos $$2, BlockState $$3) {
        return this.feature.get() != null;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader $$0, BlockPos $$1, BlockState $$2, boolean $$3) {
        return this.feature.get() != null;
    }

    @Override
    public void performBonemeal(ServerLevel world, RandomSource rand, BlockPos pos, BlockState state) {
        ConfiguredFeature<?, ?> configuredFeature = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE).get(this.feature.get());
        configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, pos);
    }
}
