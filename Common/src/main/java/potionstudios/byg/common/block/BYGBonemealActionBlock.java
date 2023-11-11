package potionstudios.byg.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.TallGrassBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class BYGBonemealActionBlock extends TallGrassBlock implements BonemealableBlock {

    private final TagKey<Block> mayPlaceOn;
    private final BonemealAction bonemealAction;

    protected BYGBonemealActionBlock(Properties properties, TagKey<Block> mayPlaceOn, BonemealAction bonemealAction) {
        super(properties);
        this.mayPlaceOn = mayPlaceOn;
        this.bonemealAction = bonemealAction;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, @NotNull BlockGetter worldIn, @NotNull BlockPos pos) {
        return state.is(this.mayPlaceOn);
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel level, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        this.bonemealAction.perform(level, random, pos, state);
    }

    @FunctionalInterface
    interface BonemealAction {
        void perform(ServerLevel level, RandomSource random, BlockPos pos, BlockState state);

        static BonemealAction growDoublePlant(Supplier<DoublePlantBlock> doublePlantBlockSupplier) {
            return (level, random, pos, state) -> {
                DoublePlantBlock doublePlantBlock = doublePlantBlockSupplier.get();
                if (doublePlantBlock.defaultBlockState().canSurvive(level, pos) && level.isEmptyBlock(pos.above())) {
                    DoublePlantBlock.placeAt(level, doublePlantBlock.defaultBlockState(), pos, 2);
                }
            };
        }
    }
}
