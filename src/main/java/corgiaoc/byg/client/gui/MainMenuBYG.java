//package voronoiaoc.byg.client.gui;
//
//import net.minecraft.client.gui.screen.MainMenuScreen;
//import net.minecraft.client.renderer.RenderSkyboxCube;
//import net.minecraft.util.ResourceLocation;
//import voronoiaoc.byg.BYG;
//import voronoiaoc.byg.config.BYGConfig;
//
//public class MainMenuBYG {
//    public static void mainMenuPanorama() {
//        if (BYGConfig.mainMenuPanorama.get()) {
//            BYG.LOGGER.debug("BYG: Replacing Panorama...");
//            MainMenuScreen.PANORAMA_OVERLAY_TEXTURES = new ResourceLocation("byg:textures/gui/title/background/panorama_overlay.png");
//            MainMenuScreen.PANORAMA_RESOURCES = new RenderSkyboxCube(new ResourceLocation("byg:textures/gui/title/background/panorama"));
//            BYG.LOGGER.debug("BYG: Panorama Replaced!");
//        }
//    }
//}
