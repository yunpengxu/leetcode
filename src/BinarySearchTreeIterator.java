import java.util.*;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 * 
 * @author yunpeng
 * 
 */
public class BinarySearchTreeIterator {

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

	TreeNode root = null, next = null, curNode = null;

	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();

	public BinarySearchTreeIterator(TreeNode root) {
		if (root != null) {
			this.root = root;
			curNode = root;
			next = getNext();
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return next != null;
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode curNext = next;
		next = getNext();
		return curNext.val;
	}

	private TreeNode getNext() {
		if (stack.isEmpty() && curNode == null) {
			next = null;
		} else {
			while (!stack.isEmpty() || curNode != null) {
				if (curNode != null) {
					stack.add(curNode);
					curNode = curNode.left;
				} else {
					curNode = stack.pollLast();
					next = curNode;
					curNode = curNode.right;
					break;
				}
			}
		}
		return next;
	}
}
