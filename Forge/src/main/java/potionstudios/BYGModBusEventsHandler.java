package potionstudios;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import potionstudios.byg.BYG;
import potionstudios.byg.common.item.BYGItems;
import potionstudios.byg.reg.RegistryObject;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = BYG.MOD_ID)
public class BYGModBusEventsHandler {

    @SubscribeEvent
    public static void registerTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(BYG.createLocation(BYG.MOD_ID), builder -> {

            builder.icon(() -> new ItemStack(BYGItems.BYG_LOGO.get()));
            builder.title(Component.translatable("itemGroup.byg.byg"));
            builder.withSearchBar();
            builder.withBackgroundLocation(new ResourceLocation("minecraft", "textures/gui/container/creative_inventory/tab_item_search.png"));
            builder.displayItems((displayParameters, pOutput) -> {
                for (ResourceKey<Item> entry : BYGItems.REGISTRATION_ORDERED_ITEMS) {
                    Item pItem = BYGItems.PROVIDER.getRegistry().get(entry);

                    if (pItem != BYGItems.BYG_LOGO.get()) {
                        pOutput.accept(pItem);
                    }
                }
            });
        });
    }
}
