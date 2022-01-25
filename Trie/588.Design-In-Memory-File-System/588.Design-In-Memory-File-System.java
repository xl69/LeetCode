class FileSystem {
    TrieNode root;
    public FileSystem() {
        root = new TrieNode();
    }
    
    public List<String> ls(String path) {
        TrieNode cur = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) cur = cur.children.get(dirs[i]);
        if (cur.content.length() > 0) return new ArrayList<>(Arrays.asList(dirs[dirs.length - 1]));
        return new ArrayList<>(cur.children.keySet());
    }
    
    public void mkdir(String path) {
        TrieNode cur = root;
        String[] dirs = path.split("/");
        for (int i = 1; i < dirs.length; i++) {
            cur.children.putIfAbsent(dirs[i], new TrieNode());
            cur = cur.children.get(dirs[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode cur = root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i++) {
            cur.children.putIfAbsent(dirs[i], new TrieNode());
            cur = cur.children.get(dirs[i]);
        }
        cur.content.append(content);
    }
    
    public String readContentFromFile(String filePath) {
        TrieNode cur = root;
        String[] dirs = filePath.split("/");
        for (int i = 1; i < dirs.length; i++) {
            cur.children.putIfAbsent(dirs[i], new TrieNode());
            cur = cur.children.get(dirs[i]);
        }
        return cur.content.toString();
    }
}

class TrieNode {
    TreeMap<String, TrieNode> children;
    StringBuilder content;
    public TrieNode() {
        children = new TreeMap<>();
        content = new StringBuilder();
    }
}