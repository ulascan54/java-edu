package com.example.application;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MarketApiRestSyncClient {
    private static final String  URL = "https://api.binance.com/api/v3/ticker/price?symbol=BTCUSDT";
    // Duration: 8532, Average:426.60
    public static void main(String[] args) throws IOException, InterruptedException {
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder()
                .uri(URI.create(URL))
                .header("Accept","application/json")
                .build();
        var start = System.currentTimeMillis();
        for (var i=0 ; i< 20; ++i){
            var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            System.out.println(response);
        }
        var stop = System.currentTimeMillis();
        System.out.println("Duration: %4d, Average:%4.2f".formatted((stop-start),((stop-start)/20.0)));

    }
}
