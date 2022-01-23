class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] ps, int[][] qs) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] indegrees = new int[numCourses];
        for (int[] p : ps) {
            if (graph[p[0]] == null) graph[p[0]] = new ArrayList<>();
            graph[p[0]].add(p[1]);
            indegrees[p[1]]++;
        }
        Set<Integer>[] preSet = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            preSet[i] = new HashSet<>();
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                preSet[cur].add(cur);
                if (graph[cur] == null) continue;
                for (int next : graph[cur]) {
                    preSet[next].addAll(preSet[cur]);
                    indegrees[next]--;
                    if (indegrees[next] == 0) {
                        q.offer(next);
                    }
                }
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < qs.length; i++) {
            res.add(preSet[qs[i][1]].contains(qs[i][0]));
        }
        return res;
    }
}