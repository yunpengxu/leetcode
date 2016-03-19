import java.util.*;

/**
 * 
 * @author yunpeng
 * 
 */
public class PopulatingNextRightPointersinEachNodeII {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}

		public String toString() {
			StringBuffer sb = new StringBuffer();
			sb.append(val).append('{').append(left == null ? "null" : left.val)
					.append(",").append(right == null ? "null" : right.val)
					.append(",").append(next == null ? "null" : next.val)
					.append('}');
			return sb.toString();
		}
	}

	public void connect(TreeLinkNode root) {
		if (root != null) {
			List<TreeLinkNode> currentLevel = new ArrayList<TreeLinkNode>();
			currentLevel.add(root);
			List<TreeLinkNode> nextLevel = null;
			while (currentLevel.size() != 0) {
				nextLevel = new ArrayList<TreeLinkNode>();
				TreeLinkNode prevNode = null;
				for (TreeLinkNode curNode : currentLevel) {
					if (curNode != null) {
						nextLevel.add(curNode.left);
						nextLevel.add(curNode.right);
						if (prevNode != null) {
							prevNode.next = curNode;
						}
						prevNode = curNode;
					}
				}
				currentLevel = nextLevel;
			}
		}
	}
}
