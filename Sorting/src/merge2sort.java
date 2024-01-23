import java.util.*;
// ! https://leetcode.com/problems/merge-sorted-array/submissions/1154481360/
public class merge2sort {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 6, 8 , 9};
        int[] arr2 = { 1, 4, 5, 7};

    }


        public void merge(int[] nums1, int m, int[] nums2, int n) {
            ArrayList<Integer>arr=new ArrayList<>();
            int i=0,j=0;
            while(i<m && j<n){
                if(nums1[i]<nums2[j]){
                    arr.add(nums1[i]);
                    i++;
                }
                else{
                    arr.add(nums2[j]);
                    j++;
                }
            }
            while(i<m){
                arr.add(nums1[i]);
                i++;
            }
            while(j<n){
                arr.add(nums2[j]);
                j++;
            }
            for(i=0;i<m+n;i++){
                nums1[i]=arr.get(i);
            }
        }

}
