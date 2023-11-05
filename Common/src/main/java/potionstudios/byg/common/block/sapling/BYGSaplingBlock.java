package potionstudios.byg.common.block.sapling;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;
import potionstudios.byg.util.ModPlatform;

import java.util.List;

public class BYGSaplingBlock extends SaplingBlock implements FeatureGrowerFromBlockPattern {

    private ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> patternsToSpawner = ImmutableList.of();
    private final TagKey<Block> groundTag;

    public BYGSaplingBlock(Properties properties, TagKey<Block> groundTag) {
        super(new BYGTreeGrower(), properties);
        this.groundTag = groundTag;
        ENTRIES.add(() -> this);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
        return state.is(this.groundTag);
    }

    @Override
    public void advanceTree(@NotNull ServerLevel level, @NotNull BlockPos pos, BlockState state, @NotNull RandomSource random) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!ModPlatform.INSTANCE.canTreeGrowWithEvent(level, random, pos)) {
                return;
            }

            this.growFeature(this, level, pos, random);
        }
    }

    @Override
    public ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> getPatterns() {
        return this.patternsToSpawner;
    }

    @Override
    public void setPatterns(ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> map) {
        this.patternsToSpawner = map;
    }
}