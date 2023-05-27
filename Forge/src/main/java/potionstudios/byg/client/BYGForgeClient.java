package potionstudios.byg.client;

import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.fml.config.ModConfig;

import java.io.File;
import java.nio.file.Path;
import java.util.function.BiPredicate;

public class BYGForgeClient {
    private static final BiPredicate<Path, ModConfig> FILTER = (relativized, modConfig) -> {
        String regex = "[\\\\|/]";
        return modConfig.getFileName().replaceAll(regex, File.pathSeparator).equals(relativized.toString().replaceAll(regex, File.pathSeparator));
    };

    public static void client() {
        BYGClient.registerLayerDefinitions(ForgeHooksClient::registerLayerDefinition);
    }
}
