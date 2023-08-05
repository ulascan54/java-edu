package com.example.random.service.business;

import com.example.random.service.RandomNumberService;
import com.example.random.service.service.QualityLevel;
import com.example.random.service.service.ServiceQuality;

import java.security.SecureRandom;

@ServiceQuality(QualityLevel.SECURE)
public class SecureRandomNumberService implements RandomNumberService {
    private SecureRandom random = new SecureRandom();

    @Override
    public int generate(int min, int max) {
        System.err.println("SecureRandomNumberService::Generate");

        return random.nextInt(min, max);
    }
}
