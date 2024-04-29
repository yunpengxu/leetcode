package completed;

import java.util.*;
public class Problem1522 {

  static class Node {
    public int val;
    public List<Node> children;


    public Node() {
      children = new ArrayList<Node>();
    }

    public Node(int _val) {
      val = _val;
      children = new ArrayList<Node>();
    }

    public Node(int _val,ArrayList<Node> _children) {
      val = _val;
      children = _children;
    }
  };

  int maxLen = 0;
  public int diameter(Node root) {
    maxLen = 0;
    postOrder(root);
    return maxLen;
  }

  int postOrder(Node root) {
    if(root == null) {
      return 0;
    }
    if (root.children.size() ==0) {
      return 1;
    }
    if(root.children.size() ==1){
      int childDepth = postOrder(root.children.get(0));
      if(maxLen < childDepth) {
        maxLen = childDepth;
      }
      return childDepth+1;
    }

    List<Integer> depths = new ArrayList<>();
    for(Node child: root.children) {
      int d = postOrder(child);
      depths.add(d);
    }
    Collections.sort(depths, new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o2-o1;
      }
    });

    int first = depths.get(0), second = depths.get(1);
    if (first+ second> maxLen) {
      maxLen = first+ second;
    }
    return first+1;
  }

  public static void main(String[] args) {
    Problem1522 instance = new Problem1522();

//    Node node1 = new Node(1);
//    Node node2 = new Node(2);
//    Node node3 = new Node(3);
//    Node node4 = new Node(4);
//    Node node5 = new Node(5);
//    Node node6 = new Node(6);
//    node1.children.add(node2);
//    node1.children.add(node3);
//    node1.children.add(node4);
//    node3.children.add(node5);
//    node3.children.add(node6);

    Node node1 = new Node(1);
    Node node2 = new Node(2);
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node5 = new Node(5);
    Node node6 = new Node(6);
    node1.children.add(node2);
    node2.children.add(node3);
    node2.children.add(node4);
    node3.children.add(node5);
    node4.children.add(node6);

    instance.diameter(node1);
  }
}
