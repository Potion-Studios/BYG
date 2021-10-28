package corgiaoc.byg.mixin.access;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.structure.Structure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;
import java.util.Map;

@Mixin(Structure.class)
public interface StructureAccess {

    @Accessor("STEP")
    static Map<Structure<?>, GenerationStage.Decoration> getStructureStep() {
        throw new Error("Mixin did not apply!");
    }

    @Mutable
    @Accessor("NOISE_AFFECTING_FEATURES")
    static void setNOISE_AFFECTING_FEATURES(List<Structure<?>> NOISE_AFFECTING_FEATURES) {
        throw new UnsupportedOperationException();
    }
}
