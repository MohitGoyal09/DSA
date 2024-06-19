import java.util.Stack;

public class prev_elements {
    public static void main(String[] args) {

    }
    //! previous smaller element
    // ! Element store in Increasing order from the bottom of the stack
    // ! previous Gearter Elmt
    // ! Element Store in Decreasing order from the bottom of the stack
    void prv(int[] a){
        Stack s1 = new Stack();
        for (int i = 0 ; i < a.length ; i++){
            while(!s1.isEmpty() && a[(int) s1.peek()] >= a[i]) s1.pop();
            if (s1.isEmpty()) System.out.println(-1);
            else System.out.println(a[(int) s1.peek()]);
            s1.push(i);
        }
    }
    void grv(int[] a){
        Stack s1 = new Stack();
        for (int i = 0 ; i < a.length ; i++){
            while(!s1.isEmpty() && a[(int) s1.peek()] <= a[i]) s1.pop();
            if (s1.isEmpty()) System.out.println(-1);
            else System.out.println(a[(int) s1.peek()]);
            s1.push(i);
        }
    }
}
