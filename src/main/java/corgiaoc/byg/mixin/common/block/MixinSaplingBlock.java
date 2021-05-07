package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.common.properties.blocks.vanilla.ITreeSpawner;
import corgiaoc.byg.common.world.feature.overworld.trees.util.TreeSpawner;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Optional;
import java.util.Random;

@SuppressWarnings("OptionalUsedAsFieldOrParameterType")
@Mixin(SaplingBlock.class)
public class MixinSaplingBlock implements ITreeSpawner {

    private Optional<TreeSpawner> treeSpawnerOptional = Optional.empty();

    @Inject(method = "advanceTree", at = @At(value = "INVOKE", target = "Lnet/minecraft/block/trees/Tree;growTree(Lnet/minecraft/world/server/ServerWorld;Lnet/minecraft/world/gen/ChunkGenerator;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;Ljava/util/Random;)Z"), cancellable = true)
    private void growBYGTree(ServerWorld world, BlockPos pos, BlockState state, Random random, CallbackInfo ci) {
        if (treeSpawnerOptional.isPresent()) {
            if(random.nextInt(4) == 0 && treeSpawnerOptional.get().spawn(world, world.getChunkSource().getGenerator(), pos, state, random)) {
                ci.cancel();
            }
        }
    }

    @Override
    public void setTreeSpawner(TreeSpawner treeSpawner) {
        this.treeSpawnerOptional = Optional.of(treeSpawner);
    }
}
