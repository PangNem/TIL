class ListNode {
  private int value;
  private ListNode next;

  public ListNode() {}

  public ListNode(int value) {
    this.value = value;
    this.next = null;
  }

  public static ListNode add(ListNode head, ListNode nodeToAdd, int position) {
    if (position <= 0) {
      throw new IllegalArgumentException("position should be positive.");
    }

    if (head.next == null) {
      head.next = nodeToAdd;
      nodeToAdd.next = null;
      return nodeToAdd;
    }

    ListNode currentListNode = head;
    for (int i = 0; i < position - 1; i++) {
      currentListNode = currentListNode.next;
    }

    nodeToAdd.next = currentListNode.next;
    currentListNode.next = nodeToAdd;

    return currentListNode;
  }

  public static void getAll(ListNode head) {
    ListNode currentListNode = head;
    int position = 0;
    while (currentListNode != null) {
      System.out.println("value: " + currentListNode.value + ", position: " + position);
      currentListNode = currentListNode.next;
      position++;
    }
    System.out.println();
  }

  public static ListNode remove(ListNode head, int positionToRemove) {
    if (positionToRemove <= 0) {
      throw new IllegalArgumentException("position should be positive.");
    }

    ListNode currentListNode = head;
    for (int i = 0; i < positionToRemove - 1; i++) {
      currentListNode = currentListNode.next;
    }

    if (currentListNode.next == null) {
      throw new IndexOutOfBoundsException("empty linkedlist");
    }
    currentListNode.next = currentListNode.next.next;
    return currentListNode;
  }

  public static boolean contains(ListNode head, ListNode nodeToCheck) {
     ListNode currentListNode = head;
     while(currentListNode.next != nodeToCheck) {
       if (currentListNode.next == null) {
         return false;
       }
       currentListNode = currentListNode.next;
     }
     return true;
  }
}

public class LinkedList {
  public static void main(String[] args) {
    ListNode head = new ListNode();
    ListNode first = new ListNode(100);
    ListNode last = new ListNode(100);

    ListNode.add(head, first, 1);
    ListNode.add(head, new ListNode(1), 1);
    ListNode.add(head, new ListNode(2), 1);
    ListNode.add(head, new ListNode(3), 1);
    ListNode.add(head, new ListNode(4), 1);
    ListNode.add(head, new ListNode(5), 1);
    ListNode.add(head, last, 1);

    ListNode.getAll(head);
    ListNode.remove(head, 1);
    ListNode.remove(head, 1);
    ListNode.remove(head, 1);
    ListNode.getAll(head);

    System.out.println(ListNode.contains(head, first));
    System.out.println(ListNode.contains(head, last));
  }
}
