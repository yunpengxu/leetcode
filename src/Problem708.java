package completed;

public class Problem708 {
  static class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
      val = _val;
    }

    public Node(int _val, Node _next) {
      val = _val;
      next = _next;
    }
  };


  // 3 different cases;
  public Node insert(Node head, int insertVal) {
    if(head== null) {
      head = new Node(insertVal);
      head.next = head;
    } else if (head.next == head) {
      Node next = new Node(insertVal);
      next.next = head;
      head.next= next;
    } else {
      Node current =head, next = head.next;
      Boolean insert = false;
      while(next != head) {
        if(next.val >= insertVal && current.val <= insertVal) {
          Node newNode = new Node(insertVal);
          newNode.next = next;
          current.next = newNode;
          insert = true;
          break;
        } else if (next.val< current.val &&(insertVal >= current.val || insertVal <= next.val)){
          Node newNode = new Node(insertVal);
          newNode.next = next;
          current.next = newNode;
          insert = true;
          break;
        }
        else {
          current = next;
          next = next.next;
        }
      }
      if (!insert) {
        Node newNode = new Node(insertVal);
        newNode.next = next;
        current.next = newNode;
      }
    }

    return head;
  }

  public static void main(String[] args) {
    Problem708 instance = new Problem708();
    Node node3 = new Node(3);
    Node node4 = new Node(4);
    Node node1 = new Node(1);
    node3.next = node4; node4.next = node1; node1.next = node3;

    instance.insert(node3, 2);
    System.out.println();
  }

}
