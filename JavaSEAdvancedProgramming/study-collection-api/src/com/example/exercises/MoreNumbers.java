package com.example.exercises;

import java.util.HashMap;
import java.util.Map;

public class MoreNumbers {
    private Map<Integer, String> map = new HashMap<>();

    public MoreNumbers() {
        map.put(108, "108");
        map.put(108, "108");
        map.put(549, "549");
        map.put(549, "549");
    }

    public static void main(String[] args) {
        MoreNumbers moreNumbers = new MoreNumbers();
        System.err.println(moreNumbers.getSize());
    }

    public int getSize() {
        return map.size();
    }
}