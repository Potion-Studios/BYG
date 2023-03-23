package potionstudios.byg;

import com.google.common.collect.ImmutableList;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.Util;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SignBlock;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import potionstudios.byg.common.*;
import potionstudios.byg.common.block.BYGBlockTags;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.entity.BYGEntities;
import potionstudios.byg.common.entity.ai.village.poi.BYGPoiTypes;
import potionstudios.byg.common.entity.villager.BYGVillagerType;
import potionstudios.byg.config.BYGConfigHandler;
import potionstudios.byg.config.ConfigVersionTracker;
import potionstudios.byg.config.SettingsConfig;
import potionstudios.byg.mixin.access.BlockEntityTypeAccess;
import potionstudios.byg.mixin.access.DeltaFeatureAccess;
import potionstudios.byg.mixin.access.PoiTypesAccess;
import potionstudios.byg.reg.BlockRegistryObject;
import potionstudios.byg.server.command.ReloadConfigsCommand;
import potionstudios.byg.server.command.UpdateConfigsCommand;
import potionstudios.byg.util.FileUtils;
import potionstudios.byg.util.MLBlockTags;
import potionstudios.byg.util.ModPlatform;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

public class BYG {

    public static final String MOD_ID = "byg";
    private static final Logger LOGGER = LogManager.getLogger();
    public static boolean INITIALIZED;

    private static final Map<Block, Predicate<BlockBehaviour.BlockStateBase>> BLOCKSTATE_IS_REPLACEMENTS = new HashMap<>();

    public static void commonLoad() {
        registerBlockTagReplacements();

        PoiTypesAccess.byg_invokeRegisterBlockStates(BYGPoiTypes.FORAGER.asHolder());

        String loadAllConfigs = BYGConfigHandler.loadAllConfigs(false, false);
        if (!loadAllConfigs.isEmpty()) {
            throw new IllegalStateException(loadAllConfigs);
        }

        BYGEntities.registerSpawnPlacements();
        FileUtils.backUpDirectory(ModPlatform.INSTANCE.configPath(), "last_working_configs_backup");

        if (Boolean.getBoolean("bygDev")) {
            ModPlatform.INSTANCE.addTagsUpdatedListener(access -> {
                for (final var tag : BYGTags.values()) {
                    for (final var allowed : tag.acceptedTypes) {
                        final var bygTag = tag.byg(allowed);
                        final var holder = allowed.getTag(bygTag);
                        if (holder.isEmpty() || holder.get().stream().findFirst().isEmpty()) {
                            logWarning("Tag %s of type %s is empty!".formatted(bygTag.location(), allowed.registry.location()));
                        }
                    }
                }
            });
        }
    }

    private static void registerBlockTagReplacements() {
        blockToBlockTagReplacement(Blocks.BOOKSHELF, MLBlockTags.BOOKSHELVES);
        blockToBlockTagReplacement(Blocks.FARMLAND, BYGBlockTags.FARMLAND);
        blockToBlockTagReplacement(Blocks.END_STONE, BYGBlockTags.END_STONE);
    }

    public static void blockToBlockTagReplacement(Block block, TagKey<Block> blockTag) {
        BLOCKSTATE_IS_REPLACEMENTS.put(block, state -> state.is(blockTag));
    }

    public static void blockToInstanceOfReplacement(Block block, Class<? extends Block> clazz) {
        BLOCKSTATE_IS_REPLACEMENTS.put(block, state -> clazz.isInstance(state.getBlock()));
    }

    public static Map<Block, Predicate<BlockBehaviour.BlockStateBase>> getBlockstateIsReplacements() {
        return BLOCKSTATE_IS_REPLACEMENTS;
    }

    public static void attachCommands(final CommandDispatcher<CommandSourceStack> dispatcher, final Commands.CommandSelection environmentType) {
        LiteralArgumentBuilder<CommandSourceStack> bygCommands = Commands.literal(BYG.MOD_ID);
        bygCommands.then(ReloadConfigsCommand.register());
        bygCommands.then(UpdateConfigsCommand.register());
        dispatcher.register(bygCommands);
    }

