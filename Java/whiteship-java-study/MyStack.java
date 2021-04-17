package Stack;

import lombok.Getter;

interface MyStackInterface {
  void push(int data);

  int pop();
}

@Getter
public class MyStack implements MyStackInterface {
  private int[] data;
  private int count;

  public MyStack(int length) {
    this.data = new int[length];
    this.count = 0;
  }

  @Override
  public void push(int data) {
    this.data[count++] = data;
  }

  @Override
  public int pop() {
    if (count == 0) {
      throw new ArrayIndexOutOfBoundsException("stack 비어있음");
    }
    return this.data[--count];
  }
}
