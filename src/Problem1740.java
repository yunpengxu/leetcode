package completed;

import java.util.ArrayList;
import java.util.HashMap;


public class Problem1740 {

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

  public int findDistance(TreeNode root, int p, int q) {
     java.util.Map<TreeNode, TreeNode> parentMap = new HashMap<>();
     preOrder(root, null, parentMap);
     java.util.List<TreeNode> pathP = new ArrayList<>(), pathQ = new ArrayList<>();
     TreeNode pNode = null, qNode= null;
     for(TreeNode node: parentMap.keySet()) {
       if(node.val == p) {
         pNode = node;
       }
       if(node.val == q) {
         qNode = node;
       }
     }
     TreeNode curNodeP = pNode;
     while(curNodeP != null) {
       pathP.add(curNodeP);
       curNodeP = parentMap.get(curNodeP);
     }
    TreeNode curNodeQ = qNode;
    while(curNodeQ != null) {
      pathQ.add(curNodeQ);
      curNodeQ = parentMap.get(curNodeQ);
    }
    int len = Math.abs(pathP.size() - pathQ.size());

    curNodeP = pNode;
    curNodeQ = qNode;
    for(int i=0; i< len; i++) {
      if(pathP.size() > pathQ.size()) {
        curNodeP = parentMap.get(curNodeP);
      }
      if(pathP.size() < pathQ.size()) {
        curNodeQ = parentMap.get(curNodeQ);
      }
    }

    while(curNodeP != curNodeQ) {
      curNodeP = parentMap.get(curNodeP);
      curNodeQ = parentMap.get(curNodeQ);
      len+=2;
    }

    return len;
  }

  private void preOrder(TreeNode node, TreeNode parent, java.util.Map<TreeNode, TreeNode> parentMap) {
    parentMap.put(node, parent);
     if (node.left != null) {
       preOrder(node.left, node, parentMap);
     }
     if (node.right != null) {
       preOrder(node.right, node, parentMap);
     }
  }

  public static void main(String[] args) {
     Problem1740 instance = new Problem1740();
     TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);

    node3.left = node5; node3.right = node1;
    node5.left = node6; node5.right = node2;
    node1.left = node0; node1.right = node8;
    node2.left = node7; node2.right = node4;

    instance.findDistance(node3, 5, 0);
    instance.findDistance(node3, 5, 7);
    instance.findDistance(node3, 5, 5);
  }
}
