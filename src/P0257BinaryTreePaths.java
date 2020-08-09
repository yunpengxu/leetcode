import java.util.*;


/**
 *
 * @author yunpeng
 *
 */
public class P0257BinaryTreePaths {
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

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> results = new ArrayList<String>();
		if (root == null) {
			return results;
		}
		if (root.left == null && root.right == null) {
			results.add(String.format("%d", root.val));
			return results;
		}

		results.addAll(binaryTreePathHelper(root));
		return results;
	}

	Set<String> binaryTreePathHelper(TreeNode root) {
		Set<String> results = new HashSet<String>();
		TreeNode lChild = root.left;
		TreeNode rChild = root.right;
		if (lChild == null && rChild == null) {
			results.add(String.format("%d", root.val));
			return results;
		}

		Set<String> paths = new HashSet<String>();
		if (lChild != null) {
			paths.addAll(binaryTreePathHelper(lChild));
		}
		if (rChild != null) {
			paths.addAll(binaryTreePathHelper(rChild));
		}

		for (String p : paths) {
			results.add(String.format("%d->%s", root.val, p));
		}

		return results;
	}
}
