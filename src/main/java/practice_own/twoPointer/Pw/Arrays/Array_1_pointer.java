package practice_own.twoPointer.Pw.Arrays;

import practice_own.twoPointer.util.Shows;
import practice_own.twoPointer.util.Swaper;

import java.util.Arrays;

public class Array_1_pointer {
    public static void main(String[] args) {
        rotateArray(new int [] {10,20,30,40,50,60,70},3);
        move0and1(new int [] {0,1,0,0,1,1,0,1,0});
        ductedFlag(new int [] {0,1,0,0,2,2,1,1,0,1,0,2});
        int[] arr = {12,8,41,37,2,49,16,28,21};
        nextGreaterElement(arr);
        nextGreateMoreoptimize(arr);
    }
    public static void rotateArray(int [] arr , int k){
        int n = arr.length;
        k = k % n;
int i = 0;
int j = n - k - 1;
      while (i<j){
          Swaper.swapping(arr,i,j);
          i++;
          j--;
      }
//int j = k + 1;
//      int e = n-1;
//        while (k<e){
//            Swaper.swapping(arr,j,e);
//            j++;
//            e--;
//
//        }
      i = n  - k;
        j = n-1;

        while (i < j) {
            Swaper.swapping(arr, i++, j--);
        }



        i = 0;
        j = n-1;
        while (i<j){
            Swaper.swapping(arr,i,j);
            i++;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void move0and1(int [] arr){
        int i = 0;
        int j = arr.length - 1;
        while (i<j){
         if (arr[i]==0) {

             i++;
         }
            if (arr[j]==1) {

                j--;
            } else if (arr[i]==1&&arr[j]==0) {
                Swaper.swapping(arr,i,j);
                i++;
                j--;
            }

        }
        Shows.arr(arr);
    }

    public static void ductedFlag(int [] arr){

        int n = arr.length;
        int low=0;
        int high = n-1;
        int mid = 0;
       while(mid<=high) {
//            if(arr[low]>0 && arr[low]==0 && arr[low - 1]==0){
//                low++;
//            }
//            if(arr[high]>0 && arr[high]==0 && arr[high + 1]==0){
//                high--;
//            }
            if(arr[mid] == 0){
                Swaper.swapping(arr,low++,mid++);

            }else if(arr[mid] ==2){
                Swaper.swapping(arr,high--,mid);
            }

            else if (arr[mid]==1){
                mid++;
            }


        }
        Shows.arr(arr);
    }

    public static void nextGreaterElement(int[] arr){

        int[] ans = new int[arr.length];
        int n = arr.length;
        ans[n-1] = -1;
        for (int i = 0; i < n-1; i++) {
//            ans[i] =arr[maxElement(arr,i+1,n-1)];
            int mx = Integer.MIN_VALUE;
            for (int j = i+1; j < n; j++) {
                mx = Math.max(mx,arr[j]);
            }
            ans[i] = mx;
        }
       Shows.arr(ans);
    }
    public static int maxElement(int[] arr , int i , int j){
        int max  = Integer.MIN_VALUE;
        int idx = -1;
        for ( int k = i; k <= j; k++) {
            if(arr[k]>max){
                max = arr[k];
                idx =k;
            }
        }
        return idx;
    }
    public static void nextGreateMoreoptimize(int[] arr){
        int[] ans =  new int[arr.length];
        int n  =  ans.length;
        ans[n-1] = -1;
        int neg = arr[n-1];
        for (int i = n-2; i >=0; i--) {
            ans[i] = neg;
            neg = Math.max(neg,arr[i]);
        }
        Shows.arr(ans);
    }
}
