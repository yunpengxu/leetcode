package completed;


public class Problem2265 {

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

  /**
   * A helper class that summarize the node
   */
  class NodeSummary {
    Integer totalSum ;
    Integer totalCount;
    Integer goodCount ;
    NodeSummary(int tS, int tC, int gC) {
      totalSum = tS;
      totalCount = tC;
      goodCount = gC;
    }
  }


  private NodeSummary getSubtreeSummary(TreeNode node) {
    if(node == null) {
      return new NodeSummary(0,0,0);
    }
    if(node.left == null & node.right == null) {
      return new NodeSummary(node.val, 1, 1);
    }
    NodeSummary leftSummary = getSubtreeSummary(node.left);
    NodeSummary rightSummary = getSubtreeSummary(node.right);

    int curTotalSum = node.val +  leftSummary.totalSum +  rightSummary.totalSum;
    int curTotalCount = 1 +  leftSummary.totalCount + rightSummary.totalCount;
    int curAvg = curTotalSum /  curTotalCount;
    int curGoodCount = leftSummary.goodCount + rightSummary.goodCount;
    if (curAvg == node.val) {
      curGoodCount ++;
    }
    return new NodeSummary(curTotalSum, curTotalCount, curGoodCount);
  }

  public int averageOfSubtree(TreeNode root) {
    NodeSummary summary = getSubtreeSummary(root);
    return summary.goodCount;
  }

}
