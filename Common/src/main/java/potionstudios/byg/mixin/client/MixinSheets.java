package potionstudios.byg.mixin.client;

import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.world.level.block.state.properties.WoodType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

@Mixin(Sheets.class)
public abstract class MixinSheets {


    @Shadow
    private static Material createSignMaterial(WoodType woodType) {
        throw new Error("Mixin did not apply!");
    }

    @Shadow
    private static Material createHangingSignMaterial(WoodType woodType) {
        throw new Error("Mixin did not apply!");
    }

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void emergencyCreateSignMaterials(CallbackInfo ci) {
        boolean missingWoodTypeMaterial = false;
        for (BYGWoodTypes value : BYGWoodTypes.values()) {
            WoodType woodType = value.woodType();
            if (woodType != null) {
                if (!Sheets.SIGN_MATERIALS.containsKey(woodType)) {
                    missingWoodTypeMaterial = true;
                    Sheets.SIGN_MATERIALS.put(woodType, createSignMaterial(woodType));
                    BYG.logWarning("BYG WoodType \"%s\" was not in `Sheets.SIGN_MATERIALS`, registering it now in Sheets static initializer...".formatted(woodType.name()));
                }
                if (!Sheets.HANGING_SIGN_MATERIALS.containsKey(woodType)) {
                    missingWoodTypeMaterial = true;
                    Sheets.HANGING_SIGN_MATERIALS.put(woodType, createHangingSignMaterial(woodType));
                    BYG.logWarning("BYG WoodType \"%s\" was not in `Sheets.HANGING_SIGN_MATERIALS`, registering it now in Sheets static initializer...".formatted(woodType.name()));
                }
            }
        }

        if (missingWoodTypeMaterial)
            new Throwable("BYG: Sheets Class loaded early. View stacktrace to see culprit mod and report it...").printStackTrace();
    }
}
