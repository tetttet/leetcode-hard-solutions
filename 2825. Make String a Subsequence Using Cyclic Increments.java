class Solution {
    public boolean canMakeSubsequence(String source, String target) {
        int tIndex = 0, tLength = target.length();
        
        for (int sIndex = 0; sIndex < source.length(); sIndex++) {
            char sourceChar = source.charAt(sIndex);
            if (tIndex < tLength) {
                char targetChar = target.charAt(tIndex);
                int difference = (targetChar - sourceChar + 26) % 26;
                if (difference == 0 || difference == 1) {
                    tIndex++;
                }
            }
        }
        
        return tIndex == tLength;
    }
}
