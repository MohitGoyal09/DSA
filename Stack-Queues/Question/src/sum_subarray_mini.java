import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class sum_subarray_mini {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;
        int[] left = new int[length];
        int[] right = new int[length];

        Arrays.fill(left, -1);
        Arrays.fill(right, length);

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; ++i) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                left[i] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();

        for (int i = length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                right[i] = stack.peek();
            }
            stack.push(i);
        }

        int mod = (int) 1e9 + 7;
        long answer = 0;

        for (int i = 0; i < length; ++i) {
            answer += (long) (i - left[i]) * (right[i] - i) % mod * arr[i] % mod;
            answer %= mod;
        }

        return (int) answer;
    }
}
class Pair{
    int element;
    int minicount;
    Pair(int ele , int c){
        element = ele;
        minicount = c;
    }
}

class Solution8 {
    public int m = (int)Math.pow(10, 9)+7;
    public int sumSubarrayMins(int[] arr) {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        ArrayDeque<Pair> st1 = new ArrayDeque<>();
        ArrayDeque<Pair> st2 = new ArrayDeque<>();

        for (int i = 0 ; i < arr.length ; i++){
            int curr_element = arr[i];
            int count = 1;
            while (!st1.isEmpty() && st1.peek().element > curr_element){
                count += st1.peek().minicount;
                st1.pop();
            }
            st1.push(new Pair(curr_element , count));
            left[i] = count;
        }
        for (int i = arr.length - 1 ; i >= 0; i--){
            int curr_element = arr[i];
            int count = 1;
            while (!st2.isEmpty() && st2.peek().element >= curr_element){
                count += st2.peek().minicount;
                st2.pop();
            }
            st2.push(new Pair(curr_element , count));
            right[i] = count;
        }
        int ans = 0 ;
        for (int i = 0 ; i < arr.length ; i++){
            ans = (ans +(left[i] * right[i]*arr[i]))%m;
        }
        return ans;
    }
}

class Solution10 {
    public int sumSubarrayMins(int[] arr) {
        int[] nextSm = nextSmaller(arr);
        int[] prevSm = prevSmaller(arr);
        int mod = 1000000007;
        long count = 0;
        for (int i = 0; i < arr.length; i++) {
            int first = i - prevSm[i];
            int second = nextSm[i] - i;
            long prod = ((long) first * second) % mod;
            prod = (prod * arr[i]) % mod;
            count = (count + prod) % mod;
        }
        return (int)count;
    }

    private int[] nextSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.push(i);
        }
        return ans;
    }
    private int[] prevSmaller(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }
}