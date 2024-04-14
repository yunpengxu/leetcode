package completed;

import java.util.ArrayList;
import java.util.LinkedList;


public class Problem637 {
  public class TreeNode {
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

  public java.util.List<Double> averageOfLevels(TreeNode root) {
    java.util.List<Double> results = new ArrayList<>();
    java.util.Queue<TreeNode> curLevel = new LinkedList<>(), nextLevel = new LinkedList<>();
    curLevel.add(root);
    while(true) {
      Double curTotal = 0.0, curCount = 0.0;
      while(!curLevel.isEmpty()) {
        TreeNode node = curLevel.poll();
        curTotal += node.val;
        curCount +=1.0;
        if(node.left!= null) {
          nextLevel.offer(node.left);
        }
        if(node.right!= null) {
          nextLevel.offer(node.right);
        }
      }
      results.add(curTotal/curCount);
      if(nextLevel.size() ==0) {
        break;
      }
      curLevel = nextLevel;
      nextLevel = new LinkedList<>();
    }

    return results;
  }

}
