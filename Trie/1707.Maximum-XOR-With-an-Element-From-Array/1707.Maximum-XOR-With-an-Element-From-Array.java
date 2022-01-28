class Solution {
    TrieNode root;
    public int[] maximizeXor(int[] nums, int[][] queries) {
        root = new TrieNode();
        int[] res = new int[queries.length];
        for (int num : nums) insert(num);
        for (int i = 0; i < res.length; i++) {
            res[i] = search(queries[i]);
        }
        return res;
    }
    private void insert(int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            if (node.children[curBit] == null) node.children[curBit] = new TrieNode();
            node = node.children[curBit];
        }
    }
    private int search(int[] query) {
        TrieNode node = root;
        int x = query[0], limit = query[1];
        int i = 31;
        while ((1 >> i & 1) == 0) i--;
        for (; i >= 0; i--) {
            
        }
        return i;
    }
}

class TrieNode {
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[2];
    }
}