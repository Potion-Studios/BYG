package potionstudios.byg.util.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class CodecUtil {
    public static final Codec<ResourceKey<Biome>> BIOME_CODEC = ResourceLocation.CODEC.comapFlatMap(resourceLocation -> DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation)), ResourceKey::location);
    public static final Codec<Block> BLOCK_CODEC = createLoggedExceptionRegistryCodec(Registry.BLOCK);
    public static final CollectionCodec<ResourceKey<Biome>, Set<ResourceKey<Biome>>> BIOME_SET_CODEC = new CollectionCodec<>(BIOME_CODEC, ObjectOpenHashSet::new);


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


    public static <T> Codec<WrapForSerialization<T>> wrapCodecForCollectionSerializing(Codec<T> codec) {
        return RecordCodecBuilder.create(builder ->
            builder.group(
                codec.fieldOf("value").forGetter(tWrapForSerialization -> tWrapForSerialization.value)
            ).apply(builder, WrapForSerialization::new));
    }

    public static <T> WrapForSerialization<T> wrap(T toWrap) {
        return new WrapForSerialization<>(toWrap);
    }

    public record WrapForSerialization<T>(T value) {
    }
}
