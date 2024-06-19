import java.util.Stack;
public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    // Function to determine the precedence of operators
    int precedence(char a) {
        if (a == '^') {
            return 3;
        } else if (a == '*' || a == '/') {
            return 2;
        } else if (a == '+' || a == '-') {
            return 1;
        }
        return 0;
    }

    // Function to convert an infix expression to a postfix expression
    public String infixToPostfix(String s) {
        StringBuilder str = new StringBuilder();
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || Character.isDigit(ch)) {
                str.append(ch);
            } else if (ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                while (!st.isEmpty() && st.peek() != '(') {
                    str.append(st.pop());
                }
                st.pop();
            } else {
                while (!st.isEmpty() && precedence(st.peek()) >= precedence(ch)) {
                    str.append(st.pop());
                }
                st.push(ch);
            }
        }

        while (!st.isEmpty()) {
            str.append(st.pop());
        }

        return str.toString();
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String infix = "a+b*(c^d-e)^(f+g*h)-i";
        String postfix = sol.infixToPostfix(infix);
        System.out.println("Postfix expression: " + postfix);
    }
}