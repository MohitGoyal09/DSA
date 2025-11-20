// Algorithm : 
// 1. Sort the intervals by the end time
// 2. Initialize two variables to store the last two elements of the interval
// 3. Iterate through the intervals
// 4. If the current interval does not overlap with the previous interval, add 2 to the count
// 5. If the current interval overlaps with the previous interval, add 1 to the count
// 6. Return the count

// Time Complexity : O(nlogn)
// Space Complexity : O(1)

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[1], b[1]));
        int prev1 = intervals[0][1] - 1;
        int prev2 = intervals[0][1];
        int count = 2;
        for (int i = 1 ; i < intervals.length ; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (prev2 < start){
                prev1 = end - 1;
                prev2 = end;
                count +=2;
            } else if (prev1 < start){
                if (end == prev2){
                    prev1 = end - 1;
                } else {
                    prev1 = end;
                }
                if (prev1 > prev2){
                    int temp = prev1;
                    prev1 = prev2;
                    prev2 = temp;
                }
                count +=1;
            }
        }
        return count;
    }
}