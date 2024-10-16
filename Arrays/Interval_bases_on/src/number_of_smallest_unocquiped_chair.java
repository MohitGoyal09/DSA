import java.util.*;
public class number_of_smallest_unocquiped_chair {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[] endTimes = new int[n]; // at max we will have 0 to n-1 chairs
        Arrays.fill(endTimes, -1);

        /*
            We need to sort the times based on arrival time but we don't want to
            lose the friend number after sorting. So, store the arrival time
            of targetFriend because it's given in the question that
            Each arrival time is distinct.
        */

        int targetArrivalTime = times[targetFriend][0];

        Arrays.sort(times, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] time : times) {
            int arrival = time[0];
            int depart = time[1];
            // Find the first unoccupied chair
            for (int i = 0; i < n; i++) {
                if (endTimes[i] <= arrival) {
                    endTimes[i] = depart; // update with current friend depart time

                    if (arrival == targetArrivalTime)
                        return i;
                    break;
                }
            }
        }
        return -1;
    }
}
