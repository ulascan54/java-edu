package com.example.lottery.application;

import com.example.lottery.service.LotteryService;
import com.example.lottery.service.soup.StandardLotteryService;

import javax.xml.ws.Endpoint;

public class LotteryApplication {
    public static void main(String[] args) {
        LotteryService lotteryService = new StandardLotteryService();
        Endpoint.publish("http://localhost:8100/lottery",lotteryService);
    }
}
