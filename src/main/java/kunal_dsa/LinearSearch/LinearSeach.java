package kunal_dsa.LinearSearch;

public class LinearSeach {

    static int linearSearch(int[] arr, int target){

        // if the array is empty return -1
        if(arr.length == 0){
            return -1;
        }
        // iterate through the array
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        // if the target is not found
        return -1;
    }
static int linearSearch2(int[] arr, int target){

        // if the array is empty return -1
        if(arr.length == 0){
            return -1;
        }
        // iterate through the array
  for(int element :arr){
      if(element == target){
            return element;
      }
  }
        // if the target is not found
        return -1;
    }
    static int linearSearch(String str , char target){

        // if the string is empty return -1
        if(str.isEmpty()){
            return -1;
        }
        // iterate through the string
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == target) {

                return i;
            }
        }
        // if the target is not found
        return -1;
    }


    public static void main(String[] args) {
        int[] arr = {3,5,7,9,2,4,6,8};
        int target = 6;
        String str = "kunaldsa";
        char targetChar = 'd';
        System.out.println(linearSearch(arr,target));
        System.out.println(linearSearch(str,targetChar));
        System.out.println(rangeSearch(arr,2,2,5));
        System.out.println(min(arr));
        int[][] arr2d = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(SearchIn2dArray(arr2d,5));
        int[] minPos = findMinIn2dArray(arr2d);
        System.out.println("Min element position: ("+minPos[0]+","+minPos[1]+")");

        int[] arr3 = {12,345,2,6,-7896};
        System.out.println("No of elements with even digits: " + findNumber(arr3));
    }

    static int rangeSearch(int[] arr , int target , int start , int end){
        if(arr.length ==0){
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if(arr[i] == target){
                return i;
            }
        }
        return -1;
    }

    static int min(int[] arr){
        if(arr.length==0){
            return -1;
        }
        int min = arr[0];
        for (int element : arr){
            if(element<min){
                min = element;
            }
        }
        return min;
    }

    static String SearchIn2dArray(int[][] arr , int target){
        if(arr.length == 0){
            return "(_,_)";
        }
        for(int i = 0 ; i< arr.length ; i++){
            for (int j = 0 ; j< arr[i].length ; j++){
               if(arr[i][j] ==  target){
                   return "("+(i+1)+","+(j+1)+")";
               }
            }

        }
        return "(_,_)";
    }

    static int[] findMinIn2dArray(int[][] arr){
        if(arr.length == 0){
            return new int[]{-1,-1};
        }
        int minRow = -1;
        int minCol = -1;
        int min = Integer.MAX_VALUE;

        for(int i= 0; i<arr.length ; i++){
            for(int j =0 ; j< arr[i].length ; j++){
                if(arr[i][j] < min){
                    min = arr[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }
        return new int[]{minRow,minCol};

    }

    static int digits(int number) {
        if(number == 0){
            return 1;
        }
        if (number<0){
            number = -number;
        }
        int count  = 0;
        while(number>0){
            number = number/10;
            count++;
        }
        return count;
    }
    static int digits2(int number){
        if(number<0){
            number = -number;
        }
        return Integer.toString(number).length();
    }
    static int digits3(int number){
        if(number<0){
            number = -number;
        }
        return (int)(Math.log10(number))+1;
    }

    static boolean even(int number){

        int no_of_digit = digits3(number);
        return no_of_digit % 2 == 0;
    }
    static int findNumber(int[] arr){
        int count = 0;
        for(int element : arr){
            if(even(element)){
                count++;
            }
        }
        return count;
    }


}
