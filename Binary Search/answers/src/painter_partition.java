import java.util.*;

public class painter_partition {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>(Arrays.asList(10, 20, 30, 40));
        int k = 2;
        int ans = bs(boards, k);
        System.out.println("The answer is: " + ans);

    }
    static int findlargestMinDistance(ArrayList<Integer> boards , int k){
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();
        for ( int time = low ; time <= high ; time++){
            if (counttime(boards, time ) <= k)  return time;
        }
        return low;
    }
    static int counttime(ArrayList<Integer> boards , int time){
        int n = boards.size();
        int painters = 1;
        int countpaint = 0;
        for ( int i = 0 ; i < n ; i++){
            if (countpaint + boards.get(i) <= time) {
                countpaint += boards.get(i);
            } else {
                painters ++;
                countpaint = boards.get(i);
            }
        }
        return painters;
    }
    static int bs(ArrayList<Integer> boards , int k){
        int low = Collections.max(boards);
        int high = boards.stream().mapToInt(Integer::intValue).sum();
        while ( low <= high){
            int mid = (low + high)/2;
            if (counttime(boards, mid ) > k)  low = mid +1;
            else high = mid - 1;
        }
        return low;
    }

}
