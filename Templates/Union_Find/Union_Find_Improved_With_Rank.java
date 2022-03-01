class DSU {
	int[] parent, rank;
	public DSU(int n) {
		parent = new int[n];
		rank = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
		Arrays.fill(rank, 1);
	}
	public int find(int x) {
		if (parent[x] != x) {
			parent[x] = find(parent[x]);
		}
		return parent[x];
	}
	public void union(int x, int y) {
		int rootX = find(x), rootY = find(y);
		if (rootX == rootY) return;
		if (rank[rootX] < rank[rootY]) {
			parent[rootX] = rootY;
		} else if (rank[rootX] > rank[rootY]) {
			parent[rootY] = rootX;
		} else {
			parent[rootX] = rootY;
			rank[rootY]++;
		}
	}
}