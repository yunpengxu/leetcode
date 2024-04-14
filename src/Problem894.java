package completed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem894 {
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

  private Map<Integer, List<TreeNode>> treeMap = new HashMap<>();

  public java.util.List<TreeNode> allPossibleFBT(int n) {
    if(n %2==0) {
      return new ArrayList<>();
    }
    if (treeMap.containsKey(n)) {
      return treeMap.get(n);
    }

    List<TreeNode> results = new ArrayList<>();
    if(n ==1) {
      results.add(new TreeNode(0));
    } else {
      for(int i = 1; i <= (n-2); i+=2) {
        List<TreeNode> left = allPossibleFBT(i);
        List<TreeNode> right = allPossibleFBT(n-1-i);
        for(TreeNode ln: left) {
          for(TreeNode rn: right) {
            TreeNode root = new TreeNode(0);
            root.left = ln;
            root.right = rn;
            results.add(root);
          }
        }
      }
    }

    treeMap.put(n, results);
    return results;
  }

  public static void main(String[] args) {
    Problem894 instance = new Problem894();
    instance.allPossibleFBT(7);

  }
}
