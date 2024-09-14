public class xor_quries_subarray {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int CumXor[] = new int[n];
        CumXor[0] = arr[0];
        for (int i = 1 ; i < n  ;i++){
            CumXor[i] = CumXor[i-1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for ( int i = 0 ; i < queries.length ; i++){
            int L = queries[i][0];
            int R = queries[i][1];
            result[i] = CumXor[R] ^ (L == 0 ? 0 : CumXor[L-1]);
        }
        return result;
    }
}
