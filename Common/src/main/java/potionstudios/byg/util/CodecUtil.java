package potionstudios.byg.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.List;

public class CodecUtil {
    public static final Codec<ResourceKey<Biome>> BIOME_CODEC = ResourceLocation.CODEC.comapFlatMap(resourceLocation -> DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation)), ResourceKey::location);
    public static final Codec<Block> BLOCK_CODEC = createLoggedExceptionRegistryCodec(Registry.BLOCK);

    public static <T> Codec<T> createLoggedExceptionRegistryCodec(Registry<T> registry) {
        return ResourceLocation.CODEC.comapFlatMap(location -> {
            final T result = registry.get(location);

            if (result == null) {
                StringBuilder registryElements = new StringBuilder();
                for (int i = 0; i < registry.entrySet().size(); i++) {
                    final T object = registry.byId(i);
                    registryElements.append(i).append(". \"").append(registry.getKey(object).toString()).append("\"\n");
                }

                throw new IllegalArgumentException(String.format("\"%s\" is not a valid id in registry: %s.\n Current Registry Values:\n%s", location.toString(), registry.toString(), registryElements.toString()));
            }
            return DataResult.success(result);
        }, registry::getKey);
    }


    public static <T> Codec<SerializableCollectionFromCodec<T>> wrapCodecForCollectionSerializing(Codec<T> codec) {
        return RecordCodecBuilder.create(builder ->
            builder.group(
                codec.listOf().fieldOf("entries").forGetter(tSerializableCollectionFromCodec -> tSerializableCollectionFromCodec.values)
            ).apply(builder, SerializableCollectionFromCodec::new));
    }

    public static <T> SerializableCollectionFromCodec<T> wrapCollectionForSerializing(Collection<T> toWrap) {
        return new SerializableCollectionFromCodec<>(List.copyOf(toWrap));
    }

    public record SerializableCollectionFromCodec<T>(List<T> values) {
    }
}
