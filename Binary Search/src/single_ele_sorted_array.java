public class single_ele_sorted_array {
    public static void main(String[] args) {

        int[] a = {1,1,2, 2, 3, 3, 4, 5,5};
        int ans = search(a);
        System.out.println("The single element is: " + ans);
    }
    static int search(int[] a){
        int n = a.length;
        int low = 1 , high = n-2;
        if ( n== 1) return a[0];
        if ( a[n-1] != a[n-2]) return a[n-1];
        if (a[0] != a[1]) return a[0];
        while (low<= high){
            int mid = (low + high) / 2;
            if (a[mid] != a[mid-1] && a[mid] != a[mid+1]) return a[mid];
            if (( mid % 2 == 1 && a[mid] == a[mid-1]) ||  (mid % 2 == 0 && a[mid] == a[mid+1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return -1;
    }
}
