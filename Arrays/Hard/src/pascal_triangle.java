import java.util.ArrayList;
import java.util.List;

// *Variation 1: Given row number r and column number c. Print the element at position (r, c) in
 // * Pascal’s triangle.
// * Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
// * Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
public class pascal_triangle {
    public static void main(String[] args) {
        int r = 5; // row number
        int c = 3; // col number
        int element = varitaiton1(r, c);
        int n = 6;

        System.out.println("The element at position (r,c) is: " + element);
        List<List<Integer>> ans = var3_optimal(n);
        for (List<Integer> it : ans) {
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    static long ncr(int n,int r){
        long res = 1;
        for ( int i = 0 ; i < r ; i++){
            res = res * (n-i);
            res = res / (i+1);

        }
        return res;
    }
    static int varitaiton1(int r , int c){
        int el = (int) ncr(r-1 , c-1);
        return el;
    }

    // ! Variation 2
     public static void brutte(int n) {
         // printing the entire row n:
         for (int c = 1; c <= n; c++) {
             System.out.print(ncr(n - 1, c - 1) + " ");
         }
         System.out.println();
     }
     public static void optimal(int n){
        long ans = 1;
         System.out.print(ans + " ");

         for ( int i = 1 ; i < n ; i++){
             ans = ans * (n-i);
             ans = ans/i;
             System.out.print(ans + " ");
         }
         System.out.println();
     }
     // ! Variation 3

     public static List<List<Integer>> var3(int n){
        List<List<Integer>> ans = new ArrayList<>();

        for ( int row = 1 ; row <= n ; row++){
            List<Integer> temp = new ArrayList<>();
            for ( int col = 1 ; col <= row ; col++){
                temp.add((int)ncr(row-1 , col-1));
            }
            ans.add(temp);
        }
        return ans;
     }

     public static List<Integer> generaterow(int row){
        long res = 1;
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        for ( int col = 1 ; col < row ; col++ ){
            res = res * (row - col);
            res = res / col;
            ans.add((int)res);
        }
        return ans;
     }

     public static List<List<Integer>> var3_optimal(int n){
        List<List<Integer>> ans = new ArrayList<>();
        for ( int row = 1 ; row <= n ; row++){
            ans.add(generaterow(row));
        }
        return ans;
     }

}
