package potionstudios.byg.util.jankson;

import blue.endless.jankson.JsonArray;
import blue.endless.jankson.JsonGrammar;

import java.io.IOException;
import java.io.Writer;

public class JsonArrayOfArrays extends JsonArray {


    @Override
    public void toJson(Writer writer, JsonGrammar grammar, int depth) throws IOException {
        super.toJson(writer, JanksonUtil.JSON_GRAMMAR_BUILDER.get().printWhitespace(false).build(), depth);
    }
}
