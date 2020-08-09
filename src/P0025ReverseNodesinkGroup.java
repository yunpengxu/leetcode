
/**
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 *
 * @author yunpeng
 *
 */
public class P0025ReverseNodesinkGroup {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}

		public String toString() {
			return String.valueOf(val);
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || k == 1) {
			return head;
		}

		ListNode curHeadNode = head, curLastNode = head, curNode = head;
		ListNode retHead = null;
		ListNode prevLastNode = null;
		while (curNode != null) {
			boolean flip = true;
			for (int count = 0; count < k && curNode != null; count++) {
				if (count == 0) {
					curHeadNode = curNode;
				}
				if (count == k - 1 || curNode.next == null) {
					curLastNode = curNode;
					if (count < k - 1) {
						flip = false;
					}
				}
				curNode = curNode.next;
			}
			if (retHead == null) {
				if (flip) {
					retHead = curLastNode;
				} else {
					retHead = curHeadNode;
				}
			}
			if (flip) {
				reverseList(curHeadNode, curLastNode);
				if (prevLastNode != null) {
					prevLastNode.next = curLastNode;
				}
				prevLastNode = curHeadNode;
			} else {
				if (prevLastNode != null) {
					prevLastNode.next = curHeadNode;
				}
			}

		}
		return retHead;
	}

	public void reverseList(ListNode headNode, ListNode lastNode) {
		if (headNode == lastNode) {
			return;
		}

		ListNode prevNode = null, curNode = headNode;
		ListNode stopNode = lastNode.next;
		while (curNode != stopNode) {
			ListNode nextNode = curNode.next;
			curNode.next = prevNode;
			prevNode = curNode;
			curNode = nextNode;
		}
	}
}
