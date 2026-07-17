import java.util.PriorityQueue;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];
        int cost = 0;
        int edges = 0;
        
        pq.offer(new int[]{0, 0});
        
        while (edges < n) {
            int[] curr = pq.poll();
            int weight = curr[0];
            int node = curr[1];
            
            if (visited[node]) continue;
            
            visited[node] = true;
            cost += weight;
            edges++;
            
            for (int nextNode = 0; nextNode < n; nextNode++) {
                if (!visited[nextNode]) {
                    int nextWeight = Math.abs(points[node][0] - points[nextNode][0]) + 
                                     Math.abs(points[node][1] - points[nextNode][1]);
                    pq.offer(new int[]{nextWeight, nextNode});
                }
            }
        }
        
        return cost;
    }
}