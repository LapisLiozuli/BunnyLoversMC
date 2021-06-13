package com.lapisliozuli.bunnyloversmc.mixins;

import net.minecraft.entity.passive.RabbitEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RabbitEntity.class)
public abstract class NoFallDamageMixin {
	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}
}
