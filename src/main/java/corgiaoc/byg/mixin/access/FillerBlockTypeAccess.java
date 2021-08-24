package corgiaoc.byg.mixin.access;

import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(OreConfiguration.Predicates.class)
public interface FillerBlockTypeAccess {

    @Accessor("NETHERRACK")
    static void setNetherFillerType(RuleTest ruleTest) {
        throw new Error("Mixin did not apply");
    };
}
