package com.example.lottery.application;

import com.example.random.service.RandomNumberService;
import com.example.random.service.service.QualityLevel;
import com.example.random.service.service.ServiceQuality;
import com.example.service.business.StandardLotteryService;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

public class LotteryApplication {
    public static void main(String[] args) throws IOException,FileNotFoundException {
        var lotteryService = new StandardLotteryService();
        lotteryService.setRandomNumberService(getRandomNumberService());
        lotteryService.draw(60, 6, 10)
                .forEach(System.out::println);
    }

    public static RandomNumberService getRandomNumberService() throws FileNotFoundException, IOException  {
        var props = new Properties();
        props.load(new FileInputStream(new File("src", "application.properties")));
        var qualityLevel = QualityLevel.valueOf(props.getProperty("service.quality"));
        var randomNumberServices = ServiceLoader.load(RandomNumberService.class);
        for (var randomNumberService : randomNumberServices) {
            var clazz = randomNumberService.getClass();
            if (clazz.isAnnotationPresent(ServiceQuality.class)){
                var serviceQuality = clazz.getAnnotation(ServiceQuality.class);
                if (serviceQuality.value().equals(qualityLevel)){
                    return randomNumberService;
                }
            }
        }
        throw new IllegalStateException("Cannot find an implementation!");
    }
}
