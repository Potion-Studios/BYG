package corgiaoc.byg.mixin.access;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.level.levelgen.StructureSettings;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.levelgen.feature.configurations.StructureFeatureConfiguration;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(StructureSettings.class)
public interface DimensionStructuresSettingsAccess {

    @Accessor("DEFAULTS")
    static void setDefaults(ImmutableMap<StructureFeature<?>, StructureFeatureConfiguration> newMap) {
        throw new Error("Mixin did not apply!");
    }
}
