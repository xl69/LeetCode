class Solution {
    TrieNode root;
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new TrieNode();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() > 0 && dfs(word, 0, new boolean[word.length()])) {
                res.add(word);
            }
            insert(word);
        }
        return res;
    }
    private void insert(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }
    private boolean dfs(String word, int index, boolean[] visited) {
        if (index == word.length()) return true;
        if (visited[index]) return false;
        TrieNode cur = root;
        for (int i = index; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) break;
            cur = cur.children[word.charAt(i) - 'a'];
            if (cur.isWord && dfs(word, i + 1, visited)) return true;
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
        isWord = false;
    }
}