import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class fruit_basket {
    public static void main(String[] args) {

    }

    static int buret(int N , int[] fruits){
        int maxlen = 0;
        for (int i = 0 ; i < fruits.length ; i++){
            HashSet<Integer> set = new HashSet<>();
            for (int j = i ; j < fruits.length ; j++){
                set.add(fruits[j]);
                if (set.size() <= 2){
                    maxlen = Math.max(maxlen , j  - i + 1);
                } else break;
            }
        }
        return maxlen;
    }
    public static int better(int n, int[] f) {
        int l = 0;
        int r = 0;
        int maxsum = Integer.MIN_VALUE;
        Map<Integer, Integer> m = new HashMap<>();

        while (r < n) {
            m.put(f[r], m.getOrDefault(f[r], 0) + 1);
            if (m.size() > 2) {
                m.put(f[l], m.get(f[l]) - 1);
                if (m.get(f[l]) == 0) {
                    m.remove(f[l]);
                }
                l++;
            }
            if (m.size() <= 2) {
                maxsum = Math.max(maxsum, r - l + 1);
            }
            r++;
        }
        return maxsum;
    }


}
