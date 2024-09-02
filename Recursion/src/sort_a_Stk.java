import java.util.*;
//The sort method takes a Stack<Integer> as input and returns a sorted Stack<Integer>.
//If the stack is empty or has only one element,
//it's already sorted, so we return it as is.If the stack has more than one element, we:
//Pop the top element and store it in top.Recursively call sort on the remaining stack.
//Call the order method to insert top back into the sorted stack.Finally, we return the sorted stack.
public class sort_a_Stk {
    public Stack<Integer> sort(Stack<Integer> s) {
        if(s.isEmpty() || s.size() == 1){
            return s;
        }
        int top = s.pop();
        sort(s);
        order(s,top);
        return s;
    }
    public static void order(Stack<Integer> stk, int element){
        if(stk.isEmpty() || stk.peek() <= element){
            stk.push(element);
            return;
        }
        int top = stk.pop();
        order(stk,element);
        stk.push(top);
    }
}
