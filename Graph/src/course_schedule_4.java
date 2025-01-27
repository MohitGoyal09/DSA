import java.util.*;
public class course_schedule_4 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            adj.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        Map<Integer, Set<Integer>> mp = new HashMap<>();
        for(int i = 0; i < numCourses; i++) {
            mp.put(i, new HashSet<>());
        }

        while(!q.isEmpty()) {
            int curr = q.poll();
            for(int next : adj.get(curr)) {
                mp.get(next).add(curr);
                mp.get(next).addAll(mp.get(curr));
                indegree[next]--;
                if(indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(mp.get(query[1]).contains(query[0]));
        }
        return res;
    }
}
