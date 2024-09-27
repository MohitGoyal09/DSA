import java.util.*;
public class my_calender_2 {
    class MyCalendarTwo {

        private List<int[]> doubleOverlappedRegion;
        private List<int[]> overallBookings;

        // Constructor initializes the lists
        public MyCalendarTwo() {
            doubleOverlappedRegion = new ArrayList<>();
            overallBookings = new ArrayList<>();
        }

        // Method to check if two intervals overlap
        private boolean checkOverlap(int start1, int end1, int start2, int end2) {
            return Math.max(start1, start2) < Math.min(end1, end2);
        }

        // Method to find the overlapped region between two intervals
        private int[] findOverlappedRegion(int start1, int end1, int start2, int end2) {
            return new int[]{Math.max(start1, start2), Math.min(end1, end2)};
        }

        // Method to book a new event
        public boolean book(int start, int end) {
            // Check if a triple booking is being created or not
            for (int[] region : doubleOverlappedRegion) {
                if (checkOverlap(region[0], region[1], start, end)) {
                    return false; // Triple booking created
                }
            }

            // Check if it is creating double bookings
            for (int[] booking : overallBookings) {
                if (checkOverlap(booking[0], booking[1], start, end)) {
                    doubleOverlappedRegion.add(findOverlappedRegion(booking[0], booking[1], start, end));
                }
            }

            // Add the current booking to the overall bookings list
            overallBookings.add(new int[]{start, end});
            return true;
        }
    }
}
