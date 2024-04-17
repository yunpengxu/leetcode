package completed;

import java.util.HashMap;


public class Problem1315 {

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

  public int sumEvenGrandparent(TreeNode root) {
    java.util.Map<TreeNode, TreeNode> grandparentMap = new HashMap<>();
    preOrder(root, null, grandparentMap);
    int total =0;
    for(TreeNode node: grandparentMap.keySet()) {
      if(grandparentMap.get(node)!= null && grandparentMap.get(node).val %2==0) {
        total+= node.val;
      }
    }
    return total;
  }

  private void preOrder(TreeNode node, TreeNode parent, java.util.Map<TreeNode, TreeNode> grandparentMap) {
    if(node.left != null) {
      grandparentMap.put(node.left, parent);
    }
    if(node.right != null) {
      grandparentMap.put(node.right, parent);
    }

    if(node.left != null) {
      preOrder(node.left, node, grandparentMap);
    }
    if(node.right != null) {
      preOrder(node.right, node, grandparentMap);
    }
  }

  public static void main(String[] args) {
    Problem1315 instance = new Problem1315();
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node12 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node72 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);
    node6.left = node7; node6.right = node8;
    node7.left = node2; node7.right = node72;
    node8.left = node1; node8.right = node3;
    node2.left = node9;
    node72.left = node12; node72.right = node4;
    node3.right = node5;

    instance.sumEvenGrandparent(node6);
  }
}
