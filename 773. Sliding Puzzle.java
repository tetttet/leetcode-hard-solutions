class Solution {
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        String start = "";
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                start += board[i][j];
            }
        }
        if (start.equals(target)) {
            return 0;
        }
        int[][] neighbor = new int[][]{{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return step;
                }
                int zero = cur.indexOf('0');
                for (int next : neighbor[zero]) {
                    String nextStr = swap(cur, zero, next);
                    if (!visited.contains(nextStr)) {
                        queue.offer(nextStr);
                        visited.add(nextStr);
                    }
                }
            }
            step++;
        }
        return -1;   
    }
}