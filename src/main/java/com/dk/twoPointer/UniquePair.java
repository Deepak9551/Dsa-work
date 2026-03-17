package com.dk.twoPointer;

import java.util.Arrays;

public class UniquePair {

    public static void main(String[] args) {
uniqueArray(new int[]{1,1,2,2,3,4,4});
    }
    public static void uniqueArray(int[] nums){
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
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr , int i , int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
