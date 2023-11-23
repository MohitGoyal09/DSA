import java.util.*;

public class Collectionfamework {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(3);
        list.add(5);
        list.add(10);
        list.add(1,12);
        System.out.println(list);

        Stack stk = new Stack();
        stk.push(1);
        stk.add(2);
        System.out.println(stk.peek());
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offer(5);  // ADD IN LAST
        dq.offerLast(4); //ADD IN LAST
        Queue<Integer> q = new LinkedList<>();
      // PRIORITY QUEUE BY DEFAULT MIN HEAP
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(5);
        pq.offer(4);
        pq.offer(3);
        pq.offer(10);
        System.out.println(pq);

        // PRIORITY QUEUE FOR  MAX HEAP
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(5);
        maxHeap.offer(4);
        maxHeap.offer(3);
        maxHeap.offer(10);
        System.out.println(maxHeap);
    }

}

// TREE MAP = SORTED KEYS
// HASH MAP = UNORDERED

//QUEUE = FIRST IN FIRST OUT
//STACK = LAST IN FIRST OUT
// PRIORITY QUEUE = ORDERED
// DEQUE = FIRST IN LAST OUT


// LIST OF PRIORITY QUEUE FUNCTIONS

