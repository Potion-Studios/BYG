package corgiaoc.byg.mixin.access;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(DimensionStructuresSettings.class)
public interface DimensionStructuresSettingsAccess {

    @Accessor("DEFAULTS")
    static void setDefaults(ImmutableMap<Structure<?>, StructureSeparationSettings> newMap) {
        throw new Error("Mixin did not apply!");
    }
}
