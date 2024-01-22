import java.util.Arrays;

public class Searchin2D {
    public static void main(String[] args) {
          int[][] arr = { {3,4, 5, 8},
                  {56 , 67 , 45 , 78},
                  {23 , 24 , 235 , 223}
          };
          int target = 67;
          int[] ans = search(arr , target);
          System.out.println(Arrays.toString(ans));
    }
    static int[] search( int[][] arr , int target){
        for (int row = 0; row < arr.length; row++) {
            // for each col in every row
            for (int col = 0; col < arr[row].length; col++) {
                if ( arr[row][col] == target){
                    return new int[] { row , col};
                }
            }

        }
        return  new int[]{ -1 ,-1};
    }
}
