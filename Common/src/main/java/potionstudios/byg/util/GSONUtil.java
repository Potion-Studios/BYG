package potionstudios.byg.util;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.annotation.Nullable;
import java.util.Map;

public class GSONUtil {
    private static final Gson gson = new Gson();

    @Nullable
    public static <T> T readFirstField(String fieldKey, Class<T> type, JsonElement element) {
        if (element instanceof JsonObject) {
            JsonObject jsonObject = element.getAsJsonObject();

            if (jsonObject.has(fieldKey)) {
                return gson.fromJson(jsonObject.get(fieldKey), type);
            }
            for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
                T readField = readFirstField(fieldKey, type, entry.getValue());
                if (readField != null) {
                    return readField;
                }
            }
        }
        return null;
    }
}