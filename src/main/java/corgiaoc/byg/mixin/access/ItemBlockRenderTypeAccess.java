package corgiaoc.byg.mixin.access;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Map;

@Mixin(ItemBlockRenderTypes.class)
public interface ItemBlockRenderTypeAccess {


    @Accessor("TYPE_BY_BLOCK")
    static Map<Block, RenderType> getTypeByBlock() {
        throw new Error("Mixin did not apply");
    }
}
