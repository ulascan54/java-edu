package com.example.javase7;

import java.util.List;

public class WrapperClasses {
    public static void main(String[] args) {
        int u = 42; // 4-byte
        Integer v = 42 ; //object-header: 12 byte + 4 byte (int)  =16-byte

        Integer x=42;//-128..127 aralığındaki referansları okuyabiliyor
        // cash kapasitesini arttırıssak m ve n içinde aynınısı gösterir
        // aslında burada referans karşılaştırıyor. optimize etmek için

        // -Djava.lang.Integer.IntegerCache.high = 4096
        // -2048..2047
        Integer y=42;
        Integer m=542;
        Integer n=542;
        System.out.println("x==y?:"+(x==y)); //true
        System.out.println("m==n?:"+(m==n)); //false

        double d=1;//8b
        Double dd=1.;//12b+8b+4b ( aligment ) =24b
        List<Integer> numbers; //kaçınılmaz olarak kullanılmalı ancak bunu çözülmek üzere
        // List<int> -> l1,l2 cache ini kullanır bunuda engellemiş olacağız

        String name1 = "jack";//static -> object pooling -> caching, sınıfın immutable olmalı
        String name2 = new String("jack");//dynamic
        String name3 = "jack";
        System.out.println("name1==name2?"+(name1==name2));
        System.out.println("name1==name3?"+(name1==name3));
        name3 = name3.toUpperCase();
        System.out.println(name3);
        //immutable = String,Integer,Character,Float,Double -> Immutable class
        //BigDecimal,BigInteger,...
    }
}


final class A{//immutable class
    // statei dağiştirilemez state final ve davranışlarıda final olduğu için immutable classtır bu sayade object pooling yapabilirim
    // cashleye bilmemiz için classın immutable olması gerekiyor.
    private final int x;

    public A(int x){
        this.x=x;
    }
    public int getX(){
        return x;
    }
}