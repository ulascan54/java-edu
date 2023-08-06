package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MarketApiRestAsyncClient {
    private static final AtomicInteger counter = new AtomicInteger();
    private static final String URL = "https://api.binance.com/api/v3/ticker/price?symbol=%s";

    //Duration: 1037, Average:51.85
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var start = System.currentTimeMillis();
        var markets = List.of("BTCUSDT", "ETHBTC", "LTCBTC", "BNBBTC", "NEOBTC", "QTUMETH", "EOSETH", "SNTETH", "BNTETH", "BCCBTC");
        markets.forEach(symbol -> {
            var request = HttpRequest.newBuilder()
                    .uri(URI.create(URL.formatted(symbol)))
                    .header("Accept", "application/json")
                    .build();
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenAccept(response -> {
                        var index = counter.incrementAndGet();
                        System.out.println(index + ": " + response.body());
                        if (index == markets.size()) {
                            var stop = System.currentTimeMillis();
                            System.out.println("Duration: %4d, Average:%4.2f".formatted((stop - start), ((double) (stop - start) / 20.0)));
                        }
                    });
        });
        try {
            TimeUnit.MINUTES.sleep(1);
        } catch (Exception e) {
        }
    }
}
