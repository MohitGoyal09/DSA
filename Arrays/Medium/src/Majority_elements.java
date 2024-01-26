import java.util.HashMap;

public class Majority_elements {
    public static void main(String[] args) {

        int[] v = {2,2,1,1,1,2,2};
        System.out.println(optimal(v));
    }
    // ? Brute Force
    // ! Time complexity : O(n^2)
    // ! Space Complexity : O(1)
    static int burute(int[] v){
        int n = v.length;
        for(int i = 0; i < n ; i++){
            int count = 0;
            for ( int j = 0 ; j < n ; j++){
                if ( v[i] == v[j]){
                    count++;
                }
            }
            if ( count > n/2){
                return v[i];
            }
        }
        return -1;
    }

    // ? Better
    // ! Time Complexity : O(N*logN) + O(N)
    // ! Space Complexity : O(N)

    static int better(int[] v){
        int n = v.length;
        HashMap<Integer, Integer> ans = new HashMap<Integer, Integer>();
        for ( int i = 0; i < n ; i++){
            int value = ans.getOrDefault(v[i], 0);
            ans.put(v[i], value + 1);
        }
        for (HashMap.Entry<Integer , Integer> it : ans.entrySet()) {
            if ( it.getValue() > n/2){
                return it.getKey();
            }
        }
        return -1;
    }


    // !       Moore’s Voting Algorithm
    // ? Optimal
    // ! Time Complexity : O(n)
    // ! Space Complexity : O(1)

    static int optimal(int[] v){
        int n = v.length;
        int count = 0;
        int el = 0;
        for ( int i = 0 ; i < n ; i++){
            if (count == 0){
                el = v[i];
                count = 1;
            } else if (el == v[i]) count++;
            else count--;
        }
        // ! checking if the stored element
        // ! is the majority element:
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (v[i] == el) cnt1++;
        }
        if (cnt1 > n/2) return el;
        return -1;
    }

}
