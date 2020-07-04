package voronoiaoc.byg.common.properties.blocks;

import net.minecraft.block.*;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import voronoiaoc.byg.BYG;
import voronoiaoc.byg.common.world.feature.features.overworld.mushrooms.util.BYGHugeMushroom;
import voronoiaoc.byg.core.byglists.BYGBlockList;

import java.util.Random;

public class BYGMushroomBlock extends PlantBlock implements Fertilizable {
    protected static final VoxelShape SHAPE = Block.createCuboidShape(5.0D, 0.0D, 5.0D, 11.0D, 6.0D, 11.0D);
    private final BYGHugeMushroom mushroom;

    public BYGMushroomBlock(BYGHugeMushroom mushroom, String registryName) {
        super(AbstractBlock.Settings.of(Material.PLANT)
                .sounds(BlockSoundGroup.GRASS)
                .strength(0.0f)
                .noCollision()
                .ticksRandomly()
        );
        this.mushroom = mushroom;
        Registry.register(Registry.BLOCK, new Identifier(BYG.MODID, registryName), this);

    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOpaqueFullCube(world, pos);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public boolean canPlaceAt(BlockState state, WorldView worldIn, BlockPos pos) {
        BlockPos blockpos = pos.down();
        BlockState blockstate = worldIn.getBlockState(blockpos);
        Block block = blockstate.getBlock();
        if (block != Blocks.MYCELIUM && block != Blocks.PODZOL && block != BYGBlockList.GLOWCELIUM && block != BYGBlockList.OVERGROWN_NETHERRACK && block != BYGBlockList.EMBUR_NYLIUM && block != BYGBlockList.SYTHIAN_NYLIUM) {
            return worldIn.getBaseLightLevel(pos, 0) < 13 && this.canPlantOnTop(state, worldIn, pos);
        } else {
            return true;
        }
    }

    @Override
    public void randomDisplayTick(BlockState state, World worldIn, BlockPos pos, Random rand) {
        if (rand.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for (BlockPos blockpos : BlockPos.iterate(pos.add(-4, -1, -4), pos.add(4, 1, 4))) {
                if (worldIn.getBlockState(blockpos).getBlock() == this) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);

            for (int k = 0; k < 4; ++k) {
                if (worldIn.isAir(blockpos1) && state.canPlaceAt(worldIn, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(2) - rand.nextInt(2), rand.nextInt(3) - 1);
            }

            if (worldIn.isAir(blockpos1) && state.canPlaceAt(worldIn, blockpos1)) {
                worldIn.setBlockState(blockpos1, state, 2);
            }
        }
    }

    public void grow(ServerWorld worldIn, BlockPos pos, BlockState state, Random rand) {
        worldIn.removeBlock(pos, false);
        this.mushroom.spawn(worldIn, worldIn.getChunkManager().getChunkGenerator(), pos, state, rand);
    }



    @Override
    public boolean isFertilizable(BlockView world, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World world, Random random, BlockPos pos, BlockState state) {
        return (double) world.random.nextFloat() < 0.25D;
    }

    @Override
    public void grow(ServerWorld world, Random rand, BlockPos pos, BlockState state) {
        this.grow(world, pos, state, rand);
    }
}