package potionstudios.byg.mixin.access.world.entity.npc.villagertrades;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.npc.VillagerTrades;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(VillagerTrades.SuspiciousStewForEmerald.class)
public interface SuspiciousStewForEmeraldAccess {

    @Accessor("effect")
    MobEffect byg_getEffect();

    @Accessor("duration")
    int byg_getDuration();

    @Accessor("xp")
    int byg_getXp();

    @Accessor("priceMultiplier")
    float byg_getPriceMultiplier();
}
