
public class Oncenumber {
    public static void main(String[] args) {
        int[] arr ={1,1,2,2,3,4,4,5,5,6,6,7,7,8,8,9,9,10,10};
        int n = arr.length;
        int ans = optimal(arr,n);
        System.out.println(ans);
    }

    // ? Burte Force
    // * Time Complexity = O(N^2)
    // * Space Complexity = O(1)
    static int burrte(int[] arr , int n){
        for(int i = 0  ; i < n ; i++){
            int num = arr[i];
            int count = 0;
            for( int  j = 0; j < n ; j++){
                if(num == arr[j]){
                    count++;
                }
            }
            if(count == 1) return num;
        }
        return -1;
    }

    // ? Better Approach
    // * Time Complexity = O(3N)
    // * Space Complexity = O(max +1)
    static int better(int[] arr , int n){
        int max = arr[0];
        for ( int i = 0 ; i < n ; i++ ){
            max = Math.max(max, arr[i]);
        }
        int[] hash = new int[max +1];
        for ( int i  =0 ; i < n ; i++){
            hash[arr[i]]++;
        }
        for ( int i = 0 ; i < n ; i++){
            if(hash[arr[i]] == 1){
                return arr[i];
            }
        }
        return -1;
    }

    // ? Optimal Approach
    // * Time Complexity = O(N)
    // * Space Complexity = O(1)
    static int optimal(int[] arr , int n){
        int xor = 0;
        for ( int i = 0 ; i < n ; i++){
             xor = xor ^ arr[i];

        }
        return xor;

    }
}
