package corgiaoc.byg.common.properties.blocks;

import corgiaoc.byg.mixin.access.NyliumBlockAccess;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.NyliumBlock;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BlockClusterFeatureConfig;
import net.minecraft.world.gen.feature.TwistingVineFeature;
import net.minecraft.world.server.ServerWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BYGNylium extends NyliumBlock {

    public static final List<Block> BYG_NETHER_SURFACE_BLOCKS = new ArrayList<>();
    public static final List<Block> BYG_END_SURFACE_BLOCKS = new ArrayList<>();

    private final BlockClusterFeatureConfig featureConfig;
    private final RegistryKey<World> worldRegistryKey;
    private final Block dirtBlock;

    public BYGNylium(Properties properties, BlockClusterFeatureConfig featureConfig, RegistryKey<World> worldRegistryKey, Block dirtBlock) {
        super(properties);
        this.featureConfig = featureConfig;
        this.worldRegistryKey = worldRegistryKey;
        this.dirtBlock = dirtBlock;

        if (worldRegistryKey == World.NETHER) {
            BYG_NETHER_SURFACE_BLOCKS.add(this);
        }

        if (worldRegistryKey == World.END) {
            BYG_END_SURFACE_BLOCKS.add(this);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.worldRegistryKey == World.NETHER) {
            if (!NyliumBlockAccess.invokeCanBeNylium(state, world, pos)) {
                world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            }
        }

        if (this.worldRegistryKey == World.END) {
            if (world.getBlockState(pos.above()).canOcclude()) {
                world.setBlockAndUpdate(pos, this.dirtBlock.defaultBlockState());
            }
        }
    }

    @Override
    public void performBonemeal(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        BlockState blockstate = world.getBlockState(pos);
        BlockPos blockpos = pos.above();
        if (blockstate.is(this)) {
            BYGGrassBlock.place(world, rand, blockpos, featureConfig);
        }

        if (this.worldRegistryKey == World.NETHER) {
            if (rand.nextInt(8) == 0) {
                TwistingVineFeature.place(world, rand, blockpos, 3, 1, 2);
            }
        }
    }
}
