class Solution {
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