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
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.*;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.biome.Biome;
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
            if (!modId.contains("forge"))
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
        Path dataPackPath = dataPackPath(commandSource.getSource().getWorld().getServer().func_240776_a_(FolderName.DATAPACKS), modId);
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();

        //Collect biomes
        for (Map.Entry<RegistryKey<Biome>, Biome> biome : commandSource.getSource().getServer().func_244267_aX().getRegistry(Registry.BIOME_KEY).getEntries()) {
            if (Objects.requireNonNull(commandSource.getSource().getServer().func_244267_aX().getRegistry(Registry.BIOME_KEY).getKey(biome.getValue())).toString().contains(modId)) {
                biomeList.add(biome.getValue());
            }
        }

        if (biomeList.size() > 0) {
            for (Biome biome : biomeList) {
                ResourceLocation key = commandSource.getSource().getServer().func_244267_aX().getRegistry(Registry.BIOME_KEY).getKey(biome);
                if (key != null) {
                    Path biomeJsonPath = jsonPath(dataPackPath, key, modId);
                    Function<Supplier<Biome>, DataResult<JsonElement>> biomeCodec = JsonOps.INSTANCE.withEncoder(Biome.BIOME_CODEC);
                    try {
                        if (!Files.exists(biomeJsonPath)) {
                            Files.createDirectories(biomeJsonPath.getParent());
                            Optional<JsonElement> optional = (biomeCodec.apply(() -> biome).result());
                            if (optional.isPresent()) {
                                Files.write(biomeJsonPath, gson.toJson(optional.get()).getBytes());
                            }
                        }
                    } catch (IOException e) {
                        if (!stopSpamFlag) {
                            commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.failed", modId).modifyStyle(text -> text.setColor(Color.fromTextFormatting(TextFormatting.RED))), false);
                            stopSpamFlag = true;
                        }
                    }
                }
            }

            try {
                createPackMCMeta(dataPackPath, modId);
            } catch (IOException e) {
                commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.mcmeta.failed", modId).modifyStyle(text -> text.setColor(Color.fromTextFormatting(TextFormatting.RED))), false);
            }

            ITextComponent filePathText = (new StringTextComponent(".." + dataPackPath.toString())).mergeStyle(TextFormatting.UNDERLINE).modifyStyle(text -> text.setColor(Color.fromTextFormatting(TextFormatting.GREEN)).setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, dataPackPath.toString())).setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslationTextComponent("commands.gendata.hovertext"))));

            commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.success", commandSource.getArgument("modid", String.class), filePathText), false);
        } else {
            commandSource.getSource().sendFeedback(new TranslationTextComponent("commands.gendata.listisempty", modId).modifyStyle(text -> text.setColor(Color.fromTextFormatting(TextFormatting.RED))), false);
        }
    }

    private static Path jsonPath(Path path, ResourceLocation identifier, String modId) {
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
