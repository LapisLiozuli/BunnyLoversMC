package com.lapisliozuli.bunnyloversmc.mixins;

import com.lapisliozuli.bunnyloversmc.BunnyLovers;
import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.registry.Registry;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Items.class)
public class ItemsMixin {
    // Isn't this a registry replace? I'm actually wary of this...
    // https://github.com/ConsistencyPlus/ConsistencyPlus/blob/master/src/main/java/io/github/consistencyplus/consistency_plus/mixin/BlocksMixin.java
    @Inject(at = @At("HEAD"),
            method = "Lnet/minecraft/item/Items;register(Ljava/lang/String;Lnet/minecraft/item/Item;)Lnet/minecraft/item/Item;", cancellable = true)
    private static void register(String id, Item item, CallbackInfoReturnable<Item> cir) {
        if (id.equals("rabbit")) {
            cir.setReturnValue(Registry.register(Registry.ITEM, id, BunnyItems.IMITATION_RABBIT_MEAT));
        }
    }
}