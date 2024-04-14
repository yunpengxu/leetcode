package completed;

import java.util.LinkedList;


public class Problem1161 {
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

  public int maxLevelSum(TreeNode root) {
    java.util.LinkedList<TreeNode> curLevel = new LinkedList<>();
    java.util.LinkedList<TreeNode> nextLevel = new LinkedList<>();
    curLevel.add(root);
    Integer maxSum = Integer.MIN_VALUE;
    int curSum = 0;
    int curLevelNum = 1;
    int maxLevelNum = -1;
    while(!curLevel.isEmpty()) {
      TreeNode curNode = curLevel.pop();
      curSum += curNode.val;
      if(curNode.left!= null) {
        nextLevel.add(curNode.left);
      }
      if(curNode.right!= null) {
        nextLevel.add(curNode.right);
      }
      if(curLevel.isEmpty()) {
        if(curSum> maxSum) {
          maxSum = curSum;
          maxLevelNum = curLevelNum;
        }
        curSum = 0;
        curLevelNum++;
        curLevel = nextLevel;
        nextLevel = new LinkedList<>();
      }
    }
    return maxLevelNum;
  }

  public static void main(String[] args) {
    Problem1161 instance = new Problem1161();
    TreeNode n1 = new TreeNode(1);
    TreeNode n2 = new TreeNode(7);
    TreeNode n3 = new TreeNode(0);
    TreeNode n4 = new TreeNode(7);
    TreeNode n5 = new TreeNode(-8);
    n1.left = n2;
    n1.right = n3;
    n2.left = n4;
    n2.right = n5;
//    TreeNode n1 = new TreeNode(989);
//    TreeNode n2 = new TreeNode(10250);
//    TreeNode n3 = new TreeNode(98693);
//    TreeNode n4 = new TreeNode(-89388);
//    TreeNode n5 = new TreeNode(-32127);
//    n1.right = n2;
//    n2.left = n3;
//    n2.right = n4;
//    n4.right = n5;
    instance.maxLevelSum(n1);
  }
}
