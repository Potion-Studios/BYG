package corgiaoc.byg.common.world.feature.nether.wailinggarth;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.MLBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class WailingVine extends Feature<NoFeatureConfig> {
    public WailingVine(Codec<NoFeatureConfig> config) {
        super(config);
    }

    //place
    public boolean place(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);
        BlockState storedState = BYGBlocks.WAILING_VINES.defaultBlockState();

        for (int i = 0; i < 128; ++i)
            if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.above()).is(MLBlockTags.NETHERRACK)) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());
                if (worldIn.isEmptyBlock(mutable)) {
                    for (Direction direction : Direction.values()) {
                        if (direction != Direction.DOWN && VineBlock.isAcceptableNeighbour(worldIn, mutable, direction)) {
                            worldIn.setBlock(mutable, storedState.setValue(VineBlock.getPropertyForFace(direction), Boolean.valueOf(true)), 2);
                            break;
                            }
                        }
                    }
                    mainMutable.move(Direction.DOWN);
                }
            }
            return true;
        }
    }
