import java.util.Arrays;

public class geek_training {
    class Solution {
        public int maximumPoints(int[][] arr, int N) {
            // code here
            int[][] dp = new int[N][4];
            for (int[] row : dp){
                Arrays.fill(row ,  -1);
            }
            return f(N - 1 , 3 ,dp , arr);
        }
        public int f(int days , int last , int[][] dp , int[][] points){
            if (dp[days][last] != -1) return dp[days][last];
            if ( days == 0){
                int maxi = 0;
                for (int i = 0 ; i <= 2 ; i++){
                    if (i != last){
                        maxi = Math.max(maxi , points[0][i]);
                    }
                }
                return dp[days][last] = maxi;
            }
            int maxi = 0;
            for (int i = 0 ; i <=2 ; i++){
                if (i != last){
                    int activity = points[days][i] + f(days - 1 , i , dp , points);
                    maxi = Math.max(maxi, activity);
                }
            }
            return dp[days][last] = maxi;
        }
    }

    static int ninjaTraining(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[][] dp = new int[n][4];

        // Initialize the first day's maximum points based on the available choices
        dp[0][0] = Math.max(points[0][1], points[0][2]);
        dp[0][1] = Math.max(points[0][0], points[0][2]);
        dp[0][2] = Math.max(points[0][0], points[0][1]);
        dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                dp[day][last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        // Calculate the points for the current activity and add it to the maximum points from the previous day
                        int activity = points[day][task] + dp[day - 1][task];
                        // Update the maximum points for the current day and last activity
                        dp[day][last] = Math.max(dp[day][last], activity);
                    }
                }
            }
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[n - 1][3];
    }
    static int ninjaTraining2(int n, int[][] points) {
        // Initialize a 2D array 'dp' to store the maximum points
        int[] dp = new int[4];

        // Initialize the first day's maximum points based on the available choices
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // Iterate through each day and each activity
        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0; // Initialize the maximum points for the current day and last activity
                // Consider each possible task for the current day
                for (int task = 0; task <= 2; task++) {
                    if (task != last) { // Ensure that the current task is different from the last
                        temp[last] = Math.max(temp[last], points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }

        // Return the maximum points achievable after all days (last activity is 3)
        return dp[3];
    }

}
