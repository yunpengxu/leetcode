
/**
 * 
 * @author yunpeng
 * 
 */
public class BalancedBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			StringBuffer sb = new StringBuffer();
			if (this == null) {
				sb.append("null");
			} else {
				sb.append(val);
				sb.append("[");
				sb.append(left == null ? "null" : left.val);
				sb.append(",");
				sb.append(right == null ? "null" : right.val);
				sb.append("];");
			}
			return sb.toString();
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		int depth = getBalancedDepth(root);
		return (depth < 0) ? false : true;
	}

	private int getBalancedDepth(TreeNode root) {
		if (root.left == null && root.right == null) {
			return 1;
		}

		if (root.left != null && root.right == null) {
			if (root.left.left != null || root.left.right != null) {
				return -1;
			} else {
				return 2;
			}
		} else if (root.right != null && root.left == null) {
			if (root.right.left != null || root.right.right != null) {
				return -1;
			} else {
				return 2;
			}
		}

		int leftDepth = getBalancedDepth(root.left);
		int rightDepth = getBalancedDepth(root.right);
		if (leftDepth < 0 || rightDepth < 0 || leftDepth > rightDepth + 1
				|| rightDepth > leftDepth + 1) {
			return -1;
		}

		return 1 + ((leftDepth > rightDepth) ? leftDepth : rightDepth);
	}
}
