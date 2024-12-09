class Solution {
    public int findTheLongestSubstring(String s) {
        // Map to store the first occurrence of each state
        HashMap<Integer, Integer> stateMap = new HashMap<>();
        stateMap.put(0, -1); // Initial state: all vowels are even

        int state = 0; // Bitmask to track vowel counts
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // Update the state if the current character is a vowel
            if ("aeiou".indexOf(ch) != -1) {
                state ^= (1 << ("aeiou".indexOf(ch)));
            }

            // Check if the current state has been seen before
            if (stateMap.containsKey(state)) {
                maxLength = Math.max(maxLength, i - stateMap.get(state));
            } else {
                stateMap.put(state, i);
            }
        }

        return maxLength;
    }
}
