package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class TallEmburRoots extends Feature<NoneFeatureConfiguration> {
    public TallEmburRoots(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    public static final EnumProperty<DoubleBlockHalf> HALF;

    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random random, BlockPos pos, NoneFeatureConfiguration config) {
        if (!worldIn.isEmptyBlock(pos) || worldIn.getBlockState(pos.below()).getBlock() != BYGBlockList.EMBUR_NYLIUM) {
            return false;
        } else {
            worldIn.setBlock(pos, BYGBlockList.TALL_EMBUR_ROOTS.defaultBlockState(), 10);
            worldIn.setBlock(pos.relative(Direction.UP), BYGBlockList.TALL_EMBUR_ROOTS.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER), 10);
            return true;
        }
    }

    static {
        HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;
    }
}