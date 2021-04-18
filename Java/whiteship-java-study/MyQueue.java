package StackQueue;

import lombok.Getter;

@Getter
public class MyQueue {
  int[] data;
  int index;

  public MyQueue() {
    this(5);
  }

  public MyQueue(int length) {
    this.data = new int[length];
  }

  public void enqueue(int value) {
    this.data[index++] = value;
  }

  public int dequeue() {
    int firstValue = this.data[0];
    for (int i = 0; i < this.data.length - 1; i++) {
      this.data[i] = this.data[i + 1];
    }

    return firstValue;
  }
}
