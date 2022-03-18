package potionstudios.byg.util.codec;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

public record CollectionCodec<TYPE, COLLECTION extends Collection<TYPE>>(Codec<TYPE> element,
                                                                         Supplier<COLLECTION> collectionConstruction) implements Codec<COLLECTION> {

    @Override
    public <T> DataResult<T> encode(COLLECTION input, DynamicOps<T> ops, T prefix) {
        final ListBuilder<T> builder = ops.listBuilder();

        for (TYPE type : input) {
            builder.add(this.element.encodeStart(ops, type));
        }

        return builder.build(prefix);
    }

    @Override
    public <T> DataResult<Pair<COLLECTION, T>> decode(DynamicOps<T> ops, T input) {
        return ops.getList(input).setLifecycle(Lifecycle.stable()).flatMap(consumer -> {
            COLLECTION result = collectionConstruction.get();
            List<T> errors = new ArrayList<>();
            consumer.accept(t -> {
                DataResult<Pair<TYPE, T>> decoded = element.decode(ops, t);
                decoded.error().ifPresent(e -> errors.add(t));
                result.add(decoded.get().orThrow().getFirst());
            });

            return DataResult.success(Pair.of(result, ops.createList(errors.stream())));
        });
    }


}
