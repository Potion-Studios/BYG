package potionstudios.byg.server.command;

import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.Codec;
import it.unimi.dsi.fastutil.Function;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.*;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.levelgen.WorldGenSettings;
import net.minecraft.world.level.storage.PrimaryLevelData;
import potionstudios.byg.common.world.biome.end.BYGEndBiomeSource;
import potionstudios.byg.common.world.biome.end.EndBiomesConfig;
import potionstudios.byg.common.world.biome.nether.BYGNetherBiomeSource;
import potionstudios.byg.common.world.biome.nether.NetherBiomesConfig;
import potionstudios.byg.mixin.access.BiomeSourceAccess;
import potionstudios.byg.mixin.access.ChunkGeneratorAccess;
import potionstudios.byg.mixin.access.CommandSourceStackAccess;
import potionstudios.byg.util.ModLoaderContext;

import java.io.File;
import java.util.function.Supplier;

public class RepairBiomeSourceCommand {

    private static int warnings = 0;

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        String commandString = "repairbiomesource";

        Function<CommandContext<CommandSourceStack>, Boolean> repairNether = cs -> ((CommandContext<CommandSourceStack>) cs).getArgument("Repair Nether?", Boolean.class);
        Function<CommandContext<CommandSourceStack>, Boolean> repairEnd = cs -> ((CommandContext<CommandSourceStack>) cs).getArgument("Repair End?", Boolean.class);

        return Commands.literal(commandString)
            .executes(cs -> repairBiomeSource(true, true, cs))
            .then(Commands.argument("Repair Nether?", BoolArgumentType.bool()).executes(cs -> repairBiomeSource(repairNether.apply(cs), true, cs))

                .then(Commands.argument("Repair End?", BoolArgumentType.bool())
                    .executes(cs -> repairBiomeSource(repairNether.apply(cs), repairEnd.apply(cs), cs))));
    }

    private static int repairBiomeSource(boolean repairNether, boolean repairEnd, CommandContext<CommandSourceStack> stack) {
        CommandSourceStack source = stack.getSource();
        MinecraftServer server = source.getServer();
        boolean singlePlayer = source.getServer().isSingleplayer() && source.getServer().getPlayerCount() == 1;
        boolean repairedEnd = false;
        boolean repairedNether = false;
        File serverDirectory = server.getServerDirectory();

        if (((CommandSourceStackAccess) source).byg_getSource() instanceof MinecraftServer || singlePlayer) {
            if (!repairEnd && !repairNether) {
                stack.getSource().sendFailure(new TranslatableComponent("byg.commands.repairbiomesource.none"));
                return 0;
            }

            Component exportFileComponent = new TextComponent(serverDirectory.getAbsolutePath()).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, serverDirectory.getAbsolutePath())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));

            switch (warnings) {
                case 0 -> {
                    stack.getSource().sendFailure(new TranslatableComponent("byg.commands.repairbiomesource.warning1", exportFileComponent));
                    warnings++;
                    return 0;
                }
                case 1 -> {
                    stack.getSource().sendFailure(new TranslatableComponent("byg.commands.repairbiomesource.warning2", exportFileComponent));
                    warnings++;
                    return 0;
                }
                default -> warnings = 0;
            }

            PrimaryLevelData worldData = (PrimaryLevelData) server.getWorldData();
            WorldGenSettings worldGenSettings = worldData.worldGenSettings();

            Registry<LevelStem> oldRegistry = worldGenSettings.dimensions();
            for (LevelStem dimension : oldRegistry) {
                ResourceKey<LevelStem> levelStemResourceKey = oldRegistry.getResourceKey(dimension).orElseThrow();
                ModLoaderContext modLoaderContext = ModLoaderContext.getInstance();
                Registry<Biome> biomeRegistry = server.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY);
                if (repairNether) {
                    Supplier<BiomeSource> netherBiomeSource = () -> {
                        NetherBiomesConfig config = NetherBiomesConfig.getConfig(true, biomeRegistry);
                        return modLoaderContext.createNetherBiomeSource(biomeRegistry, worldGenSettings.seed(),
                            config.upperLayer(), config.middleLayer(), config.bottomLayer(), config.layerSize());
                    };
                    if (repair(dimension, levelStemResourceKey, LevelStem.NETHER, BYGNetherBiomeSource.LOCATION, netherBiomeSource)) {
                        repairedNether = true;
                    }

                }

                if (repairEnd) {
                    Supplier<BiomeSource> endBiomeSource = () -> {
                        EndBiomesConfig config = EndBiomesConfig.getConfig(true, biomeRegistry);

                        return modLoaderContext.createEndBiomeSource(biomeRegistry, worldGenSettings.seed(),
                            config.islandLayers(), config.voidLayers(), config.skyLayers());
                    };
                    if (repair(dimension, levelStemResourceKey, LevelStem.END, BYGEndBiomeSource.LOCATION, endBiomeSource)) {
                        repairedEnd = true;
                    }
                }
            }
            if (repairedEnd || repairedNether) {
                MutableComponent mutableComponent = new TranslatableComponent("byg.commands.repairbiomesource.changed").append("\n");

                if (repairedEnd) {
                    mutableComponent.append(new TranslatableComponent("byg.commands.repairbiomesource.changed.dimension.end"));
                }
                if (repairedEnd && repairedNether) {
                    mutableComponent.append("\n");
                }

                if (repairedNether) {
                    mutableComponent.append(new TranslatableComponent("byg.commands.repairbiomesource.changed.dimension.nether"));
                }

                if (server.isSingleplayer()) {
                    for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                        player.connection.disconnect(mutableComponent);
                    }
                } else {
                    source.sendSuccess(mutableComponent, true);
                    server.close();
                }
            } else {
                source.sendSuccess(new TranslatableComponent("byg.commands.repairbiomesource.alreadychanged"), true);
            }
            return 1;
        } else {
            source.sendSuccess(new TranslatableComponent("byg.commands.repairbiomesource.lowpermissionlevel"), true);
            return 0;
        }
    }

    private static boolean repair(LevelStem dimension, ResourceKey<LevelStem> fromRegistryDimension, ResourceKey<LevelStem> targetDimension, ResourceLocation targetBiomeSourceID, Supplier<BiomeSource> replacement) {
        if (fromRegistryDimension == targetDimension) {
            ChunkGenerator generator = dimension.generator();
            Codec<? extends BiomeSource> codec = ((BiomeSourceAccess) generator.getBiomeSource()).byg_invokeCodec();
            if (!Registry.BIOME_SOURCE.getKey(codec).equals(targetBiomeSourceID)) {
                BiomeSource replacementBiomeSource = replacement.get();
                ((ChunkGeneratorAccess) generator).byg_setBiomeSource(replacementBiomeSource);
                ((ChunkGeneratorAccess) generator).byg_setRuntimeBiomeSource(replacementBiomeSource);
                return true;
            }
        }
        return false;
    }
}