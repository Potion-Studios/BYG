package potionstudios.byg.common.entity.ai.village.poi;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.core.Registry;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import potionstudios.byg.BYG;
import potionstudios.byg.common.block.BYGBlocks;
import potionstudios.byg.mixin.access.PoiTypesAccess;
import potionstudios.byg.reg.RegistrationProvider;
import potionstudios.byg.reg.RegistryObject;

import java.util.Collection;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class BYGPoiTypes {

    private static final RegistrationProvider<PoiType> PROVIDER = RegistrationProvider.get(Registry.POINT_OF_INTEREST_TYPE_REGISTRY, BYG.MOD_ID);

    public static final RegistryObject<PoiType> FORAGER = createPoiType("forager", createPoiTypeSupplier(() -> Set.of(BYGBlocks.FORAGERS_TABLE.get())));

    public static RegistryObject<PoiType> createPoiType(String id, Supplier<PoiType> poiType) {
        return PROVIDER.register(id, poiType);
    }


    private static Supplier<PoiType> createPoiTypeSupplier(Supplier<Collection<Block>> states) {
        return () -> {
            Set<BlockState> blockStates = new ObjectOpenHashSet<>();
            states.get().stream().map(PoiTypesAccess::byg_invokeGetBlockStates).collect(Collectors.toSet()).forEach(blockStates::addAll);
            return new PoiType(blockStates, 1, 1);
        };
    }

    public static void loadClass() {
    }
}
