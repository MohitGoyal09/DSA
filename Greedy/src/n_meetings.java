import java.util.*;
public class n_meetings {
    class Solution {
        // Function to find the maximum number of meetings that can
        // be performed in a meeting room.
        public int maxMeetings(int n, int start[], int end[]) {
            // add your code here
            List<int[]> meetings = new ArrayList<>();
            for(int i =0;i<n;i++){
                meetings.add(new int[]{start[i],end[i]});

            }
            meetings.sort((a,b)-> a[1]-b[1]);

            int count =0;
            int lastEndTime = -1;

            for(int[] meeting:meetings){
                if(meeting[0] > lastEndTime){
                    count++;
                    lastEndTime = meeting[1];
                }
            }
            return count;
        }
    }
}
