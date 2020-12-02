

package corgiaoc.byg.server.command;

import com.google.gson.*;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.command.CommandSource;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.structure.processor.StructureProcessorList;
import net.minecraft.structure.processor.StructureProcessorType;
import net.minecraft.text.*;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.WorldSavePath;
import net.minecraft.util.registry.DynamicRegistryManager;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredStructureFeature;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class GenDataCommand {

    public static void dataGenCommand(CommandDispatcher<ServerCommandSource> dispatcher) {
        String commandString = "gendata";
        List<String> modIdList = new ArrayList<>();
        FabricLoader.getInstance().getAllMods().forEach(modContainer -> {
            String modId = modContainer.getMetadata().getId();
            if (!modId.contains("fabric"))
                modIdList.add(modId);
        });

        LiteralCommandNode<ServerCommandSource> source = dispatcher.register(CommandManager.literal(commandString).then(CommandManager.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> CommandSource.suggestMatching(modIdList.stream(), sb)).executes(cs -> {
            GenDataCommand.createBiomeDatapack(cs.getArgument("modid", String.class), cs);
            return 1;
        })));
        dispatcher.register(CommandManager.literal(commandString).redirect(source));
    }

    public static void createBiomeDatapack(String modId, CommandContext<ServerCommandSource> commandSource) {
        List<Biome> biomeList = new ArrayList<>();
        boolean stopSpamFlag = false;
        Path dataPackPath = dataPackPath(commandSource.getSource().getWorld().getServer().getSavePath(WorldSavePath.DATAPACKS), modId);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        DynamicRegistryManager manager = commandSource.getSource().getMinecraftServer().getRegistryManager();
        Registry<Biome> biomeRegistry = manager.get(Registry.BIOME_KEY);
        Registry<ConfiguredFeature<?, ?>> featuresRegistry = manager.get(Registry.CONFIGURED_FEATURE_WORLDGEN);
        Registry<ConfiguredStructureFeature<?, ?>> structuresRegistry = manager.get(Registry.CONFIGURED_STRUCTURE_FEATURE_WORLDGEN);
        Registry<ConfiguredCarver<?>> carverRegistry = manager.get(Registry.CONFIGURED_CARVER_WORLDGEN);
        Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry = manager.get(Registry.CONFIGURED_SURFACE_BUILDER_WORLDGEN);
        Registry<StructureProcessorList> structureProcessorRegistry = manager.get(Registry.PROCESSOR_LIST_WORLDGEN);

        createConfiguredSurfaceBuilderJson(modId, dataPackPath, gson, surfaceBuilderRegistry);
        createConfiguredFeatureJson(modId, dataPackPath, gson, featuresRegistry);
        createConfiguredCarverJson(modId, dataPackPath, gson, carverRegistry);
        createConfiguredStructureJson(modId, dataPackPath, gson, structuresRegistry);
        createProcessorListJson(modId, dataPackPath, gson, structureProcessorRegistry);
        createBiomeJsonAndPackMcMeta(modId, commandSource, biomeList, stopSpamFlag, dataPackPath, gson, biomeRegistry, featuresRegistry, structuresRegistry, carverRegistry, surfaceBuilderRegistry);
    }

    private static void createBiomeJsonAndPackMcMeta(String modId, CommandContext<ServerCommandSource> commandSource, List<Biome> biomeList, boolean stopSpamFlag, Path dataPackPath, Gson gson, Registry<Biome> biomeRegistry, Registry<ConfiguredFeature<?, ?>> featuresRegistry, Registry<ConfiguredStructureFeature<?, ?>> structuresRegistry, Registry<ConfiguredCarver<?>> carverRegistry, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry) {
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : biomeRegistry.getEntries()) {
            String biomeKey = Objects.requireNonNull(biomeRegistry.getKey(biome.getValue())).get().getValue().toString();
            if (biomeKey.contains(modId)) {
                biomeList.add(biome.getValue());
            }
        }

        if (biomeList.size() > 0) {
            for (Biome biome : biomeList) {
                Identifier key = biomeRegistry.getId(biome);
                if (key != null) {
                    Path biomeJsonPath = biomeJsonPath(dataPackPath, key, modId);
                    Function<Supplier<Biome>, DataResult<JsonElement>> biomeCodec = JsonOps.INSTANCE.withEncoder(Biome.REGISTRY_CODEC);
                    try {
//                        if (!Files.exists(biomeJsonPath)) {
                        Files.createDirectories(biomeJsonPath.getParent());
                        Optional<JsonElement> optional = (biomeCodec.apply(() -> biome).result());
                        if (optional.isPresent()) {
                            JsonElement root = optional.get();
                            JsonArray features = new JsonArray();
                            for (List<Supplier<ConfiguredFeature<?, ?>>> list : biome.getGenerationSettings().getFeatures()) {
                                JsonArray stage = new JsonArray();
                                for (Supplier<ConfiguredFeature<?, ?>> feature : list) {
                                    featuresRegistry.getKey(feature.get()).ifPresent(featureKey -> stage.add(featureKey.getValue().toString()));
                                }
                                features.add(stage);
                            }
                            root.getAsJsonObject().add("features", features);
                            String surfaceBuilder = surfaceBuilderRegistry.getKey(biome.getGenerationSettings().getSurfaceBuilder().get()).get().getValue().toString();
                            root.getAsJsonObject().addProperty("surface_builder", surfaceBuilder);

                            JsonObject carvers = new JsonObject();
                            for (GenerationStep.Carver step : GenerationStep.Carver.values()) {
                                JsonArray stage = new JsonArray();
                                for (Supplier<ConfiguredCarver<?>> carver : biome.getGenerationSettings().getCarversForStep(step)) {
                                    carverRegistry.getKey(carver.get()).ifPresent(carverKey -> stage.add(carverKey.getValue().toString()));
                                }
                                if (stage.size() > 0) {
                                    carvers.add(step.asString(), stage);
                                }
                            }
                            root.getAsJsonObject().add("carvers", carvers);
                            JsonArray starts = new JsonArray();
                            for (Supplier<ConfiguredStructureFeature<?, ?>> start : biome.getGenerationSettings().getStructureFeatures()) {
                                structuresRegistry.getKey(start.get()).ifPresent(structureKey -> starts.add(structureKey.getValue().toString()));
                            }
                            root.getAsJsonObject().add("starts", starts);
                            Files.write(biomeJsonPath, gson.toJson(root).getBytes());
                        }
//                        }
                    } catch (IOException e) {
                        if (!stopSpamFlag) {
                            commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.failed", modId).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.RED))), false);
                            stopSpamFlag = true;
                        }
                    }
                }
            }

            try {
                createPackMCMeta(dataPackPath, modId);
            } catch (IOException e) {
                commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.mcmeta.failed", modId).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.RED))), false);
            }

            Text filePathText = (new LiteralText(dataPackPath.toString())).formatted(Formatting.UNDERLINE).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.GREEN)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, dataPackPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableText("commands.gendata.hovertext"))));

            commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.success", commandSource.getArgument("modid", String.class), filePathText), false);
        } else {
            commandSource.getSource().sendFeedback(new TranslatableText("commands.gendata.listisempty", modId).styled(text -> text.withColor(TextColor.fromFormatting(Formatting.RED))), false);
        }
    }

    private static void createConfiguredFeatureJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredFeature<?, ?>> featuresRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredFeature<?, ?>>, ConfiguredFeature<?, ?>> feature : featuresRegistry.getEntries()) {
            Function<Supplier<ConfiguredFeature<?, ?>>, DataResult<JsonElement>> featureCodec = JsonOps.INSTANCE.withEncoder(ConfiguredFeature.REGISTRY_CODEC);

            ConfiguredFeature<?, ?> configuredFeature = feature.getValue();
            if (feature.getKey().getValue().toString().contains(modId)) {
                if (configuredFeature != null) {
                    if (Objects.requireNonNull(featuresRegistry.getKey(configuredFeature)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (featureCodec.apply(() -> configuredFeature).result());
                        if (optional.isPresent()) {
                            try {
                                Path cfPath = configuredFeatureJsonPath(dataPackPath, Objects.requireNonNull(featuresRegistry.getId(configuredFeature)), modId);
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

    private static void createConfiguredSurfaceBuilderJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuildersRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredSurfaceBuilder<?>>, ConfiguredSurfaceBuilder<?>> surfaceBuilder : surfaceBuildersRegistry.getEntries()) {
            Function<Supplier<ConfiguredSurfaceBuilder<?>>, DataResult<JsonElement>> surfaceBuilderCodec = JsonOps.INSTANCE.withEncoder(ConfiguredSurfaceBuilder.REGISTRY_CODEC);

            ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder = surfaceBuilder.getValue();
            if (surfaceBuilder.getKey().getValue().toString().contains(modId)) {
                if (configuredSurfaceBuilder != null) {
                    if (Objects.requireNonNull(surfaceBuildersRegistry.getKey(configuredSurfaceBuilder)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (surfaceBuilderCodec.apply(() -> configuredSurfaceBuilder).result());
                        if (optional.isPresent()) {
                            try {
                                Path sbPath = configuredSurfaceBuilderJsonPath(dataPackPath, Objects.requireNonNull(surfaceBuildersRegistry.getId(configuredSurfaceBuilder)), modId);
                                Files.createDirectories(sbPath.getParent());
                                Files.write(sbPath, gson.toJson(optional.get()).getBytes());
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static void createConfiguredCarverJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredCarver<?>> carverRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredCarver<?>>, ConfiguredCarver<?>> carver : carverRegistry.getEntries()) {
            Function<Supplier<ConfiguredCarver<?>>, DataResult<JsonElement>> carverCodec = JsonOps.INSTANCE.withEncoder(ConfiguredCarver.REGISTRY_CODEC);

            ConfiguredCarver<?> configuredCarver = carver.getValue();
            if (carver.getKey().getValue().toString().contains(modId)) {
                if (configuredCarver != null) {
                    if (Objects.requireNonNull(carverRegistry.getKey(configuredCarver)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (carverCodec.apply(() -> configuredCarver).result());
                        if (optional.isPresent()) {
                            try {
                                Path carverPath = configuredCarverJsonPath(dataPackPath, Objects.requireNonNull(carverRegistry.getId(configuredCarver)), modId);
                                Files.createDirectories(carverPath.getParent());
                                Files.write(carverPath, gson.toJson(optional.get()).getBytes());
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static void createConfiguredStructureJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredStructureFeature<?, ?>> structureRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredStructureFeature<?, ?>>, ConfiguredStructureFeature<?, ?>> structure : structureRegistry.getEntries()) {
            Function<Supplier<ConfiguredStructureFeature<?, ?>>, DataResult<JsonElement>> structureCodec = JsonOps.INSTANCE.withEncoder(ConfiguredStructureFeature.REGISTRY_CODEC);

            ConfiguredStructureFeature<?, ?> configuredStructure = structure.getValue();
            if (structure.getKey().getValue().toString().contains(modId)) {
                if (configuredStructure != null) {
                    if (Objects.requireNonNull(structureRegistry.getKey(configuredStructure)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (structureCodec.apply(() -> configuredStructure).result());
                        if (optional.isPresent()) {
                            try {
                                Path structurePath = configuredStructureFeatureJsonPath(dataPackPath, Objects.requireNonNull(structureRegistry.getId(configuredStructure)), modId);
                                Files.createDirectories(structurePath.getParent());
                                Files.write(structurePath, gson.toJson(optional.get()).getBytes());
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static void createProcessorListJson(String modId, Path dataPackPath, Gson gson, Registry<StructureProcessorList> structureProcessorRegistry) {
        for (Map.Entry<RegistryKey<StructureProcessorList>, StructureProcessorList> processor : structureProcessorRegistry.getEntries()) {
            Function<Supplier<StructureProcessorList>, DataResult<JsonElement>> processorCodec = JsonOps.INSTANCE.withEncoder(StructureProcessorType.REGISTRY_CODEC);

            StructureProcessorList processorList = processor.getValue();
            if (processor.getKey().getValue().toString().contains(modId)) {
                if (processorList != null) {
                    if (Objects.requireNonNull(structureProcessorRegistry.getKey(processorList)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (processorCodec.apply(() -> processorList).result());
                        if (optional.isPresent()) {
                            try {
                                Path processorListPath = configuredProceesorListPath(dataPackPath, Objects.requireNonNull(structureProcessorRegistry.getId(processorList)), modId);
                                Files.createDirectories(processorListPath.getParent());
                                Files.write(processorListPath, gson.toJson(optional.get()).getBytes());
                            } catch (IOException e) {
                            }
                        }
                    }
                }
            }
        }
    }

    private static Path configuredFeatureJsonPath(Path path, Identifier identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_feature/" + identifier.getPath() + ".json");
    }

    private static Path configuredSurfaceBuilderJsonPath(Path path, Identifier identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_surface_builder/" + identifier.getPath() + ".json");
    }

    private static Path configuredCarverJsonPath(Path path, Identifier identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_carver/" + identifier.getPath() + ".json");
    }

    private static Path configuredStructureFeatureJsonPath(Path path, Identifier identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_structure_feature/" + identifier.getPath() + ".json");
    }

    private static Path configuredProceesorListPath(Path path, Identifier identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/processor_list/" + identifier.getPath() + ".json");
    }

    private static Path biomeJsonPath(Path path, Identifier identifier, String modId) {
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

