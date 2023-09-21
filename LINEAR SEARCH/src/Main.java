
public class Main {
    public static void main(String[] args) {
        int[] arr = {12 , 24, 36,  45, 3, 56,};
        int traget = 3;
        int ans = linearS(arr , traget);
        System.out.println(ans);
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