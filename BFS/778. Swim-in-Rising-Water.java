class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            if (visited[cur[1]][cur[2]]) continue;
            visited[cur[1]][cur[2]] = true;
            res = Math.max(res, cur[0]);
            if (cur[1] == n - 1 && cur[2] == n - 1) return res;
            for (int[] dir : dirs) {
                int x = cur[1] + dir[0], y = cur[2] + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] == true) continue;
                pq.offer(new int[]{grid[x][y], x, y});
            }
        }
        return -1;
    }
}