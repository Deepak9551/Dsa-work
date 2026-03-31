package com.dk.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class threeSum {
    public static void main(String[] args) {

        int[] threeSumArray = {-1,2,1,-4};

    int ans  =    threeSumClosesToTarget(threeSumArray, 12);
        System.out.println(ans);
    }

    public static int threeSumClosesToTarget(int[] arr, int target) {

        Arrays.sort(arr);
        int closest = arr[0] + arr[1] + arr[2];
        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {

//            if(i>0 && arr[i] == arr[i-1]) continue;
            int left = i + 1;
            int right = arr.length - 1;



            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                //current sum, pehle wale closest se target ke zyada paas hai
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }
                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }

        }
     return closest;
    }
    }
