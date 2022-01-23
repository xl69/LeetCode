class Solution {
    public boolean canFinish(int numCourses, int[][] ps) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];
        for (int[] p : ps) {
            if (graph[p[1]] == null) graph[p[1]] = new ArrayList<>();
            graph[p[1]].add(p[0]);
            indegrees[p[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                count++;
                if (graph[cur] == null) continue;
                for (int next : graph[cur]) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return count == numCourses;
    }
}