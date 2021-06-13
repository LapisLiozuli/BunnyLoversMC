package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(BrewingRecipeRegistry.class)
public class NewLeapingPotionMixin {
	@Shadow
	private static void registerPotionRecipe(Potion input, Item item, Potion output) {
	}

	@Inject(method = "registerDefaults()V", at = @At(value="TAIL"))
	private static void registerDefaults(CallbackInfo ci) {
		registerPotionRecipe(Potions.AWKWARD, BunnyItems.BUNNY_SUCCULENT, Potions.LEAPING);
	}
}
