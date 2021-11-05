package corgiaoc.byg.mixin.client;

import com.google.common.collect.ImmutableMap;
import corgiaoc.byg.common.entity.boat.BYGBoatEntity;
import corgiaoc.byg.common.entity.boat.BYGBoatRenderer;
import corgiaoc.byg.common.entity.manowar.ManOWarRenderer;
import net.minecraft.client.model.BoatModel;
import net.minecraft.client.model.geom.LayerDefinitions;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import java.util.Map;

@Mixin(LayerDefinitions.class)
public class MixinLayerDefinitions {


    @Inject(method = "createRoots", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/model/BoatModel;createBodyModel()Lnet/minecraft/client/model/geom/builders/LayerDefinition;"), locals = LocalCapture.CAPTURE_FAILHARD)
    private static void createBYGBoatTypeModelRoots(CallbackInfoReturnable<Map<ModelLayerLocation, LayerDefinition>> cir, ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> builder) {
        for (BYGBoatEntity.BYGType value : BYGBoatEntity.BYGType.values()) {
            builder.put(BYGBoatRenderer.createBoatModelName(value), BoatModel.createBodyModel());
        }
    }
}
