package corgiaoc.byg.common.world.feature.overworld;

import com.mojang.serialization.Codec;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BeehiveBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import java.util.Random;

public class BeeHiveFeature extends Feature<DefaultFeatureConfig> {
    public BeeHiveFeature(Codec<DefaultFeatureConfig> codec) {
        super(codec);
    }

    @Override
    public boolean generate(StructureWorldAccess world, ChunkGenerator generator, Random rand, BlockPos pos, DefaultFeatureConfig config) {
        if (world.isAir(pos) && world.isAir(pos.down())){
            if (world.getBlockState(pos.up()).isIn(BlockTags.LEAVES) || world.getBlockState(pos.up()).isIn(BlockTags.LOGS)) {
                Direction direction;

                if (world.isAir(pos.north()))
                    direction = Direction.NORTH;
                else if (world.isAir(pos.south()))
                    direction = Direction.SOUTH;
                else if (world.isAir(pos.west()))
                    direction = Direction.WEST;
                else
                    direction = Direction.EAST;

                BlockState beeHiveState = Blocks.BEE_NEST.getDefaultState().with(BeehiveBlock.FACING, direction);

                world.setBlockState(pos, beeHiveState, 2);
                BlockEntity tileEntity = world.getBlockEntity(pos);

                if (tileEntity instanceof BeehiveBlockEntity) {
                    BeehiveBlockEntity beehiveTileEntity = (BeehiveBlockEntity) tileEntity;
                    int beeCount = rand.nextInt(4);

                    for (int bee = 0; bee <= beeCount; bee++) {
                        BeeEntity beeEntity = new BeeEntity(EntityType.BEE, world.toServerWorld());
                        beehiveTileEntity.tryEnterHive(beeEntity, false, rand.nextInt(599));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
