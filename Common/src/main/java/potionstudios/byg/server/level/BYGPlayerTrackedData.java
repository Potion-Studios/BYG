package potionstudios.byg.server.level;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.network.packet.DiscoveredBiomesPacket;
import potionstudios.byg.util.CodecUtil;
import potionstudios.byg.util.ModLoaderContext;

import java.util.*;

import static potionstudios.byg.util.BYGUtil.convertMapValueType;

public record BYGPlayerTrackedData(Map<String, Set<ResourceKey<Biome>>> discoveredBiomesByNameSpace) {
    public static final Codec<BYGPlayerTrackedData> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
           Codec.unboundedMap(Codec.STRING, CodecUtil.BIOME_CODEC.listOf()).fieldOf("known_biomes").forGetter(bygPlayerTrackedData -> convertMapValueType(bygPlayerTrackedData.discoveredBiomesByNameSpace, HashMap::new, ArrayList::new))
        ).apply(builder, BYGPlayerTrackedData::fromCodec)
    );

    private static BYGPlayerTrackedData fromCodec(Map<String, List<ResourceKey<Biome>>> knownBiomes) {
        return new BYGPlayerTrackedData(convertMapValueType(knownBiomes, HashMap::new, ObjectOpenHashSet::new));
    }

    public void tickPerSecond(ServerPlayer player) {
        ResourceKey<Biome> biomeResourceKey = player.level.getBiome(player.blockPosition()).unwrapKey().orElseThrow();
        if (this.discoveredBiomesByNameSpace.computeIfAbsent(biomeResourceKey.location().getNamespace(), key -> new ObjectOpenHashSet<>()).add(biomeResourceKey)) {
            ModLoaderContext.getInstance().sendToClient(player, new DiscoveredBiomesPacket(convertMapValueType(this.discoveredBiomesByNameSpace, HashMap::new, ArrayList::new)));
        }
    }

    public interface Access {

        BYGPlayerTrackedData getServerPlayerTrackedData();
    }
}