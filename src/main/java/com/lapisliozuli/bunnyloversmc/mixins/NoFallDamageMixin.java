package com.lapisliozuli.bunnyloversmc.mixins;

import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.entity.passive.RabbitEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RabbitEntity.class)
public class NoFallDamageMixin {
//	@Inject(at = @At("HEAD"), method = "init()V")
	public boolean handleFallDamage(float fallDistance, float damageMultiplier) {
		return false;
	}
}
