
public class Main {
    public static void main(String[] args) {
        int[] arr = { 1, 2,4, 5, 56 , 67 , 77, 98};
        int target = 77;
        int ans = binarySearch(arr, target);
        System.out.println(ans);

    }

    static int binarySearch( int[] arr , int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            //FIND MID POINT
            int mid = start + (end - start) / 2;

            if (target < arr[mid]){
                end = mid - 1;
            } else if ( target > arr[mid]){
                start = mid + 1;
            } else {
                return mid;
            }
            
        }
        return -1;
    }
}