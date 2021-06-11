package com.lapisliozuli.bunnyloversmc.mixins;

import net.minecraft.entity.passive.RabbitEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(RabbitEntity.class)
public class NoFallDamageMixin {
	public boolean bunnyloversmc$handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}
}
