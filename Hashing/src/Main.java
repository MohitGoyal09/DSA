
import java.util.Scanner;

// Time Complexity = O(Q*N)
// Where
//  number of queries = Q
//  N = size of the string.

//=================================================================

// NUMBER HASHING;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Length of array");
        int n = in.nextInt();
        int[] arr = new int[n];
        for ( int i = 0; i<n; i++){
             arr[i] = in.nextInt();
        }

        //Precompute
        int[] hash =  new int[13];

        for ( int i = 0; i<n ; i++){
            hash[arr[i]]+=1;
        }
        int q;
        q = in.nextInt();
        while (q-- !=0){
            int num;
            num = in.nextInt();
            //Fetching
            System.out.println(hash[num]);
        }
    }
}