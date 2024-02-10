import java.util.ArrayList;
import java.util.List;

public class median_2_sorted_array {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + bs(a, b));
    }

    static double brutteforce(int[] a , int[] b){
        int n = a.length;
        int m = b.length;
        List<Integer> arr3 = new ArrayList<>();
        int i = 0 , j = 0 , k = 0;
        while ( i < n && j < m){
            if ( a[i] < b[j]){
                arr3.add(a[i++]);

            }
            else {
                arr3.add(b[j++]);
            }
        }
        while (i < n) {
            arr3.add(a[i++]);
        }
        while (j < m) {
            arr3.add(b[j++]);
        }
        int n1 = n + m;
        if (n1 % 2 == 1){
            return (double) arr3.get(n1 / 2);
        }
        double median = ((double) arr3.get(n1 / 2) + (double) arr3.get((n1 / 2) - 1)) / 2.0;
        return median;
    }

    static double better(int[] a , int[]b ){
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        int ind2 = n/2;
        int ind1 = n/2 - 1;
        int indel1 = -1 , indel2 = -1;
        int cnt = 0;
        int i = 0 ,  j = 0;
        while (  i < n1 && j < n2){
            if (a[i] < b[j]){
                if (cnt == ind1) indel1 = a[i];
                if (cnt == ind2) indel2 = a[i];
                cnt++;
                i++;
            } else {
                if (cnt == ind1) indel1 = b[j];
                if (cnt == ind2) indel2 = b[j];
                cnt++;
                j++;
            }
        }
        if ( i < n1){
            if (cnt == ind1) indel1 = a[i];
            if (cnt == ind2) indel2 = a[i];
        }
        if ( j < n2){
            if (cnt == ind1) indel1 = b[j];
            if (cnt == ind2) indel2 = b[j];
        }
        if (n % 2 == 1) {
            return (double)indel2;
        }

        return (double)((double)(indel1 + indel2)) / 2.0;

    }

    static double bs(int[] a , int[] b){
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if (n1 > n2) return bs(b,a);
        int left = (n1 + n2 + 1)/2;
        int low = 0 , high = n1;
        while (low <= high){
            int mid1 = (low + high)/2;
            int mid2 = left - mid1;
            int l1 = (mid1 >0) ? a[mid1 -1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1){
                if ( n%2 == 1) return Math.max(l1,l2);
                return (double)(Math.min(r1,r2) + Math.max(l1,l2))/2.0;
            } else if ( l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0;
    }
}
