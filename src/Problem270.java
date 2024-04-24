package completed;

public class Problem270 {

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

  public int closestValue(TreeNode root, double target) {
    TreeNode curNode = root;
    Double minDiff = Double.MAX_VALUE;
    Integer minVal = root.val;
    while(curNode != null) {
      double curDiff = Math.abs(curNode.val - target);
      if (curDiff == 0.0) {
        return curNode.val;
      }

      if(curDiff < minDiff) {
        minDiff = curDiff;
        minVal = curNode.val;
      }
      if(curDiff == minDiff &&curNode.val < minVal) {
          minVal = curNode.val;
      }
      if(target< curNode.val) {
        curNode = curNode.left;
      } else {
        curNode = curNode.right;
      }
    }
    return minVal;
  }

  public static void main(String[] args) {
   Problem270 instance = new Problem270();
   TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    node4.left = node2; node4.right = node5;
    node2.left = node1; node2.right = node3;

   instance.closestValue(node4, 3.714286);
  }
}
