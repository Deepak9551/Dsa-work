package kunal_dsa.BinarySearch;

public class BinarySearchCode1 {

    static int binarySearchASC(int[]arr, int target){

        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(target<arr[mid]){
                end = mid -1 ;
            } else if (target>arr[mid]) {
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int binarySearchDESC(int[]arr, int target){

        if(arr.length == 0){
            return -1;
        }
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid = start + (end - start)/2;
            if(target<arr[mid]){
                start = mid + 1 ;
            } else if (target>arr[mid]) {
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
static int binarySearch(int[] arr, int target){
        int start = arr[0];
        int end  =  arr[arr.length-1];
       if(start<end) {
           return binarySearchASC(arr, target);
       }
       else {
           return binarySearchDESC(arr, target);
       }
}
static int firstOCCURRENCE(int[]arr,int target){

        int findFirst = -1;
        int start = 0;
        int end = arr.length-1;
        while (start<=end){
            int mid  = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid - 1;
            } else if (target>arr[mid]) {
                start = mid + 1;
            }
            else{
               findFirst = mid;
               end = mid - 1;
            }

        }
   return  findFirst;

}
    public static void main(String[] args) {

        int[] arr  = new int[]{9,8,7,5,4,3,2,1};
//        System.out.println(binarySearch(arr,4));
        int[] arr2 = new int[]{1,3,3,3,4,5,6};
        System.out.println(firstOCCURRENCE(arr2,3));
    }
}
