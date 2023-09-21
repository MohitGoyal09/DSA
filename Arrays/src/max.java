public class max {
    public static void main(String[] args) {
        int[] arr = { 1 , 2 , 3 , 5, 9};
        int value = max(arr);
        System.out.println(value);
    }

    static int max(int[] arr){
        int max = arr[0];
        for ( int i = 0 ; i < arr.length ; i++){
            if ( max < arr[i]){
                 max = arr[i];
            }

        }
        return max;
    }
}
