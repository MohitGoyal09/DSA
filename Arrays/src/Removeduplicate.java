import java.util.HashSet;

public class Removeduplicate {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 5, 9, 7, 8, 9, 10};
        int s = brute(arr);
        int o = optimal(arr);
        System.out.println("The array after removing duplicate elements is ");
        for (int i = 0; i < o; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    static int brute(int[] arr) {
        // * Time Complexity: O(NlongN) + O(N)
        // * NlogN = Inseting Set
        // * N = Iteration through the array
        // * Space Complexity : O(N)
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }
        int k = set.size();
        int j = 0;
        for (int x : set) {
            arr[j++] = x;
        }
        return k;
    }

    static int optimal(int[] arr) {
        // * Time Complexity : O(N)
        // * Space Complexity : O(1)
        int i = 0;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] != arr[j]) {
                i++;
                arr[i] = arr[j];
            }

        }
        return i+1;
    }

}
