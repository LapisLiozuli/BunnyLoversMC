package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarrotsBlock;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

// This actually targets a static inner class within the RabbitEntity class.
@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class RabbitEntityMixin {
	@Shadow
	@Final
	private RabbitEntity rabbit;
	protected BlockPos targetPos;
	public int berryDropTime;


	public void bunnyloversmc$setBerryDropTime(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci) {
		// 5-10 min interval i.e. 20 ticks per second.
//		this.eggLayTime = this.random.nextInt(6000) + 6000;
		this.berryDropTime = 200;
	}


	// THIS THING HOKSDNAKSNITI IT PROVES THAT THE INJECFT TRULY LTLU YL WORKS IN INNER CLASSSSASEASESE.
	// THEN WHY DOESN'T IT IN THE METHOD THAT I'M ACTUALLY TARGETING????
	@Inject(
			method = "shouldContinue()Z",
			at = @At(value="TAIL")
	)
	public void shouldContinue(CallbackInfoReturnable<Boolean> cir) {
		rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 0.2F + 1.0F);
		rabbit.dropItem(BunnyItems.BUNNY_BERRIES);	}


	@Inject(
			method = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;tick()V",
//			at = @At(value="TAIL"),
//			at = @At(value = "INVOKE_ASSIGN", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/BlockState;I)Z", ordinal = 1),
			// This should work but now every single rabbit poops itself at the thought of eating a carrot.
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRawIdFromState(Lnet/minecraft/block/BlockState;)I", shift = At.Shift.BY, by = 1),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRawIdFromState(Lnet/minecraft/block/BlockState;)I"),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/world/WorldAccess;syncWorldEvent(ILnet/minecraft/util/math/BlockPos;I)V"),
//			at = @At(value = "FIELD", target = "Lnet/minecraft/entity/passive/RabbitEntity;moreCarrotTicks:I"),
//			at = @At(value = "FIELD", target = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;hasTarget:Z"),
//			at = @At(value = "FIELD", target = "Lnet/minecraft/entity/ai/goal/MoveToTargetPosGoal;cooldown:I"),
			locals = LocalCapture.PRINT
	)
	public void bunnyloversmc$tick(CallbackInfo ci) {
		World world = this.rabbit.world;
		BlockPos blockPos = this.targetPos.up();
		BlockState blockState = world.getBlockState(blockPos);
		Block block = blockState.getBlock();
		Integer integer = (Integer)blockState.get(CarrotsBlock.AGE);
		rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 0.2F + 1.0F);
		rabbit.dropItem(BunnyItems.BUNNY_BERRIES);
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
