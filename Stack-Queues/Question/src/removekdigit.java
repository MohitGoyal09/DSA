import java.util.*;

public class removekdigit {
    public static void main(String[] args) {

    }

    static String remove(String s , int k){
        Stack<Character> st = new Stack<>();
        for (char num : s.toCharArray()){
          while (!st.isEmpty() && k > 0 && st.peek() > num){
              st.pop();
              k--;
          }
          st.push(num);
        }
        while ( k > 0 && !st.isEmpty()){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        sb.reverse();
        while (!sb.isEmpty() && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return !sb.isEmpty() ? sb.toString() : "0";
    }
}
