package completed;

public class Problem543 {
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

  int diameter = 0;

  // remember to return the diameter instead of depth;
  public int diameterOfBinaryTree(TreeNode root) {
    diameter = 0;
    postOrder(root);
    return diameter;
  }

  int postOrder(TreeNode node) {
    if(node == null) {
      return 0;
    }

    int leftDepth = postOrder(node.left);
    int rightDepth = postOrder(node.right);
    diameter = Math.max(diameter, leftDepth + rightDepth );
    return Math.max(leftDepth, rightDepth) + 1;
  }

  public static void main(String[] args) {
    Problem543 instance = new Problem543();
//    TreeNode node1 = new TreeNode(1);
//    TreeNode node2 = new TreeNode(2);
//    TreeNode node3 = new TreeNode(3);
//    TreeNode node4 = new TreeNode(4);
//    TreeNode node5 = new TreeNode(5);
//    node1.left = node2; node1.right = node3;
//    node2.left = node4; node2.right = node5;

    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    node1.left = node2;

    instance.diameterOfBinaryTree(node1);
    System.out.println();
  }

}
