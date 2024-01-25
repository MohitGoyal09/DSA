public class Print_largestsum_subaaray {
    public static void main(String[] args) {

        int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4};
        int n = arr.length;
        int ans = print(arr , n);
        System.out.println("The maximum subarray sum is: " + ans);
    }

    static int print(int[] a , int n){
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int start = 0;
        int ansStart = -1 , ansEnd = -1;
        for ( int i = 0 ; i < n ; i++){
            if ( sum == 0) start = i;
            sum +=a[i];

            if ( sum > max){
                max = sum;
                ansStart = start;
                ansEnd = i;
            }
            if ( sum < 0 ) sum = 0;
        }
        for ( int i = ansStart ; i <= ansEnd ; i++ ){
            System.out.print(a[i] + " ");
        }

        return max;
    }
}
