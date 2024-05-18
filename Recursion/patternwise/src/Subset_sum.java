import java.util.*;

public class Subset_sum {
    public static void main(String[] args) {

    }

    public static void subsetsum(int ind , int sum , ArrayList<Integer> arr, int N , ArrayList<Integer> subset){
       if (ind == N){
           subset.add(sum);
           return;
       }
       // * picked
       subsetsum(ind +1, sum + arr.get(ind) , arr , N , subset );
       // * not picked
        subsetsum(ind +1, sum  , arr , N , subset );
    }

    // ! In case of duplicate Elmenets
    public void helper(int ind ,  int[] nums , ArrayList<Integer> list ,List<List<Integer>>subsets){
        subsets.add(new ArrayList<>(list));
        for (int i = ind ; i < nums.length ; i++){
            if (i != ind && nums[i] == nums[i-1]) continue;
            list.add(nums[i]);
            helper(i+1 , nums , list , subsets );
            list.remove(list.size()-1);
        }
    }
}
