package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;
import potionstudios.byg.mixin.access.LeavesBlockAccess;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.util.*;

public class TreeFromStructureNBTFeature extends Feature<TreeFromStructureNBTConfig> {
    public static final Direction[] DIRECTIONS = Arrays.stream(Direction.values()).filter(direction -> direction != Direction.UP).toArray(Direction[]::new);
    public static final Direction[] VINE_GEN_DIRECTIONS = Arrays.stream(Direction.values()).filter(direction -> direction != Direction.DOWN).toArray(Direction[]::new);

    private static final boolean DEBUG = false;

    public TreeFromStructureNBTFeature(Codec<TreeFromStructureNBTConfig> $$0) {
        super($$0);
    }

    @Override
    public boolean place(FeaturePlaceContext<TreeFromStructureNBTConfig> featurePlaceContext) {
        TreeFromStructureNBTConfig config = featurePlaceContext.config();

        BlockStateProvider logProvider = config.logProvider();
        BlockStateProvider leavesProvider = config.leavesProvider();

        WorldGenLevel level = featurePlaceContext.level();
        StructureTemplateManager templateManager = level.getLevel().getStructureManager();
        ResourceLocation baseLocation = config.baseLocation();
        Optional<StructureTemplate> baseTemplateOptional = templateManager.get(baseLocation);
        ResourceLocation canopyLocation = config.canopyLocation();
        Optional<StructureTemplate> canopyTemplateOptional = templateManager.get(canopyLocation);

        if (baseTemplateOptional.isEmpty()) {
            throw noTreePartPresent(baseLocation);
        }
        if (canopyTemplateOptional.isEmpty()) {
            throw noTreePartPresent(canopyLocation);
        }
        StructureTemplate baseTemplate = baseTemplateOptional.get();
        StructureTemplate canopyTemplate = canopyTemplateOptional.get();
        List<StructureTemplate.Palette> basePalettes = ((StructureTemplateAccess) baseTemplate).byg_getPalettes();
        List<StructureTemplate.Palette> canopyPalettes = ((StructureTemplateAccess) canopyTemplate).byg_getPalettes();
        BlockPos origin = featurePlaceContext.origin();
        if (DEBUG) {
            level.setBlock(origin, Blocks.DIAMOND_BLOCK.defaultBlockState(), 2);
        }
        RandomSource random = featurePlaceContext.random();
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().setRotation(Rotation.getRandom(random));
        StructureTemplate.Palette trunkBasePalette = placeSettings.getRandomPalette(basePalettes, origin);
        StructureTemplate.Palette randomCanopyPalette = placeSettings.getRandomPalette(canopyPalettes, origin);

        List<StructureTemplate.StructureBlockInfo> center = trunkBasePalette.blocks(Blocks.WHITE_WOOL);
        if (center.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one central position.");
        }
        BlockPos centerOffset = center.get(0).pos;
        centerOffset = new BlockPos(-centerOffset.getX(), 0, -centerOffset.getZ());


        List<StructureTemplate.StructureBlockInfo> logs = trunkBasePalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> logBuilders = trunkBasePalette.blocks(Blocks.RED_WOOL);
        if (logBuilders.isEmpty()) {
            throw new UnsupportedOperationException(String.format("\"%s\" is missing log builders.", baseLocation));
        }

        Set<BlockPos> leavePositions = new HashSet<>();
        Set<BlockPos> trunkPositions = new HashSet<>();


        int trunkLength = config.height().sample(random);
        final int maxTrunkBuildingDepth = config.maxLogDepth();

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            if (!isOnGround(config.maxLogDepth(), level, pos)) {
                return false; // Exit because all positions are not on ground.
            }

        }

        fillLogsUnder(random, logProvider, level, origin, placeSettings, centerOffset, logBuilders, maxTrunkBuildingDepth);
        placeLogsWithRotation(logProvider, level, origin, random, placeSettings, centerOffset, logs, trunkPositions);
        placeCanopy(config, logProvider, leavesProvider, level, origin, random, placeSettings, randomCanopyPalette, center, leavePositions, trunkPositions, trunkLength);
        placeTreeDecorations(config.treeDecorators(), level, random, leavePositions, trunkPositions);

