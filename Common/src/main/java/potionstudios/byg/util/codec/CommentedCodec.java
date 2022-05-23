package potionstudios.byg.util.codec;

import com.mojang.serialization.*;

import java.util.function.BiFunction;
import java.util.stream.Stream;

public class CommentedCodec<A> extends MapCodec<A> {

    private final MapCodec<A> mapCodec;
    private final String name;
    private final String comment;

    public static <B> CommentedCodec<B> of(Codec<B> codec, String name, String comment) {
        return new CommentedCodec<>(codec, name, comment, Codec::fieldOf);
    }

    public static <B> CommentedCodec<B> optionalOf(Codec<B> codec, String name, String comment) {
        return new CommentedCodec<>(codec, name, comment, (bCodec, s) -> (MapCodec<B>) bCodec.optionalFieldOf(name));
    }

    public static <B> CommentedCodec<B> optionalOf(Codec<B> codec, String name, String comment, B defaultVal) {
        return new CommentedCodec<>(codec, name, comment, (bCodec, s) -> bCodec.optionalFieldOf(name, defaultVal));
    }

    public CommentedCodec(Codec<A> codec, String name, String comment, BiFunction<Codec<A>, String, MapCodec<A>> codecBiFunction) {
        this.mapCodec = codecBiFunction.apply(codec, name);
        this.name = name;
        this.comment = comment;
    }

    @Override
    public <T> Stream<T> keys(DynamicOps<T> ops) {
        return this.mapCodec.keys(ops);
    }

    @Override
    public <T> DataResult<A> decode(DynamicOps<T> ops, MapLike<T> input) {
        return this.mapCodec.decode(ops, input);
    }

    @Override
    public <T> RecordBuilder<T> encode(A input, DynamicOps<T> ops, RecordBuilder<T> prefix) {
        if (prefix instanceof CommentsTracker commentsTracker) {
            commentsTracker.addComment(this.name, this.comment);
        }
        return this.mapCodec.encode(input, ops, prefix);
    }


}
