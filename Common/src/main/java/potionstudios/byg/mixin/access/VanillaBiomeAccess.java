package potionstudios.byg.mixin.access;

import net.minecraft.data.worldgen.biome.OverworldBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(OverworldBiomes.class)
public interface VanillaBiomeAccess {

    @Invoker
    static int invokeCalculateSkyColor(float f) {
        throw new Error("Mixin did not apply!");
    }
}
