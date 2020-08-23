package voronoiaoc.byg.common.world.feature.features.nether.crimsongardens;

import com.mojang.serialization.Codec;
import net.minecraft.block.Blocks;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallCrimsonRoots extends Feature<NoFeatureConfig> {
    public TallCrimsonRoots(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public static final EnumProperty<DoubleBlockHalf> HALF;

    public boolean func_241855_a(ISeedReader worldIn,  ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (!worldIn.isAirBlock(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.OVERGROWN_CRIMSON_BLACKSTONE || worldIn.getBlockState(pos.down()).getBlock() != Blocks.CRIMSON_NYLIUM) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.TALL_CRIMSON_ROOTS.getDefaultState(), 10);
            worldIn.setBlockState(pos.offset(Direction.UP), BYGBlockList.TALL_CRIMSON_ROOTS.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 10);
            return true;
        }
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    }
}