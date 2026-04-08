package practice_own.twoPointer.Pw.Arrays;

import practice_own.twoPointer.util.Shows;
import practice_own.twoPointer.util.Swaper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Array_2_matrix {
    public static void main(String[] args) {
        int[][] arr ={{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};
//        rotateMatrix(arr);
//       printMatrix(arr);
//        wavePrint(arr);

        int[][] spiral = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        printMatrix(spiral);
//        spiralMatrix(spiral);
//        pascalTriangle2(6);
//        int[][] brr =  {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
//        multiplicationMatrix(arr,brr);
//        int[][] brr2 = {{1, 0, 1}, {0, 0, 0}, {0, 0, 1}};
//        flipzero(brr2);

        int[][] crr  = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int[][] crr2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes2(crr2);
    }

    public static void printMatrix(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void transposeMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int[][] transpose = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[i][j] = arr[j][i];
            }
        }

    }

    public static void rotateMatrix(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                swap2d(arr, i, j, j, i);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                reverseArray(arr[i]);
            }
        }


    }

    public static void reverseArray(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            Swaper.swapping(arr, start, end);
            start++;
            end--;
        }
    }

    public static void swap2d(int[][] arr, int i, int j, int i2, int j2) {
        int temp = arr[i][j];
        arr[i][j] = arr[i2][j2];
        arr[i2][j2] = temp;
    }

    public static void wavePrint(int[][] arr) {

        int n = arr.length;
//        int srow = 0;
//        int erow = arr.length-1;
//        int scol = 0;
//        int ecol = arr[0].length-1;
//    for (int i = 0; i < arr.length; i++) {
//     while (scol<=ecol){
//         System.out.print(arr[srow][scol] + "  ");
//         scol++;
//     }
//     srow++;
//        System.out.println();
//        while (ecol>=0){
//            System.out.print(arr[srow][ecol] + "  ");
//            ecol--;
//        }
//        srow++;
//        scol = 0;
////        while (scol>ecol){
////            System.out.print(arr[srow][scol] + "  ");
////            scol++;
////        }


        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {


                for (int j = 0; j < arr[0].length; j++) {
                    System.out.print(arr[i][j] + " ");
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    System.out.print(arr[i][j] + " ");
                }
            }
        }
    }

    public static void spiralMatrix(int[][] arr) {
        int minR = 0;
        int maxR = arr.length - 1;
        int minC = 0;
        int maxC = arr[0].length - 1;
        System.out.println("ans = " + maxC + " " + minC);
        while (minR <= maxR && minC <= maxC) {

            for (int j = minC  ; j <=maxC ; j++) {
                System.out.print(arr[minC][j] + " ");
            }
            minR++;
if(minR>maxR || minC>maxC) break;
            for (int i = minR  ; i <=maxR ; i++) {
                System.out.print(arr[i][maxC] + " ");
            }
            if(minR>maxR || minC>maxC) break;
            maxC--;
            for (int j = maxC  ; j >=minC ; j--) {
                System.out.print(arr[maxR][j] + " ");
            }
            if(minR>maxR || minC>maxC) break;
            maxR--;
            for (int j = maxR  ; j >=minR ; j--) {
                System.out.print(arr[j][minC] + " " );
            }
            if(minR>maxR || minC>maxC) break;
            minC++;

        }
    }
    public static void pascalTriangle(int n){
//        int n = 6;
        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(List.of(1));
        for (int i = 0; i <n ; i++) {
            List<Integer> ele = new ArrayList<>();


              for (int j = 0; j <=i ; j++) {
                  ele.add(1);

              }

ans.add(ele);
        }
        System.out.println(ans);

        // pascal work
        for (int i = 2; i <n ; i++) {
            List<Integer> ele = new ArrayList<>();


            for (int j = 1; j <=i-1 ; j++) {
            int data =    ans.get(i-1).get(j-1) + ans.get(i-1).get(j) ;
               ele.add(data);
               ans.get(i).set(j,data);
            }


        }
        System.out.println(ans);
    }
    public static void pascalTriangle2(int n){
//        int n = 6;
        List<List<Integer>> ans = new ArrayList<>();
//        ans.add(List.of(1));
        for (int i = 0; i <n ; i++) {
            List<Integer> ele = new ArrayList<>();


            for (int j = 0; j <=i ; j++) {
             if(j==0 || j==i)   ele.add(1);
            else   ele.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }

            ans.add(ele);
        }
        System.out.println(ans);



    }
    
    public static void multiplicationMatrix(int[][] arr,int [][ ]brr){
        int a = arr.length;
        int b =  arr[0].length;
        
        int c = brr.length;
        int d = brr[0].length;
        int [][] crr = new int[a][d];
        if(arr[0].length != brr.length) {
            System.out.println("Multiplication Not Possible !!");
        }
        else {
            for (int row = 0; row < crr.length; row++) {
                for (int col = 0; col < crr[0].length; col++) {

                    for (int k = 0; k < arr[0].length; k++) {
                        crr[row][col] += arr[row][k] * brr[k][col];
                    }
                }
            }
            printMatrix(crr);
        }
    }
    public static  void getmultiple(int[][] arr,int[][] brr , int row , int col){
       int sum =0;
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <arr[0].length ; j++) {

                   sum+= arr[row][j] * brr[j][col];
               }

        }
        System.out.println(sum);
    }

