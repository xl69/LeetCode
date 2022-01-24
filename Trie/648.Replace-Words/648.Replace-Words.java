class Solution {
    TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        root = new TrieNode();
        for (String r : dictionary) insert(r);
        StringBuilder res = new StringBuilder();
        for (String word : sentence.split(" ")) {
            res.append(search(word, new StringBuilder()));
            res.append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
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
    private String search(String word, StringBuilder sb) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return word;
            node = node.children[c - 'a'];
            sb.append(c);
            if (node.isWord) return sb.toString();
        }
        return word;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean isWord;
    public TrieNode() {
        children = new TrieNode[26];
    }
}