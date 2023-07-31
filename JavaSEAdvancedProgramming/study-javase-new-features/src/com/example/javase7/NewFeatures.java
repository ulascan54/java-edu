package com.example.javase7;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewFeatures {
    public static void main(String[] args) {
        int x=1_000_000;
        double y =1_234_567.123_456;
        int z=123;//decimal
        z=0123_3456;//octal
        z=0xa1c8_2bd3;//hexadecimal
        z=0b1110_0110;// new:binary
        List<Integer> numbers = new ArrayList<Integer>();
        List<List<Integer>> numbers2 = new ArrayList<List<Integer>>();// Artık sağ taraftakini yazmamıza gerek yok
        List<List<Integer>> diamondOperator = new ArrayList<>();//diamond operator
        /*
        {
            PreciousResource res1 = new PreciousResource(1);
            PreciousResource res2 = new PreciousResource(2);
            PreciousResource res3 = new PreciousResource(3);

            // before java 7
            try{
                //work with resources
            }catch (Exception e){
                System.err.println("an error has occured :" +e.getMessage());
            }finally {
                try{
                    res1.close();
                }catch (IOException e){
                    System.err.println("an error has occured :" +e.getMessage());
                }finally {
                    try{
                        res2.close();
                    }catch (IOException e){
                        System.err.println("an error has occured :" +e.getMessage());
                    }finally {
                        try{
                            res3.close();
                        }catch (IOException e){
                            System.err.println("an error has occured :" +e.getMessage());
                        }
                    }
                }
            }

        }*/
        // after java se 7 : try-with-recources
        {

            try(
                    PreciousResource res1 = new PreciousResource(1);
                    PreciousResource res2 = new PreciousResource(2);
                    PreciousResource res3 = new PreciousResource(3);
                    ){
                //work with resources
            }catch (Exception e){
                System.err.println("an error has occured :" +e.getMessage());
                for(var otherException :e.getSuppressed()){
                    System.err.println("an error has occured :"+otherException.getMessage());
                }
            }
            //switch
            Integer m= 42; // auto-boxing Integer.valueOf()
            Integer n= 108;
            Integer u = m+n; // Integer.valueOf(m.intValue() + n.intValue()) -> extra charge
            switch(m){//auto-unboxing m.intValue() since java 5
                case 42:
            }

        }
    }
}

class PreciousResource implements Closeable {
    private final int id;
    public PreciousResource(int id){
        this.id=id;
    }


    @Override
    public void close() throws IOException {
        System.err.println("Closing the precious RESOURCE %d....".formatted(id));
        throw new IllegalStateException("Cannot close the resource %d".formatted(id));
    }
}