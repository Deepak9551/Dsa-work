package practice_own.twoPointer.util;

public class Swaper {
    public static void swapping(int[] arr, int i , int j){
  int temp  = arr[i];
  arr[i] = arr[j];
  arr[j] = temp;
    }
}
