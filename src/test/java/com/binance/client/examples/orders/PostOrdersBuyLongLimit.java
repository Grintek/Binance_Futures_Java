package com.binance.client.examples.orders;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.constants.PrivateConfig;
import com.binance.client.model.enums.NewOrderRespType;
import com.binance.client.model.enums.OrderSide;
import com.binance.client.model.enums.OrderType;
import com.binance.client.model.enums.TimeInForce;
import javafx.scene.transform.Scale;

import java.math.BigDecimal;

public class PostOrdersBuyLongLimit {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions();
        options.setUrl("https://testnet.binancefuture.com");
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                options);
//        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.SELL, PositionSide.BOTH, OrderType.LIMIT, TimeInForce.GTC,
//                "1", "1", null, null, null, null));

        // place dual position side order.
        // Switch between dual or both position side, call: com.binance.client.examples.trade.ChangePositionSide
        String price = syncRequestClient.getMarkPrice("BTCUSDT").get(0).getMarkPrice().setScale(1, BigDecimal.ROUND_CEILING).toPlainString();
        System.out.println(price);
        System.out.println(syncRequestClient.postOrder("BTCUSDT", OrderSide.BUY, null, OrderType.LIMIT, TimeInForce.GTC,
                "1", price, null, null, null, null, NewOrderRespType.RESULT));
    }
}
