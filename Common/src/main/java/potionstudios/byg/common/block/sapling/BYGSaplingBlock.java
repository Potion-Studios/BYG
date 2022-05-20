package potionstudios.byg.common.block.sapling;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BYGSaplingBlock extends SaplingBlock implements FeatureGrowerFromBlockPattern {

    private final List<Pair<List<BlockPos>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> patternsToSpawner = new ArrayList<>();
    private final TagKey<Block> groundTag;

    public BYGSaplingBlock(Properties properties, TagKey<Block> groundTag) {
        super(null, properties);
        this.groundTag = groundTag;
        ENTRIES.add(() -> this);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(this.groundTag);
    }

    @Override
    public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            FeatureGrowerFromBlockPattern.growFeature(this, world, pos, rand, this.patternsToSpawner);
        }
    }

    @Override
    public void load() {
        FeatureGrowerFromBlockPattern.serializePatterns(Registry.BLOCK.getKey(this), this.patternsToSpawner);
    }
}