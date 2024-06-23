import java.util.Stack;

public class postfix_to_infix {
    static String postToInfix(String exp) {
        // code here
        Stack<String> stack = new Stack<>();
        for (int i = 0 ; i < exp.length() ; i++){
            char c = exp.charAt(i);
            if (isOperand(c)){
                stack.push(c + "");
            }
            else {
                String op1 = stack.pop();
                String op2 = stack.pop();
                stack.push("(" + op2 + c + op1 + ")");
            }
        }
        return stack.peek();
    }
    static boolean isOperand(char x){
        return (x >= 'a' && x <= 'z') ||
                (x >= 'A' && x <= 'Z');
    }
}
