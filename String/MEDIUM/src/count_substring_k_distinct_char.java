import java.util.Arrays;

public class count_substring_k_distinct_char {
    public static void main(String[] args) {
        String ch = "abcbaa";
        int k = 3;
        System.out.println(buruteForce(ch, k));
    }
    // ! Time Complexity : O(n^3)
    static int buruteForce(String s, int k) {
        int n = s.length();
        int count = 0;
        boolean seen[] = new boolean[26];
        for (int i = 0; i < n; i++) {
            int discont = 0;
            Arrays.fill(seen, false);
            for (int j = i; j < n; j++) {
                if (!seen[s.charAt(j) - 'a']) discont++;
                seen[s.charAt(j) - 'a'] = true;
                if (discont == k) count++;
            }
        }
        return count;
    }
}
