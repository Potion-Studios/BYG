package potionstudios.byg.core;

import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerTrades;
import potionstudios.byg.BYG;
import potionstudios.byg.common.entity.npc.BYGVillagerTrades;
import potionstudios.byg.common.entity.npc.VillagerTradeRegistry;
import potionstudios.byg.mixin.access.RegistryAccess;
import potionstudios.byg.util.blendingfunction.BlendingFunction;

public class BYGRegistry {
    public static final ResourceKey<Registry<Codec<? extends BlendingFunction>>> BLENDING_FUNCTION_RESOURCE_KEY = ResourceKey.createRegistryKey(BYG.createLocation("blending_function"));

    public static final Registry<Codec<? extends BlendingFunction>> BLENDING_FUNCTION = RegistryAccess.byg_invokeRegisterSimple(BLENDING_FUNCTION_RESOURCE_KEY, Lifecycle.stable(), registry -> BlendingFunction.CODEC);

    public static final ResourceKey<Registry<Codec<? extends VillagerTrades.ItemListing>>> VILLAGER_TRADES_ITEM_LISTING_RESOURCE_KEY = ResourceKey.createRegistryKey(BYG.createLocation("villager_trades_item_listing"));

    public static final Registry<Codec<? extends VillagerTrades.ItemListing>> VILLAGER_TRADES_ITEM_LISTING = RegistryAccess.byg_invokeRegisterSimple(VILLAGER_TRADES_ITEM_LISTING_RESOURCE_KEY, Lifecycle.stable(), registry -> VillagerTradeRegistry.ITEM_LISTING_CODEC);
}
