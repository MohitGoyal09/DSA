public class Missingno {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,6,7,8};
        int n = a.length+1;
        int ans = missingNumber(a, n);
        int ans1 = optimal2(a,n);
        System.out.println(ans1);
    }

    // ? Brute Force Approach
    // * Time Complexity: O(N^2), where N = size of the array+1.
    // *Reason: In the worst case i.e. if the missing number is N itself,
    // * the outer loop will run for N times,
    // * and for every single number the inner loop will also run for approximately N times.
    // * So, the total time complexity will be O(N^2).

    // * Space Complexity: O(1)  as we are not using any extra space
    static int brutte(int[] a , int N){
        for ( int i = 1; i < N ; i++){
            int flag = 0;
            for ( int j = 0 ; j < N - 1 ; j++){
                if ( a[j] == i){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) return i;
        }
        return -1;
    }

    // ? Optimal Approach 1
    // * Time Complexity = O(n)
    // * Space Complexity = O(1)
    public static int missingNumber(int []a, int N) {
        if(a == null || a.length == 0) return 0;
        //Summation of first N numbers:
        int sum = (N * (N + 1)) / 2;

        //Summation of all array elements:
        int s2 = 0;
        for (int i = 0; i < N - 1; i++) {
            s2 += a[i];
        }

        int missingNum = sum - s2;
        return missingNum;
    }

    //? Optimal Approach 2
    // ? Bitwise operation :- XOR
    // * Time Complexity = O(n)
    // * Space Complexity = O(1)

    static int optimal2(int [] a , int n){
        int XOR1 = 0 , XOR2 = 0;
        for ( int i = 0 ; i < n-1 ; i++){
            XOR2 = XOR2  ^ a[i];
            XOR1 = XOR1 ^ (i+1);
        }
           XOR1 = XOR1^n;
        return (XOR1^XOR2);
    }


}
