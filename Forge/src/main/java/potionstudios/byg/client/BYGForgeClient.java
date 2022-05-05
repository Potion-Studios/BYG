package potionstudios.byg.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.TextComponent;
import net.minecraftforge.fml.config.ConfigTracker;
import net.minecraftforge.fml.config.IConfigEvent;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;
import potionstudios.byg.client.config.filebrowser.FileBrowserScreen;
import potionstudios.byg.client.gui.screen.HypogealImperiumScreen;
import potionstudios.byg.common.container.BYGMenuTypes;

import java.io.File;
import java.nio.file.Path;
import java.util.function.BiPredicate;

public class BYGForgeClient {
    private static final BiPredicate<Path, ModConfig> FILTER = (relativized, modConfig) -> {
        String regex = "[\\\\|/]";
        return modConfig.getFileName().replaceAll(regex, File.pathSeparator).equals(relativized.toString().replaceAll(regex, File.pathSeparator));
    };

    public static void client() {
        FileBrowserScreen.ON_RELOAD = path -> {
            Path configDir = FMLPaths.CONFIGDIR.get();
            Path relativized = configDir.relativize(path);

            ToastComponent toasts = Minecraft.getInstance().getToasts();
            ConfigTracker.INSTANCE.fileMap().values().stream().filter(modConfig -> FILTER.test(relativized, modConfig)).findAny()
                .ifPresentOrElse(
                    modConfig -> {
                        try {
                            IConfigEvent.reloading(modConfig);
                            toasts.addToast(SystemToast.multiline(Minecraft.getInstance(),
                                SystemToast.SystemToastIds.PACK_LOAD_FAILURE,
                                new TextComponent(String.format("Reloaded %s Config File: ", modConfig.getType().toString())),
                                new TextComponent(relativized.toString()))
                            );
                        } catch (Exception e) {
                            toasts.addToast(SystemToast.multiline(Minecraft.getInstance(),
                                SystemToast.SystemToastIds.PACK_LOAD_FAILURE,
                                new TextComponent(String.format("Reloaded %s Config File FAILED: ", modConfig.getType().toString())),
                                new TextComponent(relativized.toString() + ": " + e.getMessage()))
                            );
                        }

                    },
                    () -> toasts.addToast(SystemToast.multiline(Minecraft.getInstance(),
                        SystemToast.SystemToastIds.PACK_LOAD_FAILURE,
                        new TextComponent("Config file reloading failed for:"),
                        new TextComponent(relativized.toString()))
                    )
                );

        };
        FileBrowserScreen.RELOADS_ON_SAVE = fileAbsolutePath -> {
            Path configDir = FMLPaths.CONFIGDIR.get();
            if (fileAbsolutePath.startsWith(configDir)) {
                Path relativized = configDir.relativize(fileAbsolutePath);

                boolean anyMatch = ConfigTracker.INSTANCE.configSets().get(ModConfig.Type.CLIENT).stream().anyMatch(modConfig -> FILTER.test(relativized, modConfig));
                if (!anyMatch) {
                    if (Minecraft.getInstance().isLocalServer() || Minecraft.getInstance().level == null) {
                        return ConfigTracker.INSTANCE.configSets().get(ModConfig.Type.COMMON).stream().anyMatch(modConfig -> FILTER.test(relativized, modConfig));
                    }
                }
                return anyMatch;
            }
            return false;
        };
    }
}
