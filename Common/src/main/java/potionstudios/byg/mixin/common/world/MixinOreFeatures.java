package potionstudios.byg.mixin.common.world;

import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.tags.BlockTags;
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
@Mixin(OreFeatures.class)
public class MixinOreFeatures {

    @Mutable
    @Shadow
    @Final
    public static RuleTest NETHERRACK;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void useBASE_STONE_NETHERtag(CallbackInfo ci) {
        NETHERRACK = new TagMatchTest(BlockTags.BASE_STONE_NETHER);
    }
}
