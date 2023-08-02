package com.example.controller;

import com.example.aspect.Profiled;
import com.example.dto.request.CalculateRequest;
import com.example.service.ArithmeticCalculator;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@RequestScope
@RequestMapping("calculator")
@CrossOrigin
public class CalculatorController {
    private ArithmeticCalculator calculator;

    public CalculatorController(ArithmeticCalculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping
    @Profiled
    @Cacheable(cacheNames = "calculator")
    public double calculate(@RequestBody CalculateRequest request) {
         return switch (request.getOperation()) {
            case ADD ->  calculator.add(request.getLeft(), request.getRight());
            case SUB ->  calculator.sub(request.getLeft(), request.getRight());
            case MUL ->  calculator.mul(request.getLeft(), request.getRight());
            case DIV ->  calculator.div(request.getLeft(), request.getRight());
        };
    }
}
