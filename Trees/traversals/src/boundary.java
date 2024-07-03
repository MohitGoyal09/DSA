import java.util.*;
public class boundary {
    public static void main(String[] args) {

    }
    class Solution{

        public static boolean isLeaf(Node root){
            return (root.left == null && root.right == null);
        }

        public static void addLeftNode(Node node, ArrayList<Integer> al){
            Node temp = node;
            while(temp!=null){
                if(!isLeaf(temp))
                    al.add(temp.data);
                if(temp.left!=null)
                    temp = temp.left;
                else
                    temp = temp.right;
            }
        }

        public static void addRootNode(Node root, ArrayList<Integer> al){
            if(isLeaf(root)){
                al.add(root.data);
                return;
            }
            //Simple Inorder Traversal
            if(root.left!=null)
                addRootNode(root.left, al);
            if(root.right!=null)
                addRootNode(root.right, al);
        }

        public static void addRightNode(Node node, ArrayList<Integer> al){
            Node temp = node;
            ArrayList<Integer> res = new ArrayList<Integer>();
            while(temp!=null){
                if(!isLeaf(temp))
                    res.add(temp.data);
                if(temp.right!=null)
                    temp = temp.right;
                else
                    temp = temp.left;
            }
            for(int i=res.size()-1;i>=0;i--)
                al.add(res.get(i));
        }

        ArrayList <Integer> boundary(Node node){
            ArrayList<Integer> al = new ArrayList<Integer>();
            if(!isLeaf(node))
                al.add(node.data);
            if(node.left!=null)
                addLeftNode(node.left, al);
            addRootNode(node, al);
            if(node.right!=null)
                addRightNode(node.right, al);
            return al;
        }
    }
}
