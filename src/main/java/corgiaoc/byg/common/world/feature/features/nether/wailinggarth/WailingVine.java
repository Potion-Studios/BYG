package corgiaoc.byg.common.world.feature.features.nether.wailinggarth;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.Tags;

import java.util.Random;

public class WailingVine extends Feature<NoFeatureConfig> {
    public WailingVine(Codec<NoFeatureConfig> config) {
        super(config);
    }

    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);
        BlockState storedState = BYGBlocks.WAILING_VINES.getDefaultState();
        if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) || !worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.STONE) && !(worldIn.getDimensionType() == DimensionType.OVERWORLD_TYPE)) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());
                if (worldIn.getBlockState(mutable).getBlock() == Blocks.AIR) {
                    for (Direction direction : Direction.values()) {
                        if (direction != Direction.DOWN) {
                            if (worldIn.getBlockState(pos).isOpaqueCube(worldIn, pos.offset(direction))) {
                                storedState = storedState.with(VineBlock.getPropertyFor(direction.getOpposite()), true);
                            }
                        }
                    }

                    worldIn.setBlockState(mainMutable, storedState, 2);
                    mainMutable.move(Direction.DOWN);
                }

            }
            return true;
        }
    }
}
