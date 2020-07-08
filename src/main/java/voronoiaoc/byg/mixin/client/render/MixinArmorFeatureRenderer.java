//package voronoiaoc.byg.mixin.client.render;
//
//import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
//import net.minecraft.item.ArmorItem;
//import net.minecraft.util.Identifier;
//import org.spongepowered.asm.mixin.Final;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.Shadow;
//import org.spongepowered.asm.mixin.injection.At;
//import org.spongepowered.asm.mixin.injection.Inject;
//import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
//import voronoiaoc.byg.BYG;
//import voronoiaoc.byg.common.properties.items.BYGArmorItem;
//
//import java.util.Map;
//
//@Mixin(ArmorFeatureRenderer.class)
//public class MixinArmorFeatureRenderer {
//    @Final
//    @Shadow private static Map<String, Identifier> ARMOR_TEXTURE_CACHE;
//
//    @Inject(at = @At("HEAD"), method = "getArmorTexture(Lnet/minecraft/item/ArmorItem;ZLjava/lang/String;)Lnet/minecraft/util/Identifier;", cancellable = true)
//    private void addBYGArmor(ArmorItem armorItem, boolean bl, String string, CallbackInfoReturnable<Identifier> cir) {
//        if (armorItem instanceof BYGArmorItem) {
//            String string3 = BYG.MODID + ":textures/models/armor/" + ((BYGArmorItem)armorItem).getBYGArmorMaterial().getBYGName() + "_layer_" + (bl ? 2 : 1) + (string == null ? "" : "_" + string) + ".png";
//            cir.setReturnValue(ARMOR_TEXTURE_CACHE.computeIfAbsent(string3, Identifier::new));
//        }
//    }
//}
