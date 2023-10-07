import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Divisors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        brufeforcemethod(n);
          optimized(n);

    }

    static void brufeforcemethod( int n ){

        for ( int i  = 1 ; i <=n ; i++){
            if ( n % i == 0){
                System.out.println(i);
            }
        }
    }

    // T & C = O(N)

    static void optimized( int n ){
        ArrayList<Integer>  list = new ArrayList<>();
        for ( int i = 1 ; i*i <= n ; i++){
            if ( n % i == 0){
                list.add(i);
                System.out.println(i);
                if ( n/i != i ){
                    list.add(n/i);
                    System.out.println(n/i);
                }
            }

        }
//        Arrays.sort(list);
        System.out.println(list);
    }

    // T & C = O(sqrt(n))
}
