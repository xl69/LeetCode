class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, new ArrayList<>(Arrays.asList(0)), 0, graph);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> tmp, int node, int[][] graph) {
        if (node == graph.length - 1) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int next : graph[node]) {
            tmp.add(next);
            dfs(res, tmp, next, graph);
            tmp.remove(tmp.size() - 1);
        }
    }
}