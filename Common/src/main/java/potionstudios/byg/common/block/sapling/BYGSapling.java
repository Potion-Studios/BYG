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
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.overworld.trees.util.TreeSpawner;

import java.util.*;

public class BYGSapling extends SaplingBlock {

    private final List<Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>>> patternsToSpawner = new ArrayList<>();
    private final String id;
    private boolean patternsSerialized;
    private final Tag<Block> groundTag;
    private final TreeSpawner tree;

    public BYGSapling(String id, Properties properties, Tag<Block> groundTag, TreeSpawner tree) {
        super(null, properties);
        this.id = id;
        this.groundTag = groundTag;
        this.tree = tree;
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
                        if (aChar == 'x') {
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

                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < Math.min(pattern.size(), 2); i++) {
                    String s = pattern.get(i);
                    String substring = s.substring(0, Math.min(2, s.length()));
                    builder.append(substring);
                }

                String patternCombined = builder.toString();

                String trimmed = patternCombined.trim();
                if (trimmed.length() > 1) {
                    for (int i = -1; i < Math.min(pattern.size(), 2); i++) {
                        String s = pattern.get(i + 1);
                        String substring = s.substring(0, Math.min(3, s.length()));
                        builder.append(substring);
                        char[] charArray = substring.toCharArray();
                        for (int j = -1; j < charArray.length - 1; j++) {
                            char c = charArray[j + 1];
                            if (c == 'x') {
                                newEntry.getFirst().add(new BlockPos(j, 0, i));
                            }
                        }
                    }
                } else {
                    newEntry.getFirst().add(new BlockPos(0, 0, 0));
                }
            }
            this.patternsToSpawner.addAll(patternsToSpawnerMapped);
        }
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter worldIn, BlockPos pos) {
        return this == BYGBlocks.PALM_SAPLING ? state.is(BlockTags.SAND) && state.is(this.groundTag) : state.is(this.groundTag);
    }

    @Override
    public void advanceTree(ServerLevel world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        } else {
            if (!this.patternsSerialized) {
                ResourceLocation key = new ResourceLocation(BYG.MOD_ID, id);
                serializePatterns(key);
                this.patternsSerialized = true;
            }

            int range = 1;
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);

            for (int xMove = -range; xMove <= range; xMove++) {
                for (int zMove = -range; zMove <= range; zMove++) {
                    boolean matchedPattern = true;
                    BlockPos.MutableBlockPos mutableBlockPos1 = new BlockPos.MutableBlockPos().set(mutableBlockPos.set(pos).move(xMove, 0, zMove));


                    for (Pair<List<BlockPos>, SimpleWeightedRandomList<ResourceLocation>> entry : this.patternsToSpawner) {
                        List<BlockPos> offsets = entry.getFirst();
                        SimpleWeightedRandomList<ResourceLocation> treePicker = entry.getSecond();
                        for (BlockPos offset : offsets) {
                            BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                            BlockState offsetState = world.getBlockState(movedPos);
                            if (offsetState.getBlock() != this) {
                                matchedPattern = false;
                            }
                        }
                        if (matchedPattern) {
                            // Clear saplings
                            for (BlockPos offset : offsets) {
                                BlockPos.MutableBlockPos movedPos = mutableBlockPos1.set(mutableBlockPos).move(offset);
                                world.removeBlock(movedPos, false);
                            }

                            // Set tree
                            Optional<WritableRegistry<ConfiguredFeature<?, ?>>> configuredFeaturesOptionalRegistry = world.registryAccess().ownedRegistry(Registry.CONFIGURED_FEATURE_REGISTRY);
                            if (configuredFeaturesOptionalRegistry.isPresent()) {
                                WritableRegistry<ConfiguredFeature<?, ?>> configuredFeaturesRegistry = configuredFeaturesOptionalRegistry.get();
                                Optional<ResourceLocation> randomValue = treePicker.getRandomValue(rand);
                                if (randomValue.isPresent()) {
                                    ConfiguredFeature<?, ?> configuredFeature = configuredFeaturesRegistry.get(randomValue.get());
                                    if (configuredFeature != null) {
                                        configuredFeature.place(world, world.getChunkSource().getGenerator(), rand, mutableBlockPos1);
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