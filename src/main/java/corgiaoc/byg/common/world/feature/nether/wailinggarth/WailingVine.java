package corgiaoc.byg.common.world.feature.nether.wailinggarth;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SixWayBlock;
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

    //place
    public boolean func_241855_a(ISeedReader worldIn, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().setPos(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().setPos(block);
        BlockState storedState = BYGBlocks.WAILING_VINES.getDefaultState();

        for (int i = 0; i < 128; ++i)
            if (!worldIn.isAirBlock(pos)) {
            return false;
        } else if (!worldIn.getBlockState(pos.up()).isIn(Tags.Blocks.NETHERRACK) && !(worldIn.getDimensionType() == DimensionType.NETHER_TYPE)) {
            return false;
        } else {
            for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());
                if (worldIn.isAirBlock(mutable)) {
                    for (Direction direction : Direction.values()) {
                        if (direction != Direction.DOWN && VineBlock.canAttachTo(worldIn, mutable, direction)) {
                            worldIn.setBlockState(mutable, storedState.with(VineBlock.getPropertyFor(direction), Boolean.valueOf(true)), 2);
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
