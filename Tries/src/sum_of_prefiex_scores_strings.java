import java.util.*;
public class sum_of_prefiex_scores_strings {
    //Approach - Using TRIE
//T.C : O(n*l), n = number of words, l = average length of each word
//S.C : O(n*l), need to store all characters of words
    class Solution {

        // TrieNode class equivalent to struct trieNode in C++
        class TrieNode {
            int countP = 0; // stores the number of prefixes ending here
            TrieNode[] children = new TrieNode[26]; // array to store children

            // Constructor to initialize a new TrieNode
            public TrieNode() {
                for (int i = 0; i < 26; i++) {
                    children[i] = null;
                }
                countP = 0;
            }
        }

        // Function to create a new TrieNode (Not needed separately in Java)
        private TrieNode getTrieNode() {
            return new TrieNode();
        }

        // Function to insert a word into the Trie
        private void insert(String word, TrieNode root) {
            TrieNode crawl = root;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';

                if (crawl.children[idx] == null) {
                    crawl.children[idx] = getTrieNode();
                }

                crawl.children[idx].countP += 1;
                crawl = crawl.children[idx];
            }
        }

        // Function to get the score for the word (sum of scores for all prefixes)
        private int getScore(String word, TrieNode root) {
            TrieNode crawl = root;
            int score = 0;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                score += crawl.children[idx].countP;
                crawl = crawl.children[idx];
            }

            return score;
        }

        // Main function to return the sum of prefix scores for each word
        public int[] sumPrefixScores(String[] words) {
            int n = words.length;
            TrieNode root = getTrieNode();

            // Insert all words into the Trie
            for (String word : words) {
                insert(word, root);
            }

            // Array to store the result (sum of prefix scores for each word)
            int[] result = new int[n];

            // Calculate the sum of prefix scores for each word
            for (int i = 0; i < n; i++) {
                result[i] = getScore(words[i], root);
            }

            return result;
        }
    }
}
