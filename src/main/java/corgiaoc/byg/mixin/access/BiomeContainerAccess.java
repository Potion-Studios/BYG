package corgiaoc.byg.mixin.access;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(BiomeContainer.class)
public interface BiomeContainerAccess {
    @Accessor Biome[] getBiomes();

    @Accessor static int getWIDTH_BITS() {
        throw new Error("Mixin did not apply!");
    }

    @Accessor static int getHORIZONTAL_MASK() {
        throw new Error("Mixin did not apply!");
    }

    @Accessor static int getVERTICAL_MASK() {
        throw new Error("Mixin did not apply!");
    }
}
