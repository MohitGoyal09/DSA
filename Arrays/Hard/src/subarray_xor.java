import java.util.HashMap;

public class subarray_xor {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int target = 6;
        System.out.println(better(a , target));
    }

    // ? Brute Force
    // ! Time Complexity: O(N^3)
    // ! Space Complexity : O(1)
    static int brtue(int[] a , int target){
        int n = a.length;
        int count = 0;
        for ( int i = 0 ; i < n ; i++){
            for ( int j = i ; j < n ; j++){
                int xorr = 0;
                for ( int k = i ; k <= j ; k++){
                    xorr = xorr ^ a[k];

                }
                if ( xorr == target) count++;
            }
        }
        return count;
    }

    // ? Better
    // ! Time Complexity : O(N^2)
    // ! Space Complexity : O(1)
    static int better(int[] a, int target){
        int n = a.length;
        int count = 0;
        for ( int i = 0 ; i < n ; i++){
            int xorr = 0;
            for ( int   j = i ; j < n ; j++){

                xorr = xorr ^ a[j];
                if ( xorr == target) count++;
            }
        }
        return count;
    }

    // ? Optimal
    // ! Time Complexity: O(N) or O(N*logN) depending on which map data structure we are using, where N = size of the array.
    // ! Space Complexity : O(N)
    static int optimal(int[] a , int target){
        int n = a.length;
        int xr = 0;
        int count = 0;
        HashMap<Integer , Integer> set = new HashMap<Integer , Integer>();
        set.put(xr,1);
        for ( int i = 0 ; i < n ; i++){
            // prefix XOR till index i:
            xr = xr ^ a[i];

            int x = xr ^ target;
            if (set.containsKey(x)){
                count+= set.get(x);
            }
            if ( set.containsKey(xr)){
                set.put(xr , set.get(xr) + 1);
            } else {
                set.put(xr, 1);
            }
        }
        return count;
    }
}

