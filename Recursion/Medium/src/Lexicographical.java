import java.util.*;
public class Lexicographical {

    public List<Integer> lexico(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1 ; i <= 9 ; i++){
            solve(i , n , list);
        }
        return list;
    }

    public void solve(int i , int n , List<Integer> list){
        if ( i> n) return ;
        for ( int num =  0 ; num <= 9 ; num++){
            int nextnum = i * 10 + num;
            list.add(nextnum);
            if ( nextnum > n) return ;
            solve(nextnum , n , list);
        }
    }
}
