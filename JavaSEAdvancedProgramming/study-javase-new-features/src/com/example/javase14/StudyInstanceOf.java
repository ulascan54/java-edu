package com.example.javase14;

import java.util.Objects;

public class StudyInstanceOf {
    public static void main(String[] args) {
        Pet garfield = new Cat();
        if(garfield instanceof Cat){
            var evcil = garfield;
            evcil.play();
        }// bunun kısayolu :

        if(garfield instanceof Cat evcil && Objects.nonNull(evcil) && evcil instanceof X ){//kolay yolu
            // var evcil = (Cat) garfield;
            //if (evcil instanceof X)
            //  evcil.toString();
            //else
            //  evcil.hashCode();
            evcil.play();
        }
        System.out.println(garfield instanceof X);
        System.out.println(garfield instanceof Pet);
    }
}
interface X{}
interface Pet{
    public default void play(){}
}

class Cat implements Pet {}
class Fish implements Pet {}
