package potionstudios.byg.mixin.common.world.carver;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashBigSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.CarverConfiguration;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.common.BYGCarvableBlocks;

import java.util.Set;

@Mixin(WorldCarver.class)
public class MixinWorldCarver<C extends CarverConfiguration> {


    @Shadow protected Set<Block> replaceableBlocks;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void addBYGCarverBlocks(Codec<C> $$0, CallbackInfo ci) {
        this.replaceableBlocks = new ObjectOpenHashBigSet<>(this.replaceableBlocks);
        this.replaceableBlocks.addAll(BYGCarvableBlocks.addCarverBlocks());
    }
}
