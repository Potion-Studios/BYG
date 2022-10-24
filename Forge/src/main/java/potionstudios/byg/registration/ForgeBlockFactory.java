package potionstudios.byg.registration;

import com.google.auto.service.AutoService;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.ForgeRegistries;
import potionstudios.byg.common.block.BYGBlockFactory;
import potionstudios.byg.common.block.BYGScaffoldingBlock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

@AutoService(BYGBlockFactory.class)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ForgeBlockFactory implements BYGBlockFactory {

    private static Map<Supplier<? extends Block>, FlowerPotBlock> flowerPots = new HashMap<>();
    @Override
    public FlowerPotBlock createPottedBlock(Supplier<? extends Block> block, BlockBehaviour.Properties behaviour) {
        var pot = new FlowerPotBlock(() -> (FlowerPotBlock)Blocks.FLOWER_POT, block, behaviour);
        flowerPots.put(block, pot);
        return pot;
    }

    @Override
    public BYGScaffoldingBlock createScaffolding(BlockBehaviour.Properties behaviour) {
        return new BYGForgeScaffoldingBlock(behaviour);
    }

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            for (Map.Entry<Supplier<? extends Block>, FlowerPotBlock> entry : flowerPots.entrySet()) {
                ((FlowerPotBlock)Blocks.FLOWER_POT).addPlant(ForgeRegistries.BLOCKS.getKey(entry.getKey().get()), entry::getValue);
            }
        });
    }
}
