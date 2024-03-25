import java.util.ArrayList;
import java.util.List;


public class Prime_factors {
    public static List<Integer> countPrimes(int n) {
        List<Integer> list = new ArrayList<>();
        // Check for divisibility by 2 first and add 2 to the list of prime factors
        // as long as n is even.
        while (n % 2 == 0) {
            list.add(2);
            n /= 2;
        }

        // After the above step, n must be odd. Now we can skip even numbers.
        // Start from 3 and check for divisibility by i (where i is odd).
        for (int i = 3; i * i <= n; i += 2) {
            // While i divides n, add i to the list and divide n by i
            while (n % i == 0) {
                list.add(i);
                n /= i;
            }
        }

        // If n becomes a prime number greater than 2, then it will not become 1 by the above two steps.
        // For example, n = 14 will result in n = 7 at the end of the loop, which is a prime number.
        if (n > 1) {
            list.add(n);
        }

        return list;
    }

    public static void main(String[] args) {
        // Example usage
        List<Integer> primeFactors = countPrimes(100);
        System.out.println("Prime factors: " + primeFactors);
    }
    static long largestPrimeFactor(int N) {

        int maxPrime = Integer.MIN_VALUE;
        while(N%2 == 0){
            N = N/2;
            maxPrime = 2;
        }
        for(int i = 3; i <= Math.sqrt(N); i+=2){
            while(N%i == 0){
                N = N / i;
                maxPrime = i;
            }
        }
        if(N > 2){
            maxPrime = N;
        }
        return maxPrime;
    }
}
