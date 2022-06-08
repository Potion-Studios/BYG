package potionstudios.byg.util.lazy;

import java.util.function.Supplier;

public class LazySupplier<T> implements Supplier<T> {
    private Supplier<T> supplier;
    private T instance;

    public LazySupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    public static <T> LazySupplier<T> lazy(Supplier<T> sup) {
        return new LazySupplier<>(sup);
    }

    @Override
    public final T get() {
        if (supplier != null) {
            instance = supplier.get();
            supplier = null;
        }
        return instance;
    }
}
