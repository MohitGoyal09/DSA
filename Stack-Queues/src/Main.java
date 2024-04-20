import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Stackexception {
    Stack<Integer> st = new Stack();
     st.push(5);
     st.push(6);
     st.peek();
     st.pop();

     // custom stack
  customstack stk = new customstack(4);
        stk.push(5);
        stk.push(6);
        System.out.println(stk.pop());
        System.out.println(stk.peek());
    }
}

