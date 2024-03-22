public class basics {
    public static void main(String[] args) { }

    static boolean checkKthBit(int n, int k) {
        // * Right shift
        return ((n >> k) & 1) != 0 ;

        // * Left Shift
     // !   return ((n << k ) & 1) != 0;
    }
       // ! Even or Odd
    public static boolean isEven(int n) { return ((n & 1) == 0); }
    // ! Set Kth Bit
    static int setKthBit(int N,int K){
        return ((1 << K) | N);
    }
    // ! Clear Kth Bit
    static int clearKthBit(int N,int K) {
        return (~(1 << K) & N);
    }
    // ! Toggle kth Bit
    static int togglekthBit(int N , int K){
        return (N ^ (1 << K));
    }
    // ! Remove the last set Bit
    static int removeLastSetBit(int N) { return (N & N-1); }
   // ! Check  number if power of 2
    static boolean power2(int N){
        return ( (N & N-1) == 0);
    }
    // ! Count Number of set Bits
    static int countbits(int n){
        int count = 0;
        while ( n > 1){
            count += n & 1;
            n = n >> 1;
        }
        if (n == 1) count++;
        return count;
    }

    static int countbits2(int n){
        int count = 0;
        while (n != 0){
            n = n & n-1;
            count++;
        }
        return count;
    }
}
