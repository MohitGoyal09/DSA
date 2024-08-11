import java.util.Arrays;
// ! https://www.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1
public class Main {
    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }
    class Solution
    {
        //Function to find the maximum profit and the number of jobs done.
        int[] JobScheduling(Job arr[], int n)
        {
            // Your code here
            Arrays.sort(arr, (a, b) -> b.profit - a.profit);
            int maxDeadline = 0;
            for(Job job : arr) {
                maxDeadline = Math.max(maxDeadline, job.deadline);
            }
            boolean[] flag = new boolean[maxDeadline + 1];
            int count = 0;
            int total = 0;
            for(Job job : arr) {
                for(int j=job.deadline; j>0; j--) {
                    if(flag[j] == false) {
                        flag[j] = true;
                        count++;
                        total += job.profit;
                        break;
                    }
                }
            }
            return new int[]{count, total};
        }
    }
}