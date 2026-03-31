package practice_own.twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSumToZero {
    public static void main(String[] args) {
        int [] arr = {-1, 0, 1, 2, -1, -4};

        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < arr.length -2; i++) {

            // handle duplicate in i
      if(i>0 && arr[i] == arr[i-1]) continue;
            int start  = i + 1;
            int end  = arr.length- 1;
            int target = - arr[i];
            while(start<end){




                int sum = arr[start] + arr[end];
                if(sum < target){
                    start ++;
                } else if (sum > target) {
                    end --;
                }
                else{
                    ans.add(List.of(arr[i],arr[start],arr[end]));
                    start ++;
                    end--;
                   // make sure 0 or end na ho

                    while (start < end && arr[start] == arr[start - 1]){
                        start ++;
                    }
                    while (start < end && arr[end] == arr[end + 1]){
                        end --;
                    }
                }


            }

        }
        System.out.println(ans);
        }
    }


