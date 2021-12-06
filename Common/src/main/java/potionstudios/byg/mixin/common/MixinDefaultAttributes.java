package potionstudios.byg.mixin.common;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.IdentityHashMap;
import java.util.Map;

@Mixin(DefaultAttributes.class)
public class MixinDefaultAttributes {

    @Mutable
    @Shadow @Final private static Map<EntityType<? extends LivingEntity>, AttributeSupplier> SUPPLIERS;

    @Inject(method = "<clinit>", at = @At("RETURN"))
    private static void byg_AddAttributes(CallbackInfo ci) {
        final IdentityHashMap<EntityType<? extends LivingEntity>, AttributeSupplier> suppliers = new IdentityHashMap<>(SUPPLIERS);
        //TODO: Geckolib Mojmap 1.18
//        suppliers.put(BYGEntities.MAN_O_WAR, ManOWar.createAttributes().build());
        SUPPLIERS = suppliers;
    }
}
