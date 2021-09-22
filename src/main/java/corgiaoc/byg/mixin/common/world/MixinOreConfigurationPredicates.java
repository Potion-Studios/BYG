package corgiaoc.byg.mixin.common.world;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//TODO: Is this right?!
@Mixin(OreConfiguration.Predicates.class)
public class MixinOreConfigurationPredicates {

    @Mutable
    @Shadow
    @Final
    public static RuleTest NETHERRACK;

    @SuppressWarnings("UnresolvedMixinReference")
    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void useBASE_STONE_NETHERtag(CallbackInfo ci) {
        NETHERRACK = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
    }
}
