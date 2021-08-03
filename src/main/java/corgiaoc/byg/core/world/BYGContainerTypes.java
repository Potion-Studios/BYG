package corgiaoc.byg.core.world;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BYGContainerTypes {

    public static final DeferredRegister<ContainerType<?>> CONTAINER_TYPES = DeferredRegister.create(ForgeRegistries.CONTAINERS, BYG.MOD_ID);

    public static final RegistryObject<ContainerType<HypogealImperiumContainer>> HYPOGEAL_CONTAINER = CONTAINER_TYPES
            .register("hypogeal_container", () -> IForgeContainerType.create(HypogealImperiumContainer::new));
}
