package corgiaoc.byg.common.entity.tileentities;

import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.common.properties.blocks.nether.HypogealImperiumBlock;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGTileEntities;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.tileentity.*;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;
import java.util.List;

public class HypogealImperiumTE extends LockableLootTileEntity implements ITickableTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(20, ItemStack.EMPTY);
    protected int numPlayersUsing;
    private final IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);
    protected int crystal;
    public static int loadtime;
    public int fuel;
    public int damageTime;

    public HypogealImperiumTE() {
        super(BYGTileEntities.HYPOGEAL.get());
    }

    public int get(int p_221476_1_) {
        switch(p_221476_1_) {
            case 0:
                return HypogealImperiumTE.this.crystal;
            case 1:
                return HypogealImperiumTE.this.fuel;
            default:
                return 0;
        }
    }

    public void set(int p_221477_1_, int p_221477_2_) {
        switch(p_221477_1_) {
            case 0:
                HypogealImperiumTE.this.crystal = p_221477_2_;
                break;
            case 1:
                HypogealImperiumTE.this.fuel = p_221477_2_;
        }
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
        return 18;
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
        this.loadtime = nbt.getShort("LoadTime");
        this.fuel = nbt.getShort("Fuel");
        this.crystal = nbt.getShort("Crystal");
        if (!this.tryLoadLootTable(nbt)) {
            ItemStackHelper.loadAllItems(nbt, this.chestContents);
        }
    }

    public static int getLoadTime(){
        return loadtime;
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        super.save(compound);
        compound.putShort("LoadTime", (short)this.loadtime);
        compound.putShort("Fuel", (short)this.fuel);
        compound.putShort("Crystal", (short)this.crystal);
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

    public int getFuel(){
        return fuel;
    }

    public void setFuel(int amount){
        fuel = amount;
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
    public void tick() {
        this.addEffectsToMobs();
        --damageTime;
        ItemStack itemFuelItem = this.getItem(0);
        ItemStack itemCatalystItem = this.getItem(1);
        ItemStack resultItem = this.getItem(2);

        if (!this.level.isClientSide) {
            if (this.crystal < 12) {
                if (itemFuelItem.getItem() == BYGItems.SUBZERO_CRYSTAL_SHARD && this.getFuel() == 0) {
                        this.setFuel(9);
                        itemFuelItem.shrink(1);
                    }
                if (itemCatalystItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                    if (this.getFuel() > 0) {
                        --this.loadtime;
                        if (this.loadtime <= 0) {
                            this.setFuel(this.getFuel() - 1);
                            itemCatalystItem.shrink(1);
                            this.crystal++;
                            this.loadtime = 600;
                            if (resultItem.getItem() != BYGItems.SUBZERO_CRYSTAL_CLUSTER){
                                this.setItem(2, BYGItems.SUBZERO_CRYSTAL_CLUSTER.getDefaultInstance());
                        }
                            if (resultItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER){
                                resultItem.setCount(resultItem.getCount() + 1);
                            }
                        }
                    }
                }
                if (itemCatalystItem.getItem() != BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                    this.loadtime = 600;
                }
            }
        }
    }

    public void addEffectsToMobs(){
        if (!this.level.isClientSide) {
                AxisAlignedBB axisalignedbb = (new AxisAlignedBB(this.worldPosition)).inflate(6 + crystal).expandTowards(0.0D, this.level.getHeight(), 0.0D);
                List<MonsterEntity> list = this.level.getEntitiesOfClass(MonsterEntity.class, axisalignedbb);
                for (MonsterEntity mob : list) {
                    mob.addEffect(new EffectInstance(Effects.MOVEMENT_SLOWDOWN, 20, 3, false, true));
                    if (damageTime == 0){
                        mob.hurt(DamageSource.MAGIC, 2);
                        damageTime = 300;
                    }
                }
            }
        }
    }