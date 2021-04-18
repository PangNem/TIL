package StackQueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MyQueueTest {
  private static final int[] ENQUEUE_DATA = {3, 1, 4, 1, 5};
  private MyQueue queue;

  @BeforeAll
  void setUp() {
    queue = new MyQueue();
    queue.enqueue(3);
    queue.enqueue(1);
    queue.enqueue(4);
    queue.enqueue(1);
    queue.enqueue(5);
  }

  @Test
  void enqueueTest() {
    assertThat(queue.getData()).isEqualTo(ENQUEUE_DATA);
  }

  @Test
  void dequeueTest() {
    assertThat(queue.dequeue()).isEqualTo(3);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(4);
    assertThat(queue.dequeue()).isEqualTo(1);
    assertThat(queue.dequeue()).isEqualTo(5);
  }
}
