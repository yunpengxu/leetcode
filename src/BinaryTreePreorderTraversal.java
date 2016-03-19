import java.util.*;


/**
 * https://leetcode.com/submissions/detail/2537509/
 * @author yunpeng
 *
 */
public class BinaryTreePreorderTraversal {
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

	public ArrayList<Integer> preorderTraversal(TreeNode root) {
	      if(root == null) 
	        {
	        	return new ArrayList<Integer>();
	        }
	        ArrayList<Integer> retVal = new ArrayList<Integer>();
	        retVal.add(root.val);
	        retVal.addAll(preorderTraversal(root.left));
	        retVal.addAll(preorderTraversal(root.right));
	        return retVal;  
	    }
}
