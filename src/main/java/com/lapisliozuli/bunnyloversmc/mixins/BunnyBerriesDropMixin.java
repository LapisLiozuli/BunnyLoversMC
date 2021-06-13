package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.ItemStack;
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

import java.util.Random;

@Mixin(targets = "net.minecraft.entity.passive.RabbitEntity$EatCarrotCropGoal")
public class BunnyBerriesDropMixin {
	@Shadow
	@Final
	private RabbitEntity rabbit;
	// Fullness should reduce the frequency at which Rabbits poop. (Should I just set to 1 throughout?)
	int fullness = 0;


	@Inject(
			method = "Lnet/minecraft/entity/passive/RabbitEntity$EatCarrotCropGoal;tick()V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/block/Block;getRawIdFromState(Lnet/minecraft/block/BlockState;)I", shift = At.Shift.AFTER),
			locals = LocalCapture.CAPTURE_FAILSOFT
	)
	public void bunnyloversmc$tick(CallbackInfo ci, World world, BlockPos blockPos, BlockState blockState, Block block, Integer integer) {
		// This determines the amount of fullness.
		if (fullness < 3) {
			fullness += 1;
		}
		else {
			// Current ratio of Bunny Berries to Carrots is 1:1.
			Random random = rabbit.getRandom();
			rabbit.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (random.nextFloat() - random.nextFloat()) * 0.2F + 1.0F);
			// Drops a few Bunny Berries in an ItemStack instead of a single Item.
			// Fullness + 1 because people count from 1 but computers count from 0.
//			rabbit.dropStack(new ItemStack(BunnyItems.BUNNY_BERRIES, fullness + 1));
			// Drops a random number of Bunny Berries ranging from 1-4. Can tweak constant and random components.
			int excretionCount = 1 + random.nextInt(fullness + 1);
			rabbit.dropStack(new ItemStack(BunnyItems.BUNNY_BERRIES, excretionCount));
			// Resets fullness.
			fullness = 0;
//			// Fullness decreases by a variable amount.
//			fullness -= excretionCount;
		}
	}
}