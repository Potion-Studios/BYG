package potionstudios.byg.common.world.feature.gen.overworld.trees.decorators;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AttachedToLogsDecorator extends TreeDecorator {
    public static final Codec<AttachedToLogsDecorator> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.floatRange(0.0F, 1.0F).fieldOf("probability").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.probability),
                    Codec.intRange(0, 16).fieldOf("exclusion_radius_xz").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.exclusionRadiusXZ),
                    Codec.intRange(0, 16).fieldOf("exclusion_radius_y").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.exclusionRadiusY),
                    BlockStateProvider.CODEC.fieldOf("block_provider").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.blockProvider),
                    Codec.intRange(1, 16).fieldOf("required_empty_blocks").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.requiredEmptyBlocks),
                    ExtraCodecs.nonEmptyList(Direction.CODEC.listOf()).fieldOf("directions").forGetter(attachedToLogsDecorator -> attachedToLogsDecorator.directions)
            ).apply(builder, AttachedToLogsDecorator::new)
    );

    protected final float probability;
    protected final int exclusionRadiusXZ;
    protected final int exclusionRadiusY;
    protected final BlockStateProvider blockProvider;
    protected final int requiredEmptyBlocks;
    protected final List<Direction> directions;

    public AttachedToLogsDecorator(float probability, int exclusionRadiusXZ, int exclusionRadiusY, BlockStateProvider blockProvider, int requiredEmptyBlocks, List<Direction> directions) {
        this.probability = probability;
        this.exclusionRadiusXZ = exclusionRadiusXZ;
        this.exclusionRadiusY = exclusionRadiusY;
        this.blockProvider = blockProvider;
        this.requiredEmptyBlocks = requiredEmptyBlocks;
        this.directions = directions;
    }

    public void place(TreeDecorator.Context pContext) {
        Set<BlockPos> set = new HashSet<>();
        RandomSource randomsource = pContext.random();

        for (BlockPos blockpos : Util.shuffledCopy(pContext.logs(), randomsource)) {
            Direction direction = Util.getRandom(this.directions, randomsource);
            BlockPos relative = blockpos.relative(direction);
            if (!set.contains(relative) && randomsource.nextFloat() < this.probability && this.hasRequiredEmptyBlocks(pContext, blockpos, direction)) {
                BlockPos offsetMin = relative.offset(-this.exclusionRadiusXZ, -this.exclusionRadiusY, -this.exclusionRadiusXZ);
                BlockPos offsetMax = relative.offset(this.exclusionRadiusXZ, this.exclusionRadiusY, this.exclusionRadiusXZ);

                for (BlockPos blockpos4 : BlockPos.betweenClosed(offsetMin, offsetMax)) {
                    set.add(blockpos4.immutable());
                }

                BlockState state = this.blockProvider.getState(randomsource, relative);

                if (state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) {
                    state = state.setValue(BlockStateProperties.HORIZONTAL_FACING, direction);
                }
                pContext.setBlock(relative, state);
            }
        }

    }

    private boolean hasRequiredEmptyBlocks(TreeDecorator.Context pContext, BlockPos pPos, Direction pDirection) {
        for (int i = 1; i <= this.requiredEmptyBlocks; ++i) {
            BlockPos blockpos = pPos.relative(pDirection, i);
            if (!pContext.isAir(blockpos)) {
                return false;
            }
        }

        return true;
    }

    protected TreeDecoratorType<?> type() {
        return BYGTreeDecoratorTypes.ATTACHED_TO_LOGS.get();
    }
}