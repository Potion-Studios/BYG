package potionstudios.byg.config;

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

public record BiomepediaConfig(boolean biomepediaEnabled) {

    public static final Codec<BiomepediaConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.BOOL.fieldOf("inventory_enabled").forGetter(BiomepediaConfig::biomepediaEnabled)
            ).apply(builder, BiomepediaConfig::new));

    public static final BiomepediaConfig DEFAULT = new BiomepediaConfig(true);

    public static BiomepediaConfig INSTANCE = null;

    public static BiomepediaConfig getConfig() {
        return getConfig(false, false);
    }

    public static BiomepediaConfig getConfig(boolean serialize) {
        return getConfig(serialize, false);
    }

    public static BiomepediaConfig getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }
        return INSTANCE;
    }


    private static BiomepediaConfig readConfig(boolean recreate) {
        final Path path = ModPlatform.INSTANCE.configPath().resolve("biomepedia.json5");

        if (!path.toFile().exists() || recreate) {
            JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, Util.make(new HashMap<>(), map -> {
                map.put("inventory_enabled", "Whether the biomepedia button is enabled or not in the player inventory for all users connected to this host.");
            }), JanksonJsonOps.INSTANCE, DEFAULT);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }


}
