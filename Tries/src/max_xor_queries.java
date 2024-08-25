import java.util.*;
public class max_xor_queries {



    // Define a node structure for a trie,
// which contains links to child nodes.
    static class Node {
        // Array to hold links
        // to child nodes (0 and 1)
        Node[] links;

        // Constructor to initialize
        // the array of links
        Node() {
            links = new Node[2];
        }

        // Function to check if a child node
        // exists at a given index (0 or 1)
        boolean containsKey(int ind) {
            return (links[ind] != null);
        }

        // Function to get the child
        // node at a given index (0 or 1)
        Node get(int ind) {
            return links[ind];
        }

        // Function to set the child
        // node at a given index (0 or 1)
        void put(int ind, Node node) {
            links[ind] = node;
        }
    }
    static class Pair<T, U> {
        public T first;
        public U second;

        public Pair(T first, U second) {
            this.first = first;
            this.second = second;
        }
    }

    // Class definition for
// Trie data structure
    static class Trie {
        // Pointer to the root
        // node of the trie
        Node root;

        // Constructor to initialize the
        // trie with an empty root node
        Trie() {
            root = new Node();
        }

        // Function to insert a
        // number into the trie
        void insert(int num) {
            // Start traversal
            // from the root node
            Node node = root;

            // Traverse each bit of the number
            // from the most significant bit
            // to the least significant bit
            for (int i = 31; i >= 0; i--) {
                // Extract the i-th
                // bit of the number
                int bit = (num >> i) & 1;

                // If the current node doesn't
                // have a child node at the
                // current bit, create one
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }

                // Move to the child node
                // corresponding to the current bit
                node = node.get(bit);
            }
        }

        // Function to find the maximum XOR
        // value achievable with a given number
        int findMax(int num) {
            // Start traversal from the root node
            Node node = root;

            // Initialize the maximum XOR value
            int maxNum = 0;

            // Traverse each bit of the number
            // from the most significant bit to
            // the least significant bit
            for (int i = 31; i >= 0; i--) {

                // Extract the i-th
                // bit of the number
                int bit = (num >> i) & 1;

                // If there exists a different bit
                // in the trie at the current position,
                // choose it to maximize XOR
                if (node.containsKey(1 - bit)) {

                    // Set the corresponding
                    // bit in the result
                    maxNum = maxNum | (1 << i);
                    // Move to the child node
                    // with the different bit
                    node = node.get(1 - bit);
                } else {

                    // Move to the child node
                    // with the same bit
                    node = node.get(bit);
                }
            }

            // Return the maximum XOR value
            return maxNum;
        }
    }

    public class Main {
        // Function to perform offline
        // maximum XOR queries
        static int[] maxXorQueries(int[] arr, int[][] queries) {

            // Initialize array to
            // store results of queries
            int[] ans = new int[queries.length];

            // Vector to store offline queries
            ArrayList<Pair<Integer, Pair<Integer, Integer>>> offlineQueries = new ArrayList<>();
            // Sort the array of numbers
            Arrays.sort(arr);

            int index = 0;

            // Convert queries to offline
            // queries and store them in a vector
            for (int[] it : queries) {
                offlineQueries.add(new Pair<>(it[1], new Pair<>(it[0], index++)));
            }

            // Sort offline queries
            // based on their end points
//            Collections.sort(offlineQueries);

            // Pointer to iterate through
            // the array of numbers
            int i = 0;

            // Number of elements in the array
            int n = arr.length;

            // Create an instance of
            // the Trie data structure
            Trie trie = new Trie();

            // Process each offline query
            for (Pair<Integer, Pair<Integer, Integer>> it : offlineQueries) {
                // Insert numbers into the trie
                // until the current query's end point
                while (i < n && arr[i] <= it.first) {
                    trie.insert(arr[i]);
                    i++;
                }

                // If there are numbers inserted
                // into the trie, find the maximum
                // XOR value for the query range
                if (i != 0)
                    ans[it.second.second] = trie.findMax(it.second.first);
                else
                    // If no numbers inserted,
                    // set result to -1
                    ans[it.second.second] = -1;
            }
            // Return the results
            // of all queries
            return ans;
        }

        public static void main(String[] args) {
            int[] arr = {3, 10, 5, 25, 2, 8};
            System.out.print("Given Array: ");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};

            System.out.print("Queries: ");
            for (int[] query : queries) {
                System.out.print(query[0] + " " + query[1] + ", ");
            }
            System.out.println();

            int[] result = maxXorQueries(arr, queries);

            System.out.println("Result of Max XOR Queries:");
            for (int i = 0; i < result.length; ++i) {
                System.out.println("Query " + (i + 1) + ": " + result[i]);
            }
        }
    }


}
