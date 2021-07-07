package com.lapisliozuli.bunnyloversmc.mixins;

import net.minecraft.recipe.Ingredient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(Ingredient.class)
public class IngredientMixin {
//    // Inject to StackEntry
//    @Inject(at = @At("HEAD"),
//            method = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", cancellable = true)
}
