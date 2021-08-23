package corgiaoc.byg.mixin.access;

import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.template.RuleTest;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(OreFeatureConfig.FillerBlockType.class)
public interface FillerBlockTypeAccess {

    @Accessor("NETHERRACK")
    static void setNetherFillerType(RuleTest ruleTest) {
        throw new Error("Mixin did not apply");
    };
}
