package potionstudios.byg.client;

import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public record BiomepediaClientConfig(boolean visible, PlayerInventorySettings settings) {

    public static boolean server_value = true;

    public static final Codec<BiomepediaClientConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.BOOL.fieldOf("visible").forGetter(BiomepediaClientConfig::visible),
                    PlayerInventorySettings.CODEC.fieldOf("inventory_settings").forGetter(BiomepediaClientConfig::settings)
            ).apply(builder, BiomepediaClientConfig::new));

    public static final BiomepediaClientConfig DEFAULT = new BiomepediaClientConfig(true, new PlayerInventorySettings(126, 22));

    public static BiomepediaClientConfig INSTANCE = null;

    public static BiomepediaClientConfig getConfig() {
        return getConfig(false, false);
    }

    public static BiomepediaClientConfig getConfig(boolean serialize) {
        return getConfig(serialize, false);
    }

    public static BiomepediaClientConfig getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }
        return INSTANCE;
    }


    private static BiomepediaClientConfig readConfig(boolean recreate) {
        final Path path = ModPlatform.INSTANCE.configPath().resolve("client").resolve("biomepedia_client.json5");

        if (!path.toFile().exists() || recreate) {
            JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, Util.make(new HashMap<>(), map -> {
                map.put("visible", "Whether the biomepedia button is visible in the player inventory.\nServers can disable this button from functioning regardless of this value.");
                map.put("inventory_settings", "Inventory GUI settings for the biomepedia button position.");
            }), JanksonJsonOps.INSTANCE, DEFAULT);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }

    public record PlayerInventorySettings(int widthOffset, int heightOffset) {
        public static final Codec<PlayerInventorySettings> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        Codec.INT.fieldOf("width_offset").forGetter(PlayerInventorySettings::widthOffset),
                        Codec.INT.fieldOf("height_offset").forGetter(PlayerInventorySettings::heightOffset)
                ).apply(builder, PlayerInventorySettings::new));
    }
}
