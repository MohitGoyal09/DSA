import java.util.*;
public class Partition_Labels {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        List<Integer> result = new ArrayList<>();
        int[] lastindex = new int[26];
        for (int i = 0 ; i < n; i++){
            lastindex[s.charAt(i) - 'a'] = i;
        }
        int i = 0 ;
        int start = 0;
        int end = 0;
        while (i < n){
            end = Math.max(end , lastindex[s.charAt(i) - 'a']);
            if (i == end){
                result.add(end  - start + 1);
                start = end + 1;
            }
            i++;
        }
        return result;
    }
}
