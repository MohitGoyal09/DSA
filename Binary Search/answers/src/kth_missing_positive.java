public class kth_missing_positive {
    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int k = 4;
        int ans = bs(vec,  k);
        System.out.println("The missing number is: " + ans);
    }

    static int kthmissing(int[] a ,  int k){
        int n = a.length;
        for ( int i = 0 ; i <n ; i++){
            //shifting k
            if (a[i] <= k)   k++;
             else break;
        }
        return k;
    }
    static int bs(int[] a , int k){
        int low = 0 , high = a.length - 1;
        while ( low <= high){
            int mid = (low + high)/2;
            int missing = a[mid] - (mid+1);
            if (missing < k) low = mid+1;
            else high = mid - 1;
        }
        return (high+1 + k);
    }
}
