package completed;

import java.util.*;
public class Problem1171 {

  public static class ListNode {

      int val;

      ListNode next;

      ListNode() {}

      ListNode(int val) { this.val = val; }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

  }
  public ListNode removeZeroSumSublists(ListNode head) {
    // pay attention that the head node may change, therefore introduce a new node front.
    ListNode front = new ListNode(0, head);
    Map<Integer, ListNode> accMap = new HashMap<>();
    int acc = 0;
    for(ListNode node = front; node != null; node = node.next) {
      acc+= node.val;
      accMap.put(acc, node);
    }

    acc = 0;
    ListNode curNode = front;
    while(curNode != null) {
      acc+= curNode.val;
      if(accMap.containsKey(acc)) {
        ListNode nextNode = accMap.get(acc);
        if(nextNode != curNode) {
          curNode.next = nextNode.next;
        }
      }
      curNode = curNode.next;
    }

    return front.next;
  }

  public static void main(String[] args) {
    Problem1171 instance = new Problem1171();
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(-3);
    ListNode node4 = new ListNode(3);
    ListNode node5 = new ListNode(1);
    node1.next = node2; node2.next = node3; node3.next = node4; node4.next = node5;
    instance.removeZeroSumSublists(node1);
  }
}
