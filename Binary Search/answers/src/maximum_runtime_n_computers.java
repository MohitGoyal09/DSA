/*
Approach:
----------
We want to maximize the minimum running time T during which all n computers can run simultaneously given a list of batteries with various capacities (in minutes). Batteries can be swapped among computers at any time, and each battery can only supply at most its full charge.

The core idea is to use binary search to find the largest value of T such that it is possible to distribute the batteries' total power so that all n computers run for T minutes at the same time.

- For a guess T, we check if the sum of the smallest between T and each battery's capacity, over all batteries, is at least n * T.
- This means, if all batteries together can provide enough energy for n computers to run for T minutes simultaneously, then T is feasible.
- We binary search the answer over T from 0 up to the total capacity divided by n (because that's the maximum possible equal runtime for all computers).

This binary search allows us to efficiently find the maximum possible runtime T.
*/

// Time Complexity: O(k*logn)
// Space Complexity: O(1)



class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long l = Long.MAX_VALUE;
        long sum = 0;
        for (int b : batteries){
            l = Math.min(b ,l );
            sum +=b;
        }
        long r = sum/n;
        long result = 0;
        while ( l <= r){
            long mid = l + (r-l)/2;
            if (possible(batteries , n , mid)){
                result = mid;
                l = mid + 1;
            } else r = mid - 1;
        }
        return result;
    }

    private boolean possible(int[] batteries , int n , long mid){
        long total_time = n * mid;
        for ( int b : batteries){
            total_time -= Math.min((long) b , mid);
            if (total_time <=0) return true;
        }
        return false;
    }
}