package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MarketApiRestAsyncClient {
    private static final AtomicInteger counter = new AtomicInteger();
    private static final String URL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";

    //Duration: 1037, Average:51.85
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Accept", "application/json")
                .build();
        var start = System.currentTimeMillis();
        for (var i = 0; i < 20; ++i) {
            client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenAccept(response -> {
                        System.out.println(response.body());
                        if (counter.incrementAndGet() == 20){
                            var stop = System.currentTimeMillis();
                            System.out.println("Duration: %4d, Average:%4.2f".formatted((stop - start), ((stop - start) / 20.0)));
                        }});}
        try {TimeUnit.MINUTES.sleep(1);} catch (Exception e) {}
    }
}
