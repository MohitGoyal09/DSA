import java.util.HashMap;
import java.util.Stack;

// ! https://leetcode.com/problems/next-greater-element-i/solutions/5164552/must-read-intuitive-pattern-for-deep-understanding-of-nge-and-nsm
public class next_greater_element {
    public static void main(String[] args) {
        int[] arr ={5,7,1,2,6,0};

        int[] arr2 = nextGreaterElements(arr);
        System.out.println("The next greater elements are ");
        for (int j : arr2) {
            System.out.print(j + " ");
        }
    }

    private static int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1 ; i >= 0 ; i--){
            while (!st.isEmpty() && st.peek() <= arr[i%n]){
                st.pop();
            }
            if ( i < n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(arr[i%n]);
        }
        return nge;
    }
}

class Solution {
    public int[] nextGreaterElement(int[] n1, int[] n2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=n2.length-1;i>=0;i--){
            int num=n2[i];
            while(!s1.isEmpty() && s1.peek()<=num){
                s1.pop();
            }
            if(s1.isEmpty()) map.put(num,-1);
            else map.put(num,s1.peek());

            s1.push(num);
        }

        for (int i = 0; i < n1.length; i++) {
            n1[i] = map.getOrDefault(n1[i], -1);
        }
        return n1;
    }
    public int[] nextsmallestElement(int[] n1, int[] n2) {
        Stack<Integer> s1=new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i< n2.length;i++){
            int num=n2[i];
            while(!s1.isEmpty() && s1.peek()<=num){
                s1.pop();
            }
            if(s1.isEmpty()) map.put(num,-1);
            else map.put(num,s1.peek());

            s1.push(num);
        }

        for (int i = 0; i < n1.length; i++) {
            n1[i] = map.getOrDefault(n1[i], -1);
        }
        return n1;
    }
}


