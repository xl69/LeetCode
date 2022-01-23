class Solution {
    public int minimumSemesters(int n, int[][] rs) {
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegrees = new int[n + 1];
        for (int[] r : rs) {
            if (graph[r[0]] == null) graph[r[0]] = new ArrayList<>();
            graph[r[0]].add(r[1]);
            indegrees[r[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0, courses = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                courses++;
                if (graph[cur] == null) continue;
                for (int next : graph[cur]) {
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            count++;
        }
        return courses == n ? count : -1;
    }
}