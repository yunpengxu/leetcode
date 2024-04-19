package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;


public class Problem314 {
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
  public List<List<Integer>> verticalOrder(TreeNode root) {
    List<List<Integer>> results = new ArrayList<>();
    if(root == null) {
      return results;
    }

    java.util.Map<TreeNode, Integer> posMap = new HashMap<>();
    preOrder(root, 0, posMap);
    java.util.TreeMap<Integer, List<Integer>> pos2nodesMap = new TreeMap<>();

    LinkedList<TreeNode> queue = new LinkedList<>(), nextQueue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()) {
      TreeNode curNode = queue.pop();
      int pos = posMap.get(curNode);
      List<Integer> node4pos = pos2nodesMap.getOrDefault(pos, new ArrayList<>());
      node4pos.add(curNode.val);
      pos2nodesMap.put(pos, node4pos);

      if(curNode.left!= null) {
        nextQueue.add(curNode.left);
      }
      if (curNode.right != null) {
        nextQueue.add(curNode.right);
      }
      if(queue.isEmpty()) {
        queue = nextQueue;
        nextQueue = new LinkedList<>();
      }
    }

    for(Integer pos: pos2nodesMap.keySet()) {
      results.add(pos2nodesMap.get(pos));
    }
    return results;
  }

  private void preOrder(TreeNode node, int pos, java.util.Map<TreeNode, Integer> posMap) {
    posMap.put(node, pos);
    if(node.left != null) {
      preOrder(node.left, pos -1, posMap);
    }
    if(node.right != null) {
      preOrder(node.right, pos +1, posMap);
    }
  }

  public static void main(String[] args){
    Problem314 instance = new Problem314();
    TreeNode node0 = new TreeNode(0);
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode node4 = new TreeNode(4);
    TreeNode node5 = new TreeNode(5);
    TreeNode node6 = new TreeNode(6);
    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(8);
    TreeNode node9 = new TreeNode(9);
    node3.left = node9; node3.right = node8;
    node9.left = node4; node9.right = node0;
    node8.left = node1; node8.right = node7;
    node1.left = node5;
    node0.right = node2;
    instance.verticalOrder(node3);
  }
}
