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
    if (index == 0) {
      throw new ArrayIndexOutOfBoundsException("꺼낼 데이터 없음");
    }
    this.index--;
    for (int i = 0; i < index; i++) {
      this.data[i] = this.data[i + 1];
    }

    int lastValueIndex = this.data.length - 1;
    this.data[lastValueIndex] = 0;
    return firstValue;
  }
}
