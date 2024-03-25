import java.util.Arrays;

public class single__number_2 {
    public static void main(String[] args) {

    }
    // ! TC : O(N x 32)
    // ! SC : O(1)
    static int singlenumber(int[] bits){
        int ans = 0;
        for (int i = 0 ; i < 32 ; i++){
            int cnt = 0;
            for (int j = 0 ; j < bits.length ; j++){
                if ((bits[j] & (1 << i)) != 0) cnt++;
            }
            if (cnt % 3 == 1) ans = ans | (1 << i);
        }
        return ans;
    }
    // ! Optimized
    // ! TC : O(Nlogn + N/3)
    // ! SC : O(1)
    static int optimize(int[] bits){
        Arrays.sort(bits);
        for (int i = 1 ; i < bits.length ; i += 3){
            if (bits[i] != bits[i-1]) return bits[i-1];
        }
        return bits[bits.length-1];
    }

    // * Single Number 3
    class Solution {
        public int[] singleNumber(int[] nums) {
            int xora = 0;
            for (int i = 0; i < nums.length; i++) {
                xora = xora ^ nums[i];
            }
            int rightmost = (xora & (xora - 1)) ^ xora;
            int b1 = 0, b2 = 0; // Correct initialization
            for (int i = 0; i < nums.length; i++) {
                if ((nums[i] & rightmost) != 0) b1 = b1 ^ nums[i]; // Corrected condition check
                else b2 = b2 ^ nums[i];
            }
            return new int[]{b1, b2}; // Correct array creation
        }
    }
}
