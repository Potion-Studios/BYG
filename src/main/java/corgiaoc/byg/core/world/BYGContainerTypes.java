package corgiaoc.byg.core.world;

import corgiaoc.byg.BYG;
import corgiaoc.byg.client.gui.HypogealImperiumContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.ArrayList;
import java.util.List;

public class BYGContainerTypes {

    public static final List<ContainerType<?>> CONTAINER_TYPES = new ArrayList<>();

    public static final ContainerType<HypogealImperiumContainer> HYPOGEAL_CONTAINER = register("hypogeal", HypogealImperiumContainer::new);


    private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> builder) {
        ContainerType<T> containerType = new ContainerType<>(builder);
        containerType.setRegistryName(new ResourceLocation(BYG.MOD_ID, key));

        CONTAINER_TYPES.add(containerType);
        return containerType;
    }
}
