package com.lapisliozuli.bunnyloversmc.items;

import com.lapisliozuli.bunnyloversmc.BunnyLovers;
import net.minecraft.item.FoodComponents;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BunnyItems {
    public static final Item BUNNY_BERRIES = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
//    public class BunnyBerryItem extends BoneMealItem{
//    }
    public static final Item TANNED_LEATHER = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
    public static final Item LEATHER_STRIP = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
    // Monilaria obconica / M. moniliformis
    public static final Item BUNNY_SUCCULENT = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));
    // I have an amazing idea. Make Imitation Rabbit Meat from Carrots and Eggs. Double rabbit reference, and it naturally resolves texturing issues.
    public static final Item IMITATION_RABBIT_MEAT = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.RABBIT));
    public static final Item COOKED_IMITATION_RABBIT_MEAT = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.COOKED_RABBIT));
    public static final Item IMITATION_RABBIT_STEW = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.RABBIT_STEW));
    public static final Item EASTER_BUNNY_EGG = new Item(new Item.Settings().group(BunnyLovers.BUNNYLOVERSMC));


    public static void registerBunnyItems() {
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_berries"), BUNNY_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "tanned_leather"), TANNED_LEATHER);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "leather_strip"), LEATHER_STRIP);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_succulent"), BUNNY_SUCCULENT);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "imitation_rabbit_meat"), IMITATION_RABBIT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "cooked_imitation_rabbit_meat"), COOKED_IMITATION_RABBIT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "imitation_rabbit_stew"), IMITATION_RABBIT_STEW);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "easter_bunny_egg"), EASTER_BUNNY_EGG);
    }
}
