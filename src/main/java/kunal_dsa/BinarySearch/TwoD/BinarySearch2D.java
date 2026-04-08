package kunal_dsa.BinarySearch.TwoD;

import java.util.Arrays;

public class BinarySearch2D {

    public static void main(String[] args) {
        int[][] arr = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Row | col " + Arrays.toString(binarySearch2D_HARD(arr,5)));
    }
    // SORTED ROW | COL WISE
    public static int [] search2D(int[][] arr, int target){
        int col = arr.length -1;
        int row = 0;
        int n = arr.length;
       // until Last row column left
        // col = 4 , row = 0
        // when col =0 to -1 means all col traverse
        while(row<n && col >= 0){
            if(arr[row][col]==target){
                return new int []{row,col};
            } else if (target > arr[row][col]) {
                row ++;
            }else{
                col--;
            }
        }
        return new int[]{-1,-1};
    }
    public static int[] binarySearch2D_HARD(int[][]arr,int target){


        int srow = 0;
        int erow = arr.length - 1;

        int cols = arr[0].length;

        int midcol = cols/2;

        int rows = arr.length;
        if(rows==1){
  return binarySearch(arr,target,0,0,cols - 1);
        }
        while (srow<(erow - 1)){

            int mid = srow + (erow - srow) /2;
            if(arr[mid][midcol] == target){
                return new int[] {mid,midcol};
            } else if (arr[mid][midcol]<target) {
                srow = mid;
            }
            else{
                erow = mid;
            }
        }
        if(target == arr[srow][midcol] ){
            return new int[] {srow,midcol};
        }
        if(target<= arr[srow][midcol - 1]){
return binarySearch(arr,target,srow,0,midcol -1);
        }
        if(target>= arr[srow][midcol + 1] && target<= arr[srow][cols - 1]){
            return binarySearch(arr,target,srow,midcol + 1,cols -1);
        }
        if(target<= arr[srow+1][midcol - 1]){
            return binarySearch(arr,target,srow+1,0,midcol -1);
        }
        else{
            return binarySearch(arr,target,srow+1,midcol+1,cols - 1);
        }

    }

    public static int[] binarySearch(int[][] arr, int target, int row, int startCol, int endCol) {
        while (startCol <= endCol) {
            int mid = startCol + (endCol - startCol) / 2;
            if (arr[row][mid] == target) {
                return new int[]{mid, row};
            } else if (arr[row][mid] < target) {
                startCol = mid + 1;
            } else {
                endCol = mid - 1;
            }
        }
        return new int[]{-1, -1};
    }
}
