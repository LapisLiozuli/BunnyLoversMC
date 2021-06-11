package com.lapisliozuli.bunnyloversmc.items;

import com.lapisliozuli.bunnyloversmc.BunnyLovers;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BunnyItems {
    public static final Item BUNNY_BERRIES = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
    public static final Item TANNED_LEATHER = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
    public static final Item LEATHER_STRIP = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));

    public static void registerBunnyItems() {
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_berries"), BUNNY_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "tanned_leather"), TANNED_LEATHER);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "leather_strip"), LEATHER_STRIP);

    }


}
