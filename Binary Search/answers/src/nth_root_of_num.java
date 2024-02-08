public class nth_root_of_num {
    public static void main(String[] args) {
        int n = 3, m = 27;
        int ans = NthRoot(n, m);
        System.out.println("The answer is: " + ans);

    }
    static int NthRoot(int root , int number){
        int low = 1 , high = number;
        while (low <= high){
            int mid = (low + high)/2;
            int midM = func(mid , root , number);
            if (midM == 1){
                return mid;
            } else if (midM == 0){
                low = mid + 1;
            } else high = mid - 1;

        }
        return -1;
    }

    private static int func(int mid, int root, int number) {
        // Return 1 if mid == m
        //Return 0 if mid < m
        //Return 2 if mid > m
        long ans = 1;
        for ( int i = 0 ; i <= root ; i++){
            ans = ans * mid;
            if ( ans > number) return 2;
        }
        if ( ans == number) return 1;
        return 0;
    }
}
