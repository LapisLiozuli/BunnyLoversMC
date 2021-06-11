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

@Mixin(RabbitEntity.class)
public abstract class RabbitEntityMixin extends AnimalEntity{
	public int berryDropTime;

	protected RabbitEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	public boolean bunnyloversmc$handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}
	public void bunnyloversmc$setBerryDropTime(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci){
		// 5-10 min interval i.e. 20 ticks per second.
//		this.eggLayTime = this.random.nextInt(6000) + 6000;
		this.berryDropTime = 200;
	}

//	@Inject(at = @At("HEAD"), method = "RabbitEntity")
//	public void bunnyloversmc$RabbitEntity(EntityType<? extends RabbitEntity> entityType, World world, CallbackInfo ci){
//		// 5-10 min interval i.e. 20 ticks per second.
////		this.eggLayTime = this.random.nextInt(6000) + 6000;
//		this.berryDropTime = 200;
//	}

	@Inject(at = @At("HEAD"), method = "tickMovement")
	public void bunnyloversmc$tickMovement(CallbackInfo ci) {
		if (!this.world.isClient && this.isAlive() && !this.isBaby() && --this.berryDropTime <= 0) {
			this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
			this.dropItem(BunnyItems.BUNNY_BERRIES);
//			this.berryDropTime = this.random.nextInt(6000) + 6000;
			this.berryDropTime = 200;
		}

	}
}
