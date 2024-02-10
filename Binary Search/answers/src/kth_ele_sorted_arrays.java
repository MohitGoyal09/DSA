public class kth_ele_sorted_arrays {
    public static void main(String[] args) {
        int array1[] = {2,3,6,7,9};
        int array2[] = {1,4,8,10};

        int k = 5;
        System.out.println(bs(array1,array2,k));
    }
    static double bs(int[] a , int[] b , int k){
        int n1 = a.length;
        int n2 = b.length;
        int n = n1 + n2;
        if (n1 > n2) return bs(b,a,k);

        int low = Math.max(0,k-n1) , high = Math.min(k,n);
        while (low <= high){
            int mid1 = (low + high)/2;
            int mid2 =k - mid1;
            int l1 = (mid1 >0) ? a[mid1 -1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2-1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            if (l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            } else if ( l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return -1;
    }
}
