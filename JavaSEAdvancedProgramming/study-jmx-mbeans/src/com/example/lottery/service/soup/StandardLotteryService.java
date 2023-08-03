package com.example.lottery.service.soup;

import com.example.lottery.jmx.QualityMetric;
import com.example.lottery.jmx.WebServiceQualitySamplerMXBean;
import com.example.lottery.service.LotteryService;

import javax.jws.WebService;
import java.util.List;
import java.util.Observable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@WebService(endpointInterface = "com.example.lottery.service.LotteryService")
public class StandardLotteryService
extends Observable
implements LotteryService, WebServiceQualitySamplerMXBean {
    private int counter;
    private long totalResponseTime;
    @Override
    public List<Integer> draw(int max, int size) {
        return ThreadLocalRandom.current()
                .ints(1,60)
                .distinct()
                .limit(6).sorted().boxed()
                .collect(Collectors.toList());
    }

    @Override
    public void reset() {

    }

    @Override
    public QualityMetric getQualityMetric() {
        return null;
    }
}
