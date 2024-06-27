import java.util.HashMap;
import java.util.Map;

public class long_substring_with_k_distinct {
    public static void main(String[] args) {

    }
    // ! Time complexity : O(N ^2 ) x O(256)
    static int buretter(String s  , int k ){
        int maxlen = 0;
        HashMap<Character , Integer> mp = new HashMap<>();
        for (int i = 0 ; i < s.length() ; i++){
             mp.clear();
            for (int j = i ; j < s.length() ; j++){
                mp.put(s.charAt(j) , mp.getOrDefault(s.charAt(j) , 0) + 1);
                if (mp.size() <= k ){
                    maxlen = Math.max(maxlen , j - i +1);
                } else {
                    break;
                }
            }
        }
        return maxlen;
    }
    public int longestkSubstr(String s, int k) {
        // code here
        Map<Character,Integer> map = new HashMap<>();
        int mx=-1;
        int i=0;
        int j=0;
        while(j<s.length()){
            char ch = s.charAt(j);
            map.put(ch,map.getOrDefault(ch,0)+1);
            if(map.size()==k){
                mx = Integer.max(mx,j-i+1);
            }
            if(map.size()>k){
                char ch1 = s.charAt(i);
                if(map.containsKey(ch1)){
                    map.put(ch1,map.get(ch1)-1);
                    if(map.get(ch1)==0){
                        map.remove(ch1);
                    }
                }
                i++;
            }
            j++;
        }
        return mx;
    }
}
