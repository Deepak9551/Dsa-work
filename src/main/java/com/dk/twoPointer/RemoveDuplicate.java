package com.dk.twoPointer;

import java.util.Arrays;

public class RemoveDuplicate {

    public void removeDuplicates(int[] nums) {

        int officer = 0;
        int cm  = 1;
        int unique = 1;
        while(cm<nums.length) {
            if (nums[officer] == nums[cm]) {
                System.out.println("Skipping " + nums[cm] + " as it is duplicate");
                cm++;
               continue;
            }

            else if (nums[officer] != nums[cm]) {
                swap(nums, officer + 1, cm);
                officer++;
                cm++;
                unique++;
            }

        }

        System.out.println("No of unique elements: " + unique);
        System.out.println("Array after removing duplicates: " + Arrays.toString(nums));
    }

    public void byTwoPointer(int[]arr){
        int no_of_unique=1;
        int officer = 0;
        int cm = 1;
        while(cm < arr.length){
         if (arr[cm] == arr[cm-1]){

             cm++;
continue;
         }
           if (arr[cm] != arr[cm-1]){
                officer++;

                no_of_unique++;
                cm++;
            }

        }
        System.out.println("No of unique elements: " + no_of_unique);
    }
    public  void swap(int[]arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {1,1,2,2,3,4,4};
        RemoveDuplicate removeDuplicate = new RemoveDuplicate();
//        removeDuplicate.byTwoPointer(arr);
//        removeDuplicate.removeDuplicates(arr);
        removeDuplicateFromSortedArray(arr);
    }

    public static void removeDuplicateFromSortedArray(int[]arr){
        int i = 0;
        int j = 1;
        int unique = 1;

        for (int k = 1; k < arr.length; k++) {

            if (arr[j] != arr[j - 1]) {
                arr[i+1] = arr[j];
                i++;
            unique ++;
            }
            j++;
        }
        System.out.println(unique);
    }
}
