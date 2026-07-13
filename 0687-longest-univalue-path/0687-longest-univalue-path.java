class Solution {
    private int maxLength;

    public int longestUnivaluePath(TreeNode root) {
        maxLength = 0;
        dfs(root);
        return maxLength;
    }

    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int leftArrow = 0;
        int rightArrow = 0;

        if (node.left != null && node.left.val == node.val) {
            leftArrow = left + 1;
        }
        
        if (node.right != null && node.right.val == node.val) {
            rightArrow = right + 1;
        }

        maxLength = Math.max(maxLength, leftArrow + rightArrow);

        return Math.max(leftArrow, rightArrow);
    }
}
