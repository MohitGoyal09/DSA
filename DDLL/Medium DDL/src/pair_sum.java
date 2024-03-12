import java.util.ArrayList;
import java.util.List;

public class pair_sum {
    public static void main(String[] args) {

    }
    static List<List<Integer>> brutte(Node head , int sum){
        Node temp1 = head;
        List<List<Integer>> list = new ArrayList<>();
        while (temp1 != null){
            Node temp2 = temp1.next;
            while (temp2 != null && temp1.data + temp2.data <= sum){
                if (temp1.data + temp2.data == sum){
                    List<Integer> l = new ArrayList<>();
                    l.add(temp1.data);
                    l.add(temp2.data);
                    list.add(l);
                }
                temp2 = temp2.next;
            }
            temp1 = temp1.next;
        }
        return list;
    }

    static List<List<Integer>> optimal(Node head, int sum){
        List<List<Integer>> ans = new ArrayList<>();
        if (head == null) return ans;
        Node left = head;
        Node right = findtail(head);
        while (left.data < right.data){
            if (left.data + right.data == sum){
                List<Integer> l = new ArrayList<>();
                l.add(left.data);
                l.add(right.data);
                ans.add(l);
                left = left.next;
                right = right.next;
            }
            else if (left.data + right.data < sum){
                left = left.next;
            }
            else{
                right = right.next;
            }
       }
        return ans;
    }

    static Node findtail(Node head){
        Node temp = head;
        while (temp != null) temp = temp.next;
        return temp;
    }
}
