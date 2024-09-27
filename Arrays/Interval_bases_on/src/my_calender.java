import java.util.*;
public class my_calender {
    //Approach-1 : Brute Force
//T.C : O(n^2)
//S.C : O(n)
    class MyCalendar {

        // List to store the booked intervals
        List<int[]> calendar;

        public MyCalendar() {
            // Initialize the list
            calendar = new ArrayList<>();
        }

        public boolean book(int start, int end) {
            // Check for overlap with every existing booking
            for (int[] curr : calendar) {
                // If there is overlap, return false
                if (!(end <= curr[0] || start >= curr[1])) {
                    return false;
                }
            }

            // If no overlap, add the booking to the calendar
            calendar.add(new int[]{start, end});
            return true;
        }
    }
    //Approach - 2 (set : lower_bound) : O(nlog(n))
    //T.C : O(nlogn)
    //S.C : O(n)
//    MyCalendar3 Algorithm Notes:
//
//            1. Data Structure:
//            - Uses [TreeSet](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html) to store booked intervals
//            - TreeSet ordered by start time, then end time
//
//2. book(int start, int end) method:
//            - Time complexity: O(log N)
//
//3. Booking process:
//    a. Check next event:
//            - Find ceiling (next higher) event in TreeSet
//      - If overlap with next event, return false
//
//    b. Check previous event:
//            - Find floor (next lower) event in TreeSet
//      - If overlap with previous event, return false
//
//    c. If no overlaps:
//            - Add new booking to TreeSet
//      - Return true
//
//            4. Overlap check:
//            - For next event: next.start < current.end
//   - For previous event: current.start < prev.end
//
//5. Key operations:
//            - TreeSet.ceiling(): O(log N)
//   - TreeSet.floor(): O(log N)
//   - TreeSet.add(): O(log N)

    class MyCalendar3 {

        // TreeSet to store the booked intervals
        TreeSet<int[]> st;

        public MyCalendar3() {
            // Initialize the TreeSet with a custom comparator
            st = new TreeSet<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        }

        public boolean book(int start, int end) {
            // Find the first event that starts after or at the same time of {start, end}
            int[] event = new int[]{start, end};
            int[] next = st.ceiling(event); // O(logN)

            // Check if the current event overlaps with the next event
            if (next != null && next[0] < end) {
                return false;
            }

            // Check if the current event overlaps with the previous event
            int[] prev = st.floor(event);
            if (prev != null && start < prev[1]) {
                return false;
            }

            // If no overlap, add the booking to the set
            st.add(new int[]{start, end});
            return true;
        }
    }
}
