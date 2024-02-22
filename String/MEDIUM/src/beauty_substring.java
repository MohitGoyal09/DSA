public class beauty_substring {
    public static void main(String[] args) {

    }
}
class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int totalBeauty = 0;

        for (int i = 0 ; i < n ; i++){
            int[] charFreq = new int[26];
            for (int j = i ; j < n ; j++){
                charFreq[s.charAt(j) - 'a']++;
                totalBeauty += calculate(charFreq);
            }
        }
        return totalBeauty;
    }
    static int calculate(int[] charFreq){
        int minFreq = Integer.MAX_VALUE;
        int maxFreq = 0;

        for (int freq : charFreq){
            if (freq > maxFreq) maxFreq = freq;
            if (freq > 0 && freq < minFreq) minFreq = freq;
        }
        return maxFreq - minFreq;
    }
}
