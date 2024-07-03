
import java.util.*;



public class vertical_order {
    public static void main(String[] args) {

    }
    // Function to perform vertical order traversal
    // and return a 2D ArrayList of node values
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        // Map to store nodes based on
        // vertical and level information
        Map<Integer, Map<Integer, List<Integer>>> nodes = new TreeMap<>();

        // Queue for BFS traversal, each
        // element is a pair containing node
        // and its vertical and level information
        Queue<Pair<TreeNode, Pair<Integer, Integer>>> todo = new LinkedList<>();

        // Push the root node with initial vertical
        // and level values (0, 0)
        todo.add(new Pair<>(root, new Pair<>(0, 0)));
        // BFS traversal
        while (!todo.isEmpty()) {
            // Retrieve the node and its vertical
            // and level information from
            // the front of the queue
            Pair<TreeNode, Pair<Integer, Integer>> p = todo.poll();
            TreeNode temp = p.getKey();

            // Extract the vertical and level information
            // x -> vertical
            int x = p.getValue().getKey();
            // y -> level
            int y = p.getValue().getValue();

            // Insert the node value into the
            // corresponding vertical and level
            // in the map
            nodes.computeIfAbsent(x, k -> new TreeMap<>())
                    .computeIfAbsent(y, k -> new ArrayList<>())
                    .add(temp.val);

            // Process left child
            if (temp.left != null) {
                todo.add(new Pair<>(temp.left, new Pair<>(x - 1, y + 1)));
            }

            // Process right child
            if (temp.right != null) {
                todo.add(new Pair<>(temp.right, new Pair<>(x + 1, y + 1)));
            }
        }

        // Prepare the final result list
        // by combining values from the map
        List<List<Integer>> ans = new ArrayList<>();
        for (Map.Entry<Integer, Map<Integer, List<Integer>>> entry : nodes.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (List<Integer> list : entry.getValue().values()) {
                // Sort the list to ensure the correct order
                Collections.sort(list);
                // Insert node values
                // into the column list
                col.addAll(list);
            }
            // Add the column list
            // to the final result
            ans.add(col);
        }
        return ans;
    }

}
