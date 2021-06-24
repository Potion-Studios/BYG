package corgiaoc.byg.common.world.feature.nether.wailinggarth;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import corgiaoc.byg.util.FabricTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.VineBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.util.FeatureContext;

import java.util.Random;

public class WailingVine extends Feature<DefaultFeatureConfig> {
    public WailingVine(Codec<DefaultFeatureConfig> config) {
        super(config);
    }

    //place
    @Override
    public boolean generate(FeatureContext<DefaultFeatureConfig> context) {
        StructureWorldAccess worldIn = context.getWorld();
        BlockPos pos = context.getOrigin();
        Random rand = context.getRandom();
        DefaultFeatureConfig config = context.getConfig();

        int randLength = rand.nextInt(17) + 3;
        BlockPos blockPos = new BlockPos(pos.getX(), pos.getY(), pos.getZ());
        BlockPos.Mutable block = new BlockPos.Mutable().set(blockPos);
        BlockPos.Mutable mainMutable = new BlockPos.Mutable().set(block);
        BlockState storedState = BYGBlocks.WAILING_VINES.getDefaultState();

        for (int i = 0; i < 128; ++i)
            if (!worldIn.isAir(pos)) {
                return false;
            } else if (!worldIn.getBlockState(pos.up()).isIn(FabricTags.NETHERRACK) && !(worldIn.getDimension() == DimensionType.THE_NETHER)) {
                return false;
            } else {
                for (int WeepingRootPlantLength = 0; WeepingRootPlantLength <= randLength; WeepingRootPlantLength++) {
                    BlockPos.Mutable mutable = new BlockPos.Mutable(pos.getX(), pos.getY(), pos.getZ());
                    if (worldIn.isAir(mutable)) {
                        for (Direction direction : Direction.values()) {
                            if (direction != Direction.DOWN && VineBlock.shouldConnectTo(worldIn, mutable, direction)) {
                                worldIn.setBlockState(mutable, storedState.with(VineBlock.getFacingProperty(direction), Boolean.valueOf(true)), 2);
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
