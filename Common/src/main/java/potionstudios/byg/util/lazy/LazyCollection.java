package potionstudios.byg.util.lazy;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LazyCollection<T> implements Supplier<Collection<? extends T>> {
    private Collection<? extends Supplier<? extends T>> lazy;
    private Collection<? extends T> actual;
    private final Collector<T, ?, ? extends Collection<? extends T>> collector;

    public LazyCollection(Collection<? extends Supplier<? extends T>> lazy, Collector<T, ?, ? extends Collection< ? extends T>> collector) {
        this.lazy = lazy;
        this.collector = collector;
    }

    public LazyCollection(Collection<? extends Supplier<? extends T>> lazy) {
        this(lazy, Collectors.toList());
    }

    @SafeVarargs
    public static <T> LazyCollection<T> of(Collector<T, ?, ? extends Collection<? extends T>> collector, Supplier<? extends T>... elements) {
        return new LazyCollection<>(List.of(elements), collector);
    }

    @Override
    public Collection<? extends T> get() {
        if (actual == null) {
            actual = Objects.requireNonNull(lazy)
                .stream()
                .map(Supplier::get)
                .collect(collector);
            lazy = null;
        }
        return actual;
    }
}
