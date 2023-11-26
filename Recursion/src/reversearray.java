public class reversearray {
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Array before Sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        reverse(arr,0,n-1);
//        rerecur(arr,0,n-1);
        System.out.println("Array after Sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // * 2-pointers approach
    static void reverse(int[] arr,int start,int end){
        while (start < end ){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    // * Resursive approach
    static void rerecur(int[] arr,int start,int end){
        if ( start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            rerecur(arr,start+1,end-1);
        }
    }
}
