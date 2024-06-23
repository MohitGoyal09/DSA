import java.util.Stack;

public class pre_2_post {


    static String preToPost(String pre_exp) {
        // code here
        Stack<String> st = new Stack<>();
        int l = pre_exp.length();
        for (int i = l - 1; i >= 0; i--) {
            char c = pre_exp.charAt(i);
            if (isOperator(c)) {
                String str1 = st.pop();
                String str2 = st.pop();
                String temp = str1 + str2 + c;
                st.push(temp);
            } else {
                st.push(c + "");
            }
        }
        return st.peek();
    }

    static boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }
}