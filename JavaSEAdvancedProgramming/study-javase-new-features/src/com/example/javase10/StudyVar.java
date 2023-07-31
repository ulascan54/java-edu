package com.example.javase10;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.List;


public class StudyVar {
    public static void main(String[] args) {
        int x = 42;
        var y = 42; //-> y -> int otamatik compiler alır.
        var numbers = List.of(4,8,15,16,23,42);// List<Integer>
        for(var number : numbers)// inferance
            System.out.println(number);
        var v =fun(); //var yalnızca local değişkenlerde kullanılır
        Map<String,Function<List<Integer>,String>> mappers = new HashMap<>();
        var mappersVarVersion = new HashMap<String,Function<List<Integer>,String>>(); // böylede yazmak mümkün

        // sorun : compilerın gördüğünü herzaman göremeye biliriz
        var nubmers2 = List.of(4.,8,11,23,43,23); // burada var -> List<Double> değildir aslında
        //Burada List<Number & Comparable <?> > ortak base classtan alır dikkat edilmesi gerekebilir.
        var numbers3 = List.of(4,"sadeafa",11,23,43,23); // burada var -> List<Object & Serializable & Comparable <?> > değildir aslında
        numbers3.get(0).compareTo(null);

    }

    static Map<String,Function<List<Integer>,String>> fun(){
        return null;
    }
}
