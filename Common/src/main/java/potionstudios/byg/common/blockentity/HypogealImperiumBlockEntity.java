package potionstudios.byg.common.blockentity;

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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import potionstudios.byg.client.gui.HypogealImperiumContainer;
import potionstudios.byg.common.block.nether.HypogealImperiumBlock;
import potionstudios.byg.common.item.BYGItems;

import java.util.List;
import java.util.Random;

public class HypogealImperiumBlockEntity extends RandomizableContainerBlockEntity {

    private NonNullList<ItemStack> contents = NonNullList.withSize(20, ItemStack.EMPTY);
    protected int numPlayersUsing;
    protected int crystal = 0;
    public int fuel;
    public int damageTime;

    private final ContainerData dataAccess = new ContainerData() {
        public int get(int index) {
            if (index == 0) {
                return HypogealImperiumBlockEntity.this.fuel;
            }
            return 0;
        }

        public void set(int index, int value) {
            HypogealImperiumBlockEntity.this.fuel = value;
        }

        public int getCount() {
            return 1;
        }
    };

    public HypogealImperiumBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(BYGBlockEntities.HYPOGEAL.get(), blockPos, blockState);
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
        return ClientboundBlockEntityDataPacket.create(this);
    }


    /*********************** Packets End ***********************/
    /*********************** Disk Start ***********************/

    @Override
    public void load(CompoundTag nbt) {
        super.load(nbt);
        readData(nbt);
    }

    @Override
    protected void saveAdditional(CompoundTag compound) {
        compound.putShort("Fuel", (short) this.fuel);
        compound.putInt("Crystal", this.getCrystal());
        if (!this.trySaveLootTable(compound)) {
            ContainerHelper.saveAllItems(compound, this.contents);
        }
        super.saveAdditional(compound);
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


    public static void tick(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        playSound(level, blockPos, blockState, hypogealImperiumBlockEntity);
        hypogealImperiumBlockEntity.addEffectsToMobs(level, blockPos, blockState, hypogealImperiumBlockEntity);
        hypogealImperiumBlockEntity.changeBlocksInRadius(level, blockPos, blockState, hypogealImperiumBlockEntity);
        hypogealImperiumBlockEntity.doCrystalLoad(level, blockPos, blockState, hypogealImperiumBlockEntity);
        hypogealImperiumBlockEntity.addParticles(level, blockPos, blockState, hypogealImperiumBlockEntity);
        hypogealImperiumBlockEntity.setLit(level, blockPos, blockState, hypogealImperiumBlockEntity);
    }

    public static void playSound(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        if (hypogealImperiumBlockEntity.isLit()) {
            if (level.getGameTime() % 80 == 0) {
                level.playLocalSound(blockPos.getX(), blockPos.getY(), blockPos.getZ(), SoundEvents.BEACON_AMBIENT, SoundSource.BLOCKS, 1, 1, false);
            }
        }
    }

    public static void setLit(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        if (hypogealImperiumBlockEntity.isLit()) {
            level.setBlock(hypogealImperiumBlockEntity.worldPosition, level.getBlockState(hypogealImperiumBlockEntity.worldPosition).setValue(HypogealImperiumBlock.LIT, hypogealImperiumBlockEntity.isLit()), 3);
            hypogealImperiumBlockEntity.setChanged();
        }
    }

    public static void doCrystalLoad(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        ItemStack itemFuelItem = hypogealImperiumBlockEntity.getItem(0);
        ItemStack itemCatalystItem = hypogealImperiumBlockEntity.getItem(1);
        ItemStack resultItem = hypogealImperiumBlockEntity.getItem(2);

        if (hypogealImperiumBlockEntity.getCrystal() < 12) {
            if (itemFuelItem.getItem() == BYGItems.SUBZERO_CRYSTAL_SHARD && hypogealImperiumBlockEntity.getFuel() <= 0) {
                hypogealImperiumBlockEntity.setFuel(9);
                itemFuelItem.shrink(1);
            }
            if (itemCatalystItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                if (hypogealImperiumBlockEntity.getFuel() > 0) {
                    hypogealImperiumBlockEntity.setFuel(hypogealImperiumBlockEntity.getFuel() - 1);
                    itemCatalystItem.shrink(1);
                    hypogealImperiumBlockEntity.setCrystal(hypogealImperiumBlockEntity.getCrystal() + 1);
                    hypogealImperiumBlockEntity.getLevel().sendBlockUpdated(hypogealImperiumBlockEntity.worldPosition, hypogealImperiumBlockEntity.getBlockState(), hypogealImperiumBlockEntity.getBlockState(), 13);
                    if (resultItem.getItem() != BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                        hypogealImperiumBlockEntity.setItem(2, BYGItems.SUBZERO_CRYSTAL_CLUSTER.get().getDefaultInstance());
                    }
                    if (resultItem.getItem() == BYGItems.SUBZERO_CRYSTAL_CLUSTER) {
                        resultItem.setCount(resultItem.getCount() + 1);
                    }
                }
            }
        }
    }

    public static void addParticles(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        int h = 6 + hypogealImperiumBlockEntity.getCrystal();
        if (level.isClientSide) {
            for (int x1 = hypogealImperiumBlockEntity.getBlockPos().getX() - h; x1 <= hypogealImperiumBlockEntity.getBlockPos().getX() + h; ++x1) {
                for (int y1 = hypogealImperiumBlockEntity.getBlockPos().getY(); y1 <= hypogealImperiumBlockEntity.getBlockPos().getY() + 6; ++y1) {
                    for (int z1 = hypogealImperiumBlockEntity.getBlockPos().getZ() - h; z1 <= hypogealImperiumBlockEntity.getBlockPos().getZ() + h; ++z1) {
                        if (hypogealImperiumBlockEntity.getFuel() > 0) {
                            Random rand = new Random();
                            int i = rand.nextInt(7);
                            if (i >= 4) {
                                level.addParticle(ParticleTypes.WHITE_ASH, (double) x1, (double) y1, (double) z1, 0D, 5.0E-4D, 0D);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void addEffectsToMobs(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        if (!level.isClientSide) {
            AABB axisalignedbb = (new AABB(hypogealImperiumBlockEntity.worldPosition)).inflate(6 + hypogealImperiumBlockEntity.getCrystal()).expandTowards(0.0D, level.getHeight(), 0.0D);
            List<Monster> list = level.getEntitiesOfClass(Monster.class, axisalignedbb);
            for (Monster mob : list) {
                if (hypogealImperiumBlockEntity.getFuel() > 0) {
                    mob.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 20, 3, false, true));
                    --hypogealImperiumBlockEntity.damageTime;
                    if (hypogealImperiumBlockEntity.damageTime <= 0) {
                        mob.hurt(DamageSource.MAGIC, 2);
                        useFuel(level, blockPos, blockState, hypogealImperiumBlockEntity);
                        hypogealImperiumBlockEntity.damageTime = 100;
                    }
                }
            }
        }
    }


    public static void changeBlocksInRadius(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        if (!level.isClientSide) {
            if (hypogealImperiumBlockEntity.getFuel() > 0) {
                int h = 6 + hypogealImperiumBlockEntity.getCrystal();
                for (int x1 = hypogealImperiumBlockEntity.getBlockPos().getX() - h; x1 <= hypogealImperiumBlockEntity.getBlockPos().getX() + h; ++x1) {
                    for (int y1 = hypogealImperiumBlockEntity.getBlockPos().getY() - 2; y1 <= hypogealImperiumBlockEntity.getBlockPos().getY() + 5; ++y1) {
                        for (int z1 = hypogealImperiumBlockEntity.getBlockPos().getZ() - h; z1 <= hypogealImperiumBlockEntity.getBlockPos().getZ() + h; ++z1) {
                            if (level.getBlockState(new BlockPos(x1, y1, z1)) == Blocks.WATER.defaultBlockState()) {
                                level.setBlockAndUpdate(new BlockPos(x1, y1, z1), Blocks.ICE.defaultBlockState());
                                useFuel(level, blockPos, blockState, hypogealImperiumBlockEntity);
                            }
                            if (level.getBlockState(new BlockPos(x1, y1, z1)) == Blocks.LAVA.defaultBlockState()) {
                                level.setBlockAndUpdate(new BlockPos(x1, y1, z1), Blocks.OBSIDIAN.defaultBlockState());
                                useFuel(level, blockPos, blockState, hypogealImperiumBlockEntity);
                            }
                        }
                    }
                }
            }
        }
    }

    public static void useFuel(Level level, BlockPos blockPos, BlockState blockState, HypogealImperiumBlockEntity hypogealImperiumBlockEntity) {
        int useFuel;
        Random random = new Random();
        useFuel = random.nextInt(11);
        if (useFuel > 9) {
            hypogealImperiumBlockEntity.setFuel(hypogealImperiumBlockEntity.getFuel() - 1);
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