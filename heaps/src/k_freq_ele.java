import java.util.*;
public class k_freq_ele {
    public int[] topKFrequent(int[] nums, int k) {
        int res[] = new int[k];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for(int key : map.keySet()){
            minHeap.add(key);
        }

        for(int i = 0; i < k; i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}
