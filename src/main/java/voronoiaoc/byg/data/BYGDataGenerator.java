package voronoiaoc.byg.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.SnbtProvider;
import net.minecraft.data.validate.StructureValidatorProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import voronoiaoc.byg.BYG;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BYGDataGenerator {
    //Have this load after everything else.

    public static void dataGenBiome(String filePath) throws IOException {
        OptionParser optionParser = new OptionParser();
        OptionSpec<Void> optionSpec = optionParser.accepts("help", "Show the help menu").forHelp();
        OptionSpec<Void> optionSpec7 = optionParser.accepts("all", "Include all generators");
        OptionSpec<String> optionSpec9 = optionParser.accepts("input", "Input folder").withRequiredArg();
        OptionSet optionSet = optionParser.parse("-all");
        if (!optionSet.has(optionSpec) && optionSet.hasOptions()) {
            Path path = Paths.get((filePath));
            boolean bl = optionSet.has(optionSpec7);
            DataGenerator dataGenerator = create(path, optionSet.valuesOf(optionSpec9).stream().map((string) -> Paths.get(string)).collect(Collectors.toList()));
            dataGenerator.run();
        } else {
            optionParser.printHelpOn(System.out);
        }
    }

    public static DataGenerator create(Path output, Collection<Path> inputs) {
        DataGenerator dataGenerator = new DataGenerator(output, inputs);
        dataGenerator.install((new SnbtProvider(dataGenerator)).addWriter(new StructureValidatorProvider()));
        dataGenerator.install(new BiomeDataProvider(dataGenerator));
        return dataGenerator;
    }


    public static class BiomeDataProvider implements DataProvider {
        private static final Logger logger = LogManager.getLogger();
        private static final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        private final DataGenerator dataGen;

        public BiomeDataProvider(DataGenerator dataGenerator) {
            this.dataGen = dataGenerator;
        }

        public void run(DataCache cache) {
            Path path = this.dataGen.getOutput();
            Iterator var3 = BuiltinRegistries.BIOME.getEntries().iterator();

            while (var3.hasNext()) {
                Map.Entry<RegistryKey<Biome>, Biome> entry = (Map.Entry) var3.next();
                Path path2 = filePath(path, entry.getKey().getValue(), entry.getValue());
                Biome biome = entry.getValue();


                Function<Supplier<Biome>, DataResult<JsonElement>> function = JsonOps.INSTANCE.withEncoder(Biome.REGISTRY_CODEC);

                try {
                    Optional optional = ((DataResult) function.apply(() -> biome)).result();
                    if (optional.isPresent()) {
                        DataProvider.writeToPath(gson, cache, (JsonElement) optional.get(), path2);
                    } else {
                        logger.error("Couldn't serialize biome {}", path2);
                    }
                } catch (IOException var9) {
                    logger.error("Couldn't save biome {}", path2, var9);
                }
            }

        }

        private static Path filePath(Path path, Identifier identifier, Biome biome) {
            if (Objects.requireNonNull(BuiltinRegistries.BIOME.getId(biome)).toString().contains(BYG.MODID))
                return path.resolve(BYG.MODID + "/biomes/" + identifier.getPath() + ".json");
            else
                return path.resolve("minecraft/biomes/" + identifier.getPath() + ".json");

        }

        public String getName() {
            return "Byg Biomes";
        }
    }

}
