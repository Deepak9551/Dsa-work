package practice_own.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DuplicateTwoSum {
    public static void main(String[] args) {
        int [] arr = {1,1,1,2,2,3,3,3};
        int start = 0;
        int end = arr.length - 1;
        int target=  4;

        List<List<Integer>> list = new ArrayList<>();

        while (start<end){
            while (start>0 && arr[start] == arr[start - 1]){
                start ++;
            }
            System.out.println(start);
            while (end<arr.length-1 && arr[end] == arr[end + 1]){
                end --;
            }
            System.out.println(end);
            int sum  = arr[start] + arr[end];
            if(sum<target){
                start++;
            }
            else if (sum>target){
                end--;
            }
            else {
               list.add(Arrays.asList(start,end));
            }

            start++;
            end--;
        }
        System.out.println(list);
    }
}
