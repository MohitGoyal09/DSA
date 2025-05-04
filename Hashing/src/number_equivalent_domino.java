import java.util.*;
public class number_equivalent_domino {
    public int numEquivDominoPairs1(int[][] dominoes) {
        Map<String, Integer> map = new HashMap<>();

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            String key = a + "," + b;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int result = 0;
        for (int freq : map.values()) {
            result += freq * (freq - 1) / 2;
        }

        return result;
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int result = 0;

        for (int[] d : dominoes) {
            int a = d[0], b = d[1];
            if (a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            int num = a * 10 + b;
            result += count[num];
            count[num]++;
        }

        return result;
    }
}
