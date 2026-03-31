package practice_own.twoPointer;

public class PeakElement {
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,6,5,4,3,2,1};
        System.out.println( findMountainPeak(arr));
    }
    public static int findMountainPeak(int[] arr ){
        int n = arr.length;

        int start = 0;
        int end = n-1;
        while (start<=end){
            if (start == end){
                return start;
            }
          int mid =  start + ( end - start)/2;

          // always move toward the peak Element
            if(arr[mid]<arr[mid + 1]){
                start = mid+ 1;
            }
            // end point to the peak
            else if (arr[mid]>arr[mid+1]) {
                end = mid;
            }
        }
        System.out.println(start);
        return start;
    }
}
