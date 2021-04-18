package StackQueue;

import lombok.Getter;

interface ListNodeQueueInterface {
  void enqueue(ListNodeQueue head, int value);

  ListNodeQueue dequeue(ListNodeQueue head);
}

@Getter
public class ListNodeQueue implements ListNodeQueueInterface {
  int value;
  ListNodeQueue next;

  public ListNodeQueue() {
    this(0);
  }

  public ListNodeQueue(int value) {
    this.value = value;
    this.next = null;
  }

  @Override
  public void enqueue(ListNodeQueue head, int value) {
    ListNodeQueue newNode = new ListNodeQueue(value);
    ListNodeQueue currentNode = head;
    while (currentNode.next != null) {
      currentNode = currentNode.next;
    }
    currentNode.next = newNode;
  }

  @Override
  public ListNodeQueue dequeue(ListNodeQueue head) {
    ListNodeQueue removeToNode = head.next;
    head.next = head.next.next;
    return removeToNode;
  }
}
