package voronoiaoc.byg.common.world.feature.features.nether.emburbog;

import com.mojang.serialization.Codec;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class TallEmburRoots extends Feature<DefaultFeatureConfig> {
    public TallEmburRoots(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    public static final EnumProperty<DoubleBlockHalf> HALF;

    public boolean generate(ServerWorldAccess worldIn, ChunkGenerator generator, Random random, BlockPos pos, DefaultFeatureConfig config) {
        if (!worldIn.isAir(pos) || worldIn.getBlockState(pos.down()).getBlock() != BYGBlockList.EMBUR_NYLIUM) {
            return false;
        } else {
            worldIn.setBlockState(pos, BYGBlockList.TALL_EMBUR_ROOTS.getDefaultState(), 10);
            worldIn.setBlockState(pos.offset(Direction.UP), BYGBlockList.TALL_EMBUR_ROOTS.getDefaultState().with(HALF, DoubleBlockHalf.UPPER), 10);
            return true;
        }
    }

    static {
        HALF = Properties.DOUBLE_BLOCK_HALF;
    }
}