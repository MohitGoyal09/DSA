import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = {12 , 24, 36,  45, 3, 56,};
        int traget = in.nextInt();
        boolean ans = linearS3(arr , traget);
        System.out.println(ans);
    }

    //Search the element and return true or false
    static boolean linearS3( int[] arr , int target){
        if ( arr.length == 0){
            return false;
        }

        for ( int element : arr){
            if ( element == target){
                return true;
            }
        }

        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return false;
    }

    //Search the element and return the element
    static int linearS2( int[] arr , int target){
        if (arr.length ==0){
            return -1;
        }
        for ( int element : arr){
            if (element == target){
                return element;
            }
        }
        // this line will execute if none of the return statements above have executed
        // hence the target not found
        return Integer.MAX_VALUE;
    }

    static int linearS( int[] arr , int target){
        // IF ARR HAS NO ELEMENTS
        if ( arr.length == 0) {
            return -1;
        }
        // FOR LOOP
         for ( int i = 0 ; i <= arr.length ; i++){
             int element = arr[i];
             if( element == target){       //CHECKING
                 return i; //RETURNING INDEX OF THE ELEMENT
             }
         }

         //IF NO SUCH ELEMENT EXISTS IN ARR.
        return -1;
    }
}