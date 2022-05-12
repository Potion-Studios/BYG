package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;
import java.util.function.Supplier;

public class GrassGrowsIntoDoublePlantBlockBlock extends TallGrassBlock implements BonemealableBlock {

    private final TagKey<Block> mayPlaceOn;
    private final Supplier<? extends DoublePlantBlock> doublePlantBlock;

    protected GrassGrowsIntoDoublePlantBlockBlock(Properties properties, TagKey<Block> mayPlaceOn, Supplier<? extends DoublePlantBlock> doublePlantBlock) {
        super(properties);
        this.mayPlaceOn = mayPlaceOn;
        this.doublePlantBlock = doublePlantBlock;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
       return state.is(this.mayPlaceOn);
    }

    @Override
    public void performBonemeal(ServerLevel level, Random random, BlockPos pos, BlockState state) {
        DoublePlantBlock doublePlantBlock = this.doublePlantBlock.get();
        if (doublePlantBlock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
            DoublePlantBlock.placeAt(level, doublePlantBlock.defaultBlockState(), pos, 2);
        }
    }
}
