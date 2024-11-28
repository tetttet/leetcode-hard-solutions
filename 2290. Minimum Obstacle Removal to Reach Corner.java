class Solution {
    public int minimumObstacles(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int[][] distances = new int[rows][cols];
        for (int[] row : distances) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> deque = new ArrayDeque<>();
        distances[0][0] = 0;
        deque.addFirst(new int[]{0, 0});

        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int x = current[0], y = current[1];

            for (int[] direction : directions) {
                int newX = x + direction[0], newY = y + direction[1];

                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int newDistance = distances[x][y] + grid[newX][newY];

                    if (newDistance < distances[newX][newY]) {
                        distances[newX][newY] = newDistance;

                        if (grid[newX][newY] == 0) {
                            deque.addFirst(new int[]{newX, newY});
                        } else {
                            deque.addLast(new int[]{newX, newY});
                        }
                    }
                }
            }
        }

        return distances[rows - 1][cols - 1];
    }
}
