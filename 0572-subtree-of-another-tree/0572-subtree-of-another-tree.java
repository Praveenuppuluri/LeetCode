class Solution {
    // This is the main method LeetCode calls
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // This is the helper method used by the main method above
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case 1: If both trees are empty, they are the same.
        if (p == null && q == null) {
            return true;
        }
        
        // Base case 2: If only one tree is empty, or the values don't match, they are different.
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        
        // Recursive step: Check if both left subtrees and right subtrees are identical.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}