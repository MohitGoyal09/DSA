import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
    // ! Flip Bits
    public static int flipBits(int start , int goal){
        int ans = start ^ goal;
        int cnt = 0;
        for (int i = 0 ; i < 32 ; i++){
            if ( (ans & (1 << i) ) != 0) cnt++;
        }
        return cnt;
    }
    // ! Power of 2 
    public List<List<Integer>> subsets(int[] nums) {
            int n = nums.length;
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 0; i < Math.pow(2, n); i++) {
                List<Integer> temp = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        temp.add(nums[j]);
                    }
                }

                res.add(temp);
            }
            return res;
        }

    // ! XOR from L TO R
    public static int findXOR(int l, int r) {
        return xor(l - 1) ^ xor(r);
    }

    public static int xor(int n){
        if ( n % 4 == 1) return 1;
        else if ( n % 4 == 2) return n + 1;
        else if ( n % 4 == 3) return 0;
        else return n;
    }

    // ! Swap Two Numbers
    static List<Integer> swap(int a,int b){
        // code here
        a=a^b;
        b=a^b;
        a=a^b;
        List<Integer> resultList = new ArrayList<>();
        resultList.add(a);
        resultList.add(b);
        return resultList;
    }

}
