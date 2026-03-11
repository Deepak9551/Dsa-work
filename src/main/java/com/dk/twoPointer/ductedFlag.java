package com.dk.twoPointer;

import java.util.Arrays;

public class ductedFlag {
    public static void main(String[] args) {

        int[] arr = {0, 1, 0, 2, 2,0, 1, 0, 2};

        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while (mid<high) {

            if(arr[mid] == 0){
                swap(arr,low,mid);
                low++;
                mid++;
            } else if (arr[mid] ==2) {
                swap(arr,high,mid);
                high--;
                mid++;
            }
           mid++;

        }
        System.out.println("Arrays " + Arrays.toString(arr));

    }
    public static void swap(int[] arr, int i , int j ){

        int temp =  arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
