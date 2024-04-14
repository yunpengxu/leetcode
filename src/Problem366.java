package completed;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


public class Problem366 {

   public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
  public List<List<Integer>> findLeaves(TreeNode root) {
    java.util.Map<TreeNode, Integer> depthMap = new java.util.HashMap<>();
    calcDepth(root, depthMap);
    java.util.TreeMap<Integer, List<Integer>> outputMap = new TreeMap<>();
    for(TreeNode node: depthMap.keySet()) {
      int depth = depthMap.get(node);
      if(!outputMap.containsKey(depth)) {
        outputMap.put(depth, new ArrayList<>());
      }
      outputMap.get(depth).add(node.val);
    }
    return new ArrayList<>(outputMap.values());
  }

  private int calcDepth(TreeNode node, java.util.Map<TreeNode, Integer> depthMap) {
    if (node != null) {
      if(node.left == null && node.right == null){
        depthMap.put(node, 1);
        return 1;
      }
      int leftDepth = calcDepth(node.left, depthMap);
      int rightDepth = calcDepth(node.right, depthMap);
      int maxDepth = leftDepth> rightDepth? leftDepth:rightDepth;
      depthMap.put(node, maxDepth+1);
      return maxDepth+1;
    } else {
      return 0;
    }
  }
}
