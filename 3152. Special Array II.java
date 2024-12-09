class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        boolean[] result = new boolean[queries.length];
        int[] prefix = new int[n]; // Tracks alternating parity pairs up to each index

        // Step 1: Build the prefix array
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1];
            if ((nums[i] % 2 != nums[i - 1] % 2)) {
                prefix[i]++;
            }
        }

        // Step 2: Process each query
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            // Check if all pairs within the range have alternating parity
            int alternatingPairs = prefix[right] - prefix[left];
            result[i] = (alternatingPairs == (right - left));
        }

        return result;
    }
}
0