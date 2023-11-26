public class faconachi {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(facn(n));

    }
    static int facn(int n){
        if ( n <= 1) return n;
        int last = facn(n-1);
        int slast = facn(n-2);

        return last + slast;
    }
    static void fac(int n){
        int  a = 0 , b = 1 , c;
        for ( int i = 1 ; i <= n ; i++) {
            c = a + b;
            a = b;
            b = c;
            System.out.println();
        }
    }
}
