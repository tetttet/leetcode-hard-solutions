class Solution {
    public long findScore(int[] nums) {
        int n = nums.length;

        // Create an array of indices
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        // Sort indices based on the values in nums, breaking ties by index
        Arrays.sort(indices, (a, b) -> {
            if (nums[a] != nums[b]) {
                return Integer.compare(nums[a], nums[b]);
            }
            return Integer.compare(a, b);
        });

        // Mark array to track visited positions
        boolean[] visited = new boolean[n];
        long score = 0;

        // Traverse sorted indices and calculate the score
        for (int idx : indices) {
            if (visited[idx]) continue;

            // Add the value to the score and mark neighbors as visited
            score += nums[idx];
            visited[idx] = true;
            if (idx > 0) visited[idx - 1] = true;
            if (idx < n - 1) visited[idx + 1] = true;
        }

        return score;
    }
}
