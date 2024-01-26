import java.util.ArrayList;

public class leaders_in_array {
    public static void main(String[] args) {
        // Array Initialization.
        int n = 6;
        int arr[]=  {10, 22, 12, 3, 0, 6};


        ArrayList<Integer> ans= optimal(arr,n);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }
    }

    // ? Brute Approach
    // ! Time complexity : O(n^2)
    // ! Space complexity : O(n)
    static ArrayList<Integer> brute(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for ( int i = 0 ; i < n ; i++){
            boolean leader = true;
            for ( int j = i + 1 ; j < n ; j++){
                if ( arr[j] > arr[i]){
                    leader = false;
                    break;
                }
            }
            if (leader) ans.add(arr[i]);
        }
        return ans;

    }

    // ! Time complexity : O(n)
    // ! Space complexity : O(n)

    static ArrayList<Integer> optimal(int[] arr, int n){
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int max = arr[n-1];
        ans.add(max);
        for ( int i = n-2; i >=0 ; i--){
            if( arr[i] > max){
                max = arr[i];
                ans.add(max);
            }


        }
        return ans;
    }
}
