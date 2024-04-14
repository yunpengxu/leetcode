package completed;

import java.util.ArrayList;


public class Problem897 {

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

  public TreeNode increasingBST(TreeNode root) {
    java.util.List<TreeNode> visited = new ArrayList<>();
    inorder(root, visited);
    if(visited.size()>0) {
      TreeNode last = visited.get(visited.size()-1);
      last.left = null;
      last.right = null;
      for(int i = visited.size() - 2; i >=0; i--) {
        TreeNode curnode = visited.get(i);
        curnode.left = null;
        curnode.right = visited.get(i+1);
      }
      return visited.get(0);
    }
    return null;
  }

  private void inorder(TreeNode node, java.util.List<TreeNode> visited) {
    if (node != null) {
      inorder(node.left, visited);
      visited.add(node);
      inorder(node.right, visited);
    }
  }
}
