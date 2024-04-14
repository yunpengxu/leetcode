package completed;

public class Problem1650 {

  class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
  }

  public Node lowestCommonAncestor(Node p, Node q) {
    int pDepth = getDepth(p);
    int qDepth = getDepth(q);
    while(pDepth > qDepth) {
      p = p.parent;
      pDepth--;
    }
    while(qDepth>pDepth){
      q = q.parent;
      qDepth--;
    }
    while(q != p){
      q=q.parent;
      p=p.parent;
    }

    return p;
  }

  int getDepth(Node n) {
    int depth = 0;
    while(n != null) {
      n = n.parent;
      depth++;
    }
    return depth;
  }

}
