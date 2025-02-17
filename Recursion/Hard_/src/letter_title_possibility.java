import java.util.*;

public class letter_title_possibility {
    // Approach-1 (Using simple backtracking Khandani Template)
// T.C : O(n!)
// S.C : O(n * n!), total possible sequences = n! and each having n length
    int n;
    public int numTilePossibilities(String titles){
        n = titles.length();
        HashSet<String> result = new HashSet<String>();
        boolean used[] = new boolean[n];
        StringBuilder curr = new StringBuilder();
        solve(titles , curr , used , result);
        return curr.length() - 1;
    }
    private void solve(String titles , StringBuilder curr , boolean[] used ,HashSet<String> result ){
        result.add(curr.toString());
        for (int i = 0 ; i < n ; i++){
            if (used[i]) continue;
            curr.append(titles.charAt(i));
            used[i] = true;
            solve(titles , curr , used , result);
            used[i] = false;
            curr.deleteCharAt(curr.length()-1);
        }
    }
    class Solution {
        private int total;
        public int numTilePossibilities(String tiles) {
            total = 0;
            int[] count = new int[26];
            for (char c : tiles.toCharArray()){
                count[c - 'A']++;
            }
            findfreq(count);
            return total - 1;
        }
        private void findfreq(int[] count){
            total++;
            for (int pos = 0 ; pos < 26 ; pos++){
                if (count[pos] == 0) continue;
                count[pos]--;
                findfreq(count);
                count[pos]++;
            }
        }
    }
}
