

package corgiaoc.byg.server.command;

import com.google.gson.*;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.JsonOps;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
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
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.storage.FolderName;
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
        DynamicRegistries manager = commandSource.getSource().getServer().registryAccess();
        Registry<Biome> biomeRegistry = WorldGenRegistries.BIOME;
        Registry<ConfiguredFeature<?, ?>> featuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
        Registry<StructureFeature<?, ?>> structuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY);
        Registry<ConfiguredCarver<?>> carverRegistry = manager.registryOrThrow(Registry.CONFIGURED_CARVER_REGISTRY);
        Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry = manager.registryOrThrow(Registry.CONFIGURED_SURFACE_BUILDER_REGISTRY);
        Registry<StructureProcessorList> structureProcessorRegistry = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY);


//        Function<DimensionGeneratorSettings, DataResult<JsonElement>> dimensionGeneratorSettingsCodec = JsonOps.INSTANCE.withEncoder(DimensionGeneratorSettings.CODEC);
//
//        DataResult<JsonElement> jsonResult = dimensionGeneratorSettingsCodec.apply(((ServerWorldInfo) commandSource.getSource().getWorld().getWorldInfo()).getDimensionGeneratorSettings());
//
//        try {
//            Path sbPath = worldImportJsonPath(dataPackPath, "yes");
//            Files.createDirectories(sbPath.getParent());
//            Files.write(sbPath, gson.toJson(jsonResult.get().left().get()).getBytes());
//        } catch (IOException e) {
//
//        }

        createConfiguredSurfaceBuilderJson(modId, dataPackPath, gson, surfaceBuilderRegistry);
        createConfiguredFeatureJson(modId, dataPackPath, gson, featuresRegistry);
        createConfiguredCarverJson(modId, dataPackPath, gson, carverRegistry);
        createConfiguredStructureJson(modId, dataPackPath, gson, structuresRegistry);
        createProcessorListJson(modId, dataPackPath, gson, structureProcessorRegistry);
        createBiomeJsonAndPackMcMeta(modId, commandSource, biomeList, stopSpamFlag, dataPackPath, gson, biomeRegistry, featuresRegistry, structuresRegistry, carverRegistry, surfaceBuilderRegistry);
    }

    private static void createWorldImportJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuildersRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredSurfaceBuilder<?>>, ConfiguredSurfaceBuilder<?>> surfaceBuilder : surfaceBuildersRegistry.entrySet()) {
            Function<Supplier<ConfiguredSurfaceBuilder<?>>, DataResult<JsonElement>> surfaceBuilderCodec = JsonOps.INSTANCE.withEncoder(ConfiguredSurfaceBuilder.CODEC);

            ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder = surfaceBuilder.getValue();
            if (surfaceBuilder.getKey().location().toString().contains(modId)) {
                if (configuredSurfaceBuilder != null) {
                    if (Objects.requireNonNull(surfaceBuildersRegistry.getKey(configuredSurfaceBuilder)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (surfaceBuilderCodec.apply(() -> configuredSurfaceBuilder).result());
                        if (optional.isPresent()) {
                            try {
                                Path sbPath = configuredSurfaceBuilderJsonPath(dataPackPath, Objects.requireNonNull(surfaceBuildersRegistry.getKey(configuredSurfaceBuilder)), modId);
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

    private static void createBiomeJsonAndPackMcMeta(String modId, CommandContext<CommandSource> commandSource, List<Biome> biomeList, boolean stopSpamFlag, Path dataPackPath, Gson gson, Registry<Biome> biomeRegistry, Registry<ConfiguredFeature<?, ?>> featuresRegistry, Registry<StructureFeature<?, ?>> structuresRegistry, Registry<ConfiguredCarver<?>> carverRegistry, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry) {
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : biomeRegistry.entrySet()) {
            String biomeKey = Objects.requireNonNull(biomeRegistry.getResourceKey(biome.getValue())).get().location().toString();
            if (biomeKey.contains(modId)) {
                biomeList.add(biome.getValue());
            }
        }

        if (biomeList.size() > 0) {
            for (Biome biome : biomeList) {
                ResourceLocation key = biomeRegistry.getKey(biome);
                if (key != null) {
                    Path biomeJsonPath = biomeJsonPath(dataPackPath, key, modId);
                    Function<Supplier<Biome>, DataResult<JsonElement>> biomeCodec = JsonOps.INSTANCE.withEncoder(Biome.CODEC);
                    try {
//                        if (!Files.exists(biomeJsonPath)) {
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
                        }
//                        }
                    } catch (IOException e) {
                        if (!stopSpamFlag) {
                            commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.failed", modId).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))), false);
                            stopSpamFlag = true;
                        }
                    }
                }
            }

            try {
                createPackMCMeta(dataPackPath, modId);
            } catch (IOException e) {
                commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.mcmeta.failed", modId).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))), false);
            }

            ITextComponent filePathText = (new StringTextComponent(dataPackPath.toString())).withStyle(TextFormatting.UNDERLINE).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.GREEN)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, dataPackPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("commands.gendata.hovertext"))));
            commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.success", commandSource.getArgument("modid", String.class), filePathText), false);
        } else {
            commandSource.getSource().sendSuccess(new TranslationTextComponent("commands.gendata.listisempty", modId).withStyle(text -> text.withColor(Color.fromLegacyFormat(TextFormatting.RED))), false);
        }
    }

    private static void createConfiguredFeatureJson(String modId, Path dataPackPath, Gson gson, Registry<ConfiguredFeature<?, ?>> featuresRegistry) {
        for (Map.Entry<RegistryKey<ConfiguredFeature<?, ?>>, ConfiguredFeature<?, ?>> feature : featuresRegistry.entrySet()) {
            Function<Supplier<ConfiguredFeature<?, ?>>, DataResult<JsonElement>> featureCodec = JsonOps.INSTANCE.withEncoder(ConfiguredFeature.CODEC);

            ConfiguredFeature<?, ?> configuredFeature = feature.getValue();
            if (feature.getKey().location().toString().contains(modId)) {
                if (configuredFeature != null) {
                    if (Objects.requireNonNull(featuresRegistry.getKey(configuredFeature)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (featureCodec.apply(() -> configuredFeature).result());
                        if (optional.isPresent()) {
                            try {
                                Path cfPath = configuredFeatureJsonPath(dataPackPath, Objects.requireNonNull(featuresRegistry.getKey(configuredFeature)), modId);
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
        for (Map.Entry<RegistryKey<ConfiguredSurfaceBuilder<?>>, ConfiguredSurfaceBuilder<?>> surfaceBuilder : surfaceBuildersRegistry.entrySet()) {
            Function<Supplier<ConfiguredSurfaceBuilder<?>>, DataResult<JsonElement>> surfaceBuilderCodec = JsonOps.INSTANCE.withEncoder(ConfiguredSurfaceBuilder.CODEC);

            ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder = surfaceBuilder.getValue();
            if (surfaceBuilder.getKey().location().toString().contains(modId)) {
                if (configuredSurfaceBuilder != null) {
                    if (Objects.requireNonNull(surfaceBuildersRegistry.getKey(configuredSurfaceBuilder)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (surfaceBuilderCodec.apply(() -> configuredSurfaceBuilder).result());
                        if (optional.isPresent()) {
                            try {
                                Path sbPath = configuredSurfaceBuilderJsonPath(dataPackPath, Objects.requireNonNull(surfaceBuildersRegistry.getKey(configuredSurfaceBuilder)), modId);
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
        for (Map.Entry<RegistryKey<ConfiguredCarver<?>>, ConfiguredCarver<?>> carver : carverRegistry.entrySet()) {
            Function<Supplier<ConfiguredCarver<?>>, DataResult<JsonElement>> carverCodec = JsonOps.INSTANCE.withEncoder(ConfiguredCarver.CODEC);

            ConfiguredCarver<?> configuredCarver = carver.getValue();
            if (carver.getKey().location().toString().contains(modId)) {
                if (configuredCarver != null) {
                    if (Objects.requireNonNull(carverRegistry.getKey(configuredCarver)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (carverCodec.apply(() -> configuredCarver).result());
                        if (optional.isPresent()) {
                            try {
                                Path carverPath = configuredCarverJsonPath(dataPackPath, Objects.requireNonNull(carverRegistry.getKey(configuredCarver)), modId);
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

    private static void createConfiguredStructureJson(String modId, Path dataPackPath, Gson gson, Registry<StructureFeature<?, ?>> structureRegistry) {
        for (Map.Entry<RegistryKey<StructureFeature<?, ?>>, StructureFeature<?, ?>> structure : structureRegistry.entrySet()) {
            Function<Supplier<StructureFeature<?, ?>>, DataResult<JsonElement>> structureCodec = JsonOps.INSTANCE.withEncoder(StructureFeature.CODEC);

            StructureFeature<?, ?> configuredStructure = structure.getValue();
            if (structure.getKey().location().toString().contains(modId)) {
                if (configuredStructure != null) {
                    if (Objects.requireNonNull(structureRegistry.getKey(configuredStructure)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (structureCodec.apply(() -> configuredStructure).result());
                        if (optional.isPresent()) {
                            try {
                                Path structurePath = configuredStructureFeatureJsonPath(dataPackPath, Objects.requireNonNull(structureRegistry.getKey(configuredStructure)), modId);
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
        for (Map.Entry<RegistryKey<StructureProcessorList>, StructureProcessorList> processor : structureProcessorRegistry.entrySet()) {
            Function<Supplier<StructureProcessorList>, DataResult<JsonElement>> processorCodec = JsonOps.INSTANCE.withEncoder(IStructureProcessorType.LIST_CODEC);

            StructureProcessorList processorList = processor.getValue();
            if (processor.getKey().location().toString().contains(modId)) {
                if (processorList != null) {
                    if (Objects.requireNonNull(structureProcessorRegistry.getKey(processorList)).toString().contains(modId)) {
                        Optional<JsonElement> optional = (processorCodec.apply(() -> processorList).result());
                        if (optional.isPresent()) {
                            try {
                                Path processorListPath = configuredProceesorListPath(dataPackPath, Objects.requireNonNull(structureProcessorRegistry.getKey(processorList)), modId);
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

    private static Path worldImportJsonPath(Path path, String jsonName) {
        return path.resolve("import/" + jsonName + ".json");
    }

    private static Path configuredFeatureJsonPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_feature/" + identifier.getPath() + ".json");
    }

    private static Path configuredSurfaceBuilderJsonPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_surface_builder/" + identifier.getPath() + ".json");
    }

    private static Path configuredCarverJsonPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_carver/" + identifier.getPath() + ".json");
    }

    private static Path configuredStructureFeatureJsonPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/configured_structure_feature/" + identifier.getPath() + ".json");
    }

    private static Path configuredProceesorListPath(Path path, ResourceLocation identifier, String modId) {
        return path.resolve("data/" + modId + "/worldgen/processor_list/" + identifier.getPath() + ".json");
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

