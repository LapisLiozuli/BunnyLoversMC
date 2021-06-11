package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

// This actually targets a static inner class within the RabbitEntity class.
@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class RabbitEntityMixin {
	public int berryDropTime;


	public void bunnyloversmc$setBerryDropTime(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci) {
		// 5-10 min interval i.e. 20 ticks per second.
//		this.eggLayTime = this.random.nextInt(6000) + 6000;
		this.berryDropTime = 200;
	}
}

//	@Inject(method = "tick",
////			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/state/State;get(Lnet/minecraft/state/property/Property;)Ljava/lang/Comparable;", shift = At.Shift.AFTER)
////			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldAccess;syncWorldEvent(ILnet/minecraft/util/math/BlockPos;I)V", shift = At.Shift.AFTER)
//			at = @At(value = "INVOKE",
//					target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z",
//					ordinal = 2,
//					shift = At.Shift.BY,
//					by = 2),
//			locals = LocalCapture.PRINT
//	)
//	public void bunnyloversmc$tick(CallbackInfo ci) {
//		// Need to access outer class from inner class.
////		if (!this.world.isClient && this.isAlive() && !this.isBaby() && --this.berryDropTime <= 0) {
////			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
////			this.dropItem(BunnyItems.BUNNY_BERRIES);
//	}


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
