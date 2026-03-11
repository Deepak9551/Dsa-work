package kunal_dsa.BinarySearch;

public class  BinarySearchCode3 {

    public static void main(String[] args) {
        int[] arr = {'a','c','f','j'};
        int target = 'f';
        System.out.println((char) nextGreaterElement(arr,target));
    }

    private static int nextGreaterElement(int[] arr , int target) {

    int start = 0;
    int n = arr.length;
    int end  =  n-1;

    // loop until they are not cross to each other
    while (start<=end){
        int mid = start + (end - start)/2;

        if(target<arr[mid]) {
            end = mid-1;

        } else if (target>arr[mid]) {
            start = mid + 1;
        }
        else{
            start = mid+1;

        }
    }

    return arr[start % arr.length] ;
    }
}
