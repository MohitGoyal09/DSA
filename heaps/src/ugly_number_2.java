import java.io.PipedOutputStream;
import java.util.*;
public class ugly_number_2 {
//    Certainly! I'd be happy to explain the approach used in this code. This solution
//    is designed to find the nth ugly number. An ugly number is a positive integer whose
//    prime factors are limited to 2, 3, and 5. Here's the approach:
//
//      1. Data Structures:
//            - An array `primes` containing the prime factors 2, 3, and 5.
//            - A `PriorityQueue` called `uglyHeap` to store and retrieve ugly numbers in ascending order.
//   - A `HashSet` called `visited` to keep track of numbers we've already processed.
//
//            2. Initialization:
//            - Add 1 to both `uglyHeap` and `visited` as it's the first ugly number.
//
//            3. Main Algorithm:
//            - The method uses a loop that runs n times to find the nth ugly number.
//   - In each iteration:
//            a. Poll (remove and return) the smallest number from `uglyHeap`. This is the current ugly number.
//    b. For each prime factor (2, 3, and 5):
//            - Multiply the current ugly number with the prime factor.
//        - If this new number hasn't been seen before (not in `visited`):
//            * Add it to `uglyHeap`
//            * Add it to `visited` to mark it as processed
//
//4. Result:
//            - After n iterations, the last number polled from `uglyHeap` is the nth ugly number.
//
//    The key ideas behind this approach are:
//
//            1. Generate new ugly numbers by multiplying existing ugly numbers with the prime factors.
//2. Use a priority queue to always have access to the smallest ugly number generated so far.
//            3. Use a set to avoid duplicates, as the same ugly number can be generated in multiple ways.
//
//    This approach ensures that we generate ugly numbers in ascending order and efficientl
//    y find the nth one. The time complexity is O(n log n) due to the heap operations, and
//    the space complexity is O(n) for storing the generated numbers.
    class Solution {
        public int nthUglyNumber(int n) {
            int[] primes = {2, 3, 5};
            PriorityQueue<Long> uglyHeap = new PriorityQueue<>();
            HashSet<Long> visited = new HashSet<>();

            uglyHeap.add(1L);
            visited.add(1L);

            long curr = 1L;
            for (int i = 0; i < n; i++) {
                curr = uglyHeap.poll();
                for (int prime : primes) {
                    long new_ugly = curr * prime;
                    if (!visited.contains(new_ugly)) {
                        uglyHeap.add(new_ugly);
                        visited.add(new_ugly);
                    }
                }
            }
            return (int)curr;
        }
    }

    // ! DP Approach
    public int uglynumber(int n ){
        int[] prime = { 2,3 , 5};
        int[] indices = { 0 , 0, 0};
        List<Integer> ugly = new ArrayList<>();
        ugly.add(1);
        for (int i = 0  ; i < n ;i++){
            int[] nextugly = {
                  ugly.get(indices[0]) * prime[0],
                  ugly.get(indices[1]) * prime[1],
                  ugly.get(indices[2]) * prime[2]
            };
            int min = Math.min(nextugly[0], Math.min(nextugly[1], nextugly[2]));
            ugly.add(min);
            for (int j = 0 ; j < 3 ; j++){
                if (nextugly[j] == min){
                    indices[j]++;
                }
            }
        }
        return ugly.get(n-1);
    }
    class Solution3 {
        public int nthUglyNumber(int n) {
            int[] dp = new int[n + 1];
            dp[0] = 0;
            dp[1] = 1;

            int i2, i3, i5;
            i2 = i3 = i5 = 1;

            for (int i = 2; i <= n; i++) {
                int n2 = dp[i2] * 2;
                int n3 = dp[i3] * 3;
                int n5 = dp[i5] * 5;

                int toInsert = Math.min(n2, Math.min(n3, n5));
                dp[i] = toInsert;

                // since duplicates might exist so we cant use else if, because there might be a
                // case when we want to increase both the pointers.

                // example: i2 and i3=6, ab 6 ans mei daal diya hai oh dono pointers ko aage
                // badhao
                if (toInsert == n2)
                    i2++;
                if (toInsert == n3)
                    i3++;
                if (toInsert == n5)
                    i5++;
            }
            return dp[n];

        }
    }
}
