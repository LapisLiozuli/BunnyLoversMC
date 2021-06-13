package com.lapisliozuli.bunnyloversmc;

import com.lapisliozuli.bunnyloversmc.blocks.BunnySucculentBlock;
import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CarrotsBlock;
import net.minecraft.block.Material;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BunnyLovers implements ModInitializer {
	public static final String MOD_ID = "bunnyloversmc";
	public static final ItemGroup BUNNYLOVERSMC = FabricItemGroupBuilder.create(
			new Identifier(MOD_ID, "bunnyloversmc"))
			.icon(() -> new ItemStack(Items.CARROT))
			.build();
//	public static Block BUNNY_SUCCULENT_BLOCK;

	@Override
	public void onInitialize() {
		BunnyItems.registerBunnyItems();
		Registry.register(Registry.BLOCK,
				new Identifier(MOD_ID, "bunny_succulent"),
				new BunnySucculentBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
//		CARROTS = register("carrots", new CarrotsBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));

	}
}
