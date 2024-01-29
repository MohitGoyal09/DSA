// * Time Complexity = O(N)
// * Space Complexity = O(1)
public class MaximumConsecutive {
    public static void main(String[] args) {
        int max = 0 ;
        int count = 0;
        int arr[] = {1,1,4,1,1,1,0,10, 9 , 1,1,1,1};
        for ( int i = 0 ; i < arr.length ; i++){
            if ( arr[i] == 1) count++;
            else count = 0;
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}

