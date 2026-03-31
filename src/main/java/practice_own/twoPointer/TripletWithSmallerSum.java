package practice_own.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerSum {
    public static void main(String[] args) {
        int arr[] = {-2, 0, 1, 3};

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        int target =  2;
        for (int i = 0; i < arr.length - 2; i++) {
            // handle duplicate in i
            if(i>0 && arr[i] == arr[i-1]) continue;
            int start  =  i+1;
            int end  = arr.length - 1;



//            int closest = arr[0] + arr[1] + arr[2];
            while (start<end) {

                int sum = arr[i] + arr[start]+ arr[end];

                if(sum >= target ){
                    end--;
                }else{
                    for (int k = end; k > start; k--) {
                        ans.add(List.of(arr[i], arr[start], arr[k]));
                    }
            start++;

                }
            }
        }
        System.out.println(ans);
    }
}
