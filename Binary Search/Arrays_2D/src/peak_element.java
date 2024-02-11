import java.util.ArrayList;
import java.util.Arrays;

public class peak_element {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(10,20,15)));
        matrix.add(new ArrayList<>(Arrays.asList(21,30,14)));
        matrix.add(new ArrayList<>(Arrays.asList(7,16,32)));
        System.out.println(Arrays.toString(bs(matrix)));
    }
    static int[] bs(ArrayList<ArrayList<Integer>> matrix){
        int n = matrix.size();
        int m = matrix.get(0).size();
        int low = 0 , high = m - 1;
        while ( low <= high){
            int mid = (low + high)/2;
            int maxindex = maxxel(matrix , n , m , mid);
            int left  = mid - 1 >=0 ? matrix.get(maxindex).get(mid - 1) : -1;
            int right  = mid + 1 < m ? matrix.get(maxindex).get(mid + 1) : -1;
            if (matrix.get(maxindex).get(mid) > left && matrix.get(maxindex).get(mid) > right)
                return new int[]{maxindex, mid } ;
            else if (matrix.get(maxindex).get(mid) < left) high = mid -1;
            else low = mid +1;

        }
        return new int[]{-1, -1};
    }

    static int maxxel(ArrayList<ArrayList<Integer>> matrix , int n , int m , int col){
        int max = Integer.MIN_VALUE;
        int index = -1;
        for ( int i = 0 ; i < n ; i++){
            if ( matrix.get(i).get(col) > max){
                max = matrix.get(i).get(col);
                index = i;
            }
        }
        return index;
    }
}
