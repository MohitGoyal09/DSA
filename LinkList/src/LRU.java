import java.util.HashMap;
import java.util.Map;

public class LRU {
}
class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    Node head = new Node(0, 0), tail = new Node(0, 0);
    Map< Integer, Node > map = new HashMap();
    int cap;
    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)){
            remove(map.get(key));
        }
        if (map.size() == cap) remove(tail.prev);
        insert(new Node(key,value));
    }
    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insert(Node node){
        map.put(node.key , node);
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
}