public static void flipzero(int[][] arr){

        // put zero a every row
    for (int row = 0; row < arr.length; row++) {
        if(arr[row][0] ==0) {
            for (int col = 0; col < arr[0].length; col++) {
            if(arr[row][col] ==0) arr[row][col] = 1;
            else arr[row][col] = 0;

            }
        }
    }
    // column wise ( check 0 > 1 )

    for (int col = 1; col < arr[0].length; col++) {
        //count for each column
        int noOfZero = 0;
        int noOfOne = 0;

        for (int row = 0; row < arr.length; row++) {
            if(arr[col][row] ==0) noOfZero++;
            else arr[col][row] = noOfOne++;

        }
        // code for fliping 0 - 1 ( if 0 > 1 )
        if (noOfZero >= noOfOne) {
            for (int row = 0; row < arr.length; row++) {
                if(arr[col][row] ==0) arr[col][row] = 1;
                else arr[col][row] = 0;

            }
        }


    }
    int sum =0;
    int x = 1;
    int factor = 1;
    for (int row = 0; row < arr.length; row++) {

            for (int col = arr[0].length-1; col >=0; col--) {
             sum+= arr[row][col]*x;

            }
        x *= 2;
    }
    System.out.println(sum);
}
    public static void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean [] row  = new boolean[n];
        boolean [] col = new boolean[m];

        for(int i = 0 ; i<n;i++){

            for(int j = 0 ; j<m;j++){
              if(matrix[i][j]==0){
                  row[j] = true;
              }
            }
            for(int j = 0 ; j<m;j++){
                if(matrix[j][i]==0){
                    col[j] = true;
                }
            }

//  make my work

        }
        System.out.println("Old matrix");
        printMatrix(matrix);
        for(int j = 0 ; j<col.length;j++){
            if(col[j]){
                System.out.println(j);

                    for(int c = 0 ; c<n;c++){
                      matrix[c][j] =0;
                    }

            }
        }
        for(int j = 0 ; j<row.length;j++){
            if(row[j]){
                System.out.println(j);

                for(int c = 0 ; c<m;c++){
                    matrix[j][c] =0;
                }

            }
        }
        System.out.println(Arrays.toString(row));
        System.out.println(Arrays.toString(col));
        printMatrix(matrix);
    }
    public static void setZeroes2(int[][] matrix) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if the first row contains zero
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column contains zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Mark zeros in the first row and column
        for (int i = 1; i < rows; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < cols; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < cols; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < rows; i++) {
                    matrix[i][j] = 0;
                }
            }
        }



        // Set first row to zero if needed
        if (firstRowZero) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }

        // Set first column to zero if needed
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }

            printMatrix(matrix);

    }
}