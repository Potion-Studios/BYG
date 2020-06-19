package voronoiaoc.byg.mixin.common.world.misc;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.fluid.IFluidState;
import net.minecraft.inventory.IClearable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.feature.template.PlacementSettings;
import net.minecraft.world.gen.feature.template.Template;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mixin(Template.class)
public class MixinTemplate {

    @Shadow
    public List<List<Template.BlockInfo>> blocks;

    @Final
    @Shadow
    private List<Template.EntityInfo> entities;

    @Shadow
    private BlockPos size;
    /**
     * @author CorgiTaco
     * @Reason Don't worry about it.
     */
    @Overwrite
    public boolean addBlocksToWorld(IWorld worldIn, BlockPos featurePos, PlacementSettings placementIn, int flags) {
        if (this.blocks.isEmpty()) {
            return false;
        } else {
            List<Template.BlockInfo> list = placementIn.func_227459_a_(this.blocks, featurePos);
            if ((!list.isEmpty() || !placementIn.getIgnoreEntities() && !this.entities.isEmpty()) && this.size.getX() >= 1 && this.size.getY() >= 1 && this.size.getZ() >= 1) {
                MutableBoundingBox mutableboundingbox = placementIn.getBoundingBox();
                List<BlockPos> list1 = Lists.newArrayListWithCapacity(placementIn.func_204763_l() ? list.size() : 0);
                List<Pair<BlockPos, CompoundNBT>> list2 = Lists.newArrayListWithCapacity(list.size());
                int i = Integer.MAX_VALUE;
                int j = Integer.MAX_VALUE;
                int k = Integer.MAX_VALUE;
                int l = Integer.MIN_VALUE;
                int i1 = Integer.MIN_VALUE;
                int j1 = Integer.MIN_VALUE;

                for(Template.BlockInfo template$blockinfo : Template.processBlockInfos((Template)(Object)this, worldIn, featurePos, placementIn, list)) {
                    BlockPos templateBlockInfoPos = template$blockinfo.pos;
                    if (mutableboundingbox == null || mutableboundingbox.isVecInside(templateBlockInfoPos)) {
                        IFluidState ifluidstate = placementIn.func_204763_l() ? worldIn.getFluidState(templateBlockInfoPos) : null;
                        BlockState blockstate = template$blockinfo.state.mirror(placementIn.getMirror()).rotate(placementIn.getRotation());
                        if (template$blockinfo.nbt != null) {
                            TileEntity tileentity = worldIn.getTileEntity(templateBlockInfoPos);
                            IClearable.clearObj(tileentity);
                            worldIn.setBlockState(templateBlockInfoPos, Blocks.BARRIER.getDefaultState(), 20);
                        }

                        if (worldIn.setBlockState(templateBlockInfoPos, blockstate, flags)) {
                            i = Math.min(i, templateBlockInfoPos.getX());
                            j = Math.min(j, templateBlockInfoPos.getY());
                            k = Math.min(k, templateBlockInfoPos.getZ());
                            l = Math.max(l, templateBlockInfoPos.getX());
                            i1 = Math.max(i1, templateBlockInfoPos.getY());
                            j1 = Math.max(j1, templateBlockInfoPos.getZ());
                            list2.add(Pair.of(templateBlockInfoPos, template$blockinfo.nbt));
                            if (template$blockinfo.nbt != null) {
                                TileEntity tileentity1 = worldIn.getTileEntity(templateBlockInfoPos);
                                if (tileentity1 != null) {
                                    template$blockinfo.nbt.putInt("x", templateBlockInfoPos.getX());
                                    template$blockinfo.nbt.putInt("y", templateBlockInfoPos.getY());
                                    template$blockinfo.nbt.putInt("z", templateBlockInfoPos.getZ());
                                    tileentity1.read(template$blockinfo.nbt);
                                    tileentity1.mirror(placementIn.getMirror());
                                    tileentity1.rotate(placementIn.getRotation());
                                }
                            }

                            if (ifluidstate != null && blockstate.getBlock() instanceof ILiquidContainer) {
                                ((ILiquidContainer)blockstate.getBlock()).receiveFluid(worldIn, templateBlockInfoPos, blockstate, ifluidstate);
                                if (!ifluidstate.isSource()) {
                                    list1.add(templateBlockInfoPos);
                                }
                            }
                        }
                    }
                }

                boolean flag = true;
                Direction[] adirection = new Direction[]{Direction.UP, Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};

                while(flag && !list1.isEmpty()) {
                    flag = false;
                    Iterator<BlockPos> iterator = list1.iterator();

                    while(iterator.hasNext()) {
                        BlockPos blockpos2 = iterator.next();
                        BlockPos blockpos3 = blockpos2;
                        IFluidState ifluidstate2 = worldIn.getFluidState(blockpos2);

                        for(int k1 = 0; k1 < adirection.length && !ifluidstate2.isSource(); ++k1) {
                            BlockPos blockpos1 = blockpos3.offset(adirection[k1]);
                            IFluidState ifluidstate1 = worldIn.getFluidState(blockpos1);
                            if (ifluidstate1.getActualHeight(worldIn, blockpos1) > ifluidstate2.getActualHeight(worldIn, blockpos3) || ifluidstate1.isSource() && !ifluidstate2.isSource()) {
                                ifluidstate2 = ifluidstate1;
                                blockpos3 = blockpos1;
                            }
                        }

                        if (ifluidstate2.isSource()) {
                            BlockState blockstate2 = worldIn.getBlockState(blockpos2);
                            Block block = blockstate2.getBlock();
                            if (block instanceof ILiquidContainer) {
                                ((ILiquidContainer)block).receiveFluid(worldIn, blockpos2, blockstate2, ifluidstate2);
                                flag = true;
                                iterator.remove();
                            }
                        }
                    }
                }

                if (i <= l) {
                    if (!placementIn.func_215218_i()) {
                        VoxelShapePart voxelshapepart = new BitSetVoxelShapePart(l - i + 1, i1 - j + 1, j1 - k + 1);
                        int l1 = i;
                        int i2 = j;
                        int j2 = k;

                        for(Pair<BlockPos, CompoundNBT> pair1 : list2) {
                            BlockPos blockpos5 = pair1.getFirst();
                            voxelshapepart.setFilled(blockpos5.getX() - l1, blockpos5.getY() - i2, blockpos5.getZ() - j2, true, true);
                        }

                        Template.func_222857_a(worldIn, flags, voxelshapepart, l1, i2, j2);
                    }

                    for(Pair<BlockPos, CompoundNBT> pair : list2) {
                        BlockPos blockpos4 = pair.getFirst();
                        if (!placementIn.func_215218_i()) {
                            BlockState blockstate1 = worldIn.getBlockState(blockpos4);
                            BlockState blockstate3 = Block.getValidBlockForPosition(blockstate1, worldIn, blockpos4);
                            if (blockstate1 != blockstate3) {
                                worldIn.setBlockState(blockpos4, blockstate3, flags & -2 | 16);
                            }

                            worldIn.notifyNeighbors(blockpos4, blockstate3.getBlock());
                        }

                        if (pair.getSecond() != null) {
                            TileEntity tileentity2 = worldIn.getTileEntity(blockpos4);
                            if (tileentity2 != null) {
                                tileentity2.markDirty();
                            }
                        }
                    }
                }

                if (!placementIn.getIgnoreEntities()) {
                    ((TemplateInvoker)this).addEntitiesWorld(worldIn, featurePos, placementIn, placementIn.getMirror(), placementIn.getRotation(), placementIn.getCenterOffset(), placementIn.getBoundingBox());
                }

                List<String> treeLeaveList = new ArrayList<>();
                List<String> trunkLogList = new ArrayList<>();
                List<String> treeBranchList = new ArrayList<>();
                int stopppp = 0;

                list2.forEach(o -> {
                    int featureX = o.getFirst().getX();
                    int featureY = o.getFirst().getY() - featurePos.getY();
                    int realY = o.getFirst().getY();
                    int realZ = o.getFirst().getZ();
                    BlockPos pos = new BlockPos(featureX, realY, realZ);

                    //|| pos.getX() == -1 && pos.getZ() == 0 || pos.getX() == -1 && pos.getZ() == -1 || pos.getX() == -1 && pos.getZ() == -1
                    if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().contains("log") && pos.getX() == 0 && pos.getZ() == 0 || pos.getX() == -1 && pos.getZ() == 0 || pos.getX() == 1 && pos.getZ() == 0 || pos.getX() == 0 && pos.getZ() == 1 || pos.getX() == 0 && pos.getZ() == -1) {
                        trunkLogList.add("this.treeLog(changedBlocks, worldIn, mainmutable.add(" + featureX + ", " + featureY + ", " + realZ + "), boundsIn);");
                    }

                    if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().contains("log")) {
                        treeBranchList.add("this.treeBranch(changedBlocks, worldIn, mainmutable.add(" + featureX + ", " + featureY + ", " + realZ + "), boundsIn);");
                    }

                    if (worldIn.getBlockState(pos).getBlock().getRegistryName().toString().contains("leaves")) {
                        treeLeaveList.add("this.leafs(changedBlocks, worldIn, mainmutable.add(" + featureX + ", " + featureY + ", " + realZ + "), boundsIn);");
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
