import java.util.*;
public class DisjointSet {
      List<Integer> rank = new ArrayList<>();
      List<Integer> parent = new ArrayList<>();
      List<Integer> size = new ArrayList<>();

      public DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                  parent.add(i);
                  rank.add(0);
                  size.add(1);
            }
      }

      public int findUPar(int node) {
            if (parent.get(node) == node) {
                  return node;
            }
           int ulp = findUPar(parent.get(node));
            parent.set(node , ulp);
            return parent.get(node);
      }
      public void unionByRank(int u , int v){
          int ulp_u = findUPar(u);
          int ulp_v = findUPar(v);
          if (ulp_v == ulp_u) return;
          if (rank.get(ulp_u) < rank.get(ulp_v)){
              parent.set(ulp_u , ulp_v);
          } else if (rank.get(ulp_v) < rank.get(ulp_u)){
              parent.set(ulp_v , ulp_u);
          } else {
              parent.set(ulp_v , ulp_u);
              rank.set(ulp_u , rank.get(ulp_u) + 1);
          }


      }
    public void unionBySize(int u , int v) {
        int ulp_u = findUPar(u);
        int ulp_v = findUPar(v);
        if (ulp_v == ulp_u) return;
        if (size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
        }
    }
    class GfG
    {
        int find(int[] parent, int node)
        {
            //add code here
            if (parent[node] == node) {
                return node;
            }
            int ulp = find(parent,parent[node]);
            parent[node] =  ulp;
            return parent[node];
        }
        void unionSet(int[] parent, int u, int v)
        {
            //add code here.
            int ulp_u = find(parent,u);
            int ulp_v = find(parent,v);
            if (ulp_v == ulp_u) return;
            else {
                parent[ulp_u] = ulp_v;
            }
        }
    }
}
