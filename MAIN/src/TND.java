//DRY RUN CENTRE

public class TND {
    public static void main(String[] args) {


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



    static void ss(int[] arr , int n){
        for ( int i = 0; i <=n-1 ; i++){
            int mini = i;
            for ( int j =0 ; j <= n ; j++){
                if ( arr[j] < arr[mini]){
                    mini = j;
                }
                int temp = arr[mini];
                arr[mini] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
