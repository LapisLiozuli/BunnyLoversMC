package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(RabbitEntity.class)
public abstract class NoFallDamageMixin extends AnimalEntity {
	protected NoFallDamageMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}

//	@Inject(
//			method = "wantsCarrots()Z",
//			at = @At(value="TAIL")
//	)
//	public void shouldContinue(CallbackInfoReturnable<Boolean> cir) {
//		this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 0.2F + 1.0F);
//		this.dropItem(BunnyItems.BUNNY_BERRIES);
//	}
}
