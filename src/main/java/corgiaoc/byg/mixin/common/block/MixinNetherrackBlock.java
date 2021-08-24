package corgiaoc.byg.mixin.common.block;

import corgiaoc.byg.common.properties.blocks.BYGNylium;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.NetherrackBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Iterator;
import java.util.Random;

@Mixin(NetherrackBlock.class)
public class MixinNetherrackBlock {


    @Inject(method = "performBonemeal", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/world/level/block/Block;)Z", shift = At.Shift.BEFORE), locals = LocalCapture.CAPTURE_FAILHARD)
    private void handleBYGGrowables(ServerLevel world, Random random, BlockPos pos, BlockState state, CallbackInfo ci, boolean flag, boolean flag1, Iterator<BlockPos> var7, BlockPos blockpos, BlockState state2) {
        if (BYGNylium.BYG_NETHER_SURFACE_BLOCKS.contains(state2.getBlock())) {
            if (world.getBlockState(pos).getBlock() != state2.getBlock()) {
                world.setBlock(pos, state2.getBlock().defaultBlockState(), 2);
            }
        }
    }
}
