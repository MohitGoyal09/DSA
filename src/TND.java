//DRY RUN CENTRE

public class TND {
    public static void main(String[] args) {
        int n = 5;
        nto1(1,n);

    }
//    static void pattern( int n){
//        int count = 1;
//        for ( int i = 0 ; i< n ; i++){
//
//            for ( int j = n  ; j>i ; j--){
//                count++;
//                System.out.print(count   + "");
//            }
//            System.out.println();
//        }
//    }

// static void p2( int n){
//        for ( int i = 0 ; i < n ; i++){
//
//            for ( int  j = 0; j < n-i-1 ; j++){
//                System.out.print(" ");
//            }
//            for ( int j = 0; j < 2*i +1 ; j++){
//                System.out.print("*");
//            }
//            for ( int  j = 0; j < n-i-1 ; j++){
//                System.out.print(" ");
//            }
//            System.out.println();
//
//        }
// }

// static void p3(int n){
//        for ( int i = 0; i < n ; i++){
//
////            for ( int j = )
//        }
// }
//
// static void r( int i ,int n){
//        if ( i < 1) return;
//       System.out.println(i);
//       r( i -1 , n);
//
// }
//    static void sum( int i , int sum) {
//
//
//        if (i < 1) {
//            System.out.println(sum);
//            sum(i-1 , sum + i);
//        }
//    }

    static void nto1( int i , int n){
        if ( i > n) return;
            System.out.println(i);


         nto1( i+1 , n);
    }

}
