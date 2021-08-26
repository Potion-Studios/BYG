package corgiaoc.byg.mixin.access;

import net.minecraft.data.worldgen.biome.VanillaBiomes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(VanillaBiomes.class)
public interface VanillaBiomeAccess {

    @Invoker
    static int invokeCalculateSkyColor(float f) {
        throw new Error("Mixin did not apply!");
    }
}
