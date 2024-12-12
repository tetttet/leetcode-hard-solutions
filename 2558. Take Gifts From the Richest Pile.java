class Solution {
    public long pickGifts(int[] g, int k) {
        // Use a custom max heap for processing
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        // Add all elements from the gifts array into the heap
        for (int gift : g) {
            maxHeap.offer(gift);
        }

        // Perform the operation 'k' times
        while (k-- > 0) {
            int largestGift = maxHeap.poll();
            int reducedGift = (int) Math.sqrt(largestGift);
            maxHeap.offer(reducedGift);
        }

        // Calculate the sum of remaining gifts in the heap
        long totalSum = 0;
        while (!maxHeap.isEmpty()) {
            totalSum += maxHeap.poll();
        }

        return totalSum;
    }
}
