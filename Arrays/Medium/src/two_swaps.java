import java.util.*;
public class two_swaps {
    public boolean twoswaps(List<Integer> arr){
        int n = arr.size();
        int c = 0;
        for ( int i = 0 ; i < n  ; i++){
            while (arr.get(i) != i+1){
                int num = arr.get(i) - 1;
                int temp = arr.get(num);
                arr.set(num , arr.get(i));
                arr.set(i , temp);
                c++;
                if ( c > 2) return false;
            }
        }
        return c == 0 || c == 2;
    }
}
