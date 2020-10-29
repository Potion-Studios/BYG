package corgiaoc.byg.server.command;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.command.CommandSource;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.ClickEvent;
import net.minecraft.text.TextColor;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@SuppressWarnings("deprecation")
public class GenDataCommand {
    //Have this load after everything else.

    public static void dataGenBiome(String filePath, String modId, CommandContext<ServerCommandSource> source) throws IOException {
        OptionParser optionParser = new OptionParser();
        OptionSpec<Void> optionSpec = optionParser.accepts("help", "Show the help menu").forHelp();
        OptionSpec<Void> optionSpec7 = optionParser.accepts("all", "Include all generators");
        OptionSpec<String> optionSpec9 = optionParser.accepts("input", "Input folder").withRequiredArg();
        OptionSet optionSet = optionParser.parse("-all");
        if (!optionSet.has(optionSpec) && optionSet.hasOptions()) {
            Path path = Paths.get((filePath));
            boolean bl = optionSet.has(optionSpec7);
            DataGenerator dataGenerator = create(path, optionSet.valuesOf(optionSpec9).stream().map((string) -> Paths.get(string)).collect(Collectors.toList()), modId, source);
            dataGenerator.run();
        } else {
            optionParser.printHelpOn(System.out);
        }
    }

    public static DataGenerator create(Path output, Collection<Path> inputs, String modId, CommandContext<ServerCommandSource> source) {
        DataGenerator dataGenerator = new DataGenerator(output, inputs);
        dataGenerator.install(new BiomeDataProvider(dataGenerator, modId, source));
        return dataGenerator;
    }


    public static class BiomeDataProvider implements DataProvider {
        private static final Logger logger = LogManager.getLogger();
        private static final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        private final DataGenerator dataGen;
        private final String modId;
        private final CommandContext<ServerCommandSource> commandSource;

        private static final List<Biome> biomeList = new ArrayList<>();

        public BiomeDataProvider(DataGenerator dataGenerator, String modId, CommandContext<ServerCommandSource> source) {
            this.dataGen = dataGenerator;
            this.modId = modId;
            commandSource = source;
        }

        public void run(DataCache cache) {
            Path path = this.dataGen.getOutput();
            for (Map.Entry<RegistryKey<Biome>, Biome> biome : BuiltinRegistries.BIOME.getEntries()) {
                if (Objects.requireNonNull(BuiltinRegistries.BIOME.getId(biome.getValue())).toString().contains(modId)) {
                    biomeList.add(biome.getValue());
                }
            }

            if (biomeList.size() > 0) {
                for (Biome biome : biomeList) {
                    Path path2 = filePath(path, BuiltinRegistries.BIOME.getId(biome), modId);
                    Function<Supplier<Biome>, DataResult<JsonElement>> function1 = JsonOps.INSTANCE.withEncoder(Biome.REGISTRY_CODEC);

                    try {
                        Optional optional = ((DataResult) function1.apply(() -> biome)).result();
                        if (optional.isPresent()) {
                            DataProvider.writeToPath(gson, cache, (JsonElement) optional.get(), path2);
                        } else {
                            logger.error("Couldn't serialize biome {}", path2);
                        }
                    } catch (IOException var9) {
                        logger.error("Couldn't save biome {}", path2, var9);
                    }
                }
                commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.success", commandSource.getArgument("modid", String.class), commandSource.getSource().getWorld().getServer().getSavePath(WorldSavePath.DATAPACKS).toString().replace("\\", "/").replace("/./", "/") + "/data/" + modId + "/worldgen/biome/").styled(text -> {
//                    text.setColor(Color.func_240744_a_(TextFormatting.GREEN));

                    return text.withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, commandSource.getSource().getWorld().getServer().getSavePath(WorldSavePath.DATAPACKS).toString().replace("\\", "/").replace("/./", "/") + "/data/" + modId + "/worldgen/biome/")).withColor(TextColor.fromFormatting(Formatting.GREEN));

                }), false);
                biomeList.clear();
            } else {
                commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.listisempty", modId).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.RED))), false);
            }

        }


        @Override
        public String getName() {
            return "Byg Biomes";
        }

        private static Path filePath(Path path, Identifier identifier, String modId) {
            return path.resolve("data/" + modId + "/worldgen/biome/" + identifier.getPath() + ".json");
        }
    }

    public static void dataGenCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        String commandString = "gendata";
        List<String> modIdList = new ArrayList<>();
        FabricLoader.getInstance().getAllMods().forEach(modContainer -> {
            String modId = modContainer.getMetadata().getId();
            if (!modId.contains("fabric"))
                modIdList.add(modId);
        });

        LiteralCommandNode<ServerCommandSource> source = dispatcher.register(CommandManager.literal(commandString).then(CommandManager.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> CommandSource.suggestMatching(modIdList.stream(), sb)).executes(cs -> {
            try {
                GenDataCommand.dataGenBiome(cs.getSource().getWorld().getServer().getSavePath(WorldSavePath.DATAPACKS).toString(), cs.getArgument("modid", String.class), cs);
            } catch (IOException e) {
                cs.getSource().sendFeedback(new TranslatableText("commands.gendata.failed", cs.getArgument("modid", String.class)).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.RED))), false);
            }
            return 1;
        })));
        dispatcher.register(CommandManager.literal(commandString).redirect(source));

    }
}
