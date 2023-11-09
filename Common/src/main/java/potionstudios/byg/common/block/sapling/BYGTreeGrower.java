package potionstudios.byg.common.block.sapling;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BYGTreeGrower extends AbstractTreeGrower {


    @Override
    public boolean growTree(@NotNull ServerLevel $$0, @NotNull ChunkGenerator $$1, @NotNull BlockPos $$2, @NotNull BlockState $$3, @NotNull Random $$4) {
        return false;
    }

    @Nullable
    @Override
    protected Holder<? extends ConfiguredFeature<?, ?>> getConfiguredFeature(@NotNull Random random, boolean b) {
        return null;
    }
}
