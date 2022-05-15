package potionstudios.byg.config;

import blue.endless.jankson.api.SyntaxError;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.util.ModPlatform;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Path;

public record ConfigVersionTracker(int configVersion) {
    public static final Codec<ConfigVersionTracker> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                    Codec.INT.fieldOf("version").forGetter(ConfigVersionTracker::configVersion)
            ).apply(builder, ConfigVersionTracker::new)
    );

    public static ConfigVersionTracker INSTANCE = null;


    public static ConfigVersionTracker getConfig() {
        return getConfig(new ConfigVersionTracker(BYGConstants.CONFIG_VERSION), false);
    }

    public static ConfigVersionTracker getConfig(ConfigVersionTracker from, boolean serialize) {
        Path resolve = ModPlatform.INSTANCE.configPath().resolve("config_versions.json5");
        if (!resolve.toFile().exists() || serialize) {
            JanksonUtil.createConfig(resolve, CODEC, JanksonUtil.HEADER_CLOSED, ImmutableMap.of(), JanksonJsonOps.INSTANCE, from);
        }
        try {
            INSTANCE = JanksonUtil.readConfig(resolve, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            e.printStackTrace();
        }

        return INSTANCE;
    }
}
