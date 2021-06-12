package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class BunnyBerriesDropMixin {
	@Shadow
	@Final
	private RabbitEntity rabbit;


	@Inject(
			method = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;tick()V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRawIdFromState(Lnet/minecraft/block/BlockState;)I", shift = At.Shift.AFTER),
			locals = LocalCapture.CAPTURE_FAILSOFT
	)
	public void bunnyloversmc$tick(CallbackInfo ci, World world, BlockPos blockPos, BlockState blockState, Block block, Integer integer) {
		rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, 0.2F + 1.0F);
		rabbit.dropItem(BunnyItems.BUNNY_BERRIES);
	}
}