package corgiaoc.byg.common.entity.tileentities;

import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import corgiaoc.byg.common.properties.blocks.nether.HypogealImperiumBlock;
import corgiaoc.byg.core.BYGItems;
import corgiaoc.byg.core.BYGTileEntities;
import corgiaoc.byg.helper.BlockEntityPacketHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;
import java.util.Random;

public class HypogealImperiumTE extends RandomizableContainerBlockEntity implements TickableBlockEntity, BlockEntityPacketHandler {

    private NonNullList<ItemStack> contents = NonNullList.withSize(20, ItemStack.EMPTY);
    protected int numPlayersUsing;
    protected int crystal = 0;
    public int fuel;
    public int damageTime;

    private final ContainerData dataAccess = new ContainerData() {
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
    public CompoundTag getUpdateTag() {
        CompoundTag nbtTag = super.getUpdateTag();
        nbtTag.putInt("Crystal", this.getCrystal());
        nbtTag.putShort("Fuel", (short) this.fuel);
        return nbtTag;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return new ClientboundBlockEntityDataPacket(getBlockPos(), -1, getUpdateTag());
    }

    @Override
    public void handleClientPacketNoTypeCheck(ClientboundBlockEntityDataPacket packet) {
        readData(packet.getTag());
    }

    /*********************** Packets End ***********************/
    /*********************** Disk Start ***********************/

    @Override
    public void load(BlockState state, CompoundTag nbt) {
        super.load(state, nbt);
        readData(nbt);
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        super.save(compound);
        compound.putShort("Fuel", (short) this.fuel);
        compound.putInt("Crystal", this.getCrystal());
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.contents);
        }
        return compound;
    }

    /*********************** Disk End ***********************/


    private void readData(CompoundTag nbt) {
        this.contents = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        this.fuel = nbt.getShort("Fuel");
        this.setCrystal(nbt.getInt("Crystal"));
        if (!this.tryLoadLootTable(nbt)) {
            ContainerHelper.loadAllItems(nbt, this.contents);
        }
    }

    @Override
    public void tick() {
        this.playSound();
        this.addEffectsToMobs();
        this.changeBlocksInRadius();
        this.doCrystalLoad();
        this.addParticles();
        this.setLit();
    }

    public void playSound(){
        if (this.isLit()) {
            if (this.level.getGameTime() % 80 == 0) {
                this.level.playLocalSound(this.getBlockPos().getX(), this.getBlockPos().getY(), this.getBlockPos().getZ(), SoundEvents.BEACON_AMBIENT, SoundSource.BLOCKS, 1, 1, false);
            }
        }
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
        Level world = this.level;
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
            AABB axisalignedbb = (new AABB(this.worldPosition)).inflate(6 + getCrystal()).expandTowards(0.0D, this.level.getHeight(), 0.0D);
            List<Monster> list = this.level.getEntitiesOfClass(Monster.class, axisalignedbb);
            for (Monster mob : list) {
                if (getFuel() > 0) {
                    mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, true));
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
        Level world = this.level;
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
    protected Component getDefaultName() {
        return new TranslatableComponent("container.hypogeal_imperium_container");
    }

    @Override
    protected AbstractContainerMenu createMenu(int id, Inventory player) {
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
    public void startOpen(Player player) {
        if (!player.isSpectator()) {
            if (this.numPlayersUsing < 0) {
                this.numPlayersUsing = 0;
            }
            ++this.numPlayersUsing;
            this.onOpenOrClose();
        }
    }

    @Override
    public void stopOpen(Player player) {
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
}