class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int[] t : times) {
            if (graph[t[0]] == null) graph[t[0]] = new ArrayList<>();
            graph[t[0]].add(new int[]{t[1], t[2]});
        }
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[1]]) continue;
            visited[cur[1]] = true;
            n--;
            if (n == 0) return cur[0];
            if (graph[cur[1]] == null) continue;
            for (int[] next : graph[cur[1]]) {
                if (visited[next[0]]) continue;
                pq.offer(new int[]{cur[0] + next[1], next[0]});
            }
        }
        return -1;
    }
}