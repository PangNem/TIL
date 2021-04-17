import Stack.MyStack;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MyStackTest {
  private static MyStack stack;
  private static final int[] PUSH_DATA = {3, 1, 4, 1, 5};

  @BeforeAll
  static void setUp() {
    stack = new MyStack(5);
  }

  @Test
  void addTest() {
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(1);
    stack.push(5);

    assertThat(stack.getData()).isEqualTo(PUSH_DATA);
  }

  @Test
  void popTest() {
    stack.push(3);
    stack.push(1);
    stack.push(4);
    stack.push(1);
    stack.push(5);

    assertThat(stack.pop()).isEqualTo(5);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(4);
    assertThat(stack.pop()).isEqualTo(1);
    assertThat(stack.pop()).isEqualTo(3);
  }
}
