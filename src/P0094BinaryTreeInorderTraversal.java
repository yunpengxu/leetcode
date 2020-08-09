import java.util.*;


/**
 * https://leetcode.com/submissions/detail/2537673/
 *
 * @author yunpeng
 *
 */
public class P0094BinaryTreeInorderTraversal {
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

	public ArrayList<Integer> inorderTraversal(TreeNode root) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> retVal = new ArrayList<Integer>();
		retVal.addAll(inorderTraversal(root.left));
		retVal.add(root.val);
		retVal.addAll(inorderTraversal(root.right));
		return retVal;
	}
}
