package potionstudios.byg.util;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.Vec3i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.sapling.GrowingPatterns;

import java.util.*;
import java.util.function.Supplier;

public interface FeatureGrowerFromBlockPattern {

    List<Supplier<? extends FeatureGrowerFromBlockPattern>> ENTRIES = new ArrayList<>();

    default void load(Block block) {
        this.serializePatterns(Registry.BLOCK.getKey(block));
    }

    ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> getPatterns();

    void setPatterns(ImmutableList<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> map);


    default void serializePatterns(ResourceLocation key) {
        List<Pair<List<Vec3i>, SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner>>> list = new ArrayList<>();

        GrowingPatterns.getConfig().getPatterns(key).map(ArrayList::new).ifPresent(growingPatternEntries -> {
            growingPatternEntries.sort(Comparator.comparingInt(p -> {
                int saplingCount = 0;
                for (String s : p.pattern()) {
                    char[] chars = s.toCharArray();
                    for (char aChar : chars) {
                        if (aChar == 'x' || aChar == 'X') {
                            saplingCount++;
                        }
                    }
                }
                return saplingCount;
            }));

            for (GrowingPatterns.GrowingPatternEntry growingPatternEntry : growingPatternEntries) {
                List<String> pattern = growingPatternEntry.pattern();
                List<Vec3i> offsets = new ArrayList<>();
                int patternLoopSize = Math.min(pattern.size(), GrowingPatterns.MAX_PATTERN_SIZE);

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < patternLoopSize; i++) {
                    String s = pattern.get(i);
                    String substring = s.substring(0, Math.min(s.length(), GrowingPatterns.MAX_PATTERN_SIZE));
                    builder.append(substring);
                }

                String patternCombined = builder.toString();

                String trimmed = patternCombined.trim();
                if (trimmed.length() > 1) {
                    int zOffset = -patternLoopSize / 2;
                    for (int i = 0; i < patternLoopSize; i++) {
                        String s = pattern.get(i);
                        int range = Math.min(s.length(), GrowingPatterns.MAX_PATTERN_SIZE);
                        String substring = s.substring(0, range);
                        int xOffset = -range / 2;
                        char[] charArray = substring.toCharArray();
                        for (char c : charArray) {
                            if (c == 'x' || c == 'X') {
                                offsets.add(new Vec3i(xOffset, 0, zOffset));
                            }
                            xOffset++;
                        }
                        zOffset++;
                    }
                } else {
                    offsets.add(Vec3i.ZERO);
                }
                list.add(Pair.of(offsets, growingPatternEntry.spawners()));
            }
        });
        Collections.reverse(list);

        this.setPatterns(ImmutableList.copyOf(list));
    }

    default boolean growFeature(Block block, ServerLevel level, BlockPos pos, RandomSource rand) {
        BlockPos.MutableBlockPos mutableBlockPos = pos.mutable();
        int range = (GrowingPatterns.MAX_PATTERN_SIZE - 1) / 2;

        for (var entry : this.getPatterns()) {
            for (int xMove = -range; xMove <= range; xMove++) {
                for (int zMove = -range; zMove <= range; zMove++) {
                    BlockPos.MutableBlockPos mutableBlockPos1 = new BlockPos.MutableBlockPos().set(mutableBlockPos.set(pos).move(xMove, 0, zMove));

                    List<Vec3i> offsets = entry.getFirst();
                    SimpleWeightedRandomList<GrowingPatterns.FeatureSpawner> treePicker = entry.getSecond();

                    boolean matchedPattern = FeatureGrowerFromBlockPattern.patternMatches(level, offsets, mutableBlockPos1, mutableBlockPos, block, false);
                    boolean rotated = false;

                    if (!matchedPattern && FeatureGrowerFromBlockPattern.patternMatches(level, offsets, mutableBlockPos1, mutableBlockPos, block, true)) {
                        matchedPattern = true;
                        rotated = true;
                    }


                    if (matchedPattern) {

                        // Set tree
                        Optional<Registry<ConfiguredFeature<?, ?>>> configuredFeaturesOptionalRegistry = level.registryAccess().ownedRegistry(Registry.CONFIGURED_FEATURE_REGISTRY);
                        if (configuredFeaturesOptionalRegistry.isPresent()) {
                            Registry<ConfiguredFeature<?, ?>> configuredFeaturesRegistry = configuredFeaturesOptionalRegistry.get();
                            Optional<GrowingPatterns.FeatureSpawner> randomValue = treePicker.getRandomValue(rand);
                            if (randomValue.isPresent()) {
                                GrowingPatterns.FeatureSpawner featureSpawner = randomValue.get();
                                ConfiguredFeature<?, ?> configuredFeature = configuredFeaturesRegistry.get(featureSpawner.spawnerID());
                                if (configuredFeature != null) {
                                    Vec3i spawnOffset = featureSpawner.spawnOffset();
                                    BlockPos growthPos = mutableBlockPos1.offset(spawnOffset);
                                    if (configuredFeature.place(level, level.getChunkSource().getGenerator(), rand, growthPos)) {
                                        // Clear saplings
                                        for (Vec3i offset : offsets) {
                                            if (rotated) {
                                                offset = new Vec3i(offset.getZ(), offset.getY(), offset.getX());
                                            }

                                            BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                                            BlockState offsetState = level.getBlockState(movedPos);
                                            if (offsetState.is(block)) {
                                                level.removeBlock(movedPos, false);
                                            }
                                        }
                                        if (GrowingPatterns.getConfig().logGrowth()) {
                                            BYG.LOGGER.info(String.format("Grower \"%s\" grew configured feature \"%s\" at position %s(growth offset: %s).", Registry.BLOCK.getKey(block).toString(), featureSpawner.toString(), growthPos, spawnOffset));
                                        }
                                        return true;
                                    } else {
                                        if (GrowingPatterns.getConfig().logGrowth()) {
                                            BYG.LOGGER.info(String.format("Grower \"%s\" couldn't grow configured feature \"%s\" at position %s(growth offset: %s).", Registry.BLOCK.getKey(block).toString(), featureSpawner.toString(), growthPos, spawnOffset));
                                        }
                                    }
                                } else {
                                    BYG.LOGGER.error(String.format("Grower \"%s\" failed when attempting to spawn configured feature \"%s\" at position %s. \"%s\" is not a valid configured feature ID in this world's datapack configured feature registry! Valid entries:\n %s", Registry.BLOCK.getKey(block).toString(), featureSpawner, pos, featureSpawner, BYGUtil.dumpRegistry(configuredFeaturesRegistry)));
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    static boolean patternMatches(ServerLevel level, List<Vec3i> offsets, BlockPos.MutableBlockPos mutableBlockPos, BlockPos pos, Block block, boolean rotated) {
        for (Vec3i offset : offsets) {
            if (rotated) {
                offset = new Vec3i(offset.getZ(), offset.getY(), offset.getX());
            }

            mutableBlockPos.set(pos).move(offset);
            BlockState offsetState = level.getBlockState(mutableBlockPos);

            if (!offsetState.is(block)) {
                return false;
            }
        }

        return true;
    }
}