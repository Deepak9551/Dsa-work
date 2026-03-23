package com.dk.twoPointer;

import java.util.Arrays;

public class UniquePair {

    public static void main(String[] args) {
//uniqueArray(new int[]{1,1,2,2,3,4,4});
        doubleZero((new int[]{1,0,2,0,3,5,0,6,0,7}));
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
            } else if (nums[officer] != nums[cm]) {
                swap(nums, officer + 1, cm);
                officer++;
                cm++;
                unique++;
            }


        }
        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void removeDuplicate(int[] nums) {
        int officer = 0;
        int cm = 1;
        int unique = 1;
        while (cm < nums.length) {
            if (nums[officer] == nums[cm]) {
                System.out.println("Skipping " + nums[cm] + " as it is duplicate");
                cm++;

            } else if (nums[officer] != nums[cm]) {
                swap(nums, officer + 1, cm);
                officer++;
                cm++;
                unique++;
            }

        }
        System.out.println(Arrays.toString(nums));
    }

    public static void doubleZero(int[] nums){
        int n = nums.length;
int count = 0;
for (int num : nums){
    if(num == 0) count ++;
}
     int i = n-1;
     int j = n - 1 + count;

     while (i != j){
         if(j<n){

        nums[j] = nums[i];
         }
         j--;
         if(nums[i]==0){

             if(j<n){

                 nums[j] = nums[i];
             }
         j--;
         }

         i--;
     }
        System.out.println(Arrays.toString(nums));
    }
}
