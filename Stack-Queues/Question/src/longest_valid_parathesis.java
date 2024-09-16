import java.util.*;
public class longest_valid_parathesis {
    static int maxLength(String str){
        // code here
        Stack<Integer> stack = new Stack<>();

        // Initialize the stack with -1 to handle edge cases
        stack.push(-1);

        // Initialize result
        int maxLength = 0;

        // Traverse the given string
        for (int i = 0; i < str.length(); i++) {
            // If it's an opening bracket, push index onto the stack
            if (str.charAt(i) == '(') {
                stack.push(i);
            }
            // If it's a closing bracket
            else {
                // Pop the top index
                stack.pop();

                // Check if the stack is empty
                if (!stack.isEmpty()) {
                    // Update maxLength
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // Push the current index onto the stack
                    stack.push(i);
                }
            }
        }

        return maxLength;
    }
}
