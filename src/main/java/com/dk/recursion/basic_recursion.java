package com.dk.recursion;

public class basic_recursion {


    public static void naturalNumber(int n){
        if(n == 0){
            return ;
        }
        System.out.println(n);

        naturalNumber(n-1);
    //    System.out.println(n);
    }

    public static int sumByRecursion(int n){
        if (n==1) return n;
      return n +  sumByRecursion(n - 1);
    }

    public static int factorial(int n){
        if (n==1) return n;
        return n *  factorial(n - 1);
    }

    public static void fabonacci(int n){

        int a = 0;
        int b = 1;
        System.out.println(a);
        System.out.println(b);

        int i = 0;
        int temp = 0;
        while (i<=n-2){
            temp = a + b;
            System.out.println(temp);
            i++;
            a = b;
            b = temp;
        }
    }


    public static void fabonacciByRecursion(int n,int first , int second){

        if(n==1) return;
   int third = first + second;
        System.out.println(third);
    fabonacciByRecursion(n-1,second,third);
    }

    public static int  sumOfDigit(int n){

        if(n==0) return 0;

      return  n%10 + sumOfDigit(n/10);

    }
    public static int  reverse(int n,int rev){

        if(n==0) return 0;
        rev  = n%10;
        return  rev * 10 + reverse(n/10,rev);

    }




    public static void main(String[] args) {
//        naturalNumber(5);
//      fabonacci(5);

//        System.out.println(0);
//        System.out.println(1);
//        fabonacciByRecursion(5,0,1);

        System.out.println(reverse(198,0));
    }


}
