class Solution {
    TrieNode root;
    public List<String> wordBreak(String s, List<String> wordDict) {
        root = new TrieNode();
        for (String word : wordDict) insert(word);
        List<String> res = new ArrayList<>();
        dfs(res, s, new StringBuilder(), 0, new boolean[s.length()]);
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
    private boolean dfs(List<String> res, String s, StringBuilder sb, int index, boolean[] visited) {
        if (visited[index]) return false;
        TrieNode cur = root;
        boolean flag = false;
        for (int i = index; i < s.length(); i++) {
            if (cur.children[s.charAt(i) - 'a'] == null) break;
            cur = cur.children[s.charAt(i) - 'a'];
            sb.append(s.charAt(i));
            if (cur.isWord) {
                if (i == s.length() - 1) {
                    res.add(sb.toString());
                    flag = true;
                } else {
                    int len = sb.length();
                    sb.append(" ");
                    if (dfs(res, s, sb, i + 1, visited)) {
                        flag = true;
                    }
                    sb.setLength(len);
                }
            }
        }
        if (flag == false) visited[index] = true;
        return flag;
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