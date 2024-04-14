package completed;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Memory exceed.
 */
public class Problem1644 {

   public static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
     java.util.Map<TreeNode, TreeNode> parentMap = new HashMap<>();
     preorder2(root, null, parentMap);

     if (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
       if (p != root && !parentMap.containsKey(p) || q != root && !parentMap.containsKey(q)) {
         return null;
       }
       return root;
     }

     int stepP = 0;
     TreeNode curNodeP = p;
     while(curNodeP!= root) {
       stepP++;
       curNodeP = parentMap.get(curNodeP);
     }

    int stepQ = 0;
    TreeNode curNodeQ = q;
    while(curNodeQ!= root) {
      stepQ++;
      curNodeQ = parentMap.get(curNodeQ);
    }

    curNodeP = p;
    for (int i=0; i< stepP-stepQ; i++) {
      curNodeP = parentMap.get(curNodeP);
    }
    curNodeQ = q;
    for (int i=0; i< stepQ-stepP; i++) {
      curNodeQ = parentMap.get(curNodeQ);
    }

    while(curNodeP != curNodeQ) {
      curNodeP = parentMap.get(curNodeP);
      curNodeQ = parentMap.get(curNodeQ);
    }
    return curNodeP;

//    java.util.Map<TreeNode, java.util.List<TreeNode>> paths  = new HashMap<TreeNode, java.util.List<TreeNode>>();
//     preorder(root, null, paths);
//     if (!paths.containsKey(p) || !paths.containsKey(q)) {
//       return null;
//     }
//     java.util.List<TreeNode> pathP = paths.get(p);
//     java.util.List<TreeNode> pathQ = paths.get(q);
//     TreeNode result = root;
//     for(int i = 0; i< pathP.size() && i< pathQ.size(); i++) {
//       if(pathP.get(i) != pathQ.get(i)) {
//         break;
//       } else {
//         result = pathP.get(i);
//       }
//     }
//     return result;
  }

  void preorder2(TreeNode node, TreeNode parent, java.util.Map<TreeNode, TreeNode> parentMap) {
     if(parent != null) {
       parentMap.put(node, parent);
     }

    if (node.left != null) {
      preorder2(node.left, node, parentMap);
    }
    if (node.right != null) {
      preorder2(node.right, node, parentMap);
    }
  }

  void preorder(TreeNode node, TreeNode parent, java.util.Map<TreeNode, java.util.List<TreeNode>> paths) {
     java.util.List<TreeNode> parentPath = parent == null? new ArrayList<>(): paths.get(parent);
     java.util.List<TreeNode> curPath = new ArrayList<>();
     curPath.addAll(parentPath);
     curPath.add(node);
     paths.put(node, curPath);
     if (node.left != null) {
       preorder(node.left, node, paths);
     }
    if (node.right != null) {
      preorder(node.right, node, paths);
    }
  }

  public static void main(String[] args) {
     Problem1644 instance = new Problem1644();
     TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    node3.left =  node5; node3.right = node1;
    node5.left =  node6; node5.right = node2;
    node2.left =  node7; node2.right = node4;
    node1.left =  node0; node1.right = node8;

      instance.lowestCommonAncestor(node3, node6, node8);


  }

}
