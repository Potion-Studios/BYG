package corgiaoc.byg.mixin;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.IClearable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Mixin(Template.class)
public abstract class MixinTemplate {


    @Shadow
    @Final
    private List<Template.Palette> blocks;

    @Shadow
    @Final
    private List<Template.EntityInfo> entities;

    @Shadow
    private BlockPos size;

    @Shadow
    protected abstract void addEntitiesToWorld(IServerWorld p_237143_1_, BlockPos p_237143_2_, PlacementSettings placementIn);

    /**
     * @author
     */
    @Overwrite
    public boolean func_237146_a_(IServerWorld world, BlockPos featurePos, BlockPos pos2, PlacementSettings settings, Random rand, int flags) {
        if (this.blocks.isEmpty()) {
            return false;
        } else {
            List<Template.BlockInfo> list = settings.func_237132_a_(blocks, featurePos).func_237157_a_();
            if ((!list.isEmpty() || !settings.getIgnoreEntities() && !entities.isEmpty()) && size.getX() >= 1 && this.size.getY() >= 1 && this.size.getZ() >= 1) {
                MutableBoundingBox mutableboundingbox = settings.getBoundingBox();
                List<BlockPos> list1 = Lists.newArrayListWithCapacity(settings.func_204763_l() ? list.size() : 0);
                List<Pair<BlockPos, CompoundNBT>> list2 = Lists.newArrayListWithCapacity(list.size());
                int i = Integer.MAX_VALUE;
                int j = Integer.MAX_VALUE;
                int k = Integer.MAX_VALUE;
                int l = Integer.MIN_VALUE;
                int i1 = Integer.MIN_VALUE;
                int j1 = Integer.MIN_VALUE;

                for (Template.BlockInfo template$blockinfo : Template.processBlockInfos(world, featurePos, pos2, settings, list, (Template) (Object) this)) {
                    BlockPos blockpos = template$blockinfo.pos;
                    if (mutableboundingbox == null || mutableboundingbox.isVecInside(blockpos)) {
                        FluidState fluidstate = settings.func_204763_l() ? world.getFluidState(blockpos) : null;
                        BlockState blockstate = template$blockinfo.state.mirror(settings.getMirror()).rotate(settings.getRotation());
                        if (template$blockinfo.nbt != null) {
                            TileEntity tileentity = world.getTileEntity(blockpos);
                            IClearable.clearObj(tileentity);
                            world.setBlockState(blockpos, Blocks.BARRIER.getDefaultState(), 20);
                        }

                        if (world.setBlockState(blockpos, blockstate, flags)) {
                            i = Math.min(i, blockpos.getX());
                            j = Math.min(j, blockpos.getY());
                            k = Math.min(k, blockpos.getZ());
                            l = Math.max(l, blockpos.getX());
                            i1 = Math.max(i1, blockpos.getY());
                            j1 = Math.max(j1, blockpos.getZ());
                            list2.add(Pair.of(blockpos, template$blockinfo.nbt));
                            if (template$blockinfo.nbt != null) {
                                TileEntity tileentity1 = world.getTileEntity(blockpos);
                                if (tileentity1 != null) {
                                    template$blockinfo.nbt.putInt("x", blockpos.getX());
                                    template$blockinfo.nbt.putInt("y", blockpos.getY());
                                    template$blockinfo.nbt.putInt("z", blockpos.getZ());
                                    if (tileentity1 instanceof LockableLootTileEntity) {
                                        template$blockinfo.nbt.putLong("LootTableSeed", rand.nextLong());
                                    }

                                    tileentity1.read(template$blockinfo.state, template$blockinfo.nbt);
                                    tileentity1.mirror(settings.getMirror());
                                    tileentity1.rotate(settings.getRotation());
                                }
                            }

                            if (fluidstate != null && blockstate.getBlock() instanceof ILiquidContainer) {
                                ((ILiquidContainer) blockstate.getBlock()).receiveFluid(world, blockpos, blockstate, fluidstate);
                                if (!fluidstate.isSource()) {
                                    list1.add(blockpos);
                                }
                            }
                        }
                    }
                }

                boolean flag = true;
                Direction[] adirection = new Direction[]{Direction.UP, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

                while (flag && !list1.isEmpty()) {
                    flag = false;
                    Iterator<BlockPos> iterator = list1.iterator();

                    while (iterator.hasNext()) {
                        BlockPos blockpos2 = iterator.next();
                        BlockPos blockpos3 = blockpos2;
                        FluidState fluidstate2 = world.getFluidState(blockpos2);

                        for (int k1 = 0; k1 < adirection.length && !fluidstate2.isSource(); ++k1) {
                            BlockPos blockpos1 = blockpos3.offset(adirection[k1]);
                            FluidState fluidstate1 = world.getFluidState(blockpos1);
                            if (fluidstate1.getActualHeight(world, blockpos1) > fluidstate2.getActualHeight(world, blockpos3) || fluidstate1.isSource() && !fluidstate2.isSource()) {
                                fluidstate2 = fluidstate1;
                                blockpos3 = blockpos1;
                            }
                        }

                        if (fluidstate2.isSource()) {
                            BlockState blockstate2 = world.getBlockState(blockpos2);
                            Block block = blockstate2.getBlock();
                            if (block instanceof ILiquidContainer) {
                                ((ILiquidContainer) block).receiveFluid(world, blockpos2, blockstate2, fluidstate2);
                                flag = true;
                                iterator.remove();
                            }
                        }
                    }
                }

                if (i <= l) {
                    if (!settings.func_215218_i()) {
                        VoxelShapePart voxelshapepart = new BitSetVoxelShapePart(l - i + 1, i1 - j + 1, j1 - k + 1);
                        int l1 = i;
                        int i2 = j;
                        int j2 = k;

                        for (Pair<BlockPos, CompoundNBT> pair1 : list2) {
                            BlockPos blockpos5 = pair1.getFirst();
                            voxelshapepart.setFilled(blockpos5.getX() - l1, blockpos5.getY() - i2, blockpos5.getZ() - j2, true, true);
                        }

                        Template.func_222857_a(world, flags, voxelshapepart, l1, i2, j2);
                    }

                    for (Pair<BlockPos, CompoundNBT> pair : list2) {
                        BlockPos blockpos4 = pair.getFirst();
                        if (!settings.func_215218_i()) {
                            BlockState blockstate1 = world.getBlockState(blockpos4);
                            BlockState blockstate3 = Block.getValidBlockForPosition(blockstate1, world, blockpos4);
                            if (blockstate1 != blockstate3) {
                                world.setBlockState(blockpos4, blockstate3, flags & -2 | 16);
                            }

                            world.func_230547_a_(blockpos4, blockstate3.getBlock());
                        }

                        if (pair.getSecond() != null) {
                            TileEntity tileentity2 = world.getTileEntity(blockpos4);
                            if (tileentity2 != null) {
                                tileentity2.markDirty();
                            }
                        }
                    }
                }

                if (!settings.getIgnoreEntities()) {
                    addEntitiesToWorld(world, featurePos, settings);
                }

                List<String> treeLeaveList = new ArrayList<>();
                List<String> trunkLogList = new ArrayList<>();
                List<String> treeBranchList = new ArrayList<>();
                final int stopppp = 1;
                list2.forEach(o -> {
                    int featureX = o.getFirst().getX();
                    int featureY = o.getFirst().getY() - featurePos.getY();
                    int realY = o.getFirst().getY();
                    int realZ = o.getFirst().getZ();
                    BlockPos pos = new BlockPos(featureX, realY, realZ);
                    BlockState state = world.getBlockState(pos);

                    Block blockCheck = state.getBlock();
                    int modifiedY = featureY;
                    //|| pos.getX() == 0 && pos.getZ() == 1 || pos.getX() == 0 && pos.getZ() == -1 || pos.getX() == 1 && pos.getZ() == 0 || pos.getX() == -1 && pos.getZ() == 0
                    if (blockCheck.getRegistryName().toString().contains("log") && pos.getX() == 0 && pos.getZ() == 0) {
                        trunkLogList.add("placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(" + featureX + ", " + modifiedY + ", " + realZ + "), boundsIn);");
                    } else if (blockCheck.getRegistryName().toString().contains("log")) {
                        treeBranchList.add("placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(" + featureX + ", " + modifiedY + ", " + realZ + "), boundsIn);");
                    }

                    if (state.hasProperty(BlockStateProperties.DISTANCE_1_7) && state.get(BlockStateProperties.DISTANCE_1_7) <= 6) {
                        if (blockCheck.getRegistryName().toString().contains("leaves")) {
                            treeLeaveList.add("placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(" + featureX + ", " + modifiedY + ", " + realZ + "), boundsIn);");
                        }
                    }
                });
                trunkLogList.forEach(System.out::println);
                treeBranchList.forEach(System.out::println);
                treeLeaveList.forEach(System.out::println);

                return true;
            } else {
                return false;
            }
        }
    }
}