package com.example.lottery.service;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface LotteryService {
    List<Integer> draw(int max, int size);

}
