// https://leetcode.com/problems/create-binary-tree-from-descriptions/description/?envType=daily-question&envId=2024-07-15
// * 1. Initialization:
// Create an array nodes of size 100001 to store references to TreeNode objects.
// This size is chosen to accommodate node values up to 100000.Create a boolean array children of
// size 100001 to keep track of which nodes are children.
// * 2. Building the Tree:
// Iterate through each description in the descriptions array.
// ! For each description:
// Check if the parent node exists in the nodes array. If not, create a new TreeNode for the parent.
// Check if the child node exists in the nodes array. If not, create a new TreeNode for the child.
// Depending on the third element of the description (0 or 1), set the child node as
// either the right or left child of the parent node.Mark the child node in the children array.
// * 3. Finding the Root:
// Iterate through the descriptions again to find the root node.The root node is identified as the node that is never
// marked as a child in the children array.
// * 4. Return:
// If no root node is found, return null.

public class leetcode_2196 {
    class Solution {
        public TreeNode createBinaryTree(final int[][] descriptions) {
            // Create an array to hold TreeNode references. The size is 100001 to accommodate node values up to 100000.
            final TreeNode[] nodes = new TreeNode[100001];
            // Create a boolean array to keep track of which nodes are children.
            final boolean[] children = new boolean[100001];

            // Iterate through each description in the descriptions array.
            for(final int[] description : descriptions) {
                // If the parent node does not exist, create it.
                if(nodes[description[0]] == null) nodes[description[0]] = new TreeNode(description[0]);

                // If the child node does not exist, create it.
                if(nodes[description[1]] == null) nodes[description[1]] = new TreeNode(description[1]);

                // If the third element in the description is 0, set the child as the right child.
                if(description[2] == 0) nodes[description[0]].right = nodes[description[1]];
                    // Otherwise, set the child as the left child.
                else nodes[description[0]].left = nodes[description[1]];

                // Mark the child node as a child.
                children[description[1]] = true;
            }

            // Iterate through the descriptions again to find the root node.
            for(final int[] description : descriptions) {
                // The root node is the one that is never marked as a child.
                if(!children[description[0]]) return nodes[description[0]];
            }

            // If no root node is found, return null.
            return null;
        }

    }
}
