public class basics {
    public static void main(String[] args) {

    }

    static boolean checkKthBit(int n, int k)
    {
        // * Right shift
        return ((n >> k) & 1) != 0 ;

        // * Left Shift
     //   return ((n << k ) & 1) != 0;
    }
       // ! Even or Odd
    public static boolean isEven(int n)
    {
        return ((n & 1) == 0);

    }
    // ! Set Kth Bit
    static int setKthBit(int N,int K){
        // code here
        return ((1 << K) | N);
    }

    static int clearKthBit(int N,int K){
        // code here
        return (~(1 << K) & N);
    }

}