        return true;
    }

    private static void placeCanopy(TreeFromStructureNBTConfig config, BlockStateProvider logProvider, BlockStateProvider leavesProvider, WorldGenLevel level, BlockPos origin, RandomSource random, StructurePlaceSettings placeSettings, StructureTemplate.Palette randomCanopyPalette, List<StructureTemplate.StructureBlockInfo> center, Set<BlockPos> leavePositions, Set<BlockPos> trunkPositions, int trunkLength) {
        List<StructureTemplate.StructureBlockInfo> leaves = randomCanopyPalette.blocks(config.leavesTarget());
        List<StructureTemplate.StructureBlockInfo> canopyLogs = randomCanopyPalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> canopyAnchor = randomCanopyPalette.blocks(Blocks.WHITE_WOOL);
        if (center.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one central position.");
        }
        if (center.isEmpty()) {
            throw new IllegalArgumentException("Canopy is missing anchor block (yellow wool).");
        }
        StructureTemplate.StructureBlockInfo structureBlockInfo = canopyAnchor.get(0);
        BlockPos canopyCenterOffset = structureBlockInfo.pos;
        canopyCenterOffset = new BlockPos(-canopyCenterOffset.getX(), trunkLength, -canopyCenterOffset.getZ());

        List<StructureTemplate.StructureBlockInfo> trunkFillers = new ArrayList<>(randomCanopyPalette.blocks(Blocks.RED_WOOL));
        trunkFillers.addAll(randomCanopyPalette.blocks(Blocks.YELLOW_WOOL));
        fillLogsUnder(random, logProvider, level, origin, placeSettings, canopyCenterOffset, trunkFillers, level.getHeight());


        placeLogsWithRotation(logProvider, level, origin, random, placeSettings, canopyCenterOffset, canopyLogs, trunkPositions);

        placeLeavesWithCalculatedDistanceAndRotation(leavesProvider, level, origin, random, placeSettings, leaves, leavePositions, canopyCenterOffset);
    }

    public static void placeLogsWithRotation(BlockStateProvider logProvider, WorldGenLevel level, BlockPos origin, RandomSource random, StructurePlaceSettings placeSettings, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logs, Set<BlockPos> trunkPositions) {
        for (StructureTemplate.StructureBlockInfo trunk : logs) {
            BlockPos pos = getModifiedPos(placeSettings, trunk, centerOffset, origin);
            level.setBlock(pos, getTransformedState(logProvider.getState(random, pos), trunk.state, placeSettings.getRotation()), 2);
            trunkPositions.add(pos);
        }
    }

    public static void placeTreeDecorations(Iterable<TreeDecorator> treeDecorators, WorldGenLevel level, RandomSource random, Set<BlockPos> leavePositions, Set<BlockPos> trunkPositions) {
        for (TreeDecorator treeDecorator : treeDecorators) {
            treeDecorator.place(new TreeDecorator.Context(level, (pos, state) -> level.setBlock(pos, state, 2), random, trunkPositions, leavePositions, new HashSet<>()));
        }
    }

    public static void placeLeavesWithCalculatedDistanceAndRotation(BlockStateProvider leavesProvider, WorldGenLevel level, BlockPos origin, RandomSource random, StructurePlaceSettings placeSettings, List<StructureTemplate.StructureBlockInfo> leaves, Set<BlockPos> leavePositions, BlockPos canopyCenterOffset) {
        List<Runnable> leavesPostApply = new ArrayList<>(leaves.size());
        for (StructureTemplate.StructureBlockInfo leaf : leaves) {
            BlockPos pos = getModifiedPos(placeSettings, leaf, canopyCenterOffset, origin);

            BlockState state = leavesProvider.getState(random, pos);

            if (state.hasProperty(LeavesBlock.DISTANCE) && leaf.state.hasProperty(LeavesBlock.DISTANCE)) {
                state = state.setValue(LeavesBlock.DISTANCE, leaf.state.getValue(LeavesBlock.DISTANCE));
            }

            if (!level.getBlockState(pos).canOcclude()) {
                level.setBlock(pos, state, 2);
                BlockState finalState = state;
                Runnable postProcess = () -> {
                    BlockState blockState = LeavesBlockAccess.byg_invokeUpdateDistance(finalState, level, pos);
                    if (blockState.getValue(LeavesBlock.DISTANCE) < LeavesBlock.DECAY_DISTANCE) {
                        leavePositions.add(pos);
                        level.setBlock(pos, blockState, 2);
                        level.scheduleTick(pos, blockState.getBlock(), 0);
                    } else {
                        level.removeBlock(pos, false);
                    }
                };
                leavesPostApply.add(postProcess);
            }
        }
        leavesPostApply.forEach(Runnable::run);
    }

    public static void fillLogsUnder(RandomSource randomSource, BlockStateProvider logProvider, WorldGenLevel level, BlockPos origin, StructurePlaceSettings placeSettings, BlockPos centerOffset, List<StructureTemplate.StructureBlockInfo> logBuilders, int maxTrunkBuildingDepth) {
        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);

            for (int i = 0; i < maxTrunkBuildingDepth; i++) {
                BlockState blockState = level.getBlockState(mutableBlockPos);
                if (!blockState.canOcclude()) {
                    level.setBlock(mutableBlockPos, logProvider.getState(randomSource, mutableBlockPos), 2);
                    mutableBlockPos.move(Direction.DOWN);
                } else {
                    Block block = blockState.getBlock();
                    if (BYGAbstractTreeFeature.SPREADABLE_TO_NON_SPREADABLE.containsKey(block)) {
                        level.setBlock(mutableBlockPos, BYGAbstractTreeFeature.SPREADABLE_TO_NON_SPREADABLE.get(block).defaultBlockState(), 2);
                    }
                    break;
                }
            }
        }
    }


    @NotNull
    private static BlockState getTransformedState(BlockState state, BlockState canopyLogState, Rotation rotation) {
        for (Property property : state.getProperties()) {
            if (canopyLogState.hasProperty(property)) {
                Comparable value = canopyLogState.getValue(property);
                state = state.setValue(property, value);
            }
        }

        if (state.hasProperty(RotatedPillarBlock.AXIS)) {
            Direction.Axis axis = state.getValue(RotatedPillarBlock.AXIS);
            if (axis.isHorizontal()) {
                if (rotation == Rotation.CLOCKWISE_90 || rotation == Rotation.COUNTERCLOCKWISE_90) {
                    if (axis == Direction.Axis.X) {
                        state = state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.Z);
                    } else if (axis == Direction.Axis.Z) {
                        state = state.setValue(RotatedPillarBlock.AXIS, Direction.Axis.X);
                    }
                }
            }
        }
        return state;
    }

    private static boolean isOnGround(int maxLogDepth, WorldGenLevel level, BlockPos pos) {
        int oceanFloorHeight = level.getHeight(Heightmap.Types.OCEAN_FLOOR_WG, pos.getX(), pos.getZ());
        if (pos.getY() > oceanFloorHeight) {
            return pos.getY() - oceanFloorHeight < maxLogDepth;
        }

        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);
        int logDepth;
        for (logDepth = 0; logDepth < maxLogDepth; logDepth++) {
            mutableBlockPos.move(Direction.DOWN);
            BlockState blockState = level.getBlockState(mutableBlockPos);
            // TODO: Use a tag!
            if (!blockState.getMaterial().isReplaceable()) {
                return true;
            }
        }

        return false;
    }

    public static BlockPos getModifiedPos(StructurePlaceSettings settings, StructureTemplate.StructureBlockInfo placing, BlockPos partCenter, BlockPos featureOrigin) {
        return StructureTemplate.calculateRelativePosition(settings, placing.pos).offset(featureOrigin).offset(StructureTemplate.calculateRelativePosition(settings, partCenter));
    }

    public static IllegalArgumentException noTreePartPresent(ResourceLocation location) {
        throw new IllegalArgumentException(String.format("\"%s\" is not a valid tree part.", location));
    }
}
