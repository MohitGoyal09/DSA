public class mising_repated_no {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        int[] ans = optimal(arr);
        System.out.println("The missing and repated numbers are: " + ans[0] + " " + ans[1]);
    }

    // ? Brute
    // ! Time Complexity : O(n^3)
    // ! Space Complexity : O(1)
    static int[] brute(int[] arr){
        int n = arr.length;
        int missing = -1 , repating = -1;
        for ( int i = 1 ; i < n ; i++){
            int cnt = 0;
            for ( int j = 0 ; j <  n ; j++){
                if (arr[j] == i){
                    cnt++;
                }
            }
            if (cnt == 0) missing = i;
            else if (cnt == 2) repating = i;
            if ( missing != -1 && repating != -1 ) break;
        }
        int[] ans = {missing, repating};
        return ans;

    }

    // ? Better
    // ! Time Complexity : O(n^2)
    // ! Space Complexity : O(n)
    static int[] better(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        for ( int i = 0 ; i < n ; i++) hash[arr[i]]++;
        int missing = -1 , repating = -1;
        for ( int i = 1 ; i <= n ; i++){
            if (hash[i] == 0) missing = i;
            else if (hash[i] == 2) repating = i;
            if ( missing != -1 && repating != -1 ) break;
        }
        int[] ans = {missing, repating};
        return ans;
    }

    // ? Optimal
    // ! Time Complexity : O(n)
    // ! Space Complexity : O(1)
    static int[] optimal(int[] a){
        int n = a.length;
        long Sum = (n*(n+1))/2;
        long SqSum = (n*(n+1)*(2*n+1))/6;
        long s1 = 0 , s2 = 0;
        for ( int i = 0 ; i < n ; i++){
            s1 += a[i];
            s2 += (long) a[i]* (long) a[i];
        }
        long first =  s1 - Sum; // x - y
        long second =  s2 - SqSum; // x^2 - y^2
         second = second/first; // x + y
        long x = ( first + second) / 2;
        long y = x - first;
        int[] ans = {(int)x, (int)y};
        return ans;
    }
}
