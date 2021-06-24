package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import corgiaoc.byg.core.BYGBlocks;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.tags.BlockTags;
import net.minecraft.tileentity.BeehiveTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;

public class BeeHiveFeature extends Feature<NoFeatureConfig> {
    public BeeHiveFeature(Codec<NoFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean place(ISeedReader world, ChunkGenerator generator, Random rand, BlockPos pos, NoFeatureConfig config) {
        if (world.isEmptyBlock(pos) && world.isEmptyBlock(pos.below())){
            if (world.getBlockState(pos.above()).is(BlockTags.LEAVES) || world.getBlockState(pos.above()).is(BlockTags.LOGS) || world.getBlockState(pos.above()).is(BYGBlocks.EMBUR_GEL_BLOCK)) {
                Direction direction;

                if (world.isEmptyBlock(pos.north()))
                    direction = Direction.NORTH;
                else if (world.isEmptyBlock(pos.south()))
                    direction = Direction.SOUTH;
                else if (world.isEmptyBlock(pos.west()))
                    direction = Direction.WEST;
                else
                    direction = Direction.EAST;

                BlockState beeHiveState = Blocks.BEE_NEST.defaultBlockState().setValue(BeehiveBlock.FACING, direction);

                world.setBlock(pos, beeHiveState, 2);
                TileEntity tileEntity = world.getBlockEntity(pos);

                if (tileEntity instanceof BeehiveTileEntity) {
                    BeehiveTileEntity beehiveTileEntity = (BeehiveTileEntity) tileEntity;
                    int beeCount = rand.nextInt(4);

                    for (int bee = 0; bee <= beeCount; bee++) {
                        BeeEntity beeEntity = new BeeEntity(EntityType.BEE, world.getLevel());
                        beehiveTileEntity.addOccupantWithPresetTicks(beeEntity, false, rand.nextInt(599));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
