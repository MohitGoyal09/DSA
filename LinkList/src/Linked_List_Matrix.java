public class Linked_List_Matrix {
    static class Node
    {
        int data;
        Node right,down;

        Node(int data){
            this.data = data;
            right = null;
            down = null;
        }
    }

    /*Function should return the head of the 2D LL.*/
    static class Solution {
        Node construct(int[][] arr) {
            // Add your code here.
            int n = arr.length;
            Node upper=null, prev=null, start=null, head=null;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    Node temp = new Node(arr[i][j]);
                    if(head==null)head=temp;
                    if(upper==null)upper=start;
                    if(i!=0){
                        upper.down=temp;
                        upper=upper.right;
                    }
                    if(j==0)start=temp;
                    if(j!=0)prev.right=temp;
                    prev=temp;
                }
            }
            return head;
        }
    }
}
