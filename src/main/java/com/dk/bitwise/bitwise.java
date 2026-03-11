package com.dk.bitwise;

public class bitwise {

    public static void main(String[] args) {
       evenOdd(14);
        System.out.println(powerOfTwo(0));


    }

    public static void evenOdd(int n){
        // check least significant
        if((n & 1) == 0){
            System.out.println("Even");
        }else{
            System.out.println("Odd");
        }

    }

    public static boolean powerOfTwo(int n){
        return n > 0 && (n & (n - 1)) == 0;
    }
}
