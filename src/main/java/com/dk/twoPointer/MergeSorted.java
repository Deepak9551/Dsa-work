package com.dk.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeSorted {

    public static int[]  mergeSortedArrays(int[] arr1 , int[] arr2){
        int len1 = arr1.length;
        int len2 = arr2.length;
        int mergedLen = len1 + len2;
        int mergedArray[] = new int[mergedLen];
        int i = 0 , j =0 , k=0;
        while(i<len1 || j<len2){


            if (arr1[i] < arr2[j]){
                mergedArray[k++] = arr1[i++];
            } else {
                mergedArray[k++] = arr2[j++];
            }
            if (i==len1){
                while (j<len2){
                    mergedArray[k++] = arr2[j++];
                }
            }
            else if (j==len2){
                while (i<len1){
                    mergedArray[k++] = arr1[i++];
                }
            }
        }
        return mergedArray;
    }
    public static int[]  mergeSortedArrays(List<Integer> arr1 , List<Integer> arr2){
        int len1 = arr1.size();
        int len2 = arr2.size();
        int mergedLen = len1 + len2;
        int mergedArray[] = new int[mergedLen];
        int i = 0 , j =0 , k=0;
        while(i<len1 || j<len2){


            if (arr1.get(i) < arr2.get(j)){
                mergedArray[k++] = arr1.get(i++);
            } else {
                mergedArray[k++] = arr2.get(j++);
            }
            if (i==len1){
                while (j<len2){
                    mergedArray[k++] = arr2.get(j++);
                }
            }
            else if (j==len2){
                while (i<len1){
                    mergedArray[k++] = arr1.get(i++);
                }
            }
        }
        return mergedArray;
    }

    public int[] squareSortedArray(int[] arr) {


        List<Integer> positiveArray = new ArrayList<>();
        List<Integer> negativeArray = new ArrayList<>();

        // separate positive and negative numbers
        for (int num : arr) {
            if (num < 0) {
                negativeArray.add(num);
            } else {
                positiveArray.add(num);
            }
        }
        System.out.println("Negative Array during separation: " + negativeArray);
        System.out.println("Positive Array during separation: " + positiveArray);
        // case 1 : no negative numbers
        System.out.println(negativeArray.isEmpty());
        System.out.println(positiveArray.isEmpty());
        if (negativeArray.isEmpty()) {

            for (int i = 0; i < positiveArray.size(); i++) {
                 positiveArray.set(i, positiveArray.get(i) * positiveArray.get(i));
                return positiveArray.stream().mapToInt(v -> v).toArray();
            }
            System.out.println("Positive");

        } else if (positiveArray.isEmpty()) {
            Collections.reverse(negativeArray);
            for (int i = 0; i < negativeArray.size(); i++) {
                negativeArray.set(i, negativeArray.get(i) * negativeArray.get(i));
                return negativeArray.stream().mapToInt(v -> v).toArray();
            }
            System.out.println("negative");


        }

        Collections.reverse(negativeArray);
        // square the elements
        for (int i = 0; i < positiveArray.size(); i++) {
            positiveArray.set(i, positiveArray.get(i) * positiveArray.get(i));
        }
        for (int i = 0; i < negativeArray.size(); i++) {
            negativeArray.set(i, negativeArray.get(i) * negativeArray.get(i));
        }
        int[] mergearray = mergeSortedArrays(positiveArray, negativeArray);
        System.out.println("Negative Array: " + negativeArray);
        System.out.println("Positive Array: " + positiveArray);
        System.out.println("Merged Sorted Squared Array: " + Arrays.toString(mergearray));





       return mergearray;
    }
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8 , 9 ,10,11,12};
        int[] mergedArray = mergeSortedArrays(arr1, arr2);

        System.out.println(Arrays.toString(mergedArray));
//        System.out.println("Merged Sorted Array:");
//        for (int num : mergedArray) {
//            System.out.print(num + " ");
//        }

//        int [] arr3 = {-5, -3, -2, -1};
//        MergeSorted mergeSorted = new MergeSorted();
//        System.out.println(Arrays.toString(mergeSorted.squareSortedArray(arr3)));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m -1;
    int j = n  - 1;
    int k =  nums1.length -1 ;
    while(i>=0||j>= 0){
        if(nums1[i]>nums2[j])
            nums1[k--] = nums1[i--];
      else nums1[k--] = nums2[j--];
    }
    while (j>=0){
        nums1[k--] = nums2[j--];
    }
    }
}
