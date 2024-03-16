import java.util.ArrayList;
import java.util.Arrays;

class Node1 {
    public int data;
    public Node1 next;
    public Node1 child;

    Node1()
    {
        this.data = 0;
        this.next = null;
        this.child = null;
    }
    Node1(int data)
    {
        this.data = data;
        this.next = null;
        this.child = null;
    }
    Node1(int data, Node1 next, Node1 child)
    {
        this.data = data;
        this.next = next;
        this.child = child;
    }
}
public class flatten_ll {
    public static void main(String[] args) {

    }
    // ! Time Complexity : O( m x n) x 2 + xlogx
    // ! Space Complexity : O( n x m) x 2
    public static Node1 flatten1(Node1 head) {
        ArrayList<Integer> children = new ArrayList<>();
        Node1 temp = head;
        while (temp != null){
            Node1 temp2 = temp;
            while (temp2 != null){
                children.add(temp2.data);
                temp2 = temp2.child;
            }
            temp = temp.next;
        }
        Arrays.sort(children.toArray());
        head = convert(children);
        return head;
    }

    static Node1 convert(ArrayList<Integer> arr){
        if (arr.size() == 0) return null;
        Node1 head = new Node1(arr.get(0));
        Node1 temp = head;
        for (int i = 1 ; i < arr.size() ; i++){
           Node1 newnode = new Node1(arr.get(i));
           temp.child = newnode;
           temp = temp.child;
        }
        return head;
    }


}
//class GfG
//{
//    Node mergeTwoLists(Node a, Node b){
//        Node temp = new Node(0);
//        Node res = temp;
//        while( a != null && b!= null){
//            if(a.data < b.data){
//                temp.child = a;
//                temp = temp.child;
//                a= a.child;
//            }
//
//            else{
//                temp.child = b;
//                temp = temp.child;
//                b = b.child;
//            }
//        }
//        if(a !=null) temp.child = a;
//        else temp.child = b;
//        return res.child;
//    }
//
//
//    Node flatten(Node root)
//    {
//        if(root == null || root.next == null)
//            return root;
//        root.next = flatten(root.next);
//        root =mergeTwoLists(root,root.next);
//        return root;
//
//
//
//    }
//}
