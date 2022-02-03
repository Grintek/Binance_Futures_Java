package com.binance.client.examples.orders;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.NewOrderRespType;
import com.binance.client.model.enums.OrderSide;
import com.binance.client.model.enums.OrderType;

import java.math.BigDecimal;

/**
 * @author Grigory Yakovlev
 */
public class PostOrderSellLongMarket {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions(true);
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                options);
//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "1", "1", null, null, null, null));

        // place dual position side order.
        // Switch between dual or both position side, call: com.binance.client.examples.trade.ChangePositionSide

        BigDecimal qu = new BigDecimal("0.028");
        BigDecimal percent = new BigDecimal("0.5");
        BigDecimal main = qu.multiply(percent).setScale(3, BigDecimal.ROUND_CEILING);
        String quantity = main.toString();
        System.out.println(quantity);

        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, null, OrderType.MARKET, null,
                quantity, "", "true", null, null,
                null, NewOrderRespType.RESULT));
    }
}
