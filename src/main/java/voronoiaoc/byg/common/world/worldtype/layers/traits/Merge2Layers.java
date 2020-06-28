package voronoiaoc.byg.common.world.worldtype.layers.traits;

import net.minecraft.world.gen.IExtendedNoiseRandom;
import net.minecraft.world.gen.area.IArea;
import net.minecraft.world.gen.area.IAreaFactory;
import net.minecraft.world.gen.layer.traits.IDimTransformer;

// Definitely not QuadParentedLayer
public interface Merge2Layers extends IDimTransformer {
    default <R extends IArea> IAreaFactory<R> apply(IExtendedNoiseRandom<R> context, IAreaFactory<R> parent0, IAreaFactory<R> parent1) {
        return () -> {
            R sampler0 = parent0.make();
            R sampler1 = parent1.make();
            return context.makeArea((x, z) -> {
                context.setPosition(x, z);
                return this.apply(context, sampler0, sampler1, x, z);
            }, sampler0);
        };
    }

    int apply(IExtendedNoiseRandom<?> rand, IArea sampler0, IArea sampler1, int x, int z);
}
