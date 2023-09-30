public class GCD {
    public static void main(String[] args) {
         normal(5,20);
         optimizited(7,13);
    }

   static  void  normal( int n , int m){
        // T & C = O(MIN(N,M))
        int ans = 1;
        for ( int i =1 ; i <= Math.min(n,m) ; i++){
            if ( n % i == 0 && m % i == 0){
                ans = i;
            }
        }
       System.out.println(ans);
    }

    static void optimizited( int n1 , int n2){
        // T&C = O(log ɸ min(a,b))
        while ( n1>0 && n2>0){
             if ( n1>n2){
                 n1 = n1%n2;
             } else n2 = n2%n1;
             if ( n2 == 0){
                 System.out.println(n1);
             } else {
                 System.out.println(n2);
             }
        }
    }
//    static int optimized2( int n1 , int n2){
//        if ( n2 == 0){
//          return n1;
//    }
//        return optimized2(n2, n1%n2);
//
//}

//    }
}

