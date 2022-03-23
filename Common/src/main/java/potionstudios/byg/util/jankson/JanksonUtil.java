package potionstudios.byg.util.jankson;

import blue.endless.jankson.*;
import blue.endless.jankson.api.SyntaxError;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.codec.FromFileOps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Supplier;

public class JanksonUtil {
    public static final Jankson JANKSON = Jankson.builder().allowBareRootObject().build();
    public static final Supplier<JsonGrammar.Builder> JSON_GRAMMAR_BUILDER = () -> new JsonGrammar.Builder().withComments(true).bareSpecialNumerics(true).printCommas(true);

    public static final JsonGrammar JSON_GRAMMAR = JSON_GRAMMAR_BUILDER.get().build();


    public static JsonObject addCommentsAndAlphabeticallySortRecursively(Map<String, String> comments, JsonObject object, String parentKey, boolean alphabeticallySorted) {
        for (Map.Entry<String, JsonElement> entry : object.entrySet()) {
            String objectKey = entry.getKey();
            String commentsKey = parentKey + objectKey;

            String comment = null;
            if (comments.containsKey(commentsKey)) {
                String commentToAdd = comments.get(commentsKey);
                object.setComment(objectKey, commentToAdd);
                comment = commentToAdd;
            }

            JsonElement value = entry.getValue();
            if (value instanceof JsonArray array) {
                JsonArray sortedJsonElements = new JsonArray();
                for (JsonElement element : array) {
                    if (element instanceof JsonObject nestedObject) {
                        sortedJsonElements.add(addCommentsAndAlphabeticallySortRecursively(comments, nestedObject, entry.getKey() + ".", alphabeticallySorted));
                    } else if (element instanceof JsonArray array1) {
                        JsonArrayOfArrays arrayOfArrays = new JsonArrayOfArrays();
                        arrayOfArrays.addAll(array1);
                        sortedJsonElements.add(arrayOfArrays);
                    }
                }
                if (!sortedJsonElements.isEmpty()) {
                    object.put(objectKey, sortedJsonElements, comment);
                }
            }

            if (value instanceof JsonObject nestedObject) {
                object.put(objectKey, addCommentsAndAlphabeticallySortRecursively(comments, nestedObject, entry.getKey() + ".", alphabeticallySorted), comment);
            }
        }

        if (alphabeticallySorted) {
            JsonObject alphabeticallySortedJsonObject = new JsonObject();
            TreeMap<String, JsonElement> map = new TreeMap<>(String::compareTo);
            map.putAll(object);
            alphabeticallySortedJsonObject.putAll(map);
            alphabeticallySortedJsonObject.forEach((key, entry) -> {
                alphabeticallySortedJsonObject.setComment(key, object.getComment(key));
            });

            return alphabeticallySortedJsonObject;
        }
        return object;
    }

    public static <T> void createConfig(Path path, Codec<T> codec, String header, Map<String, String> comments, FromFileOps<JsonElement> ops, T from) {
        JsonElement jsonElement = codec.encodeStart(ops, from).result().orElseThrow();

        if (jsonElement instanceof JsonObject jsonObject) {
            jsonElement = addCommentsAndAlphabeticallySortRecursively(comments, jsonObject, "", true);
        }
        try {
            Files.createDirectories(path.getParent());
            String output = header + "\n" + jsonElement.toJson(JSON_GRAMMAR);
            Files.write(path, output.getBytes());
        } catch (IOException e) {
            BYG.LOGGER.error(e.toString());
        }
    }

    public static <T> T readConfig(Path path, Codec<T> codec, DynamicOps<JsonElement> ops) throws IOException, SyntaxError {
        JsonObject load = JANKSON.load(path.toFile());
        DataResult<Pair<T, JsonElement>> decode = codec.decode(ops, load);
        Optional<DataResult.PartialResult<Pair<T, JsonElement>>> error = decode.error();
        if (error.isPresent()) {
            String errorMsg = String.format("Jankson File reading failed for \"%s\".Error:\n%s\n throwing IOException....", path.toString(), error.get().toString());
            BYG.LOGGER.error(errorMsg);
            throw new IOException();
        }

        Optional<Pair<T, JsonElement>> result = decode.resultOrPartial(BYG.LOGGER::error/*We should never get here, due to the error check but just in case, lets log it**/);
        return result.orElseThrow(() -> BYGUtil.configFileFailureException(path)).getFirst();
    }
}
