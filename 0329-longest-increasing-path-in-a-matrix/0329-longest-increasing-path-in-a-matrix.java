class Solution {
    // Array to help navigate in 4 directions: Right, Down, Left, Up
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int longestPath = 0;
        
        // Try starting a path from every single cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int pathLength = dfs(matrix, i, j, memo);
                longestPath = Math.max(longestPath, pathLength);
            }
        }
        
        return longestPath;
    }
    
    private int dfs(int[][] matrix, int r, int c, int[][] memo) {
        // If we already calculated the longest path from this cell, return it
        if (memo[r][c] != 0) {
            return memo[r][c];
        }
        
        int maxPath = 1; // The minimum path length is 1 (the cell itself)
        
        // Explore all 4 neighboring directions
        for (int[] dir : DIRS) {
            int newRow = r + dir[0];
            int newCol = c + dir[1];
            
            // Check boundaries and ensure the next cell is strictly greater
            if (newRow >= 0 && newRow < matrix.length && 
                newCol >= 0 && newCol < matrix[0].length && 
                matrix[newRow][newCol] > matrix[r][c]) {
                
                // Recursively call DFS and keep track of the maximum path length
                maxPath = Math.max(maxPath, 1 + dfs(matrix, newRow, newCol, memo));
            }
        }
        
        // Cache the result before returning
        memo[r][c] = maxPath;
        return maxPath;
    }
}