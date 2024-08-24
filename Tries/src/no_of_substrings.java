import java.util.*;
public class no_of_substrings {
    class Node {
        Node[] links;
        // Array of pointers to child nodes,
        // each corresponding to a letter
        // of the alphabet
        boolean flag;
        // Flag indicating if the current
        // node represents the end of a substring

        // Method to check if a specific character key
        // exists in the children of the current node
        public boolean containsKey(char ch) {
            // Check if the current node has a child node
            // corresponding to character 'ch'
            return links[ch - 'a'] != null;
        }

        // Method to get the child node corresponding
        // to a specific character key
        public Node get(char ch) {
            // Get the child node
            // corresponding to character 'ch'
            return links[ch - 'a'];
        }

        // Method to insert a new child
        // node with a specific character key
        public void put(char ch, Node node) {
            // Insert a new child
            // node for character 'ch'
            links[ch - 'a'] = node;
        }

        // Method to mark the current
        // node as the end of a substring
        public void setEnd() {
            // Mark the current node
            // as the end of a substring
            flag = true;
        }

        // Method to check if the current
        // node marks the end of a substring
        public boolean isEnd() {
            // Check if the current node
            // marks the end of a substring
            return flag;
        }
    }

    public int countDistinctSubstring(String s) {
        int n = s.length();
        Node root = new Node();
        int cnt = 0;

        for ( int i = 0 ; i <n ; i++){
             Node node = root;
             for ( int j = i ; j < n ; j++){
                 if (!node.containsKey(s.charAt(j))){
                     node.put(s.charAt(j) , new Node());
                     cnt++;
                 }
                 node = node.get(s.charAt(j));
             }
        }
        return cnt + 1;
    }
}
