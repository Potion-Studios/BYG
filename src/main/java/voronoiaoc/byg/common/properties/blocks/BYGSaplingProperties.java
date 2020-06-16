package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import voronoiaoc.byg.common.properties.blocks.spreadablesnowyblocks.SpreadableSythianBlock;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGTree;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BYGSaplingProperties extends PlantBlock implements Fertilizable {
    public static final VoxelShape SHAPE = Block.createCuboidShape(2.0D, 0.0D, 2.0D, 14.0D, 12.0D, 14.0D);
    public static final IntProperty STAGE = Properties.STAGE;
    private final BYGTree tree;

    public BYGSaplingProperties(BYGTree tree, String registryName) {
        super(Settings.of(Material.PLANT)
                .sounds(BlockSoundGroup.STEM)
                .strength(0.0f)
                .noCollision()
                .ticksRandomly()
        );
        this.tree = tree;
        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, Integer.valueOf(0)));
        Registry.register(Registry.BLOCK, new Identifier("byg", registryName), this);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        Block block = floor.getBlock();
        return block == Blocks.GRASS_BLOCK || block == Blocks.DIRT || block == Blocks.COARSE_DIRT || block == Blocks.PODZOL || block == Blocks.FARMLAND || block == BYGBlockList.OVERGROWN_STONE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!SpreadableSythianBlock.isAreaLoaded(pos, 1, world))
            return;
        if (world.getLightLevel(pos.up()) >= 9 && random.nextInt(7) == 0) {
            this.grow(world, random, pos, state);
        }
    }

    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return true;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        if (state.get(STAGE) == 0) {
            world.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.spawn(world, world.getChunkManager().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}