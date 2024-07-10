import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class burn_the_tree {
    public static void main(String[] args) {

    }
    class Solution
    {
        /*class Node {
            int data;
            Node left;
            Node right;

            Node(int data) {
                this.data = data;
                left = null;
                right = null;
            }
        }*/
        public static int maxDist(HashMap<Node, Node>map, Node target){
            Queue<Node>q = new LinkedList<>();
            q.add(target);
            HashMap<Node, Integer>vis = new HashMap<>();
            vis.put(target, 1);
            int max = 0;
            while(!q.isEmpty()){
                int size = q.size();
                boolean flag = false;
                for(int i=0;i<size;i++){
                    Node node = q.poll();
                    if(node.left!=null && vis.get(node.left)==null){
                        vis.put(node.left, 1);
                        q.add(node.left);
                        flag = true;
                    }
                    if(node.right!=null && vis.get(node.right)==null){
                        vis.put(node.right, 1);
                        q.add(node.right);
                        flag = true;
                    }
                    if(map.get(node)!=null && vis.get(map.get(node))==null){
                        vis.put(map.get(node), 1);
                        q.add(map.get(node));
                        flag = true;
                    }
                }
                if(flag==true){
                    max++;
                }
            }
            return max;
        }
        public static Node bfsToMapParent(Node root, int target, HashMap<Node, Node> map){
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node res = null;
            while(!q.isEmpty()){
                Node node = q.poll();
                if(node.data==target){
                    res = node;
                }
                if(node.left!=null){
                    map.put(node.left, node);
                    q.add(node.left);
                }
                if(node.right!=null){
                    map.put(node.right, node);
                    q.add(node.right);
                }
            }
            return res;
        }
        public static int minTime(Node root, int target)
        {
            // Your code goes here
            HashMap<Node, Node>map = new HashMap<>();
            Node x = bfsToMapParent(root, target, map);
            int max = maxDist(map, x);
            return max;
        }
    }
}
