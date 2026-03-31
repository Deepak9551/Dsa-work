package kunal_dsa.BinarySearch;

import java.util.Arrays;

public class BinarySearchPivot {

    public static int pivotElement(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        // loop break when both point to the same element
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] < arr[mid + 1]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(end);
        return end;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 0, 1, 2, 4, 5};
        int target = 6;
//        int pivot = pivotElement(arr);
//        int answer = binarySearch(arr, 0, pivot, target, true);
//        if (answer == -1) {
//            answer = binarySearch(arr, pivot + 1, arr.length - 1, target, true);
//        }
//        System.out.println(answer);
//        int n = arr.length;
//        System.out.println("pivot element " + arr[pivotElement2(arr)] +" at index " + pivotElement2(arr));
//        int p = pivotElement2(arr);
//
//        int answer = -1;
//        if (p == -1) {
//            answer = binarySearch(arr, 0, n - 1, target, true);
//
//        } else if (arr[p]==target) {
//            System.out.println(p);
//        } else {
//        answer  = binarySearch(arr, 0, p, target, true);
//            if (answer == -1) {
//                answer = binarySearch(arr, p + 1, n - 1, target, true);
//            }
//
//        }
//        System.out.println("target element " + arr[answer] +" at index " + answer);

        int[] dupArray = {3, 4, 4, 6,6,7, 7,8, 0, 1, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(countRotations(arr));
  }

    public static int binarySearch(int[] arr, int start, int end, int target, boolean isAscending) {
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (target == arr[mid]) return mid;
            if (isAscending) {
                if (target < arr[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target > arr[mid]) end = mid - 1;
                else start = mid + 1;
            }

        }
        return -1;
    }

    public static int rotatedArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        // loop break when both point to the same element
        while (start < end) {
        int mid  = start + (end -  start)/2;
            //case1 for finding
            if(mid<end && arr[mid - 1]>arr[mid]) return mid;

            // case 2 for finding
            else if (mid>start&& arr[mid]<arr[mid - 1]) return mid - 1;

            // here upper two not trap the mid
            // means this mid is not pivot
            // use search space reduce technique exclude mid
            if(arr[start]>= arr[mid]) end= mid-1;
            else start = mid+1;
        }
        return -1;
    }


    public static int pivotDuplicate(int [] arr){
        int start = 0 ;
        int end = arr.length  -  1;

        while(start<end){
            int mid = start + (end - start)/2;

            if(mid<end && arr[mid] > arr[mid + 1]){
             return mid;
         }
         else if (mid>start&& arr[mid]<arr[mid - 1]) return mid - 1;

         if(arr[mid]==arr[start] && arr[mid] == arr[end]){
             // skip duplicate not if these duplicate are pivot
             if(arr[start]>arr[start+1]){
                 return start;
             }
             start++;
            if(arr[end-1]>arr[end]){
                 return end -1;
             }
            end--;
         }
         // left part is sorted so the pivot in right side
            // we already check for mid so here mid is not pivot

            // mid + 1
            if(arr[start] < arr[mid] || arr[mid] == arr[start] && arr[mid]>arr[end]){
                start = mid + 1;
            }
            else{
                end = mid - 1;



        }



        }
        return -1;
    }

    public static int countRotations(int [] arr){

        int start = 0;
        int end = arr.length -1 ;
        while(start<end){

            int mid = start + (end - start)/2;
            if(mid > start && arr[mid]>arr[mid + 1]){
            return mid;
            } else if (mid < end && arr[end -1 ] > arr[end]) {
                return mid;
            }
            if(arr[start] <= arr[mid]){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }


        }
        return -1;
    }

}
