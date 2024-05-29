public class rainwater {
    public static void main(String[] args) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }
    static int trap(int[] nums){
        int n = nums.length;
        int watertraped = 0;
        for (int i = 0 ; i < n ; i++){
            int j = i;
            int leftmax = 0 , rightmax = 0 ;
            while ( j >= 0){
                leftmax = Math.max(leftmax , nums[j]);
                j--;
            }
            j = i;
            while ( j < n){
                rightmax = Math.max(rightmax , nums[j]);
                j++;
            }
            watertraped += Math.min(leftmax , rightmax) - nums[i];
        }
        return watertraped;
    }
    // * Better Aproach
    // ! Precomputing the left max and right max for O(1) operation
    static int trap2(int[] arr){
        int n = arr.length;
        int[] leftmax = new int[n];
        int[] rightmax = new int[n];
        leftmax[0] = arr[0];
        for (int i = 1 ; i < n ; i++){
            leftmax[i] = Math.max(leftmax[i -1], arr[i]);
        }
        rightmax[n-1] = arr[n-1];
        for (int i = n - 2 ; i  >= 0 ; i--){
            rightmax[i] = Math.min(rightmax[i + 1] , arr[i]);
        }
        int watertrapped = 0;
        for (int i = 0 ; i < n ; i++){
            watertrapped += Math.min(leftmax[i] , rightmax[i]) - arr[i];
        }
        return watertrapped;
    }
    // * Optimal Aproach
    // * Intuition: We need a minimum of leftMax and rightMax.
    // * So if we take the case when height[l]<=height[r] we increase l++, so we can surely
    // * say that there is a block with a height more than height[l] to the right of l. And for the same reason
    // * when height[r]<=height[l] we can surely say that there is a block to the left of r which is at least of
    // * height[r]. So by traversing these cases and using two pointers approach the time complexity can be decreased
    // * without using extra space
    static int trap3(int[] height){
        int n = height.length;
        int left = 0 , right = n - 1;
        int leftmax = 0 , rightmax = 0;
        int res = 0;
        while (left <= right){
            if (height[left] <= height[right]){
                if (height[left] >= leftmax) leftmax = height[left];
                else res += leftmax - height[left];
                left++;
            } else {
                if (height[right] >= rightmax) rightmax = height[right];
                else res += rightmax - height[right];
                right--;
            }
        }
        return res;
    }
}
