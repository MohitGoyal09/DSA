import java.util.Arrays;
import java.util.HashMap;

public class isomorphic_strings {
    public static void main(String[] args) {

        String S1 = "egg";
        String S2 = "add";
        System.out.println(optimized(S1,S2));
    }
   // ! Time & Space Complexity : O(N)
    static boolean isomorphic(String S1 , String S2){
        if (S1.length() != S2.length()) return false;
        HashMap<Character,Character> map = new HashMap<>();
        HashMap<Character,Boolean> visited = new HashMap<>();
        int n = S1.length();
        for ( int i = 0 ; i < n ; i++){
            char c1 = S1.charAt(i);
            char c2 = S2.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) return false;
            } else {
                if (visited.containsKey(c2) == true) return false;
                else {
                    map.put(c1, c2);
                    visited.put(c2,true);
                }
            }
        }
        return true;
    }
    // ! Time Complexity : O(N)
    // ! Space Complexity : O(1)
    static boolean optimized(String S1, String S2){
        if (S1.length() != S2.length()) return false;
        int map1[] = new int[256];
        int map2[] = new int[256];
        Arrays.fill(map1,-1);
        Arrays.fill(map2,-1);
        for ( int i = 0 ; i < S1.length() ; i++){
            char c1 = S1.charAt(i);
            char c2 = S2.charAt(i);
            if ( map1[c1] == -1 && map2[c2] == -1){
                map1[c1] = c2;
                map2[c2] = c1;
            } else if (map1[c1] != c2 || map2[c2] != c1){
                return false;
            }
        }
        return true;
    }
}
