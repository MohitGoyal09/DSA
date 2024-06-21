import java.util.*;
public class sum_subarray_ranges {
    public static void main(String[] args) {

    }
    public long sumranges(int[] nums){
        Stack<Pair2> st = new Stack<>();
        long[] lesserleft = new long[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            long count = 1;
            while (!st.isEmpty() && st.peek().val <= nums[i]){
                count += st.pop().displace;
            }
            st.push(new Pair2(nums[i] , count));
            lesserleft[i] = count;
        }
        while(!st.isEmpty()) st.pop();
        long[] lesserright = new long[nums.length];
        for (int i = nums.length - 1 ; i >= 0 ; i--){
            long count = 1;
            while (!st.isEmpty() && st.peek().val < nums[i]){
                count += st.pop().displace;
            }
            st.push(new Pair2(nums[i] , count));
            lesserright[i] = count;
        }
        while(!st.isEmpty()) st.pop();
        long[] greaterleft = new long[nums.length];
        for (int i = 0 ; i < nums.length ; i++){
            long count = 1;
            while (!st.isEmpty() && st.peek().val >= nums[i]){
                count += st.pop().displace;
            }
            st.push(new Pair2(nums[i] , count));
            greaterleft[i] = count;
        }
        while(!st.isEmpty()) st.pop();
        long[] greaterright = new long[nums.length];
        for (int i = nums.length - 1;  i >= 0 ; i--){
            long count = 1;
            while (!st.isEmpty() && st.peek().val > nums[i]){
                count += st.pop().displace;
            }
            st.push(new Pair2(nums[i] , count));
            greaterright[i] = count;
        }

        long sum = 0;
        for (int i = 0 ; i < nums.length ; i++){
            sum += (nums[i] * ((lesserleft[i] * lesserright[i]) - (greaterleft[i] * greaterright[i])));
        }
        return sum;
    }
}
class Pair2 {
    long val , displace;
    Pair2(long val , long displace){
        this.val = val;
        this.displace = displace;
    }
}
//Sure, let's go through a dry run of the `subArrayRanges` method with an example input to understand how it works. We'll use the input array `nums = [1, 3, 2]`.
//
//        ### Step-by-Step Dry Run
//
//1. **Initialization**:
//        - `nums = [1, 3, 2]`
//        - `lesserLeft`, `lesserRight`, `greaterLeft`, `greaterRight` are arrays initialized to store counts of elements lesser/greater than the current element from the left and right respectively.
//   - `stack` is used to keep track of elements and their displacements.
//
//        2. **Calculate `lesserLeft`**:
//        - Iterate from left to right.
//   - For each element, count how many elements to the left are lesser than or equal to the current element.
//
//        - **Iteration 1 (i = 0)**:
//        - `nums[0] = 1`
//        - `stack` is empty, so `count = 1`
//        - Push `Node(1, 1)` to `stack`
//        - `lesserLeft[0] = 1`
//
//        - **Iteration 2 (i = 1)**:
//        - `nums[1] = 3`
//        - `stack` contains `Node(1, 1)`, which is less than `3`, so `count = 1 + 1 = 2`
//        - Push `Node(3, 2)` to `stack`
//        - `lesserLeft[1] = 2`
//
//        - **Iteration 3 (i = 2)**:
//        - `nums[2] = 2`
//        - `stack` contains `Node(3, 2)`, which is greater than `2`, so `count = 1`
//        - Push `Node(2, 1)` to `stack`
//        - `lesserLeft[2] = 1`
//
//        - Result: `lesserLeft = [1, 2, 1]`
//
//        3. **Calculate `lesserRight`**:
//        - Iterate from right to left.
//   - For each element, count how many elements to the right are less than the current element.
//
//   - **Iteration 1 (i = 2)**:
//        - `nums[2] = 2`
//        - `stack` is empty, so `count = 1`
//        - Push `Node(2, 1)` to `stack`
//        - `lesserRight[2] = 1`
//
//        - **Iteration 2 (i = 1)**:
//        - `nums[1] = 3`
//        - `stack` contains `Node(2, 1)`, which is less than `3`, so `count = 1 + 1 = 2`
//        - Push `Node(3, 2)` to `stack`
//        - `lesserRight[1] = 2`
//
//        - **Iteration 3 (i = 0)**:
//        - `nums[0] = 1`
//        - `stack` contains `Node(3, 2)`, which is greater than `1`, so `count = 1`
//        - Push `Node(1, 1)` to `stack`
//        - `lesserRight[0] = 3`
//
//        - Result: `lesserRight = [3, 2, 1]`
//
//        4. **Calculate `greaterLeft`**:
//        - Iterate from left to right.
//   - For each element, count how many elements to the left are greater than or equal to the current element.
//
//        - **Iteration 1 (i = 0)**:
//        - `nums[0] = 1`
//        - `stack` is empty, so `count = 1`
//        - Push `Node(1, 1)` to `stack`
//        - `greaterLeft[0] = 1`
//
//        - **Iteration 2 (i = 1)**:
//        - `nums[1] = 3`
//        - `stack` contains `Node(1, 1)`, which is less than `3`, so `count = 1`
//        - Push `Node(3, 1)` to `stack`
//        - `greaterLeft[1] = 1`
//
//        - **Iteration 3 (i = 2)**:
//        - `nums[2] = 2`
//        - `stack` contains `Node(3, 1)`, which is greater than `2`, so `count = 1 + 1 = 2`
//        - Push `Node(2, 2)` to `stack`
//        - `greaterLeft[2] = 2`
//
//        - Result: `greaterLeft = [1, 1, 2]`
//
//        5. **Calculate `greaterRight`**:
//        - Iterate from right to left.
//   - For each element, count how many elements to the right are greater than the current element.
//
//   - **Iteration 1 (i = 2)**:
//        - `nums[2] = 2`
//        - `stack` is empty, so `count = 1`
//        - Push `Node(2, 1)` to `stack`
//        - `greaterRight[2] = 1`
//
//        - **Iteration 2 (i = 1)**:
//        - `nums[1] = 3`
//        - `stack` contains `Node(2, 1)`, which is less than `3`, so `count = 1`
//        - Push `Node(3, 1)` to `stack`
//        - `greaterRight[1] = 1`
//
//        - **Iteration 3 (i = 0)**:
//        - `nums[0] = 1`
//        - `stack` contains `Node(3, 1)`, which is greater than `1`, so `count = 1 + 1 = 2`
//        - Push `Node(1, 2)` to `stack`
//        - `greaterRight[0] = 3`
//
//        - Result: `greaterRight = [3, 1, 1]`
//
//        6. **Calculate the final answer**:
//        - For each element, calculate the contribution to the sum of subarray ranges
//        by subtracting the count of minimum occurrences from the count of maximum occurrences.
//
//        - **Iteration 1 (i = 0)**:
//        - `nums[0] = 1`
//        - Contribution: `((1 * 3) - (1 * 3)) * 1 = 0`
//
//        - **Iteration 2 (i = 1)**:
//        - `nums[1] = 3`
//        - Contribution: `((2 * 2) - (1 * 1)) * 3 = (4 - 1) * 3 = 9`
//
//        - **Iteration 3 (i = 2)**:
//        - `nums[2] = 2`
//        - Contribution: `((1 * 1) - (2 * 1)) * 2 = (1 - 2) * 2 = -2`
//
//        - Sum of contributions: `0 + 9 - 2 = 7`
//
//        ### Final Result
//The final result is `7`, which is the sum of the ranges of all subarrays in the input array `[1, 3, 2]`.