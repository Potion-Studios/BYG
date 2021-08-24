

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
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.ConfiguredStructureFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.level.storage.LevelResource;
import net.minecraft.world.level.storage.PrimaryLevelData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;

@SuppressWarnings("deprecation")
public class GenDataCommand {

    public static void dataGenCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        String commandString = "gendata";
        List<String> modIdList = new ArrayList<>();
        FabricLoader.getInstance().getAllMods().forEach(modContainer -> {
            String modId = modContainer.getMetadata().getId();
            modIdList.add(modId);
        });

        LiteralCommandNode<CommandSourceStack> source = dispatcher.register(Commands.literal(commandString).then(Commands.argument("modid", StringArgumentType.string()).suggests((ctx, sb) -> SharedSuggestionProvider.suggest(modIdList.stream(), sb)).executes(cs -> {
            GenDataCommand.createBiomeDatapack(cs.getArgument("modid", String.class), cs);
            return 1;
        })));
        dispatcher.register(Commands.literal(commandString).redirect(source));
    }

    public static void createBiomeDatapack(String modId, CommandContext<CommandSourceStack> commandSource) {
        List<Biome> biomeList = new ArrayList<>();
        boolean stopSpamFlag = false;
        Path dataPackPath = dataPackPath(commandSource.getSource().getLevel().getServer().getWorldPath(LevelResource.DATAPACK_DIR), modId);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        RegistryAccess manager = commandSource.getSource().getLevel().registryAccess();
        Registry<Biome> biomeRegistry = manager.registryOrThrow(Registry.BIOME_REGISTRY);
        Registry<ConfiguredFeature<?, ?>> featuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_FEATURE_REGISTRY);
        Registry<ConfiguredStructureFeature<?, ?>> structuresRegistry = manager.registryOrThrow(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY);
        Registry<ConfiguredWorldCarver<?>> carverRegistry = manager.registryOrThrow(Registry.CONFIGURED_CARVER_REGISTRY);
        Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry = manager.registryOrThrow(Registry.CONFIGURED_SURFACE_BUILDER_REGISTRY);
        Registry<StructureProcessorList> structureProcessorRegistry = manager.registryOrThrow(Registry.PROCESSOR_LIST_REGISTRY);

        Function<WorldGenSettings, DataResult<JsonElement>> dimensionGeneratorSettingsCodec = JsonOps.INSTANCE.withEncoder(WorldGenSettings.CODEC);
        DataResult<JsonElement> jsonResult = dimensionGeneratorSettingsCodec.apply(((PrimaryLevelData) commandSource.getSource().getLevel().getLevelData()).worldGenSettings());

        try {
            Path worldImportPath = worldImportJsonPath(dataPackPath.getParent(), "world_settings");
            Files.createDirectories(worldImportPath.getParent());
            Files.write(worldImportPath, gson.toJson(jsonResult.get().left().get()).getBytes());
        } catch (IOException e) {

        }

        createJson(modId, dataPackPath, gson, surfaceBuilderRegistry, ConfiguredSurfaceBuilder.CODEC);
        createJson(modId, dataPackPath, gson, featuresRegistry, ConfiguredFeature.CODEC);
        createJson(modId, dataPackPath, gson, carverRegistry, ConfiguredWorldCarver.CODEC);
        createJson(modId, dataPackPath, gson, structuresRegistry, ConfiguredStructureFeature.CODEC);
        createJson(modId, dataPackPath, gson, structureProcessorRegistry, StructureProcessorType.LIST_CODEC);
        createBiomeJsonAndPackMcMeta(modId, commandSource, dataPackPath, gson, biomeRegistry, featuresRegistry, structuresRegistry, carverRegistry, surfaceBuilderRegistry);
    }

    private static void createBiomeJsonAndPackMcMeta(String modId, CommandContext<CommandSourceStack> commandSource, Path dataPackPath, Gson gson, Registry<Biome> biomeRegistry, Registry<ConfiguredFeature<?, ?>> featuresRegistry, Registry<ConfiguredStructureFeature<?, ?>> structuresRegistry, Registry<ConfiguredWorldCarver<?>> carverRegistry, Registry<ConfiguredSurfaceBuilder<?>> surfaceBuilderRegistry) {
        int hits = 0;
        int failedHits = 0;
        for (Map.Entry<ResourceKey<Biome>, Biome> entry : biomeRegistry.entrySet()) {
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
                    for (GenerationStep.Carving step : GenerationStep.Carving.values()) {
                        JsonArray stage = new JsonArray();
                        for (Supplier<ConfiguredWorldCarver<?>> carver : biome.getGenerationSettings().getCarvers(step)) {
                            carverRegistry.getResourceKey(carver.get()).ifPresent(carverKey -> stage.add(carverKey.location().toString()));
                        }
                        if (stage.size() > 0) {
                            carvers.add(step.getName(), stage);
                        }
                    }
                    root.getAsJsonObject().add("carvers", carvers);
                    JsonArray starts = new JsonArray();
                    for (Supplier<ConfiguredStructureFeature<?, ?>> start : biome.getGenerationSettings().structures()) {
                        structuresRegistry.getResourceKey(start.get()).ifPresent(structureKey -> starts.add(structureKey.location().toString()));
                    }
                    root.getAsJsonObject().add("starts", starts);
                    Files.write(biomeJsonPath, gson.toJson(root).getBytes());
                } else {
                    failedHits++;
                    BYG.LOGGER.warn("No parsable element found for: " + key);
                    commandSource.getSource().sendSuccess(new TranslatableComponent("commands.gendata.failed.parse", key).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED))), false);
                }
            } catch (IOException e) {
                failedHits++;
                e.printStackTrace();
                commandSource.getSource().sendSuccess(new TranslatableComponent("commands.gendata.failed.ioexception", key, e.getMessage()).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED)).withBold(true)), false);
            }
        }

        try {
            createPackMCMeta(dataPackPath, modId);
        } catch (IOException e) {
            commandSource.getSource().sendFailure(new TranslatableComponent("commands.gendata.mcmeta.failed", modId).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED))));
        }

        Component filePathText = (new TextComponent(dataPackPath.toString())).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.GREEN)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, dataPackPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("commands.gendata.hovertext"))));
        Component filePathText2 = (new TextComponent("https://github.com/CorgiTaco/BYG/issues/194")).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.DARK_RED)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, "https://github.com/CorgiTaco/BYG/issues/194")).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("commands.gendata.hovertext.link"))));
        if (failedHits > 0) {
            commandSource.getSource().sendFailure(new TranslatableComponent("commands.gendata.failed.parse.recommend.new.world", filePathText2).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED)).withBold(true)));
        }

        if (hits > 0) {
            commandSource.getSource().sendSuccess(new TranslatableComponent("commands.gendata.success", commandSource.getArgument("modid", String.class), filePathText), false);
        } else {
            commandSource.getSource().sendFailure(new TranslatableComponent("commands.gendata.listisempty", modId).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.RED))));
        }
    }

    private static <T> void createJson(String modId, Path dataPackPath, Gson gson, Registry<T> registry, Codec<Supplier<T>> encoder) {
        for (Map.Entry<ResourceKey<T>, T> entry : registry.entrySet()) {
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

    private static <T> Path createPath(Path path, ResourceLocation identifier, String modId, ResourceKey<? extends Registry<T>> registry) {
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

