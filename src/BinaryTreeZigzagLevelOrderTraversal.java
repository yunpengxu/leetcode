import java.util.*;

/**
 * 
 * @author yunpeng
 * 
 */
public class BinaryTreeZigzagLevelOrderTraversal {
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

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (root != null) {
			boolean isZig = false;
			LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
			LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
			queue.push(root);
			while (!queue.isEmpty() || !stack.isEmpty()) {
				List<Integer> curResults = new ArrayList<Integer>();
				if (!isZig) {
					while (!queue.isEmpty()) {
						TreeNode curNode = queue.pollFirst();
						curResults.add(curNode.val);
						if (curNode.left != null) {
							stack.addLast(curNode.left);
						}
						if (curNode.right != null) {
							stack.addLast(curNode.right);
						}
					}
				} else {
					while (!stack.isEmpty()) {
						TreeNode curNode = stack.pollLast();
						curResults.add(curNode.val);
						if (curNode.right != null) {
							queue.addFirst(curNode.right);
						}
						if (curNode.left != null) {
							queue.addFirst(curNode.left);
						}
					}
				}
				results.add(curResults);
				isZig = !isZig;
			}
		}

		return results;
	}
}
