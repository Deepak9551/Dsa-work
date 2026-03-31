package kunal_dsa.BinarySearch;

import java.util.Arrays;

public class BinarySearchFindFirstLast {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,8,9,10,11,12};
        int target = 8;
        System.out.println(Arrays.toString(binarySearch2(arr,8)));
        InfiniteSearch(arr,target);

        int[] arr1 = {1,2,2,2,3,3,3,5,5,5};
        System.out.println(Arrays.toString(binarySearch(arr1, 2)));
        int[] arr2 = {1,2,2,2,3,3,3,5,5,5};
        System.out.println(Arrays.toString(binarySearch2(arr2, 5)));
    }

    private static int[] binarySearch(int[] arr, int target) {
        int start = 0;
        int n = arr.length ;
        int end  =  n-1;
        int first  = -1;
        int last = -1;
        if(target > arr[arr.length-1])  return new int[]{-1,-1};
        while (start<=end){
            int mid = start + (end - start)/2;

            if(target<arr[mid]) {
                end = mid-1;

            } else if (target>arr[mid]) {
                start = mid + 1;
            }
            else{

                if(first == -1 || last == -1 ){
                    first = mid;
                    last = mid;
                }

                while (first>0 && arr[first] == arr[first-1]){
                    first --;
                }
                while ( arr[last] == arr[last+1]){
                    last++;
                }
                start = mid+1;
                end = mid -1 ;
            }
        }
        return  new int[]{first,last};
    }

    private static int[] binarySearch2(int[] arr, int target) {

        if(arr.length==0)  return new int[]{-1,-1};
        if(target > arr[arr.length-1])  return new int[]{-1,-1};
        if(arr.length == 1){
            if(arr[0] == target) return new int[]{0,0};
            else return new int[]{-1,-1};
        }

        int start  = search(arr,target,true);
        int end = search(arr,target,false);
        return new int[]{start,end};
    }

    private static int search(int[] arr, int target , boolean findFirstIndex) {
        int start = 0;
        int n = arr.length ;
        int end  =  n-1;
        int ans = -1;


        while (start<=end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;

            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                ans = mid;
                if(findFirstIndex){
                    end = mid - 1;
                }
                else{
                    start =  mid + 1;
                }
            }
        }
        return  ans;
    }

    private static void InfiniteSearch(int arr[], int target){
//        int start = 0;
//        int end = 1;
//        while (target>arr[end]){
//           int  newstart = end + 1;
//           end = end + (end - (start - 1)) *2;
//           start =newstart;
//        }
//       int a = binarySearch(arr,target,start,end);
//        System.out.println(a);

        // my initial start and end
        int start = 0;
        int end  = 1;
        // my work
        while(target> arr[end]){

            int newStart = end + 1;
            end  = end +   (end - ( start - 1) ) * 2;
            start =  newStart;
        }
        int a  =  binarySearch(arr,target,start,end);
        System.out.println(a);
    }

    private static int binarySearch(int [] arr , int target , int start , int end){
        while (start<=end){
            int mid  = start + (end - start)/2;
            if(target<arr[mid]){
                end = mid -1 ;
            }
            else if(target>arr[mid]){
                start = mid  + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
}
