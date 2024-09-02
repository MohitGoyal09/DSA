import java.util.*;
public class reverse_A_STACK {
    static void reverse(Stack<Integer> s)
    {
        if(!s.isEmpty()) {
            int x = s.peek();
            s.pop();
            reverse(s);
            pushToStack(s,x);
        }
    }

    static void pushToStack(Stack<Integer> s, int x) {
        if(s.isEmpty()) {
            s.push(x);
            return;
        }
        int top = s.peek();
        s.pop();
        pushToStack(s,x);
        s.push(top);
    }
}
