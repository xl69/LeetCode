class Solution {
    public int maxPoints(int[][] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j == i) continue;
                int key = asFraction(points[j][0] - points[i][0], points[j][1] - points[i][1]);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int max = 0;
            for (int fre : map.values()) max = Math.max(max, fre);
            res = Math.max(res, max + 1);
        }
        return res;
    }
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    private int asFraction(int a, int b) {
        int gcd = gcd(a, b);
        return (a / gcd) * 31 + (b / gcd);
    }
}