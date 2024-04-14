package completed;

import completed.Problem865;


public class Problem1123 {
  static public class TreeNode {
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

  private boolean isSame(java.util.List<TreeNode> nodes) {
      for(int i =1; i< nodes.size();i++) {
        if(nodes.get(0) != nodes.get(i)) {
          return false;
        }
      }
      return true;
  }

  private void preorder(TreeNode node,
      int depth,
      java.util.TreeMap<Integer, java.util.List<TreeNode>> depthMap,
      java.util.Map<TreeNode, TreeNode> child2parent) {
      if(node != null) {
        if(!depthMap.containsKey(depth)) {
          depthMap.put(depth, new java.util.ArrayList<>());
        }
        depthMap.get(depth).add(node);
        preorder(node.left, depth+1, depthMap, child2parent);
        if(node.left!= null) {
          child2parent.put(node.left, node);
        }
        preorder(node.right, depth+1, depthMap, child2parent);
        if(node.right!= null) {
          child2parent.put(node.right, node);
        }
      }
  }

  public TreeNode lcaDeepestLeaves(TreeNode root) {
    java.util.Map<TreeNode, TreeNode> child2parent = new java.util.HashMap<>();
    java.util.TreeMap<Integer, java.util.List<TreeNode>> depthMap = new java.util.TreeMap<>();
    preorder(root, 0, depthMap, child2parent);
    java.util.List<TreeNode> deepNodes = depthMap.lastEntry().getValue();
    while(!isSame(deepNodes)) {
      for(int i =0;i< deepNodes.size();i++) {
        deepNodes.set(i, child2parent.get(deepNodes.get(i)));
      }
    }
    return deepNodes.get(0);
  }
}
