class Solution {
    TrieNode root;
    public boolean wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for (String word : wordDict) {
            insert(word);
        }
        return dfs(s, 0, new boolean[s.length()]);
    }
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    private boolean dfs(String s, int index, boolean[] visited) {
        if (index == s.length()) return true;
        if (visited[index]) return false;
        TrieNode cur = root;
        for (int i = index; i < s.length(); i++) {
            if (cur.children[s.charAt(i) - 'a'] == null) break;
            cur = cur.children[s.charAt(i) - 'a'];
            if (cur.isWord && dfs(s, i + 1, visited)) {
                return true;
            }
        }
        visited[index] = true;
        return false;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}