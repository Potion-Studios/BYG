package potionstudios.byg.config;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import potionstudios.byg.BYGConstants;
import potionstudios.byg.util.ModPlatform;

import java.nio.file.Path;

public record ConfigVersionTracker(int configVersion) {
    public static final Codec<ConfigVersionTracker> CODEC = RecordCodecBuilder.create(
            builder -> builder.group(
                    Codec.INT.fieldOf("version").forGetter(ConfigVersionTracker::configVersion)
            ).apply(builder, ConfigVersionTracker::new)
    );

    public static ConfigVersionTracker INSTANCE = null;
    public static ConfigVersionTracker DEFAULT = new ConfigVersionTracker(BYGConstants.CONFIG_VERSION);


    public static ConfigVersionTracker getConfig() {
        return getConfig(new ConfigVersionTracker(BYGConstants.CONFIG_VERSION), false);
    }

    public static ConfigVersionTracker getConfig(ConfigVersionTracker from, boolean recreate) {
        Path resolve = ModPlatform.INSTANCE.configPath().resolve("config_versions.json5");
        if (!resolve.toFile().exists() || recreate) {
            JanksonUtil.createConfig(resolve, CODEC, JanksonUtil.HEADER_CLOSED, ImmutableMap.of(), JanksonJsonOps.INSTANCE, from);
        }
        try {
            INSTANCE = JanksonUtil.readConfig(resolve, CODEC, JanksonJsonOps.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
            BYGConfigHandler.CONFIG_EXCEPTIONS.add(e);
        }

        return DEFAULT;
    }
}
