package com.lapisliozuli.bunnyloversmc;

import com.google.common.collect.ImmutableMap;
import com.lapisliozuli.bunnyloversmc.items.BunnyItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.VillagerProfession;

public class Trades {
//    map.put(VillagerProfession.BUTCHER, copyToFastUtilMap(ImmutableMap.of(1,
//        new TradeOffers.Factory[]{
//              new TradeOffers.BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2),
//              new TradeOffers.BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2),
//              new TradeOffers.BuyForOneEmeraldFactory(Items.RABBIT, 4, 16, 2),
//              new TradeOffers.SellItemFactory(Items.RABBIT_STEW, 1, 1, 1)}, 2,
//        new TradeOffers.Factory[]{
//            new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2),
//            new TradeOffers.SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5),
//            new TradeOffers.SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5)}, 3,
//        new TradeOffers.Factory[]{
//            new TradeOffers.BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20),
//            new TradeOffers.BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20)}, 4,
//        new TradeOffers.Factory[]{
//            new TradeOffers.BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30)}, 5,
//        new TradeOffers.Factory[]{
//            new TradeOffers.BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30)})));
    private static Int2ObjectMap<TradeOffers.Factory[]> mapLevelToTrades(ImmutableMap<Integer, TradeOffers.Factory[]> trades) {
        return new Int2ObjectOpenHashMap(trades);
    }

    public static void addBunnyFriendlyTrades() {
        TradeOffers.Factory[] clericBuyFoot = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.BUNNY_SUCCULENT, 2, 12, 20)};
//        TradeOffers.Factory[] butcherBuyRabbit = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.IMITATION_RABBIT_MEAT, 4, 16, 2)};
        TradeOffers.BuyForOneEmeraldFactory butcherBuyRabbit = new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.IMITATION_RABBIT_MEAT, 4, 16, 2);
        TradeOffers.Factory[] leatherworkerBuyHide = new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.LEATHER_STRIP, 9, 12, 20)};

//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.CLERIC, 3, clericBuyFoot);
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.BUTCHER, 1, butcherBuyRabbit);
//        TradeOfferHelper.registerVillagerOffers(VillagerProfession.LEATHERWORKER, 3, leatherworkerBuyHide);

//         This overwrites the original map.
//        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.BUTCHER, mapLevelToTrades(ImmutableMap.of(1,butcherBuyRabbit)));
        TradeOffers.PROFESSION_TO_LEVELED_TRADE.put(VillagerProfession.BUTCHER, mapLevelToTrades(ImmutableMap.of(
                1, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.CHICKEN, 14, 16, 2),
                                                new TradeOffers.BuyForOneEmeraldFactory(Items.PORKCHOP, 7, 16, 2),
                                                // New Trade
//                                                new TradeOffers.BuyForOneEmeraldFactory(BunnyItems.IMITATION_RABBIT_MEAT, 4, 16, 2),
                                                butcherBuyRabbit,
                                                new TradeOffers.SellItemFactory(Items.RABBIT_STEW, 1, 1, 1)},
                2, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.COAL, 15, 16, 2),
                                                new TradeOffers.SellItemFactory(Items.COOKED_PORKCHOP, 1, 5, 16, 5),
                                                new TradeOffers.SellItemFactory(Items.COOKED_CHICKEN, 1, 8, 16, 5)},
                3, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.MUTTON, 7, 16, 20),
                                                new TradeOffers.BuyForOneEmeraldFactory(Items.BEEF, 10, 16, 20)},
                4, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.DRIED_KELP_BLOCK, 10, 12, 30)},
                5, new TradeOffers.Factory[]{new TradeOffers.BuyForOneEmeraldFactory(Items.SWEET_BERRIES, 10, 12, 30)})));
    }
}
