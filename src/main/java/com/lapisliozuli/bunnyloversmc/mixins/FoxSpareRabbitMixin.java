package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(FoxEntity.class)
public abstract class FoxSpareRabbitMixin extends AnimalEntity {
	protected FoxSpareRabbitMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}

	ItemStack itemStack;

	@Inject(
			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/FoxEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.BEFORE),
			locals = LocalCapture.CAPTURE_FAILSOFT
	)
	public void bunnyloversmc$getEquippedItemStack(LocalDifficulty difficulty, CallbackInfo ci, float f, ItemStack itemStack6) {
		if ((f < 0.4F) && (f >= 0.2F)) {
			itemStack = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
		}
		// Without this clause, the original drops (except Eggs and Wheat) will be replaced by BunnyItems.
		else {
			itemStack = itemStack6;
		}
	}

	@ModifyVariable(
			print = true,
			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
			at = @At(value = "INVOKE",
					target = "Lnet/minecraft/entity/passive/FoxEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V",
					shift = At.Shift.BEFORE)
	)
	public ItemStack bunnyloversmc$initEquipment(ItemStack itemStack6) {
		return itemStack;
	}
}