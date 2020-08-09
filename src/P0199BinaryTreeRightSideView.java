import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-right-side-view/
 *
 * @author yunpeng
 *
 */
public class P0199BinaryTreeRightSideView {
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

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> results = new ArrayList<Integer>();
		if (root != null) {
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			queue.add(root);
			int curLevel = 1, nextLevel = 0;
			while (!queue.isEmpty()) {
				TreeNode curNode = queue.pollFirst();
				curLevel--;
				if (curNode.left != null) {
					queue.addLast(curNode.left);
					nextLevel++;
				}
				if (curNode.right != null) {
					queue.addLast(curNode.right);
					nextLevel++;
				}
				if (curLevel == 0) {
					results.add(curNode.val);
					curLevel = nextLevel;
					nextLevel = 0;
				}
			}
		}
		return results;
	}

}
