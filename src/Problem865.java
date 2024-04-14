package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;


public class Problem865 {

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

  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    java.util.Map<TreeNode, TreeNode> child2parent = new HashMap<>();
    java.util.TreeMap<Integer, java.util.List<TreeNode>> depthMap = new TreeMap<>();
    preorder(root, 0, depthMap, child2parent);
    java.util.List<TreeNode> deepNodes = depthMap.lastEntry().getValue();
    while(!isSame(deepNodes)) {
      for(int i =0;i< deepNodes.size();i++) {
        deepNodes.set(i, child2parent.get(deepNodes.get(i)));
      }
    }
    return deepNodes.get(0);
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
          depthMap.put(depth, new ArrayList<>());
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

  public static void main(String[] args) {
      Problem865 instance = new Problem865();
      TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    node3.left = node5;
    node3.right = node1;
    node5.left = node6;
    node5.right = node2;
    node2.left = node7;
    node2.right = node4;
    node1.left = node0;
    node1.right = node8;

    instance.subtreeWithAllDeepest(node3);
  }
}
