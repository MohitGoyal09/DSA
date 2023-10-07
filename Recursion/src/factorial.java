public class factorial {
    public static void main(String[] args) {
           int n = 3;
       fac(3,1 );
        System.out.println(Nfac(n));
    }
    //PARAMETER
    static void fac(int n , int factorial ){
        if ( n == 0){
            System.out.println(factorial);
            return;
        }

        fac( n-1 , factorial *n);

    }
    // FUNCTIONAL
    static int Nfac( int n){
        if ( n == 0) return 1;
        return n * Nfac(n-1);
    }
}
