package corgiaoc.byg.common.entity.tileentities;

import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.common.properties.blocks.nether.HypogealImperiumBlock;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGTileEntities;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HypogealImperiumTE extends LockableLootTileEntity implements ITickableTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(20, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private final IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
    protected int crystal = 0;
    public int fuel;
    public int damageTime;

    public HypogealImperiumTE() {
        super(BYGTileEntities.HYPOGEAL.get());
    }


    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.hypogeal_imperium_container");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new HypogealImperiumContainer(id, player, this);
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
        return this.chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    @Override
    public void load(BlockState state, CompoundNBT nbt) {
        super.load(state, nbt);
        this.chestContents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        this.fuel = nbt.getShort("Fuel");
        this.setCrystal(nbt.getInt("Crystal"));
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.chestContents);
        }
    }


    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.putShort("Fuel", (short) this.fuel);
        compound.putInt("Crystal", this.getCrystal());
        if (!this.trySaveLootTable(compound)) {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }
        return compound;
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
    public void clearCache() {
        super.clearCache();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
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

    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
        if (!this.remove && cap == net.minecraftforge.items.CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            if (this.itemHandler == null)
                this.itemHandler = net.minecraftforge.common.util.LazyOptional.of(this::createHandler);
            return this.itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

    @Override
    protected void invalidateCaps() {
        super.invalidateCaps();
        if (itemHandler != null)
            itemHandler.invalidate();
    }

    @Override
    public CompoundNBT getUpdateTag() {
        CompoundNBT nbtTag = super.getUpdateTag();
        nbtTag.putInt("Crystal", this.getCrystal());
        return nbtTag;
    }

    @Override
    public void handleUpdateTag(BlockState state, CompoundNBT tag) {
        this.setCrystal(tag.getInt("Crystal"));
    }


    @Override
    public SUpdateTileEntityPacket getUpdatePacket() {
        return new SUpdateTileEntityPacket(getBlockPos(), -1, getUpdateTag());
    }

    @Override
    public void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt) {
        CompoundNBT tag = pkt.getTag();
        this.handleUpdateTag(this.getBlockState(), tag);
    }

    @Override
    public void tick() {
        this.addEffectsToMobs();
        this.changeBlocksInRadius();
        this.doCrystalLoad();
        this.addParticles();
        this.setLit();

    }

    public void setLit(){
        boolean flag = this.isLit();
        boolean flag1 = false;
        if (flag != this.isLit()) {
            flag1 = true;
            this.level.setBlock(this.worldPosition, this.level.getBlockState(this.worldPosition).setValue(HypogealImperiumBlock.LIT, this.isLit()), 3);
        }

        if (flag1) {
            this.setChanged();
        }
    }

    private boolean isLit() {
        return this.getFuel() > 0;
    }

    public void doCrystalLoad() {
        ItemStack itemFuelItem = this.getItem(0);
        ItemStack itemCatalystItem = this.getItem(1);
        ItemStack resultItem = this.getItem(2);
        World world = this.level;

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
                        }
                        this.damageTime = 100;
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
                        if (!world.isClientSide){
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
            public void useFuel(){
                int useFuel;
                Random random = new Random();
                useFuel = random.nextInt(11);
                if (useFuel > 9) {
                    this.setFuel(this.getFuel() - 1);
                }
            }
        }