package potionstudios.byg.common.block.sapling;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class BYGTreeGrower extends AbstractTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull RandomSource randomSource, boolean b) {
        return null;
    }

    @Override
    public boolean growTree(@NotNull ServerLevel $$0, @NotNull ChunkGenerator $$1, @NotNull BlockPos $$2, @NotNull BlockState $$3, @NotNull RandomSource $$4) {
        return false;
    }
}
