import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

public class top_bottom_view {
    public static void main(String[] args) {

    }
    static ArrayList<Integer> topView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        // if root is null reruen result;
        if(root == null) return result;

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();

        que.add(new Pair(root, 0));
        while(!que.isEmpty()){
            Pair top = que.poll();
            Node curr = top.node;
            int hm = top.data;
            if(!map.containsKey(hm)) map.put(hm,curr.data);
            if(curr.left != null) que.add(new Pair(curr.left, hm - 1));
            if(curr.right != null) que.add(new Pair(curr.right, hm + 1));
        }
        result.addAll(map.values());
        return result;
    }
    // ! Bottom View
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here

        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer , Integer> map = new TreeMap<>();
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(root,0));
        if (root == null) return result;
        while(!que.isEmpty()){
            Pair top = que.poll();
            Node curr = top.node;
            int hm = top.data;
            map.put(hm,curr.data);
            if(curr.left != null) que.add(new Pair(curr.left, hm - 1));
            if(curr.right != null) que.add(new Pair(curr.right, hm + 1));
        }
        result.addAll(map.values());
        return result;
    }
}

 class Pair{
    Node node;
    int data;
    Pair(Node node, int data){
        this.node = node;
        this.data = data;

    }
}