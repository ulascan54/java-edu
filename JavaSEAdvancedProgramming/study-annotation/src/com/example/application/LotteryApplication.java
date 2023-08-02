package com.example.application;

import com.example.model.LotteryModel;
import com.example.service.RandomNumberGenerator;

import java.lang.reflect.InvocationTargetException;

public class LotteryApplication {
    public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        var lotteryModel = new LotteryModel();
        RandomNumberGenerator.populate(lotteryModel);
        System.out.println(lotteryModel.getNumbers());
    }
}
