package potionstudios.byg.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.codec.CommentedCodec;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import corgitaco.corgilib.shadow.blue.endless.jankson.api.SyntaxError;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModPlatform;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;

public record BiomepediaConfig(boolean biomepediaInventoryButtonEnabled, boolean giveBiomepediaBook) {

    public static final Codec<BiomepediaConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    CommentedCodec.of(Codec.BOOL, "inventory_enabled", "Whether the biomepedia inventory BUTTON is enabled or not in the player inventory for all users connected to this host.").forGetter(BiomepediaConfig::biomepediaInventoryButtonEnabled),
                    CommentedCodec.of(Codec.BOOL, "give_item", "Whether to give the biomepedia book ITEM to new players for the first time.").orElse(true).forGetter(BiomepediaConfig::giveBiomepediaBook)
            ).apply(builder, BiomepediaConfig::new));

    public static final BiomepediaConfig DEFAULT = new BiomepediaConfig(true, true);

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
                map.put("inventory_enabled", "");
            }), JanksonJsonOps.INSTANCE, DEFAULT);
        }
        BYG.logInfo(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }


}
