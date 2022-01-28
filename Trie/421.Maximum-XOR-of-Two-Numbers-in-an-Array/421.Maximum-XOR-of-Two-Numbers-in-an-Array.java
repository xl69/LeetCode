class Solution {
    TrieNode root;
    public int findMaximumXOR(int[] nums) {
        root = new TrieNode();
        int res = 0;
        for (int num : nums) insert(num);
        for (int num : nums) res = Math.max(res, search(num));
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
    private int search(int num) {
        TrieNode node = root;
        int sum = 0;
        for (int i = 31; i >= 0; i--) {
            int curBit = (num >> i) & 1;
            int choice = curBit ^ 1;
            if (node.children[choice] == null) {
                node = node.children[curBit];
            } else {
                sum += (1 << i);
                node = node.children[choice];
            }
        }
        return sum;
    }
}

class TrieNode {
    TrieNode[] children;
    public TrieNode() {
        children = new TrieNode[2];
    }
}