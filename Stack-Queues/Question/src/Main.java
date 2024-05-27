import java.util.Stack;


public class Main {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<Character>();
        for (char it : s.toCharArray()){
            if (it == '('  || it == '[' || it == '{') st.push(it);
            else {
                if (st.isEmpty()) return false;
                char c = st.pop();
                if ((it == ')' && c == '(') || (it == ']' && c == '[') || (it == '}' && c == '{')) continue;
                else return false;

            }
        }
        return st.isEmpty();
    }
}