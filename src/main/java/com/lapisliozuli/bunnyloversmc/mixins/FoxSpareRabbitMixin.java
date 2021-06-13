package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FoxEntity.class)
public abstract class FoxSpareRabbitMixin extends AnimalEntity{
	protected FoxSpareRabbitMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

//	@Inject(
//			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
//			at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()Z", shift = At.Shift.AFTER),
//			locals = LocalCapture.PRINT
//	)
//	public void bunnyloversmc$initEquipment(LocalDifficulty difficulty, CallbackInfo ci) {
//		ItemStack itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//	}

	@Inject(
//	@ModifyVariable(
//			print = true,
			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
//			slice = @Slice(
//					from = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()")
//			),
			at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()Z", shift = At.Shift.AFTER),
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V", ordinal = 3, shift = At.Shift.AFTER),
			locals = LocalCapture.PRINT
	)
	public void bunnyloversmc$initEquipment(LocalDifficulty difficulty, CallbackInfo ci) {
		ItemStack itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
	}

//	@ModifyVariable(
//			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
//			at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()Z")
////			slice = @Slice(
////					from = @At(value = "INVOKE", target = "Ljava/util/Random;nextBoolean()")
////			),
////			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
////			at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V", ordinal = 3)
////			at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V", ordinal = 3, shift = At.Shift.AFTER)
//	)
//	public ItemStack bunnyloversmc$initEquipment(ItemStack itemStack6) {
//		return this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//	}
}
