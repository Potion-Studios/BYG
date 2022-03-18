package potionstudios.byg.network.packet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import potionstudios.byg.server.level.BYGPlayerTrackedData;
import potionstudios.byg.util.CodecUtil;

import java.util.Collection;
import java.util.Set;

import static potionstudios.byg.util.CodecUtil.wrapCodecForCollectionSerializing;
import static potionstudios.byg.util.CodecUtil.wrapCollectionForSerializing;

public record DiscoveredBiomes(Collection<ResourceKey<Biome>> discoveredBiomes) implements BYGS2CPacket {

    public static DiscoveredBiomes read(FriendlyByteBuf buf) {
        try {
            return new DiscoveredBiomes(buf.readWithCodec(wrapCodecForCollectionSerializing(CodecUtil.BIOME_CODEC)).values());
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be read. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void write(FriendlyByteBuf buf) {
        try {
            buf.writeWithCodec(wrapCodecForCollectionSerializing(CodecUtil.BIOME_CODEC), wrapCollectionForSerializing(this.discoveredBiomes));
        } catch (Exception e) {
            throw new IllegalStateException("Discovered Biomes packet could not be written. This is really really bad...\n\n" + e.getMessage());
        }
    }

    @Override
    public void handle(ClientLevel level) {
        Set<ResourceKey<Biome>> discoveredBiomes = ((BYGPlayerTrackedData.Access) Minecraft.getInstance().player).getServerPlayerTrackedData().discoveredBiomes();
        discoveredBiomes.clear();
        discoveredBiomes.addAll(this.discoveredBiomes);
    }


}