// SELECTION SORT ALGORITHM
public class Main {
    public static void main(String[] args) {
        int arr[] = {13, 46, 24, 52, 20, 9};
        int n = arr.length;
        System.out.println("Array before Sort: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
//        selection_sort(arr, n);
//          bubble_sort(arr, n);
        insertion_sort(arr, n);
        System.out.println("Array after selection sort: ");
        for ( int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //SELECTION SORT ALGORITHM
    static void selection_sort(int[] arr , int n) {
        for( int i =0 ; i<n-1 ; i++){
            int mini = i;
            for( int j = i+1; j<n ; j++){
                if(arr[j] < arr[mini]){
                    mini = j;
                }
            //swap
            int temp = arr[mini];
            arr[mini] = arr[i];
            arr[i] = temp;
            }
        }
    }
    //BUBBLE SORT ALGORITHM
    static void bubble_sort(int[] arr,int n ){
        for ( int i = n-1; i >= 1 ; i--){
            for (int j = 0; j <= i -1 ; j++){
                if( arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // INSERTION SORT ALGORITHM
    static void insertion_sort(int[] arr , int n){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i+1; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    swap(arr, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}