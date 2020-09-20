var Queue = (function () {
  function Queue() {
    this.count = 0;
    this.head = null;
    this.tail = null;
  }
  function Node(data) {
    this.data = data;
    this.next = null;
  }
  Queue.prototype.enqueue = function (data) {
    var node = new Node(data);
    if (!this.head) {
      this.head = node;
    } else {
      this.tail.next = node; // 원래 끝에 있는거 next를 새로 추가된거로 하고
    }

    this.tail = node; // 꼬리를 현재꺼로 바꾼다.
    return ++this.count;
  };
  Queue.prototype.dequeue = function () {
    // 1,3,5
    if (!this.head) return false;

    var data = this.head.data;
    this.head = this.head.next;

    this.count--;
    return data;
  };
  // Queue.prototype.front = function () {

  // };
  return Queue;
})();

var queue = new Queue();
console.log(queue.enqueue(1)); // 1
console.log(queue.enqueue(3)); // 2
console.log(queue.enqueue(5)); // 3
console.log(queue.dequeue()); // 1
// console.log(queue.front()); // 3
