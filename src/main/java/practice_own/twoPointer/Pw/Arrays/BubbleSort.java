package practice_own.twoPointer.Pw.Arrays;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        selectionSort(arr);

    }
    public static void BubbleSortDesc(int[] arr){

        boolean flag = false;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
              if(arr[j]< arr[j+1]){
                swap(arr,j,j+1);

                flag  = true;
              }
            }
            if (!flag ) break;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void selectionSort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
         int placeIdx  = arr.length-1-i;
            int maxIdx = findMaxInRange(arr, 0, arr.length - 1 - i);
            swap(arr,maxIdx,placeIdx);
        }
        System.out.println(Arrays.toString(arr));
    }
    public static int findMaxInRange(int[] arr, int start, int end){
        int max = Integer.MIN_VALUE;
        int maxIdx =-1;
        for (int i = start; i <= end; i++) {
            max = Math.max(max,arr[i]);
            maxIdx = i;
        }
        return maxIdx;
    }
}
