class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> count = new HashMap<>();
        for (String word : s1.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        for (String word : s2.split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        List<String> uncommon = new ArrayList<>();
        for (String word : count.keySet()) {
            if (count.get(word) == 1) {
                uncommon.add(word);
            }
        }
        
        return uncommon.toArray(new String[uncommon.size()]);       
    }
}