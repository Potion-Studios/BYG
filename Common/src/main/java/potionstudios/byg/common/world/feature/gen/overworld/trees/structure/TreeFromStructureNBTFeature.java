package potionstudios.byg.common.world.feature.gen.overworld.trees.structure;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureManager;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.common.world.feature.gen.overworld.trees.util.BYGAbstractTreeFeature;
import potionstudios.byg.mixin.access.LeavesBlockAccess;
import potionstudios.byg.mixin.access.StructureTemplateAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class TreeFromStructureNBTFeature extends Feature<TreeFromStructureNBTConfig> {

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
        StructureManager templateManager = level.getLevel().getStructureManager();
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
        } else {
            BlockState inside = level.getBlockState(origin);
            BlockState below = level.getBlockState(origin.below());
            if (inside.is(Blocks.WATER)) {
                if (!config.allowUnderwater())
                    return false;
                // allow certain more blocks underwater (temp)
                if (!below.is(BlockTags.DIRT) && !below.is(BlockTags.SAND) &&
                        !below.is(BYGBlocks.MUD_BLOCK.get()) && !below.is(Blocks.CLAY)
                        && !below.is(Blocks.GRAVEL))
                    return false;
            }
            if (inside.canOcclude())
                return false;
            if (!below.is(config.growableOn()))
                return false;
        }
        Random random = featurePlaceContext.random();
        StructurePlaceSettings placeSettings = new StructurePlaceSettings().setRotation(Rotation.getRandom(random));
        StructureTemplate.Palette randomBasePalette = placeSettings.getRandomPalette(basePalettes, origin);
        StructureTemplate.Palette randomCanopyPalette = placeSettings.getRandomPalette(canopyPalettes, origin);

        List<StructureTemplate.StructureBlockInfo> center = randomBasePalette.blocks(Blocks.WHITE_WOOL);
        if (center.size() > 1) {
            throw new IllegalArgumentException("There cannot be more than one central position.");
        }
        BlockPos centerOffset = center.get(0).pos;
        centerOffset = new BlockPos(-centerOffset.getX(), 0, -centerOffset.getZ());

        List<StructureTemplate.StructureBlockInfo> leaves = randomCanopyPalette.blocks(config.leavesTarget());
        List<StructureTemplate.StructureBlockInfo> canopyLogs = randomCanopyPalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> logs = randomBasePalette.blocks(config.logTarget());
        List<StructureTemplate.StructureBlockInfo> logBuilders = randomBasePalette.blocks(Blocks.RED_WOOL);
        if (logBuilders.isEmpty()) {
            throw new UnsupportedOperationException(String.format("\"%s\" is missing log builders.", baseLocation));
        }

        List<StructureTemplate.StructureBlockInfo> trunkAnchor = randomBasePalette.blocks(Blocks.YELLOW_WOOL);

        int trunkLength = config.height().sample(random);
        final int maxTrunkBuildingDepth = config.maxLogDepth();

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            if (!isOnGround(config.maxLogDepth(), level, pos)) {
                return false; // Exit because all positions are not on ground.
            }

        }

        for (StructureTemplate.StructureBlockInfo logBuilder : logBuilders) {
            BlockPos pos = getModifiedPos(placeSettings, logBuilder, centerOffset, origin);
            BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos().set(pos);

            for (int i = 0; i < maxTrunkBuildingDepth; i++) {
                BlockState blockState = level.getBlockState(mutableBlockPos);
                if (!blockState.canOcclude()) {
                    level.setBlock(mutableBlockPos, logProvider.getState(featurePlaceContext.random(), mutableBlockPos), 2);
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

        for (StructureTemplate.StructureBlockInfo trunk : logs) {
            BlockPos pos = getModifiedPos(placeSettings, trunk, centerOffset, origin);
            level.setBlock(pos, getTransformedState(logProvider.getState(random, pos), trunk.state, placeSettings.getRotation()), 2);
        }

        int trunkY = 0;
        for (StructureTemplate.StructureBlockInfo trunk : trunkAnchor) {
            trunkY = trunk.pos.getY();
            BlockPos pos = getModifiedPos(placeSettings, trunk, centerOffset, origin);
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos().set(pos);

            for (int i = 0; i <= trunkLength; i++) {
                level.setBlock(mutable, logProvider.getState(random, mutable), 2);
                mutable.move(Direction.UP);
            }


        }
        {
            List<StructureTemplate.StructureBlockInfo> canopyAnchor = randomCanopyPalette.blocks(Blocks.WHITE_WOOL);
            if (center.size() > 1) {
                throw new IllegalArgumentException("There cannot be more than one central position.");
            }
            if (center.isEmpty()) {
                throw new IllegalArgumentException("Canopy is missing anchor block (yellow wool).");
            }
            StructureTemplate.StructureBlockInfo structureBlockInfo = canopyAnchor.get(0);
            BlockPos canopyCenterOffset = structureBlockInfo.pos;
            canopyCenterOffset = new BlockPos(-canopyCenterOffset.getX(), trunkY - canopyCenterOffset.getY() + trunkLength, -canopyCenterOffset.getZ());

            // some stray log
            /* BlockPos placingPos = getModifiedPos(placeSettings, structureBlockInfo, new BlockPos(0, 0, 0), origin);
            level.setBlock(placingPos, logProvider.getState(random, placingPos), 2); */

            for (StructureTemplate.StructureBlockInfo canopyLog : canopyLogs) {
                BlockPos pos = getModifiedPos(placeSettings, canopyLog, canopyCenterOffset, origin);
                level.setBlock(pos, getTransformedState(logProvider.getState(random, pos), canopyLog.state, placeSettings.getRotation()), 2);
            }

            List<Runnable> leavesPostApply = new ArrayList<>(leaves.size());
            for (StructureTemplate.StructureBlockInfo leaf : leaves) {
                BlockPos pos = getModifiedPos(placeSettings, leaf, canopyCenterOffset, origin);

                BlockState state = leavesProvider.getState(random, pos);
                if (!level.getBlockState(pos).canOcclude()) {
                    level.setBlock(pos, state, 2);
                    Runnable postProcess = () -> {
                        BlockState blockState = LeavesBlockAccess.byg_invokeUpdateDistance(state, level, pos);
                        if (blockState.getValue(LeavesBlock.DISTANCE) < LeavesBlock.DECAY_DISTANCE) {
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
        return true;
    }

    @NotNull
    private BlockState getTransformedState(BlockState state, BlockState canopyLogState, Rotation rotation) {
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
            return pos.getY() - oceanFloorHeight > maxLogDepth;
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

    private static BlockPos getModifiedPos(StructurePlaceSettings settings, StructureTemplate.StructureBlockInfo placing, BlockPos partCenter, BlockPos featureOrigin) {
        return StructureTemplate.calculateRelativePosition(settings, placing.pos).offset(featureOrigin).offset(StructureTemplate.calculateRelativePosition(settings, partCenter));
    }

    public static IllegalArgumentException noTreePartPresent(ResourceLocation location) {
        throw new IllegalArgumentException(String.format("\"%s\" is not a valid tree part.", location));
    }
}
