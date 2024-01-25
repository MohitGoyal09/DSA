import java.util.*;

// * Time Complexity: O(nlog(n))
// * Reason: At each step, we divide the whole array, for that logn and we assume n steps are taken
// * to get a sorted array, so overall time complexity will be nlogn

// * Space Complexity: O(n)
public class Merge_Sort {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = 7;
//        int arr[] = {9, 4, 7, 6, 3, 1, 5};
//        System.out.println("Before sorting array: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//        ms(arr, 0, n - 1);
//        System.out.println("After sorting array: ");
//        for (int i = 0; i < n; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//    }

//    public static void ms(int[] a, int start, int end) {
//        if (start >= end) return;
//        int mid = (start + end) / 2;
//        ms(a, start, mid);
//        ms(a, mid + 1, end);
//        listmerge(a, start, mid, end);
//    }

    // ! Using Arraylist
    public static void listmerge(int[] a, int start, int mid, int end) {
        ArrayList<Integer> temp = new ArrayList<>();
        int i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) {
                temp.add(a[i]);
                i++;
            } else {
                temp.add(a[j]);
                j++;
            }

        }
            while (i <= mid) {
                temp.add(a[i]);
                i++;
            }
            while (j <= end) {
                temp.add(a[j]);
                j++;
            }
            for (int s = start; s <= end; s++) {
                a[s] = temp.get(s - start);
            }
        }

    // ! Using Arrays only
    public static void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start, j = mid + 1, k = 0;
        while (i <= mid && j <= end) {
            if (a[i] < a[j]) temp[k++] = a[i++];
            else temp[k++] = a[j++];
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= end) temp[k++] = a[j++];
        for (int l = start; l <= end; l++) a[l] = temp[l - start];
    }


}




