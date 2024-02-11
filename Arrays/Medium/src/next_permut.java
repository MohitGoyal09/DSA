import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class next_permut {
    public static void main(String[] args) {
        List<Integer> A = Arrays.asList(new Integer[] {2, 1, 5, 4, 3, 0, 0});
        List<Integer> ans = nextPermutation(A);

        System.out.print("The next permutation is: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println("]");

    }
    public static List<Integer> nextPermutation(List<Integer> A) {
        int n = A.size();
        // Step 1: Find the break point:
        int ind = -1; // break point
        for ( int i = n-2 ; i >=0 ; i--){
            if (A.get(i) < A.get(i+1)) {
                ind = i;
                break;
            }
        }
        if (ind == -1){
            Collections.reverse(A);
            return A;
        }
        // Step 2: Find the next greater number
        for (  int i = n -1 ; i > ind ; i--){
            if (A.get(i) > A.get(ind)){
                int temp = A.get(i);
                A.set(i , A.get(ind));
                A.set(ind , temp);
                break;
            }
        }
        // Step 3 : Reverse the Right array
        List<Integer> sublist = A.subList(ind + 1, n);
        Collections.reverse(sublist);

        return A;

    }



    //  ! LEETCODE
    class Solution {
        public void nextPermutation(int[] nums) {
            int ind1=-1;
            int ind2=-1;
            // step 1 find breaking point
            for(int i=nums.length-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    ind1=i;
                    break;
                }
            }
            // if there is no breaking  point
            if(ind1==-1){
                reverse(nums,0);
            }

            else{
                // step 2 find next greater element and swap with ind2
                for(int i=nums.length-1;i>=0;i--){
                    if(nums[i]>nums[ind1]){
                        ind2=i;
                        break;
                    }
                }

                swap(nums,ind1,ind2);
                // step 3 reverse the rest right half
                reverse(nums,ind1+1);
            }
        }
        void swap(int[] nums,int i,int j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }
        void reverse(int[] nums,int start){
            int i=start;
            int j=nums.length-1;
            while(i<j){
                swap(nums,i,j);
                i++;
                j--;
            }
        }
    }
}
