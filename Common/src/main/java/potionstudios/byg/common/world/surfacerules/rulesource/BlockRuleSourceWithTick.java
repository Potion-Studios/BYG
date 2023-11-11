package potionstudios.byg.common.world.surfacerules.rulesource;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.KeyDispatchDataCodec;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.ticks.ScheduledTick;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.mixin.access.ChunkAccessAccess;
import potionstudios.byg.mixin.access.SurfaceRuleContextAccess;
import potionstudios.byg.mixin.access.SurfaceRulesStateRuleAccess;

public record BlockRuleSourceWithTick(BlockState state, int tickDelay,
                                      SurfaceRules.StateRule rule) implements SurfaceRules.RuleSource {
    public static final KeyDispatchDataCodec<BlockRuleSourceWithTick> CODEC = KeyDispatchDataCodec.of(RecordCodecBuilder.mapCodec(builder ->
            builder.group(BlockState.CODEC.fieldOf("result_state").forGetter(BlockRuleSourceWithTick::state),
                    Codec.INT.fieldOf("tick_delay").orElse(0).forGetter(BlockRuleSourceWithTick::tickDelay)
            ).apply(builder, BlockRuleSourceWithTick::new)));


    BlockRuleSourceWithTick(BlockState blockState, int tickDelay) {
        this(blockState, tickDelay, SurfaceRulesStateRuleAccess.byg_create(blockState));
    }

    @Override
    public @NotNull KeyDispatchDataCodec<? extends SurfaceRules.RuleSource> codec() {
        return CODEC;
    }

    @Override
    public SurfaceRules.SurfaceRule apply(SurfaceRules.Context context) {
        ChunkAccess chunkAccess = ((SurfaceRuleContextAccess) (Object) context).byg_getChunk();
        return (x, y, z) -> {
            BlockState blockState = rule.tryApply(x, y, z);
            // Schedule Block Ticks
            LevelHeightAccessor heightAccessor = ((ChunkAccessAccess) chunkAccess).byg_getLevelHeightAccessor();
            if (!(heightAccessor instanceof LevelAccessor levelAccessor)) {
                throw new IllegalStateException("99% sure a mod is doing something cursed and constructing a chunk access without a server level(or some impl of LevelAccessor) and we can't tick our block due to the lack of level data context here.");
            }

            BlockPos blockPos = new BlockPos(x, y, z);
            ScheduledTick<Block> scheduledTick = new ScheduledTick<>(blockState.getBlock(), blockPos, levelAccessor.getLevelData().getGameTime() + this.tickDelay, levelAccessor.nextSubTickCount());
            chunkAccess.getBlockTicks().schedule(scheduledTick);

            // Schedule Fluid Ticks
            FluidState fluidState = blockState.getFluidState();
            if (!fluidState.isEmpty()) {
                ScheduledTick<Fluid> scheduledFluidTick = new ScheduledTick<>(fluidState.getType(), blockPos, levelAccessor.getLevelData().getGameTime() + this.tickDelay, levelAccessor.nextSubTickCount());
                chunkAccess.getFluidTicks().schedule(scheduledFluidTick);
            }
            return blockState;
        };
    }
}