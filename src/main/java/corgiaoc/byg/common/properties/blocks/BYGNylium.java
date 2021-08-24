package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.mixin.access.NyliumBlockAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.NyliumBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.TwistingVinesFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomPatchConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BYGNylium extends NyliumBlock {

    public static final List<Block> BYG_NETHER_SURFACE_BLOCKS = new ArrayList<>();
    public static final List<Block> BYG_END_SURFACE_BLOCKS = new ArrayList<>();

    private final RandomPatchConfiguration featureConfig;
    private final ResourceKey<Level> worldRegistryKey;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, RandomPatchConfiguration featureConfig, ResourceKey<Level> worldRegistryKey, Block dirtBlock) {
        super(properties);
        this.featureConfig = featureConfig;
        this.worldRegistryKey = worldRegistryKey;
        this.dirtBlock = dirtBlock;

        if (worldRegistryKey == Level.NETHER) {
            BYG_NETHER_SURFACE_BLOCKS.add(this);
        }

        if (worldRegistryKey == Level.END) {
            BYG_END_SURFACE_BLOCKS.add(this);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        if (this.worldRegistryKey == Level.NETHER) {
            if (!NyliumBlockAccess.invokeCanBeNylium(state, world, pos)) {
                world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            }
        }

        if (this.worldRegistryKey == Level.END) {
            if (world.getBlockState(pos.above()).canOcclude()) {
                world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            }
        }
    }

    @Override
    public void performBonemeal(ServerLevel world, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = world.getBlockState(pos);
        BlockPos blockpos = pos.above();
        if (blockstate.is(this)) {
            BYGGrassBlock.place(world, rand, blockpos, featureConfig);
        }

        if (this.worldRegistryKey == Level.NETHER) {
            if (rand.nextInt(8) == 0) {
                TwistingVinesFeature.place(world, rand, blockpos, 3, 1, 2);
            }
        }
    }
}
