package potionstudios.byg.common.block.sapling;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.WritableRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import potionstudios.byg.BYG;
import potionstudios.byg.util.CommonSetupLoad;

import java.util.*;

public class BYGSapling extends SaplingBlock implements CommonSetupLoad {

    private final List<Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>>> patternsToSpawner = new ArrayList<>();
    private final String id;
    private final Tag<Block> groundTag;

    public BYGSapling(String id, Properties properties, Tag<Block> groundTag) {
        super(null, properties);
        this.id = id;
        this.groundTag = groundTag;
    }

    private void serializePatterns(ResourceLocation key) {
        Map<ResourceLocation, List<SaplingPatterns.Entry>> patterns = SaplingPatterns.getConfig().saplingPatterns();
        if (patterns.containsKey(key)) {
            List<SaplingPatterns.Entry> patternsToSpawner = new ArrayList<>(patterns.get(key));
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

            List<Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>>> patternsToSpawnerMapped = new ArrayList<>();
            for (SaplingPatterns.Entry entry : patternsToSpawner) {
                List<String> pattern = entry.pattern();
                SimpleWeightedRandomList<ResourceLocation> spawner = entry.spawners();
                Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>> newEntry = Pair.of(new ArrayList<>(), spawner);
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
            for (Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>> entry : this.patternsToSpawner) {
                for (int xMove = -range; xMove <= range; xMove++) {
                    for (int zMove = -range; zMove <= range; zMove++) {
                        boolean matchedPattern = true;
                        BlockPos.MutableBlockPos mutableBlockPos1 = new BlockPos.MutableBlockPos().set(mutableBlockPos.set(pos).move(xMove, 0, zMove));


                        List<BlockPos> offsets = entry.getFirst();
                        SimpleWeightedRandomList<ResourceLocation> treePicker = entry.getSecond();
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
                            Optional<WritableRegistry<ConfiguredFeature<?, ?>>> configuredFeaturesOptionalRegistry = world.registryAccess().ownedRegistry(Registry.CONFIGURED_FEATURE_REGISTRY);
                            if (configuredFeaturesOptionalRegistry.isPresent()) {
                                WritableRegistry<ConfiguredFeature<?, ?>> configuredFeaturesRegistry = configuredFeaturesOptionalRegistry.get();
                                Optional<ResourceLocation> randomValue = treePicker.getRandomValue(rand);
                                if (randomValue.isPresent()) {
                                    ConfiguredFeature<?, ?> configuredFeature = configuredFeaturesRegistry.get(randomValue.get());
                                    if (configuredFeature != null) {
                                        if (configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, mutableBlockPos1)) {
                                            // Clear saplings
                                            for (BlockPos offset : offsets) {
                                                BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                                                BlockState offsetState = world.getBlockState(movedPos);
                                                if (offsetState.is(BlockTags.SAPLINGS)) {
                                                    world.removeBlock(movedPos, false);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
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