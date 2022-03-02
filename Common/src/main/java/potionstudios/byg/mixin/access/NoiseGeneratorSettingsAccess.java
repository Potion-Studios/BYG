package potionstudios.byg.mixin.access;

import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.SurfaceRules;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.function.Supplier;

@Mixin(NoiseGeneratorSettings.class)
public interface NoiseGeneratorSettingsAccess {

    @Accessor @Mutable
    void setSurfaceRule(SurfaceRules.RuleSource ruleSource);
}
