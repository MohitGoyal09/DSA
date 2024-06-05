import java.util.Stack;


public class celebirty_prblm {
}
class Solution11 {
    //* Function to find if there is a celebrity in the party or not.
    boolean Knows(int[][] M, int a , int b ) {
        return M[a][b] == 1;
    }

    int celebrity(int[][] M, int n) {
        Stack<Integer> s = new Stack<>();
        // ! Step 1 : - Push all candidates in the stack
        for (int i = 0 ; i < n ; i++) s.push(i);
        // ! Step 2 : - Take two at a time and check it they know each other
        while (s.size() > 1){
            int a = s.peek();
            s.pop();
            int b = s.peek();
            s.pop();
            if (Knows(M,a,b)) s.push(b);
            else s.push(a);
        }
        // * One left is potential Candidate
        int ans = s.peek();
        // ! Step 3 :- Verify by checking its row and Column
        int zeroCount = 0 ;
        for (int i = 0 ; i < n ; i++) if (M[ans][i] == 0) zeroCount++;
        if (zeroCount != n) return -1;
        int OneColumn = 0;
        for (int i = 0 ; i < n ; i++) if (M[i][ans] == 1) OneColumn++;
        if (OneColumn != n-1) return -1;
        return ans;
    }
}