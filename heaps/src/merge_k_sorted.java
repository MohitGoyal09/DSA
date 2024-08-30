import java.util.*;
public class merge_k_sorted {
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
    {
        // min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[] a : arr){
            for(int ele : a){
                pq.offer(ele);
            }
        }
        ArrayList<Integer>list = new ArrayList<>(K*K);
        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }
}
