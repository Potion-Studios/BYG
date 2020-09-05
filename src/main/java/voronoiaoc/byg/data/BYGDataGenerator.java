package voronoiaoc.byg.data;

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
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.Color;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.storage.FolderName;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BYGDataGenerator {
    //Have this load after everything else.

    public static void dataGenBiome(String filePath, String modId, CommandContext<CommandSource> source) throws IOException {
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

    public static DataGenerator create(Path output, Collection<Path> inputs, String modId, CommandContext<CommandSource> source) {
        DataGenerator dataGenerator = new DataGenerator(output, inputs);
        dataGenerator.addProvider(new BiomeDataProvider(dataGenerator, modId, source));
        return dataGenerator;
    }


    public static class BiomeDataProvider implements IDataProvider {
        private static final Logger logger = LogManager.getLogger();
        private static final Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        private final DataGenerator dataGen;
        private final String modId;
        private final CommandContext<CommandSource> commandSource;

        private static final List<Biome> biomeList = new ArrayList<>();

        public BiomeDataProvider(DataGenerator dataGenerator, String modId, CommandContext<CommandSource> source) {
            this.dataGen = dataGenerator;
            this.modId = modId;
            commandSource = source;
        }

        public void act(DirectoryCache cache) {
            Path path = this.dataGen.getOutputFolder();
            for (Map.Entry<RegistryKey<Biome>, Biome> biome : ForgeRegistries.BIOMES.getEntries()) {
                if (Objects.requireNonNull(ForgeRegistries.BIOMES.getKey(biome.getValue())).toString().contains(modId)) {
                    biomeList.add(biome.getValue());
                }
            }

            if (biomeList.size() > 0) {
                for (Biome biome : biomeList) {
                    Path path2 = filePath(path, ForgeRegistries.BIOMES.getKey(biome), modId);
                    Function<Supplier<Biome>, DataResult<JsonElement>> function1 = JsonOps.INSTANCE.withEncoder(Biome.field_235051_b_);

                    try {
                        Optional optional = ((DataResult) function1.apply(() -> biome)).result();
                        if (optional.isPresent()) {
                            IDataProvider.save(gson, cache, (JsonElement) optional.get(), path2);
                        } else {
                            logger.error("Couldn't serialize biome {}", path2);
                        }
                    } catch (IOException var9) {
                        logger.error("Couldn't save biome {}", path2, var9);
                    }
                }
                commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.success", commandSource.getArgument("modid", String.class), commandSource.getSource().getWorld().getServer().func_240776_a_(FolderName.DATAPACKS).toString().replace("\\", "/").replace("/./", "/") + "/data/" + modId + "/worldgen/biome/").modifyStyle(text -> {
//                    text.setColor(Color.func_240744_a_(TextFormatting.GREEN));

                    return text.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, commandSource.getSource().getWorld().getServer().func_240776_a_(FolderName.DATAPACKS).toString().replace("\\", "/").replace("/./", "/") + "/data/" + modId + "/worldgen/biome/")).setColor(Color.func_240744_a_(TextFormatting.GREEN));

                }), false);
                biomeList.clear();
            }
            else {
                commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.listisempty", modId).modifyStyle(text -> text.setColor(Color.func_240744_a_(TextFormatting.RED))), false);
            }

        }


        @Override
        public String getName() {
            return "Byg Biomes";
        }

        private static Path filePath(Path path, ResourceLocation identifier, String modId) {
            return path.resolve("data/" + modId + "/worldgen/biome/" + identifier.getPath() + ".json");
        }
    }

    public static void dataGenCommand(CommandDispatcher<CommandSource> dispatcher) {
        String commandString = "gendata";
        List<String> modIdList = new ArrayList<>();
        ModList.get().getMods().forEach(modContainer -> {
            String modId = modContainer.getModId();
            if (!modId.contains("forge"))
                modIdList.add(modId);
        });

        LiteralCommandNode<CommandSource> source = dispatcher.register(Commands.literal(commandString).then(Commands.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> ISuggestionProvider.suggest(modIdList.stream(), sb)).executes(cs -> {
            try {
                BYGDataGenerator.dataGenBiome(cs.getSource().getWorld().getServer().func_240776_a_(FolderName.DATAPACKS).toString(),cs.getArgument("modid", String.class), cs);
            } catch (IOException e) {
                cs.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.failed", cs.getArgument("modid", String.class)).modifyStyle(text -> text.setColor(Color.func_240744_a_(TextFormatting.RED))), false);
            }
            return 1;
        })));
        dispatcher.register(Commands.literal(commandString).redirect(source));

    }
}
