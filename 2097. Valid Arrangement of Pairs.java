import java.util.*;

class Solution {
    public int[][] validArrangement(int[][] pairs) {
        // Adjacency list for the graph and degree map
        Map<Integer, Queue<Integer>> adjacencyList = new HashMap<>();
        Map<Integer, Integer> degreeMap = new HashMap<>();

        // Build the graph and calculate degrees
        for (int[] pair : pairs) {
            int from = pair[0], to = pair[1];
            adjacencyList.computeIfAbsent(from, k -> new LinkedList<>()).offer(to);
            degreeMap.put(from, degreeMap.getOrDefault(from, 0) + 1);  // Increment out-degree
            degreeMap.put(to, degreeMap.getOrDefault(to, 0) - 1);     // Decrement in-degree
        }

        // Determine the starting node
        int startNode = pairs[0][0];
        for (int node : degreeMap.keySet()) {
            if (degreeMap.get(node) == 1) {
                startNode = node;
                break;
            }
        }

        // Use a stack to perform iterative DFS
        LinkedList<int[]> resultPath = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);

        while (!stack.isEmpty()) {
            int current = stack.peek();
            Queue<Integer> neighbors = adjacencyList.getOrDefault(current, new LinkedList<>());

            if (!neighbors.isEmpty()) {
                stack.push(neighbors.poll()); // Traverse to the next neighbor
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    resultPath.addFirst(new int[]{stack.peek(), current}); // Add edge in reverse
                }
            }
        }

        // Convert the result to int[][]
        return resultPath.toArray(new int[resultPath.size()][]);
    }
}
