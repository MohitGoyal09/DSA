public class SumofN {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(sumofN(n));
        sum( n, 0);
    }

    // FUNCTIONAL FORM
    static int sumofN( int n){
        if ( n == 0) return 0;
        return n + sumofN(n-1);
    }

    // PARAMETER FORM
    static void sum(int i , int sum ){
        if ( i < 1) {
            System.out.println(sum);
            return;
        }
        sum( i - 1 , sum + i);

    }
}
