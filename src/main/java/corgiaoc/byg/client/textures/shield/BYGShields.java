//package sporeaoc.sporeaoc.byg.client.textures.shield;
//
//import com.mojang.blaze3d.platform.GlStateManager;
//import net.minecraft.client.Minecraft;
//import net.minecraft.client.renderer.BannerTextures;
//import net.minecraft.client.renderer.ItemRenderer;
//import net.minecraft.client.renderer.entity.model.ShieldModel;
//import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemStack;
//import net.minecraft.item.ShieldItem;
//import net.minecraft.tileentity.BannerTileEntity;
//import net.minecraft.util.ResourceLocation;
//import sporeaoc.sporeaoc.byg.catalogs.BYGItems;
//
//public class BYGShields {
//    public static class BYGShieldResourceLocations extends BannerTextures {
//        public static final ResourceLocation AMETHRINE_BLUE_SHIELD_BASE_TEXTURE = new ResourceLocation("assets/sporeaoc.byg/textures/shield/shield_base_ametrine_blue_enchanted_log_nopattern.png");
//    }
//
//    public static class BYGShieldEntityRenderer extends ItemStackTileEntityRenderer {
//        public final BannerTileEntity banner = new BannerTileEntity();
//        private final ShieldModel modelShield = new ShieldModel();
//
//        @Overrider
//        public void renderByItem(ItemStack itemStack) {
//            Item item = itemStack.getItem();
//            if (item == BYGItems.AMETRINE_SHIELD) {
//                if (itemStack.getChildTag("BlockEntityTag") != null) {
//                    this.banner.loadFromItemStack(itemStack, ShieldItem.getColor(itemStack));
//                    Minecraft.getInstance().getTextureManager().bindTexture(BannerTextures.SHIELD_DESIGNS.getResourceLocation(this.banner.getPatternResourceLocation(), this.banner.getPatternList(), this.banner.getColorList()));
//                } else {
//                    Minecraft.getInstance().getTextureManager().bindTexture(BYGShieldResourceLocations.AMETHRINE_BLUE_SHIELD_BASE_TEXTURE);
//                }
//                GlStateManager.pushMatrix();
//                GlStateManager.scalef(1.0F, -1.0F, -1.0F);
//                this.modelShield.render();
//                if (itemStack.hasEffect()) {
//                    this.renderEffect(this.modelShield::render);
//                }
//            }
//        }
//
//        public void renderEffect(Runnable renderModelFunction) {
//            GlStateManager.color3f(0.5019608F, 0.2509804F, 0.8F);
//            Minecraft.getInstance().getTextureManager().bindTexture(ItemRenderer.RES_ITEM_GLINT);
//            ItemRenderer.renderEffect(Minecraft.getInstance().getTextureManager(), renderModelFunction, 1);
//        }
//    }
//}
