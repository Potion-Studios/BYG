package corgiaoc.byg.common.world.feature.nether.crimsongardens;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class TallCrimsonRoots extends Feature<NoFeatureConfig> {
    public TallCrimsonRoots(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlocks.OVERGROWN_CRIMSON_BLACKSTONE) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlocks.TALL_CRIMSON_ROOTS.getDefaultState(), 10);
            worldIn.setBlockState(pos.offset(Direction.UP), BYGBlocks.TALL_CRIMSON_ROOTS.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 10);
            return true;
        }

    }
}