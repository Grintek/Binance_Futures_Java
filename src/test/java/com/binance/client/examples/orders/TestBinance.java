package com.binance.client.examples.orders;

import com.binance.client.RequestOptions;
import com.binance.client.SyncRequestClient;
import com.binance.client.examples.constants.PrivateConfig;

import java.math.BigDecimal;

public class TestBinance {
    public static void main(String[] args) {
        RequestOptions options = new RequestOptions(true);
        SyncRequestClient syncRequestClient = SyncRequestClient.create(PrivateConfig.API_KEY, PrivateConfig.SECRET_KEY,
                options);

    }
}
