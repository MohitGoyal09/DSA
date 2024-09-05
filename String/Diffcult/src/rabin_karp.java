import java.util.*;
public class rabin_karp {



    class TUF {
        static void rabinKarpAlgo(String pattern, String text, int q) {

            int m = pattern.length();
            int n = text.length();
            int i, j, hash_p = 0, hash_t = 0, h = 1, d = m + n;

            for (i = 0; i < m - 1; i++) {
                h = (h * d) % q;
            }

            // Calculate hash value for pattern and text
            for (i = 0; i < m; i++) {
                hash_p = (pattern.charAt(i) + d * hash_p) % q;
                hash_t = (text.charAt(i) + d * hash_t) % q;
            }

            // Find the match
            for (i = 0; i <= n - m; i++) {

                // Check the hash values of current windows of text and pattern.
                if (hash_p == hash_t) {

                    for (j = 0; j < m; j++) {

                        if (text.charAt(i + j) != pattern.charAt(j)) break;
                    }

                    // if pattern == text
                    if (j == m) System.out.println("Pattern is found at index : " + i);
                }

                // Calculate the hash value for next window : adding trailing digit and
                //remove leading digit
                if (i < n - m) {
                    hash_t = (d * (hash_t - text.charAt(i) * h) + text.charAt(i + m)) % q;

                    //converting negative value of hash_t to positive.
                    if (hash_t < 0) hash_t = (hash_t + q);
                }
            }
        }

        public static void main(String args[]) {
            String text = "GEEKS FOR GEEKS";
            String pattern = "GEEK";
            int q = 101;
            rabinKarpAlgo(pattern, text, q);
        }
    }
}
