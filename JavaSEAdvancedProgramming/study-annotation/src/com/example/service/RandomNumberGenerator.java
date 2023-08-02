package com.example.service;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ThreadLocalRandom;

public class RandomNumberGenerator {
    public static void populate(Object o) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        var clazz = o.getClass();
     /*   for (var field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Random.class)) {
                var random = field.getAnnotation(Random.class);
                var numbers = ThreadLocalRandom.current()
                        .ints(random.min(),random.max())
                        .distinct()
                        .limit(random.size())
                        .sorted()
                        .boxed()
                        .toList();
                field.setAccessible(true);
                field.set(o, numbers);
                field.setAccessible(false);
            }
        }*/

        for (var method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Random.class)) {
                var random = method.getAnnotation(Random.class);
                var numbers = ThreadLocalRandom.current()
                        .ints(random.min(),random.max())
                        .distinct()
                        .limit(random.size())
                        .sorted()
                        .boxed()
                        .toList();
                method.invoke(o,numbers);
            }
        }
    }
}
