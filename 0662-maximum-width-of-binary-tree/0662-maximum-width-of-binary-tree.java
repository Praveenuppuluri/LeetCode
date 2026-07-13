import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        TreeNode node;
        int index;
        Pair(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int maxWidth = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().index;
            int first = 0;
            int last = 0;
            
            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int currentIndex = current.index - minIndex;
                
                if (i == 0) {
                    first = currentIndex;
                }
                if (i == size - 1) {
                    last = currentIndex;
                }
                
                if (current.node.left != null) {
                    queue.offer(new Pair(current.node.left, currentIndex * 2));
                }
                if (current.node.right != null) {
                    queue.offer(new Pair(current.node.right, currentIndex * 2 + 1));
                }
            }
            maxWidth = Math.max(maxWidth, last - first + 1);
        }
        
        return maxWidth;
    }
}