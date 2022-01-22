class Solution {
    public int findCircleNum(int[][] isConnected) {
        DSU dsu = new DSU(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        return dsu.count;
    }
}

class DSU {
    int[] parent, size;
    int count;
    public DSU(int n) {
        count = n;
        parent = new int[n];
        size = new int[n];
        Arrays.fill(size, 1);
        for (int i = 0; i < n; i++) parent[i] = i;
    }
    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x, int y) {
        int rootX = find(x), rootY = find(y);
        if (rootX == rootY) return;
        if (size[rootX] < size[rootY]) {
            size[rootY] += size[rootX];
            parent[rootX] = rootY;
        } else {
            size[rootX] += size[rootY];
            parent[rootY] = rootX;
        }
        count--;
    }
}