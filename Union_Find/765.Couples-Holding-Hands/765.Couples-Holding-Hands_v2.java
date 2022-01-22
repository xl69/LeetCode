class Solution {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        DSU dsu = new DSU(n);
        for (int i = 0; i < n; i += 2) {
            dsu.union(i, i + 1);
            dsu.union(row[i], row[i + 1]);
        }
        return n / 2 - dsu.count;
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