import java.util.Stack;
// ! REMOVE EFFFICIENT STACK
class MyQueue {
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();
    public MyQueue() {

    }

    public void push(int x) {
        while (input.empty() == false){
            output.push(input.peek());
            input.pop();
        }
        input.push(x);
        while (output.empty() == false){
            input.push(output.peek());
            output.pop();
        }
    }

    public int pop() {
        if (input.empty()){
            System.out.println("Stack is empty");
        }
        int val = input.peek();
        input.pop();
        return val;
    }

    public int peek() {
        if (input.empty()) {
            System.out.println("Stack is empty");

        }
        return input.peek();
    }

    public boolean empty() {
        if (input.empty()) {
            return true;
        }
        return false;
    }
}