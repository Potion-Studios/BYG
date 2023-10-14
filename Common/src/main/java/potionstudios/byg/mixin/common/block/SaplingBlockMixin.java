package potionstudios.byg.mixin.common.block;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.block.sapling.BYGSaplingBlock;
import potionstudios.byg.common.block.sapling.GrowingPatterns;
import potionstudios.byg.util.FeatureGrowerFromBlockPattern;
import potionstudios.byg.util.ModPlatform;

import java.util.List;

@Mixin(SaplingBlock.class)
public class SaplingBlockMixin implements FeatureGrowerFromBlockPattern {
    @Shadow @Final public static IntegerProperty STAGE;
    @Unique
    private ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> byg$patterns = ImmutableList.of();

    @Inject(method = "<init>", at = @At("TAIL"))
    private void onInitTailInjector(AbstractTreeGrower $$0, BlockBehaviour.Properties $$1, CallbackInfo ci) {
        ENTRIES.add(() -> this);
    }

    @Inject(method = "advanceTree", at = @At("HEAD"), cancellable = true)
    private void onAdvanceTreeHeadInjector(ServerLevel level, BlockPos pos, BlockState state, RandomSource random, CallbackInfo ci) {
        if (!(((Object)this) instanceof BYGSaplingBlock)) {
            if (state.getValue(STAGE) == 0) {
                level.setBlock(pos, state.cycle(STAGE), 4);
            } else {
                if (!ModPlatform.INSTANCE.canTreeGrowWithEvent(level, random, pos)) {
                    ci.cancel();
                    return;
                }
                if (this.growFeature((SaplingBlock)((Object)this), level, pos, random)) {
                    ci.cancel();
                }
            }
        }
    }

    @Override
    public ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> byg_getPatterns() {
        return byg$patterns;
    }

    @Override
    public void byg_setPatterns(ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> map) {
        this.byg$patterns = map;
    }
}
