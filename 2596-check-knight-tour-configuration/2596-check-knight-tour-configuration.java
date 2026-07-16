class Solution {
    public boolean checkValidGrid(int[][] grid) {
        // The knight must start at the top-left cell
        if (grid[0][0] != 0) {
            return false;
        }
        
        int n = grid.length;
        // Array to store the [row, col] of each step from 0 to n*n - 1
        int[][] pos = new int[n * n][2];
        
        // Populate the positions array
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                pos[grid[r][c]][0] = r;
                pos[grid[r][c]][1] = c;
            }
        }
        
        // Verify each move
        for (int i = 1; i < n * n; i++) {
            int[] curr = pos[i];
            int[] prev = pos[i - 1];
            
            int dr = Math.abs(curr[0] - prev[0]);
            int dc = Math.abs(curr[1] - prev[1]);
            
            // A valid knight move is either (2, 1) or (1, 2)
            if (!((dr == 2 && dc == 1) || (dr == 1 && dc == 2))) {
                return false;
            }
        }
        
        return true;
    }
}