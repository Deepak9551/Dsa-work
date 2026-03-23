package practice_own.twoPointer;

import practice_own.twoPointer.util.Shows;
import practice_own.twoPointer.util.Swaper;

public class rearrange0and1 {
    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0};
        rearrange(arr);
    }

    public static void rearrange(int[] arr){
      if(arr.length==1){
          System.out.println(arr[0]);
          return;
      }
        int placer = 0;
        int picker  = 0;
        int n  =  arr.length;

        while (picker<n){
           if(arr[picker]==0){
            Swaper.swapping(arr,picker,placer);
            placer++;
           }
            picker ++;
        }
        Shows.arr(arr);
    }

}
