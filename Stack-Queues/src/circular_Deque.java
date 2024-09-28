import java.util.*;
public class circular_Deque {
    private int[] deq;         // Array to store deque elements
    private int K;             // Maximum capacity of the deque
    private int front;         // Pointer to the front of the deque
    private int rear;          // Pointer to the rear of the deque
    private int currentCount;  // Current number of elements in the deque

    // Constructor to initialize the deque with the given capacity
    public circular_Deque(int k) {
        K = k;
        deq = new int[K];      // Initialize array with capacity K
        front = 0;
        rear = K - 1;
        currentCount = 0;
    }

    // Insert element at the front of the deque
    public boolean insertFront(int value) {
        if (isFull()) {
            return false;
        }
        front = (front - 1 + K) % K;
        deq[front] = value;
        currentCount++;
        return true;
    }

    // Insert element at the rear of the deque
    public boolean insertLast(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % K;
        deq[rear] = value;
        currentCount++;
        return true;
    }

    // Delete element from the front of the deque
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % K;
        currentCount--;
        return true;
    }

    // Delete element from the rear of the deque
    public boolean deleteLast() {
        if (isEmpty()) {
            return false;
        }
        rear = (rear - 1 + K) % K;
        currentCount--;
        return true;
    }

    // Get the front element of the deque
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return deq[front];
    }

    // Get the rear element of the deque
    public int getRear() {
        if (isEmpty()) {
            return -1;
        }
        return deq[rear];
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return currentCount == 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return currentCount == K;
    }
}
class MyCircularDeque {
    private LinkedList<Integer> deq;  // Using LinkedList to store deque elements
    private int cnt;                  // Current number of elements in the deque
    private int k;                    // Maximum capacity of the deque

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.k = k;                   // Assign capacity
        this.deq = new LinkedList<>(); // Initialize the deque as an empty LinkedList
        this.cnt = 0;                  // Initialize count to 0
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (cnt == k) {
            return false;              // If the deque is full, insertion fails
        }
        deq.addFirst(value);           // Insert at the front of the deque
        cnt++;                         // Increment count
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (cnt == k) {
            return false;              // If the deque is full, insertion fails
        }
        deq.addLast(value);            // Insert at the rear of the deque
        cnt++;                         // Increment count
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (cnt == 0) {
            return false;              // If the deque is empty, deletion fails
        }
        deq.removeFirst();             // Remove the front element
        cnt--;                         // Decrement count
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (cnt == 0) {
            return false;              // If the deque is empty, deletion fails
        }
        deq.removeLast();              // Remove the last element
        cnt--;                         // Decrement count
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if (cnt == 0) {
            return -1;                 // If the deque is empty, return -1
        }
        return deq.getFirst();          // Return the front element
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if (cnt == 0) {
            return -1;                 // If the deque is empty, return -1
        }
        return deq.getLast();           // Return the last element
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return cnt == 0;               // Return true if the deque is empty
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return cnt == k;               // Return true if the deque is full
    }
}