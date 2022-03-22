package potionstudios.byg.util.jankson;

import blue.endless.jankson.*;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.*;

import javax.annotation.Nullable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public record JanksonJsonOps(boolean compressed) implements DynamicOps<JsonElement> {
    public static final JanksonJsonOps INSTANCE = new JanksonJsonOps(false);
    public static final JanksonJsonOps COMPRESSED = new JanksonJsonOps(true);

    @Override
    public JsonElement empty() {
        return JsonNull.INSTANCE;
    }

    @Override
    public <U> U convertTo(final DynamicOps<U> outOps, final JsonElement input) {
        if (input instanceof JsonObject) {
            return convertMap(outOps, input);
        }
        if (input instanceof JsonArray) {
            return convertList(outOps, input);
        }
        if (input instanceof JsonNull) {
            return outOps.empty();
        }
        final JsonPrimitive primitive = (JsonPrimitive) input;
        Object value = primitive.getValue();
        if (value instanceof String) {
            return outOps.createString(primitive.asString());
        }
        if (value instanceof Boolean) {
            return outOps.createBoolean(primitive.asBoolean(false));
        }


        final BigDecimal bigDecimal = primitive.asBigDecimal(new BigDecimal(primitive.asString()));
        try {
            final long l = bigDecimal.longValueExact();
            if ((byte) l == l) {
                return outOps.createByte((byte) l);
            }
            if ((short) l == l) {
                return outOps.createShort((short) l);
            }
            if ((int) l == l) {
                return outOps.createInt((int) l);
            }
            return outOps.createLong(l);
        } catch (final ArithmeticException e) {
            final double d = bigDecimal.doubleValue();
            if ((float) d == d) {
                return outOps.createFloat((float) d);
            }
            return outOps.createDouble(d);
        }
    }

    @Override
    public DataResult<Number> getNumberValue(final JsonElement input) {
        if (input instanceof JsonPrimitive jsonPrimitive) {
            Object value = jsonPrimitive.getValue();
            if (value instanceof Number number) {
                return DataResult.success(number);
            } else if (value instanceof Boolean bl) {
                return DataResult.success(bl ? 1 : 0);
            }
            if (compressed && value instanceof String s) {
                try {
                    return DataResult.success(Integer.parseInt(s));
                } catch (final NumberFormatException e) {
                    return DataResult.error("Not a number: " + e + " " + input);
                }
            }
        }
        if (input instanceof JsonPrimitive primitive && primitive.getValue() instanceof Boolean) {
            return DataResult.success((Boolean) primitive.getValue() ? 1 : 0);
        }
        return DataResult.error("Not a number: " + input);
    }

    @Override
    public JsonElement createNumeric(final Number i) {
        return new JsonPrimitive(i);
    }

    @Override
    public DataResult<Boolean> getBooleanValue(final JsonElement input) {
        if (input instanceof JsonPrimitive) {
            Object value = ((JsonPrimitive) input).getValue();
            if (value instanceof Boolean bl) {
                return DataResult.success(bl);
            } else if (value instanceof Number num) {
                return DataResult.success(num.byteValue() != 0);
            }
        }
        return DataResult.error("Not a boolean: " + input);
    }

    @Override
    public JsonElement createBoolean(final boolean value) {
        return new JsonPrimitive(value);
    }

    @Override
    public DataResult<String> getStringValue(final JsonElement input) {
        if (input instanceof JsonPrimitive primitive) {
            if (primitive.getValue() instanceof String || primitive.getValue() instanceof Number && compressed) {
                return DataResult.success(primitive.asString());
            }
        }
        return DataResult.error("Not a string: " + input);
    }

    @Override
    public JsonElement createString(final String value) {
        return new JsonPrimitive(value);
    }

    @Override
    public DataResult<JsonElement> mergeToList(final JsonElement list, final JsonElement value) {
        if (!(list instanceof JsonArray) && list != empty()) {
            return DataResult.error("mergeToList called with not a list: " + list, list);
        }

        final JsonArray result = new JsonArray();
        if (list != empty()) {
            result.addAll((Collection<? extends JsonElement>) list);
        }
        result.add(value);
        return DataResult.success(result);
    }

    @Override
    public DataResult<JsonElement> mergeToList(final JsonElement list, final List<JsonElement> values) {
        if (!(list instanceof JsonArray) && list != empty()) {
            return DataResult.error("mergeToList called with not a list: " + list, list);
        }

        final JsonArray result = new JsonArray();
        if (list != empty()) {
            result.addAll((Collection<? extends JsonElement>) list);
        }
        values.forEach(result::add);
        return DataResult.success(result);
    }

    @Override
    public DataResult<JsonElement> mergeToMap(final JsonElement map, final JsonElement key, final JsonElement value) {
        if (!(map instanceof JsonObject) && map != empty()) {
            return DataResult.error("mergeToMap called with not a map: " + map, map);
        }
        if (!(key instanceof JsonPrimitive primitive) || !(primitive.getValue() instanceof String) && !compressed) {
            return DataResult.error("key is not a string: " + key, map);
        }

        final JsonObject output = new JsonObject();
        if (map != empty()) {
            ((JsonObject) map).entrySet().forEach(entry -> output.put(entry.getKey(), entry.getValue()));
        }
        output.put(((JsonPrimitive) key).asString(), value);

        return DataResult.success(output);
    }

    @Override
    public DataResult<JsonElement> mergeToMap(final JsonElement map, final MapLike<JsonElement> values) {
        if (!(map instanceof JsonObject) && map != empty()) {
            return DataResult.error("mergeToMap called with not a map: " + map, map);
        }

        final JsonObject output = new JsonObject();
        if (map != empty()) {
            ((JsonObject) map).entrySet().forEach(entry -> output.put(entry.getKey(), entry.getValue()));
        }

        final List<JsonElement> missed = Lists.newArrayList();

        values.entries().forEach(entry -> {
            final JsonElement key = entry.getFirst();
            if (!(key instanceof JsonPrimitive primitive) || !(primitive.getValue() instanceof String) && !compressed) {
                missed.add(key);
                return;
            }
            output.put(((JsonPrimitive) key).asString(), entry.getSecond());
        });

        if (!missed.isEmpty()) {
            return DataResult.error("some keys are not strings: " + missed, output);
        }

        return DataResult.success(output);
    }

    @Override
    public DataResult<Stream<Pair<JsonElement, JsonElement>>> getMapValues(final JsonElement input) {
        if (!(input instanceof JsonObject)) {
            return DataResult.error("Not a JSON value: " + input);
        }
        return DataResult.success(((JsonObject) input).entrySet().stream().map(entry -> Pair.of(new JsonPrimitive(entry.getKey()), entry.getValue() instanceof JsonNull ? null : entry.getValue())));
    }

    @Override
    public DataResult<Consumer<BiConsumer<JsonElement, JsonElement>>> getMapEntries(final JsonElement input) {
        if (!(input instanceof JsonObject)) {
            return DataResult.error("Not a JSON value: " + input);
        }
        return DataResult.success(c -> {
            for (final Map.Entry<String, JsonElement> entry : ((JsonObject) input).entrySet()) {
                c.accept(createString(entry.getKey()), entry.getValue() instanceof JsonNull ? null : entry.getValue());
            }
        });
    }

    @Override
    public DataResult<MapLike<JsonElement>> getMap(final JsonElement input) {
        if (!(input instanceof JsonObject)) {
            return DataResult.error("Not a JSON value: " + input);
        }
        final JsonObject object = (JsonObject) input;
        return DataResult.success(new MapLike<>() {
            @Nullable
            @Override
            public JsonElement get(final JsonElement key) {
                final JsonElement element = object.get(((JsonPrimitive) key).asString());
                if (element instanceof JsonNull) {
                    return null;
                }
                return element;
            }

            @Nullable
            @Override
            public JsonElement get(final String key) {
                final JsonElement element = object.get(key);
                if (element instanceof JsonNull) {
                    return null;
                }
                return element;
            }

            @Override
            public Stream<Pair<JsonElement, JsonElement>> entries() {
                return object.entrySet().stream().map(e -> Pair.of(new JsonPrimitive(e.getKey()), e.getValue()));
            }

            @Override
            public String toString() {
                return "MapLike[" + object + "]";
            }
        });
    }

    @Override
    public JsonElement createMap(final Stream<Pair<JsonElement, JsonElement>> map) {
        final JsonObject result = new JsonObject();
        map.forEach(p -> {
            result.put(((JsonPrimitive) p.getFirst()).asString(), p.getSecond());
        });
        return result;
    }

    @Override
    public DataResult<Stream<JsonElement>> getStream(final JsonElement input) {
        if (input instanceof JsonArray) {
            return DataResult.success(StreamSupport.stream(((JsonArray) input).spliterator(), false).map(e -> e instanceof JsonNull ? null : e));
        }
        return DataResult.error("Not a json array: " + input);
    }

    @Override
    public DataResult<Consumer<Consumer<JsonElement>>> getList(final JsonElement input) {
        if (input instanceof JsonArray) {
            return DataResult.success(c -> {
                for (final JsonElement element : ((JsonArray) input)) {
                    c.accept(element instanceof JsonNull ? null : element);
                }
            });
        }
        return DataResult.error("Not a json array: " + input);
    }

    @Override
    public JsonElement createList(final Stream<JsonElement> input) {
        final JsonArray result = new JsonArray();
        input.forEach(result::add);
        return result;
    }

    @Override
    public JsonElement remove(final JsonElement input, final String key) {
        if (input instanceof JsonObject) {
            final JsonObject result = new JsonObject();
            ((JsonObject) input).entrySet().stream().filter(entry -> !Objects.equals(entry.getKey(), key)).forEach(entry -> result.put(entry.getKey(), entry.getValue()));
            return result;
        }
        return input;
    }

    @Override
    public String toString() {
        return "Jankson JSON";
    }

    @Override
    public ListBuilder<JsonElement> listBuilder() {
        return new ArrayBuilder();
    }

    private static final class ArrayBuilder implements ListBuilder<JsonElement> {
        private DataResult<JsonArray> builder = DataResult.success(new JsonArray(), Lifecycle.stable());

        @Override
        public DynamicOps<JsonElement> ops() {
            return INSTANCE;
        }

        @Override
        public ListBuilder<JsonElement> add(final JsonElement value) {
            builder = builder.map(b -> {
                b.add(value);
                return b;
            });
            return this;
        }

        @Override
        public ListBuilder<JsonElement> add(final DataResult<JsonElement> value) {
            builder = builder.apply2stable((b, element) -> {
                b.add(element);
                return b;
            }, value);
            return this;
        }

        @Override
        public ListBuilder<JsonElement> withErrorsFrom(final DataResult<?> result) {
            builder = builder.flatMap(r -> result.map(v -> r));
            return this;
        }

        @Override
        public ListBuilder<JsonElement> mapError(final UnaryOperator<String> onError) {
            builder = builder.mapError(onError);
            return this;
        }

        @Override
        public DataResult<JsonElement> build(final JsonElement prefix) {
            final DataResult<JsonElement> result = builder.flatMap(b -> {
                if (!(prefix instanceof JsonArray) && prefix != ops().empty()) {
                    return DataResult.error("Cannot append a list to not a list: " + prefix, prefix);
                }

                final JsonArray array = new JsonArray();
                if (prefix != ops().empty()) {
                    array.addAll(((JsonArray) prefix));
                }
                array.addAll(b);
                return DataResult.success(array, Lifecycle.stable());
            });

            builder = DataResult.success(new JsonArray(), Lifecycle.stable());
            return result;
        }
    }

    @Override
    public boolean compressMaps() {
        return compressed;
    }

    @Override
    public RecordBuilder<JsonElement> mapBuilder() {
        return new JsonRecordBuilder();
    }

    private class JsonRecordBuilder extends RecordBuilder.AbstractStringBuilder<JsonElement, JsonObject> {
        protected JsonRecordBuilder() {
            super(JanksonJsonOps.this);
        }

        @Override
        protected JsonObject initBuilder() {
            return new JsonObject();
        }

        @Override
        protected JsonObject append(final String key, final JsonElement value, final JsonObject builder) {
            builder.put(key, value);
            return builder;
        }

        @Override
        protected DataResult<JsonElement> build(final JsonObject builder, final JsonElement prefix) {
            if (prefix == null || prefix instanceof JsonNull) {
                return DataResult.success(builder);
            }
            if (prefix instanceof JsonObject) {
                final JsonObject result = new JsonObject();
                for (final Map.Entry<String, JsonElement> entry : ((JsonObject) prefix).entrySet()) {
                    result.put(entry.getKey(), entry.getValue());
                }
                for (final Map.Entry<String, JsonElement> entry : builder.entrySet()) {
                    result.put(entry.getKey(), entry.getValue());
                }
                return DataResult.success(result);
            }
            return DataResult.error("mergeToMap called with not a map: " + prefix, prefix);
        }
    }
}
