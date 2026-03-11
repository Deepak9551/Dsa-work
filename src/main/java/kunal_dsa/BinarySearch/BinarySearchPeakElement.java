package kunal_dsa.BinarySearch;

public class BinarySearchPeakElement {

    public static int peakElement(int [] arr){
        int n =  arr.length;
        if (n==1 ) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;
        int peak = -1;
        int start  = 0;
        int end  = n-1;
        while (start<=end){
            int mid= start + (end - start)/2;

            if(start == end) return mid;
            // code for ascending capture
            if(arr[mid] < arr[mid+1]){
              start = mid + 1;

            }
            // code for descending capture
            else if (arr[mid] > arr[mid-1]) {
                end  = mid;
            }

        }
      return end;
    }

    public static int peakElement2(int [] arr){
        int n =  arr.length;
        if (n==1 ) return 0;
        if (arr[0] > arr[1]) return 0;
        if (arr[n-1] > arr[n-2]) return n-1;

        int start  = 0;
        int end  = n-1;
        while (start<end){
            int mid= start + (end - start)/2;


            // code for ascending capture
            if(arr[mid] < arr[mid+1]){
                start = mid + 1;

            }
            // code for descending capture
            else  {
                end  = mid;
            }

        }
        return end;
    }

public static int mountain(int[] arr, int target){
        int n = arr.length;

       int peakElement = peakElement2(arr);
    System.out.println(peakElement);
      int answer =  binarySearch(arr,0,peakElement,target , true);
      if (answer == -1){
        answer =  binarySearch(arr,peakElement + 1,n-1,target,false);
      }
      return answer;


}
public  static int binarySearch(int[] arr,int start , int end ,int target , boolean isAscending){
        while (start<=end){
            int  mid  = start + (end - start)/2;
            if(target == arr[mid]) return mid ;
            if(isAscending){
                if(target<arr[mid]) end = mid -1;
                else start = mid + 1;
            }
            else{
                if(target>arr[mid]) end = mid -1;
                else start = mid +1;
            }

        }
    return -1;
}
    public static void main(String[] args) {
        int[] arr = {1,2,4,5,6,7,6,5,4,3,2,1};
//        System.out.println(peakElement2(arr));
        System.out.println(mountain(arr,3));
    }
}
