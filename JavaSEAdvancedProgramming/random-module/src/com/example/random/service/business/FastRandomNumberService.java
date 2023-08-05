package com.example.random.service.business;

import com.example.random.service.RandomNumberService;
import com.example.random.service.service.QualityLevel;
import com.example.random.service.service.ServiceQuality;

import java.util.concurrent.ThreadLocalRandom;

@ServiceQuality(QualityLevel.FAST)
public class FastRandomNumberService implements RandomNumberService {
    @Override
    public int generate(int min, int max) {
        System.err.println("FastNumberService::Generate");
        return ThreadLocalRandom.current().nextInt(min,max);
    }
}
