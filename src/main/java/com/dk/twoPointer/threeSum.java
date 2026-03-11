package com.dk.twoPointer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class threeSum {
    public static void main(String[] args) {

        int[] threeSumArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        threeSumClosesToTarget(threeSumArray, 12);
    }

    public static void threeSumClosesToTarget(int[] arr, int target) {


        int ans = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum >= target) {
                    right--;
                } else {
                    ans += (right - left);
                    left++;

                }

            }

        }
        System.out.println(ans);
    }
}
