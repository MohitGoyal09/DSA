import java.util.*;

public class Alt_pos_neg {
    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1, 2, -4, -5));
        ArrayList<Integer> ans = RearrangebySign(A);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

    }

    // ? Burutte Force
    // ! Time complexity : O(n ^ 2)
    // ! Space Complexity : O(n)

    public static int[] brutte(int[] a, int n) {
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            if (a[i] > 0) {
                pos.add(a[i]);
            } else {
                neg.add(a[i]);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            a[2 * i] = pos.get(i);
            a[2 * i + 1] = neg.get(i);

        }
        return a;
    }

    // ? optimal Approach
    // ! Time Complexity : O(n)
    // ! Space Complexity : O(n)
    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A) {
        int n = A.size();

        // Define array for storing the ans separately.
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n, 0));

        // positive elements start from 0 and negative from 1.
        int posIndex = 0, negIndex = 1;
        for (int i = 0; i < n; i++) {

            // Fill negative elements in odd indices and inc by 2.
            if (A.get(i) < 0) {
                ans.set(negIndex, A.get(i));
                negIndex += 2;
            }

            // Fill positive elements in even indices and inc by 2.
            else {
                ans.set(posIndex, A.get(i));
                posIndex += 2;
            }
        }

        return ans;
    }



    // !  VARIETY 2
    // ? IF Number of Pos and Neg are not equal

    static ArrayList<Integer> variety2(ArrayList<Integer> ans){
        int n = ans.size();
        ArrayList<Integer> pos = new ArrayList<Integer>();
        ArrayList<Integer> neg = new ArrayList<Integer>();
        for ( int i = 0; i < n ; i++){
            if ( ans.get(i) < 0){
                neg.add(ans.get(i));
            }
            else pos.add(ans.get(i));
        }

        if ( neg.size() < pos.size()){
            for ( int i = 0; i < neg.size() ; i++){
                ans.set(2*i,pos.get(i));
                ans.set(2*i + 1 , neg.get(i));
            }
            int index = neg.size() * 2;
            for ( int i = pos.size() ; i < neg.size() ; i++){
                ans.set(index , pos.get(i));
                index++;
            }
        }
        return ans;
    }
}

