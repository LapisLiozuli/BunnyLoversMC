package com.lapisliozuli.bunnyloversmc;

import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class BunnyLovers implements ModInitializer {
	public static final String MOD_ID = "bunnyloversmc";
	public static final ItemGroup BUNNYLOVERSMC = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "bunnyloversmc"))
			.icon(() -> new ItemStack(Items.CARROT))
			.build();

	@Override
	public void onInitialize() {
		BunnyItems.registerBunnyItems();
	}
}
