class Solution {
    public boolean isValidBST(TreeNode root) {
        // Use Long.MIN_VALUE and Long.MAX_VALUE to handle edge cases 
        // where a node's value is exactly Integer.MIN_VALUE or Integer.MAX_VALUE.
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean validate(TreeNode node, long min, long max) {
        // An empty node is valid
        if (node == null) {
            return true;
        }

        // The current node's value must fall strictly inside the allowed range
        if (node.val <= min || node.val >= max) {
            return false;
        }

        // Recursively validate the left and right subtrees.
        // For the left subtree, the max value becomes the current node's value.
        // For the right subtree, the min value becomes the current node's value.
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}