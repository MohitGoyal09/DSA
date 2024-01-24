public class Recurssive_sort {
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Array before Sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
        insertsort(arr , 0 , arr.length);
        bubblesort(arr , arr.length);

        System.out.println("Array after selection sort: ");
        for ( int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void bubblesort( int[] arr , int n){
     if ( n == 1) return;
     boolean swap = false;
     for ( int  j = 0 ; j < n-2 ; j++){
         if ( arr[j] > arr[j+1] ){
             swap(arr , j , j+1);
             swap = true;
         }
     }
     if (!swap) return;
     bubblesort(arr , n-1);
    }
    public static void insertsort(int[] arr ,int i , int n){
        if ( i == n) return;
        int j = i;
        while ( j > 0 && arr[j] < arr[j-1]){
            swap(arr , j , j-1);
            j--;
        }
        insertsort(arr , i+1 , n);

    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
