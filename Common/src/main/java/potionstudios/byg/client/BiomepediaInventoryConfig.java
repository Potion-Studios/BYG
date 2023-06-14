package potionstudios.byg.client;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import corgitaco.corgilib.serialization.jankson.JanksonJsonOps;
import corgitaco.corgilib.serialization.jankson.JanksonUtil;
import net.minecraft.Util;
import potionstudios.byg.BYG;
import potionstudios.byg.config.BYGConfigHandler;
import potionstudios.byg.util.ModPlatform;

import java.nio.file.Path;
import java.util.HashMap;

public record BiomepediaInventoryConfig(boolean visible, PlayerInventoryPosition settings) {

    public static boolean server_value = true;

    public static final Codec<BiomepediaInventoryConfig> CODEC = RecordCodecBuilder.create(builder ->
            builder.group(
                    Codec.BOOL.fieldOf("visible").forGetter(BiomepediaInventoryConfig::visible),
                    PlayerInventoryPosition.CODEC.fieldOf("inventory_position").forGetter(BiomepediaInventoryConfig::settings)
            ).apply(builder, BiomepediaInventoryConfig::new));

    public static final BiomepediaInventoryConfig DEFAULT = new BiomepediaInventoryConfig(true, new PlayerInventoryPosition(126, 22));

    public static BiomepediaInventoryConfig INSTANCE = null;

    public static BiomepediaInventoryConfig getConfig() {
        return getConfig(false, false);
    }

    public static BiomepediaInventoryConfig getConfig(boolean serialize) {
        return getConfig(serialize, false);
    }

    public static BiomepediaInventoryConfig getConfig(boolean serialize, boolean recreate) {
        if (INSTANCE == null || serialize || recreate) {
            INSTANCE = readConfig(recreate);
        }
        return INSTANCE;
    }


    private static BiomepediaInventoryConfig readConfig(boolean recreate) {
        final Path path = ModPlatform.INSTANCE.configPath().resolve("client").resolve("biomepedia_inventory.json5");

        if (!path.toFile().exists() || recreate) {
            JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, Util.make(new HashMap<>(), map -> {
                map.put("visible", "Whether the biomepedia button is visible in the player inventory.\nServers can disable this button from functioning regardless of this value.");
                map.put("inventory_position", "Inventory GUI settings for the biomepedia button position.");
            }), JanksonJsonOps.INSTANCE, DEFAULT);
        }
        BYG.logDebug(String.format("\"%s\" was read.", path));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (Exception e) {
            e.printStackTrace();
            BYGConfigHandler.CONFIG_EXCEPTIONS.add(e);
            return DEFAULT;
        }
    }

    public record PlayerInventoryPosition(int widthOffset, int heightOffset) {
        public static final Codec<PlayerInventoryPosition> CODEC = RecordCodecBuilder.create(builder ->
                builder.group(
                        Codec.INT.fieldOf("width_offset").forGetter(PlayerInventoryPosition::widthOffset),
                        Codec.INT.fieldOf("height_offset").forGetter(PlayerInventoryPosition::heightOffset)
                ).apply(builder, PlayerInventoryPosition::new));
    }
}
