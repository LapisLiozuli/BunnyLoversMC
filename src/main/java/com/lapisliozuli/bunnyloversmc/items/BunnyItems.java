package com.lapisliozuli.bunnyloversmc.items;

import com.lapisliozuli.bunnyloversmc.BunnyLovers;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BunnyItems {
    public static final Item BUNNY_BERRIES = new BunnyBerries(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC));
    public static final Item TANNED_LEATHER = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC));
    public static final Item LEATHER_STRIP = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC));
    // Monilaria obconica / M. moniliformis
    public static Item BUNNY_SUCCULENT;
    //    public static final Item BUNNY_SUCCULENT = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC));
//    public static final Item BUNNY_SUCCULENT = new AliasedBlockItem(BunnyLovers.BUNNY_SUCCULENT_BLOCK, (new FabricItemSettings()));
//    CARROT = register((String)"carrot", (Item)(new AliasedBlockItem(Blocks.CARROTS, (new Item.Settings()).group(ItemGroup.FOOD).food(FoodComponents.CARROT))));
    // I have an amazing idea. Make Imitation Rabbit Meat from Carrots and Eggs. Double rabbit reference, and it naturally resolves texturing issues.
    public static final Item IMITATION_RABBIT_MEAT = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.RABBIT));
    public static final Item COOKED_IMITATION_RABBIT_MEAT = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.COOKED_RABBIT));
    public static final Item IMITATION_RABBIT_STEW = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC).food(FoodComponents.RABBIT_STEW));
    public static final Item EASTER_BUNNY_EGG = new Item(new FabricItemSettings().group(BunnyLovers.BUNNYLOVERSMC));


    public static void registerBunnyItems() {
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_berries"), BUNNY_BERRIES);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "tanned_leather"), TANNED_LEATHER);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "leather_strip"), LEATHER_STRIP);
//        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_succulent"), BUNNY_SUCCULENT);
//        BUNNY_SUCCULENT = new AliasedBlockItem(BunnyLovers.BUNNY_SUCCULENT_BLOCK, new Item.Settings());
        BUNNY_SUCCULENT = Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "bunny_succulent"),
                new AliasedBlockItem(BunnyLovers.BUNNY_SUCCULENT_BLOCK, new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "imitation_rabbit_meat"), IMITATION_RABBIT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "cooked_imitation_rabbit_meat"), COOKED_IMITATION_RABBIT_MEAT);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "imitation_rabbit_stew"), IMITATION_RABBIT_STEW);
        Registry.register(Registry.ITEM, new Identifier(BunnyLovers.MOD_ID, "easter_bunny_egg"), EASTER_BUNNY_EGG);
    }
}
