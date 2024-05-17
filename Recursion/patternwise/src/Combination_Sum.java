import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// * https://leetcode.com/problems/combination-sum/solutions/16502/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
public class Combination_Sum {
    // ! Combination Sum 1
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList< >();
        findCombinations(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }

    private void findCombinations(int ind, int[] arr, int target, List < List < Integer >> ans, List < Integer > ds) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList <> (ds));
            }
            return;
        }

        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findCombinations(ind, arr, target - arr[ind], ans, ds);
            ds.remove(ds.size() - 1);
        }
        findCombinations(ind + 1, arr, target, ans, ds);
    }
    // ! Combination Sum 2
    // * IF Array Contains Duplicates
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List < List < Integer >> ans = new ArrayList< >();
        Arrays.sort(candidates);
        withoutdup(0, candidates, target, ans, new ArrayList < > ());
        return ans;
    }
    private void withoutdup(int ind , int[] arr , int target , List<List<Integer>> ans , List<Integer> ds){
        if (target == 0){
                ans.add(new ArrayList<> (ds));
                return;
            }


        for (int i = ind ; i < arr.length ; i++){
            if (i > ind && arr[i] == arr[i-1]) continue;
            if (arr[i] > target) break;
            ds.add(arr[i]);
            withoutdup(i + 1, arr, target - arr[i] , ans , ds);
            ds.remove(arr[i]);
        }

    }
}
