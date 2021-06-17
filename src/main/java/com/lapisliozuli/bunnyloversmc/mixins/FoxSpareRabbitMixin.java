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
public abstract class FoxSpareRabbitMixin extends AnimalEntity{
	protected FoxSpareRabbitMixin(EntityType<? extends AnimalEntity> entityType, World world) {
		super(entityType, world);
	}
	ItemStack itemStack;

//	/**
//	 * @author
//	 */
//	@Overwrite
//	public void initEquipment(LocalDifficulty difficulty) {
//		if (this.random.nextFloat() < 0.2F) {
//			float f = this.random.nextFloat();
//			ItemStack itemStack6;
//			if (f < 0.05F) {
//				itemStack6 = new ItemStack(Items.EMERALD);
//			} else if (f < 0.2F) {
//				itemStack6 = new ItemStack(Items.EGG);
//			} else if (f < 0.4F) {
////				itemStack6 = this.random.nextBoolean() ? new ItemStack(Items.RABBIT_FOOT) : new ItemStack(Items.RABBIT_HIDE);
//				itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.IMITATION_RABBIT_MEAT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//			} else if (f < 0.6F) {
//				itemStack6 = new ItemStack(Items.WHEAT);
//			} else if (f < 0.8F) {
//				itemStack6 = new ItemStack(Items.LEATHER);
//			} else {
//				itemStack6 = new ItemStack(Items.FEATHER);
//			}
//
//			this.equipStack(EquipmentSlot.MAINHAND, itemStack6);
//		}
//
//	}

	@Inject(
			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
//			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/mob/MobEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.BEFORE),
			at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/FoxEntity;equipStack(Lnet/minecraft/entity/EquipmentSlot;Lnet/minecraft/item/ItemStack;)V", shift = At.Shift.BEFORE),
//			at = @At(value = "INVOKE", target = "Ljava/util/Random;nextFloat()F", shift = At.Shift.BEFORE),
			locals = LocalCapture.CAPTURE_FAILSOFT
	)
	public void bunnyloversmc$getEquippedItemStack(LocalDifficulty difficulty, CallbackInfo ci, float f, ItemStack itemStack6) {
		if ((f < 0.4F) && (f >= 0.2F)) {
			itemStack = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
		}
		else {
			itemStack = itemStack6;
		}
//		ItemStack itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//		itemStack = itemStack6;
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

//	@Inject(
//			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
//			at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()Z", shift = At.Shift.AFTER),
//			locals = LocalCapture.PRINT
//	)
//	public void bunnyloversmc$initEquipment(LocalDifficulty difficulty, CallbackInfo ci) {
//		ItemStack itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//	}

//	@Inject(
////	@ModifyVariable(
////			print = true,
//			method = "Lnet/minecraft/entity/passive/FoxEntity;initEquipment(Lnet/minecraft/world/LocalDifficulty;)V",
////			slice = @Slice(
////					from = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()")
////			),
//			at = @At(value = "INVOKE_ASSIGN", target = "Ljava/util/Random;nextBoolean()Z", shift = At.Shift.AFTER),
////			at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;<init>(Lnet/minecraft/item/ItemConvertible;)V", ordinal = 3, shift = At.Shift.AFTER),
//			locals = LocalCapture.PRINT
//	)
//	public void bunnyloversmc$initEquipment(LocalDifficulty difficulty, CallbackInfo ci) {
//		ItemStack itemStack6 = this.random.nextBoolean() ? new ItemStack(BunnyItems.BUNNY_SUCCULENT) : new ItemStack(BunnyItems.LEATHER_STRIP);
//	}

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
