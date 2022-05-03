package potionstudios.byg.client;

import net.minecraft.client.gui.screens.MenuScreens;
import potionstudios.byg.BYG;
import potionstudios.byg.client.gui.screen.HypogealImperiumScreen;
import potionstudios.byg.common.container.BYGMenuTypes;
import potionstudios.byg.mixin.access.client.MenuScreensAccess;
import potionstudios.byg.util.LangFileGenerator;

import java.nio.file.Paths;

public class BYGClient {

    public static void load() {
        BYG.LOGGER.debug("BYG: \"Client Setup\" Event Starting...");
        BiomepediaClientData.getConfig(true);
        if (BYG.GENERATE_DATA) {
            LangFileGenerator.createLangFile(Paths.get("generated/en_us.json"));
        }

//        EntityRendererRegistry.register(BYGEntities.MAN_O_WAR, ManOWarRenderer::new);
        BYG.LOGGER.info("BYG: \"Client Setup\" Event Complete!");
    }

    public static void threadSafeLoad() {
        MenuScreensAccess.byg_register(BYGMenuTypes.HYPOGEAL_CONTAINER.get(), HypogealImperiumScreen::new);
    }

}
