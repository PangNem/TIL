package StackQueue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListNodeQueueTest {

  private ListNodeQueue head;
  private int[] ENQUEUE_DATA = {3, 1, 4, 1, 5};

  @BeforeAll
  void setUp() {
    head = new ListNodeQueue();
    for (int i : ENQUEUE_DATA) {
      head.enqueue(head, i);
    }
  }

  @Test
  void enqueueTest() {
    ListNodeQueue currentNode = head.next;
    for (int i : ENQUEUE_DATA) {
      assertThat(currentNode.getValue()).isEqualTo(i);
      currentNode = currentNode.next;
    }
  }

  @Test
  void dequeueTest() {
    for (int i : ENQUEUE_DATA) {
      assertThat(head.dequeue(head).getValue()).isEqualTo(i);
    }
  }
}
