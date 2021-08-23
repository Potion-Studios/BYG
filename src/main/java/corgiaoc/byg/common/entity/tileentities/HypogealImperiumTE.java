package corgiaoc.byg.common.entity.tileentities;

import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.common.properties.blocks.nether.HypogealImperiumBlock;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGTileEntities;
import corgiaoc.byg.helper.BlockEntityPacketHandler;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.util.*;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import java.util.List;
import java.util.Random;

public class HypogealImperiumTE extends LockableLootTileEntity implements ITickableTileEntity, BlockEntityPacketHandler {

    private NonNullList<ItemStack> contents = NonNullList.withSize(20, ItemStack.EMPTY);
    protected int numPlayersUsing;
    protected int crystal = 0;
    public int fuel;
    public int damageTime;

    private final IIntArray dataAccess = new IIntArray() {
        public int get(int index) {
            if (index == 0) {
                return HypogealImperiumTE.this.fuel;
            }
            return 0;
        }

        public void set(int index, int value) {
            HypogealImperiumTE.this.fuel = value;
        }

        public int getCount() {
            return 1;
        }
    };

    public HypogealImperiumTE() {
        super(BYGTileEntities.HYPOGEAL);
    }

    /*********************** Packets Start ***********************/

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbtTag = super.getUpdateTag();
        nbtTag.putInt("Crystal", this.getCrystal());
        nbtTag.putShort("Fuel", (short) this.fuel);
        return nbtTag;
    }

    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), -1, getUpdateTag());
    }

    @Override
    public void handleClientPacketNoTypeCheck(SUpdateTileEntityPacket packet) {
        readData(packet.getTag());
    }

    /*********************** Packets End ***********************/
    /*********************** Disk Start ***********************/

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        readData(nbt);
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.putShort("Fuel", (short) this.fuel);
        compound.putInt("Crystal", this.getCrystal());
        if (!this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, this.contents);
        }
        return compound;
    }

    /*********************** Disk End ***********************/


    private void readData(CompoundNBT nbt) {
        this.contents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        this.fuel = nbt.getShort("Fuel");
        this.setCrystal(nbt.getInt("Crystal"));
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.contents);
        }
    }

    @Override
    public void tick() {

        if (this.level.getGameTime() % 80 == 0) {
            this.level.playLocalSound(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), SoundEvents.BEACON_AMBIENT, SoundCategory.BLOCKS, 1, 1, false);
        }
        this.addEffectsToMobs();
        this.changeBlocksInRadius();
        this.doCrystalLoad();
        this.addParticles();
        this.setLit();
    }

    public void setLit() {
        if (this.isLit()) {
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(HypogealImperiumBlock.LIT, this.isLit()), 3);
            this.setChanged();
        }
    }

    public void doCrystalLoad() {
        ItemStack itemFuelItem = this.getItem(0);
        ItemStack itemCatalystItem = this.getItem(1);
        ItemStack resultItem = this.getItem(2);

        if (this.getCrystal() < 12) {
            if (itemFuelItem.getItem() == BYGItems.SUBZERO_CRYSTAL_SHARD && this.getFuel() <= 0) {
                this.setFuel(9);
                itemFuelItem.shrink(1);
            }
            if (itemCatalystItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                if (this.getFuel() > 0) {
                    this.setFuel(this.getFuel() - 1);
                    itemCatalystItem.shrink(1);
                    this.setCrystal(this.getCrystal() + 1);
                    this.getLevel().sendBlockUpdated(this.worldPosition, this.getBlockState(), this.getBlockState(), 13);
                    if (resultItem.getItem() != BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                        this.setItem(2, BYGItems.SUBZERO_CRYSTAL_CLUSTER.getDefaultInstance());
                    }
                    if (resultItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                        resultItem.setCount(resultItem.getCount() + 1);
                    }
                }
            }
        }
    }

    public void addParticles() {
        World world = this.level;
        int h = 6 + this.getCrystal();
        for (int x1 = this.getBlockPos().getX() - h; x1 <= this.getBlockPos().getX() + h; ++x1) {
            for (int y1 = this.getBlockPos().getY(); y1 <= this.getBlockPos().getY() + 6; ++y1) {
                for (int z1 = this.getBlockPos().getZ() - h; z1 <= this.getBlockPos().getZ() + h; ++z1) {
                    if (this.level.isClientSide) {
                        if (getFuel() > 0) {
                            Random rand = new Random();
                            int i = rand.nextInt(7);
                            if (i >= 4) {
                                world.addParticle(ParticleTypes.WHITE_ASH, (double) x1, (double) y1, (double) z1, 0D, 5.0E-4D, 0D);
                            }
                        }
                    }
                }
            }
        }
    }

    public void addEffectsToMobs() {
        if (!this.level.isClientSide) {
            AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.worldPosition)).inflate(6 + getCrystal()).expandTowards(0.0D, this.level.getHeight(), 0.0D);
            List<MonsterEntity> list = this.level.getEntitiesOfClass(MonsterEntity.class, axisalignedbb);
            for (MonsterEntity mob : list) {
                if (getFuel() > 0) {
                    mob.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 3, false, true));
                    --this.damageTime;
                    if (this.damageTime <= 0) {
                        mob.hurt(DamageSource.MAGIC, 2);
                        useFuel();
                        this.damageTime = 100;
                    }
                }
            }
        }
    }


    public void changeBlocksInRadius() {
        World world = this.level;
        if (getFuel() > 0) {
            int h = 6 + this.getCrystal();
            for (int x1 = this.getBlockPos().getX() - h; x1 <= this.getBlockPos().getX() + h; ++x1) {
                for (int y1 = this.getBlockPos().getY() - 2; y1 <= this.getBlockPos().getY() + 5; ++y1) {
                    for (int z1 = this.getBlockPos().getZ() - h; z1 <= this.getBlockPos().getZ() + h; ++z1) {
                        if (!world.isClientSide) {
                            if (world.getBlockState(new BlockPos(x1, y1, z1)) == Blocks.WATER.defaultBlockState()) {
                                world.setBlockAndUpdate(new BlockPos(x1, y1, z1), Blocks.ICE.defaultBlockState());
                                useFuel();
                            }
                            if (world.getBlockState(new BlockPos(x1, y1, z1)) == Blocks.LAVA.defaultBlockState()) {
                                world.setBlockAndUpdate(new BlockPos(x1, y1, z1), Blocks.OBSIDIAN.defaultBlockState());
                                useFuel();
                            }
                        }
                    }
                }
            }
        }
    }

    public void useFuel() {
        int useFuel;
        Random random = new Random();
        useFuel = random.nextInt(11);
        if (useFuel > 9) {
            this.setFuel(this.getFuel() - 1);
        }
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.hypogeal_imperium_container");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new HypogealImperiumContainer(id, player, this, dataAccess);
    }

    @Override
    public boolean triggerEvent(int id, int type) {
        if (id == 1) {
            this.numPlayersUsing = type;
            return true;
        } else {
            return super.triggerEvent(id, type);
        }
    }

    @Override
    public void startOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    @Override
    public void stopOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof HypogealImperiumBlock) {
            this.level.blockEvent(this.worldPosition, block, 1, this.numPlayersUsing);
            this.level.updateNeighborsAt(this.worldPosition, block);
        }
    }

    @Override
    public int getContainerSize() {
        return 20;
    }

    @Override
    public int getMaxStackSize() {
        return 64;
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.contents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.contents = itemsIn;
    }

    public int getFuel() {
        return fuel;
    }

    public void setFuel(int amount) {
        fuel = amount;
    }

    public int getCrystal() {
        return crystal;
    }

    public void setCrystal(int amount) {
        crystal = amount;
    }

    private boolean isLit() {
        return this.getFuel() > 0;
    }

    //Forge
    private final IItemHandlerModifiable items = new InvWrapper(this);
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    @Override
    public void clearCache() {
        super.clearCache();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null)
            itemHandler.invalidate();
    }
}