class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        int[] count = new int[26];
        for (String str : strs) {
            Arrays.fill(count, 0);
            for (char c : str.toCharArray()) count[c - 'a']++;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) sb.append(count[i]).append('#');
            String key = sb.toString();
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}