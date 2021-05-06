

package corgiaoc.byg.server.command;

import com.google.gson.*;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import corgiaoc.byg.BYG;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.storage.FolderName;
import net.minecraft.world.storage.ServerWorldInfo;
import net.minecraftforge.fml.ModList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class GenDataCommand {

    public static void dataGenCommand(CommandDispatcher<CommandSource> dispatcher) {
        String commandString = "gendata";
        List<String> modIdList = new ArrayList<>();
        ModList.get().getMods().forEach(modContainer -> {
            String modId = modContainer.getModId();
            if (!modId.equals("forge"))
                modIdList.add(modId);
        });

        LiteralCommandNode<CommandSource> source = dispatcher.register(Commands.literal(commandString).then(Commands.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> ISuggestionProvider.suggest(modIdList.stream(), sb)).executes(cs -> {
            GenDataCommand.createBiomeDatapack(cs.getArgument("modid", String.class), cs);
            return 1;
        })));
        dispatcher.register(Commands.literal(commandString).redirect(source));
    }

    public static void createBiomeDatapack(String modId, CommandContext<CommandSource> commandSource) {
        List<Biome> biomeList = new ArrayList<>();
        boolean stopSpamFlag = false;
        Path dataPackPath = dataPackPath(commandSource.getSource().getLevel().getServer().getWorldPath(FolderName.DATAPACK_DIR), modId);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        DynamicRegistries manager = commandSource.getSource().getLevel().registryAccess();
        Registry<Biome> biomeRegistry = manager.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<ConfiguredFeature<?, ?>> featuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
        Registry<StructureFeature<?, ?>> structuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY);
        Registry<ConfiguredCarver<?>> carverRegistry = manager.registryOrThrow(Registry.CONFIGURED_CARVER_REGISTRY);
        Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry = manager.registryOrThrow(Registry.CONFIGURED_SURFACE_BUILDER_REGISTRY);
        Registry<StructureProcessorList> structureProcessorRegistry = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY);

        Function<DimensionGeneratorSettings, DataResult<JsonElement>> dimensionGeneratorSettingsCodec = JsonOps.INSTANCE.withEncoder(DimensionGeneratorSettings.CODEC);
        DataResult<JsonElement> jsonResult = dimensionGeneratorSettingsCodec.apply(((ServerWorldInfo) commandSource.getSource().getLevel().getLevelData()).worldGenSettings());

        try {
            Path worldImportPath = worldImportJsonPath(dataPackPath.getParent(), "world_settings");
            Files.createDirectories(worldImportPath.getParent());
            Files.write(worldImportPath, gson.toJson(jsonResult.get().left().get()).getBytes());
        } catch (IOException e) {

        }

        createJson(modId, dataPackPath, gson, surfaceBuilderRegistry, ConfiguredSurfaceBuilder.CODEC);
        createJson(modId, dataPackPath, gson, featuresRegistry, ConfiguredFeature.CODEC);
        createJson(modId, dataPackPath, gson, carverRegistry, ConfiguredCarver.CODEC);
        createJson(modId, dataPackPath, gson, structuresRegistry, StructureFeature.CODEC);
        createJson(modId, dataPackPath, gson, structureProcessorRegistry, IStructureProcessorType.LIST_CODEC);
        createBiomeJsonAndPackMcMeta(modId, commandSource, dataPackPath, gson, biomeRegistry, featuresRegistry, structuresRegistry, carverRegistry, surfaceBuilderRegistry);
    }

    private static void createBiomeJsonAndPackMcMeta(String modId, CommandContext<CommandSource> commandSource, Path dataPackPath, Gson gson, Registry<Biome> biomeRegistry, Registry<ConfiguredFeature<?, ?>> featuresRegistry, Registry<StructureFeature<?, ?>> structuresRegistry, Registry<ConfiguredCarver<?>> carverRegistry, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry) {
        int hits = 0;
        int failedHits = 0;
        for (Map.Entry<RegistryKey<Biome>, Biome> entry : biomeRegistry.entrySet()) {
            ResourceLocation key = entry.getKey().location();
            Biome biome = entry.getValue();

            if (!key.toString().contains(modId)) {
                continue;
            }
            hits++;

            Path biomeJsonPath = biomeJsonPath(dataPackPath, key, modId);
            Function<Supplier<Biome>, DataResult<JsonElement>> biomeCodec = JsonOps.INSTANCE.withEncoder(Biome.CODEC);
            try {
                Files.createDirectories(biomeJsonPath.getParent());
                Optional<JsonElement> optional = (biomeCodec.apply(() -> biome).result());
                if (optional.isPresent()) {
                    JsonElement root = optional.get();
                    JsonArray features = new JsonArray();
                    for (List<Supplier<ConfiguredFeature<?, ?>>> list : biome.getGenerationSettings().features()) {
                        JsonArray stage = new JsonArray();
                        for (Supplier<ConfiguredFeature<?, ?>> feature : list) {
                            featuresRegistry.getResourceKey(feature.get()).ifPresent(featureKey -> stage.add(featureKey.location().toString()));
                        }
                        features.add(stage);
                    }
                    root.getAsJsonObject().add("features", features);
                    String surfaceBuilder = surfaceBuilderRegistry.getResourceKey(biome.getGenerationSettings().getSurfaceBuilder().get()).get().location().toString();
                    root.getAsJsonObject().addProperty("surface_builder", surfaceBuilder);

                    JsonObject carvers = new JsonObject();
                    for (GenerationStage.Carving step : GenerationStage.Carving.values()) {
                        JsonArray stage = new JsonArray();
                        for (Supplier<ConfiguredCarver<?>> carver : biome.getGenerationSettings().getCarvers(step)) {
                            carverRegistry.getResourceKey(carver.get()).ifPresent(carverKey -> stage.add(carverKey.location().toString()));
                        }
                        if (stage.size() > 0) {
                            carvers.add(step.getName(), stage);
                        }
                    }
                    root.getAsJsonObject().add("carvers", carvers);
                    JsonArray starts = new JsonArray();
                    for (Supplier<StructureFeature<?, ?>> start : biome.getGenerationSettings().structures()) {
                        structuresRegistry.getResourceKey(start.get()).ifPresent(structureKey -> starts.add(structureKey.location().toString()));
                    }
                    root.getAsJsonObject().add("starts", starts);
                    Files.write(biomeJsonPath, gson.toJson(root).getBytes());
                } else {
                    failedHits++;
                    BYG.LOGGER.warn("No parsable element found for: " + key);
                    commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.failed.parse", key).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))), false);
                }
            } catch (IOException e) {
                failedHits++;
                e.printStackTrace();
                commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.failed.ioexception", key, e.getMessage()).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED)).withBold(true)), false);
            }
        }

        try {
            createPackMCMeta(dataPackPath, modId);
        } catch (IOException e) {
            commandSource.getSource().sendFailure(new TranslationTextComponent("commands.gendata.mcmeta.failed", modId).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))));
        }

        ITextComponent filePathText = (new StringTextComponent(dataPackPath.toString())).withStyle(TextFormatting.UNDERLINE).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.GREEN)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, dataPackPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("commands.gendata.hovertext"))));
        ITextComponent filePathText2 = (new StringTextComponent("https://github.com/CorgiTaco/BYG/issues/194")).withStyle(TextFormatting.UNDERLINE).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.DARK_RED)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/CorgiTaco/BYG/issues/194")).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("commands.gendata.hovertext.link"))));
        if (failedHits > 0) {
            commandSource.getSource().sendFailure(new TranslationTextComponent("commands.gendata.failed.parse.recommend.new.world", filePathText2).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED)).withBold(true)));
        }

        if (hits > 0) {
            commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.success", commandSource.getArgument("modid", String.class), filePathText), false);
        } else {
            commandSource.getSource().sendFailure(new TranslationTextComponent("commands.gendata.listisempty", modId).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))));
        }
    }

    private static <T> void createJson(String modId, Path dataPackPath, Gson gson, Registry<T> registry, Codec<Supplier<T>> encoder) {
        for (Map.Entry<RegistryKey<T>, T> entry : registry.entrySet()) {
            Function<Supplier<T>, DataResult<JsonElement>> featureCodec = JsonOps.INSTANCE.withEncoder(encoder);

            T object = entry.getValue();
            if (entry.getKey().location().toString().contains(modId)) {
                if (object != null) {
                    if (Objects.requireNonNull(registry.getKey(object)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (featureCodec.apply(() -> object).result());
                        if (optional.isPresent()) {
                            try {
                                Path cfPath = createPath(dataPackPath, Objects.requireNonNull(registry.getKey(object)), modId, registry.key());
                                Files.createDirectories(cfPath.getParent());

                                Files.write(cfPath, gson.toJson(optional.get()).getBytes());
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }


    private static Path worldImportJsonPath(Path path, String jsonName) {
        return path.resolve("import/" + jsonName + ".json");
    }

    private static <T> Path createPath(Path path, ResourceLocation identifier, String modId, RegistryKey<? extends Registry<T>> registry) {
        return path.resolve("data/" + modId + "/" + registry.location().toString().replace("minecraft:", "") + "/" + identifier.getPath() + ".json");
    }

    private static Path biomeJsonPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/biome/" + identifier.getPath() + ".json");
    }

    private static Path dataPackPath(Path path, String modId) {
        return path.resolve("gendata/" + modId + "-custom");
    }

    //Generate the pack.mcmeta file required for datapacks.
    private static void createPackMCMeta(Path dataPackPath, String modID) throws IOException {
        String fileString = "{\n" +
                "\t\"pack\":{\n" +
                "\t\t\"pack_format\": 6,\n" +
                "\t\t\"description\": \"Custom biome datapack for " + modID + ".\"\n" +
                "\t}\n" +
                "}\n";

        Files.write(dataPackPath.resolve("pack.mcmeta"), fileString.getBytes());
    }
}

