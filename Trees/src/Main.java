
public class Main {
    public static void main(String[] args) {
        // Creates the root node
        // with a key value of 1
        Node root = new Node(1);
        // Creates a left child node for
        // the root with a key value of 2
        root.left = new Node(2);
        // Creates a right child node for
        // the root with a key value of 3
        root.right = new Node(3);
        // Creates a left child node for the right
        // child of the root with a key value of 5
        root.right.left = new Node(5);
        // Creates a right child node for the right
        // child of the root with a key value of 4
        root.right.right = new Node(4);
    }
}
class Node {
    int data;
    Node left;
    Node right;
    public Node(int key){
        data = key;
        left = null;
        right = null;
    }
}