import java.util.*;

/**
 * https://leetcode.com/submissions/detail/20449668/
 *
 * @author yunpeng
 *
 */
public class P0107BinaryTreeLevelOrderTraversalII {
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

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> output = new LinkedList<List<Integer>>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		if (root != null) {
			stack.push(root);

			while (stack.size() > 0) {
				int currentLayerCount = stack.size();
				List<Integer> currentLayer = new ArrayList<Integer>(
						currentLayerCount);
				for (int i = 0; i < currentLayerCount; i++) {
					currentLayer.add(i, 0);
				}
				for (int i = 0; i < currentLayerCount; i++) {
					TreeNode curNode = stack.pop();
					currentLayer.set(i, curNode.val);
					if (curNode.left != null) {
						stack.addLast(curNode.left);
					}
					if (curNode.right != null) {
						stack.addLast(curNode.right);
					}
				}
				output.addFirst(currentLayer);
			}
		}

		return output;
	}
}
