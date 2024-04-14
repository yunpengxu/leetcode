package completed;

import java.util.ArrayList;
import java.util.LinkedList;


public class Problem515 {

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

  public java.util.List<Integer> largestValues(TreeNode root) {
    java.util.LinkedList<TreeNode> curLevel = new LinkedList<>();
    java.util.LinkedList<TreeNode> nextLevel = new LinkedList<>();
    curLevel.add(root);
    Integer curMax = Integer.MIN_VALUE;
    java.util.List<Integer> results = new ArrayList<>();
    while(!curLevel.isEmpty()) {
      TreeNode curNode = curLevel.pop();
      if (curNode.val > curMax) {
        curMax = curNode.val;
      }
      if (curNode.left != null) {
        nextLevel.add(curNode.left);
      }
      if (curNode.right != null) {
        nextLevel.add(curNode.right);
      }
      if (curLevel.isEmpty()) {
        curLevel = nextLevel;
        nextLevel = new LinkedList<>();
        results.add(curMax);
        curMax = Integer.MIN_VALUE;
      }
    }
    return results;
  }

  public static void main(String[] args) {
    Problem515 instance = new Problem515();
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(3);
    TreeNode node3 = new TreeNode(2);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(2);
    TreeNode node6 = new TreeNode(9);
    node1.left = node2;
    node1.right = node3;
    node2.left = node4;
    node2.right = node5;
    node3.right = node6;
    instance.largestValues(node1);
  }
}
