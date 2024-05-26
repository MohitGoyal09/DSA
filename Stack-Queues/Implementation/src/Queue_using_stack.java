import java.util.Stack;

public class Queue_using_stack {
    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(3);
        q.push(4);
        System.out.println("The element poped is " + q.pop());
        q.push(5);
        System.out.println("The top element is " + q.peek());
        System.out.println("The size of the queue is " + q.size());
    }
}
class MyQueue {
   Stack<Integer> input = new Stack<Integer>();
   Stack<Integer> output = new Stack<Integer>();
   public MyQueue(){
   }
   public void push(int x){
       while (!input.empty()){
           output.push(input.peek());
           input.pop();
       }
       // Insert the desired element in the stack input
       System.out.println("The element pushed is " + x);
       input.push(x);
       // Pop out elements from the stack output and push them into the stack input
       while (!output.empty()){
           input.push(output.peek());
           output.pop();
       }
   }
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        int val = input.peek();
        input.pop();
        return val;

    }
    /** Get the front element. */
    public int peek() {
        // shift input to output
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        return input.peek();
    }
    int size() {
        return input.size();
    }
}
