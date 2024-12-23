import java.util.*;
public class min_number_operation_sort_binary_tree_by_level {
    // ! Approach :
    /* 1. Level Order Traversal (BFS):
       Use a queue to traverse the binary tree level by level.
       For each level, collect node values and their indices.
       2. Sort with Index Mapping:
       Pair each value with its original index.
       Sort the values, preserving their original indices.
       3. Count Minimum Swaps:
       Determine the number of swaps needed to rearrange the values to match their sorted order.
       This involves cycling through misplaced elements and swapping them to their correct positions.
       4. Repeat for All Levels:
       Process all levels independently to calculate the total number of swaps.
 */
    //  ! 1. Time complexity: O(nlogn)
    //  * Traversal of n nodes is O(n).
    // * Sorting each level's values dominates and contributes O(klogk) for k nodes in a level.
    // * Summing across levels gives O(nlogn).
    // ! 2. Space complexity: O(n)
    // * Space for the queue and level-wise node values.

    private void swap(int[] arr , int i , int j ){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private int indexof(int[] arr , int ele){
        for (int i = 0 ; i < arr.length ; i++){
            if (arr[i] == ele) return i;
        }
        return -1;
    }
    private int miniSwaps(int[] arr , int N){
        int ans = 0;
        int[] temp = Arrays.copyOfRange(arr , 0 , N);
        Arrays.sort(temp);
        for (int i  = 0 ; i < N ; i++){
            if (arr[i] != temp[i]){
                ans++;
                swap(arr , i , indexof(arr , temp[i]));
            }
        }
        return ans;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int count = 0;
        while (!q.isEmpty()){
            TreeNode curr = q.peek();
            int size = q.size();
            for (int i  = 0 ; i < size ; i++){
                curr = q.remove();
                if (curr.left != null) q.add(curr.left);
                if (curr.right != null) q.add(curr.right);
            }
            int[] arr = new int[q.size()];
            int k = 0;
            for (TreeNode num :q) arr[k++] = num.val;
            count += miniSwaps(arr,k);
        }
        return count;
    }
}
