package potionstudios.byg.common.world.feature.gen.nether.wailinggarth;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.VineBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.util.MLBlockTags;

import java.util.Random;

public class WailingVine extends Feature<NoneFeatureConfiguration> {
    public WailingVine(Codec<NoneFeatureConfiguration> config) {
        super(config);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    //place
    public boolean place(WorldGenLevel worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.MutableBlockPos block = new BlockPos.MutableBlockPos().set(blockPos);
        BlockPos.MutableBlockPos mainMutable = new BlockPos.MutableBlockPos().set(block);
        BlockState storedState = BYGBlocks.WAILING_VINES.defaultBlockState();

        for (int i = 0; i < 128; ++i)
            if (!worldIn.isEmptyBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.above()).is(MLBlockTags.NETHERRACK)) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos(pos.getX(), pos.getY(), pos.getZ());
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
