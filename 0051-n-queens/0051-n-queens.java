import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        
        // Initialize an empty board
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        
        // Trackers for columns and diagonals
        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n - 1]; // row + col
        boolean[] negDiag = new boolean[2 * n - 1]; // row - col + (n - 1)
        
        backtrack(0, board, result, cols, posDiag, negDiag, n);
        return result;
    }
    
    private void backtrack(int row, char[][] board, List<List<String>> result, 
                           boolean[] cols, boolean[] posDiag, boolean[] negDiag, int n) {
        // Base case: If we've successfully placed n queens, add the board to results
        if (row == n) {
            result.add(construct(board));
            return;
        }
        
        // Try placing a queen in each column of the current row
        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col + n - 1; 
            
            // If the cell is under attack, skip it
            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue; 
            }
            
            // Place the queen and mark the paths as attacked
            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;
            
            // Recurse to the next row
            backtrack(row + 1, board, result, cols, posDiag, negDiag, n);
            
            // Backtrack: Remove the queen and unmark the paths
            board[row][col] = '.';
            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }
    
    // Helper method to convert the char[][] board into a List<String>
    private List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(new String(board[i]));
        }
        return res;
    }
}