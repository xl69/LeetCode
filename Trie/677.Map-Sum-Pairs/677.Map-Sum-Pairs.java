class MapSum {
    TrieNode root;
    Map<String, Integer> map;
    public MapSum() {
        root = new TrieNode();
        map = new HashMap<>();
    }
    
    public void insert(String key, int val) {
        TrieNode cur = root;
        int lastVal = map.getOrDefault(key, 0);
        for (char c : key.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new TrieNode();
            }
            cur = cur.children[c - 'a'];
            cur.val += val - lastVal;
        }
        map.put(key, val);
    }
    
    public int sum(String prefix) {
        TrieNode cur = root;
        for (char c : prefix.toCharArray()) {
            if (cur.children[c - 'a'] == null) return 0;
            cur = cur.children[c - 'a'];
        }
        return cur.val;
    }
}

class TrieNode {
    TrieNode[] children;
    int lastVal, val;
    public TrieNode() {
        children = new TrieNode[26];
        lastVal = val = 0;
    }
}