package com.example;

import java.lang.reflect.InvocationTargetException;

public class StudyClass {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //Meta-space

        var voidClazz = void.class;
        Class<?> intClazz = Integer.class;
        // all fields declared in Integer
        for (var field : intClazz.getDeclaredFields())
            System.out.println("Field: " + field.getName());
        for (var method : intClazz.getDeclaredFields())
            System.out.println("Method: " + method.getName());
        var intValueMethod = intClazz.getDeclaredMethod("intValue");
        Integer i = 42;
        System.out.println("i= " + i.intValue());
        System.out.println("i= " + intValueMethod.invoke(i));

    }
}
