// Approach-1 - Greedily using %3 property
// T.C : O(nlogn)
// S.C : O(n)
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        List<Integer> remain1 = new ArrayList<>();
        List<Integer> remain2 = new ArrayList<>();

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1)
                remain1.add(num);
            else if (num % 3 == 2)
                remain2.add(num);
        }

        if (sum % 3 == 0)
            return sum;

        Collections.sort(remain1);
        Collections.sort(remain2);

        int result = 0;

        if (sum % 3 == 1) {
            int remove1 = remain1.size() >= 1 ? remain1.get(0) : Integer.MAX_VALUE;
            int remove2 = remain2.size() >= 2 ? remain2.get(0) + remain2.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1, remove2);
        } 
        else { // sum % 3 == 2
            int remove1 = remain2.size() >= 1 ? remain2.get(0) : Integer.MAX_VALUE;
            int remove2 = remain1.size() >= 2 ? remain1.get(0) + remain1.get(1) : Integer.MAX_VALUE;
            result = sum - Math.min(remove1, remove2);
        }

        return Math.max(result, 0);
    }
}



// Approach-2 - Recursion Memoization
// T.C : O(n)
// S.C : O(n)
class Solution {
    private int solve(int i, int remainder, int[] nums, int[][] t) {
        if (i >= nums.length) {
            return (remainder == 0) ? 0 : Integer.MIN_VALUE;
        }

        if (t[i][remainder] != -1)
            return t[i][remainder];

        int pick = nums[i] + solve(i + 1, (remainder + nums[i]) % 3, nums, t);
        int notPick = solve(i + 1, remainder, nums, t);

        return t[i][remainder] = Math.max(pick, notPick);
    }

    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n][3];

        for (int i = 0; i < n; i++)
            Arrays.fill(t[i], -1);

        return solve(0, 0, nums, t);
    }
}



// Approach-3 - Bottom up
// T.C : O(n)
// S.C : O(n)

class Solution {
    public int maxSumDivThree(int[] nums) {
        int n = nums.length;
        int[][] t = new int[n + 1][3];

        // Initialize with INT_MIN
        for (int i = 0; i <= n; i++) {
            Arrays.fill(t[i], Integer.MIN_VALUE);
        }

        // Base case: i == n
        t[n][0] = 0;
        t[n][1] = Integer.MIN_VALUE;
        t[n][2] = Integer.MIN_VALUE;

        // DP from bottom to top
        for (int i = n - 1; i >= 0; i--) {
            for (int rem = 0; rem < 3; rem++) {

                int newRem = (rem + nums[i]) % 3;

                int pick = (t[i + 1][newRem] == Integer.MIN_VALUE)
                           ? Integer.MIN_VALUE
                           : nums[i] + t[i + 1][newRem];

                int notPick = t[i + 1][rem];

                t[i][rem] = Math.max(pick, notPick);
            }
        }

        return t[0][0];
    }
}