package StackQueue;

import lombok.Getter;

interface ListNodeStackInterface {
  void push(ListNodeStack head, int value);

  int pop(ListNodeStack head);
}

@Getter
public class ListNodeStack implements ListNodeStackInterface {
  int value;
  ListNodeStack next;

  public ListNodeStack() {
    this(0);
  }

  public ListNodeStack(int value) {
    this.value = value;
    this.next = null;
  }

  @Override
  public void push(ListNodeStack head, int value) {
    ListNodeStack newNode = new ListNodeStack(value);
    ListNodeStack currentNode = head;
    while(currentNode.next != null) {
      currentNode = currentNode.next;
    }
    currentNode.next = newNode;
  }

  @Override
  public int pop(ListNodeStack head) {
    ListNodeStack currentNode = head;
    while(currentNode.next.next != null) {
      currentNode = currentNode.next;
    }
    int lastData = currentNode.next.getValue();
    currentNode.next = null;
    return lastData;
  }
}
