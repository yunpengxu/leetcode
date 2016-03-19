import java.util.*;

/**
 * https://leetcode.com/submissions/detail/7912266/
 * @author yunpeng
 *
 */
public class BinaryTreeLevelOrderTraversal {
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

	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root != null) {
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.addFirst(root);
			queue.add(null);
			List<Integer> curRow = new ArrayList<Integer>();
			while (!queue.isEmpty()) {
				TreeNode curNode = queue.pollFirst();
				if (curNode == null) {
					results.add(curRow);
					if (!queue.isEmpty()) {
						queue.add(null);
						curRow = new ArrayList<Integer>();
					}
				} else {
					curRow.add(curNode.val);
					if (curNode.left != null) {
						queue.addLast(curNode.left);
					}
					if (curNode.right != null) {
						queue.addLast(curNode.right);
					}
				}
			}
		}

		return results;
    }
}
