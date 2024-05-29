import java.util.*;
public class mini_stack {
    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(val);
        obj.pop();
        int param_3 = obj.top();
        int param_4 = obj.getMin();
    }
}
class MinStack{
    Stack<Long> st = new Stack<Long>();
    Long mini;
    public MinStack() {
         mini = Long.MAX_VALUE;
    }

    public void push(int val) {
          Long value = Long.valueOf(val);
          if (st.isEmpty()){
              st.push(value);
              mini = value;
          } else {
              if (value < mini){
                  st.push(2 * value - mini);
                  mini = value;
              } else {
                  st.push(value);
              }
          }
    }

    public void pop() {
        if (st.isEmpty()) return;
        Long val = st.pop();
        if (val < mini){
            mini = 2 * mini - val;
        }
    }

    public int top() {
         Long val = st.peek();
         if (val < mini){
             return mini.intValue();
         } else {
             return val.intValue();
         }
    }

    public int getMin(){
        return mini.intValue();
    }
}
