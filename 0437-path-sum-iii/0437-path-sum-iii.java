import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumMap);
    }
    
    private int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }
        
        currentSum += node.val;
        int numPathsToCurr = prefixSumMap.getOrDefault(currentSum - targetSum, 0);
        
        prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        
        int result = numPathsToCurr 
                   + dfs(node.left, currentSum, targetSum, prefixSumMap) 
                   + dfs(node.right, currentSum, targetSum, prefixSumMap);
        
        prefixSumMap.put(currentSum, prefixSumMap.get(currentSum) - 1);
        
        return result;
    }
}