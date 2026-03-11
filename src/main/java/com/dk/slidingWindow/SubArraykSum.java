package com.dk.slidingWindow;

import java.util.Arrays;

public class SubArraykSum {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 3;
     subArray(arr,3);

     hireFire(new int[] {1,2,4,4},4);
    }

    public static void subArray(int[] arr, int k) {
    int sum = 0;
    int maxSum = 0;

    int low = 0;
    int high = k-1;
        for (int i = 0; i <= k; i++) {
           sum+= arr[i];
        }

        while(high<=arr.length){
            low++;
            high++;

            maxSum= Math.max(sum,maxSum);

           if (high == arr.length) break;
           sum = sum + arr[high] +arr[low-1];
            System.out.println(sum);
        }

        System.out.println(maxSum);
    }

    public static void hireFire(int[] arr , int targetComplete){

        // hire until our target is not completed
        // nahi part first time kaab taak hire kitno ko karna
        // while loop

        // variable length wale mai -> low = 0 , high = 0
        // because ek hi person woh kar sakta hai
        int low = 0; // super person
        int high = 0; // until applicants are available
        int n  =  arr.length -1 ;
        int length  = 0;
        int maxlength = Integer.MAX_VALUE;
        int sum = 0;
        // n = applicant list
        while (high<=n){
          sum += arr[high];

          while (sum>=targetComplete){
              length = high - low + 1;
              maxlength = Math.min(length,maxlength);
              sum -= arr[low];
              low++; //  fire
          }
            if (high == n )break;
            // fire code
            high++;

        }
        System.out.println(maxlength);
    }
}
