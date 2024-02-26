import java.util.*;
// ! https://youtu.be/vB6qmqd85aQ?si=M-udotLivefC8dUG
public class sort_by_freq {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        System.out.println(buketsort(s));
    }
    // ! TIME COMPLEXITY : O(N log N)
    // ! SPACE COMPLEXITY : O(N)
    static  String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        // ! Storing the frequency of each character
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch) + 1);
            }
            else{
                map.put(ch, 1);
            }
        }
        List<Character> chars = new ArrayList<>(map.keySet());
        // ! Lamda fuction to sort the characters according to their frequency
        Collections.sort(chars, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        // ! Intreating ArrayList & appending the characters
        for (Character ch : chars) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    // ! BUCKET  SORT
    // ! TIME & SPACE COMPLEXITY : O(N)
    static String buketsort(String s){
        if (s == null || s.isEmpty()) return s;
        Map<Character , Integer> map = new HashMap<Character, Integer>();
        int maxfreq = Integer.MIN_VALUE;
        for ( char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
            maxfreq = Math.max(maxfreq, map.get(c));
        }
        List<List<Character>> bucket = new ArrayList<>();
        for (int i = 0; i <= maxfreq; i++) {
            bucket.add(new ArrayList<>());
        }
        for (char c : map.keySet()) {
            int freq = map.get(c);
            bucket.get(freq).add(c);
        }
        StringBuilder ans = new StringBuilder();
        for (int i = bucket.size() - 1 ; i > 0 ; i--){
          for (char c : bucket.get(i)){
              for (int j = 0 ; j  < i ; j++ ){
                  ans.append(c);
              }
          }
        }
        return ans.toString();
    }
}


