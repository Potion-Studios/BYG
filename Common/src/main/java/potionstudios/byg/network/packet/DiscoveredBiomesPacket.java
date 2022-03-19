package potionstudios.byg.network.packet;

import com.mojang.serialization.Codec;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.server.level.BYGPlayerTrackedData;
import potionstudios.byg.util.codec.CodecUtil;

import java.util.Map;
import java.util.Set;

public record DiscoveredBiomesPacket(Map<String, Set<ResourceKey<Biome>>> discoveredBiomes) implements BYGS2CPacket {

    public static DiscoveredBiomesPacket read(FriendlyByteBuf buf) {
        try {
            return new DiscoveredBiomesPacket(buf.readWithCodec(Codec.unboundedMap(Codec.STRING, CodecUtil.BIOME_SET_CODEC)));
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(Codec.unboundedMap(Codec.STRING, CodecUtil.BIOME_SET_CODEC), this.discoveredBiomes);
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(Level level) {
        Map<String, Set<ResourceKey<Biome>>> discoveredBiomesByNameSpace = ((BYGPlayerTrackedData.Access) Minecraft.getInstance().player).getPlayerTrackedData().discoveredBiomesByNameSpace();
        discoveredBiomesByNameSpace.clear();
        discoveredBiomesByNameSpace.putAll(this.discoveredBiomes);
    }
}