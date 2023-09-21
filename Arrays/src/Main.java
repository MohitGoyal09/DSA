import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int [][] arr = new int[3][3];
        System.out.println(arr.length);

        for( int row = 0 ; row < arr.length  ; row ++){
            for ( int col = 0 ; col < arr[row].length ; col++){
                //INPUT
                arr[row][col] = in.nextInt();
            }
        }
        for (int row = 0; row < arr.length; row++) {
            // for each col in every row
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col] + " ");
            }
            System.out.println();
        }

        //ARRAY LIST
        ArrayList<Integer> list = new ArrayList<>(10);
    }
}