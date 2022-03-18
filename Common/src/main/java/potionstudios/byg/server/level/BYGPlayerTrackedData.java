package potionstudios.byg.server.level;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.network.packet.ConstructBYGPlayerTrackedDataPacket;
import potionstudios.byg.network.packet.DiscoveredBiomesPacket;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public record BYGPlayerTrackedData(Map<String, Set<ResourceKey<Biome>>> discoveredBiomesByNameSpace) {
    public static final Codec<BYGPlayerTrackedData> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            Codec.unboundedMap(Codec.STRING, CodecUtil.BIOME_SET_CODEC).fieldOf("known_biomes").forGetter(bygPlayerTrackedData -> bygPlayerTrackedData.discoveredBiomesByNameSpace)
        ).apply(builder, BYGPlayerTrackedData::fromCodec)
    );

    public static  BYGPlayerTrackedData fromCodec(Map<String, Set<ResourceKey<Biome>>> discoveredBiomesByNameSpace) {
        return new BYGPlayerTrackedData(new HashMap<>(discoveredBiomesByNameSpace));
    }

    public void playerCreate(ServerPlayer player) {
        ModLoaderContext.getInstance().sendToClient(player, new ConstructBYGPlayerTrackedDataPacket(this));
    }


    public void tickPerSecond(ServerPlayer player) {
        ResourceKey<Biome> biomeResourceKey = player.level.getBiome(player.blockPosition()).unwrapKey().orElseThrow();
        if (this.discoveredBiomesByNameSpace.computeIfAbsent(biomeResourceKey.location().getNamespace(), key -> new ObjectOpenHashSet<>()).add(biomeResourceKey)) {
            ModLoaderContext.getInstance().sendToClient(player, new DiscoveredBiomesPacket(this.discoveredBiomesByNameSpace));
        }
    }

    public interface Access {

        BYGPlayerTrackedData getPlayerTrackedData();

        BYGPlayerTrackedData setPlayerTrackedData(BYGPlayerTrackedData newVal);
    }
}