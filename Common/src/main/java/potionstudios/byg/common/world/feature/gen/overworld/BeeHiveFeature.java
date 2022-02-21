package potionstudios.byg.common.world.feature.gen.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BeehiveBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import potionstudios.byg.common.block.BYGBlocks;

import java.util.Random;

public class BeeHiveFeature extends Feature<NoneFeatureConfiguration> {
    public BeeHiveFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> featurePlaceContext) {
        return place(featurePlaceContext.level(), featurePlaceContext.chunkGenerator(), featurePlaceContext.random(), featurePlaceContext.origin(), featurePlaceContext.config());
    }

    public boolean place(WorldGenLevel world, ChunkGenerator generator, Random rand, BlockPos pos, NoneFeatureConfiguration config) {
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
                BlockEntity tileEntity = world.getBlockEntity(pos);

                if (tileEntity instanceof BeehiveBlockEntity) {
                    BeehiveBlockEntity beehiveTileEntity = (BeehiveBlockEntity) tileEntity;
                    int beeCount = rand.nextInt(4);

                    for (int bee = 0; bee <= beeCount; bee++) {
                        Bee beeEntity = new Bee(EntityType.BEE, world.getLevel());
                        beehiveTileEntity.addOccupantWithPresetTicks(beeEntity, false, rand.nextInt(599));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
