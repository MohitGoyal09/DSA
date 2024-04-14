import java.util.Arrays;

public class sieve_of_erathosthenses {
    public static void main(String[] args) {

    }
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int count = 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < n; j += i) {
                    isPrime[j] = false; // This should be j, not i
                }
            }
        }
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        return count; // This should be outside the for loop
    }
}
