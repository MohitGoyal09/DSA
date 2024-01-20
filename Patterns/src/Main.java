import java.util.Arrays;

//STRIDER 'S SHEET
// https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/
public class Main {
    public static void main(String[] args) {
        pattern8(4);
    }

    static void pattern1(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= n; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print(col + "");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int row = 1; row <= n; row++) {
            // for every row, run the col
            for (int col = 1; col <= row; col++) {
                System.out.print(row + "");
            }
            // when one row is printed, we need to add a newline
            System.out.println();
        }
    }

    static void pattern5(int N) {
        // This is the outer loop which will loop for the rows.
        for (int i = 0; i < N; i++)
        {
            // This is the inner loop which loops for the columns
            // no. of columns = (N - row index) for each line here.
            for (int j = N; j > i; j--)
            {
                System.out.print("* ");
            }

            // As soon as stars for each iteration are printed, we move to the
            // next row and give a line break otherwise all stars
            // would get printed in 1 line.
            System.out.println();
        }
    }

    static void pattern6(int N) {
        // This is the outer loop which will loop for the rows.
        for (int i = 0; i < N; i++) {
            // This is the inner loop which loops for the columns
            // no. of columns = (N - row index) for each line here
            // as we have to print an inverted pyramid.
            // (N-j) will give us the numbers in a row starting from 1 to N-i.
            for (int j = N; j > i; j--) {
                System.out.print(N - j + 1 + " ");
            }

            // As soon as numbers for each iteration are printed, we move to the
            // next row and give a line break otherwise all numbers
            // would get printed in 1 line.
            System.out.println();
        }
    }

    static void pattern7(int N) {
        // This is the outer loop which will loop for the rows.
        for (int i = 0; i < N; i++)
        {
            // For printing the spaces before stars in each row
            for (int j =0; j<N-i-1; j++)
            {
                System.out.print(" ");
            }

            // For printing the stars in each row
            for(int j=0;j< 2*i+1;j++){

                System.out.print("*");
            }

            // For printing the spaces after the stars in each row
            for (int j =0; j<N-i-1; j++)
            {
                System.out.print(" ");
            }


            // As soon as the stars for each iteration are printed, we move to the
            // next row and give a line break otherwise all stars
            // would get printed in 1 line.
            System.out.println();
        }
    }


   static void pattern8(int N) {
        // This is the outer loop which will loop for the rows.
        for(int i=0;i<N; i++){
        // For printing the spaces before stars in each row
        for(int j=0;j<i; j++) {
        System.out.print(" ");
        }

        // For printing the stars in each row
        for(int j=0;j< 2*N-(2*i+1);j++){

        System.out.print("*");
        }

        // For printing the spaces after the stars in each row
        for(int j=0;j<i; j++)
        {
        System.out.print(" ");
        }


        // As soon as the stars for each iteration are printed, we move to the
        // next row and give a line break otherwise all stars
        // would get printed in 1 line.
        System.out.println();
        }

        }


    static void pattern10(int N) {
        // Outer loop for number of rows.
        for(int i=1;i<=2*N-1;i++){

            // stars would be equal to the row no. uptill first half
            int stars = i;

            // for the second half of the rotated triangle.
            if(i>N) stars = 2*N-i;

            // for printing the stars in each row.
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }

            // As soon as the stars for each iteration are printed, we move to the
            // next row and give a line break otherwise all stars
            // would get printed in 1 line.
            System.out.println();
        }
    }

    static void pattern11(int N) {
        // First row starts by printing a single 1.
        int start =1;

        // Outer loop for the no. of rows
        for(int i=0;i<N;i++){

            // if the row index is even then 1 is printed first
            // in that row.
            if(i%2 ==0) start = 1;

                // if odd, then the first 0 will be printed in that row.
            else start = 0;

            // We alternatively print 1's and 0's in each row by using
            // the inner for loop.
            for(int j=0;j<=i;j++){
                System.out.print(start);
                start = 1-start;
            }


            // As soon as the numbers for each iteration are printed, we move to the
            // next row and give a line break otherwise all numbers
            // would get printed in 1 line.
            System.out.println();
        }
    }

    static void pattern12( int N){
        int space = 2*(N-1);
        for ( int i = 1 ; i <= N ; i++){
            for ( int j = 1 ; j <=  i ; j++){
                System.out.print(j);
            }

           for ( int x = 1; x <= space ; x++ ){
               System.out.print(" ");
           }

            for ( int j = i ; j >=  1 ; j--){
                System.out.print(j);
            }
            System.out.println();
            space -=2;
        }

    }

    static void pattern13( int N){
        for ( int i = 1 ; i <=N ; i++){
            int num = 1;
            for ( int j = 1 ; j <=i ; j++){
                System.out.print(num + "");
                num +=1;
            }
            System.out.println();
        }
    }

    public static class RRotate {
        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 4, 5 , 6  , 7, 8, 9, 10};
            int n = arr.length;
            int k = 2;
            System.out.println("Arrays after right rotation: ");
            rotateByK(arr, k, n);
            optimizedRotateByK(arr, k, n);
            System.out.println(Arrays.toString(arr));
        }
        // ? Burte Force Approach
        // * Time Complexity: O(n)
        // * Space Complexity: O(k)
        public static void rotateByK(int[] arr , int k , int n){
                if ( n == 0) return;
                k = k % n;
                if ( k > n ) return;
                int[] temp = new int[k];
            for (int i = n - k; i < n; i++) {
                temp[i - n + k] = arr[i];
            }
            for (int i = n - k - 1; i >= 0; i--) {
                arr[i + k] = arr[i];
            }
            for (int i = 0; i < k; i++) {
                arr[i] = temp[i];
            }
        }

        // ? Optimized Approach
        // * Time Complexity – O(N) where N is the number of elements in an array
        // * Space Complexity – O(1) since no extra space is required
        public static void optimizedRotateByK(int[] arr, int n, int k) {
            if ( n == 0) return;
            k = k % n;
            if ( k > n ) return;
            // !  Reverse first n-k elements
            reverse(arr , 0 , n-k-1);
            // ! Reverse last k elements
            reverse(arr , n-k ,n-1);
            // ! Reverse whole array
            reverse( arr ,  0 ,n-1);
        }


        // ? Reverse the array
        static int[] reverse(int[] arrr , int start , int end){

            while(start < end){
                int temp = arrr[start];
                arrr[start] = arrr[end];
                arrr[end] = temp;
                start++;
                end--;
            }
            return arrr;
        }
    }
}
