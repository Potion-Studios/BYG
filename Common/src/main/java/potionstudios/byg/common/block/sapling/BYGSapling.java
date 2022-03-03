package potionstudios.byg.common.block.sapling;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.util.BYGUtil;
import potionstudios.byg.util.CommonSetupLoad;

import java.util.*;

public class BYGSapling extends SaplingBlock implements CommonSetupLoad {

    public static final List<CommonSetupLoad> SERIALIZERS = new ArrayList<>();

    private final List<Pair<List<BlockPos>, SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner>>> patternsToSpawner = new ArrayList<>();
    private final String id;
    private final TagKey<Block> groundTag;

    public BYGSapling(String id, Properties properties, TagKey<Block> groundTag) {
        super(null, properties);
        this.id = id;
        this.groundTag = groundTag;
        SERIALIZERS.add(this);
    }

    private void serializePatterns(ResourceLocation key) {
        this.patternsToSpawner.clear();
        Map<ResourceLocation, List<SaplingPatterns.PatternEntry>> patterns = SaplingPatterns.getConfig().saplingPatterns();
        if (patterns.containsKey(key)) {
            List<SaplingPatterns.PatternEntry> patternsToSpawner = new ArrayList<>(patterns.get(key));
            patternsToSpawner.sort(Comparator.comparingInt(p -> {
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

            List<Pair<List<BlockPos>, SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner>>> patternsToSpawnerMapped = new ArrayList<>();
            for (SaplingPatterns.PatternEntry patternEntry : patternsToSpawner) {
                List<String> pattern = patternEntry.pattern();
                SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner> spawner = patternEntry.spawners();
                Pair<List<BlockPos>, SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner>> newEntry = Pair.of(new ArrayList<>(), spawner);
                patternsToSpawnerMapped.add(newEntry);
                int patternLoopSize = Math.min(pattern.size(), SaplingPatterns.MAX_PATTERN_SIZE);

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < patternLoopSize; i++) {
                    String s = pattern.get(i);
                    String substring = s.substring(0, Math.min(s.length(), SaplingPatterns.MAX_PATTERN_SIZE));
                    builder.append(substring);
                }

                String patternCombined = builder.toString();

                String trimmed = patternCombined.trim();
                if (trimmed.length() > 1) {
                    int zOffset = -patternLoopSize / 2;
                    for (int i = 0; i < patternLoopSize; i++) {
                        String s = pattern.get(i);
                        int range = Math.min(s.length(), SaplingPatterns.MAX_PATTERN_SIZE);
                        String substring = s.substring(0, range);
                        int xOffset = -range / 2;
                        char[] charArray = substring.toCharArray();
                        for (char c : charArray) {
                            if (c == 'x' || c == 'X') {
                                newEntry.getFirst().add(new BlockPos(xOffset, 0, zOffset));
                            }
                            xOffset++;
                        }
                        zOffset++;
                    }
                } else {
                    newEntry.getFirst().add(new BlockPos(0, 0, 0));
                }
            }
            this.patternsToSpawner.addAll(patternsToSpawnerMapped);
            Collections.reverse(this.patternsToSpawner);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return state.is(this.groundTag);
    }

    @Override
    public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            int range = (SaplingPatterns.MAX_PATTERN_SIZE - 1) / 2;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);
            for (Pair<List<BlockPos>, SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner>> entry : this.patternsToSpawner) {
                for (int xMove = -range; xMove <= range; xMove++) {
                    for (int zMove = -range; zMove <= range; zMove++) {
                        boolean matchedPattern = true;
                        BlockPos.MutableBlockPos mutableBlockPos1 = new BlockPos.MutableBlockPos().set(mutableBlockPos.set(pos).move(xMove, 0, zMove));


                        List<BlockPos> offsets = entry.getFirst();
                        SimpleWeightedRandomList<SaplingPatterns.FeatureSpawner> treePicker = entry.getSecond();
                        for (BlockPos offset : offsets) {
                            BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                            BlockState offsetState = world.getBlockState(movedPos);
                            if (offsetState.getBlock() != this) {
                                matchedPattern = false;
                                break;
                            }
                        }
                        if (matchedPattern) {
                            // Set tree
                            Optional<Registry<ConfiguredFeature<?, ?>>> configuredFeaturesOptionalRegistry = world.registryAccess().ownedRegistry(Registry.CONFIGURED_FEATURE_REGISTRY);
                            if (configuredFeaturesOptionalRegistry.isPresent()) {
                                Registry<ConfiguredFeature<?, ?>> configuredFeaturesRegistry = configuredFeaturesOptionalRegistry.get();
                                Optional<SaplingPatterns.FeatureSpawner> randomValue = treePicker.getRandomValue(rand);
                                if (randomValue.isPresent()) {
                                    SaplingPatterns.FeatureSpawner featureSpawner = randomValue.get();
                                    ConfiguredFeature<?, ?> configuredFeature = configuredFeaturesRegistry.get(featureSpawner.spawnerID());
                                    if (configuredFeature != null) {
                                        BlockPos spawnOffset = featureSpawner.spawnOffset();
                                        BlockPos growthPos = mutableBlockPos1.offset(spawnOffset);
                                        if (configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, growthPos)) {
                                            // Clear saplings
                                            for (BlockPos offset : offsets) {
                                                BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                                                BlockState offsetState = world.getBlockState(movedPos);
                                                if (offsetState.getBlock() == this) {
                                                    world.removeBlock(movedPos, false);
                                                }
                                            }
                                            if (SaplingPatterns.getConfig().logSaplingGrowth()) {
                                                BYG.LOGGER.info(String.format("Sapling \"%s\" grew configured feature \"%s\" at position %s(growth offset: %s).", Registry.BLOCK.getKey(this).toString(), featureSpawner.toString(), growthPos, spawnOffset));
                                            }
                                        }
                                    } else {
                                        BYG.LOGGER.error(String.format("Sapling: \"%s\" failed when attempting to spawn configured feature \"%s\" at position %s. \"%s\" is not a valid configured feature ID in this world's datapack configured feature registry! Valid entries:\n %s", Registry.BLOCK.getKey(this).toString(), featureSpawner, pos, featureSpawner, BYGUtil.dumpRegistry(configuredFeaturesRegistry)));
                                    }
                                }
                            }
                            return;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void load() {
        serializePatterns(BYG.createLocation(id));
    }
}