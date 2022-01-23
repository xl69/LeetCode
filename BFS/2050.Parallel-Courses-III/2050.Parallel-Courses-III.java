class Solution {
    public int minimumTime(int n, int[][] rs, int[] time) {
        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indegrees = new int[n + 1], t = new int[n + 1];
        for (int[] r : rs) {
            if (graph[r[0]] == null) graph[r[0]] = new ArrayList<>();
            graph[r[0]].add(r[1]);
            indegrees[r[1]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (indegrees[i] == 0) {
                t[i] = time[i - 1];
                q.offer(i);
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                res = Math.max(res, t[cur]);
                if (graph[cur] == null) continue;
                for (int next : graph[cur]) {
                    t[next] = Math.max(t[next], t[cur] + time[next - 1]);
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        return res;
    }
}