import java.util.*;


/**
 * 
 * @author yunpeng
 * 
 */
public class BinaryTreePostorderTraversal {
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

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> outputs = new ArrayList<Integer>();
		LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
		TreeNode curNode = root, lastVisitedNode = null;
		while (!stack.isEmpty() || curNode != null) {
			if (curNode != null) {
				stack.addLast(curNode);
				curNode = curNode.left;
			} else {
				curNode = stack.peekLast();
				if (curNode.right != null && lastVisitedNode != curNode.right) {
					curNode = curNode.right;
				} else {
					outputs.add(curNode.val);
					lastVisitedNode = stack.pollLast();
					curNode = null;
				}

			}
		}

		return outputs;
	}
}
