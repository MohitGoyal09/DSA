import java.util.*;
public class coruse_shedulle {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prereq : prerequisites) {
            adj.get(prereq[1]).add(prereq[0]);
        }

        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return count == numCourses;
    }

    // ! Course Shedule 2
    class Solution6 {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            // Form a graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adj.add(new ArrayList<>());
            }
            for (int[] prereq : prerequisites) {
                adj.get(prereq[1]).add(prereq[0]);
            }

            int[] indegree = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                for (int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
            int n = numCourses;
            int topo[] = new int[n];
            int ind = 0;
            while (!q.isEmpty()) {
                int node = q.poll();
                topo[ind++] = node;
                for (int it : adj.get(node)) {
                    indegree[it]--;
                    if (indegree[it] == 0) q.add(it);
                }
            }

            if (ind == n) return topo;
            int[] arr = {};
            return arr;
        }
    }
}
