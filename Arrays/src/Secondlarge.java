import java.util.Arrays;

public class Secondlarge {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 9, 7, 8, 9, 10};
        int n = arr.length;
        int s1 = optimal(arr, n);
//
        System.out.println(s1);
    }
    static int optimal(int[] arr , int n){
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        if ( n <2)
            return -1;
        int largetst = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        int i;
        for ( i = 0 ; i < n ; i++){
            if ( arr[i] > largetst){
                secondlargest = largetst;
                largetst = arr[i];
            }
            else if ( arr[i] > secondlargest && arr[i] != largetst){
                secondlargest = arr[i];
            }
        }
        return secondlargest;
    }
    static int better(int[] arr , int n){
        // Time Complexity : O(n)
        // Space Complexity : O(1)
        if ( n <2)
            return -1;
        int largest = Integer.MIN_VALUE;
        int secondlargest = Integer.MIN_VALUE;
        int i;
        for ( i = 0; i < n; i++ ){
            largest = Math.max(largest , arr[i]);
        }
        for ( i = 0 ; i < n; i++ ){
            if ( arr[i] < largest && arr[i] > secondlargest){
                secondlargest = arr[i];
            }
        }
        return secondlargest;
    }
    static  void brute(int[] arr, int n) {
        //Time Complexity: O(NlogN), For sorting the array
        //Space Complexity: O(1)
        if (n == 0 || n==1)
        {
            System.out.print(-1);
            System.out.print(" ");
            System.out.print(-1);
            System.out.print("\n");
        }
        Arrays.sort(arr);
        int small = arr[1];
        int large = arr[n - 2];
        System.out.println("Second smallest is "+small);
        System.out.println("Second largest is "+large);
    }

}
