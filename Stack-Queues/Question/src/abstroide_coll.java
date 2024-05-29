import java.util.Stack;

public class abstroide_coll {
    public static void main(String[] args) {

    }
    public int[] asteroidCollision(int[] arr) {
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 || s.isEmpty()){
                ///+ve h toh right side me move krega toh
                //if koi -ve (left side move krne wala) bhi stack me h toh bhi vo kbhi collide
                // nhi krenge
                s.push(arr[i]);
            }
            else{//jab arr[i]=-ve h mtlb left me jaa rha h
                while (!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(arr[i])){
                    //toh agr peek pr +ve h pr chota h toh hmesha explode ho jayega
                    // toh pop
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() == Math.abs(arr[i])){
                    //if dono equal h toh explode
                    s.pop();
                }
                else{//if dono equal nhi h
                    //or peek pr bhi chota h mtlb dono -ve peek and curr astroid toh push
                    if (s.isEmpty() || s.peek() < 0){
                        s.push(arr[i]);
                    }
                }
            }
        }
        int[] res = new int[s.size()];
        for (int i = s.size() - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }

}

