package potionstudios.byg.datagen.providers.loot;

import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.registries.ForgeRegistries;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGWoodTypes;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

class BYGBlockLootProvider extends BlockLootSubProvider {

    private static final float[] NORMAL_LEAVES_SAPLING_CHANCES = {0.05F, 0.0625F, 0.083333336F, 0.1F};

    private  final List<Block> blocks = new ArrayList<>();

    protected BYGBlockLootProvider(Set<Item> pExplosionResistant, FeatureFlagSet pEnabledFeatures) {
        super(pExplosionResistant, pEnabledFeatures);
    }

    public void dropSelf(@Nullable Supplier<? extends Block> pBlock) {
        if (pBlock != null) {
            super.dropSelf(pBlock.get());
            blocks.add(pBlock.get());
        }
    }

    protected void add(@Nullable Supplier<? extends Block> pBlock, Function<Block, LootTable.Builder> pFactory) {
        if (pBlock != null) {
            super.add(pBlock.get(), pFactory);
            blocks.add(pBlock.get());
        }
    }

    @Override
    protected void add(Block pBlock, Function<Block, LootTable.Builder> pFactory) {
        super.add(pBlock, pFactory);
        blocks.add(pBlock);
    }

    @Override
    protected void add(Block pBlock, LootTable.Builder pBuilder) {
        super.add(pBlock, pBuilder);
        blocks.add(pBlock);
    }

    @Override
    protected void generate() {
        for (final BYGWoodTypes type : BYGWoodTypes.values()) {
            add(type.bookshelf(), shelf -> createSingleItemTableWithSilkTouch(shelf, Items.BOOK, ConstantValue.exactly(3.0F)));
            dropSelf(type.button());
            dropSelf(type.craftingTable());
            add(type.door(), this::createDoorTable);
            dropSelf(type.fence());
            dropSelf(type.fenceGate());
            add(type.leaves(), leaf -> createLeavesDrops(leaf, type.growerItem().get(), NORMAL_LEAVES_SAPLING_CHANCES));
            dropSelf(type.log());
            dropSelf(type.wood());
            dropSelf(type.strippedLog());
            dropSelf(type.strippedWood());
            dropSelf(type.planks());
            dropSelf(type.pressurePlate());
            dropSelf(type.growerItem());
            add(type.slab(), this::createSlabItemTable);
            dropSelf(type.stairs());
            dropSelf(type.trapdoor());
            dropSelf(type.sign());

            if (type.growerItem() != null) {
                final var growerName = type.growerItem().getId().getPath();
                final var potted = ForgeRegistries.BLOCKS.getDelegate(BYG.createLocation("potted_" + growerName));
                potted.ifPresent(blockReference -> {
                    add(blockReference.value(), LootTable.lootTable()
                            .withPool(applyExplosionCondition(type.growerItem(), LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1.0F))
                                    .add(LootItem.lootTableItem(type.growerItem()))))
                            .withPool(applyExplosionCondition(Items.FLOWER_POT, LootPool.lootPool()
                                    .setRolls(ConstantValue.exactly(1.0F))
                                    .add(LootItem.lootTableItem(Items.FLOWER_POT)))));
                });
            }
        }
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return blocks;
    }
}
