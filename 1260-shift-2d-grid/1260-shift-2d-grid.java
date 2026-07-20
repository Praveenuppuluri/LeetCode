import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;
        
        // Normalize k to avoid unnecessary full rotations
        k = k % total;
        
        List<List<Integer>> result = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                // Calculate the 1D index in the new grid
                int new1DIndex = i * n + j;
                
                // Find where the element originally came from
                int old1DIndex = (new1DIndex - k + total) % total;
                
                // Convert the 1D index back to 2D coordinates
                int oldRow = old1DIndex / n;
                int oldCol = old1DIndex % n;
                
                row.add(grid[oldRow][oldCol]);
            }
            result.add(row);
        }
        
        return result;
    }
}