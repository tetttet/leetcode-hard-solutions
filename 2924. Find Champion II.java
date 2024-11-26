class Solution {
    public int findChampion(int n, int[][] edges) {
        boolean[] isUndefeated = new boolean[n];
        Arrays.fill(isUndefeated, true);

        // Mark all losers
        for (int[] edge : edges) {
            isUndefeated[edge[1]] = false;
        }

        // Find the champion
        int champion = -1;
        int undefeatedCount = 0;

        for (int team = 0; team < n; team++) {
            if (isUndefeated[team]) {
                undefeatedCount++;
                if (undefeatedCount > 1) {
                    return -1; // More than one undefeated team, no unique champion
                }
                champion = team;
            }
        }

        return undefeatedCount == 1 ? champion : -1;
    }
}
