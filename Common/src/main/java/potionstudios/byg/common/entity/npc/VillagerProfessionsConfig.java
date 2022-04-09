package potionstudios.byg.common.entity.npc;

import blue.endless.jankson.api.SyntaxError;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import potionstudios.byg.BYG;
import potionstudios.byg.util.jankson.JanksonJsonOps;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public record VillagerProfessionsConfig(Map<VillagerProfession, Int2ObjectMap<VillagerTrades.ItemListing[]>> tradesByProfession) {

    public static final Supplier<Path> CONFIG_PATH = () -> BYG.CONFIG_PATH.resolve(BYG.MOD_ID + "-villager-trades.json5");

    public static VillagerProfessionsConfig INSTANCE = null;


    public static final VillagerProfessionsConfig DEFAULT = new VillagerProfessionsConfig(BYGVillagerTrades.TRADES);

    public static final Codec<VillagerProfessionsConfig> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(BYGVillagerTrades.VILLAGER_TRADES_CODEC.fieldOf("trades_by_profession").forGetter(config -> config.tradesByProfession)
        ).apply(builder, VillagerProfessionsConfig::new)
    );

    public static VillagerProfessionsConfig getConfig() {
        return getConfig(false);
    }

    public static VillagerProfessionsConfig getConfig(boolean serialize) {
        if (INSTANCE == null || serialize) {
            INSTANCE = readConfig();
        }

        return INSTANCE;
    }

    public static void setConfigInstance(VillagerProfessionsConfig config) {
        INSTANCE = config;
    }

    private static VillagerProfessionsConfig readConfig() {
        final Path path = CONFIG_PATH.get();

        if (!path.toFile().exists()) {
            createConfig(path);
        }
        BYG.LOGGER.info(String.format("\"%s\" was read.", path.toString()));

        try {
            return JanksonUtil.readConfig(path, CODEC, JanksonJsonOps.INSTANCE);
        } catch (IOException | SyntaxError e) {
            throw new RuntimeException(e);
        }
    }

    private static void createConfig(Path path) {
        JanksonUtil.createConfig(path, CODEC, JanksonUtil.HEADER_CLOSED, new HashMap<>(), JanksonJsonOps.INSTANCE, DEFAULT);
    }
}