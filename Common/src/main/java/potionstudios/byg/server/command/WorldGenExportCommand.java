package potionstudios.byg.server.command;

import com.google.gson.JsonElement;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.JsonOps;
import net.minecraft.ChatFormatting;
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
import potionstudios.byg.util.ModLoaderContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static potionstudios.byg.mixin.access.WorldGenRegistryDumpReportAccess.invokeDumpRegistry;
import static potionstudios.byg.mixin.access.WorldGenRegistryDumpReportAccess.invokeDumpRegistryCap;

public class WorldGenExportCommand {

    public static void worldGenExportCommand(CommandDispatcher<CommandSourceStack> dispatcher) {
        String commandString = "worldGenExport";

        LiteralCommandNode<CommandSourceStack> source = dispatcher.register(Commands.literal(commandString).then(Commands.argument("Generate Built In Registries?", BoolArgumentType.bool()).executes(cs -> {
            WorldGenExportCommand.generateWorldGenExport(cs.getArgument("Generate Built In Registries?", Boolean.class), cs);
            return 1;
        })));
        dispatcher.register(Commands.literal(commandString).redirect(source));
    }

    public static void generateWorldGenExport(boolean builtin, CommandContext<CommandSourceStack> commandSource) {
        CommandSourceStack source = commandSource.getSource();

        source.sendSuccess(new TranslatableComponent("byg.worldgenexport.starting").withStyle(ChatFormatting.YELLOW), true);

        try {
            Path exportPath = ModLoaderContext.getInstance().configPath().getParent().resolve("world_gen_export").resolve(builtin ? "builtin" : "world");
            HashCache cache = new HashCache(exportPath, "cache");
            RegistryAccess registry = builtin ? RegistryAccess.builtinCopy() : source.getLevel().registryAccess();

            Registry<LevelStem> defaultDimensions = DimensionType.defaultDimensions(registry, 0L, false);
            ChunkGenerator chunkGenerator = WorldGenSettings.makeDefaultOverworld(registry, 0L, false);

            DynamicOps<JsonElement> ops = RegistryOps.create(JsonOps.INSTANCE, registry);

            for (RegistryAccess.RegistryData<?> knownRegistry : RegistryAccess.knownRegistries()) {
                invokeDumpRegistryCap(cache, exportPath, registry, ops, knownRegistry);
            }
            createPackMCMeta(exportPath, builtin);

            Registry<LevelStem> worldSettings = builtin ? WorldGenSettings.withOverworld(registry.ownedRegistryOrThrow(Registry.DIMENSION_TYPE_REGISTRY), defaultDimensions, chunkGenerator) : ((PrimaryLevelData) source.getServer().getLevel(Level.OVERWORLD).getLevelData()).worldGenSettings().dimensions();

            invokeDumpRegistry(exportPath, cache, ops, Registry.LEVEL_STEM_REGISTRY, worldSettings, LevelStem.CODEC);

            Component fileComponent = new TextComponent(exportPath.toString()).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, exportPath.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));

            source.sendSuccess(new TranslatableComponent("byg.worldgenexport.success", fileComponent).withStyle(ChatFormatting.GREEN), true);
        } catch (IOException e) {
            source.sendFailure(new TranslatableComponent("byg.worldgenexport.failed"));
            e.printStackTrace();
        }
    }

    private static void createPackMCMeta(Path path, boolean builtIn) throws IOException {
        String fileString = "{\n" +
            "\t\"pack\":{\n" +
            "\t\t\"pack_format\": 8,\n" +
            "\t\t\"description\": \"" + " Generated world gen datapack from " + (builtIn ? "built in registries" : "current world registries") + ".\"\n" +
            "\t}\n" +
            "}\n";

        Files.write(path.resolve("reports").resolve("pack.mcmeta"), fileString.getBytes());
    }
}