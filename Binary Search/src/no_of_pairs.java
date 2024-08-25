import java.util.Arrays;
// * https://www.geeksforgeeks.org/problems/number-of-pairs-1587115620/1
//Certainly! Here's an algorithmic step-by-step breakdown of the given code to help you revise later:
//
//        1. Define a binary search function:
//        a. Initialize low, high, and index variables
//b. While low <= high:
//        - Calculate mid
//      - If brr[mid] <= key, update index and move low
//      - Else, move high
//c. Return the final index
//
//2. In the countPairs function:
//a. Initialize variables: ans, one, two, threeFour
//b. Sort the brr array
//c. Count occurrences of 1, 2, 3, and 4 in brr
//
//3. Iterate through each element x in arr:
//a. If x != 1:
//        - Add count of 1's to ans
//        - If x == 2, subtract count of 3's and 4's from ans
//      - If x == 3, add count of 2's to ans
//        - Perform binary search to find the largest index where brr[index] <= x
//      - Add (brr.length - index - 1) to ans
//
//4. Return the final count (ans)
//
//Key points to remember:
//        - Time Complexity: O((N+M)LogM) due to sorting brr and binary search for each element in arr
//- Space Complexity: O(1) as no extra space is used proportional to input size
//- The algorithm efficiently handles special cases for x = 1, 2, and 3
//        - Binary search is used to find the count of elements in brr greater than x
//
//This algorithm efficiently counts pairs (x, y) where x^y > y^x by utilizing sorting, counting, and binary search techniques.
public class no_of_pairs {
    int binarySearch(int key,int brr[]){
        int low=0,high=brr.length-1,mid,index=-1;
        while(low<=high){
            mid=(low+high)/2;
            if(brr[mid]<=key){
                index=mid;
                low=mid+1;
            }
            else high=mid-1;
        }
        return index;
    }
    // Function to count number of pairs such that x^y is greater than y^x.
    public long countPairs(int arr[], int brr[], int M, int N) {
        // code here
        long ans = 0,one=0,two=0,threeFour=0;
        Arrays.sort(brr);
        for(int x:brr){
            if(x==1)one++;
            else if(x==2)two++;
            else if(x==3 || x==4)threeFour++;
        }
        for(int x:arr){
            if(x!=1){
                ans+=one;
                if(x==2)ans-=threeFour;
                if(x==3)ans+=two;
                int index = binarySearch(x,brr);
                ans+=(brr.length-index-1);
            }
        }
        return ans;
    }


//  ! Time Complexity:- O((N+M)LogM)
// ! Space Complexity:- O(1)
}
