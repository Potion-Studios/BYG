package potionstudios.byg.util.codec;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;

import java.util.Map;
import java.util.Optional;

public record FromFileCodec<E>(Codec<E> elementCodec, String internalKey) implements Codec<Wrapped<E>> {

    public static <E> FromFileCodec<E> create(Codec<E> codec, String internalKey) {
        return new FromFileCodec<>(codec, internalKey);
    }

    @Override
    public <T> DataResult<Pair<Wrapped<E>, T>> decode(DynamicOps<T> ops, T input) {
        if (ops instanceof FromFileOps<T> ops1) {
            Map<String, E> registry = ops1.getAccess(this.internalKey);
            DataResult<Pair<String, T>> id = Codec.STRING.decode(ops, input);
            if (id.result().isEmpty()) {
                return this.elementCodec.decode(ops, input).map(m -> m.mapFirst(e -> {
                    return new Wrapped<>(Optional.empty(), e);
                }));
            } else {
                Pair<String, T> stringTPair = id.result().get();
                String key = stringTPair.getFirst();
                if (!registry.containsKey(key)) {
                    return DataResult.error(String.format("\"%s\" does not exist", key));
                } else {
                    E e = registry.get(key);
                    // TODO: Figure out why things rewrap themselves
                    return DataResult.success(Pair.of((e instanceof Wrapped wrapped) ? wrapped : new Wrapped<>(Optional.of(key), e), stringTPair.getSecond()));
                }
            }

        }
        return this.elementCodec.decode(ops, input).map(etPair -> Pair.of(new Wrapped<>(Optional.empty(), etPair.getFirst()), etPair.getSecond()));
    }

    @Override
    public <T> DataResult<T> encode(Wrapped<E> input, DynamicOps<T> ops, T prefix) {
        Optional<String> id = input.id();
        if (ops instanceof FromFileOps<T> fromFileOps) {
            if (id.isPresent()) {
                if (fromFileOps.getAccess(this.internalKey).containsKey(id.get())) {
                    return Codec.STRING.encode(id.get(), ops, prefix);
                }
            }
        }
        return this.elementCodec.encode(input.value(), ops, prefix);
    }
}
