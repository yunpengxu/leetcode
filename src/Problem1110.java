package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;


public class Problem1110 {
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

  public java.util.List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
    java.util.Map<Integer, TreeNode> val2Node = new HashMap<>();
    java.util.Map<Integer, TreeNode> child2parent = new HashMap<>();
    preorder(root, val2Node, child2parent);
    java.util.Set<Integer> deleteSet = new HashSet<>();
    for(int deleteVal: to_delete) {
      deleteSet.add(deleteVal);
    }

    java.util.List<TreeNode> results = new ArrayList<>();
    for(int nodeVal: to_delete) {
      TreeNode node = val2Node.get(nodeVal);
      if(node.left != null && !deleteSet.contains(node.left.val)) {
        results.add(node.left);
      }
      if(node.right != null && !deleteSet.contains(node.right.val)) {
        results.add(node.right);
      }
      if (child2parent.containsKey(nodeVal)) {
        TreeNode parent = child2parent.get(nodeVal);
        if(parent.left != null && parent.left.val== nodeVal) {
          parent.left = null;
        } else if (parent.right != null && parent.right.val == nodeVal) {
          parent.right = null;
        }
      }
    }
    if(!deleteSet.contains(root.val)) {
      results.add(root);
    }
    return  results;
  }

  private void preorder(TreeNode node, java.util.Map<Integer, TreeNode> val2Node, java.util.Map<Integer, TreeNode> child2parent) {
    if(node!= null){
      val2Node.put(node.val, node);
      if(node.left!= null) {
        child2parent.put(node.left.val, node);
      }
      if(node.right != null) {
        child2parent.put(node.right.val, node);
      }

      preorder(node.left, val2Node, child2parent);
      preorder(node.right, val2Node, child2parent);
    }
  }

  public static void main(String[] args) {
    Problem1110 instance = new Problem1110();
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    node1.left = node2;
    node2.left = node4;
    node2.right = node3;
    instance.delNodes(node1, new int[]{2, 3});
  }
}
