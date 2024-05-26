// ! Stack implementation using Queue
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Create a new stack instance
        stack s = new stack();

        // Push elements onto the stack
        s.push(3);
        s.push(2);
        s.push(4);
        s.push(1);

        // Display the top element of the stack
        System.out.println("Top of the stack: " + s.top());

        // Display the size of the stack before removing an element
        System.out.println("Size of the stack before removing element: " + s.size());

        // Remove the top element from the stack and display it
        System.out.println("The deleted element is: " + s.pop());

        // Display the new top element after the previous top was removed
        System.out.println("Top of the stack after removing element: " + s.top());

        // Display the size of the stack after removing an element
        System.out.println("Size of the stack after removing element: " + s.size());
    }
}

class stack {
    // Queue to store stack elements
    Queue<Integer> q = new LinkedList<Integer>();

    // Method to add an element to the stack
    void push(int x){
        q.add(x); // Add the new element to the queue
        // Rotate the queue to make the last added element to be at the front of the queue
        for (int i = 0 ; i < q.size() - 1 ; i++){
            q.add(q.remove());
        }
    }

    // Method to remove the top element from the stack
    int pop(){
        return q.remove(); // Remove the element from the front of the queue
    }

    // Method to get the top element of the stack
    int top(){
        return q.peek(); // Peek at the front of the queue without removing it
    }

    // Method to get the current size of the stack
    int size(){
        return q.size(); // Return the size of the queue
    }
    boolean empty(){
        return q.isEmpty();
    }
}
