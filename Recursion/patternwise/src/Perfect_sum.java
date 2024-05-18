import java.util.ArrayList;

public class Perfect_sum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5 };
        int target = 5;
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println(count(arr, target, 0, 0));
    }
    // ! Print all the subsequence of the given array of Sum K
    public static void perfectSum(int[] arr, int target, int index, int sum, ArrayList<Integer> list) {
        if (index == arr.length){
            if (sum == target){
                System.out.println(list);
            }
            return;
        }
        // * if picked
        list.add(arr[index]);
        sum += arr[index];
        perfectSum(arr, target, index + 1, sum, list);
        list.remove(list.size() - 1);
        sum -= arr[index];
        // * if not picked
        perfectSum(arr, target, index + 1, sum, list);
    }
    // ! Print one the subsequence of the given array of Sum K
    public static boolean one(int[] arr, int target, int index, int sum, ArrayList<Integer> list) {
        if (index == arr.length){
            if (sum == target){
                System.out.println(list);
                return true;
            }
            return false;
        }
        // * if picked
        list.add(arr[index]);
        sum += arr[index];
        if (one(arr, target, index + 1, sum, list)) return true;
        list.remove(list.size() - 1);
        sum -= arr[index];
        // * if not picked
        if (one(arr, target, index + 1, sum, list)) return true;
        return false;
    }
    // ! Count the number of subsequence of the given array of Sum K
    public static int count(int[] arr, int target, int index, int sum) {
        if (index == arr.length){
            if (sum == target) return 1;
            return 0;
        }
        // * if picked
        sum += arr[index];
        int left = count(arr, target, index + 1, sum);
        sum -= arr[index];
        // * if not picked
        int right = count(arr, target, index + 1, sum);
        return left + right;
    }
}
