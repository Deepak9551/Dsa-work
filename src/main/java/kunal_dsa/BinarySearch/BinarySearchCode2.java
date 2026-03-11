package kunal_dsa.BinarySearch;

public class BinarySearchCode2 {

    static int celingBinarySearch(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        int ceilingMid  = -1;
        if (arr.length == 0 ) return -1;
        if(target>arr[arr.length- 1]) return -1;

        while (start<=end){

            int mid  = start + (end - start)/2;

            if(target<arr[mid]){
                end = mid - 1;

            } else if (target>arr[mid]) {
                start = mid + 1;
            ceilingMid = start;

            }
            else{
                return mid;
            }
        }
        return arr[ceilingMid];

    }

    static int floorBinarySearch(int[] arr , int target){
        int start = 0;
        int end = arr.length-1;
        int floorMid  = -1;
        while (start<=end){

            int mid  = start + (end - start)/2;

            if(target<arr[mid]){
                end = mid - 1;
                floorMid = end;

            } else if (target>arr[mid]) {
                start = mid + 1;


            }
            else{
                return mid;
            }
        }
        return arr[floorMid];

    }
    public static void main(String[] args) {
        System.out.println(celingBinarySearch(new int[]{2,3,5,9,14,16,18},15));
        System.out.println(floorBinarySearch(new int[]{2,3,5,9,14,16,18},15));
    }
}
