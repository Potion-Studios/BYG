package potionstudios.byg.util.codec;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public class CodecUtil {
    public static final Codec<ResourceKey<Biome>> BIOME_CODEC = ResourceLocation.CODEC.comapFlatMap(resourceLocation -> DataResult.success(ResourceKey.create(Registry.BIOME_REGISTRY, resourceLocation)), ResourceKey::location);
    public static final Codec<Block> BLOCK_CODEC = createLoggedExceptionRegistryCodec(Registry.BLOCK);
    public static final Codec<Integer> INTEGER_KEY_CODEC = Codec.STRING.comapFlatMap(s -> DataResult.success(Integer.valueOf(s)), Object::toString);

    public static final Codec<Item> ITEM_CODEC = createLoggedExceptionRegistryCodec(Registry.ITEM);
    public static final Codec<MobEffect> MOB_EFFECT_CODEC = createLoggedExceptionRegistryCodec(Registry.MOB_EFFECT);
    public static final Codec<VillagerProfession> VILLAGER_PROFESSION_CODEC = createLoggedExceptionRegistryCodec(Registry.VILLAGER_PROFESSION);
    public static final CollectionCodec<ResourceKey<Biome>, Set<ResourceKey<Biome>>> BIOME_SET_CODEC = new CollectionCodec<>(BIOME_CODEC, ObjectOpenHashSet::new);


    public static Codec<Integer> intKeyRangeCodec(int min, int max) {
        Function<Integer, DataResult<Integer>> check = Codec.checkRange(min, max);
        return INTEGER_KEY_CODEC.flatXmap(check, check);
    }

    public static <T> Codec<T> createLoggedExceptionRegistryCodec(Registry<T> registry) {
        return ResourceLocation.CODEC.comapFlatMap(location -> {
            final Optional<T> result = registry.getOptional(location);

            if (result.isEmpty()) {
                StringBuilder registryElements = new StringBuilder();
                for (int i = 0; i < registry.entrySet().size(); i++) {
                    final T object = registry.byId(i);
                    registryElements.append(i).append(". \"").append(registry.getKey(object).toString()).append("\"\n");
                }

                return DataResult.error(String.format("\"%s\" is not a valid id in registry: %s.\nCurrent Registry Values:\n\n%s\n", location.toString(), registry.toString(), registryElements.toString()));
            }
            return DataResult.success(result.get());
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
