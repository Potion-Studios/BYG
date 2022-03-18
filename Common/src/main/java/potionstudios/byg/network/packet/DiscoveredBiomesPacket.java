package potionstudios.byg.network.packet;

import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.server.level.BYGPlayerTrackedData;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.CodecUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public record DiscoveredBiomesPacket(Map<String, List<ResourceKey<Biome>>> discoveredBiomes) implements BYGS2CPacket {

    public static DiscoveredBiomesPacket read(FriendlyByteBuf buf) {
        try {
            return new DiscoveredBiomesPacket(buf.readWithCodec(Codec.unboundedMap(Codec.STRING, Codec.list(CodecUtil.BIOME_CODEC))));
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(Codec.unboundedMap(Codec.STRING, Codec.list(CodecUtil.BIOME_CODEC)), this.discoveredBiomes);
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(ClientLevel level) {
        Map<String, Set<ResourceKey<Biome>>> discoveredBiomesByNameSpace = ((BYGPlayerTrackedData.Access) Minecraft.getInstance().player).getServerPlayerTrackedData().discoveredBiomesByNameSpace();
        discoveredBiomesByNameSpace.clear();
        discoveredBiomesByNameSpace.putAll(BYGUtil.convertMapValueType(this.discoveredBiomes, HashMap::new, ObjectOpenHashSet::new));
    }
}