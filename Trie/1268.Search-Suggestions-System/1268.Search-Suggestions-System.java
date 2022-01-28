class Solution {
    TrieNode root;
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        for (String word : products) insert(word);
        List<List<String>> res = new ArrayList<>();
        TrieNode cur = root;
        StringBuilder sb = new StringBuilder();
        for (char c : searchWord.toCharArray()) {
            sb.append(c);
            cur = cur.children[c - 'a'];
            List<String> tmp = new ArrayList<>();
            if (cur == null) {
                for (int i = 0; i <= searchWord.length() - sb.length(); i++) res.add(tmp);
                break;
            }
            dfs(tmp, sb, cur);
            res.add(tmp);
        }
        return res;
    }
    
    private void dfs(List<String> tmp, StringBuilder sb, TrieNode cur) {
        for (int i = 0; i < cur.count; i++) {
            tmp.add(sb.toString());
            if (tmp.size() == 3) return;
        }
        for (char c = 'a'; c <= 'z'; c++) {
            if (cur.children[c - 'a'] == null) continue;
            sb.append(c);
            dfs(tmp, sb, cur.children[c - 'a']);
            sb.deleteCharAt(sb.length() - 1);
            if (tmp.size() == 3) break;
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
        node.count++;
    }
}

class TrieNode {
    TrieNode[] children;
    int count;
    public TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
}