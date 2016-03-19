import java.util.*;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author yunpeng
 * 
 */
public class AddTwoNumbers {

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

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}

		ListNode head = null, prevNode = null;
		int lowBit = 0;
		ListNode c1 = l1, c2 = l2;
		while (c1 != null && c2 != null) {
			ListNode curNode = null;
			int val = c1.val + c2.val + lowBit;
			if (val < 10) {
				curNode = new ListNode(val);
				lowBit = 0;
			} else {
				curNode = new ListNode(val - 10);
				lowBit = 1;
			}

			if (head == null) {
				head = curNode;
			} else {
				prevNode.next = curNode;
			}
			prevNode = curNode;
			c1 = c1.next;
			c2 = c2.next;
		}

		ListNode rest = (c1 != null) ? c1 : c2;
		if (rest != null) {
			for (ListNode curNode = rest; curNode != null; curNode = curNode.next) {
				int val = curNode.val + lowBit;
				ListNode node = null;
				if (val < 10) {
					node = new ListNode(val);
					lowBit = 0;
				} else {
					node = new ListNode(val - 10);
					lowBit = 1;
				}

				prevNode.next = node;
				prevNode = node;
			}
		}

		if (lowBit == 1) {
			prevNode.next = new ListNode(1);
		}

		return head;
	}
}
