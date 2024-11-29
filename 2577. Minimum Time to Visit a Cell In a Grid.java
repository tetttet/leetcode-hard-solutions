class Solution {
public:
    int minimumTime(vector<vector<int>>& grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) 
            return -1; // Early termination if immediate neighbors are inaccessible.

        int rows = grid.size();
        int cols = grid[0].size();

        using Node = pair<int, pair<int, int>>; // Format: {time, {row, col}}
        priority_queue<Node, vector<Node>, greater<Node>> minHeap;

        // Initialize with the starting point.
        minHeap.push({0, {0, 0}});
        
        // Track visited cells to prevent redundant processing.
        vector<vector<int>> visited(rows, vector<int>(cols, 0));
        visited[0][0] = 1;

        // Define possible moves: right, left, down, up.
        vector<pair<int, int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!minHeap.empty()) {
            auto [currTime, position] = minHeap.top();
            minHeap.pop();

            int currRow = position.first;
            int currCol = position.second;

            // If we've reached the bottom-right cell, return the time.
            if (currRow == rows - 1 && currCol == cols - 1) 
                return currTime;

            for (auto [dx, dy] : directions) {
                int nextRow = currRow + dx;
                int nextCol = currCol + dy;

                // Ensure the next cell is within bounds and not visited.
                if (nextRow >= 0 && nextCol >= 0 && nextRow < rows && nextCol < cols && !visited[nextRow][nextCol]) {
                    // Compute the wait time if needed to ensure valid traversal.
                    int waitTime = ((grid[nextRow][nextCol] - currTime) % 2 == 0) ? 1 : 0;
                    int nextTime = max(currTime + 1, grid[nextRow][nextCol] + waitTime);

                    // Push the next state into the priority queue.
                    minHeap.push({nextTime, {nextRow, nextCol}});
                    visited[nextRow][nextCol] = 1;
                }
            }
        }

        return -1; // If no path to the destination is found.
    }
};
