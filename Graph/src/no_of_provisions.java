public class no_of_provisions {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0 ;
        for (int i = 0 ; i < n ; i++){
            if (!visited[i]){
                dfs(isConnected , visited , i);
                count++;
            }
        }
        return count;
    }
    private void dfs(int[][] m , boolean[] visited , int i ){
        visited[i] = true;
        for (int j = 0 ; j < m.length ; j++){
            if (m[i][j]  == 1 && !visited[j]){
                dfs(m , visited , j);
            }
        }
    }
}
