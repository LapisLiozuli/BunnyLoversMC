package com.lapisliozuli.bunnyloversmc;

import com.google.common.collect.ImmutableMap;
import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class Trades {
    private static Int2ObjectMap<TradeOffers.Factory[]> mapLevelToTrades(ImmutableMap<Integer, TradeOffers.Factory[]> trades) {
        return new Int2ObjectOpenHashMap(trades);
    }

    public static void addBunnyFriendlyTrades() {
        // Overwrite Cleric trade for Rabbit Foot.
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.CLERIC, mapLevelToTrades(ImmutableMap.of(
                1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.ROTTEN_FLESH, 32, 16, 2),
                                                 new TradeOffers.SellItemFactory(Items.REDSTONE, 1, 2, 1)},
                2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.GOLD_INGOT, 3, 12, 10),
                                                 new TradeOffers.SellItemFactory(Items.LAPIS_LAZULI, 1, 1, 5)},
                                                 // New Trade.
                3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.BUNNY_SUCCULENT, 2, 12, 20),
                                                 new TradeOffers.SellItemFactory(Blocks.GLOWSTONE, 4, 1, 12, 10)},
                4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30),
                                                 new TradeOffers.BuyForOneEmeraldFactory(Items.GLASS_BOTTLE, 9, 12, 30),
                                                 new TradeOffers.SellItemFactory(Items.ENDER_PEARL, 5, 1, 15)},
                5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.NETHER_WART, 22, 12, 30),
                                                 new TradeOffers.SellItemFactory(Items.EXPERIENCE_BOTTLE, 3, 1, 30)})));

        // Overwrite Butcher trades for Rabbit and Rabbit Stew.
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.BUTCHER, mapLevelToTrades(ImmutableMap.of(
                1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2),
                                                 new TradeOffers.BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2),
                                                 // New Trades.
                                                 new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.IMITATION_RABBIT_MEAT, 4, 16, 2),
                                                 new TradeOffers.SellItemFactory(BunnyItems.IMITATION_RABBIT_STEW, 1, 1, 1)},
                2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2),
                                                 new TradeOffers.SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5),
                                                 new TradeOffers.SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5)},
                3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20),
                                                 new TradeOffers.BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20)},
                4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30)},
                5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30)})));

        // Overwrite Leatherworker trades for Rabbit Hide.
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.LEATHERWORKER, mapLevelToTrades(ImmutableMap.of(
                1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.LEATHER, 6, 16, 2),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_LEGGINGS, 3),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)},
                2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.FLINT, 26, 12, 10),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 5),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_BOOTS, 4, 12, 5)},
                                                 // New Trade.
                3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.LEATHER_STRIP, 9, 12, 20),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_CHESTPLATE, 7)},
                4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SCUTE, 4, 12, 30),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HORSE_ARMOR, 6, 12, 15)},
                5, new TradeOffers.Factory[]{new TradeOffers.SellItemFactory(new ItemStack(Items.SADDLE), 6, 1, 12, 30, 0.2F),
                                                 new TradeOffers.SellDyedArmorFactory(Items.LEATHER_HELMET, 5, 12, 30)})));


    }
}
