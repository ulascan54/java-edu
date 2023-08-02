package com.example.service.business;

import com.example.aspect.Audited;
import com.example.aspect.Profiled;
import com.example.service.ArithmeticCalculator;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.concurrent.TimeUnit;

@Service
public class StandardArithmeticCalculator implements ArithmeticCalculator {
    @Override
    @Profiled(unit = TimeUnit.NANOSECONDS)
    @Cacheable(cacheNames = "add-cache", key = "#x")
    public double add(double x, double y) {
        System.out.println("StandardArithmeticCalculator::add");
        return x + y;
    }

    @Override
    @Profiled(unit = TimeUnit.MILLISECONDS)
    public double sub(double x, double y) {
        return x - y;
    }

    @Override
    @Audited
    @Profiled
    public double mul(double x, double y) {
        return x * y;
    }

    @Override
    public double div(double x, double y) {
        return x / y;
    }
}