    public static void threadSafeCommonLoad() {
        BYGVillagerType.setVillagerForBYGBiomes();
        appendBlocksToBlockEntities();

        DeltaFeatureAccess.byg_setCANNOT_REPLACE(
                new ImmutableList.Builder<Block>()
                        .addAll(DeltaFeatureAccess.byg_getCANNOT_REPLACE())
                        .add(BYGBlocks.EMBUR_GEL_BLOCK.get())
                        .add(BYGBlocks.EMBUR_GEL_BRANCH.get())
                        .add(BYGBlocks.EMBUR_GEL_VINES.get())
                        .addAll(Util.make(new ArrayList<>(), list -> {
                            for (Block block : Registry.BLOCK) {
                                Material material = block.defaultBlockState().getMaterial();
                                if (material == Material.PLANT || material == Material.BAMBOO ||
                                        material == Material.BAMBOO_SAPLING || material == Material.REPLACEABLE_PLANT ||
                                        material == Material.REPLACEABLE_FIREPROOF_PLANT || material == Material.REPLACEABLE_WATER_PLANT ||
                                        material == Material.LEAVES || material == Material.WOOD) {
                                    list.add(block);
                                }
                            }
                        }))
                        .build()
        );
    }

    private static void appendBlocksToBlockEntities() {
        BlockEntityTypeAccess campfireBuilderAccess = (BlockEntityTypeAccess) BlockEntityType.CAMPFIRE;
        Set<Block> validCampfireBlocks = new ObjectOpenHashSet<>(campfireBuilderAccess.byg_getValidBlocks());
        validCampfireBlocks.add(BYGBlocks.CRYPTIC_CAMPFIRE.get());
        validCampfireBlocks.add(BYGBlocks.BORIC_CAMPFIRE.get());
        campfireBuilderAccess.byg_setValidBlocks(validCampfireBlocks);

        BlockEntityTypeAccess signBuilderAccess = (BlockEntityTypeAccess) BlockEntityType.SIGN;
        Set<Block> signValidBlocks = new ObjectOpenHashSet<>(signBuilderAccess.byg_getValidBlocks());
        for (BlockRegistryObject<Block> signBlock : BYGBlocks.SIGN_BLOCKS) {
            Block block = signBlock.get();
            if (block instanceof SignBlock) {
                signValidBlocks.add(block);
            } else {
                throw new IllegalArgumentException("Attempting to add block to sign block entity that is not a type of SignBlock");
            }
        }
        signBuilderAccess.byg_setValidBlocks(signValidBlocks);
    }

    public static void threadSafeLoadFinish() {
        logDebug("BYG: \"Load Complete Event\" Starting...");
        BYGHoeables.tillablesBYG();
        BYGFlammables.flammablesBYG();
        BYGCarvableBlocks.addCarverBlocks();
        BYGFlattenables.addFlattenables();
        logDebug("BYG: \"Load Complete\" Event Complete!");
    }

    public static ResourceLocation createLocation(String path) {
        return new ResourceLocation(MOD_ID, path);
    }

    public static ResourceLocation createLocation(ResourceKey<?> path) {
        return path.location();
    }

    public static ResourceLocation createLocation(Holder<?> holder) {
        return createLocation(holder.unwrapKey().orElseThrow());
    }

    public static void logWarning(String msg) {
        SettingsConfig.LoggerSettings loggerSettings = SettingsConfig.getConfig().loggerSettings();
        if (loggerSettings.logWarnings() && loggerSettings.exclude().stream().noneMatch(msg::contains)) {
            LOGGER.warn(msg);
        }
    }

    public static void logInfo(String msg) {
        SettingsConfig.LoggerSettings loggerSettings = SettingsConfig.getConfig().loggerSettings();
        if (loggerSettings.logInfo() && loggerSettings.exclude().stream().noneMatch(msg::contains)) {
            LOGGER.info(msg);
        }
    }

    public static void logDebug(String msg) {
        SettingsConfig.LoggerSettings loggerSettings = SettingsConfig.getConfig().loggerSettings();
        if (loggerSettings.logDebug() && loggerSettings.exclude().stream().noneMatch(msg::contains)) {
            LOGGER.debug(msg);
        }
    }

    public static void logError(String msg) {
        LOGGER.error(msg);
    }

    static {
        ConfigVersionTracker.getConfig(new ConfigVersionTracker(ModPlatform.INSTANCE.configPath().toFile().exists() ? 0 : BYGConstants.CONFIG_VERSION), false);
    }
}