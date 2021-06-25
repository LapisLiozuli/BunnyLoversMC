package com.lapisliozuli.bunnyloversmc;

import com.lapisliozuli.bunnyloversmc.blocks.BunnySucculentBlock;
import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.Entity;
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
	public static BunnySucculentBlock BUNNY_SUCCULENT_BLOCK = new BunnySucculentBlock(AbstractBlock.Settings.of(Material.PLANT)
			.noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP));

	@Override
	public void onInitialize() {
		BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), BUNNY_SUCCULENT_BLOCK);
//		BUNNY_SUCCULENT_BLOCK = Registry.register(Registry.BLOCK,
		Registry.register(Registry.BLOCK,
				new Identifier(MOD_ID, "bunny_succulent"),
				BUNNY_SUCCULENT_BLOCK);
//				new BunnySucculentBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
		BunnyItems.registerBunnyItems();
		Trades.addBunnyFriendlyTrades();
//		CARROTS = register("carrots", new CarrotsBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)));
	}
}
