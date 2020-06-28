package voronoiaoc.byg.common.world.worldtype.layers.traits;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.area.LazyArea;
import net.minecraft.world.gen.layer.traits.IDimTransformer;

// Definitely not QuadParentedLayer
public interface Merge3Layers extends IDimTransformer {
    default <R extends IArea> IAreaFactory<R> apply(IExtendedNoiseRandom<R> context, IAreaFactory<LazyArea> createContinent, IAreaFactory<R> parent0, IAreaFactory<R> parent1) {
        return () -> {
            R sampler1 = parent0.make();
            R sampler2 = parent1.make();
            R sampler3 = parent1.make();
            return context.makeArea((x, z) -> {
                context.setPosition(x, z);
                return this.apply(context, sampler1, sampler2, sampler3, x, z);
            }, sampler1);
        };
    }

    int apply(IExtendedNoiseRandom<?> rand, IArea sampler1, IArea sampler2, IArea sampler3, int x, int z);
}
