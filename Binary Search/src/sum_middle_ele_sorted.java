public class sum_middle_ele_sorted {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        int n1=arr1.length;
        int n2=arr2.length;
        int l=0;
        int h=n1;
        while(l<=h){
            int l1=Integer.MIN_VALUE, l2=Integer.MIN_VALUE;
            int r1=Integer.MAX_VALUE, r2=Integer.MAX_VALUE;

            int mid1=(l+h)>>1;
            int mid2=n2-mid1;

            if(mid1<n1)r1=arr1[mid1];
            if(mid2<n2)r2=arr2[mid2];

            if(mid1-1>=0)l1=arr1[mid1-1];
            if(mid2-1>=0)l2=arr2[mid2-1];

            if(l1<=r2 && l2<=r1 ){
                return Math.max(l1,l2)+Math.min(r1,r2);
            }
            else if(l2>r1){
                l=mid1+1;
            }else{
                h=mid1-1;
            }
        }
        return 0;
    }
}
