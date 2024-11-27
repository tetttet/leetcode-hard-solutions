class Solution {
    private void propagateDistances(List<List<Integer>> graph, int node, int[] distances) {
        int updatedDistance = distances[node] + 1;

        for (int neighbor : graph.get(node)) {
            if (distances[neighbor] > updatedDistance) {
                distances[neighbor] = updatedDistance;
                propagateDistances(graph, neighbor, distances);
            }
        }
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Initialize distances and graph
        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = n - 1 - i;
        }

        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i + 1 < n; i++) {
            adjacencyList.get(i + 1).add(i);
        }

        // Process queries and update distances
        int[] result = new int[queries.length];
        int resultIndex = 0;

        for (int[] query : queries) {
            int source = query[0];
            int target = query[1];

            adjacencyList.get(target).add(source);
            distances[source] = Math.min(distances[source], distances[target] + 1);
            propagateDistances(adjacencyList, source, distances);

            result[resultIndex++] = distances[0];
        }

        return result;
    }
}
