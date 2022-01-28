class Solution {
    TrieNode root = new TrieNode();
    String res = "";
    public String longestWord(String[] words) {
        for (String word : words) insert(word);
        dfs(root, new StringBuilder());
        return res;
    }
    private void dfs(TrieNode node, StringBuilder sb) {
        if (sb.length() > res.length()) res = sb.toString();
        for (char c = 'a'; c <= 'z'; c++) {
            if (node.children[c - 'a'] == null || !node.children[c - 'a'].isWord) continue;
            sb.append(c);
            dfs(node.children[c - 'a'], sb);
            sb.deleteCharAt(sb.length() - 1);
        }
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
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }
}