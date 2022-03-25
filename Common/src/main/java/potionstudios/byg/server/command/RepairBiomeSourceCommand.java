package potionstudios.byg.server.command;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.serialization.Codec;
import net.minecraft.ChatFormatting;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.SharedSuggestionProvider;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.*;
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
import potionstudios.byg.mixin.access.*;
import potionstudios.byg.util.ModLoaderContext;

import java.nio.file.Path;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class RepairBiomeSourceCommand {

    public static final MutableComponent END_COMPONENT = new TranslatableComponent("byg.commands.repairbiomesource.changed.dimension.end");
    public static final MutableComponent NETHER_COMPONENT = new TranslatableComponent("byg.commands.repairbiomesource.changed.dimension.nether");

    private static int warnings = 0;

    public static ArgumentBuilder<CommandSourceStack, ?> register() {
        return Commands.literal("repairbiomesource").requires(cs -> cs.hasPermission(4))
            .executes(cs -> repairBiomeSource(BiomeSourceRepair.ALL, cs))
            .then(Commands.argument("BiomeSourceRepair", StringArgumentType.string())
                .executes(cs -> repairBiomeSource(cs.getArgument("BiomeSourceRepair", String.class), cs))
                .suggests((ctx, sb) -> SharedSuggestionProvider.suggest(Arrays.stream(BiomeSourceRepair.values()).map(BiomeSourceRepair::toString), sb))
            );
    }

    private static int repairBiomeSource(String fromCommand, CommandContext<CommandSourceStack> stack) {
        try {
            BiomeSourceRepair biomeSourceRepair = BiomeSourceRepair.valueOf(fromCommand);
            return repairBiomeSource(biomeSourceRepair, stack);
        } catch (Exception e) {
            stack.getSource().sendFailure(new TranslatableComponent("byg.commands.repairbiomesource.invalidinputerror", Arrays.toString(BiomeSourceRepair.values()), fromCommand));
            return 0;
        }
    }

    private static int repairBiomeSource(BiomeSourceRepair biomeSourceRepair, CommandContext<CommandSourceStack> stack) {
        CommandSourceStack source = stack.getSource();
        MinecraftServer server = source.getServer();
        boolean singlePlayer = source.getServer().isSingleplayer() && source.getServer().getPlayerCount() == 1;
        Path worldDirectory = ((LevelStorageSourceLevelStorageAccessAccess) ((MinecraftServerAccess) server).byg_getStorageSource()).byg_getLevelPath();

        if (((CommandSourceStackAccess) source).byg_getSource() instanceof MinecraftServer || singlePlayer) {
            Component exportFileComponent = new TextComponent(worldDirectory.toString()).withStyle(ChatFormatting.UNDERLINE).withStyle(text -> text.withColor(TextColor.fromLegacyFormat(ChatFormatting.AQUA)).withClickEvent(new ClickEvent(ClickEvent.Action.OPEN_FILE, worldDirectory.toString())).withHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new TranslatableComponent("byg.clickevent.hovertext"))));

            switch (warnings) {
                case 0 -> {
                    stack.getSource().sendFailure(new TranslatableComponent("byg.commands.repairbiomesource.warning1", exportFileComponent).withStyle(ChatFormatting.YELLOW));
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

            Optional<MutableComponent> mutableComponent = biomeSourceRepair.function.apply(worldGenSettings, server.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY));

            if (mutableComponent.isPresent()) {
                MutableComponent msg = new TranslatableComponent("byg.commands.repairbiomesource.changed").append("\n").append(mutableComponent.get());
                close(source, server, msg);
            } else {
                source.sendSuccess(new TranslatableComponent("byg.commands.repairbiomesource.alreadychanged"), true);
            }
            return 1;
        } else {
            source.sendSuccess(new TranslatableComponent("byg.commands.repairbiomesource.lowpermissionlevel"), true);
            return 0;
        }
    }

    private static void close(CommandSourceStack source, MinecraftServer server, MutableComponent mutableComponent) {
        if (server.isSingleplayer()) {
            for (ServerPlayer player : server.getPlayerList().getPlayers()) {
                player.connection.disconnect(mutableComponent);
            }
        } else {
            source.sendSuccess(mutableComponent, true);
            server.close();
        }
    }

    private enum BiomeSourceRepair {
        NETHER((worldGenSettings, biomeRegistry) -> {
            Supplier<BiomeSource> netherBiomeSource = () -> {
                NetherBiomesConfig config = NetherBiomesConfig.getConfig(true, biomeRegistry);
                return ModLoaderContext.getInstance().createNetherBiomeSource(biomeRegistry, worldGenSettings.seed(),
                    config.upperLayer(), config.middleLayer(), config.bottomLayer(), config.layerSize());
            };

            return repair(worldGenSettings.dimensions().getOrThrow(LevelStem.NETHER), BYGNetherBiomeSource.LOCATION, netherBiomeSource) ? Optional.of(NETHER_COMPONENT) : Optional.empty();
        }),
        END((worldGenSettings, biomeRegistry) -> {
            Supplier<BiomeSource> endBiomeSource = () -> {
                EndBiomesConfig config = EndBiomesConfig.getConfig(true, biomeRegistry);

                return ModLoaderContext.getInstance().createEndBiomeSource(biomeRegistry, worldGenSettings.seed(),
                    config.islandLayers(), config.voidLayers(), config.skyLayers());
            };

            return repair(worldGenSettings.dimensions().getOrThrow(LevelStem.END), BYGEndBiomeSource.LOCATION, endBiomeSource) ? Optional.of(END_COMPONENT) : Optional.empty();
        }),
        ALL((worldGenSettings, biomeRegistry) -> {
            MutableComponent component = null;

            Optional<MutableComponent> end = END.function.apply(worldGenSettings, biomeRegistry);
            if (end.isPresent()) {
                component = end.get();
            }

            Optional<MutableComponent> nether = NETHER.function.apply(worldGenSettings, biomeRegistry);
            if (nether.isPresent()) {
                MutableComponent netherComponent = nether.get();
                component = component != null ? component.append("\n").append(netherComponent) : netherComponent;
            }

            return component == null ? Optional.empty() : Optional.of(component);
        });

        private final BiFunction<WorldGenSettings, Registry<Biome>, Optional<MutableComponent>> function;

        BiomeSourceRepair(BiFunction<WorldGenSettings, Registry<Biome>, Optional<MutableComponent>> function) {
            this.function = function;
        }

        private static boolean repair(LevelStem dimension, ResourceLocation targetBiomeSourceID, Supplier<BiomeSource> replacement) {
            ChunkGenerator generator = dimension.generator();
            Codec<? extends BiomeSource> codec = ((BiomeSourceAccess) generator.getBiomeSource()).byg_invokeCodec();
            if (!Registry.BIOME_SOURCE.getKey(codec).equals(targetBiomeSourceID)) {
                BiomeSource replacementBiomeSource = replacement.get();
                ((ChunkGeneratorAccess) generator).byg_setBiomeSource(replacementBiomeSource);
                ((ChunkGeneratorAccess) generator).byg_setRuntimeBiomeSource(replacementBiomeSource);
                return true;
            }
            return false;
        }
    }
}