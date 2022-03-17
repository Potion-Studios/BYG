package potionstudios.byg.data.advancements;

import java.util.function.Consumer;

public interface BYGAdvancementConsumer<T> {


    void accept(Consumer<T> consumer, T root);
}
