package potionstudios.byg.server.command;

import blue.endless.jankson.Jankson;
import blue.endless.jankson.JsonObject;
import blue.endless.jankson.api.SyntaxError;
import com.google.gson.JsonElement;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import it.unimi.dsi.fastutil.Function;
import net.minecraft.ChatFormatting;
import net.minecraft.SharedConstants;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.data.HashCache;
import net.minecraft.network.chat.*;
import net.minecraft.resources.RegistryOps;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.storage.PrimaryLevelData;
import potionstudios.byg.BYG;
import potionstudios.byg.util.ModLoaderContext;
import potionstudios.byg.util.jankson.JanksonUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static potionstudios.byg.mixin.access.WorldGenRegistryDumpReportAccess.byg_invokeDumpRegistry;
import static potionstudios.byg.mixin.access.WorldGenRegistryDumpReportAccess.byg_invokeDumpRegistryCap;

public class WorldGenExportCommand {

    private static final String EXCLUDED = Paths.get("minecraft").resolve("worldgen").resolve("density_function").resolve("zero.json").toString();

    // Is there a better way of commenting?
    public static final Map<String, String> COMMENTS = Util.make(new HashMap<>(), map -> {
//        map.put("structures", "This is a test comment");
//        map.put("placement", "This is a test comment");
    });


    public static void worldGenExportCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        String commandString = "worldGenExport";

        Function<CommandContext<CommandSourceStack>, Boolean> withComments = cs -> ((CommandContext<CommandSourceStack>) cs).getArgument("With comments?", Boolean.class);
        Function<CommandContext<CommandSourceStack>, Boolean> builtin = cs -> ((CommandContext<CommandSourceStack>) cs).getArgument("Generate Built In Registries?", Boolean.class);

        LiteralCommandNode<CommandSourceStack> source = dispatcher.register(Commands.literal(commandString)
            .executes(cs -> generateWorldGenExport(true, false, cs))
            .then(Commands.argument("With comments?", BoolArgumentType.bool()).executes(cs -> WorldGenExportCommand.generateWorldGenExport(withComments.apply(cs), false, cs))

                .then(Commands.argument("Generate Built In Registries?", BoolArgumentType.bool())
                    .executes(cs -> WorldGenExportCommand.generateWorldGenExport(withComments.apply(cs), builtin.apply(cs), cs)))));

        dispatcher.register(Commands.literal(commandString).redirect(source));
    }

    public static int generateWorldGenExport(boolean withComments, boolean builtin, CommandContext<CommandSourceStack> commandSource) {
        CommandSourceStack source = commandSource.getSource();
        if (!source.getServer().isSingleplayer() && source.getServer().getPlayerCount() > 1) {
            source.sendFailure(new TranslatableComponent("byg.worldgenexport.singleplayer").withStyle(ChatFormatting.RED));
            return 0;
        }

        Path finalExportPath = ModLoaderContext.getInstance().configPath().getParent().resolve("world_gen_export").resolve(builtin ? "builtin" : "world").resolve("data");
        Path exportPath = finalExportPath.resolve("cache");
        Component exportFileComponent = new TextComponent(finalExportPath.toString()).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, finalExportPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));

        if (exportPath.toFile().exists()) {
            source.sendFailure(new TranslatableComponent("byg.worldgenexport.exists", exportFileComponent).withStyle(ChatFormatting.RED));
            return 0;
        }
        source.sendSuccess(new TranslatableComponent("byg.worldgenexport.starting").withStyle(ChatFormatting.YELLOW), true);

        try {
            HashCache cache = new HashCache(exportPath, "cache");
            RegistryAccess registry = builtin ? RegistryAccess.builtinCopy() : source.getLevel().registryAccess();

            Registry<LevelStem> defaultDimensions = DimensionType.defaultDimensions(registry, 0L, false);
            ChunkGenerator chunkGenerator = WorldGenSettings.makeDefaultOverworld(registry, 0L, false);

            DynamicOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, registry);

            for (RegistryAccess.RegistryData<?> knownRegistry : RegistryAccess.knownRegistries()) {
                byg_invokeDumpRegistryCap(cache, exportPath, registry, ops, knownRegistry);
            }


            Registry<LevelStem> worldSettings = builtin ? WorldGenSettings.withOverworld(registry.ownedRegistryOrThrow(Registry.DIMENSION_TYPE_REGISTRY), defaultDimensions, chunkGenerator) : ((PrimaryLevelData) source.getServer().getLevel(Level.OVERWORLD).getLevelData()).worldGenSettings().dimensions();

            byg_invokeDumpRegistry(exportPath, cache, ops, Registry.LEVEL_STEM_REGISTRY, worldSettings, LevelStem.CODEC);

            if (withComments) {
                Files.walk(exportPath).forEach(path -> {
                    String fileName = path.getFileName().toString();
                    boolean skipZero = !path.toString().endsWith(EXCLUDED); // For some odd reason this file is improper json
                    if (fileName.endsWith(".json") && skipZero) {
                        try {
                            JsonObject load = Jankson.builder().build().load(path.toFile());
                            load = JanksonUtil.addCommentsAndAlphabeticallySortRecursively(COMMENTS, load, "", true);
                            Files.write(path, load.toJson(JanksonUtil.JSON_GRAMMAR).getBytes());
                        } catch (IOException | SyntaxError e) {
                            BYG.LOGGER.error(String.format("\"%s\" had errors: ", path.toString()));
                            e.printStackTrace();
                        }
                    }
                });
            }

            Path result = exportPath.resolve("reports").resolve("worldgen");
            Files.walk(result).sorted(Comparator.reverseOrder()).forEach(path -> {
                try {
                    if (path.getFileName().toString().endsWith(".json")) {
                        String newTarget = result.relativize(path).toString();
                        Path newPath = finalExportPath.resolve(newTarget);
                        Files.createDirectories(newPath.getParent());
                        byte[] bytes = Files.readAllBytes(path);
                        Files.write(newPath, bytes);
                    }

                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            Files.walk(exportPath).sorted(Comparator.reverseOrder()).forEach(path -> {
                try {
                    Files.delete(path);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            createPackMCMeta(finalExportPath.getParent(), builtin);
            source.sendSuccess(new TranslatableComponent("byg.worldgenexport.success", exportFileComponent).withStyle(ChatFormatting.GREEN), true);
            return 1;
        } catch (IOException e) {
            source.sendFailure(new TranslatableComponent("byg.worldgenexport.failed"));
            e.printStackTrace();
            return 0;
        }
    }

    private static void createPackMCMeta(Path path, boolean builtIn) throws IOException {
        String fileString = "{\n" +
            "\t\"pack\":{\n" +
            "\t\t\"pack_format\": " + SharedConstants.DATA_PACK_FORMAT + ",\n" +
            "\t\t\"description\": \"" + " Generated world gen datapack from " + (builtIn ? "built in registries" : "current world registries") + ".\"\n" +
            "\t}\n" +
            "}\n";

        Files.write(path.resolve("pack.mcmeta"), fileString.getBytes());
    }
}