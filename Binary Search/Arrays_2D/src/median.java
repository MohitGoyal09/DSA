public class median {

    public static void main(String args[]) {
        int row = 3, col = 3;
        int[][] arr = {{1, 3, 8},
                {2, 3, 4},
                {1, 2, 5}};

        System.out.println("The median of the row-wise sorted matrix is: "+
                Solution.findMedian(arr,col , row));

    }

    // ! Time Complexity : O(row*log col) since the upper bound function takes log c time.
    public final class Solution {
        public static int findMedian(int matrix[][], int m, int n) {
            int low = Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for(int i = 0; i< m; i++){
                low = Math.min(low, matrix[i][0]);

                high = Math.max(high, matrix[i][n-1]);
            }
            int req = (n*m)/2;
            // Note: we have to keep the while condition as low<=high because there might be case of
            // multiple same numbers so in that case we need to keep this equal
            while(low <= high) {
                int mid = (low+high)/2;
                int currNumbers = numElements(matrix, mid);
                if(currNumbers <= req)  low = mid+1;
                else high = mid-1;
            }
            //Using opposite polarity concept
            return low;
        }



        public static int numElements(int [][] arr, int num){
            int count = 0;
            for(int i = 0; i< arr.length; i++){
                count+=upperBound(arr[i], num);
            }
            return count;
        }
        public static int upperBound (int [] arr, int num) {
            int low = 0;
            int high = arr.length-1;
            while(low <= high){
                int mid= (low+high)/2;
                if(arr[mid] <= num) low = mid+1;
                else high = mid-1;
            }
            //Using opposite polarity concept
            return low;
        }
    }

}
