package practice_own.twoPointer;

import java.util.Arrays;

public class CountUniqueElement {
    public static void main(String[] args) {
       int placer = 0;
       int picker  = 1;
       int noOfUnique = 1;
       int [] arr  = {1,1,1,2,2,3,3,4};
       int n  =  arr.length;
       while (picker <n){
           if(arr[picker] != arr[picker - 1] ){
               arr[placer + 1] = arr[picker];
               noOfUnique++;
               placer ++;
           }
               picker++;
       }
        System.out.println(noOfUnique);
        System.out.println(Arrays.toString(arr));
    }


}
