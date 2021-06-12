package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

// This actually targets a static inner class within the RabbitEntity class.
@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class RabbitEntityMixin {
	@Shadow
	@Final
	private RabbitEntity rabbit;
	public int berryDropTime;


	public void bunnyloversmc$setBerryDropTime(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci) {
		// 5-10 min interval i.e. 20 ticks per second.
//		this.eggLayTime = this.random.nextInt(6000) + 6000;
		this.berryDropTime = 200;
	}


//	@Inject(method = "tick",
	@Inject(method = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;tick()V",
//			at = @At(value="TAIL"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;getLookControl()Lnet/minecraft/entity/ai/control/LookControl;"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/ai/goal/MoveToTargetPosGoal;hasReached()Z"),
			// These methods lie within the if clause.
//			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/state/State;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldAccess;syncWorldEvent(ILnet/minecraft/util/math/BlockPos;I)V"),
//			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/entity/passive/RabbitEntity;method_6613(Lnet/minecraft/entity/passive/RabbitEntity;I)I"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z"),
			// IntelliJ accepts the path bytecode but then still raises InvocationTargetException.
			// Maybe failed because private access.
			at = @At(value = "FIELD", target = "Lnet/minecraft/entity/passive/RabbitEntity;moreCarrotTicks:I", args = { "log=true" }, opcode = 1),
//			at = @At(value = "INVOKE",
//					target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
//					ordinal = 1),
			locals = LocalCapture.PRINT
	)

	public void bunnyloversmc$tick(CallbackInfo ci) {
		// Need to access outer class from inner class.
		if (!rabbit.world.isClient && rabbit.isAlive() && !rabbit.isBaby() && --this.berryDropTime <= 0) {
//			rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (rabbit.random.nextFloat() - rabbit.random.nextFloat()) * 0.2F + 1.0F);
			rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 0.2F + 1.0F);
			rabbit.dropItem(BunnyItems.BUNNY_BERRIES);
		}
	}
}

//@Mixin(RabbitEntity.class)
//public class RabbitEntityMixin extends AnimalEntity {
//	@Inject(at = @At("HEAD"), method = "RabbitEntity")
//	public void bunnyloversmc$RabbitEntity(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci){
//		// 5-10 min interval i.e. 20 ticks per second.
////		this.eggLayTime = this.random.nextInt(6000) + 6000;
//		this.berryDropTime = 200;
//	}

//	@Inject(at = @At("HEAD"), method = "tickMovement")
//	public void bunnyloversmc$tickMovement(CallbackInfo ci) {
//		if (!this.world.isClient && this.isAlive() && !this.isBaby() && --this.berryDropTime <= 0) {
//			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
//			this.dropItem(BunnyItems.BUNNY_BERRIES);
////			this.berryDropTime = this.random.nextInt(6000) + 6000;
//			this.berryDropTime = 200;
//		}
//	}
//}
