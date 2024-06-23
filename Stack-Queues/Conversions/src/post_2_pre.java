import java.util.Stack;

public class post_2_pre {
}
// Java Program to convert postfix to prefix


class GFG6 {

    // function to check if character
    // is operator or not
    static boolean isOperator(char x)
    {

        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    // Convert postfix to Prefix expression
    static String postToPre(String post_exp)
    {
        Stack<String> s = new Stack<String>();

        // length of expression
        int length = post_exp.length();

        // reading from right to left
        for (int i = 0; i < length; i++) {

            // check if symbol is operator
            if (isOperator(post_exp.charAt(i))) {

                // pop two operands from stack
                String op1 = s.peek();
                s.pop();
                String op2 = s.peek();
                s.pop();

                // concat the operands and operator
                String temp
                        = post_exp.charAt(i) + op2 + op1;

                // Push String temp back to stack
                s.push(temp);
            }

            // if symbol is an operand
            else {

                // push the operand to the stack
                s.push(post_exp.charAt(i) + "");
            }
        }

        // concatenate all strings in stack and return the
        // answer
        String ans = "";
        for (String i : s)
            ans += i;
        return ans;
    }

    // Driver Code
    public static void main(String args[])
    {
        String post_exp = "ABC/-AK/L-*";

        // Function call
        System.out.println("Prefix : "
                + postToPre(post_exp));
    }
}

// This code is contributed by Arnab Kundu
