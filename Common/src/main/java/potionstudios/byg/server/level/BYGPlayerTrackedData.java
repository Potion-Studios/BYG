package potionstudios.byg.server.level;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.network.packet.DiscoveredBiomes;
import potionstudios.byg.util.CodecUtil;
import potionstudios.byg.util.ModLoaderContext;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public record BYGPlayerTrackedData(Set<ResourceKey<Biome>> discoveredBiomes) {
    public static final Codec<BYGPlayerTrackedData> CODEC = RecordCodecBuilder.create(builder ->
        builder.group(
            CodecUtil.BIOME_CODEC.listOf().fieldOf("known_biomes").forGetter(bygPlayerTrackedData -> new ArrayList<>(bygPlayerTrackedData.discoveredBiomes))
        ).apply(builder, BYGPlayerTrackedData::fromCodec)
    );

    private static BYGPlayerTrackedData fromCodec(Collection<ResourceKey<Biome>> knownBiomes) {
        return new BYGPlayerTrackedData(new ObjectOpenHashSet<>(knownBiomes));
    }

    public void tickPerSecond(ServerPlayer player) {
        if (this.discoveredBiomes.add(player.level.getBiome(player.blockPosition()).unwrapKey().orElseThrow())) {
            ModLoaderContext.getInstance().sendToClient(player, new DiscoveredBiomes(this.discoveredBiomes));
        }
    }

    public interface Access {

        BYGPlayerTrackedData getServerPlayerTrackedData();
    }
}