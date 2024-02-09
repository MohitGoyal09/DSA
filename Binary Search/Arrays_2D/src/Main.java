import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, 0, 0)));

        int n = 3, m = 3;
        System.out.println("The row with the maximum number of 1's is: " +
                rowwithMatrix(matrix, n, m));
    }

    static int rowwithMatrix(ArrayList<ArrayList<Integer>> matrix, int n, int m){
        int cnt_max =0;
        int index = -1;
        for ( int i = 0 ; i < n ; i++){
            int cnt = 0;
            for ( int j = 0 ; j < m ; j++){
                cnt += matrix.get(i).get(j);
            }
            if ( cnt > cnt_max){
                cnt_max = cnt;
                index = i;
            }
        }
        return index;
    }
}