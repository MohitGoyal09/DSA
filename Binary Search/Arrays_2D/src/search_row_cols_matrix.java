import java.util.ArrayList;
import java.util.Arrays;

public class search_row_cols_matrix {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 4, 7, 11, 15)));
        matrix.add(new ArrayList<>(Arrays.asList(2, 5, 8, 12, 19)));
        matrix.add(new ArrayList<>(Arrays.asList(3, 6, 9, 16, 22)));
        matrix.add(new ArrayList<>(Arrays.asList(10, 13, 14, 17, 24)));
        matrix.add(new ArrayList<>(Arrays.asList(18, 21, 23, 26, 30)));

        boolean result = bs(matrix, 8);
        System.out.println(result ? "true" : "false");
    }

    static boolean bs(ArrayList<ArrayList<Integer>> matrix , int target){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int row = 0 , col = m - 1;
        while ( row < n && col >= 0){
            if (matrix.get(row).get(col) == target) return true;
            else if (matrix.get(row).get(col) < target) row++;
            else col--;
        }
        return false;
    }
}
