package voronoiaoc.byg.common.world.feature.features.nether.whalinggarth;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Dynamic;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;
import java.util.function.Function;

public class WhalingVine extends Feature<NoFeatureConfig> {
    public WhalingVine(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);

        for (Direction direction : Direction.Plane.HORIZONTAL) {

            if (!worldIn.isAirBlock(pos)) {
                return false;
            } else if (!worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) || !worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.STONE) && !worldIn.func_230315_m_().func_236040_e_()) {
                return false;
            } else {
                for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY() - WeepingRootPlantLength, pos.getZ());
                    if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR)
                        worldIn.setBlockState(mainMutable.move(Direction.DOWN), BYGBlockList.WHALING_VINES.getDefaultState().with(VineBlock.getPropertyFor(direction.getOpposite()), Boolean.valueOf(true)), 2);

                }
                return true;
            }
        }
        return true;
    }
}
