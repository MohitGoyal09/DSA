public class container_with_most_water {
    public int maxArea(int[] height) {
        int left = 0 ;
        int right = height.length - 1;
        int res = 0;
        while ( left < right){
            int container = right - left;
            int area = container * Math.min(height[right] , height[left]);
            res = Math.max(res , area);
            if (height[left] < height[right]){
                left++;
            } else {
                right--;
            }
        }
        return res;
    }
}

