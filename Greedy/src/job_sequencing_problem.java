import java.util.Arrays;

public class job_sequencing_problem {

    class Solution {
        // Function to find the maximum profit and the number of jobs done.
        int[] JobScheduling(Job arr[], int n) {
            // Sort jobs by profit in descending order
            Arrays.sort(arr, (a, b) -> b.profit - a.profit);

            // Find the maximum deadline to create a time slot array
            int maxDeadline = 0;
            for (Job job : arr) {
                maxDeadline = Math.max(maxDeadline, job.deadline);
            }

            // Create a time slot array to keep track of used slots
            boolean[] timeSlots = new boolean[maxDeadline + 1];
            int jobCount = 0, maxProfit = 0;

            // Schedule jobs
            for (Job job : arr) {
                // Find a slot for this job from its deadline to earlier slots
                for (int j = job.deadline; j > 0; j--) {
                    if (!timeSlots[j]) {
                        timeSlots[j] = true;
                        jobCount++;
                        maxProfit += job.profit;
                        break;
                    }
                }
            }

            return new int[] { jobCount, maxProfit };
        }
    }




class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

}
