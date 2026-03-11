package com.dk.twoPointer;

import java.util.*;

public class TwoSum {

    private Map<Integer,Integer> map = new HashMap<>();

    public void solveByHashMap(int[] arr , int target){

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        for (int i = 0; i < arr.length; i++) {
            int element = target - arr[i];

            if(map.containsKey(element) ){
                System.out.println("Index found: " + i + " and " + map.get(element));
                break;
            }
        }
    }

public  void solveByTwoPointer(int[] arr , int target){

        int left =0;
        int right = arr.length-1;
        while(left<right){
            if (arr[left] + arr[right] == target){
                System.out.println("Index found: " + left + " and " + right);
                break;
            } else if (arr[left] + arr[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
    System.out.println("No such elements found");
    }
    static void duplicate2Sum(int[] arr , int target){

        int start =  0;
        int end  = arr.length-1;
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        while(start<end){
            int sum =  arr[start] + arr[end];
            if(sum<target){
                start++;
            } else if (sum>target) {
                end -- ;
            }
            else{
                System.out.println(arr[start] + ","+ arr[end]);
                result.add(new ArrayList<>(Arrays.asList(start,end)));
                start++;
                end--;
            }
            while (start>0 && arr[start] == arr[start - 1]){
                start++;
            }
            while (end<arr.length-2 && arr[end] == arr[end + 1]){
                end--;
            }
        }
    }
    static void tripletSum(int[] arr ,int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i <= arr.length - 2; i++) {
            int a = -arr[i];
            int start = i + 1;
            int end = arr.length - 2;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum < target) {
                    start++;
                } else if (sum > target) {
                    end--;
                } else {
                    System.out.println(arr[start] + "," + arr[end]);
                    result.add(new ArrayList<>(Arrays.asList(start, end)));
                    start++;
                    end--;
                }
                while (start > 0 && arr[start] == arr[start - 1]) {
                    start++;
                }
                while (end < arr.length - 2 && arr[end] == arr[end + 1]) {
                    end--;
                }
            }
        }
    }
    static void threeSum(int[] arr ){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int n  = arr.length-1;
        for (int i = 0; i < arr.length-2; i++) {

            if (i>0 && arr[i] == arr[i-1]){
                continue;
            }
            int target =  -arr[i];


            int start = i+1;
            int end  = arr.length-1;
            while (start<end){
                int sum  = arr[start] + arr[end];


                if(sum<target){
                    start++;
                } else if (sum>target) {
                    end--;
                }
                else{
                    result.add(new ArrayList<>(Arrays.asList(target, arr[start],arr[end])));
                    start++;
                    end--;
                    while (start < n &&arr[start]==arr[start-1]){
                        start++;
                    }
                    while ( end>0 && arr[end]==arr[end+1]) {
                        end--;
                    }

                }
            }
        }
        System.out.println(result);
    }
    public static void main(String[] args) {

        int[] arr = {1,2,3,2};
        int [] arr2 = {-1,0,1,2,-1,4};

        int target = 4;
//        TwoSum twoSum = new TwoSum();
//        twoSum.solveByTwoPointer(arr,target);
//        duplicate2Sum(arr,target);
//        tripletSum(arr,target);
//        threeSum(arr2);
     hashMapTwoSum();
    }

    public static void hashMapTwoSum(){
        int[] arr = {7,11,2,15 };
        int target = 9;
        Map<Integer,Integer> map = new HashMap();
        map.put(arr[0],0);
        for (int i = 1; i < arr.length; i++) {
            int ele =  Math.abs(arr[i] - target);
        if(map.containsKey(ele)){
            System.out.println("Index found: " + i + " and " + map.get(ele));
            break;
        }
        map.put(arr[i],i);
        }

    }
}
