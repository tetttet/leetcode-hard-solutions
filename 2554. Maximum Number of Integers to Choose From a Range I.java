class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        // Use a set to mark banned numbers for faster lookup
        Set<Integer> bannedSet = new HashSet<>();
        for (int num : banned) {
            bannedSet.add(num);
        }

        int count = 0;  // Tracks the number of selected integers
        int currentSum = 0; // Tracks the sum of selected integers

        for (int i = 1; i <= n; i++) {
            if (bannedSet.contains(i)) {
                continue; // Skip if the number is banned
            }

            if (currentSum + i > maxSum) {
                break; // Stop if adding the number exceeds maxSum
            }

            currentSum += i;
            count++;
        }

        return count;
    }
}
