package com.binance.client.examples.orders;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.NewOrderRespType;
import com.binance.client.model.enums.OrderSide;
import com.binance.client.model.enums.OrderType;
import com.binance.client.model.enums.TimeInForce;

import java.math.BigDecimal;

public class PostOrderBuyLongMarket {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions(true);
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                options);
//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "1", "1", null, null, null, null));

        // place dual position side order.
        // Switch between dual or both position side, call: com.binance.client.examples.trade.ChangePositionSide
        BigDecimal mainSum = new BigDecimal("1000.0").setScale(3, BigDecimal.ROUND_CEILING);

        BigDecimal a = syncRequestClient.getOrderBook("BTCUSDT", null).getAsks().get(0).getPrice();
        System.out.println(a.toString());
        BigDecimal calculateQuantity = mainSum.divide(a, BigDecimal.ROUND_CEILING);
        String quantity = calculateQuantity.toString();
        System.out.println("quantity: " + quantity);

        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.BUY, null, OrderType.MARKET, null,
                quantity, "", null, null, null,
                null, NewOrderRespType.RESULT));
    }
}
