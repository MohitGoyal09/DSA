public class max_product_subarray {
    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = burutte(nums);
        System.out.print("The maximum product subarray is: "+answer);
    }

    static int burutte(int arr[]) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++)
                    prod *= arr[k];
                result = Math.max(result, prod);
            }
        return result;
    }
    static int better(int arr[]) {
        int result = arr[0];
        for(int i=0;i<arr.length-1;i++) {
            int p = arr[i];
            for(int j=i+1;j<arr.length;j++) {
                result = Math.max(result,p);
                p *= arr[j];
            }
            result = Math.max(result,p);
        }
        return result;
    }
   static int optimal (int arr[]){
        int n = arr.length;
        int prefix = 1 , suffix = 1;
        int max = Integer.MIN_VALUE;
        for ( int i = 0 ; i < n ; i++){
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
            prefix *= arr[i];
            suffix *= arr[n-i-1];
            max = Math.max(max,Math.max(prefix,suffix));
        }
        return max;
   }

}
