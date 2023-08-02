package com.example.model;

import com.example.service.Random;

import java.util.List;

public class LotteryModel {
    //@Random(max = 60, size = 6)
    private List<Integer> numbers;

    public LotteryModel() {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    @Random(max = 60, size = 6)
    public void setNumbers(List<Integer> numbers) {
        System.out.println("LotteryModel::setNumbers");
        this.numbers = numbers;
    }
}
