package StackQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListNodeStackTest {
  private ListNodeStack head;
  private static final int[] PUSH_DATA = {3, 1, 4, 1, 5};

  @BeforeEach
  void setUp() {
    head = new ListNodeStack();
    head.push(head, 3);
    head.push(head, 1);
    head.push(head, 4);
    head.push(head, 1);
    head.push(head, 5);
  }

  @Test
  void pushTest() {
    ListNodeStack currentNode = head;
    for (int i : PUSH_DATA) {
      currentNode = currentNode.next;
      assertThat(currentNode.getValue()).isEqualTo(i);
    }
  }

  @Test
  void popTest() {
    assertThat(head.pop(head)).isEqualTo(5);
    assertThat(head.pop(head)).isEqualTo(1);
    assertThat(head.pop(head)).isEqualTo(4);
    assertThat(head.pop(head)).isEqualTo(1);
    assertThat(head.pop(head)).isEqualTo(3);
  }
}
