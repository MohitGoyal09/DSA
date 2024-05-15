import java.util.ArrayList;
import java.util.List;

public class SubSeq {
    public static void main(String[] args) {
        subSeq("","abc");
    }
    // ! Recursive method
    static void subSeq(String p , String up){

        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subSeq(p+ch,up.substring(1));
        subSeq(p,up.substring(1));
    }

    // ! Iteration method
    static List<List<Integer>> subSeqIter(int[] arr){
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : arr){
            int n = outer.size();
            for (int i = 0 ; i < n ;i++){
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }

}
