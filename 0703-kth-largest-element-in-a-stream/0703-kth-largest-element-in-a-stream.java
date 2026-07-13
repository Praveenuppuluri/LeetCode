import java.util.PriorityQueue;

class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        // Initialize the min-heap
        this.minHeap = new PriorityQueue<>();
        
        // Add existing numbers to the heap
        for (int num : nums) {
            add(num);
        }
    }
    
    public int add(int val) {
        // Add the new value to the heap
        minHeap.offer(val);
        
        // If the heap size exceeds k, remove the smallest element
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        
        // The root of the min-heap is the kth largest element
        return minHeap.peek();
    }
}