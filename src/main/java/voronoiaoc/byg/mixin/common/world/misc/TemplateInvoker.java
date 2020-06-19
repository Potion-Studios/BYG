//package voronoiaoc.byg.mixin.common.world.misc;
//
//import net.minecraft.util.Mirror;
//import net.minecraft.util.Rotation;
//import net.minecraft.util.math.BlockPos;
//import net.minecraft.util.math.MutableBoundingBox;
//import net.minecraft.world.IWorld;
//import net.minecraft.world.gen.feature.template.PlacementSettings;
//import net.minecraft.world.gen.feature.template.Template;
//import org.spongepowered.asm.mixin.Mixin;
//import org.spongepowered.asm.mixin.gen.Invoker;
//
//import javax.annotation.Nullable;
//
//@Mixin(Template.class)
//public interface TemplateInvoker {
//
//    @Invoker(value = "addEntitiesToWorld")
//    void addEntitiesWorld(IWorld worldIn, BlockPos offsetPos, PlacementSettings placementIn, Mirror mirrorIn, Rotation rotationIn, BlockPos centerOffset, @Nullable MutableBoundingBox boundsIn);
//}
