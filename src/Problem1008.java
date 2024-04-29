package completed;

public class Problem1008 {
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public TreeNode bstFromPreorder(int[] preorder) {
    if (preorder.length == 0) {
      return null;
    }
    int rootVal = preorder[0];
    TreeNode rootNode = new TreeNode(rootVal);
    if (preorder.length > 1) {

      int splitIndex = 0;
      while (splitIndex+1 < preorder.length && preorder[splitIndex+1] < rootVal) {
        splitIndex++;
      }
      int leftSize = splitIndex, rightSize = preorder.length -1 - leftSize;
      if (leftSize > 0) {
        int[] leftArray = new int[leftSize];
        System.arraycopy(preorder, 1, leftArray, 0, leftSize);
        TreeNode leftNode = bstFromPreorder(leftArray);
        rootNode.left = leftNode;
      }
      if (rightSize > 0) {
        int[] rightArray = new int[rightSize];
        System.arraycopy(preorder, 1 +leftSize, rightArray, 0, rightSize);
        TreeNode rightNode = bstFromPreorder(rightArray);
        rootNode.right = rightNode;
      }
    }
    return rootNode;
  }

  public static void main(String[] args) {
    Problem1008 instance = new Problem1008();
//    TreeNode node = instance.bstFromPreorder(new int[]{1, 3});
    TreeNode node = instance.bstFromPreorder(new int[]{8,5,1,7,10,12});
    System.out.println();
  }
}
