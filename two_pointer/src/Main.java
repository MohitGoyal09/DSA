import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
    public int leftoflongeststring(String s){
        if(s.isEmpty()) return 0;
        int l  = 0 ;
        int Maxlen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        for (int r = 0 ; r < s.length() ; r++){
            while ( l < r && set.contains(s.charAt(r))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(l));
            Maxlen = Math.max(Maxlen , r - l +1);
        }
        return Maxlen;
    }
}